package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("aiedu-cloud-login-restfulapp")
public interface LoginInterface {
    @RequestMapping(value = "/api/v1",method = RequestMethod.GET)
    String hello();

}
