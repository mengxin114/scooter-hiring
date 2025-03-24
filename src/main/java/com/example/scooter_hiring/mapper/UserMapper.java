package com.example.scooter_hiring.mapper;

import com.example.scooter_hiring.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // 根据id获取用户
    User getUserById(@Param("id") Long id);

    // 更新用户密码
    void updatePassword(@Param("id") Long id, @Param("password") String password);

    // 更新用户登录信息
    void updateLoginInfo(@Param("id") Long id, @Param("lastLoginDate") String lastLoginDate, @Param("loginCount") int loginCount);

    // 更新用户名
    void updateUserName(@Param("id") Long id, @Param("userName") String userName);

    // 更新用户手机号
    void updateMobile(@Param("id") Long id, @Param("mobile") String mobile);

    // 新建用户
    void insert(User user);
}
