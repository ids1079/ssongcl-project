<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
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
<link href="../resources/assets/apple-touch-icon.png"
  rel="apple-touch-icon">
<link href="../resources/assets/favicon.ico" rel="icon">
<title>쏭클 회원가입 페이지</title>
<link href="../resources/main.97292821.css" rel="stylesheet">
<style type="text/css">
.id_input_re_1 {
  color: green;
  display: none;
}

.id_input_re_2 {
  color: red;
  display: none;
}

.final_id_chk {
  color: red;
  display: none;
}

.final_pw_chk {
  color: red;
  display: none;
}

.final_name_chk {
  color: red;
  display: none;
}

.final_nickname_chk {
  color: red;
  display: none;
}

.final_email_chk {
  color: red;
  display: none;
}
.id_input_warn {
  color: red;
  display: none;
}
.password_input_warn {
  color: red;
  display: none;
}
.name_input_warn {
  color: red;
  display: none;
}
.email_input_warn {
  color: red;
  display: none;
}
</style>
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

                  <li><a href="../video/music"
                    class="btn btn-default navbar-btn">쏭영상</a></li>

                  <li><a href="../notice/list"
                    class="btn btn-default navbar-btn">공지사항</a></li>

                  <li><a href="../qna/list"
                    class="btn btn-default navbar-btn">Q & A</a></li>
                </ul>

              </div>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </header>

  <div class="col-xs-12">
    <h1>SSong Class</h1>
  </div>
