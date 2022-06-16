package com.culture.test.chatting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.culture.test.chatting.vo.Room;

@Controller
public class ChatController {
	
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;

	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Test/WebSocketTest.jsp");
		
		return mv;
	}
	
	@RequestMapping("/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Test/room.jsp");
		
		return mv;
	}
	
	@RequestMapping("/createRoom")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		
		return roomList;
	}
	
	@RequestMapping("/getRoom")
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	@PostMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<String, String> params) {
		String htmlCode = "";
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String)params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
//			mv.setViewName("Test/WebSocketTest.jsp");
			
			htmlCode += "<div id=\"container\"> class\"container\"";
			htmlCode += "<h1>" + params.get("roomName") + "의 채팅방</h1>";
			htmlCode += "<input type\"hidden\" id=\"sessionId\" value=\"\"";
			htmlCode += "<input type\"hidden\" id=\"roomNumber\" value=\"" + params.get("roomNumber") + "\">";
			htmlCode += "<div id=\"chating\" class=\"chating\">";
			htmlCode += "</div>";
			
			htmlCode += "<div id=\"yourName\">";
			htmlCode += "<table class=\"inputTable\">";
			htmlCode += "<tr>";
			htmlCode += "<th>사용자명</th>";
			htmlCode += "<th><input type=\"text\" name=\"userName\" id=\"userName\"></th>";
			htmlCode += "<th><button onclick=\"chatName()\" id=\"startBtn\">이름 등록</button></th>";
			htmlCode += "</tr>";
			htmlCode += "</table>";
			htmlCode += "</div>";
			htmlCode += "<div id=\"yourMsg\">";
			htmlCode += "<table class=\"inputTable\">";
			htmlCode += "<tr>";
			htmlCode += "<th>메시지</th>";
			htmlCode += "<th><input id=\"chatting=\" placeholder=\"보내실 메시지를 입력하세요.\"></th>";
			htmlCode += "<th><button onclick=\"send()\" id=\"sendBtn\">보내기</button></th>";
			htmlCode += "</tr>";
			htmlCode += "</table>";
			htmlCode += "</div>";
			htmlCode += "</div>";
			
			mv.addObject("chatHtml", htmlCode);
		}else {
			mv.setViewName("Test/room.jsp");
		}
		
		return mv;
	}
}

























