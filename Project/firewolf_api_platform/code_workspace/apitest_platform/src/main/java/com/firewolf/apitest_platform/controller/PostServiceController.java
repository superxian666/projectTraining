package com.firewolf.apitest_platform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.firewolf.apitest_platform.service.HttpClientUtils;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
public class PostServiceController {
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
            @RequestParam(value = "header",required = false)Map<String,String> headers
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

        return cr;
    }
}
