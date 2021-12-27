package edu.spring.ex06.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex06.domain.MemberVO;
import edu.spring.ex06.persistence.MemberDAO;

@Service // @Component
// * 서비스 계층(Service/Business layer)
// - 표현 계층(Presentation layer)과  영속 계층 (Persistence layer) 사이를 연결하여
// 두 계층이 직접적으로 통신하지 않도록 하는 역할
// - 트랜잭션(tranjaction) 관리
// *- DB와 상관없이 데이터를 처리 가능 * 
public class MemberServiceImple implements MemberService {
   private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImple.class);
   @Autowired
   private MemberDAO dao;

   @Override
   public int insertMember(MemberVO vo) throws Exception {

      return dao.insertMember(vo);

   }

   @Override
   public MemberVO loginMember(MemberVO vo) {
      MemberVO returnVO = null;
      try {
         returnVO = dao.readMemberWithIDPW(vo.getUserid(), vo.getPassword());
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         returnVO = null;
      }
      return returnVO;
   }

   @Override
   public int idChk(String userid) throws Exception {
      return dao.idChk(userid);
   }

}