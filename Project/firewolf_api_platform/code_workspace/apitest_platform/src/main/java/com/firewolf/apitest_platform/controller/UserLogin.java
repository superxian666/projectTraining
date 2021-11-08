package com.firewolf.apitest_platform.controller;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author superxian
 * @date 2021/11/8 14:18
 */
@RestController
public class UserLogin {

    @Autowired
    private UserMapper userMapper;
    /**
     * http://localhost:8080/login
     * @return*/
    @CrossOrigin
    @PostMapping(value="/login",consumes = "application/json")
    public String login(@RequestBody User user) throws Exception{

        //接收请求的参数
//        获取用户输入的用户名
        String strUsername = user.getUsername();
//        获取用户输入的密码
        String strPassword = user.getPassword();

//        password为根据输入的用户名从数据库中查询的对应密码
//        如果用户名不存在返回结果为空，则password为null
        String password = userMapper.login(strUsername);

        if (password==null){
            System.out.println("用户名不存在,请注册");
            return "用户名不存在，请注册";
        } else if(strPassword.equals(password)){
            System.out.println(strUsername+"登录成功");
            return strUsername+"登录成功";
        }else{
            System.out.println(strUsername+"登录失败");
            return strUsername+"登录失败";
        }
    }
}

