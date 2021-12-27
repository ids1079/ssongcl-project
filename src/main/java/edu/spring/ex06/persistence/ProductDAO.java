package edu.spring.ex06.persistence;

import java.util.List;

import edu.spring.ex06.domain.ProductVO;

public interface ProductDAO {
	// 상품 등록
	public abstract int insert(ProductVO vo);

	// 상품 전체 리스트 검색
	public abstract List<ProductVO> select();

	// 상품 한개에 대한 상세 정보 검색
	public abstract ProductVO select(int productNo);

	// 상품 한개에 대한 정보 수정 - 이름, 전화번호, 이메일
	public abstract int update(ProductVO vo);

	// 상품 한개에 대한 정보 삭제
	public abstract int delete(int productNo);

	// 
	int getTotalNumsOfRecords();

}
