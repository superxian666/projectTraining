package com.firewolf.apitest_platform.controller.Service.caseService;

import com.firewolf.apitest_platform.domain.Case;
import com.firewolf.apitest_platform.domain.User;
import com.firewolf.apitest_platform.mapper.CaseMapper;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 高昕2021 11 23 存放cas有关的操作
 * */
@Controller
@RequestMapping(value = "/caseService")
public class CaseController {
    @Autowired
    private CaseMapper case_dao;
    /**
     * 1.case重命名
     * http://localhost:8080/caseService/rename
     * 2.case的新建
     * GetServiceController 中实现过
     * http://localhost:8080/caseService/createCase
     * 3.case的删除
     * http://localhost:8080/caseService/delete
     *
     * */
    @RequestMapping(value = "/rename")
    @ResponseBody
    public CommonResult rename(
//            @RequestParam(value = "name",required = true)String name,
//            @RequestParam(value = "id",required = true)Integer id
            @RequestBody User user
            ){
        String name = user.getUsername();
        Integer id = user.getUser_id();
        CommonResult cr = new CommonResult();
        Integer res = case_dao.renameCase(name,id);
        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("重命名case成功");
            cr.setData("");
        }else {
            cr.setCode(1);
            cr.setMsg("重命名case失败");
            cr.setData("");
        }

        return cr;

    }

//    新建  插入 返回case 的 id
    @ResponseBody
    @RequestMapping(value = "/createCase")
    public CommonResult createCase(
//            @RequestParam(value = "cid",required = true)Integer cid,//collection 的 id
//            @RequestParam(value = "url",required = false)String url,
//            @RequestParam(value = "name",required = true)String name,
//            @RequestParam(value = "method",required = false)String method,
//            @RequestParam(value = "type",required = false)String type
            @RequestBody Case cas
    ){
        Integer cid = cas.getCid();

        CommonResult cr = new CommonResult();
//        public Case(Integer cid, String name, String url, String method, String type) {

        Integer res = case_dao.insertCase(cas);
        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("创建case成功");
            cr.setData(cas);
        }else {
            cr.setCode(1);
            cr.setMsg("创建case失败");
            cr.setData("");
        }

        return cr;
    }

//    删除
    @ResponseBody
    @RequestMapping(value = "/delete")
    public CommonResult deleteCase(
            @RequestBody Case cas
    ){
        CommonResult cr = new CommonResult();
        Integer res = case_dao.deleteCase(cas.getId());
        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("删除case成功");
            cr.setData("");
        }else {
            cr.setCode(1);
            cr.setMsg("删除case失败");
            cr.setData("");
        }

        return cr;
    }


}
