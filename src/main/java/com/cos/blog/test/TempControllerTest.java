package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// file return basic directory: src/main/resources/static
		// return name: /home.html
		// fullname: src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String temImg() {
		return "/a.jpg";
	}
	
	@GetMapping("/temp/jsp")    //jsp는 stacticless 파일이라 동적인파일. 
	public String temJsp() {
		//prefix: /WEB-INF/views
		//suffix: .jsp
		//fullname: /WEB-INF/views//test.jsp.jsp
		return "test";
	}
}
