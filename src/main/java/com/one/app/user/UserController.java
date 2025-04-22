package com.one.app.user;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users/*")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	@GetMapping("mypage")
	public void mypage() throws Exception {
		
	}
	
	@PostMapping("mypage")
	public void mypage(@Valid UserVO userVO, BindingResult bindingResult) throws Exception {
		
	}
	
	
	
	
	
	
	
	@GetMapping("join")
	public String join(@ModelAttribute UserVO userVO) throws Exception{
		
		
		return"users/join";
	}
	
	
	@PostMapping("join")
	public String join(@Valid UserVO userVO,BindingResult bindingResult, @RequestParam("avatar") MultipartFile avatar) throws Exception{
		
		log.info("{}",userVO);
		
		log.info("Count : {}", bindingResult.getErrorCount());
		
		if(userService.userErrorCheck(userVO,bindingResult)) {
			return "users/join";
		}
		
		int result = userService.join(userVO, avatar);
		
		
		return "redirect:./login";
		
	}
	
	@GetMapping("login")
	public String login() throws Exception{
		
		
		
		return"users/login";
	}
	
	@PostMapping("login")
	public String login(UserVO userVO,HttpSession session) throws Exception{
		userVO = userService.detail(userVO);
		
		if(userVO != null) {
			session.setAttribute("user", userVO);
		}
		
		return "redirect:/";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
