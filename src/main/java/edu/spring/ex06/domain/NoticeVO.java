package edu.spring.ex06.domain;

import java.util.Date;

public class NoticeVO {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String userid;
	private Date noticeCdate;
	
	public NoticeVO() {}

	public NoticeVO(int noticeNo, String noticeTitle, String noticeContent, String userid, Date noticeCdate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userid = userid;
		this.noticeCdate = noticeCdate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getNoticeCdate() {
		return noticeCdate;
	}

	public void setNoticeCdate(Date noticeCdate) {
		this.noticeCdate = noticeCdate;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", userid=" + userid + ", noticeCdate=" + noticeCdate + "]";
	}
	
	
	
}

	