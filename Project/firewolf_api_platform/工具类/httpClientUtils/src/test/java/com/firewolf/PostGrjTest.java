package com.firewolf;

import com.alibaba.fastjson.JSONObject;
import com.sun.tools.doclint.Checker;
import org.junit.Test;
public class PostGrjTest {
    String login_url = "http://49.232.71.217:8899/common/fgadmin/login";
    Checker check = null;

    public void login(Object phoneArea, Object phoneNumber, Object password) {
        JSONObject user = new JSONObject();
        user.put("phoneArea", phoneArea);
        user.put("phoneNumber", phoneNumber);
        user.put("password", password);
        String result = postGrj.doPost(login_url, user);
        System.out.println(result);
    }


    @Test
    public void testLoginSuccess() throws Exception {
        login("86", "2000", "123456");
    }


}