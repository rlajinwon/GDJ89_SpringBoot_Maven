package com.one.app.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.one.app.user.UserDAO;
import com.one.app.user.UserVO;


@SpringBootTest
class UserTest {

	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Test
	void test() throws Exception{
		
		
		UserVO userVO = new UserVO();
		userVO.setUsername("admin");
		
		userVO = userDAO.detail(userVO);
		
		String pw ="11111111";
		
		boolean result = passwordEncoder.matches(pw, userVO.getPassword());  //암호화 된 비밀번호 비교하는 방법
		
		
		assertTrue(result);
		
	}

}
