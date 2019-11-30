package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.LoginMapper;

@Controller
public class LoginController {
	
	@Autowired
	private LoginMapper login;
	 
	@GetMapping(path = "/")
	public ModelAndView helloWorld() {
		ModelAndView  mv = new ModelAndView("index");
		//mv.addObject("select", login.select_test()); 
		mv.addObject("test", "123123123");
		return mv;
	}
	
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest req, HttpServletResponse res,  String user_id, String user_pw) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		
		int cnt = login.select_test(user_id,user_pw);
		if(cnt == 1) {
			result.put("msg", "성공");
		}else {
			result.put("msg", "아이디 또는 비밀번호를 확인하세요");
		}
		result.put("cnt", cnt);
		
		
		return result;
	}
	
	
}
