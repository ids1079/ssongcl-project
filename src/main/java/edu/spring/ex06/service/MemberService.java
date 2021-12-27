package edu.spring.ex06.service;

import edu.spring.ex06.domain.MemberVO;




// CRUD (CREATE(INSERT), READ(SELECT) , UPDATE , DELETE)

public interface MemberService {
	
	public int insertMember(MemberVO vo) throws Exception;

	public MemberVO loginMember(MemberVO vo);
	
	public int idChk(String userid) throws Exception;
	}


	

