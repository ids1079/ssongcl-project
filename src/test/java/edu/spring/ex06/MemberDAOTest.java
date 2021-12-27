package edu.spring.ex06;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex06.domain.MemberVO;
import edu.spring.ex06.persistence.MemberDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class MemberDAOTest {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testDAO() throws Exception {
		testInsert();
	}



	private void testInsert() throws Exception {
		MemberVO vo = new MemberVO("test", "1234", "test", "ttt", "test@naver.com");
		int result = dao.insertMember(vo);
		if(result == 1) {
			LOGGER.info("insert성공");
		}else {
			LOGGER.info("insert실패");
		}
		
	}

}
