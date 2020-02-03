<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.studynote.model.vo.StudyNoteSet"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.studynote.model.vo.StudyNote"%>


<% 
List<StudyNote> snlist = (List<StudyNote>)request.getAttribute("snlist");
List<StudyNoteSet> snslist = (List<StudyNoteSet>)request.getAttribute("snslist");
System.out.println("snslist : " + snslist);
int SNnum = snslist.get(0).getStudyNoteNo(); 
String writerId = (String)request.getAttribute("writerId");
int writer = (int)request.getAttribute("writer");
int followFlag = (int)request.getAttribute("followFlag");
int displayLike = (int)request.getAttribute("displayLike");
int addStatus = (int)request.getAttribute("addStatus");

String msg2 = (String)session.getAttribute("msg2");

int resetNote = 0;
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="../images/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../images/icon57.png">
    <link rel="apple-touch-icon-precomposed" href="../images/icon114.png">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css//common.css">
    <title>온스터디</title>

<style>

#test-1 {
    cursor: pointer;
    margin-top: 7%;
}
#test-2{
    cursor: pointer;
    margin-top: 4%;
}
#paging-1>li>a:hover{
background-Color : orange;
}

#paging-1{
    margin: auto;
}
.follow-btn:hover{
            cursor: pointer;
        }

.like-btn:hover{
            cursor: pointer;
        }
.move-to-follow:hover{
cursor :pointer
}
</style>




<body>
<%@ include file="../common/loginedHeader.jsp" %>

<script>
<% if(msg != null) {%>  
alert("<%=msg %>");
<% 	
session.removeAttribute("msg");
}
%>


<% if( msg2 != null) {%> 
      var conReset = confirm("해당 학습카드의 모든 문제를 풀었습니다. 기록을 초기화 하고 문제를 다시 풀겠습니까? ");
   
      if(conReset == true){
        location.href="<%= request.getContextPath()%>/cardTest/resetCard?SNnum=<%=SNnum %>";
        <% session.removeAttribute("msg2");%>;
      }
      else if(conReset == false){
    	location.href="<%= request.getContextPath()%>/StudyNoteController/movetodetail?noteNumber=<%=SNnum%>";
       <%session.removeAttribute("msg2");%>;
      }
<%}%>

