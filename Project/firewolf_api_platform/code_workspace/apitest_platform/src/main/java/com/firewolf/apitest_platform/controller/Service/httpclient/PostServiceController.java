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
/**
 * creater ： 高昕
 * */
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
//            @RequestParam(value = "url",required = true)String url,
//            @RequestBody  JSONObject body,
//            @RequestParam(value = "header",required = false)Map<String,String> headers,
//            @RequestParam(value = "cid",required = false)Integer cid,
//            @RequestParam(value = "name",required = false)String name,
//            @RequestParam(value = "method",required = false)String method,
//            @RequestParam(value = "type",required = false)String type
                @RequestBody Case cas
            ) throws IOException {
        CommonResult cr = new CommonResult();
        String res =null;
        /**
         * 将string类型的body转为json类型
         * */



        if(cas.getUrl()!=null&& cas.getBody()!=null){
            JSONObject json = JSON.parseObject(cas.getBody());
            res = HttpClientUtils.doPost(cas.getUrl(),json);
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
         *
         * 这里后期要改成 通过查询id！！！
         * */

        Case intable = dao.selectCaseByUrl(cas);
        if(intable==null){
            /**
             *  这里需要重新实例化一个对象，不实例化会报错。
             * */
            Case cas2 = cas;
            dao.insertCase(cas2);
        }

        return cr;
    }
}
