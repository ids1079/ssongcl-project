package edu.spring.ex06.service;

import java.util.List;

import edu.spring.ex06.domain.ProductVO;
import edu.spring.ex06.pageutil.PageCriteria;

// CRUD (CREATE(INSERT), READ(SELECT) , UPDATE , DELETE)


public interface ProductService {
	public abstract int create(ProductVO vo);
	public abstract List<ProductVO> read(PageCriteria criteria);
	public abstract ProductVO read(int ProductNo);
	public abstract int update(ProductVO vo);
	public abstract int delete(int ProductNo);
	public abstract int getTotalNumsOfRecords();
	
	
	
	

}
