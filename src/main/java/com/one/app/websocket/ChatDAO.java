package com.one.app.websocket;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.one.app.user.UserVO;

@Mapper
public interface ChatDAO {
	
	List<UserVO> getList() throws Exception;
	
	List<MessageVO> room(MessageVO messageVO) throws Exception;
	
	int makeRoom(MessageVO messageVO) throws Exception;
	
}
