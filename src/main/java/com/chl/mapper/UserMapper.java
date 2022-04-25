package com.chl.mapper;

import com.chl.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;

/**
 * @description: 用户Mapper
 * @author: mqxu
 **/
public interface UserMapper {
    /**
     * 新增用户，并返回自增主键
     *
     * @param user 入参user对象
     */
    @Insert("INSERT INTO t_user (phone,nickname,avatar,create_time) VALUES (#{phone},#{nickname},#{avatar},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);


    /**
     * 根据手机号查询用户信息
     *
     * @param phone 手机号
     * @return User 用户对象
     */
    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test='phone!=null'> ",
            "AND phone = #{phone} " + "and active = 1",
            "</when> ",
            "</script>"})
    User findUserByPhone(@Param("phone") String phone);

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return User
     */
    //@Select("SELECT id,phone,nickname,avatar,gender,address,birthday,banner,signature FROM t_user WHERE id=#{id} ")
    @Select("SELECT * FROM t_user WHERE id=#{id} ")
    User getUser(@Param("id") int id);



    /**
     * 修改用户信息
     *
     * @param user 用户对象
     */
    @Update("UPDATE t_user SET password=#{password},nickname=#{nickname},avatar=#{avatar}," +
            "gender=#{gender},birthday=#{birthday}," +
            "address=#{address},banner=#{banner},signature=#{signature} " +
            "WHERE id=#{id} ")
    void updateUser(User user);

    /**
     * 绑定手机号
     *
     * @param id    用户id
     * @param phone 手机号
     */
    @Update(("UPDATE t_user SET phone=#{phone} WHERE id=#{id} "))
    void bandPhone(@Param("id") int id, @Param("phone") String phone);



//    @Insert("insert into t_user(email,password)  values(#{email},#{password})")
    Integer insUser(@Param("user") User user);

    @Update("update t_user set active=1  where id = #{id}")
    Boolean updUser(@Param("id") Integer id);

    @Select("select * from t_user where email = #{email}")
    User searchUser(@Param("email") String email);
}
