package com.one.app.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	@GetMapping("/chat")
	public String Chat() {
		
		
		return "chat/list";
	}
	

}
