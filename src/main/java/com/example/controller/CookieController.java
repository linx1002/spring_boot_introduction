package com.example.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("cookie")
public class CookieController {
	@GetMapping("/set")
	@ResponseBody
	public String setCookie(@RequestParam String value, HttpServletResponse res) {
		res.addCookie(new Cookie("test_cookie",value));//Cookie名と値を保存の命令する。
		return "保存しました";
	}
	
	@GetMapping("/get")
	@ResponseBody			//↓を付けた（）内のcookie名を指定して引数に入れる。
	public String getCookie(@CookieValue("test_cookie") Cookie cookie){
		return "cookieValue: " + cookie.getValue();//←cookieの値を取得
		
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteCookie(@CookieValue("test_cookie") Cookie cookie, HttpServletResponse res) {
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		return "削除しました";
	}
}
