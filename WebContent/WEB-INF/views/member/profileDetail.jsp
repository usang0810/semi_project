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
	int follower = (int)request.getAttribute("follower");
	int following = (int)request.getAttribute("following");
	int targetNo = (int)request.getAttribute("targetNo");
	int followFlag = (int)request.getAttribute("followFlag");
	String imagePath = (String)request.getAttribute("imagePath");
	if(imagePath != null){
		imagePath = request.getContextPath() + imagePath;
	}else{
		imagePath = request.getContextPath() + "/images/navi-icon-default.png";
	}
%>


<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="../images/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
    <link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/user-profile.css">
    <title>온스터디</title>
    
    <style>
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
#profile-wrap .member-profile-id{
  font-size: 25px;
  font-weight: bold;
  margin-top: 20px;
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
  background-color: transparent;
  border: 1px solid #f15a25;
  width: 11%;
  border-radius: .25rem;
  height: 40px;
  min-width: 80px;
  color: #f15a25;
  font-size: 17px;
  transform: translateY(-35px);
  transition: all 0.3s;
}
#profile-wrap .follow-btn:hover{
  background-color: #f15a25;
  border : 1px solid #f15a25;
  color : #ffffff;
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
    
    
    </style>
    
    </head>
    <body>
        <%@ include file="../common/loginedHeader.jsp"%>
        
        <div id="container">
          <div class="container">
            <div class="row">
              <div class="col-md-12">
                <div id="profile-wrap">
                  <img class="member-profile" src="<%=imagePath %>" alt="프로필아이콘">
                  <p class="member-profile-id"><%=notelist.get(0).getmemberId()%> 님</p>
                  <div class="profile-sub-list-wrap">
                    <dl class="member-profile-info">
                      <dt><%=notelist.size() %></dt>
                      <dd>학습노트</dd>
                    </dl>
                    <dl class="member-profile-info follower-count">
                      <dt id="checkFollower"><%= follower %></dt>
                      <dd>팔로워</dd>
                    </dl>
                    <dl class="member-profile-info">
                      <dt><%= following %></dt>
                      <dd>팔로잉</dd>
                    </dl>
                    <button type="button" class="follow-btn"><%if(followFlag==1){%>팔로우 취소<%}else{%>팔로우<%}%></button>
                  </div>
                </div>
                <div id="study-note-list">
                  <p class="study-note-list-title content-title">학습노트</p>
                  <ul>
                  <% for(int i = 0 ; i<notelist.size();i++) {%>
                    <li id="<%=notelist.get(i).getStudyNoteNo() %>">
                      <p class="col-md-3 category-name moving-to-detail"><%= categorynm.get(i) %></p>
                      <p class="col-md-7 study-note-name moving-to-detail"><%= notelist.get(i).getStudyNoteTitle() %></p>
                      <p class="col-md-2 etc-info">
                        <span class="content-amount"><%=selectStudyNoteSetNM.get(i)%></span>세트
                        <span class="like-btn">
                          <span class="like-btn-img"> </span>
                          <span class="like-count"><%=selectlike.get(i)%></span>
                        </span>
                      </p>
                    </li>
                    <%} %>
                    
                  </ul>
                </div>
                
              </div>
            </div>
          </div>
        </div>

        <script>
        
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
        
        
               //   /                  
          // 팔로우 버튼 클릭시 이벤트
          
          var following = <%=loginMember.getMemberNo()%>;
				
		var follower = <%=targetNo%>;
			var follow_flag = <%= followFlag%>;
          var countfollower = $("#checkFollower").html()
		$(function(){
			
			
			
		// 잉 = 하다 / 얽 = 당하다 둘다 memberNo로 넘겨야함
		
			$(".follow-btn").on("click",function(){
				
				var btn = $(this);
				if(follow_flag ==1){
					/* 팔로우 취소 작업 */
					$.ajax({
						url:"<%=request.getContextPath()%>/StudyNoteController/followDelete",
						data : {following : following, follower : follower},
						type : "post",
						success : function(result){
								console.log("팔로우 취소의 작업 성공");
							if(result==1){
								follow_flag=0;
								$(".follow-btn").html("팔로우");
								$("#checkFollower").html(countfollower-1);
								countfollower--;
								// btn.prop("src","주소");
							}else{
								console.log("팔로우 취소의 작업 실패");
							}
						}
					});
				}else{
					/* 팔로우 시작 작업 */
			
				$.ajax({
					url:"<%=request.getContextPath()%>/StudyNoteController/followInsert",
					data : {following : following, follower : follower},
					type : "post",
					success : function(result){
						if(result==1){
							follow_flag=1;
							console.log("팔로우 진행 성공");
							// btn.prop("src","ㅇㅅㅇ");
							$(".follow-btn").html("팔로우 취소");
							$("#checkFollower").html(countfollower+1);
							countfollower++;
						}else{
							console.log("팔로우 진행 실패");
							
						}
					}
					
				});
				}
			}); // onclick 종료
		});
        </script>

       <%@ include file="../common/footer.jsp" %>


        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
