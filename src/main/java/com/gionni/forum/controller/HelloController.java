package com.gionni.forum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	//@ResponseBody
	public String hello() {
		return "Olá mundo do Spring Boot";
	}

}
