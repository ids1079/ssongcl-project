<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.qnaTitle }</title>
</head>
<body>
  <h2>글 보기</h2>
  <div>
    <p>글 번호 : ${vo.qnaNo }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${vo.qnaTitle }" readonly="readonly">
    </p>
  </div>
  <div>
    <p>작성자 : ${vo.userid }</p>
    <p>작성일 : ${vo.qnaCdate }</p>

  </div>
  <div>
    <textarea rows="20" cols="120" readonly="readonly">${vo.qnaContent }</textarea>
  </div>
  <div>
    <a href="list?page=${page }"><input type="button" value="글 목록"></a>
    <c:if test="${sessionScope.userid == vo.userid}">
    <a href="update?qnaNo=${vo.qnaNo }&page=${page}"><input type="button" value="글 수정"></a>
    <a href="delete?qnaNo=${vo.qnaNo }"><input type="button" value="글 삭제"></a>
  </c:if>
  </div>
  <hr>
  <c:if test="${empty sessionScope.userid }">
    *댓글은 로그인이 필요한 서비스 입니다.
    <a href ="/ex06/member/login">로그인하기</a>
  </c:if>
  <c:if test="${not empty sessionScope.userid }">
      ${sessionScope.userid }님, 이제 댓글을 작성할 수 있어요!
  </c:if>
  
  <div style="text-align: center">
    <div>
      <input type="hidden" id="qnaNo" value="${vo.qnaNo }"> 
      <c:if test="${not empty sessionScope.userid }">
          <input type="text" id="userid" value ="${sessionScope.userid }" readonly>          
          <input type="text" id="replyContent">
          <button type="button" id="btn_add">작성</button>
     </c:if>
    </div>
  </div>
  <hr>
  <div style="text-align: center;">
    <div id ="replies"></div>
  </div>
  <div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
  </div>

  <script type="text/javascript">
     $(document).ready(function(){
         var qnaNo = $('#qnaNo').val(); // 게시판 번호 값
         getAllReplies();
         
         
         
         
         
         
         $('#btn_add').click(function(){// btn_add 버튼을 누르면 
         
             var replyContent = $('#replyContent').val(); // 댓글 내용
             var userid = $('#userid').val(); // 댓글 작성자 아이디
             var obj = {
                     'qnaNo' : qnaNo,
                     'replyContent' : replyContent,
                     'userid' : userid
             };// end obj{}
             
             var JSONObj = JSON.stringify(obj);
             // $.ajax로 송수신
             $.ajax({
                 type : 'post', 
                 url :  'replies',
                 headers : {
                     'Content-Type' : 'application/json',
                     'X-HTTP-Method-Override' : 'POST'
                 },
                 data : JSONObj, // {obj : JSON.stringify(obj)},  JSON으로 변환. 자바스크립트 객체를 문자열(JSON)으로 변환.
                 success : function(result, status){
                     console.log(result);
                     console.log(status);
                     if(result == 1) {
                         alert('댓글 입력 성공');
                         getAllReplies();  
                         // ↑ function getAllReplies
                     }// end if문
                 } // end function()
             }); // end $.ajax()
         }); // end btn_add.click()
         
         
         
         
         
         
         
         
         
         
         
         
         
      // 게시판의 댓글 전체 가져오기 
         function getAllReplies() {
             var url = 'replies/all/' + qnaNo; // 현재 게시판 번호. all < selectAll
             $.getJSON( // 알아서 parse 해줌.
               url,
                     function(jsonData) {
                         // jsonDate : 서버에서 온 list 데이터가 저장되어 있음
                         console.log(jsonData);
                     	var replyWriter = $('#userid').val(); //로그인 한 사용자 아이디
                        var list = ''; // JSON 데이터를 표현할 문자열 변수
                        // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
                        $(jsonData).each(function(){
                            // this : 컬렉션에서 각 데이터를 꺼내서 저장
                            console.log(this);
                        
                           var replyCdate = new Date(this.replyCdate);
                           var disabled = 'disabled';
                           var readonly = 'readonly';
                           if(replyWriter == this.userid) {
                               disabled = ' ' ;
                               readonly = ' '
                           }
                           
                           list += '<div class="reply_item"'
                              + '<pre>'
                              + '<input type="hidden" id="replyNo" value="'+ this.replyNo +'" />'
                              + '<input type="hidden" id="userid" value="'+ this.userid +'" />'
                              + this.userid
                              + '&nbsp;&nbsp;' // 공백
                              + '<input type="text" id="replyContent" value="'+ this.replyContent +'" '+ readonly +'/>'
                              + '&nbsp;&nbsp;'
                              + replyCdate
                              + '&nbsp;&nbsp;'          
                              + '<button class="btn_update" type="button" '+disabled+'>수정</button>'
                              + '<button class="btn_delete" type="button"  '+disabled+'>삭제</button>'      
                              + '</pre>'
                              + '</diV>';
                        }); // end each()
                        $('#replies').html(list);
                     }
             
             ); // end getJSON()
             
         } // end getAllReplies()
         
         
         
         
         
         
         
         
         
         
         // 수정 버튼을 클릭하면 선택된 댓글 수정
         $('#replies').on('click', '.reply_item .btn_update', function(){
             console.log(this);
             
             // 선택된 댓글 replyNo, replyContent 값을 저장
             // prevAll() : 선택된 노드의 이전 모든 형제의 노드
             var replyNo = $(this).prevAll('#replyNo').val();
             var replyContent = $(this).prevAll('#replyContent').val();
             console.log("선택된 댓글 번호 : " + replyNo + ", 댓글 내용 : " + replyContent);
             
             // ajax 요청
             $.ajax({
                 type : 'put',
                 url : 'replies/' + replyNo,
                 data : JSON.stringify({ 
                     'qnaNo' : qnaNo,
                     'replyContent' : replyContent
                 }),
                 headers : {
                     'Content-Type' : 'application/json',
                     'X-HTTP-Method-Override' : 'PUT'
                 },
                 success : function(result){
                     if(result == 'success'){
                         alert('댓글 수정 성공!');
                         getAllReplies();
                     } // end if문
                  }//end function
              }); // end $.ajax()
              }); // replies.on()
         
              
              
              
              
              
              
              
              
              
              
              
              
         // 삭제 버튼을 클릭하면 선택된 댓글 삭제
         $('#replies').on('click', '.reply_item .btn_delete', function(){
             console.log(this);
           
             // 선택된 댓글 replyNo, replyContent 값을 저장
             // prevAll() : 선택된 노드의 이전 모드 형제의 노드
             var replyNo = $(this).prevAll('#replyNo').val();
             console.log("선택된 댓글 번호 : " + replyNo);
             
          // ajax [삭제]요청
             $.ajax({
                 type : 'delete',
                 url : 'replies/' + replyNo,
                 data : JSON.stringify({
                     'qnaNo' : qnaNo
                 }),
                 headers : {
                     'Content-Type' : 'application/json',
                     'X-HTTP-Method-Override' : 'DELETE'
                 },
                 success : function(result){
                     if(result == 'success'){
                         alert('댓글 삭제 성공!');
                         getAllReplies();
                     } // end if문
                 }//end function
                 
            }); // end $.ajax()
           }); // replies.on()
           
           
           
           
           
           
           
           
          }); // end documnet
  </script>
</body>
</html>







