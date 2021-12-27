<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.noticeTitle }</title>
</head>
<body>
  <h2>글 보기</h2>
  <div>
    <p>글 번호 : ${vo.noticeNo }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${vo.noticeTitle }"
        readonly="readonly">
    </p>
  </div>
  <div>
    <p>작성자 : ${vo.userid }</p>
    <fmt:formatDate value="${vo.noticeCdate }"
      pattern="yyyy-MM-dd HH:mm:ss" var="noticeCdate" />
    <p>작성일 : ${noticeCdate }</p>

  </div>
  <div>
    <textarea rows="20" cols="120" readonly="readonly">${vo.noticeContent }</textarea>
  </div>
  <div>
    <a href="list?page=${page }"><input type="button" value="글 목록"></a>

    <c:if test="${sessionScope.userid == 'admin'}">
      <a href="update?noticeNo=${vo.noticeNo }&page=${page}"> <input
        type="button" value="글 수정"></a>
    </c:if>

    <c:if test="${sessionScope.userid == 'admin'}">
      <a href="delete?noticeNo=${vo.noticeNo }"><input type="button"
        value="글 삭제"></a>
    </c:if>
    
  </div>
</body>
</html>
