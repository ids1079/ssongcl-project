package edu.spring.ex06.persistence;

import java.util.List;

import edu.spring.ex06.domain.QnaReplyVO;


public interface QnaReplyDAO {
	int insert(QnaReplyVO vo);
	List<QnaReplyVO> select_all_by_qna_no(int qnaNo) throws Exception;
	int update(QnaReplyVO vo);
	int delete(int replyNo);
	
}
