package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.from.SampleForm;

@Controller
@RequestMapping("lesson")
public class LessonController {
	
	@GetMapping("/sample")
    //@ResponseBody
    public String sample(Model model) {
		String text = "Hello Spring Boot!!";
		model.addAttribute("message",text);
        return "index";
	}
	
	 @GetMapping("/test/{num}")//Lesson2の例文04
	    @ResponseBody
	    public String test(@PathVariable Integer num) {
	        return "Good Evening!" + num;
	    }
	 
	 @GetMapping("/request_test")//03の例文
	 @ResponseBody
	 public String getTest(@RequestParam("name") String name
			 ,@RequestParam("bloodType") String bloodType) {
		 return "名前:" + name + "<br>血液型: " + bloodType;
	 }
	 
	 public String postTest(SampleForm sampleForm) {
		 return "名前:" + sampleForm.getName() + "<br>血液型: " + sampleForm.getBloodType();
	 }
	 
	 @GetMapping("/form_test")
	 public String formTest(SampleForm sampleForm, Model model) {
		 model.addAttribute("SampleForm", sampleForm);
		 return "lesson/form_test";
	 }
	 
	 @PostMapping("/request_test")//05の例文
	    @ResponseBody
	    public String postTest(SampleForm sampleForm) {
	        return "名前: " + sampleForm.getName() + "<br>血液型: " + sampleForm.getBloodType();
	    }
	 
	 @GetMapping("/form_test")//07の例文
	    public String formTest(@ModelAttribute SampleForm sampleForm) {
	        return "lesson/form_test";
	    }
	 
	 @GetMapping("/")//08の例文
	 	public String test(@RequestParam("name") String name) {
	    
	 	}
	 
}
