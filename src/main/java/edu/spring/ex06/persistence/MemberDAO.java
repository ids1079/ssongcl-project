package edu.spring.ex06.persistence;

import edu.spring.ex06.domain.MemberVO;

public interface MemberDAO {
	// 회원등록
	public int insertMember(MemberVO vo) throws Exception;
	
	// DB에 저장된 회원 정보 조회
	public MemberVO readMemberWithIDPW(String userid, String password) throws Exception;
	
	
	// 아이디 중복확인
	   public int idChk(String userid);
}