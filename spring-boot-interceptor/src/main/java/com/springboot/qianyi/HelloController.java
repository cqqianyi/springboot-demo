package com.springboot.qianyi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qianyi on 2017/11/26.
 */
@RestController
@RequestMapping(value="hello")
public class HelloController {


    @RequestMapping(value="world")
    public String  helloWorld(){

        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");
        System.out.println("hello world");

        return "Hello World";
    }
}
