package edu.spring.ex06.domain;

import java.util.Date;

public class QnaVO {
	private  int qnaNo;
	private String qnaTitle;
	private String qnaContent;
	private String userid;
	private Date qnaCdate;
	
	public QnaVO() {}
	

	public QnaVO(int qnaNo, String qnaTitle, String qnaContent, String userid, Date qnaCdate) {
		super();
		this.qnaNo = qnaNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.userid = userid;
		this.qnaCdate = qnaCdate;
	}


	public  int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getQnaCdate() {
		return qnaCdate;
	}

	public void setQnaCdate(Date qnaCdate) {
		this.qnaCdate = qnaCdate;
	}

	@Override
	public String toString() {
		return "QnaVO [qnaNo=" + qnaNo + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", userid=" + userid
				+ ", qnaCdate=" + qnaCdate + "]";
	}
	
	
	


}
