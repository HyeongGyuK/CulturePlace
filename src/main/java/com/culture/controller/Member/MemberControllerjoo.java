package com.culture.controller.Member;


import com.culture.dto.MemberFormDto;
import com.culture.entity.Member;
import com.culture.service.MemberService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping(value = "/members")

public class MemberControllerjoo {

//    @GetMapping(value = "/login") // form 태그와 SecurityConfig 파일에 정의 되어 있습니다.
//    public String loginMember(){
//        return "Common/Member/Login/memberLoginForm";
////        return "Common/Member/Login/memberLogin";
//    }
//
//    @GetMapping(value = "/login/error")
//    public String loginError(Model model){
//        //"loginErrorMsg"와 관련된 내용은 파일 memberLoginForm.html 안에 구현 되어 있습니다.
//        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
//        return "Common/Member/Login/memberLoginForm";
//    }

//
//    // Get 방식) http://localhost:8989/members/new
//    @GetMapping(value = "/new")
//    public String memberForm(Model model){
//        // dto 객체 (화면을 통하여 넘겨 주거나 받는 객체)를 모델에 바인딩하면 실제 request 영역에 데이터가 들어갑니다.
////        model.addAttribute("memberFormDto", new MemberFormDto());
//        return "Common/Member/Login/memberForm";
//
//    }
//    //읽기 전용 오류뜸 > @RequiredArgsConstructor 어노테이션 추가 해주면 완료
//    private final MemberService memberService;
//    private final PasswordEncoder passwordEncoder;
//
//    
//    /*
//      @Valid 는 유효성 검사를 수행해주는 어노테이션 (매개변수에 있는 Dto클래스 객체 유효성 검사를 해준다.)
//    */
//    @PostMapping(value = "/new")
//    public String newMember(@Valid MemberFormDto memberFormDto,
//                            BindingResult bindingResult,
//                            Model model){
//        if (bindingResult.hasErrors()){ // <--필드에 문제가 있으면
//            return "Common/Member/Login/memberForm";    //<-- 회원가입 폼으로 이동합니다.
//        }
//
//        try {
//            Member member = Member.createMember(memberFormDto, passwordEncoder);
//            memberService.saveMember(member); //레퍼지토리로 보냅니다.
//
//            return "redirect:/"; // <--문제 없으면 메인 페이지로 이동
//        }catch (IllegalStateException e){
//            return "Common/Member/Login/memberForm"; //<--문제 생기면 회원가입 폼으로
//
//        }
//    }
//    
  
}














