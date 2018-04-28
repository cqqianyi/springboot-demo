package com.hellokoding.uploadingfiles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: cqqianyi@sina.cn
 * @create: 2018-04-19
 **/
@RequestMapping(value = "/wechat")
@RestController
public class WechatController {

    @RequestMapping(value = "portal",method = RequestMethod.GET)
    public void test(HttpServletRequest request,
                     HttpServletResponse response,
                     @RequestParam(value = "signature", required = true) String signature,
                     @RequestParam(value = "timestamp", required = true) String timestamp,
                     @RequestParam(value = "nonce", required = true) String nonce,
                     @RequestParam(value = "echostr", required = true) String echostr){
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
    }
}
