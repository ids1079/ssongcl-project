<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>글 작성 페이지</h2>
    <form action="register" method="POST">
        <div>
            <p>제목 :
            <input type="text" name="qnaTitle" placeholder="제목 입력" required>
        </div>
        <div>
            <p>작성자 :
           <input type="text" name="userid" value="${sessionScope.userid }" readonly> 
        </div>
        <div>
            <textarea rows="20" cols="120"  name="qnaContent" placeholder="내용입력" required></textarea>
        </div>
        <div>
            <input type="submit" value="등록">
        </div>
    </form>
</body>
</html>










