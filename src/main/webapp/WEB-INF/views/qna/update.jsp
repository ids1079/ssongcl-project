<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.qnaTitle }</title>
</head>
<body>
  <h2>글 수정</h2>
  <form action="update" method="POST">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>글 번호 : ${vo.qnaNo }</p>
      <input type="hidden" name="qnaNo" value="${vo.qnaNo }">
    </div>
    <div>
      <p>
      제목 <input type="text" name="qnaTitle" value="${vo.qnaTitle }">
      </p>
    </div>
    <div>
      <p>작성자 : ${vo.userid }</p>
      <fmt:formatDate value="${vo.qnaCdate }" pattern="yyyy-MM-dd HH:mm:ss" var="qnaCdate" />
      <p>작성일 : ${qnaCdate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="qnaContent">${vo.qnaContent }</textarea>
    </div>
    <div>
      <input type="submit" value="제출">
    </div>
  </form>
  
</body>
</html>