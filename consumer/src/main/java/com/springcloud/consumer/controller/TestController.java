package com.springcloud.consumer.controller;

import com.springcloud.consumer.interf.AExampleInterface;
import com.springcloud.consumer.interf.LoginInterface;
import com.springcloud.consumer.interf.MemberInterface;
import com.springcloud.consumer.interf.ProviderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ProviderInterface providerInterface;


    @Autowired
    AExampleInterface aExampleInterface;

    @Autowired
    MemberInterface memberInterface;

    @Autowired
    LoginInterface loginInterface;

    // 调用login接口失败
    @RequestMapping(value = "/v1", method = RequestMethod.GET)
    public String v1() {
        loginInterface.hello();
        return "test1";
    }

    // 调用rember接口失败
    @RequestMapping(value = "/v3", method = RequestMethod.GET)
    public String v3() {
        memberInterface.hello();
        return "test3";
    }

    @RequestMapping(value = "/v5", method = RequestMethod.GET)
    public String v5() {
        aExampleInterface.get();
        return "test5";
    }



}
