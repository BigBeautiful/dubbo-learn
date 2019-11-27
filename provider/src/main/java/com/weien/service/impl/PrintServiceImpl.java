package com.weien.service.impl;

import com.weien.service.PrintService;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {
    public String print(String name) {
        String s = "收到来自消费者" + name + "的消息";
        System.out.println(s);
        return s;
    }
}
