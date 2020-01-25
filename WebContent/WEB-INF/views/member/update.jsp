<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] phone = ((Member) session.getAttribute("loginMember")).getMemberPhone().split("-");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/mypage-update-member.css">

<style>
#container {
	margin: 200px 0 100px 0;
	text-align: center;
	height: 1000px;
}

.jumbotron {
	height: 90%;
}

.mypage-title {
	text-align: initial;
	margin: 50px 0;
	font-size: 35px;
	border-bottom: 4px solid #212529;
	padding-bottom: 10px;
}

.profile-edit-btn, .profile-edit-btn:hover {
	background-color: #f15a25;
	color: #ffffff;
}

.profile-edit-btn {
	margin-top: 35%;
	width: 50px;
}

#new-pwd1, #new-pwd2, #phone1, #phone2, #phone3, #bank, #account {
	height: 2.2em;
}

select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}
</style>

<title>온스터디</title>

</head>

<body>
  <%@ include file="../common/loginedHeader.jsp"%>
  
  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            회원정보 수정
          </p>
          <div class="row">
            <div class="col-md-7">
              <div class="jumbotron">
                <form method="POST" action="#" onsubmit="return validate();">
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>이름</h6>
                    </div>
                    <div class="col-md-8">
                      <h6 id="name"><%=loginMember.getMemberNm() %></h6>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>아이디</h6>
                    </div>
                    <div class="col-md-8">
                      <h6 id="id"><%=loginMember.getMemberId() %></h6>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>비밀번호</h6>
                    </div>
                    <div class="col-md-8">
                      <input type="password" class="form-control input-comment" id="newPwd1" name="newPwd1"
                        maxlength="12" placeholder="비밀번호를 입력하세요" required>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>비밀번호 확인</h6>
                    </div>
                    <div class="col-md-8">
                      <input type="password" class="form-control input-comment" id="newPwd2" name="newPwd2"
                        maxlength="12" placeholder="비밀번호 확인" required>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>전화번호</h6>
                    </div>
                    <div class="col-md-2">
                      <select class="custom-select form-control input-comment" id="phone1" name="phone1" required>
                        <option>010</option>
                        <option>011</option>
                        <option>016</option>
                        <option>017</option>
                        <option>019</option>
                      </select>
                    </div>
                    
                    <script>
						$.each($("#phone1>option"), function(index, item){
							
							if($(item).text() == "<%= phone[0] %>"){
								$(item).prop("selected", true);
							}
						});
					</script>
                    <div class="col-md-3">
                      <input type="number" class="form-control input-comment phone" id="phone2" name="phone2"
                        maxlength="4" value="<%=phone[1] %>" required>
                    </div>
                    <div class="col-md-3">
                      <input type="number" class="form-control input-comment phone" id="phone3" name="phone3"
                        maxlength="4" value="<%=phone[2] %>" required>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-3">
                      <h6>계좌번호</h6>
                    </div>
                    <div class="col-md-2">
                      <select class="form-control input-comment" id="bank" name="bank" required>
                        <option>신한</option>
                        <option>신한</option>
                        <option>국민</option>
                        <option>농협</option>
                        <option>하나</option>
                        <option>우리</option>
                      </select>
                    </div>
                    <div class="col-md-6">
                      <input type="text" class="form-control input-comment" id="account" name="account">
                    </div>
                  </div>
                  <div>

                    <button class="btn btn-sm mt-5 form-control orange-hover-btn edit-btn" type="submit"
                      style="width:20%">수정</button>
                  </div>
                </form>
              </div>
            </div>
            <div class="col-md-5">
              <div class="jumbotron">
                <div id="profile-wrap">

                  <img class="member-profile" src="<%=request.getContextPath() + profileImagePath %>"
                  		 alt="프로필아이콘" style="width:40%">
                  <label for="upload" id="upBtn"
                    class="btn btn-sm form-control orange-hover-btn profile-edit-btn">수정</label><input type="file"
                    id="upload" accept="image/*">
                </div>
                <div class="profile-sub-list-wrap">
                  <div class="row mt-5 mb-1 form-row">
                    <div class="col-md-5">
                      <h6>포인트</h6>
                    </div>
                    <div class="col-md-6">
                      <h6 id="name"><%=loginMember.getMemberPoint() %> 포인트</h6>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-5">
                      <h6>알람</h6>
                    </div>
                    <div class="col-md-6">
                      <h6 id="name">2개</h6>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-5">
                      <h6>진행중인 온스터디</h6>
                    </div>
                    <div class="col-md-6">
                      <h6 id="name">8/10</h6>
                    </div>
                  </div>
                  <div class="row mb-1 form-row">
                    <div class="col-md-5">
                      <h6>작성한 학습노트</h6>
                    </div>
                    <div class="col-md-6">
                      <h6 id="name">8</h6>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <%@ include file="../common/footer.jsp"%>
  <script>
    $(function () {
      $("#upload").css("display", "none");
      $("#upBtn").css({
        "width": "50px",
        "text-align": "center"
      }).mouseenter(function () {
        $(this).css("cursor", "pointer");
      });
    });

    var formatCheck = {
      "newPwd1": false,
      "newPwd2": false,
      "phone3": false,
    };

    // submit 동작
    function validate() {
      var $newPwd1 = $("#newPwd1");
      var $newPwd2 = $("#newPwd2");
      var $phone2 = $("#phone2");
      var $phone3 = $("#phone3");

      var regExp = /^[A-Za-z0-9]{6,12}$/;
      if (!regExp.test($("#newPwd1").val())) {
        formatCheck.newPwd1 = false;
      } else {
        formatCheck.newPwd1 = true;
      }

      // 새 비밀번호 일치여부 확인
      if ($("#newPwd1").val() != $("#newPwd2").val()) {
        formatCheck.newPwd2 = false;
      } else {
        formatCheck.newPwd2 = true;
      }

      // 전화번호
      $(".phone").on("input", function () {

        // 전화번호 input 태그에 4글자 이상 입력하지 못하게 하는 이벤트
        if ($(this).val().length > $(this).prop("maxLength")) {
          $(this).val($(this).val().slice(0, $(this).prop("maxLength")));
        }
      });

      // 전화번호 유효성 검사
      var regExp1 = /^\d{3,4}$/; // 숫자 3~4 글자
      var regExp2 = /^\d{4,4}$/; // 숫자 4 글자
      if (!regExp1.test($phone2.val()) || !regExp2.test($phone3.val())) {
        formatCheck.phone3 = false;
      } else {
        formatCheck.phone3 = true;
      }

      for (var key in formatCheck) {
        if (!formatCheck[key]) {
          alert("일부 입력값이 잘못되었습니다.");
          var id = "#" + key;
          $(id).focus();
          return false;
        }
      }
    }
  </script>

  
  
</body>

</html>