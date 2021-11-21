package com.firewolf.apitest_platform.controller.Service.add;

import com.firewolf.apitest_platform.domain.Case;
import com.firewolf.apitest_platform.domain.Collection;
import com.firewolf.apitest_platform.mapper.GetServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddCollectionController {
    /**
     * 1.在domian下新建Collection 实体类
     * 2.mapper下新建 CollectionMapper  mybatis 的实现类
     * 3.完成添加collection的控制器
     * */
    @Autowired

    private  GetServiceMapper gsm;
    @CrossOrigin
    @RequestMapping(value="/addCollection",method= RequestMethod.GET)
    public String addCollection(@RequestParam String cName){
        int cId=000001;
        cId+=gsm.countCollection();
        Collection col = new Collection(cId,cName);
        gsm.insertCollection(col);
        return cName+"插入成功！";
    }
}
