package edu.spring.ex06.persistence;

import java.util.List;

import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.pageutil.PageCriteria;




public interface QnaDAO {
	// 연결되는 VO 자체는 변해도 DAO 안에 구성은 변하지 않음
	int insert(QnaVO vo);
	List<QnaVO> select();
	QnaVO select(int qnaNo);
	int update(QnaVO vo);
	int delete(int qnaNo);
	List<QnaVO> select(PageCriteria c);
   	int getTotalNumsOfRecords();
   	List<QnaVO> select(String userid);
   	List<QnaVO> selectByTitleOrContent(String keyword);
   	int updateReplyCount(int amount, int qnaNo);
}

