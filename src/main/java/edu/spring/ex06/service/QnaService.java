package edu.spring.ex06.service;

import java.util.List;


import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.pageutil.PageCriteria;





// CRUD (CREATE(INSERT), READ(SELECT) , UPDATE , DELETE)

public interface QnaService {
	public abstract int create(QnaVO vo);
	public abstract List<QnaVO> read(PageCriteria criteria);
	public abstract QnaVO read(int qnaNo);
	public abstract int update(QnaVO vo);
	public abstract int delete(int qnaNo);
	public abstract int getTotalNumsOfRecords();

}
