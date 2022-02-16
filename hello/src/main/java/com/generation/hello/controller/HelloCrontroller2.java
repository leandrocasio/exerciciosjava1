package com.generation.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/ola")

public class HelloCrontroller2 {
	@GetMapping
	
	public String ola() {
		return "Eu sou leandro";
		
	}
	
}
