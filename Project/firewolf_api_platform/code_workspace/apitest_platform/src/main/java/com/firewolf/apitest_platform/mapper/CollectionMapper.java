package com.firewolf.apitest_platform.mapper;

import com.firewolf.apitest_platform.domain.Collection;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionMapper {


    @Select("select * from `collections`")
    public List<Collection> findAll();

    @Select("select * from `collections` where user_id=#{user_id}")
    public List<Collection> findCollectionByUserId(Integer user_id);

    @Select("select id from `collections` where name=#{name}")
    public Integer findIdByCname(String name);

    /**
     * @Insert("insert into user values (#{user_id},#{username},#{password})")
     * public int insertUser(User user);
     * */
//    新建collection操作 insert新的collection
    @Insert("insert into collections values (#{id},#{name},#{user_id})")
    public int insertCollection(Collection collection);

//    删除collection操作
    @Delete("delete from collections where id = #{id}")
    public int deleteCollection(Integer id);
//    重命名
    @Update("update collections set name=#{name} where id=#{id}")
    public int renameCollection(Integer id,String name);
}
