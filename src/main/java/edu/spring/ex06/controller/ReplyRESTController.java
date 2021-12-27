package edu.spring.ex06.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex06.domain.QnaReplyVO;
import edu.spring.ex06.service.QnaReplyService;


/// replies
// /replies (POST) : 댓글 추가(insert)
// /replies/all/숫자 (GET) : 해당 글번호(replyBno)의 모든 댓글 검색(select)
// /replies/숫자 (PUT) : 해당 댓글 번호(replyNo)의 내용을 수정(update)
// /replies/숫자 (DELETE) : 해당 댓글 번호(replyNo)의 댓글을 삭제(delete)

@RestController
@RequestMapping(value = "/qna/replies") // /replies
public class ReplyRESTController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReplyRESTController.class);

	@Autowired
	private QnaReplyService qnareplyservice;

	@PostMapping // POST : 댓글 입력, /replies (POST) : 댓글 추가(insert)
	public ResponseEntity<Integer> createReply(@RequestBody QnaReplyVO vo) {
		
		// @RequestBody
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		LOGGER.info(vo.toString());
		int result = 0;

		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		// - 데이터와 HttpStatus[EX) 400 505 등 등 ]를 전송
		// - <T> : 보내고자 하는 데이터 타입
		// ResponseEntity<Integer> 돌려주기 위한 객체 타입

		try {
			result = qnareplyservice.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);

	} // end createReply()

	@GetMapping("/all/{qnaNo}") // GET : 댓글 선택(all), /replies/all/숫자 (GET) : 해당 글번호(replyBno)의 모든 댓글 검색(select)
	public ResponseEntity<List<QnaReplyVO>> readReplies(@PathVariable("qnaNo") int qnaNo) throws Exception { // front에서 보낸 객체, 받는 구간
		// ResponseEntity<T>의 타입은 JSON을 받으니까 String이니까 그것도 가능하지만,
		// List<ReplyVO>가 더 직관적이라 정답이다
		// @PathVariable("replyBno") : /all/{replyBno}값을 설정된 변수에 저장

		List<QnaReplyVO> list = qnareplyservice.select_all_by_qna_no(qnaNo);// front로 돌려주는 구간
		return new ResponseEntity<List<QnaReplyVO>>(list, HttpStatus.OK);
	} // end readReplies()

	@PutMapping("/{replyNo}") // PUT : 댓글 수정 /replies/숫자 (PUT) : 해당 댓글 번호(replyNo)의 내용을 수정(update)
	public ResponseEntity<String> updateReply(@PathVariable("replyNo") int replyNo, @RequestBody QnaReplyVO vo) // front에서
																												// 보낸
																												// 객체,
																												// 받는 구간
	{
		vo.setReplyNo(replyNo); // 내용 변경 구간
		int result = qnareplyservice.update(vo);
		if (result == 1) { // front로 돌려주는 구간
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fall", HttpStatus.OK);
		}

	} // end updateReply()

	@DeleteMapping("{replyNo}") // DELETE : 댓글 삭제
	public ResponseEntity<String> deleteReply(
			@PathVariable("replyNo") int replyNo, 
			@RequestBody QnaReplyVO vo) { // front에서
		
		
		try {
			qnareplyservice.delete(replyNo, vo.getReplyNo());
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		} // 내용 삭제 구간
		
	} // end deleteReply()

} // end ReplyRESTController















