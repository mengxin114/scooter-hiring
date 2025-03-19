package com.example.scooter_hiring.controller;

import com.example.scooter_hiring.bean.*;
import com.example.scooter_hiring.result.CodeMsg;
import com.example.scooter_hiring.result.Result;
import com.example.scooter_hiring.service.UserService;

import io.jsonwebtoken.Claims;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Result<String> login(HttpServletResponse response, @RequestParam String mobile, @RequestParam String password) {
        String token = userService.login(mobile, password);
        response.setHeader("Authorization", "Bearer " + token);
        return Result.success(token);
    }
    
    @GetMapping("/profile")
    public Result<String> getProfile(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        if (claims == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        String username = claims.getSubject();
        return Result.success("Hello, " + username);
    }
}
