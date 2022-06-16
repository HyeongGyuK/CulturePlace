package com.culture.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
	@RequestMapping("/aaaa")
	public String atest() {
		return "CulturePlace/Common/nav.html";
	}
	
}
