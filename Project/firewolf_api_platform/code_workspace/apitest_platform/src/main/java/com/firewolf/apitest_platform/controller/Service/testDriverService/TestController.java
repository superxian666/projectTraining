package com.firewolf.apitest_platform.controller.Service.testDriverService;

import com.alibaba.fastjson.JSONObject;
import com.firewolf.apitest_platform.domain.ResultObject;
import com.firewolf.apitest_platform.service.HttpClientUtils;
import com.firewolf.apitest_platform.service.TestService.ParternMatcher;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping(value = "/test")
@Controller
@CrossOrigin
public class TestController {
    /**
     * 实现了Token的搜索
     *
     * http://localhost:8080/test/getToken
     * */
    @CrossOrigin
    @RequestMapping(value = "/getToken",method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult testExcute(
            @RequestBody JSONObject jsonObject
            ) throws IOException {

        String test_txt =jsonObject.getString("tests");
        System.out.println("text_txt="+test_txt);
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
        System.out.println(test_txt);
        String url = jsonObject.getString("url");
        String content_txt = HttpClientUtils.getOnly(url);


        Pattern pattern2 = Pattern.compile("pattern=\"(\\S*)\"");
        Matcher matcher2=pattern2.matcher(test_txt);
        String pattern_txt = null;
        while(matcher2.find()) {
//			匹配内容,文本放到m.group(0);
            pattern_txt= matcher2.group(1);

        }
        //System.out.println("content="+content_txt+"pttarn="+pattern_txt);

        res = ParternMatcher.searchToken(content_txt,pattern_txt);
        System.out.println(res);

        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("test执行成功");
            cr.setData(res);
        }else {
            cr.setCode(1);
            cr.setMsg("test执行失败");
            cr.setData("");
        }

        return cr;
    }
//    content="value="773a1ea35125aa44""; pattern="value="(\S*)""

}
