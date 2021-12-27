package edu.spring.ex06.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex06.domain.QnaReplyVO;


@Repository
public class QnaReplyDAOImple implements QnaReplyDAO{
	private static final Logger LOGGER =
			LoggerFactory.getLogger(QnaReplyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.ex06.ReplyMapper";
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(QnaReplyVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<QnaReplyVO> select_all_by_qna_no(int qnaNo) throws Exception {
		LOGGER.info("select() 호출 : qnaNo = " + qnaNo);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_qna_no", qnaNo);
	}

	@Override
	public int update(QnaReplyVO vo) {
		LOGGER.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int replyNo) {
		LOGGER.info("delete() 호출 : replyNo = " + replyNo);
		return sqlSession.delete(NAMESPACE + ".delete", replyNo);
	}

	

}
