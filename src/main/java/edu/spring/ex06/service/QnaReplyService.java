package edu.spring.ex06.service;

import java.util.List;

import edu.spring.ex06.domain.QnaReplyVO;



public interface QnaReplyService {
	int create(QnaReplyVO vo) throws Exception;
	List<QnaReplyVO> select_all_by_qna_no(int qnaNo) throws Exception;
	int update(QnaReplyVO vo);
	int delete(int replyNO, int qnaNo) throws Exception;
}
