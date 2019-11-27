package com.weien.test;


import com.weien.service.PrintService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerService {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext-dubboconsumer.xml");
        ac.start();
        PrintService service = ac.getBean("service", PrintService.class);
        String print = service.print("魏恩");
        System.out.println(print);

    }
}
