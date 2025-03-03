package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("aiedu-cloud-member-restfulapp")
@RequestMapping("/member")
public interface MemberInterface {

    @RequestMapping(value="/api/v1",method = RequestMethod.GET)
    String hello();

}
