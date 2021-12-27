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

import edu.spring.ex06.domain.ProductVO;
import edu.spring.ex06.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class ProductDAOTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductDAOTest.class);

	@Autowired
	private ProductDAO dao;

	@Test
	public void testDAO() {
		testInsert();
//		testSelectAll();
//		testSelectByProductNo();
//		testUpdate();
//		testDelete();
	}

	private void testDelete() {
		int result = dao.delete(3);
		LOGGER.info(result + "행 삭제");
	}

	private void testUpdate() {
		ProductVO vo = new ProductVO(3, "변경", 500,null,null);
		int result = dao.update(vo);
		if(result==1) {
			LOGGER.info("update 성공");
		}else {
			LOGGER.info("update 실패");
		}		
		
	}

	private void testSelectByProductNo() {
		ProductVO vo = dao.select(3);
		LOGGER.info(vo.toString());
	}

	private void testSelectAll() {
		List<ProductVO> list = dao.select();
		for(ProductVO vo : list) {
			LOGGER.info(vo.toString());
		}
		
	}

	private void testInsert() {
		ProductVO vo = new ProductVO(0, "1개월", 500,null,null);
		int result =dao.insert(vo);
		if(result == 1) {
			LOGGER.info("insert성공");
		}else {
			LOGGER.info("insert실패");
		}
		
	}

}
