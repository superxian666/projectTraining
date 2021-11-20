package com.firewolf.apitest_platform;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;
import com.firewolf.apitest_platform.service.HttpClientUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApitestPlatformApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpClientUtils httpClientUtils;

    @Test
    public void testFindAll() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

    @Test
    public void testinsert(){
        User user = new User();
        user.setPassword("123456");
        user.setUsername("李明");
        userMapper.insertUser(user);
    }

    @Test
    public void test03_getClient() throws IOException {
        String url ="http://49.232.71.217:8899/common/skuList";
        String res = httpClientUtils.getOnly(url);
        System.out.println(res);
    }

}
