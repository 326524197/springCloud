package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("aiedu-cloud-login-restfulapp")
public interface ConsumeLoginInterface {

    @RequestMapping(value="/login/v1",method = RequestMethod.GET)
    String home1(@RequestParam(value = "name") String name);

}
