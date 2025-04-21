package com.one.app.board.qna;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QnaDAOTest {

	
	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Test
	void testAdd() throws Exception{
		
		
		QnaVO qnaVO = new QnaVO();
		qnaVO.setUserName("user");
		qnaVO.setBoardTitle("title");
		qnaVO.setBoardContents("contetnts");
		qnaDAO.add(qnaVO);
		
		qnaDAO.refUpdate(qnaVO);
	}
	
}
