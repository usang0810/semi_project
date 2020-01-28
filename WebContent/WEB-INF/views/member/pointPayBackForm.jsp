<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage-point-payback.css">

  <title>온스터디</title>

</head>
 
<body>
<%@ include file="../common/loginedHeader.jsp"%>
<%
	String bankName = "";
	switch(loginMember.getBankCode()){
	case 0: bankName = "없음"; break;
	case 1: bankName = "국민"; break;
	case 2: bankName = "신한"; break;
	case 3: bankName = "농협"; break;
	case 4: bankName = "우리"; break;
	}
%>

  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            포인트 관리
          </p>
          <div class="jumbotron">
            <p class="mypage-point-payback-title">포인트 환급</p>
            <form method="POST" action="pointPayBack" class="point-charge" name="point-charge" onsubmit="return validate()">
              <label for="amount-of-money" class="amount-of-money-label">환급받을 금액</label>
              <input type="number" id="amount-of-money" class="form-control input-comment" min="1000" step="1000"
                placeholder="금액을 1000원 단위로 입력해주세요." name="pointPayBack" required autofocus>

              <button class="btn btn-md form-control orange-hover-btn 10-thousand-won" type="button" value="10000"
                style="width:24%">1만원</button>
              <button class="btn btn-md form-control orange-hover-btn 30-thousand-won" type="button" value="30000"
                style="width:24%">3만원</button>
              <button class="btn btn-md form-control orange-hover-btn 50-thousand-won" type="button" value="50000"
                style="width:24%">5만원</button>
              <button class="btn btn-md form-control orange-hover-btn 100-thousand-won" type="button" value="100000"
                style="width:24%">10만원</button>
              <div class="payback-account">
                <label for="amount-of-money" class="mb-1 amount-of-money-label">환급받을 계좌 선택</label>
                <select class="form-control input-comment select-account">
                  <option value=""></option>
                  <option class="account-1"><%=bankName %> <%=loginMember.getMemberAccount() %></option>
                </select>
                <br><br>
                <p class="account-precautions"><i class="fa fa-exclamation-circle exclamation-icon"></i>본인 명의의 계좌만
                  가능합니다.</p>
              </div>
              <div class="payback-confirm">
                <button class="btn btn-lg form-control orange-hover-btn payback-confirm-btn" type="submit">신청하기</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
    $(function () {
      $(".10-thousand-won").on({
        "click": function () {
          $("#amount-of-money").val($(this).val());
        }
      });
      $(".30-thousand-won").on({
        "click": function () {
          $("#amount-of-money").val($(this).val());
        }
      });
      $(".50-thousand-won").on({
        "click": function () {
          $("#amount-of-money").val($(this).val());
        }
      });
      $(".100-thousand-won").on({
        "click": function () {
          $("#amount-of-money").val($(this).val());
        }
      });
    });
    
    <%-- 포인트 유효성 검사 --%>
    function validate(){
    	var memberPoint = <%=loginMember.getMemberPoint() %>;
    	
    	if(memberPoint < $("#amount-of-money").val()){
    		alert("보유 포인트보다 많은 금액은 환급할 수 없습니다.");
    		
    		return false;
    		
    	}else{
    		return true;
    	}
    }

  </script>

  <%@ include file="../common/footer.jsp" %>
</body>

</html>