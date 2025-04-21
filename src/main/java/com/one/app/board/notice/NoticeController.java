package com.one.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.one.app.board.BoardFileVO;
import com.one.app.board.BoardVO;
import com.one.app.home.util.Pager;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Value("${menu.board.notice.name}")
	private String name;
	
	
	@ModelAttribute("kind")
	public String getName() {
		return this.name;
	}
	
	
	
	
	@GetMapping("list")
	public String getList(Model model,Pager pager) throws Exception{
		
		List<BoardVO> ar = noticeService.getList(pager);
		model.addAttribute("list",ar);
		model.addAttribute("pager",pager);
		
		
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(NoticeVO boardVO,Model model) throws Exception{
		
		boardVO = (NoticeVO)noticeService.getDetail(boardVO);
		
		if(boardVO == null) {
			
		}
		
		
		model.addAttribute("vo", boardVO);
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add(NoticeVO boardVO) throws Exception{
		
		
		return "board/add";
		
	}
	
	
	@PostMapping("add")
	public String setAdd(NoticeVO boardVO,@RequestParam(name = "attaches") MultipartFile[] attaches) throws Exception{
		
		int result = noticeService.add(boardVO,attaches);
		
		
		
		return "redirect:./list";	
	}
	
	@PostMapping("delete")
	public String delete(NoticeVO boardVO) throws Exception{
		
		noticeService.delete(boardVO);
		
		return "redirect:./list";
	}
	
	
	@GetMapping("update")
	public String update(NoticeVO boardVO) throws Exception{

		
		return "board/add";
	}
	
	@PostMapping("update")
	public String setUpdate(NoticeVO boardVO) throws Exception{
		
		noticeService.update(boardVO);
		
		return "redirect:./detail?boardNum="+boardVO.getBoardNum();
		
	}
	
	
	@GetMapping("fileDown")
	public String getFileDetail(BoardFileVO boardFileVO, Model model) throws Exception{
		
		boardFileVO = noticeService.getFileDetail(boardFileVO);
		
		model.addAttribute("fileVO",boardFileVO);
		
		return "fileDownView";
	}
	
	
	
	
	
	
	
	
	
	
	
}
