package com.hdrtrr.jmh.try_test.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloController {

    @RequestMapping("testA")
    String testA() {
        int a = 1;
        int b = 2;
        int c = a*b;

        return "testABC";

    }



    @RequestMapping("hello")
    String hello() {
        return "Hello World123!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }
}
