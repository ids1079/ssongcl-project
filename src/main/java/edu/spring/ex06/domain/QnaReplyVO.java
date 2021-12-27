package edu.spring.ex06.domain;

import java.util.Date;

public class QnaReplyVO {
		private int qnaNo; //게시글번호
		private int replyNo; 	//댓글번호
		private String replyContent; // 댓글 내용
		private String userid; // 댓글 작성자 아이디
		private Date replyCdate; // 댓글 작성/수정 시간
		
		public QnaReplyVO() {}

		public QnaReplyVO(int qnaNo, int replyNo, String replyContent, String userid, Date replyCdate) {
			super();
			this.qnaNo = qnaNo;
			this.replyNo = replyNo;
			this.replyContent = replyContent;
			this.userid = userid;
			this.replyCdate = replyCdate;
		}

		public int getQnaNo() {
			return qnaNo;
		}

		public void setQnaNo(int qnaNo) {
			this.qnaNo = qnaNo;
		}

		public int getReplyNo() {
			return replyNo;
		}

		public void setReplyNo(int replyNo) {
			this.replyNo = replyNo;
		}

		public String getReplyContent() {
			return replyContent;
		}

		public void setReplyContent(String replyContent) {
			this.replyContent = replyContent;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public Date getReplyCdate() {
			return replyCdate;
		}

		public void setReplyCdate(Date replyCdate) {
			this.replyCdate = replyCdate;
		}

		@Override
		public String toString() {
			return "QnaReplyVO [qnaNo=" + qnaNo + ", replyNo=" + replyNo + ", replyContent=" + replyContent
					+ ", userid=" + userid + ", replyCdate=" + replyCdate + "]";
		}
		
		
		
}
		
		