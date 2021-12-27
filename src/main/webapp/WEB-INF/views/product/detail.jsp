<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.inputArea{margin:10px 0;}
.oriImg{ width:500px; height:auto;}
.thumbImg{}



</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>${vo.productName }</title>
</head>
<body>
  <h2>상품 보기</h2>
  <div>
    <p>상품 번호 : ${vo.productNo }</p>
  </div>
  <div>
    <p>
      상품이름 <input type="text" value="${vo.productName }" readonly="readonly">
    </p>
  </div>
  <div>
    <p>상품가격 : ${vo.productPrice }</p>
    
  </div>
  <div>
   <div class="inputArea">

 <img src="/ex06/resources/${vo.productImg}" width="340" height="300">
 
</div>
  </div>
  <div>
    <a href="list?page=${page }"><input type="button" value="상품 목록"></a>
     <c:if test="${sessionScope.userid == 'admin'}">
    <a href="update?productNo=${vo.productNo }&page=${page}"><input type="button" value="상품 수정"></a>
    </c:if>
     <c:if test="${sessionScope.userid == 'admin'}">
    <a href="delete?productNo=${vo.productNo }"><input type="button" value="상품 삭제"></a>
    </c:if>
     
   
    <button type="button" class="pay_button" name="kakaoPay" ><img src="../resources/assets/images/카카오페이.png" alt="" height="14" width="55"></button>
  
    
    
  </div>
  <script type="text/javascript">
  $(function(){
      $('.pay_button').click(function(){
          $.ajax({
              type: "post",
              url:'../kakao/pay',
              dataType:'json',
              success:function(data){
                  var box =data.next_redirect_pc_url;
                  window.open(box);
              } ,
              error:function(error){
                  alert(error);
              }
          });
      });
  });
  </script>
</body>
</html>






