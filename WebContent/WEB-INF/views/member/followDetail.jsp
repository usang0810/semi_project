<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage-follow.css">

  <title>온스터디</title>
 
</head>

<body>
  <%@ include file="../common/loginedHeader.jsp"%>

  <div id="container" style="color:#333333;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <p class="content-title">
            팔로우 관리
          </p>
          <div class="jumbotron">
            <div class="col-md-6 p-1 following-list">
              <p class="following-list-title">Following<span class="mr-2 following-count" style="float:right;">4</span>
              </p>
              <div class="col-md-12 pt-3 pb-3 mt-0 following-list-content">
                <ul>
                  <li class="id-list" name="id"><img src="<%=request.getContextPath() %>/images/navi-icon-default.png">
                    아이디1
                    <div class="fa fa-window-close follow-cancle-btn">
                    </div>
                  </li>
                  <li class="id-list" name="id"><img src="<%=request.getContextPath() %>/images/navi-icon-default.png">
                    아이디2
                    <div class="fa fa-window-close follow-cancle-btn">
                    </div>
                  </li>
                  <li class="id-list" name="id"><img src="<%=request.getContextPath() %>/images/navi-icon-default.png">
                    아이디3
                    <div class="fa fa-window-close follow-cancle-btn">
                    </div>
                  </li>
                  <li class="id-list" name="id"><img src="<%=request.getContextPath() %>/images/navi-icon-default.png">
                    아이디4
                    <div class="fa fa-window-close follow-cancle-btn">
                    </div>
                  </li>
                </ul>
              </div>
            </div>
            <div class="col-md-6 p-1 follower-list">
              <p class="follower-list-title">Follower<span class="mr-2 follower-count" style="float:right;">8</span></p>
              <div class="col-md-12 pt-3 pb-3 mt-0 following-list-content">
                <ul>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                  <li><img src="<%=request.getContextPath() %>/images/navi-icon-default.png"> 아이디</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    $(function () {
      $(".follow-cancle-btn").on({
        "click": function () {
          var result = confirm('팔로우를 취소하시겠습니까?');
          if (result) {
            $(this).parent().detach();
          }
        }
      });
    });
  </script>

  <%@ include file="../common/footer.jsp"%>
</body>

</html>