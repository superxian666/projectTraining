package com.firewolf.apitest_platform.controller;

import com.firewolf.apitest_platform.service.HttpClientUtils;
import com.firewolf.apitest_platform.vo.CommonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 高昕 2021年11月14号
 * GetServiceController ：这个类用于实现get方式的接口测试
 * 1.接收前端发送的参数
 * 2.将这个数据插入数据库，并且有唯一的标识 id collection_id
 *
 * 这个有的业务由其他的控制器来搞，这里的开发遵循最小逻辑单元。
 * */


@RestController
public class GetServiceController {
    @Autowired
    private HttpClientUtils httpClientUtils;

    /**
     * post方式接收数据param为url,用户选择的请求方式 这里一定是get
     * 接收到的请求体 比如表单中的method = get,url=****
     *
     * http://localhost:8080/doService/getServe.do
     *
     *
     * */
    @CrossOrigin
    @PostMapping(value="/doService/getServe.do")
    @ResponseBody
    public CommonResult getServe(HttpServletRequest request) throws IOException {
        CommonResult cr = new CommonResult();

        String url = request.getParameter("url");
        /**
         * 获取后把他插入到表中，这里应该怎么设计呢？
         * */
        String res = httpClientUtils.getOnly(url);

        if(res!=null){
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
