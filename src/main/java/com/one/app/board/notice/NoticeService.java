package com.one.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.one.app.board.BoardFileVO;
import com.one.app.board.BoardService;
import com.one.app.board.BoardVO;
import com.one.app.files.FileManager;
import com.one.app.home.util.Pager;


@Service
public class NoticeService implements BoardService{

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.delete(boardVO);
	}

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${menu.board.notice.name}")
	private String kind;
	
	@Value("${app.files.base}")
	private String path;
	
	
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		
		Long totalCount = noticeDAO.getTotalCount(pager);
		
		pager.make(totalCount);
		pager.makeNum();
		List<BoardVO> ar = noticeDAO.getList(pager);
		return ar;
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {

		return noticeDAO.getDetail(boardVO);
	}

	@Override
	public int add(BoardVO boardVO, MultipartFile[] multipartFile) throws Exception {
		// TODO Auto-generated method stub
		int result = noticeDAO.add(boardVO);
		
		
		//파일을 HDD에 저장 
		if(multipartFile != null) {
			for(MultipartFile f:multipartFile) {
				if(f.isEmpty()) {
					continue;
				}
				
				String fileName = fileManager.fileSave(path.concat(kind), f);
				//저장된 파일명을 DB에 저장 
				BoardFileVO boardfileVO = new BoardFileVO();
				boardfileVO.setFileName(fileName);
				boardfileVO.setOldName(f.getOriginalFilename());
				boardfileVO.setBoardNum(boardVO.getBoardNum());
				result = noticeDAO.addFile(boardfileVO);
				
			
			}
			
		}
		
		
		
		return result;
	}

	@Override
	public int update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		
		return noticeDAO.update(boardVO);
	}

	@Override
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception {

		return noticeDAO.getFileDetail(boardFileVO);
	}
	
	
	

	
}
