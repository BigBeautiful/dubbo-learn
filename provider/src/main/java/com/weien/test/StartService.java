package com.weien.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class StartService {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-dubboprovider.xml");
        System.out.println("启动成功");
        ac.start();
        System.in.read();

    }
}
