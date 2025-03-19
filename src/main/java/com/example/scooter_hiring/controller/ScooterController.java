package com.example.scooter_hiring.controller;

import com.example.scooter_hiring.bean.*;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.thymeleaf.spring4.context.SpringWebContext;
// import org.springframework.context.ApplicationContext;
// import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import java.util.List;

@Controller
@RequestMapping("/Scooter")
public class ScooterController {
    


    @RequestMapping(value = "/to_list", produces = "text/html")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model, User user) {
        return "";
    }
}
