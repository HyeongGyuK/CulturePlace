package com.culture.controller.User;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.culture.entity.Member;
import com.culture.repository.MemberRepository;
import com.culture.repository.UserCheckRepository;
import com.culture.service.MemberService;
import com.culture.service.UserCheckService;
import com.culture.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.culture.dto.MemberFormDto;
import com.culture.dto.UserFormDto;

@Controller(value = "UserController")
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {


	@Autowired
	private UserCheckService userCheckService;

	// 아이디 체크
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("MId") String MId){
//		System.out.println("MId = " + MId);
		int cnt = userCheckService.idCheck(MId);
		return cnt;
	}

	@GetMapping(value = "/login")
	public String login() {
		System.out.println("login controller");
		return "thymeleaf/member/UsersLogin";
	}

	@GetMapping(value = "/login/error")
	public String login(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {
		System.out.println("memberFormDto");

		if (bindingResult.hasErrors()) {
			System.out.println("에러");

			List<FieldError> list = bindingResult.getFieldErrors();
//			Map<String, String> errorMsg = new HashMap<>();
//
//			for (int i = 0; i < list.size(); i++) {
//				String field = list.get(i).getField();
//				String message = list.get(i).getDefaultMessage();
//
//				System.out.println("필드 = " + field);
//				System.out.println("메세지 = " + message);
//
//				errorMsg.put(field, message);
//			}
//			model.addAttribute("loginErrorMsg", errorMsg);
			model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");

			return "thymeleaf/member/UsersLogin";
		}
		return "thymeleaf/member/UsersLogin";
	}
	

	
	@GetMapping(value = "/new")
	public String join(Model model) {
		System.out.println("join controller");

		model.addAttribute("memberFormDto", new MemberFormDto());
		return "thymeleaf/member/UsersJoin";
	}

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder ;

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

		   return "thymeleaf/member/UsersJoin";
	   }

	   Member member = Member.createMember(memberFormDto, passwordEncoder);
	   memberService.saveMember(member) ;

	   System.out.println("aaaaaaaaaaaaaaaaaaaa");
	   return "CulturePlace/main/main";
   }
   
   
   
}










