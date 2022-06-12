package com.culture.controller.loginTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		System.out.println("join controller");
		return "../../Test/JoinFormTest.jsp";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinProc(@Valid Join join, BindingResult bindingResult, Model model) {
		System.out.println(join);
		
		if(bindingResult.hasErrors()) {
			System.out.println("에러");
			
			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<>();
			
			for(int i=0;i<list.size();i++) {
				String field = list.get(i).getField(); 
				String message = list.get(i).getDefaultMessage(); 
						
				System.out.println("필드 = " + field);
				System.out.println("메세지 = " +message);
				
				errorMsg.put(field, message);
			}
			model.addAttribute("errorMsg", errorMsg);
			return "../../Test/JoinFormTest.jsp";
		}
		
		return "redirect:/";
	}
}
