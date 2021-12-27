package edu.spring.ex06.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;

@Repository //@Component
// - 영속 계층(Persistence Layer)의 DB관련 기능을 담당
// - Spring Component bean으로 등록함
// - 스프링 프레임워크가 bean을 생성하기 위해서는
// root-context.xml에 bean으로 등록해야 함
// -<context:component-scan .../>
public class NoticeDAOImple implements NoticeDAO {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(NoticeDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.ex06.NoticeMapper";
	
	//MyBatis의 SqlSession을 사용하기 위해서
	//스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;
	
	
	
	

	@Override
	public int insert(NoticeVO vo) {
		LOGGER.info("insert()호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
		
	}

	@Override
	public List<NoticeVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public NoticeVO select(int noticeNo) {
		LOGGER.info("select()호출:noticeNo=" + noticeNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_notice_no",noticeNo);
	}

	 @Override
	   public int update(NoticeVO vo) {
	      LOGGER.info("update() 호출 + vo = " + vo.toString());
	      return sqlSession.update(NAMESPACE + ".update", vo);
	   }

	@Override
	public int delete(int noticeNo) {
		LOGGER.info("delete()호출 + noticeNo = " + noticeNo);
		return sqlSession.delete(NAMESPACE + ".delete", noticeNo);
	}

	@Override
	public List<NoticeVO> select(PageCriteria c) {
		LOGGER.info("select()호출 + PageCriteria = " + c );
		return sqlSession.selectList(NAMESPACE + ".paging",c);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getTotalNumsOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<NoticeVO> select(String userid) {
		LOGGER.info("select() 호출 + userid = " + userid );
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid" , userid);
	}

	@Override
	public List<NoticeVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("select() 호출 + keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_notice_title_notice_content",keyword);
	}
	

}
