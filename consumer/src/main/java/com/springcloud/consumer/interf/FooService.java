package com.springcloud.consumer.interf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("cloud-example-a")
@RequestMapping("/api/foo")
public interface FooService {
    @GetMapping
    void get();

    @PostMapping
    void add();

    @PutMapping("/{id}")
    void update(@PathVariable String id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id);
}
