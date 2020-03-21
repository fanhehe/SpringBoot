package com.fanhehe.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Router {
    @ResponseBody
    @RequestMapping("/:system/:service")
    public Object index() {
        return "a";
    }
}
