package com.culture.controller.Member;


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

@Controller
@RequestMapping(value = "/members")
public class MemberController {
	
	@GetMapping(value = "/login")
	public String login() {
		System.out.println("login controller");
		return "Common/Member/Login/memberLoginForm.jsp";
	}
	

//	@GetMapping(value =  "/login/error")
//	public String login(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
//		System.out.println("memberFormDto");
//		
//			if(bindingResult.hasErrors()) {
//				System.out.println("에러");
// 
//				List<FieldError> list = bindingResult.getFieldErrors();
//				Map<String, String> errorMsg = new HashMap<>();
// 
//				for(int i=0;i<list.size();i++) {
//					String field = list.get(i).getField(); 
//					String message = list.get(i).getDefaultMessage(); 
//          
//					System.out.println("필드 = " + field);
//					System.out.println("메세지 = " +message);
//
//					errorMsg.put(field, message);
//				}
//				model.addAttribute("errorMsg", errorMsg);
//			   
//			   
//			   
//				return "../../Common/Member/Login/memberForm.jsp";
//			}
//	}
//	

	
	@GetMapping(value = "/new")
	public String join() {
		System.out.println("join controller");
//		return "Common/Member/Login/memberForm.jsp";
		return "Common/Member/SignUp/memberJoinTest.jsp";
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
		   
		   
		   
		   return "Common/Member/Login/memberForm.jsp";
	   }
  
	   return "redirect:/";
   }
   
   
   
}














