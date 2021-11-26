package com.firewolf.apitest_platform.mapper;

import com.firewolf.apitest_platform.domain.Case;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *   get 业务逻辑执行的有关的mybatis查询。
 * */
@Mapper
@Repository
public interface GetServiceMapper {

    /**
     * selectCaseByUrl
     * 查到数据 证明 存在 ，查不到数据就可以进行插入了
     *
     * @Insert("insert into user values (#{user_id},#{username},#{password})")
     *     public int insertUser(User user);
     *
     *     @Select("select password from user where username = #{username}")
     *     public String findUser(User user);
     * */
    @Select("select * from `case` where url=#{url}")
    public Case selectCaseByUrl(Case cas);

    @Insert("insert into `case` values(#{id},#{cid},#{name},#{url},#{method},#{type})")
    public Case insertCase(Case cas);


}
