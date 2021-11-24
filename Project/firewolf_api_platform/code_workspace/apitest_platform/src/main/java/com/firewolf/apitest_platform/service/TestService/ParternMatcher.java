package com.firewolf.apitest_platform.service.TestService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParternMatcher {
    /**
     * String content //为要搜索的正文
     * String parttern 为要搜素的表达式
     * */
    public static String searchToken(String content,String parttern) {

//		1.先创建一个Pattern对象,模式对象,可以理解成一个正则表达式对象
//        String content = "  <input type=\"hidden\" name=\"csrf_token\" value=\"773a1ea35125aa44\"/>";
//        Pattern pattern = Pattern.compile("  <input type=\"hidden\" name=\"csrf_token\" value=\"(\\S*)\"/>");


        Pattern pattern = Pattern.compile(parttern);
//		2.创建一个匹配器对象

        Matcher matcher=pattern.matcher(content);
        String res = null;
//		3.可以开始循环匹配
        while(matcher.find()) {
//			匹配内容,文本放到m.group(0);
            res = matcher.group(1);


        }
        return res;
    }

//    public static void main(String[] args) {
//
//        System.out.println(ParternMatcher.searchToken(
//                "  <input type=\"hidden\" name=\"csrf_token\" value=\"773a1ea35125aa44\"/>"
//                ,"  <input type=\"hidden\" name=\"csrf_token\" value=\"(\\S*)\"/>"));
//    }

}
