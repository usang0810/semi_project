<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.member.model.vo.Member"%>
<%@page import="com.semi.studynote.model.vo.StudyNote"%>

<%
List categorynm = (List)request.getAttribute("categorynm");
List<StudyNote> notelist = (List<StudyNote>)request.getAttribute("notelist");
List selectlike  = (List)request.getAttribute("selectlike");
List selectStudyNoteSetNM = (List)request.getAttribute("selectStudyNoteSetNM");



// 가져와야 되는 목록

// 1. 내 학습노트 /  2. 좋아요 숫자 / 3. 단어장 구성숫자
// 카테고리NM / title / count(*)단어장 / like

%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<link rel="shortcut icon" href="../images/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
<link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
<link rel="stylesheet" href="css//common.css">
<link rel="stylesheet" href="css/header.css">
<title>온스터디</title>
<style>
/* 프로필 페이지 스타일 */
#container {
	margin: 200px 0 100px 0;
	text-align: center;
}

#profile-wrap .member-profile {
	width: 25%;
	min-width: 120px;
	display: block;
	margin: 0 auto;
}

#profile-wrap .profile-sub-list-wrap {
	margin-left: 10%;
}

#profile-wrap .member-profile-info {
	display: inline-block;
	width: 20%;
	margin-top: 2%;
}

#profile-wrap .member-profile-info dt {
	font-size: 3em;
}

#profile-wrap .member-profile-info dd {
	font-weight: bold;
	font-size: 18px;
}

#profile-wrap .follow-btn {
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

#study-note-list .study-note-list-title {
	text-align: initial;
	margin: 50px 0;
	font-size: 35px;
	border-bottom: 4px solid #212529;
	padding-bottom: 10px;
}

#study-note-list ul li {
	background-color: #9e9e9e;
	overflow: hidden;
	color: #333333;
	margin-top: 20px;
	font-weight: bold;
	cursor: pointer;
	transition: all 0.3s;
}

#study-note-list ul li:hover {
	background-color: #f15a25;
	color: #ffffff;
}

/* #study-note-list ul li:hover{
  background-color: #f15a25;
}
#study-note-list ul li:hover{
  background-color: #f15a25;
} */
#study-note-list ul li>p {
	margin-bottom: 0;
}

#study-note-list .category-name, #study-note-list .study-note-name {
	float: left;
	font-size: 1.5em;
	line-height: 150px;
}

#study-note-list .etc-info {
	position: relative;
	float: left;
	font-size: 18px;
}

#study-note-list .etc-info .content-amount {
	line-height: 150px;
}

#study-note-list .etc-info .like-btn {
	position: absolute;
	bottom: 10px;
	right: 20px;
}

#study-note-list .etc-info .like-btn>.like-btn-img {
	width: 25px;
	height: 25px;
	background-image: url(../images/like-btn-off2.png);
	background-size: 25px 25px;
	background-repeat: no-repeat;
	background-position: 50% 0%;
	display: inline-block;
}

#study-note-list .etc-info .like-btn>.like-btn-img.on {
	background-image: url(../images/like-btn-on2.png);
}

#study-note-list .etc-info .like-btn>span.like-count {
	transform: translateY(-4px);
	display: inline-block;
}

@media ( max-width : 767px) {
	/*767px : 구조가 바뀌는 기준*/
	#study-note-list .category-name, #study-note-list .study-note-name,
		#study-note-list .etc-info .content-amount {
		line-height: 40px;
	}
}

@media ( max-width : 991px) {
	#profile-wrap .follow-btn {
		font-size: 14px;
	}
}

.btn-w1 {
	background-color: #f15a25;
}

.fl-lt {
	float: left;
}
</style>
</head>

<body>

	<%@ include file="../common/loginedHeader.jsp"%>


	<!-- content 시작 -->
	<div id="container"
		style="margin: 200px auto; text-align: center; color: #333333;">





		<div class="container">


			<div class="row">
				<div class="col-md-12">

					<div id="study-note-list">


						<p class="study-note-list-title ">
							학습노트

							<button
								onclick = "location.href='<%= request.getContextPath()%>/StudyNoteController/make'"
								class="col-2 form-control orange-hover-btn" type="submit" style="width: 30%; margin-left: 83%; font-size: 15px;">
								새 학습노트 만들기</button>
						</p>
<script>

var me = "<%=loginMember.getMemberId()%>";

