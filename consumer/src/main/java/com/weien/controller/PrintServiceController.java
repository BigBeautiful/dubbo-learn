package com.weien.controller;

import com.weien.service.PrintService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class PrintServiceController {

    @Resource
    PrintService service;

    @RequestMapping(value = "/print",produces = "text/html;charset=UTF-8")
    public String print(String name) {
        String weien = service.print("位辉");
        System.out.println(weien);
        return weien;
    }
}
