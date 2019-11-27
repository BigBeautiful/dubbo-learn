package com.weien.controller;

import com.alibaba.dubbo.rpc.RpcContext;
import com.weien.service.PrintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/future")
public class FutureController {

    Logger logger = LoggerFactory.getLogger(FutureController.class);

    @Resource
    PrintService service;

    @RequestMapping(value = "/print", produces = "text/html;charset=UTF-8")
    public String printTask() {

        String result1 = service.print("接口1.....");
        Future<String> future1 = RpcContext.getContext().getFuture();
        String result2 = service.print("接口2.....");
        Future<String> future2 = RpcContext.getContext().getFuture();
        String result3 = service.print("接口3.....");
        Future<String> future3 = RpcContext.getContext().getFuture();
        try {
            result1 = future1.get(); // 可能会抛异常，请捕获
        } catch (Throwable e) {
        }
        try {
            result2 = future2.get(); // 可能会抛异常，请捕获
        } catch (Throwable e) {
        }
        try {
            result3 = future3.get(); // 可能会抛异常，请捕获
        } catch (Throwable e) {
        }

        System.out.println(result1 + " " + result2 + " " + result3 +"获取数据成功");


        return "执行成功";

    }
}
