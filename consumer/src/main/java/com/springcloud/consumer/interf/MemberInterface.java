package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("aiedu-cloud-member-restfulapp")
public interface MemberInterface {

    @RequestMapping(value="/api/v1/hello",method = RequestMethod.GET)
    String hello();

}
