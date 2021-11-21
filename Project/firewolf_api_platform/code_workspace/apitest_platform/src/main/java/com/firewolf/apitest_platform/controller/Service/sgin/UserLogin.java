package com.firewolf.apitest_platform.controller.Service.sgin;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author superxian
 * @date 2021/11/10 10:18
 */
@RestController
public class UserLogin {

    @Autowired
    private UserMapper userMapper;
    /**
     * http://localhost:8080/login
     * @return*/
    @CrossOrigin
    @PostMapping(value="/login",consumes = "application/json;charset=UTF-8")
    public String login(@RequestBody User user) throws Exception{

        String strUsername = user.getUsername();
        String strPassword = user.getPassword();

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
