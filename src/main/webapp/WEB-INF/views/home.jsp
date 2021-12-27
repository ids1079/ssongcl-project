<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<meta content="IE=edge" http-equiv="X-UA-Compatible">
<meta content="width=device-width,initial-scale=1" name="viewport">
<meta content="description" name="description">
<meta name="google" content="notranslate">
<meta content="Mashup templates have been developped by Orson.io team"
  name="author">
<meta name="msapplication-tap-highlight" content="no">
<script type="text/javascript" src="resources/main.faaf51f9.js"></script>

<link href="resources/assets/apple-touch-icon.png"
  rel="apple-touch-icon">
<link href="resources/assets/favicon.ico" rel="icon">
<title>쏭클 메인 홈페이지</title>
<link href="resources/main.97292821.css" rel="stylesheet">
<style>
.customoverlay {
  position: relative;
  bottom: 85px;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  float: left;
}

.customoverlay:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}

.customoverlay a {
  display: block;
  text-decoration: none;
  color: #000;
  text-align: center;
  border-radius: 6px;
  font-size: 14px;
  font-weight: bold;
  overflow: hidden;
  background: #d95050;
  background: #d95050
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}

.customoverlay .title {
  display: block;
  text-align: center;
  background: #fff;
  margin-right: 35px;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
}

.customoverlay:after {
  content: '';
  position: absolute;
  margin-left: -12px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background:
    url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}
</style>
<script type="text/javascript">
  $(function(){
      var login_result ='${login_result}' || '';
      if(login_result != ''){
          alert('로그인 성공');
          
      }
  })
</script>

</head>
<body>

  <header class="main_menu">
    <script type="text/javascript" src="resources/main.faaf51f9.js"></script>
    <div class="main_menu_iner">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-lg-12">

            <nav
              class="navbar navbar-expand-lg navbar-center justify-content-between">

              <div class="navbar-collapse">
                <ul class="nav navbar-nav navbar-center">

                  <li><a href=""><img
                      src="resources/assets/images/ssongclmen.jpg"
                      width="60" height="40"></a>
                  <li><a href="" class="btn btn-default navbar-btn">홈페이지</a></li>

                  <li><a href="introduce/process"
                    class="btn btn-default navbar-btn">과정소개</a></li>

                  <li><a href="introduce/teacher"
                    class="btn btn-default navbar-btn">강사소개</a></li>

                  <li><a href="video/music"
                    class="btn btn-default navbar-btn">쏭영상</a></li>

                  <li><a href="notice/list"
                    class="btn btn-default navbar-btn">공지사항</a></li>

                  <li><a href="qna/list"
                    class="btn btn-default navbar-btn">Q & A</a></li>
                    
                    <li><a href="product/list"
                    class="btn btn-default navbar-btn">상 품</a></li>  
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                <li>
                <audio src="resources/doll.mp3" controls autoplay></audio>
                </li>
                  <c:if test="${empty userid }">
                    <li><a href="member/login"
                      class="btn btn-default navbar-btn">로그인</a></li>
                  </c:if>
                  <c:if test="${not empty userid }">
                    <li><a href="member/logout"
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
  <!-- Add your site or app content here -->
  <div class="background-image-container black-text-container"
    style="background-image: url('resources/assets/images/ssonclass-logo.jpg')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h1>SSong Class</h1>
          <p style= "font-size:20px;">THE BEST PLACE FOR SING TOGETHER</p>
          
            <div id="kakao-talk-channel-chat-button"
              data-channel-public-id="_xfVxjdb" data-title="consult"
              data-size="large" data-color="yellow" data-shape="pc"
              data-support-multiple-densities="true"></div>
        </div>
      </div>
    </div>
  </div>

  <div class="section-container">
    <div class="container">
      <div class="row">
        <div class="col-xs-10 col-md-12 section-container-spacer">
          <h2 class="text-center">SSongcl Academy Adress</h2>
        </div>
      </div>
    </div>
  </div>


    <div class="container contact-form-container">
      <div class="row">
        <div class="col-xs-12 col-md-offset-0 col-md-8">
          <div class="section-container-spacer">
            <div id="map" style="width: 1200px; height: 400px;">
              <script type="text/javascript"
                src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0f3ca9ee55c335c2eeca74a2951c8f8e"></script>
              <script>
                                                            var mapContainer = document
                                                                    .getElementById('map'), // 지도를 표시할 div 
                                                            mapOption = {
                                                                center : new kakao.maps.LatLng(
                                                                        37.56966365635728,
                                                                        126.82708627528723), // 지도의 중심좌표
                                                                level : 4
                                                            // 지도의 확대 레벨
                                                            };

                                                            var map = new kakao.maps.Map(
                                                                    mapContainer,
                                                                    mapOption);

                                                            // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
                                                            var markerPosition = new kakao.maps.LatLng(
                                                                    37.56966365635728,
                                                                    126.82708627528723); // 마커가 표시될 위치입니다

                                                            // 마커를 생성합니다
                                                            var marker = new kakao.maps.Marker(
                                                                    {
                                                                        position : markerPosition,
                                                                    });

                                                            // 마커가 지도 위에 표시되도록 설정합니다
                                                            marker.setMap(map);

                                                            // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                            var content = '<div class="customoverlay">'
                                                                    + '  <a href="http://kko.to/tBsHutEfM" target="_blank">'
                                                                    + '    <span class="title">쏭클보컬피티샵 마곡나루본점</span>'
                                                                    + '  </a>'
                                                                    + '</div>';

                                                            // 커스텀 오버레이가 표시될 위치입니다 
                                                            var position = new kakao.maps.LatLng(
                                                                    37.56966365635728,
                                                                    126.82708627528723);

                                                            // 커스텀 오버레이를 생성합니다
                                                            var customOverlay = new kakao.maps.CustomOverlay(
                                                                    {
                                                                        map : map,
                                                                        position : position,
                                                                        content : content,
                                                                        yAnchor : 1
                                                                    });
                                                        </script>
            </div>
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

<script>
  window.kakaoAsyncInit = function() {
    Kakao.Channel.createChatButton({
      container: '#kakao-talk-channel-chat-button',
    });
  };

  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = 'https://developers.kakao.com/sdk/js/kakao.channel.min.js';
    fjs.parentNode.insertBefore(js, fjs);
  })(document, 'script', 'kakao-js-sdk');
</script>
</html>