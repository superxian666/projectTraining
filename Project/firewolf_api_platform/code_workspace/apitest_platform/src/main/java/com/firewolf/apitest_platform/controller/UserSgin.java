package com.firewolf.apitest_platform.controller;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class UserSgin {

    /**
     * @Autowired  引用类型对象使用的注解，加上这个注解后不用实例化。
     * */

    @Autowired
    private UserMapper userMapper;
/**
 * http://localhost:8080/hello
 * */
    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot!!!";
    }

    /**
     * http://localhost:8080/sginUser?username=xiaozhu&password=123456789
     * */
    @RequestMapping("/sginUser")
    public void sgin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=========接收了Ajax的请求=========");
        //接收请求的参数
        String strName = request.getParameter("username");
        String strW = request.getParameter("password");

        System.out.println(strName);

        String info="";

        User user = new User();
        user.setUsername(strName);
        user.setPassword(strW);
        userMapper.insertUser(user);
        //使用jsp

        //把数据保存到 request 作用域
        info = strName +"注册成功";
        //输出数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println(info);
        out.flush();
        out.close();

    }
}