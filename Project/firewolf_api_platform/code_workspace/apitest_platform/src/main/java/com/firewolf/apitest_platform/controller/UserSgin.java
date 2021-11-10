package com.firewolf.apitest_platform.controller;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author superxian
 * @date 2021/11/10 10:18
 */

@RestController
public class UserSgin {

    @Autowired
    private UserMapper userMapper;
    /**
     * http://localhost:8080/register
     * @return*/
    @CrossOrigin
    @PostMapping(value="/register",consumes = "application/json;charset=UTF-8")
    public String register(@RequestBody User resister_user) {

        String retusername=resister_user.getUsername();
        String retpassword=resister_user.getPassword();
        String renpassword=resister_user.getRpassword();

        User user0 = new User();
        user0.setUsername(retusername);
        user0.setPassword(retpassword);

        if(userMapper.findUser(resister_user)!=null){
            System.out.println("用户"+retusername+"已存在！");
            return "用户"+retusername+"已存在！";
        }else if(retusername.length()>16 || retusername.length()<6 ){
            System.out.println("用户名长度不符合要求！");
            return "用户名长度不符合要求！";
        }else if(retpassword.length()>16 || retpassword.length()<6){
            System.out.println("密码长度不符合要求！");
            return"密码长度不符合要求!";
        }else if(retpassword.equals(renpassword)==false){
            return "新密码与确认新密码不一致";
        }else{
            userMapper.insertUser(user0);
            System.out.println(retusername+"注册成功！");
            return retusername+"注册成功！";
        }
    }
}