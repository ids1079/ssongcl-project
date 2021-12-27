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

import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.persistence.QnaDAO;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class QnaDAOTest {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(QnaDAOTest.class);
	
	@Autowired
	private QnaDAO dao;
	
	@Test
	public void testDAO() {
		testInsert();
	//testSelectAll();
		//testSelectByQnaNo();
//		testUpdate();
//		testDelete();
		//testSelectPaging();
		//testSelectSearch();
	}







	private void testInsert() {
		QnaVO vo = new QnaVO(0, "아;", "oh", "admin", null);
		int result = dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert성공");
		}else {
			LOGGER.info("insert실패");
		}
		
	}

	private void testSelectAll() {
		List<QnaVO> list = dao.select();
		for(QnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}
	
	private void testSelectByQnaNo() {
		QnaVO vo = dao.select(1);
		LOGGER.info(vo.toString());
	}
	
	
	private void testUpdate() {
		QnaVO vo = new QnaVO(4, "변경", "변경", null, null);
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
		List<QnaVO> list = dao.select(c);
		for(QnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
	}

	private void testSelectSearch() {
		List<QnaVO> list = dao.selectByTitleOrContent("es");
		for(QnaVO vo : list) {
			LOGGER.info(vo.toString());
		}
		
	}

	
}

















