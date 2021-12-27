package edu.spring.ex06.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.spring.ex06.domain.ProductVO;

import edu.spring.ex06.pageutil.PageCriteria;
import edu.spring.ex06.pageutil.PageMaker;
import edu.spring.ex06.service.ProductService;

import edu.spring.ex06.util.UploadFileUtils;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	

	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("list() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// Paging 처리
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<ProductVO> list = service.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.getTotalNumsOfRecords());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	} // end list()
	
	
	@GetMapping("/register")
	public String insertGet() throws Exception {
		logger.info("insertGet() 호출");
		return "/product/register";
	}
	
	@PostMapping("/register")
	public String registerPOST(ProductVO vo,MultipartFile file, RedirectAttributes reAttr) throws Exception {
		logger.info("uploadPost()호출");
		logger.info("파일 이름: " + file.getOriginalFilename());
		logger.info("파일 크기 : " +file.getSize());
		
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		String savedName= file.getOriginalFilename();
		String savedFile = saveUploadFile(file);
		logger.info("저장된 파일 이름 : " + savedFile);
		File target = new File(uploadPath,savedName);
		
		if(file != null) {
			fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);	
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setProductImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setProductThumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
				
		service.create(vo);
		
		return "redirect:/product/list";
	
		
	
		
		
		
	}// end registerPOST()
	
	
	
	


	private String saveUploadFile(MultipartFile file) {
		//UUID : 업로드하는 파일 이름이 중복되지 않도록
				UUID uuid = UUID.randomUUID();
				String savedName = uuid + "_" + file.getOriginalFilename();
				File target = new File(uploadPath, savedName);
				
				try {
					FileCopyUtils.copy(file.getBytes(), target);
					logger.info("파일 저장 성공");
					return savedName;
				} catch (IOException e) {
					logger.error("파일 저장 실패");
					return null;
				}
			}


	@GetMapping("/detail")
	public void detail(Model model, Integer productNo, Integer page) throws Exception {
		logger.info("detail() 호출 : qnaNo = " + productNo);
		ProductVO vo = service.read(productNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
	} // end detail()
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer productNo, Integer page) {
		logger.info("updateGET() 호출 : productNo = " + productNo);
		ProductVO vo = service.read(productNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET
	
	@PostMapping("/update")
	public String updatePUT(ProductVO vo,MultipartFile file,HttpServletRequest req, Integer page) throws IOException, Exception {
		logger.info("updatePUT() 호출 : productNo = " + vo.getProductNo());
		 // 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("productImg")).delete();
		  new File(uploadPath + req.getParameter("productThumbimg")).delete();
		// 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  
		  vo.setProductImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  vo.setProductThumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		 } else {  // 새로운 파일이 등록되지 않았다면
			  // 기존 이미지를 그대로 사용
			  vo.setProductImg(req.getParameter("productImg"));
			  vo.setProductThumbimg(req.getParameter("productThumbimg"));
			  
			 }
			 
			 service.update(vo);
			 
			 return "redirect:/product/list";
			
	} // end updatePUT()
	
	@GetMapping("/delete")
	public String delete(Integer productNo) {
		logger.info("delete() 호출 : productNo =" + productNo);
		int result = service.delete(productNo);
		if(result == 1) {
			return "redirect:/product/list";
		} else {
			return "redirect:/product/list";
		}
	}// end delete()
	

}













