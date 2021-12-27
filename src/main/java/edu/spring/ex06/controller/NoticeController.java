package edu.spring.ex06.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex06.domain.NoticeVO;
import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.pageutil.PageMaker;
import edu.spring.ex06.service.NoticeService;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	private static final Logger LOGGER=
			LoggerFactory.getLogger(NoticeController.class);
	
	
	@Autowired
	private NoticeService noticeService;
		
	@GetMapping("/list")
	public void list(Model model,Integer page,Integer numsPerPage) {
		LOGGER.info("list()호출");
		LOGGER.info("page = " + page + ", numsPerPage=" + numsPerPage);
		
		//Paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page !=null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<NoticeVO> list = noticeService.read(criteria);
		model.addAttribute("list" , list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(noticeService.getTotalNumsOfRecords());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	}//end list()
	
	@GetMapping("/register")
	public void registerGET() {
		LOGGER.info("registerGET() 호출");
	}//end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(NoticeVO vo, RedirectAttributes reAttr) {
		//RedirectAttributes
		//- 재경로 위치에 속성값을 전송하는 객체
		
		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		int result = noticeService.create(vo);
		LOGGER.info(result + "행 삽입");
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result","success");
			return "redirect:/notice/list"; // board/list 경로로 이동. get방식
		}else {
			reAttr.addFlashAttribute("insert_result","fail");
			return "redirect:/notice/register"; // board/register 경로로 이동. get방식
		}
	}//end registerPOST()
	
	@GetMapping("/detail")
	public void detail(Model model, Integer noticeNo, Integer page) {
		LOGGER.info("detail()호출: noticeNo=" + noticeNo);
		NoticeVO vo = noticeService.read(noticeNo);
		model.addAttribute("vo",vo);
		model.addAttribute("page",page);
	}
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer noticeNo, Integer page) {
		LOGGER.info("updateGET()호출 : noticeNo = " + noticeNo);
		NoticeVO vo = noticeService.read(noticeNo);
		model.addAttribute("vo",vo);
		model.addAttribute("page",page);
	}
	
	@PostMapping("/update")
	public String updatePUT(NoticeVO vo, Integer page,RedirectAttributes reAttr) {
		LOGGER.info("updatePUT()호출 : noticeNo = " + vo.getNoticeNo());
		int result = noticeService.update(vo);
		if(result==1) {
			reAttr.addFlashAttribute("update_result","success");
			return "redirect:/notice/list?page=" + page;
		}else {
			reAttr.addFlashAttribute("update_result","fail");
			return "redirect:notice/update?noticeNo=" + vo.getNoticeNo();
		}
	}
	
	@GetMapping("/delete")
	public String delete(Integer noticeNo,RedirectAttributes reAttr) {
		LOGGER.info("delete()호출 : noticeNo = " + noticeNo);
		int result = noticeService.delete(noticeNo);
		if(result==1) {
			reAttr.addFlashAttribute("delete_result","success");
			return "redirect:/notice/list";
		}else {
			reAttr.addFlashAttribute("delete_result","success");
			return "redirect:/notice/list";
		}
	}
}// end BoardController