<body>
  <div class="col-md-12">
    <h2 style= "font-size:40px; font-family:'배달의민족 도현'";><회원가입></h2>
  </div>

 <form action="" id="insert_form" method="post">
    아이디 : <input type="text" name="userid" class="id_input" placeholder="(영 소문자, 숫자 4~20자리)" />
    <span class="id_input_re_1">중복되지 않는 아이디입니다.</span>
    <span class="id_input_re_2">사용 중인 아이디입니다.</span>
    <span class="id_input_warn">영 소문자, 숫자 4~20자리로 입력해주세요.</span> 
    <span class="final_id_chk">아이디를 입력해주세요.</span>
    <br>
    비밀번호 : <input type="password" name="password" class="pw_input" style="width:250px;" placeholder="(영문, 숫자, 특수문자 10~20자리)" />
    <span class="password_input_warn">영문, 숫자, 특수문자 10~20자리인지 확인해주세요.</span>
    <span class="final_pw_chk">비밀번호를입력해주세요.</span> 
    <br> 
    이름 : <input type="text" name="username" class="name_input" placeholder="(한글 이름 2~4자)" /> 
    <span class="name_input_warn">한글 이름 2~4자 인지 확인해주세요.</span> 
    <span class="final_name_chk">이름을 입력해주세요.</span> 
    
    <br> 
    닉네임 : <input type="text" name="nickname" class="nickname_input" placeholder="닉네임 입력" /> 
      <span class="final_nickname_chk">닉네임을 입력해주세요.</span> 
      <br> 
      이메일 : <input type="text" name="email" class="email_input" placeholder="ex)abc@naver.com" /> 
      <span class="email_input_warn">올바르지 않은 이메일 형식입니다. ex)abc@naver.com</span>
      <span class="final_email_chk">이메일을 입력해주세요.</span> 
      <br> 
      <br> 
      <input type="button" class="insert_button" value="회원가입" /> 
      <input type="button" onClick="location.href='../member/login'" value="취소" />
  </form>

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

  <script>
            /* 유효성 검사 통과유무 변수 */
            var idCheck = false;
            var idChkCheck = false;
            var pwCheck = false;
            var nameCheck = false;
            var nicknameCheck = false;
            var emailCheck = false;

            $(document).ready(function() {//회원가입 버튼(회원가입 기능 작동)

                                /* 회원가입버튼 입력시 */
                                $(".insert_button").click(function() {
                                                    /* 입력값 변수 */
                                                    var id = $('.id_input')
                                                            .val();
                                                    var pw = $('.pw_input')
                                                            .val();
                                                    var name = $('.name_input')
                                                            .val();
                                                    var nickname = $(
                                                            '.nickname_input')
                                                            .val();
                                                    var email = $(
                                                            '.email_input')
                                                            .val();
                                                    var idregex = /^[a-z0-9]{4,20}$/;
                                                    
                                                    var passwordregex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,20}$/;
                                                    
                                                    var nameregex = /^[가-힣]{2,4}$/;
                                                    
                                                    var emailregex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

                                                    /* 아이디 유효성 검사 */
                                                    if (id == "") {
                                                        $('.final_id_chk').css(
                                                                'display',
                                                                'block');
                                                        idCheck = false;
                                                    } else if (idregex
                                                            .test(id) == false) {
                                                        $('.id_input_warn')
                                                        .css('display',
                                                                'block');
                                                    } /* else if (idregex
                                                            .test(id) == true) {
                                                        $('.id_input_warn')
                                                        .css('display',
                                                                'none');
                                                    } */else {
                                                        $('.final_id_chk').css(
                                                                'display',
                                                                'none');
                                                        idCheck = true;
                                                    }

                                                    /* 비밀번호 */
                                                    if (pw == "") {
                                                        $('.final_pw_chk').css(
                                                                'display',
                                                                'block');
                                                        pwCheck = false;
                                                    } else if (passwordregex
                                                            .test(pw) == false) {
                                                        $('.password_input_warn')
                                                        .css('display',
                                                                'block');
                                                    } /* else if (passwordregex
                                                            .test(pw) == true) {
                                                        $('.password_input_warn')
                                                        .css('display',
                                                                'none');
                                                    } */else {
                                                        $('.final_pw_chk').css(
                                                                'display',
                                                                'none');
                                                        pwCheck = true;
                                                    }

                                                    /* 이름 */
                                                    if (name == "") {
                                                        $('.final_name_chk')
                                                                .css('display',
                                                                        'block');
                                                        nameCheck = false;
                                                    } else if (nameregex
                                                            .test(name) == false) {
                                                        $('.name_input_warn')
                                                        .css('display',
                                                                'block');
                                                    } /* else if (nameregex
                                                            .test(name) == true) {
                                                        $('.name_input_warn')
                                                        .css('display',
                                                                'none');
                                                    }  */else {
                                                        $('.final_name_chk')
                                                                .css('display',
                                                                        'none');
                                                        nameCheck = true;
                                                    }

                                                    /* 닉네임 */
                                                    if (nickname == "") {
                                                        $('.final_nickname_chk')
                                                                .css('display',
                                                                        'block');
                                                        nicknameCheck = false;
                                                    } else {
                                                        $('.final_nickname_chk')
                                                                .css('display',
                                                                        'none');
                                                        nicknameCheck = true;
                                                    }

                                                    /* 이메일 */
                                                    if (email == "") {
                                                        $('.final_email_chk')
                                                                .css('display',
                                                                        'block');
                                                        emailCheck = false;
                                                    } else if (emailregex
                                                            .test(email) == false) {
                                                        $('.email_input_warn')
                                                        .css('display',
                                                                'block');
                                                    }/* else if (emailregex
                                                            .test(email) == true) {
                                                        $('.email_input_warn')
                                                        .css('display',
                                                                'none'); 
                                                    }*/ else {
                                                        $('.final_email_chk')
                                                                .css('display',
                                                                        'none');
                                                        emailCheck = true;
                                                    }

                                                    if (idCheck && idChkCheck
                                                            && pwCheck
                                                            && nameCheck
                                                            && nicknameCheck
                                                            && emailCheck) {
                                                        $("#insert_form")
                                                                .attr("action",
                                                                        "../member/insert");
                                                        $("#insert_form")
                                                                .submit(); 
                                                    }
                                                });
                            });
        </script>
  <script>
            $('.id_input').on(
                    "propertychange change keyup paste input",
                    function() {
                        var userid = $('.id_input').val(); // .id_input에 입력되는 값
                        var data = {
                            userid : userid
                        } // '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'

                        $.ajax({
                            type : "post",
                            url : "../member/idChk",
                            data : data,
                            success : function(result) {
                               // 사용 가능한 아이디
                                if (result != 'fail') {
                                    $('.id_input_re_1').css("display",
                                            "inline-block");
                                    $('.id_input_re_2').css("display", "none");
                                    idChkCheck = true;
                                } else {
                                    $('.id_input_re_2').css("display",
                                            "inline-block");
                                    $('.id_input_re_1').css("display", "none");
                                    idChkCheck = false;
                                }
                            }
                        }); // ajax 종료

                    });
        </script>


</body>
</html>