</script>


    <!-- content 시작 -->
    <div id="container" style="margin:350px auto; text-align:center; font-size:50px; color:#333333;">
        <div class="container">

                    <!-- 첫번째 열 -->
            <div class="row">
                <div class="col-1" id="test-1">
                    <div class="wrapper" >
                        <img src="../images/test-1.PNG" alt="주관식 시험 버튼" class="float-left" style="font-size :15px; height : 20%; "><h6 class="float-right"><small>
                        <a method="get" href="<%=request.getContextPath() %>/cardTest/test?SNnum=<%=SNnum %>";>주관식</a></small></h6>
                        
                    </div>
                    <br>
                    <!-- <div class="wrapper" >

                        <img src="img/test-1.PNG" alt="객관식 시험 버튼" class="float-left" ><h6 class="float-right"><small>객관식</small></h6>
                    </div> -->
                </div>
                    
                <div class="col-5" id="test-2">

                    <div class="row" style="height:65%;">

                        <div class="container jumbotron jumbotron-fluid toggle-diplay" id="sns-word" style="font-size : 22px; width:100%; height:100%;"></div>
                        <div class="container jumbotron jumbotron-fluid toggle-diplay" id="sns-mean" style="font-size : 22px; width:100%; height:100%; display: none;" ></div>
                    </div>
                    
                    
                    
                    
                    <div class="row text-*-center small" id="paging-0">
                        &nbsp;<%if(addStatus ==1) {%>
                        <img class="add-btn" src="../images/detach-btn.PNG" alt="추가하기 취소 버튼" style="width: 5%; height: 5%; margin:0,30%, auto; font-size :15px;">&nbsp;
                        <%}else{ %>
                        <img class="add-btn" src="../images/add-btn.PNG" alt="추가하기 버튼" style="width: 5%; height: 5%; margin:0,30%, auto; font-size :15px;">&nbsp;
                        <%} %>
                        
                        <%if(displayLike==1){ %>
                        <img class="like-btn" src="../images/like-btn-on2.png" alt="좋아요 버튼 활성" style="width: 5%; height: 5%; margin:0,30%, auto; font-size :15px;">
                        <%}else{ %>
                        <img class="like-btn" src="../images/like-btn-off3.png" alt="좋아요 버튼 비활성" style="width: 5%; height: 5%; margin:0,30%, auto; font-size :15px;">
                        <%} %>
                    </div>


                </div>
                <div class="col-2"></div>
                <div class="col-4">
                    
                    <div class="jumbotron jumbotron-fluid" >
                        
                        <div class="wrapper move-to-follow">
                            <img src="<%=imagePath %>" alt="기본이미지" style="width: 40%; clear: both;" id="profileImg">
                        </div>
                        <div class="wrapper">
                            <div class="row">
                                <div class="container" style="margin-top: 8%; font-size :12px;">

                                    <div class="small" style="display: inline-block; "> <h4 class="float-center form-inline-block"> <%=writerId %></h4></div> 
                                    
                                    <%if(followFlag>0){ %>
                                    <img class="follow-btn" src="../images/following-bt.PNG" alt="팔로우 버튼 활성" style="width: 20%; display: inline-block;">
									<%}else{ %>
                                    <img class="follow-btn" src="../images/follow-bt.PNG" alt="팔로우 버튼 비활성" style="width: 20%; display: inline-block;">
									<%} %>                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <!-- 첫번째 열 종료 -->
			<!-- 좋아요 관련 action -->
			<script>
			
				var following = <%=loginMember.getMemberNo()%>;
				
				var follower = <%=writer%>;
				
				var SNnum = <%= SNnum %>;
				
				var follow_flag = <%= followFlag%>;
				var displayLike = <%= displayLike%>;
			
				
				$(function(){
			         var writer = "<%=writer%>"
			               
			               $(".move-to-follow").on("click",function(){
			                  console.log("move-to-follow 입장")
			                  location.href="<%=request.getContextPath()%>/member/profileDetail?memberNo=<%=writer%>"
			                  
			                  console.log("ajax 입장");
			               });
			               
			            });




				
				
				
				
				
			$(function(){
				
			// 좋아요 버튼
			
				
				$(".like-btn").on("click",function(){
					var btn = $(this);
					console.log("버튼 눌림");
						/* 좋아요 취소 작업 */
									console.log(<%=displayLike%>)
						$.ajax({
							url:"<%=request.getContextPath()%>/StudyNoteController/likeDetail",
							data : {SNnum : SNnum, following : following},
							type : "post",
							success : function(result){
								if(result==1){
									btn.prop("src","../images/like-btn-on2.png");
									//btn.prop("src", "경로");
								}else{
									
									btn.prop("src","../images/like-btn-off3.png");
									//btn.prop("src","경로");
									console.log("좋아요 비활성화");
									
								}console.log(<%=displayLike%>)
							}
						});
					
				}); // onclick 종료
			}); // ready 종료
			
			/////// 팔로우 관련
			$(function(){
				
				
				var follow_flag = <%= followFlag%>;
				
			// 잉 = 하다 / 얽 = 당하다 둘다 memberNo로 넘겨야함
			
				$(".follow-btn").on("click",function(){
					console.log("버튼 눌림");
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
									btn.prop("src","../images/follow-bt.PNG")
									// btn.prop("src","주소");
								}else{
									console.log("팔로우 취소의 작업 실패");
								}
							}
						});
					}else{
						/* 팔로우 시작 작업 */
				console.log("7");
					$.ajax({
						url:"<%=request.getContextPath()%>/StudyNoteController/followInsert",
						data : {following : following, follower : follower},
						type : "post",
						success : function(result){
							if(result==1){
								follow_flag=1;
								console.log("팔로우 진행 성공");
								btn.prop("src","../images/following-bt.PNG")
								
								
							}else{
								console.log("팔로우 진행 실패");
								
				
							}
						}
						
					});
					}
				}); // onclick 종료
			});
			
			$(function(){
				
				// 가져오기 버튼
				
					
					$(".add-btn").on("click",function(){
						var btn = $(this);
						console.log("버튼 눌림");
						
							$.ajax({
								url:"<%=request.getContextPath()%>/StudyNoteController/addValue",
								data : {SNnum : SNnum},
								type : "post",
								success : function(result){
									
									console.log(result);
									if(result==1){
										
										console.log("추가 완료");
										btn.prop("src","../images/detach-btn.PNG");
										//btn.prop("src", "경로");
									}else{
										//btn.prop("src","경로");
										console.log("삭제 완료");
										btn.prop("src","../images/add-btn.PNG");
										
									}
								}
							});
						
					}); // onclick 종료

			});
			
			</script>
			<script>
				var list = [];
				var cnt = 0;
				var size = <%= snslist.size() %>;
				<% for(StudyNoteSet sns : snslist){ %>
					list.push("<%=sns.getSetWord().trim()%>");
					list.push("<%=sns.getSetMean()%>");
				<% } %>
			
				if(cnt == 0){
            		$("#sns-word").show().html(list[0]);
            		cnt++;
				}
                    
            	$("#sns-word").on("click",function(){
            		$(this).hide();
            		$("#sns-mean").show().html(list[cnt++]);
            		if(cnt == list.length) cnt=0;
            	});
            	
            	$("#sns-mean").on("click",function(){
            		$(this).hide();
            		$("#sns-word").show().html(list[cnt++]);
            	});
             </script>
            <!-- 학습 노트 1칸 -->
            <% for(int i = 0 ; i<snslist.size(); i++) {%>
            <div class="container">
                <div class="row">
                    <div class="col-1" >
                       <div class="rounded" style="width: 100%; background-color: gray; color: orange; margin-top: 40%; font-size: 100%;"><%=i+1 %></div>
                    </div>
                    <div class="col-11">
                        <div class="row">
                            
                            <div class="col-5">
                                <textarea class="jumbotron" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%; resize:none; "readonly><%= snslist.get(i).getSetWord() %>
</textarea>
                            </div>
                            <div class="col-1" ></div>
                            <div class="col-5">
                                <textarea class="jumbotron" cols="30"
										rows="8"
										style="font-size: 15px; width: 100%; size: 100%; padding: 0%;resize:none; "readonly>
<%= snslist.get(i).getSetMean() %></textarea>
                                </div>
                                <div class="col-1"></div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
            <%} %>
            

        </div>
    </div>
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