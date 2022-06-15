package com.culture.test.chatting.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class SocketHandler extends TextWebSocketHandler{
	
	// 웹소켓 세션을 담아둘 맵
//	HashMap<String, WebSocketSession> sessionMap = new HashMap<>();
	List<HashMap<String, Object>> rls = new ArrayList<>();
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메시지 발송
		String msg = message.getPayload();
		JSONObject obj = jsonToObjectParser(msg);
		
		String rN = (String)obj.get("roomNumber");
		HashMap<String, Object> temp = new HashMap<String, Object>();
		
		if(rls.size() > 0) {
			for(int i = 0; i < rls.size(); i++) {
				String roomNumber = (String) rls.get(i).get("roomNumber");
				if(roomNumber.equals(rN)) {
					temp = rls.get(i);
					break;
				}
			}
			
			for(String k : temp.keySet()) {
				if(k.equals("roomNumber")) {
					continue;
				}
				
				WebSocketSession wss = (WebSocketSession) temp.get(k);
				
				if(wss != null) {
					try {
						wss.sendMessage(new TextMessage(obj.toJSONString()));
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
		
//		for(String key : sessionMap.keySet()) {
//			WebSocketSession wss = sessionMap.get(key);
//			
//			try {
//				wss.sendMessage(new TextMessage(obj.toJSONString()));
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 소켓 연결
		super.afterConnectionEstablished(session);
		boolean flag = false;
		String url = session.getUri().toString();
		System.out.println(url);
		
		String roomNumber = url.split("/chating/")[1];
		int idx = rls.size();
		if(rls.size() > 0) {
			for(int i = 0; i < rls.size(); i++) {
				String rN = (String)rls.get(i).get("roomNumber");
				
				if(rN.equals(roomNumber)) {
					flag = true;
					idx = i;
					break;
				}
			}
		}
		
		if(flag) {
			HashMap<String, Object> map = rls.get(idx);
			map.put(session.getId(), session);
		}else {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("roomNumber", roomNumber);
			map.put(session.getId(), session);
			rls.add(map);
		}
		
//		sessionMap.put(session.getId(), session);
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		obj.put("sessionId", session.getId());
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 소켓 종료
		if(rls.size() > 0) {
			for(int i=0; i < rls.size(); i++) {
				rls.get(i).remove(session.getId());
			}
		}
		
//		sessionMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}
	
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		
		try {
			obj = (JSONObject)parser.parse(jsonStr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return obj;
	}
}
























