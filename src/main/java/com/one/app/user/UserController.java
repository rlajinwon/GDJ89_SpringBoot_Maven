package com.one.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users/*")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("join")
	public String join() throws Exception{
		
		
		return"users/join";
	}
	
	
	@PostMapping("join")
	public String join(UserVO userVO, @RequestParam("avatar") MultipartFile avatar) throws Exception{
		
		int result = userService.join(userVO, avatar);
		
		return "redirect:/";
		
	}
	
	@GetMapping("login")
	public String login() throws Exception{
		
		
		
		return"users/login";
	}
	
	@PostMapping("login")
	public String login(UserVO userVO,HttpSession session) throws Exception{
		userVO = userService.login(userVO);
		
		if(userVO != null) {
			session.setAttribute("user", userVO);
			return "redirect:/";
		}
		
		return "redirect:./login";
	}
	
	
	
	
	
}
