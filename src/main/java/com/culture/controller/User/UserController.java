package com.culture.controller.User;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.culture.dto.MemberFormDto;
import com.culture.dto.UserFormDto;

@Controller(value = "UserController")
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping(value = "/login")
	public String login() {
		System.out.println("login controller");
		return "thymeleaf/member/LoginTest";
	}
	

	@GetMapping(value = "/login/error")
	public String login(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		System.out.println("memberFormDto");

		if (bindingResult.hasErrors()) {
			System.out.println("에러");

			List<FieldError> list = bindingResult.getFieldErrors();
			Map<String, String> errorMsg = new HashMap<>();

			for (int i = 0; i < list.size(); i++) {
				String field = list.get(i).getField();
				String message = list.get(i).getDefaultMessage();

				System.out.println("필드 = " + field);
				System.out.println("메세지 = " + message);

				errorMsg.put(field, message);
			}
			model.addAttribute("loginErrorMsg", errorMsg);

			return "thymeleaf/member/LoginTest";
		}
		return "thymeleaf/member/LoginTest";
	}
	

	
	@GetMapping(value = "/new")
	public String join(Model model) {
		System.out.println("join controller");

		model.addAttribute("memberFormDto", new MemberFormDto());
		return "thymeleaf/member/test";
	}

	
	
	   
   @PostMapping(value = "/new")
   public String joinProc(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
	   System.out.println(memberFormDto);
      
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
		   
		   
		   
		   return "thymeleaf/member/test";
	   }
  
	   return "redirect:/";
   }
   
   
   
}














