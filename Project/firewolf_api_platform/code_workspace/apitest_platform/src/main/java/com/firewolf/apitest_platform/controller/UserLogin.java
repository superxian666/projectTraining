package com.firewolf.apitest_platform.controller;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author superxian
 * @date 2021/11/4 15:18
 */
@RestController
public class UserLogin {

//    @Autowired
//    private UserMapper userMapper;
//    /**
//     * http://localhost:8080/login?username=xiaozhu&password=123456789
//     * */
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public void loginByusername(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("=========接收了Ajax的请求=========");
//        //接收请求的参数
//        String strName = request.getParameter("username");
//        String strW = request.getParameter("password");
//
//        System.out.println(strName);
//
//        String info="";
//
//        String pwd = userMapper.login(strName);
//
//        if(strW.equals(pwd)){
//            System.out.println(strName+"登录成功");
//            info=strName+"登录成功";
//        }else{
//            System.out.println(strName+"登录失败");
//            info=strName+"用户名或密码错误";
//        }
//        //使用jsp
//
//        //输出数据
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//
//        out.println(info);
//        out.flush();
//        out.close();
//    }


    @Autowired
    private UserMapper userMapper;
    /**
     * http://localhost:8080/login
     * @return*/
    @CrossOrigin
    @PostMapping(value="/login",consumes = "application/json")
    public String login(@RequestBody User user) {
        System.out.println("=========接收了Ajax的请求=========");
        //接收请求的参数

        String strName = user.getUsername();
        String strW = user.getPassword();

        System.out.println(strName);

        String pwd = userMapper.login(strName);

        if(strW.equals(pwd)){
            System.out.println(strName+"登录成功");
            return strName+"登录成功";
        }else{
            System.out.println(strName+"登录失败");
            return strName+"登录失败";
        }

        //输出数据
    }
}
