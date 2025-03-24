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
        // 更新数据库
        User toBeUpdate = new User();
        toBeUpdate.setId(id);
        // 密码存储需要加密
        toBeUpdate.setPassword(password);
        userMapper.updatePassword(id, password);
        return true;
    }

    public String login(String mobile, String formPass) {
        User user = getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        // 验证密码
        String dbPass = user.getPassword();
        if (!formPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

        // 生成cookie
        String token = JwtUtil.generateToken(mobile);
        return token;
    }

    public Result<String> register(User user) {
        if (user == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        long mobile = user.getId();
        String formPass = user.getPassword();
        // 判断手机号是否已经注册
        User user1 = getById(mobile);
        if (user1 != null) {
            throw new GlobalException(CodeMsg.MOBILE_ALREADY_EXIST);
        }
        // 密码加密
        user.setPassword(formPass);
        userMapper.insert(user);
        return Result.success("success");
    }
}
