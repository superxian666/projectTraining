package com.firewolf.apitest_platform;

import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.UserMapper;
import com.firewolf.apitest_platform.service.HttpClientUtils;
import com.firewolf.apitest_platform.service.TestService.ParternMatcher;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void test04(){
        String content = "  content=\"1\"  pattern=\"2\" ";
        Pattern pattern = Pattern.compile("content=\"(\\S*)\"");
//		2.创建一个匹配器对象
        Matcher matcher=pattern.matcher(content);
        String content_txt = null;
        String pattern_txt = null;
//		3.可以开始循环匹配
        while(matcher.find()) {
//			匹配内容,文本放到m.group(0);
            content_txt = matcher.group(1);

        }


        Pattern pattern2 = Pattern.compile("pattern=\"(\\S*)\"");
        Matcher matcher2=pattern2.matcher(content);
        while(matcher2.find()) {
//			匹配内容,文本放到m.group(0);
            pattern_txt= matcher2.group(1);

        }
        System.out.println("content="+content_txt+";"+"pattern="+pattern_txt);

    }


    @Test
    public void test07(){
        String content = "  content=\"1\"  pattern=\"2\" ";
        Pattern pattern = Pattern.compile("value=\"(\\S*)\"");
//        Pattern pattern = Pattern.compile("content=\"(\\S*)\"");
//		2.创建一个匹配器对象
        Matcher matcher=pattern.matcher("value=\"773a1ea35125aa44\"");
        String res = null;
//		3.可以开始循环匹配
        while(matcher.find()) {
//			匹配内容,文本放到m.group(0);
            res = matcher.group(1);

        }
        System.out.println(res);

    }
}
