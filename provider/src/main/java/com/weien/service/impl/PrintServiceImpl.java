package com.weien.service.impl;

import com.weien.service.PrintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {

    Logger logger = LoggerFactory.getLogger(PrintServiceImpl.class);

    public String print(String name) {
        System.out.println("收到来自消费者" + name + "的消息");
        return name + "发送消息成功";
    }
}
