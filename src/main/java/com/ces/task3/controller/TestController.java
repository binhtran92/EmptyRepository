package com.ces.task3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @GetMapping
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
