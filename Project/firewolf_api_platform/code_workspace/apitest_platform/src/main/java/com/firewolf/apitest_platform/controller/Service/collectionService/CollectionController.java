package com.firewolf.apitest_platform.controller.Service.collectionService;


import com.firewolf.apitest_platform.domain.Collection;
import com.firewolf.apitest_platform.mapper.CaseMapper;
import com.firewolf.apitest_platform.mapper.CollectionMapper;

import com.firewolf.apitest_platform.vo.CommonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/collectionService")
/**
 * 高昕  2021 11 23
 * */
public class CollectionController {
    @Autowired
    private CaseMapper case_dao;
    @Autowired
    private CollectionMapper collection_dao;
    /**
     *  71.实现增加collection操作
     *  http://localhost:8080/collectionService/add
     *  2.实现删除collection操作
     *  http://localhost:8080/collectionService/delete
     *  3.实现collection重命名操作
     *  http://localhost:8080/collectionService/rename
     *  4.查询在onload包中
     * */
//        实现增加collection操作
    @RequestMapping(value = "/add")
    @ResponseBody
    public CommonResult addCollection(
//            @RequestParam(value = "name",required = true)String name,
//            @RequestParam(value = "user_id",required = true)Integer user_id
            @RequestBody Collection collection
    ){
        CommonResult cr = new CommonResult();


        Integer res=collection_dao.insertCollection(collection);



        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("新建collection成功");
            cr.setData("插入行数"+res);
        }else {
            cr.setCode(1);
            cr.setMsg("新建collection失败");
            cr.setData("");
        }


        return cr;
    }

//    实现删除collection操作
    @RequestMapping(value = "/delete")
    @ResponseBody
    public CommonResult deleteCollection(
//            @RequestParam(value = "id",required = true)Integer id
            @RequestBody Collection collection
    ){
        CommonResult cr = new CommonResult();
        Integer res = collection_dao.deleteCollection(collection.getId());


        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("新建collection成功");
            cr.setData("删除行数"+res);
        }else {
            cr.setCode(1);
            cr.setMsg("删除collection失败");
            cr.setData("");
        }


        return cr;
    }

//    实现collection重命名操作
    @RequestMapping(value = "/rename")
    @ResponseBody
    public CommonResult renameCollection(
            @RequestParam(value = "name")String name,
            @RequestParam(value = "id")Integer id
    ){
        CommonResult cr = new CommonResult();
        Integer res = collection_dao.renameCollection(id,name);


        if(res!=null){
            cr.setCode(0);//代表成功
            cr.setMsg("重命名collection成功");
            cr.setData("");
        }else {
            cr.setCode(1);
            cr.setMsg("重命名collection失败");
            cr.setData("");
        }


        return cr;
    }

}
