package com.culture.controller.Chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chat")
public class chatController_go {
    @GetMapping(value = "/go")
    public String chatGo(){
        return "Intro/header/chat";
    }
}