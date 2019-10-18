package com.springcloud.provider.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping("/api/v1")
	public String home(@RequestParam String name) {
		System.out.println("provider");
		return "Hello World " + name + " " + new Date();
	}
}
