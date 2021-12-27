<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.productName }</title>
<style type="text/css">

.select_img img{margin:20px 0;}
</style>
</head>
<body>
  <h2>상품 수정</h2>
  <form action="update" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>상품 번호 : ${vo.productNo }</p>
      <input type="hidden" name="productNo" value="${vo.productNo }">
    </div>
    <div>
      <p>
      상품이름 <input type="text" name=productName value="${vo.productName }">
      </p>
    </div>
    <div>
      <p>  상품가격 <input type="text" name=productPrice value="${vo.productPrice }">
      
    </div>
    <div class="inputArea">
 <label for="productImg">이미지</label>
 <input type="file" id="productImg" name="file" onchange="readURL(this);" >
<br /><br />
<img id="preview"  width="340" height="300"/>
 <div class="select_img">
  <img src="/ex06/resources/${vo.productImg}" width="340" height="300">
  <input type="hidden" name="productImg" value="${vo.productImg}" />
  <input type="hidden" name="productThumbimg" value="${vo.productThumbimg}" /> 
  
 </div>
  <input type="submit" value="수정">
  
 <script>
    function readURL(input) {
        if (input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            document.getElementById('preview').src = e.target.result;
          };
          reader.readAsDataURL(input.files[0]);
        } else {
          document.getElementById('preview').src = "";
        }
      }
 </script>
     <%=request.getRealPath("/") %>
</div>
  </form>
  
  
  
  
</body>
</html>