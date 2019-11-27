package com.weien.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test {
    @RequestMapping("/print")
    public void print() {
        System.out.println("测试mvc是否通用");
    }
}
