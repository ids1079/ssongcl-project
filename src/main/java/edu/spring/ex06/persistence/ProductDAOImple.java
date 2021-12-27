package edu.spring.ex06.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex06.domain.ProductVO;

@Repository //@Component
//- 영속 계층(Persistence Layer)의 DB관련 기능을 담당
//- Spring Component bean으로 등록함
//- 스프링 프레임워크가 bean을 생성하기 위해서는
//root-context.xml에 bean으로 등록해야 함
//-<context:component-scan .../>

public class ProductDAOImple implements ProductDAO{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(ProductDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.ex06.ProductMapper";
	
	
	//MyBatis의 SqlSession을 사용하기 위해서
		//스프링 프레임워크가 생성한 bean을 주입(injection)받음
		@Autowired
		private SqlSession sqlSession;


		@Override
		public int insert(ProductVO vo) {
			LOGGER.info("insert()호출");
			return sqlSession.insert(NAMESPACE + ".insert", vo);
		}


		@Override
		public List<ProductVO> select() {
			LOGGER.info("select() 호출");
			return sqlSession.selectList(NAMESPACE + ".select_all");
		}


		@Override
		public ProductVO select(int productNo) {
			LOGGER.info("select()호출:productNo=" + productNo);
			return sqlSession.selectOne(NAMESPACE + ".select_by_product_no",productNo);
		}


		@Override
		public int update(ProductVO vo) {
			LOGGER.info("update() 호출 + vo = " + vo.toString());
		      return sqlSession.update(NAMESPACE + ".update", vo);
		}


		@Override
		public int delete(int productNo) {
			LOGGER.info("delete()호출 + productNo = " + productNo);
			return sqlSession.delete(NAMESPACE + ".delete", productNo);
		}


		@Override
		public int getTotalNumsOfRecords() {
			LOGGER.info("getToalNumOfRecords() 호출");
			return sqlSession.selectOne(NAMESPACE + ".total_count");
		}
		
		
}






































