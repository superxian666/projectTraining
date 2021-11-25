package com.firewolf.apitest_platform.mapper;

import com.firewolf.apitest_platform.domain.Case;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseMapper {
    @Select("select name from `case` where cid=#{cid}")
    public List<String> selectNameByCid(Integer cid);

    @Select("select * from `case` where cid=#{cid}")
    public List<Case> selectCaseByCid(Integer cid);
    /**
     * 对应CaseController的dao查询
     * 1. update name
     * 2. delete case
     * 3. insert case
     *
     * */
    @Insert("insert into `case` values(#{id},#{cid},#{name},#{url},#{method},#{type})")
    public int insertCase(Case cas);
    @Delete("delete from `case` where id= #{id}")
    public int deleteCase(Integer id);
    @Update("update `case` set name=#{name} where id=#{id}")
    public int renameCase(String name,Integer id);
    /**
     * 这个查询用在了get查询上
     * */
    @Update("update `case` set name=#{name},url= #{url},method=#{method},type=#{type}")
    public int updateCase(Case cas);


}
