package edu.spring.ex06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.persistence.NoticeDAO;



@Service //@Component
// * 서비스 계층(Service/Business layer)
// - 표현 계층(Presentation layer)과  영속 계층 (Persistence layer) 사이를 연결하여
// 두 계층이 직접적으로 통신하지 않도록 하는 역할
// - 트랜잭션(tranjaction) 관리
// *- DB와 상관없이 데이터를 처리 가능 * 
public class NoticeServiceImple implements NoticeService {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(NoticeServiceImple.class);
	@Autowired
	private NoticeDAO dao;
	
	@Override
	public int create(NoticeVO vo) {
		LOGGER.info("create()호출 : vo=" + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<NoticeVO> read(PageCriteria criteria) {
		LOGGER.info("read()호출 : PageCriteria=" + criteria);
		return dao.select(criteria);
	}

	@Override
	public NoticeVO read(int noticeNo) {
		LOGGER.info("read()호출 : noticeNo = " + noticeNo);
		return dao.select(noticeNo);
	}

	@Override
	public int update(NoticeVO vo) {
		LOGGER.info("update()호출 : vo=" + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int noticeNo) {
		LOGGER.info("delete()호출 : noticeNo = " + noticeNo);
		return dao.delete(noticeNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords()호출");
		return dao.getTotalNumsOfRecords();
	}

}
