package com.example.scooter_hiring.controller;

import com.example.scooter_hiring.bean.User;
import com.example.scooter_hiring.exception.GlobalException;
import com.example.scooter_hiring.result.CodeMsg;
import com.example.scooter_hiring.result.Result;
import com.example.scooter_hiring.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setUserName("testuser");
        user.setPassword("password123");
        user.setMobile("15114043546");

        Mockito.when(userService.register(Mockito.any(User.class))).thenReturn(Result.success("注册成功"));

        mockMvc.perform(post("/User/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"testuser\",\"password\":\"password123\",\"email\":\"testuser@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"code\":0,\"msg\":\"success\",\"data\":\"注册成功\"}"))
                .andDo(print());
    }

    //test register method
    //The user service is mocked to throw a GlobalException with the message "手机号已存在"
    @Test
    public void testRegister2() throws Exception {
        User user = new User();
        user.setUserName("testuser");
        user.setPassword("password123");
        user.setMobile("15114043546");

        Mockito.when(userService.register(Mockito.any(User.class)))
                .thenThrow(new GlobalException(CodeMsg.MOBILE_EXIST));

        mockMvc.perform(post("/User/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"testuser\",\"password\":\"password123\",\"email\":\"})"))
    }

    // Test the login method
    // The user service is mocked to throw a GlobalException with the message "手机号不存在"
    @Test
    public void testLogin() throws Exception {
        Mockito.when(userService.login(Mockito.anyString(), Mockito.anyString()))
                .thenThrow(new GlobalException(CodeMsg.MOBILE_NOT_EXIST));

        mockMvc.perform(post("/User/login")
                .param("mobile", "15114043546")
                .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"code\":500214,\"msg\":\"手机号不存在\",\"data\":null}"))
                .andDo(print());
    }

    // Test the login method
    // The user service is mocked to return a token
    @Test
    public void testLogin2() throws Exception {
        Mockito.when(userService.login(Mockito.anyString(), Mockito.anyString())).thenReturn("token");

        mockMvc.perform(post("/User/login")
                .param("mobile", "15114043546")
                .param("password", "password123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"code\":0,\"msg\":\"success\",\"data\":\"token\"}"))
                .andDo(print());
    }

    
}