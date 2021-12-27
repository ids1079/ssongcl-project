package edu.spring.ex06.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex06.domain.QnaReplyVO;
import edu.spring.ex06.domain.QnaVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.pageutil.PageMaker;
import edu.spring.ex06.service.QnaReplyService;
import edu.spring.ex06.service.QnaService;



@Controller
@RequestMapping(value="/qna") // URL :
public class QnaController {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(QnaController.class);
	
	

	@Autowired
	QnaReplyService qnareplyservice;
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		LOGGER.info("list() 호출");
		LOGGER.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<QnaVO> list = qnaService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(qnaService.getTotalNumsOfRecords());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	} // end list()
	
	@GetMapping("/register")
	public void registerGET() {
		LOGGER.info("registerGET() 호출");
	} // end registerGET()
	
	
	@PostMapping("/register")
	public String registerPOST(QnaVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 재경로 위치에 속성값을 전송하는 객체
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		int result = qnaService.create(vo);
		LOGGER.info(result + "행 삽입");
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/qna/list"; // /board/list 경로로 이동. get방식
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/qna/register"; // /board/list 경로로 이동. get방식
		}
	} // end registerPOST()
	
	
	
	
	@GetMapping("/detail")
	public void detail(Model model, Integer qnaNo, Integer page) throws Exception {
		LOGGER.info("detail() 호출 : qnaNo = " + qnaNo);
		QnaVO vo = qnaService.read(qnaNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
		List<QnaReplyVO> list = qnareplyservice.select_all_by_qna_no(0);
		model.addAttribute("list",list);
		return;
		
	} // end detail()
	
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer qnaNo, Integer page) {
		LOGGER.info("updateGET() 호출 : qnaNo = " + qnaNo);
		QnaVO vo = qnaService.read(qnaNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET
	
	@PostMapping("/update")
	public String updatePUT(QnaVO vo, Integer page) {
		LOGGER.info("updatePUT() 호출 : qnaNo = " + vo.getQnaNo());
		int result = qnaService.update(vo);
		if(result == 1) {
			return "redirect:/qna/list?page=" + page;
		} else {
			return "redirect:/qna/update?qnaNo=" + vo.getQnaNo();
		}
	} // end updatePUT()
	
	@GetMapping("/delete")
	public String delete(Integer qnaNo) {
		LOGGER.info("delete() 호출 : qnaNo =" + qnaNo);
		int result = qnaService.delete(qnaNo);
		if(result == 1) {
			return "redirect:/qna/list";
		} else {
			return "redirect:/qna/list";
		}
	}
	
} // end BoardController









