package com.weien.controller;

import com.weien.service.PrintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/cdl")
public class CountDownLatchController {

    Logger logger = LoggerFactory.getLogger(CountDownLatchController.class);

    @Resource
    PrintService service;

    @RequestMapping(value = "/print", produces = "text/html;charset=UTF-8")
    public String printTask() {

        final CountDownLatch other = new CountDownLatch(3);

        ExecutorService excutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            excutor.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    String s = service.print("接口调用" + finalI + "...");
//                    logger.info(s);
                    System.out.println(s);
                    other.countDown();
                }
            }));
        }
        excutor.shutdown();

        try {
            other.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("拿到三个接口数据，主线程执行。。。");


        return "执行成功";

    }
}
