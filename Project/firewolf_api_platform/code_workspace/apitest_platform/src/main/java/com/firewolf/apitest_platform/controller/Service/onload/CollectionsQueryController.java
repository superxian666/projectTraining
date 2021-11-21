package com.firewolf.apitest_platform.controller.Service.onload;

import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollectionsQueryController {

    @RequestMapping(value = "/onload/collections")
    @ResponseBody
    public CommonResult putCollections(){
        CommonResult cr = new CommonResult();

        return cr;
    }


    @RequestMapping(value = "/onload/cases")
    @ResponseBody
    public CommonResult putCases(){
        CommonResult cr = new CommonResult();

        return cr;
    }
}
