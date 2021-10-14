package com.example.Thanks.Bonus.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class Controller {
	@GetMapping
	public String list(){
		return "index";
	}
}