$(document).ready(function(){
	
	
	$(document).on("change","#display-selector",function(){
		
	var selector = $("#display-selector").val();
	
	if(selector=="all"){
		
			$(".mine").attr('style', "display:block;");	
			$('.other').attr('style', "display:block;");
	}
	if(selector=="other"){
			$('.mine').attr('style', "display:none;");
			$('.other').attr('style', "display:block;");
	}
	if(selector=="mine"){
		  
		  $('.mine').attr('style', "display:block;");
		  $('.other').attr('style', "display:none;");
	}  
	
	});
	
	});

</script>

						<ul>
							<select id="display-selector" style="margin-left: 85%;">
								<option value="all">노트 전체</option>
								<option value="mine">내가 쓴 노트</option>
								<option value="other">가져오기 한 노트</option>

							</select>



							<%if(notelist!=null)  {%>

							<%for(int i = 0; i<notelist.size();i++) {%>
							
							<li class="<%if(notelist.get(i).getmemberId().equals(loginMember.getMemberId())){%>mine<%}else{%>other<%} %>" id="<%=notelist.get(i).getStudyNoteNo() %>" 
							 >
								
								<p class="col-md-3 category-name moving-to-detail"><%=notelist.get(i).getcategoryNM() %></p>
								<p class="col-md-7 study-note-name moving-to-detail"><%=notelist.get(i).getStudyNoteTitle() %></p>
								<p class="col-md-2 etc-info">
								
								
								<div class="row" id=""
									style="margin-top: 10px;">

									<button class="btn-w1 update-btn" style="width: 40%;">수정</button>
									&nbsp;&nbsp;
									<button type="button" class="delete-btn btn-w1" style="width: 40%;">삭제</button>
									<div class="update-btn-flag"  style="display:none;"><%=notelist.get(i).getmemberId()%></div>
								</div> 
								<br> 
								<span class="content-amount"><%=selectStudyNoteSetNM.get(i)%></span>세트
								&nbsp;<span class="like-btn"> 
								<span ><img src="../images/like-btn-off2.png" alt="추천이미지"  style="font-size :15px; width : 25px ;height : 25px; " ></span> 
								<span class="like-count"><%=selectlike.get(i)%></span>
								</span>
								
								</p>
							</li>

							<%}
              } %>

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
          } 
          
          else {
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


      $(".btn-w1").mouseenter(function () {
        $(this).css("backgroundColor", "white").css("color", "#f15a25")
      });
      $(".btn-w1").mouseleave(function () {
        $(this).css("backgroundColor", "#f15a25").css("color", "black")
      });
    });

    $(".update-btn").click(function(){
    	var noteNumber = $(this).parent().parent().prop("id");
    	var result = confirm("수정하시겠습니까?");
    	
    	var insertFlag = $(this).siblings(".update-btn-flag").text();
    	
    	// 수정 관련 
    	if(result){
    		if(insertFlag==me){
    			
    		location.href ="<%=request.getContextPath()%>/StudyNoteController/loadingStudyNote?noteNumber="+noteNumber;
    		}else{
    			alert("다른 사람의노트는 수정할 수 없습니다.");
    		}
    		
    		
    	}
    });
    
    $(function(){
    
    	
    	$(".moving-to-detail").on("click",function(){
    	var noteNumber = $(this).parent().prop("id");
    	// console.log($(this).siblings(".content-amount").text())
    	var moveDetailDistinct = $(this).siblings(".content-amount").text()
    	console.log("로그 2"+moveDetailDistinct);
    	
    	if(moveDetailDistinct>0){
    		
    		location.href = "<%=request.getContextPath()%>/StudyNoteController/movetodetail?noteNumber="+noteNumber;
    	}else{
    		alert("구성요소가 0개인 학습노트는 들어갈 수 없습니다.");
    		return false;
    	}
    		
    		})
    	
    	
    });
    
    $(function(){
    	
    	$(document).on("click", ".delete-btn", function() {
            
	   
	    	  var result1 = confirm("삭제하시겠습니까?");
	  	      var index = $(this).parent().parent().prop("id");
	  	      var deleteThis = $(this).parent().parent()
	  	      if (result1) {
	  	    	  $.ajax({
	  	    		url : "<%= request.getContextPath()%>/StudyNoteController/delete",
	  	    		data : {index : index},
	  	    		type : "post",
	  	    		async : "false",
	  	    		success : function(result){
	  	    				console.log(result)
	  	    			if(result>0){
	  	    				deleteThis.remove();
	  	    			}
	  	        		
	  	    		}
	  	    	  
	  	    	  
	  	    	  });
	  	    	
	  	      }
	    	
	    });
    });
	    

  </script>
	<!-- content 종료 -->


	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>


	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>

</html>