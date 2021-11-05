package com.firewolf.apitest_platform.mapper;

import com.firewolf.apitest_platform.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Insert("insert into user values (#{user_id},#{username},#{password})")
    public int insertUser(User user);
}