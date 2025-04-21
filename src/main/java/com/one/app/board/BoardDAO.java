package com.one.app.board;

import java.util.List;

import com.one.app.home.util.Pager;

public interface BoardDAO {

	public List<BoardVO> getList(Pager pager) throws Exception;
	
	
	public BoardVO getDetail(BoardVO boardVO) throws Exception;
	
	public int add(BoardVO boardVO) throws Exception;
	
	public int addFile(BoardFileVO boardFileVO) throws Exception;

	public Long getTotalCount(Pager pager) throws Exception;
	
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception;
	
	
	
	public int delete(BoardVO boardVO) throws Exception;
	
	public int update(BoardVO boardVO) throws Exception;
	
	
}
