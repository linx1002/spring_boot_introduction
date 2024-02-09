package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	
	@GetMapping("/sample")
    //@ResponseBody
    public String sample(Model model) {
		String text = "Hello Spring Boot!!";
		model.addAttribute("message",text);
        return "index";
	}
	
	 @GetMapping("/test/{num}")
	    @ResponseBody
	    public String test(@PathVariable Integer num) {
	        return "Good Evening!" + num;
	    }
}
