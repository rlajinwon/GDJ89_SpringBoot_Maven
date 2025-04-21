package com.one.app.board.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.one.app.board.BoardDAO;
import com.one.app.board.BoardVO;

@Mapper
public interface NoticeDAO extends BoardDAO{

	
	public int refUpdate(BoardVO boardVO) throws Exception;
	
	public int test(List<BoardVO> ar) throws Exception;
	
	
	
}
