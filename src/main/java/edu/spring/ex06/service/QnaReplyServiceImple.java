package edu.spring.ex06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex06.domain.QnaReplyVO;
import edu.spring.ex06.persistence.QnaDAO;
import edu.spring.ex06.persistence.QnaReplyDAO;



@Service
public class QnaReplyServiceImple implements QnaReplyService{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(QnaReplyServiceImple.class);
	
	@Autowired
	private QnaReplyDAO qnareplyDAO;
	
	@Autowired
	private QnaDAO qnaDAO;
	
	// @Transactional
	// - 두 개의 데이터베이스 변경이 생길 때
	// 위의 내용이 실행되었고, 아래의 내용이 에러가 발생하면
	// 위의 내용은 roll-back 되어야 한다.
	// 이러한 기능을 해주는 어노테이션
	// root-context.xml 설정

	
	@Transactional
	@Override
	public int create(QnaReplyVO vo) throws Exception {
		// 댓글이 증가하면
		// 게시판의 댓글 개수(reply_count)가 변경되어야 함
		// test_reply 테이블에 insert를 수행하면
		// test_board 테이블에 update를 수행한다.
		LOGGER.info("create() 호출");
		qnareplyDAO.insert(vo);
		LOGGER.info("댓글 입력 성공");
		
		qnaDAO.updateReplyCount(1, vo.getQnaNo());
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}

	@Override
	public List<QnaReplyVO> select_all_by_qna_no(int qnaNo) throws Exception {
		LOGGER.info("read() 호출");
		return qnareplyDAO.select_all_by_qna_no(qnaNo);
	}

	@Override
	public int update(QnaReplyVO vo) {
		LOGGER.info("update() 호출");
		return qnareplyDAO.update(vo);
	}

	@Transactional
	@Override
	public int delete(int replyNO, int qnaNo) throws Exception {
		LOGGER.info("delete() 호출");
		qnareplyDAO.delete(replyNO);
		LOGGER.info("댓글 삭제 성공");
		
		qnaDAO.updateReplyCount(-1, qnaNo);
		LOGGER.info("게시판 댓글 개수 업데이트 성공");
		return 1;
	}

}





