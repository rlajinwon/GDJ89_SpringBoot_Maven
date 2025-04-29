package com.one.app.websocket;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.stereotype.Service;

import com.one.app.user.UserDAO;
import com.one.app.user.UserVO;

@Service
public class ChatService {

    private final WebSecurityCustomizer customizer;

	
	@Autowired
	private ChatDAO chatDAO;
	


    ChatService(WebSecurityCustomizer customizer) {
        this.customizer = customizer;
    }
	
	public List<UserVO> getList() throws Exception{
		
		List<UserVO> list = chatDAO.getList();
		
		return list;
		
	}
	
	List<MessageVO> room(MessageVO messageVO) throws Exception{
		
		List<MessageVO> list = chatDAO.room(messageVO);
		
		
	
		
		if(list.size()==0) {
			Calendar calendar = Calendar.getInstance();
			messageVO.setRoomNum(calendar.getTimeInMillis());
			chatDAO.addChat(messageVO);
			
			
		}
		
		return list;
		
		
	
	}
	
	
	
	
	
	
	
}
