package com.one.app.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import jakarta.servlet.http.HttpSession;

@Mapper
public interface UserDAO {

	
	public int join(UserVO userVO) throws Exception;
	
	public UserVO detail(UserVO userVO) throws Exception;
	
	public int statusChange(UserVO userVO) throws Exception;
}
