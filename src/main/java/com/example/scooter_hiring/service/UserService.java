package com.example.scooter_hiring.service;

import com.example.scooter_hiring.bean.User;
import com.example.scooter_hiring.exception.GlobalException;
import com.example.scooter_hiring.mapper.UserMapper;
import com.example.scooter_hiring.result.*;
import com.example.scooter_hiring.util.JwtUtil;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;






@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(long id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    public boolean updatePassword(long id, String password) {
        User user = getById(id);
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        //密码存储需要加密
        toBeUpdate.setPassword(password);
        userMapper.update(toBeUpdate);
        return true;
    }

    public String login(String mobile, String formPass) {
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        if (!formPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        //生成cookie
        String token = JwtUtil.generateToken(mobile);
        return token;
    }
}
