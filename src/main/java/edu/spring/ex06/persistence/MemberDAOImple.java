package edu.spring.ex06.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex06.domain.MemberVO;
import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;

@Repository //@Component
// - 영속 계층(Persistence Layer)의 DB관련 기능을 담당
// - Spring Component bean으로 등록함
// - 스프링 프레임워크가 bean을 생성하기 위해서는
// root-context.xml에 bean으로 등록해야 함
// -<context:component-scan .../>
public class MemberDAOImple implements MemberDAO {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MemberDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.ex06.MemberMapper";
	
	//MyBatis의 SqlSession을 사용하기 위해서
	//스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertMember(MemberVO vo) {
		return sqlSession.insert(NAMESPACE+".insertMember", vo);
	}

	@Override
	public MemberVO readMemberWithIDPW(String userid, String password) throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("password", password);
		
		return sqlSession.selectOne(NAMESPACE+".readMemberWithIDPW", paramMap);
		
	}
	
	@Override
	   public int idChk(String userid) {
	      return sqlSession.selectOne(NAMESPACE+".idChk", userid);
	   }


}
