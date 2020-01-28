<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage-point-charge.css">

  <title>온스터디</title>
   
</head>

<body>
  <%@ include file="../common/loginedHeader.jsp"%>

  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            포인트 관리
          </p>
          <div class="jumbotron">
            <p class="mypage-point-charge-title">포인트 충전</p>
            <form method="POST" action="pointCharge" class="point-charge" name="point-charge">
              <label for="amount-of-money" class="amount-of-money-label">충전할 금액</label>
              <input type="number" id="amount-of-money" class="form-control input-comment" min="1000" step="1000"
                placeholder="금액을 1000원 단위로 입력해주세요." name="pointCharge" required autofocus>
              <button class="btn btn-md form-control orange-hover-btn 10-thousand-won" type="button" value="10000"
                style="width:24%">1만원</button>
              <button class="btn btn-md form-control orange-hover-btn 30-thousand-won" type="button" value="30000"
                style="width:24%">3만원</button>
              <button class="btn btn-md form-control orange-hover-btn 50-thousand-won" type="button" value="50000"
                style="width:24%">5만원</button>
              <button class="btn btn-md form-control orange-hover-btn 100-thousand-won" type="button" value="100000"
                style="width:24%">10만원</button>
              <div class="charge-way">
                <p class="mb-1 mypage-point-charge-way">충전수단</p>
                <button class="btn btn-md mb-5 form-control orange-hover-btn charge-way-btn"
                  type="button">무통장입금</button>
              </div>
              <div class="charge-confirm">
                <button class="btn btn-lg mt-5 form-control orange-hover-btn charge-confirm-btn"
                  type="sumbit">충전하기</button>
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

      $(".charge-way-btn").on({
        "click": function () {
          $(this).css("backgroundColor", "#f15a25").css("color", "#ffffff");
        }
      });
    });
  </script>

  <%@ include file="../common/footer.jsp"%>

</body>

</html>