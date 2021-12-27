package edu.spring.ex06;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.persistence.NoticeDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class NoticeDAOTest {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(NoticeDAOTest.class);
	
	@Autowired
	private NoticeDAO dao;
	
	@Test
	public void testDAO() {
		testInsert();
	//testSelectAll();
		//testSelectByNoticeNo();
//		testUpdate();
//		testDelete();
		//testSelectPaging();
		//testSelectSearch();
	}







	private void testInsert() {
		NoticeVO vo = new NoticeVO(0, "안녕ㄹ", "oh", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert성공");
		}else {
			LOGGER.info("insert실패");
		}
		
	}

	private void testSelectAll() {
		List<NoticeVO> list = dao.select();
		for(NoticeVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	private void testSelectByNoticeNo() {
		NoticeVO vo = dao.select(1);
		LOGGER.info(vo.toString());
	}
	
	
	private void testUpdate() {
		NoticeVO vo = new NoticeVO(4, "변경", "변경", null, null);
		int result = dao.update(vo);
		if(result==1) {
			LOGGER.info("update 성공");
		}else {
			LOGGER.info("update 실패");
		}		
	}

	private void testDelete() {
		int result = dao.delete(3);
		LOGGER.info(result + "행 삭제");
	}
	

	private void testSelectPaging() {
		PageCriteria c = new PageCriteria(1, 5);
		List<NoticeVO> list = dao.select(c);
		for(NoticeVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}

	private void testSelectSearch() {
		List<NoticeVO> list = dao.selectByTitleOrContent("es");
		for(NoticeVO vo : list) {
			LOGGER.info(vo.toString());
		}
		
	}

	
}

















