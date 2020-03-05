package com.fanhehe.home.controller;

import com.fanhehe.home.system.UserSystem;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class IndexController {

    private UserSystem userSystem;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "hello world";
    }

    @GetMapping("/user/create")
    @ResponseBody
    public String createUser(@NotBlank String phoneRegion, @NotBlank  String phoneNumber) {
        return userSystem.createUser(phoneRegion, phoneNumber);
    }

    @Autowired
    public void setUserSystem(UserSystem userSystem) {
        this.userSystem = userSystem;
    }
}
