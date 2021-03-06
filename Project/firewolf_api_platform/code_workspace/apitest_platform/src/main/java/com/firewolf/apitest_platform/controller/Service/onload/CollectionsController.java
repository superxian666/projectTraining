package com.firewolf.apitest_platform.controller.Service.onload;

import com.alibaba.fastjson.JSONObject;
import com.firewolf.apitest_platform.domain.Case;
import com.firewolf.apitest_platform.domain.Collection;
import com.firewolf.apitest_platform.mapper.CaseMapper;
import com.firewolf.apitest_platform.mapper.CollectionMapper;
import com.firewolf.apitest_platform.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  页面在加载的时候会发起ajax来查询  collections的所有名称
 *
 *  这里发来请求就返回给前端一个集合
 *
 * */
@Controller
public class CollectionsController {

    @Autowired
    private CollectionMapper collection_dao;
    @Autowired
    private CaseMapper case_dao;

    /**
     * 1.这个方法是要查询collection
     * http://localhost:8080/onload/collections
     * @user_id
     * */
    @RequestMapping(value = "/onload/collections" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult putCollections(
//            @RequestParam(value = "user_id",required = true)Integer user_id
            @RequestBody JSONObject jsonObject
            ){
        Integer user_id = jsonObject.getInteger("user_id");
        CommonResult cr = new CommonResult();

        List<Collection> collections = collection_dao.findCollectionByUserId(user_id);

        if(collections!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("查询用户collections成功");
            cr.setData(collections);
        }else {
            cr.setCode(1);
            cr.setMsg("查询用户collections失败");
            cr.setData("");
        }

        return cr;
    }


    /**
     * 2.查询对应collection的case
     * @Param cname  前端传过来的数据cname 就是 项目的name
     *  sunnygao  20211125这里修改为传所有对象
     * http://localhost:8080/onload/cases
     * */
    @RequestMapping(value = "/onload/cases")
    @ResponseBody
    public CommonResult putCases(
//            @RequestParam(value = "cname") String name
            @RequestBody JSONObject jsonObject

    ){

        CommonResult cr = new CommonResult();
        Integer cid = jsonObject.getInteger("cid");
        List<Case> cases = case_dao.selectCaseByCid(cid);
        if(cases!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("查询collections对应cases成功");
            cr.setData(cases);
        }else {
            cr.setCode(1);
            cr.setMsg("查询collections对应cases失败");
            cr.setData("");
        }



        return cr;
    }
}
