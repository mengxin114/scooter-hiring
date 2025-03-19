package com.example.scooter_hiring.mapper;

import com.example.scooter_hiring.bean.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    //根据id获取用户
    @Select("select * from user where id = #{id}")
    public User getUserById(@Param("id") Long id);
    
    //更新用户密码
    @Update("update user set password = #{password} where id = #{id}")
    public void update(User toBeUpdate);

    //更新用户登录信息
    @Update("update user set last_login_date = #{lastLoginDate}, login_count = #{loginCount} where id = #{id}")
    public void updateLoginInfo(User toBeUpdate);

    //更新用户名
    @Update("update user set user_name = #{userName} where id = #{id}")
    public void updateUserName(User toBeUpdate);
}
