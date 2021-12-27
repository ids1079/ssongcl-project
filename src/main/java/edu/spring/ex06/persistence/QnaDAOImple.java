package edu.spring.ex06.persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.pageutil.PageCriteria;



// - 영속 계층(Persistence Layer)의 DB 관련 기능을 담당
// - Spring Component bean으로 등록함
// - 스르링 프레임워크가 bean을 생성하기 위해서는
//   root-context.xml에 bean으로 등록해야 함
// - <context:component-scan ... />
@Repository
public class QnaDAOImple implements QnaDAO{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(QnaDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex06.QnaMapper";
	
	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection) 받음
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(QnaVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	@Override
	public List<QnaVO> select() {
		LOGGER.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}
	@Override
	public QnaVO select(int qnaNo) {
		LOGGER.info("select() 호출 : qnaNo = " + qnaNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_qna_no", qnaNo);
	}
	@Override
	public int update(QnaVO vo) {
		LOGGER.info("update() 호출 + vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
	@Override
	public int delete(int qnaNo) {
		LOGGER.info("delete() 호출 + qnaNo = " + qnaNo);
		return sqlSession.delete(NAMESPACE + ".delete", qnaNo);
	}
	@Override
	public List<QnaVO> select(PageCriteria c) {
		LOGGER.info("select() 호출 + PageCriteria = " + c);
		return sqlSession.selectList(NAMESPACE + ".paging", c);
	}
	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("getToalNumOfRecords() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}
	@Override
	public List<QnaVO> select(String userid) {
		LOGGER.info("select() 호출 + userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
	}
	@Override
	public List<QnaVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("select() 호출 + keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	}
	
	@Override
	public int updateReplyCount(int amount, int qnaNo) {
		// 따로따로 있는 걸 같이 사용할 경우 map을 사용함 Map<key(이름), value(값)> 
		// 모든 걸 다 잡을 수 있는 키워드 : object(하지만 범위 너무 넒음)
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("qnaNo", qnaNo);
		
		return sqlSession.update(NAMESPACE + ".update_reply_count", args);
	}
	
}













