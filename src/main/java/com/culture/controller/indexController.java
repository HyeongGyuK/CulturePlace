package com.culture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        System.out.println("home controller start");

        return "index_curtain.jsp";
    }
    
    @RequestMapping(value = "/CulturePlaceMain", method = RequestMethod.GET)
    public String goCulturePlaceMain() {
    	return "CulturePlace/main/main.jsp";
    }
    
    @RequestMapping(value = "/CommunityMain", method = RequestMethod.GET)
    public String goCommunityMain() {
    	return "Board/BoardFree/board_free_main.jsp";
    }
}
