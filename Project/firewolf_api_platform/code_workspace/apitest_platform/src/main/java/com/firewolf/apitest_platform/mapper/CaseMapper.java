package com.firewolf.apitest_platform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseMapper {
    @Select("select name from `case` where cid=#{cid}")
    public List<String> selectNameByCid(Integer cid);
}
