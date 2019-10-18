package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("aiedu-cloud-login-restfulapp")
@RequestMapping("/api/v1")
public interface LoginInterface {
    @GetMapping
    String hello();

}
