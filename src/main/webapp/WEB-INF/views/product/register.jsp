<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>키에에!</title>
</head>
<body>
<h3>상품 등록</h3>
<form action="register"
method="POST" enctype="multipart/form-data">
<p>상품명 : <input type="text" name="productName" />
</p><p>가&nbsp;&nbsp;&nbsp;&nbsp;격 :
<input type="text" name="productPrice" /></p>

 <h2>이미지 업로드</h2>
   
 <div class="inputArea">
 <label for="productImg">이미지</label>
 <input type="file" id="productImg" name="file" onchange="readURL(this);" >
<br /><br />
<img id="preview"  width="340" height="300"/>
 <div class="select_img"><img src="" /></div>
 <input type="submit" value="업로드">
      
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