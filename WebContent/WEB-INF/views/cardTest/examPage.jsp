<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.semi.cardTest.model.vo.StudyCard"%>
<%@page import="com.semi.cardTest.model.vo.ProgressBar"%>

<%
	String msg = (String)session.getAttribute("msg");
	System.out.println(msg);

	StudyCard sCard = (StudyCard) session.getAttribute("sCard");
	ProgressBar pBar = (ProgressBar) session.getAttribute("proBar");
	System.out.println("view 단 sCard : " + sCard);
	System.out.println("view 단 pBar : " + pBar);
	
	int SNnum = (int)request.getAttribute("SNnum");

	int wholeQ = pBar.getWholeQuestion();
	int solvedQ = pBar.getSolvedQuestion();
	int correctQ = pBar.getCorrectAnswer();
	int wrongQ = pBar.getWrongAnswer();

	int wholeP = 0;
	if ( wholeQ==0 ){
		wholeP = 0;
	} else {
		wholeP = (int)((double)pBar.getSolvedQuestion()/pBar.getWholeQuestion()*100);
	}
	
	
	int correctP = 0;
	if ( solvedQ==0 ){
		correctP = 0;
	} else {
		correctP = (int)((double)pBar.getCorrectAnswer()/pBar.getSolvedQuestion()*100);
	}
	
	int wrongP = 0;
	if ( solvedQ==0 ){
		wrongP = 0;
	} else {
	    wrongP = (int)((double)pBar.getWrongAnswer()/pBar.getSolvedQuestion()*100);
	}
	
%>
<!DOCTYPE html>
<html>
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
<link rel="shortcut icon" href="images/favicon.png">
<link rel="apple-touch-icon-precomposed" href="images/icon57.png">
<link rel="apple-touch-icon-precomposed" href="images/icon114.png">
<link rel="stylesheet" href="../css/header2.css">
<title>학습노트 시험보기</title>
<style>
/* .outer {
            position: relative;
        } */
.study-gage {
	float: left;
}

.study-gage2 {
	float: left;
}

.btn-answer {
	background-color: #f15a25;
	color: white;
}

.btn-answer:hover {
	background-color: white;
	color: #f15a25;
}

#backBtn {
	font-size: 20px;
}

#msgArea{
	margin-top : 50px;
	width: 65%
}

h5.card-mean{
 line-height:28px;
}  

</style>
	
<script>
<% if(msg != null) {%>  
alert("<%=msg %>");
<% 	
session.removeAttribute("msg");
}
%>


