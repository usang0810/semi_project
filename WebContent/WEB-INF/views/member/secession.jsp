<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../css/mypage-delete-member.css">
<style>
#container {
	margin: 200px 0 100px 0;
	text-align: center;
	height: 1000px;
}

.jumbotron {
	height: 85%;
}

.textarea-title {
	font-size: 1.2em;
	float: left;
}

.textarea-content {
	width: 100% !important;
	height: 500px !important;
	background-color: #ffffff !important;
	resize: none !important;
}

#confirm-btn {
	width: 10%;
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
            회원탈퇴
          </p>
          <div class="jumbotron">
            <form method="POST" action="#" onsubmit="return validate();">
              <label class="control-label ml-1 mb-5 textarea-title">회원 탈퇴 약관</label>
              <textarea class="form-control mb-5 form-control input-comment textarea-content" readonly>
  제1조
  이 약관은 샘플 약관입니다.
  
  ① 약관 내용 1
  
  ② 약관 내용 2
  
  ③ 약관 내용 3
  
  ④ 약관 내용 4
  
  
  제2조
  이 약관은 샘플 약관입니다.
  
  ① 약관 내용 1
  
  ② 약관 내용 2
  
  ③ 약관 내용 3
  
  ④ 약관 내용 4
                </textarea>
              <div>
                <input type="checkbox" id="check-secession" name="check-secession">
                <label for="check-secession">정말 탈퇴하시겠습니까?</label>
              </div>
              <button class="btn mt-3 form-control orange-btn" id="confirm-btn" name="confirm-btn"
                type="submit">확인</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="../common/footer.jsp"%>
  
  <script>
    function validate() {
      if (!$("#check-secession").prop("checked")) {
        alert("약관에 동의해주세요.");
        return false;
      } else {
        return confirm("정말 탈퇴하시겠습니까?");
      }
    }
  </script>

</body>

</html>