package edu.spring.ex06.service;

import java.util.List;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;



// CRUD (CREATE(INSERT), READ(SELECT) , UPDATE , DELETE)

public interface NoticeService {
	public abstract int create(NoticeVO vo);
	public abstract List<NoticeVO> read(PageCriteria criteria);
	public abstract NoticeVO read(int noticeNo);
	public abstract int update(NoticeVO vo);
	public abstract int delete(int noticeNo);
	public abstract int getTotalNumsOfRecords();

}
