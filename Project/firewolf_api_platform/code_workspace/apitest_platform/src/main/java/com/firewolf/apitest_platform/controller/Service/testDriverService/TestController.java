package com.firewolf.apitest_platform.controller.Service.testDriverService;

import com.firewolf.apitest_platform.service.TestService.ParternMatcher;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping(value = "/test")
@Controller
public class TestController {
    /**
     * 实现了Token的搜索
     *
     * http://localhost:8080/test/getToken
     * */
    @RequestMapping(value = "/getToken")
    @ResponseBody
    public CommonResult testExcute(
            @RequestParam(value = "test_txt",required = true)String test_txt
    ){
        CommonResult cr = new CommonResult();
        String res = null;

        /**
         * 处理test
         * 用正则表达式
         * 匹配content=""
         * 匹配partern=""
         * //        String content = "  <input type=\"hidden\" name=\"csrf_token\" value=\"773a1ea35125aa44\"/>";
         * //        Pattern pattern = Pattern.compile("  <input type=\"hidden\" name=\"csrf_token\" value=\"(\\S*)\"/>");
         * */
        Pattern pattern = Pattern.compile("content=\"(\\S*)\"");
//		2.创建一个匹配器对象
        Matcher matcher=pattern.matcher(test_txt);
        String content_txt = null;
        String pattern_txt = null;
//		3.可以开始循环匹配
        while(matcher.find()) {
//			匹配内容,文本放到m.group(0);
            content_txt = matcher.group(1);

        }


        Pattern pattern2 = Pattern.compile("pattern=\"(\\S*)\"");
        Matcher matcher2=pattern2.matcher(test_txt);
        while(matcher2.find()) {
//			匹配内容,文本放到m.group(0);
            pattern_txt= matcher2.group(1);

        }

//        res = ParternMatcher.searchToken(content_txt,pattern_txt);
//
//        if(res!=null){
//            cr.setCode(0);//代表成功
//            cr.setMsg("test执行成功");
//            cr.setData(res);
//        }else {
//            cr.setCode(1);
//            cr.setMsg("test执行失败");
//            cr.setData("");
//        }

        return cr;
    }


}
