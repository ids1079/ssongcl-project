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

import edu.spring.ex06.domain.QnaReplyVO;
import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.persistence.QnaReplyDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration

public class QnaReplyDAOTest {
   
   private static final Logger LOGGER = 
         LoggerFactory.getLogger(QnaReplyDAOTest.class);
   
   @Autowired
   private QnaReplyDAO dao;
   
   @Test
   public void testDAO() throws Exception {
	//testInsert();
	//testSelectAll();
   testSelect();
	   //testUpdate();
//	   testDelete();
   } // end testDAO()








private void testInsert() {
	      QnaReplyVO vo = new QnaReplyVO(18, 0, "내용", "아이디", null);
	      int result = dao.insert(vo);
	      LOGGER.info(result + "행 삽입");
   } // testInsert()
   
   
private void testSelect() throws Exception {
    List<QnaReplyVO> list =dao.select_all_by_qna_no(0);
    LOGGER.info(list.size() + "");
    for(QnaReplyVO vo : list) {
       LOGGER.info(vo.toString());
    }
 } //end tsetSelect()
 
   
   private void testUpdate() {
	   QnaReplyVO vo = new QnaReplyVO(0, 0, "d", "d", null);
	   
   }
   

	private void testDelete() {
		int result = dao.delete(1);
		LOGGER.info(result + "행 삭제");
		
	}
	
	
} // end BoardDAOTest{}