package com.one.app.websocket;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.app.user.UserVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatHandler implements WebSocketHandler{
	
	//소켓으로 연결된 전체 유저
	//BroadCast
	private List<WebSocketSession> list = new ArrayList<>();
	
	private Map<String,WebSocketSession> users = new HashMap<>();
	
	private Map<Long, StringBuffer> messages = new HashMap<>();
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		//클라이언트가 웹소켓 연결 시 실행 
		log.info("소켓 연결 완료");
		log.info("session{}",session);
		log.info("p:{}",session.getPrincipal());
		list.add(session);
		
//		UserVO userVO = (UserVO)session.getPrincipal();
//		users.put(userVO.getUsername(), session);
		users.put(session.getPrincipal().getName(), session);
		
		
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		// WebSocket으로 연결 된 Client가 메세지를 송신 했을 때 실행 
		
		log.info("message : {}",message);
		log.info("m : {}", message.getPayload());
		
		ObjectMapper objectMapper = new ObjectMapper();
		MessageVO messageVO = objectMapper.readValue(message.getPayload().toString(), MessageVO.class);
		log.info("memssageVo : {}", messageVO);

		if(!messages.containsKey(messageVO.getRoomNum())) {
			StringBuffer sb = new StringBuffer();
			sb.append(message.getPayload());
			messages.put(messageVO.getRoomNum(),sb);
		}else {
			messages.get(messageVO.getRoomNum()).append(message.getPayload());
		}

		users.get(messageVO.getReceiver()).sendMessage(message);
		users.get(messageVO.getSender()).sendMessage(message);
	
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		// WebSocket 오류가 발생 했을 때 실행 
		
		
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		// WebSocket이 연결이 종료 되었을 때
		list.remove(session);
		
		
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		// 용량이 큰 데이터를 나눠서 받을 수 있는 여부 
		// true이면서 톰켓이 지원을 하면 handleMessage를 여러번 호출
		return false;
	}


	
	
	
}
