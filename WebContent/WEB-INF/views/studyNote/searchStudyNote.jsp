<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page import="com.semi.studynote.model.vo.StudyNote"%>
<%@page import="java.util.List"%>


console.log(<%=request.getAttribute("likeDetail")%>);
console.log("dtd");
<%

List<StudyNote> snlist = (List<StudyNote>)request.getAttribute("snlist");
List selectStudyNoteSetNM = (List)request.getAttribute("selectStudyNoteSetNM");
List selectlike = (List)request.getAttribute("selectlike");

String searchKey = request.getParameter("searchKey");
String searchValue = request.getParameter("searchValue");


%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  
  <link rel="shortcut icon" href="../images/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
  <link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
  <link rel="stylesheet" href="css//common.css">
  <link rel="stylesheet" href="css/header.css">
  <title>온스터디</title>
  <style>
  /* 프로필 페이지 스타일 */
#container{
  margin: 200px 0 100px 0;
  text-align: center;
}
#profile-wrap .member-profile{
  width: 25%;
  min-width: 120px;
  display: block;
  margin: 0 auto;
}
#profile-wrap .profile-sub-list-wrap{
  margin-left: 10%;
}
#profile-wrap .member-profile-info{
  display: inline-block;
  width: 20%;
  margin-top: 2%;
}
#profile-wrap .member-profile-info dt{
  font-size: 3em;
}
#profile-wrap .member-profile-info dd{
  font-weight: bold;
  font-size: 18px;
}
#profile-wrap .follow-btn{
  background-color: #f15a25;
  border: none;
  width: 11%;
  height: 40px;
  min-width: 80px;
  color: #ffffff;
  border-radius: 30px;
  font-size: 17px;
  transform: translateY(-35px);
}

#study-note-list .study-note-list-title{
  text-align: initial;
  margin: 50px 0;
  font-size: 35px;
  border-bottom: 4px solid #212529;
  padding-bottom: 10px;
}
#study-note-list ul li{
  background-color: #9e9e9e;
  overflow: hidden;
  color: #333333;
  margin-top: 20px;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s;
}
#study-note-list ul li:hover{
  background-color: #f15a25;
  color : #ffffff;
}
/* #study-note-list ul li:hover{
  background-color: #f15a25;
}
#study-note-list ul li:hover{
  background-color: #f15a25;
} */
#study-note-list ul li>p{
  margin-bottom: 0;
}
#study-note-list .category-name,
#study-note-list .study-note-name{
  float: left;
  font-size: 1.5em;
  line-height: 150px;
}
#study-note-list .etc-info{
  position: relative;
  float: left;
  font-size: 18px;
}
#study-note-list .etc-info .content-amount{
  line-height: 150px;
}
#study-note-list .etc-info .like-btn{
  position: absolute;
  bottom: 10px;
  right: 20px;
}
#study-note-list .etc-info .like-btn>.like-btn-img{
  width: 25px;
  height : 25px;
  background-image : url(../images/like-btn-off2.png);
  background-size: 25px 25px;
  background-repeat : no-repeat;
  background-position: 50% 0%;
  display: inline-block;
}
#study-note-list .etc-info .like-btn>.like-btn-img.on{
  background-image : url(../images/like-btn-on2.png);
}
#study-note-list .etc-info .like-btn>span.like-count{
  transform: translateY(-4px);
  display: inline-block;
}

@media (max-width: 767px){ /*767px : 구조가 바뀌는 기준*/
  #study-note-list .category-name,
  #study-note-list .study-note-name,
  #study-note-list .etc-info .content-amount{
    line-height: 40px;
  }
}
@media (max-width: 991px){
  #profile-wrap .follow-btn{
    font-size:14px;
  }
}
#search-input:hover{
background-color: #f15a25;
color: #ffffff;
}
  
  </style>
</head>

<body>
<%@ include file="../common/loginedHeader.jsp" %>
  <!-- content 시작 -->
  <div id="container" style="margin:350px auto; text-align:center; color:#333333;">

    <div class="container">
	<form action="<%=request.getContextPath()%>/StudyNoteController/search" method="GET" id="searchForm">
      <div class="row" id="pick-up">
        <div class="col-3">
          <select style="height: 40px;" name ="searchKey";>
            <option value="all" >전체</option>
            <option value="writer" >작성자</option>
            <option value="category" >카테고리</option>
            <option value="title" >제목</option>

          </select>     
        </div>
        <div class="col-6">

          <input name="searchValue" id="searchValue" type="text" class="col-12" id="input" placeholder="내용을 입력해주세요" style="height: 40px;">
        </div>
        <div class="col-3">
          <button class="col-5 pointer" id="search-input" style="height: 40px;" type="submit" >검색</button>
        </div>
      </div>
	</form>

    </div>	

<script>
					$(function(){
						
							var input =$("#search-input").val();
						$("#search-input").on("click",function(){
							
							if(input==null){
								alert("검색할 값을 입력해주세요")
								return false;
							}
						})
						
					})
				</script>

<%System.out.println("snlist"+snlist); %>


    <div class="container">
      <div class="row">
        <div class="col-md-12">

          <div id="study-note-list">
            <p class="study-note-list-title">학습노트</p>
            <ul><% if(snlist!=null) {%>
            <% for (int i = 0; i<snlist.size();i++) {%>
              <li id="<%=snlist.get(i).getStudyNoteNo() %>">
                <p class="col-md-3 category-name moving-to-detail"><%=snlist.get(i).getcategoryNM() %></p>
                <p class="col-md-7 study-note-name moving-to-detail"><%=snlist.get(i).getStudyNoteTitle() %></p>
                <p class="col-md-2 etc-info">
                <span class="content-amount"><%=selectStudyNoteSetNM.get(i)%></span>세트
                  <span class="like-btn">
                    <span class="like-btn-img"> </span>
                    <span class="like-count"><%= selectlike.get(i) %></span>
                  </span>
                </p>
              </li>
              <%} 
            }
              %>
              
            </ul> 
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
    // 팔로우 버튼 클릭시 이벤트
    $(function () {
      var followToggle = 0;
      $(".follow-btn").on({
        click: function () {
          if (followToggle == 0) {
            var count = $(".follower-count dt").html();
            count++;
            $(".follower-count dt").html(count);
            followToggle = 1;
            $(".follow-btn").html("팔로우 취소");
          } else {
            var count = $(".follower-count dt").html();
            count--;
            $(".follower-count dt").html(count);
            followToggle = 0;
            $(".follow-btn").html("팔로우");
          }
        }
      });


      // 좋아요 버튼 클릭시 이벤트
      $(".like-btn-img").on({
        click: function () {
          $(this).toggleClass("on");
        }
      });


    });
    
    $(function(){
    
    	
    	$(".moving-to-detail").on("click",function(){
    	var noteNumber = $(this).parent().prop("id");
    	
    	var moveDetailDistinct = $(this).siblings(".etc-info").children(".content-amount").text();
    	
    	console.log("로그 1"+$(this).siblings(".content-amount").text());
    	
    	console.log("로그 2"+moveDetailDistinct);
    	if(moveDetailDistinct>0){
    		location.href = "<%=request.getContextPath()%>/StudyNoteController/movetodetail?noteNumber="+noteNumber;
    	}else{
    		alert("구성요소가 0개인 학습노트는 들어갈 수 없습니다.");
    		return false;
    	}
    		
    		})
    	
    	
    });
  </script>


  <!-- content 종료 -->







  <!-- footer 시작 -->
  <%@ include file="../common/footer.jsp" %>


  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
</body>

</html>