package com.culture.controller;

import com.culture.dto.MemberFormDto;
import com.culture.entity.Member;
import com.culture.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class indexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("home controller start");

        return "index_curtain";
    }


    //    로그인 세션
    @GetMapping(value = "/login") // form 태그와 SecurityConfig 파일에 정의 되어 있습니다.
    public String loginMember() {return "thymeleaf/member/LoginTest";}

    @GetMapping(value = "/login/error")
    public String loginError(Model model) {
        //"loginErrorMsg"와 관련된 내용은 파일 memberLoginForm.html 안에 구현 되어 있습니다.
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "thymeleaf/member/LoginTest";}


    @GetMapping(value = "/test")
    public String test(Model model) {
        System.out.println("test controller start");

        model.addAttribute("memberFormDto", new MemberFormDto());
        return "thymeleaf/member/test";
    }

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/members/new")
    public String newMember(@Valid MemberFormDto memberFormDto,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) { // <--필드에 문제가 있으면
            return "thymeleaf/member/test";    //<-- 회원가입 폼으로 이동합니다.
        }

        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member); //레퍼지토리로 보냅니다.

            return "redirect:/"; // <--문제 없으면 메인 페이지로 이동
        } catch (IllegalStateException e) {
            return "thymeleaf/member/test"; //<--문제 생기면 회원가입 폼으로

        }
    }

    @RequestMapping(value = "/CulturePlaceMain", method = RequestMethod.GET)
    public String goCulturePlaceMain() {
        return "CulturePlace/main/main";
    }

    @RequestMapping(value = "/board/test", method = RequestMethod.GET)
    public String boardtest(Model model) {
        return "thymeleaf/Board/BoardFree/boardTest";
    }

}



