</script>
</head>
<body>
	<!-- 헤더 시작 -->
	<%@ include file="../common/loginedHeader.jsp"%>

	<!-- content 시작 -->
	<div id="container" style="margin: 240px auto; text-align: center; font-size: 50px; color: #333333;">
        <div class="container">
            <div class="row">

                <div class="col-2" >
                   

                    <!-- 진행률 시작 -->

                    <!-- 진행률 종료 3 -->
                </div>

                
                    <div class="col-10" >
                        
                        <div class="row">
                            <div class="col-2" style="border-right: double;">
                                <div class="col-12 row" style="margin: 0, auto; font-size: 20px; font-weight:bolder;">
                             	       주관식</div>
                                <a href="<%= request.getContextPath()%>/StudyNoteController/movetodetail?noteNumber=<%=SNnum%>" id="backBtn"
                                    style="text-align: right; font-weight:bolder; font-size: 30%;">&lt;&lt;뒤로가기</a> <br>

                                <div class="progress">
                                    <div class="progress-bar" style="width:<%=wholeP%>%"></div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <p style="font-size: 30%;">진행률</p>

                                    </div>
                                    <div class="col-6">
                                        <div class="row">

                                            <p style="font-size: 30%; text-align: right;">&nbsp;<%=solvedQ%></p>
                                            <p style="font-size: 30%; text-align: right;">/</p>
                                            <p style="font-size: 30%; text-align: right;"><%=wholeQ%></p>

                                        </div>
                                    </div>
                                </div>

                                <div class="progress">
                                    <div class="progress-bar" style="width:<%=correctP%>%"></div>
                                </div>


                                <div class="row">
                                    <div class="col-6">
                                        <p style="font-size: 30%;">정답률</p>

                                    </div>
                                    <div class="col-6">
                                        <div class="row">

                                            <p style="font-size: 30%; text-align: right;">&nbsp;<%=correctQ%></p>
                                            <p style="font-size: 30%; text-align: right;">/</p>
                                            <p style="font-size: 30%; text-align: right;"><%=solvedQ%></p>

                                        </div>
                                    </div>
                                </div>

                                <div class="progress">
                                    <div class="progress-bar" style="width:<%=wrongP%>%"></div>
                                </div>


                                <div class="row">
                                    <div class="col-6">
                                        <p style="font-size: 30%;">오답률</p>

                                    </div>
                                    <div class="col-6">
                                        <div class="row">

                                            <p style="font-size: 30%; text-align: right;">&nbsp;<%=wrongQ%></p>
                                            <p style="font-size: 30%; text-align: right;">/</p>
                                            <p style="font-size: 30%; text-align: right;"><%=solvedQ%></p>

                                        </div>
                                    </div>
                                </div>

                               
                            </div>
                           
                            <!-- 정답 입력 -->
                        <form id="AnswerForm" action="checkAnswer" method="POST" role="form" style="width:700px;">    
                        <div class="col-9" style="margin-left: 20px;">

                               <input type="hidden" name="SNnum" value="<%=SNnum %>">
                                    <div class="row" style="height: 300px;" >
                                        <div class="text-area" style="text-align:left; line-height:10px;">
                                            <h5 class="card-mean"><%=sCard.getCardSetMean()%></h5>
                                        </div>    
                                    </div> 
                                 <div class="row" style="font-size: 20px;" id="answerArea">       
                                    <input type="text" placeholder="정답입력" id="answer" name="answer" style="width: 70%; " >
                                    &nbsp; &nbsp;
                                    <button type="submit" class="btn form-control orange-hover-btn" id="submitBtn"
                                        style="width: 25%">정답</button>
                                </div>
                                <div class="row" id="msgArea">
                                    <div id="checkAnswer" style=" font-size: 30px; font-weight:bolder;"> 
                                     </div>
                                </div>

                                <br>
                                <div class="row" style="text-align: right; margin-left: 80%;">
                                    <button type="button"
                                        style="background-color: white; border: none; box-shadow: none; font-weight:bolder; font-size: 30%;"
                                        onclick='location.href="<%=request.getContextPath() %>/cardTest/test?SNnum=<%=SNnum%>"'>
                                                                                          건너뛰기>></button>

                                </div>
                            </div>
                            </form>
                            </div>
                        </div>
                    </div>
               

            </div>
        </div>
	<!-- content 종료 -->



	<!-- footer 시작 -->
	<div id="footer">
		<div class="container-fluid container">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-4 footer-logo-wrap">
							<img class="footer-logo" src="../images/logo2-white.png" alt="푸터로고">
						</div>
						<div class="col-md-8">
							<p class="copyright">&copy; 2020 NOKJO COMPANY. ALL RIGHTS
								RESERVED.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- footer 종료 -->

	<div id="button-top">
		<button type="button" class="top-btn">TOP</button>
	</div>

	<script>
		function scrollFunction() {
			if ($(window).scrollTop() >= 200) {
				$('#button-top').show(0);
			} else {
				$('#button-top').hide(0);
			}
		}
		$(function() {
			scrollFunction();
			$(window).scroll(function() {
				scrollFunction();
			});
			$('#button-top').on({
				click : function() {
					$('html,body').stop().animate({
						scrollTop : 0
					}, 600);
				}
			});
		});
		
		
		
		
	</script>


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