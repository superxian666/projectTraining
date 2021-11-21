package com.firewolf.apitest_platform.controller.Service.httpclient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.firewolf.apitest_platform.domain.Case;
import com.firewolf.apitest_platform.mapper.GetServiceMapper;
import com.firewolf.apitest_platform.service.HttpClientUtils;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
public class PostServiceController {


    @Autowired
    private GetServiceMapper dao;
    /**
     *  执行post的接口测试方法
     *
     *  http://localhost:8080/doService/postService.do
     * */


    @ResponseBody
    @RequestMapping(value = "/doService/postService.do",method = RequestMethod.POST)
    public CommonResult doPost(
            @RequestParam(value = "url",required = true)String url,
            @RequestParam(value = "body",required = false)String body,
            @RequestParam(value = "header",required = false)Map<String,String> headers,
            @RequestParam(value = "cid",required = false)Integer cid,
            @RequestParam(value = "name",required = false)String name,
            @RequestParam(value = "method",required = false)String method,
            @RequestParam(value = "type",required = false)String type
            ) throws IOException {
        CommonResult cr = new CommonResult();
        String res =null;
        /**
         * 将string类型的body转为json类型
         * */
        JSONObject json = JSON.parseObject(body);


        if(url!=null&& body!=null){
            res = HttpClientUtils.doPost(url,json);
        }

        if(res!= null){
            cr.setCode(0);//代表成功
            cr.setMsg("获取接口返回值成功");
            cr.setData(res);
        }else {
            cr.setCode(1);
            cr.setMsg("获取接口返回值失败");
            cr.setData("");
        }

        /**
         * 不管是否查询成功还是失败都会插入到数据库，为客户保存数据
         * */
        Case cas = new Case(cid,  name,  url,  method,  type);
        Case intable = dao.selectCaseByUrl(cas);
        if(intable==null){
            /**
             *  这里需要重新实例化一个对象，不实例化会报错。
             * */
            Case cas2 = new Case(cid,  name,  url,  method,  type);
            dao.insertCase(cas2);
        }

        return cr;
    }
}
