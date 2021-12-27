package edu.spring.ex06.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex06.domain.ProductVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.persistence.ProductDAO;




@Service //@Component
//* 서비스 계층(Service/Business layer)
//- 표현 계층(Presentation layer)과  영속 계층 (Persistence layer) 사이를 연결하여
//두 계층이 직접적으로 통신하지 않도록 하는 역할
//- 트랜잭션(tranjaction) 관리
//*- DB와 상관없이 데이터를 처리 가능 * 


public class ProductServiceImple implements ProductService {
	private static final Logger LOGGER = 
	         LoggerFactory.getLogger(ProductServiceImple.class);
	
	@Autowired
	private ProductDAO dao;

	@Override
	public int create(ProductVO vo) {
		LOGGER.info("create()호출 : vo=" + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<ProductVO> read(PageCriteria criteria) {
		LOGGER.info("read()호출 : PageCriteria=" + criteria);
		return dao.select();
	}

	@Override
	public ProductVO read(int ProductNo) {
		LOGGER.info("read()호출 : ProductNo = " + ProductNo);
		return dao.select(ProductNo);
	}

	@Override
	public int update(ProductVO vo) {
		LOGGER.info("update()호출 : vo=" + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int ProductNo) {
		LOGGER.info("delete()호출 : ProductNo = " + ProductNo);
		return dao.delete(ProductNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords()호출");
		return dao.getTotalNumsOfRecords();
	}
	
	

	


}
