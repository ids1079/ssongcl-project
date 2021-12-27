package edu.spring.ex06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex06.domain.MemberVO;
import edu.spring.ex06.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
   @Autowired
   private MemberService service;

   private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

   @GetMapping("/insert")
   public String insertGet() throws Exception {
      logger.info("insertGet() 호출");
      return "/member/insert";
   }

   @PostMapping("/insert")
   public String insertPost(MemberVO vo, RedirectAttributes reAttr) throws Exception {
      logger.info("insertPost() 호출");
      logger.info(vo.toString());
      int result = service.insertMember(vo);
      if (result == 1) {
         reAttr.addFlashAttribute("insert_result", "success");
         return "redirect:/member/login";
      } else {
         reAttr.addFlashAttribute("insert_result", "fail");
         return "redirect:/member/insert";
      }
   }
   
   @PostMapping("/idChk")
   @ResponseBody
   public String idChkPost(String userid) throws Exception{
      logger.info("idChkPost() 호출");
      int result = service.idChk(userid);
      logger.info("결과값 = " + result);
      if(result != 0) {
         return "fail"; //아이디 존재
      } else {
         return "success"; //아이디 생성 가능
      }
   }

   @GetMapping("/login")
   public void loginGet() {
      logger.info("loginGet() 호출");
   }

   @PostMapping("/login")
   public String loginPost(MemberVO vo, HttpSession session, RedirectAttributes reAttr) throws Exception {
      logger.info("loginPost() 호출");
      MemberVO returnVO = service.loginMember(vo);
      System.out.println(vo.toString());
      if (returnVO != null) {
         session.setAttribute("userid", returnVO.getUserid());
         reAttr.addFlashAttribute("login_result", "success");
         return "redirect:/";

      } else {
         reAttr.addFlashAttribute("login_result", "fail");
         return "redirect:/member/login";
      }
   }

   @GetMapping("/logout")
   public String logout(HttpServletRequest request) {
      logger.info("logout() 호출");

      HttpSession session = request.getSession();
      session.removeAttribute("userid");

      return "redirect:/";

   }
}