<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg = (String)session.getAttribute("msg");
    String msg2 = (String)session.getAttribute("msg2");
	//int resetNote = (int)session.getAttribute("resetNote");
	
	int resetNote = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../img/icon57.png">
    <link rel="apple-touch-icon-precomposed" href="../img/icon114.png">
    <link rel="stylesheet" href="../css/header2.css">
    <title>카드 상세보기</title>
</head>
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

</style>

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
        location.href="<%= request.getContextPath()%>/cardTest/resetCard";
        <% session.removeAttribute("msg2");%>;
      }
      else if(conReset == false){
    	location.href="<%= request.getContextPath()%>/cardTest/cardView";
       <%session.removeAttribute("msg2");%>;
      }
<%}%>

</script>

<body>
  <!-- 헤더 시작     -->
    <%@ include file="../common/loginedHeader.jsp" %>

    <!-- content 시작 -->
    <div id="container" style="margin:350px auto; text-align:center; font-size:50px; color:#333333;">
        <div class="container">

                    <!-- 첫번째 열 -->
            <div class="row">
                <div class="col-1" id="test-1">
                    <div class="wrapper" >
                        <img src="img/test-1.PNG" alt="주관식 시험 버튼" class="float-left" ><h6 class="float-right"><small>
                        <a href="<%=request.getContextPath() %>/cardTest/test">주관식</a></small></h6>
                    </div>
                    <br>
                    
                </div>
                <div class="col-5" id="test-2">

                    <div class="row">

                        <div class="container jumbotron jumbotron-fluid toggle-diplay" >example text</div>
                        <div class="container jumbotron jumbotron-fluid toggle-diplay" style="display: none;" >example answer</div>
                    </div>
                    <div class="row text-*-center small" id="paging-0">
                        <ul class="pagination " id="paging-1">
                            <li class="page-item"><a class="page-link">&lt;</a></li>
                            <li class="page-item"><a class="page-link">1</a></li>
                            <li class="page-item"><a class="page-link">2</a></li>
                            <li class="page-item"><a class="page-link">3</a></li>
                            <li class="page-item"><a class="page-link">4</a></li>
                            <li class="page-item"><a class="page-link">5</a></li>
                            <li class="page-item"><a class="page-link">&gt;</a></li>
                        </ul>
                        &nbsp;
                        <img src="img/add-btn.PNG" alt="추가하기 버튼" style="width: 5%; height: 5%; margin: auto;">&nbsp;
                        <img src="img/download-btn.PNG" alt="다운로드 버튼" style="width: 5%; height: 5%; margin: auto;">&nbsp;
                        <img src="img/like-btn-off3.png" alt="좋아요 버튼" style="width: 5%; height: 5%; margin: auto;">
                    </div>


                </div>
                <div class="col-2"></div>
                <div class="col-4">
                    
                    <div class="jumbotron jumbotron-fluid" >
                        
                        <div class="wrapper">
                            <img src="img/navi-icon-default.png" alt="기본이미지" style="width: 40%; clear: both;">
                        </div>
                        <div class="wrapper">
                            <div class="row">
                                <div class="container" style="margin-top: 8%;">

                                    <div class="small" style="display: inline-block; "> <h4 class="float-center form-inline-block"> name</h4></div> 
                                    <img  src="img/follow-bt.PNG" alt="팔로우 버튼" style="width: 20%; display: inline-block;">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <!-- 첫번째 열 종료 -->

            <!-- 학습 노트 1칸 -->
            <div class="container">
                <div class="row">
                    <div class="col-1" >
                       <div class="rounded" style="width: 100%; background-color: gray; color: orange; margin-top: 40%; font-size: 100%;">1</div>
                    </div>
                    <div class="col-11">
                        <div class="row">
                            
                            <div class="col-5">
                                <div class="jumbotron"></div>
                            </div>
                            <div class="col-1" ></div>
                            <div class="col-5">
                                <div class="jumbotron"></div>
                                </div>
                                <div class="col-1"></div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
            <!-- 학습노트 2번째 칸 -->
            <div class="container">
                <div class="row">
                    <div class="col-1" >
                       <div class="rounded" style="width: 100%; background-color: gray; color: orange; margin-top: 40%; font-size: 100%;">2</div>
                    </div>
                    <div class="col-11">
                        <div class="row">
                            
                            <div class="col-5">
                                <div class="jumbotron"></div>
                            </div>
                            <div class="col-1" ></div>
                            <div class="col-5">
                                <div class="jumbotron"></div>
                                </div>
                                <div class="col-1"></div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
            <!-- 학습노트 2번째 칸 종료 -->
            <!-- 학습노트 3번째 칸 -->
            <div class="container">
                <div class="row">
                    <div class="col-1" >
                       <div class="rounded" style="width: 100%; background-color: gray; color: orange; margin-top: 40%; font-size: 100%;">3</div>
                    </div>
                    <div class="col-11">
                        <div class="row">
                            
                            <div class="col-5">
                                <div class="jumbotron"></div>
                            </div>
                            <div class="col-1" ></div>
                            <div class="col-5">
                                <div class="jumbotron"></div>
                                </div>
                                <div class="col-1"></div>
                        </div>

                    </div>
                    
                    
                </div>
            </div>
                <!-- 학습노트 3칸 종료 -->

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