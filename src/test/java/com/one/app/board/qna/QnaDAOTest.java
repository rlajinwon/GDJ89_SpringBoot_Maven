package com.one.app.board.qna;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class QnaDAOTest {

	
	@Autowired
	private QnaDAO qnaDAO;
	
	
	@Test
	void testAdd() throws Exception{
		
		
		QnaVO qnaVO = new QnaVO();
		qnaVO.setUserName("user3");
		qnaVO.setBoardTitle("title3");
		qnaVO.setBoardContents("contetnts3");
		qnaDAO.add(qnaVO);
		
		//qnaDAO.refUpdate(qnaVO);
	}
	

	
}