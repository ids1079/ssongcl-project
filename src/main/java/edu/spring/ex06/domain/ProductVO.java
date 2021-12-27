package edu.spring.ex06.domain;

public class ProductVO {
	// 멤버 변수(필드, 프로퍼티)
		private int productNo; //상품번호
		private String productName; // 상품이름
		private int productPrice; // 상품가격
		private String productImg; // 상품이미지
		private String productThumbimg; //상품 썸네일 이미지

		// 기본 생성자
		public ProductVO() {}

		public ProductVO(int productNo, String productName, int productPrice, String productImg,
				String productThumbimg) {
			super();
			this.productNo = productNo;
			this.productName = productName;
			this.productPrice = productPrice;
			this.productImg = productImg;
			this.productThumbimg = productThumbimg;
		}

		public int getProductNo() {
			return productNo;
		}

		public void setProductNo(int productNo) {
			this.productNo = productNo;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}

		public String getProductImg() {
			return productImg;
		}

		public void setProductImg(String product_Img) {
			this.productImg = product_Img;
		}

		public String getProductThumbimg() {
			return productThumbimg;
		}

		public void setProductThumbimg(String productThumbimg) {
			this.productThumbimg = productThumbimg;
		}

		@Override
		public String toString() {
			return "ProductVO [productNo=" + productNo + ", productName=" + productName + ", productPrice="
					+ productPrice + ", productImg=" + productImg + ", productThumbimg=" + productThumbimg + "]";
		}
		

		
}
		