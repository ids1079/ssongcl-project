<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<
style
>
@media print {
  .gm-style .gmnoprint, .gmnoprint {
    display: none
  }
}

@media screen {
  .gm-style .gmnoscreen, .gmnoscreen {
    display: none
  }
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">

<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width,initial-scale=1" name="viewport">
<meta content="description" name="description">
<meta name="google" content="notranslate">
<meta content="Mashup templates have been developped by Orson.io team"
  name="author">
<meta name="msapplication-tap-highlight" content="no">
<link href="../resources/assets/apple-touch-icon.png"
  rel="apple-touch-icon">
<link href="../resources/assets/favicon.ico" rel="icon">
<title>쏭클 쏭영상 페이지</title>
<link href="../resources/main.97292821.css" rel="stylesheet">


</head>
<body>

  <header class="main_menu">

    <div class="main_menu_iner">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-12">
            <nav
              class="navbar navbar-expand-lg navbar-center justify-content-between">

              <div class="navbar-collapse">
                <ul class="nav navbar-nav navbar-center">

                  <li><a href="../"><img
                      src="../resources/assets/images/ssongclmen.jpg"
                      width="60" height="40"></a>
                  <li><a href="../"
                    class="btn btn-default navbar-btn">홈페이지</a></li>

                  <li><a href="../introduce/process"
                    class="btn btn-default navbar-btn">과정소개</a></li>

                  <li><a href="../introduce/teacher"
                    class="btn btn-default navbar-btn">강사소개</a></li>

                  <li><a href="" class="btn btn-default navbar-btn">쏭영상</a></li>

                  <li><a href="../notice/list"
                    class="btn btn-default navbar-btn">공지사항</a></li>

                  <li><a href="../qna/list"
                    class="btn btn-default navbar-btn">Q & A</a></li>
                
                  <li><a href="../product/list"
                    class="btn btn-default navbar-btn">상 품</a>
                  </li>
                  
                </ul>
                <ul class="nav navbar-nav navbar-right">
                <li>
                <audio src="../resources/doll.mp3" controls></audio>
                </li>
                  <c:if test="${empty userid }">
                    <li><a href="../member/login"
                      class="btn btn-default navbar-btn">로그인</a></li>
                  </c:if>
                  <c:if test="${not empty userid }">
                    <li><a href="../member/logout"
                      class="btn btn-default navbar-btn">로그아웃</a></li>
                  </c:if>
                </ul>
              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </header>
  <div class="background-image-container black-text-container"
    style="background-image: url('../resources/assets/images/ssonclass-logo.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>SSong Class</h1>
          <br>
          <p style= "font-size:20px; font-family:'배달의민족 도현'";>쏭 영상</p>
        </div>
      </div>
    </div>
  </div>

  <br>
  <br>
    <div class="container">
      <div class="row">
        <div class="col-xs-10 col-md-12 section-container-spacer">
          <h2 class="text-center" style= "font-size:40px; font-family:'배달의민족 도현'";><수강생 영상></h2>
        </div>
      </div>
    </div>
 

  <div class="container contact-form-container">
    <div class="row">
      <div class="col-xs-12 col-md-offset-2 col-md-8">
        <div class="section-container-spacer">
          <iframe width="800" height="360"
            src="https://www.youtube.com/embed/CRQ7a38FkmA"
            title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen> </iframe>
        </div>
      </div>
    </div>
  </div>

  <div class="container contact-form-container">
    <div class="row">
      <div class="col-xs-12 col-md-offset-2 col-md-8">
        <div class="section-container-spacer">
          <iframe width="800" height="360"
            src="https://www.youtube.com/embed/oLmb3Z-VJ6E"
            title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen> </iframe>
        </div>
      </div>
    </div>
  </div>


  <div class="section-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-10 col-md-12 section-container-spacer">
          <h2 class="text-center" style= "font-size:40px; font-family:'배달의민족 도현'";><수강생 후기 영상></h2>
        </div>
      </div>
    </div>
  </div>

  <div class="container contact-form-container">
    <div class="row">
      <div class="col-xs-12 col-md-offset-2 col-md-8">
        <div class="section-container-spacer">
          <iframe width="800" height="360"
            src="https://www.youtube.com/embed/AenFravHxUM"
            title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen> </iframe>
        </div>
      </div>
    </div>
  </div>

  <div class="container contact-form-container">
    <div class="row">
      <div class="col-xs-12 col-md-offset-2 col-md-8">
        <div class="section-container-spacer">
          <iframe width="800" height="360"
            src="https://www.youtube.com/embed/xphgaSgmnh0"
            title="YouTube video player" frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen> </iframe>
        </div>
      </div>
    </div>
  </div>

 <footer class="footer-container white-text-container">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <h4>About us</h4>
            <p>주소: 서울 강서구 마곡동 290-3 두산더랜드파크 D동 306호</p>
            <p>전화번호: 010-3539-1467</p>
            <p>instagram: ssoncl_vocal</p>
          </div>

          <div class="col-md-6">
            <h4>Do you like ? Share this instagram & youtube!</h4>
            <div>
              <p>
                <a href="https://www.instagram.com/ssongcl_vocal/"
                  class="fa-icon" title="" target="_blank"> <i
                  class="fa fa-instagram" aria-hidden="true"></i>
                </a> <a href="https://www.youtube.com/channel/UCraGLznq0tjiPkGDsJgIeBA"
                  class="fa-icon" title="" target="_blank">
                  <i class="fa fa-youtube" aria-hidden="true"></i>
                </a>
            </p>
          </div>
          
        </div>
      </div>
    </div>
  </footer>
</body>
</html>