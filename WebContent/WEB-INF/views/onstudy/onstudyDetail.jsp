<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.semi.onstudy.model.vo.Onstudy"%>

<%
	
	//List<Onstudy> dList = (List<Onstudy>)request.getAttribute("dList");
	Onstudy onstudy = (Onstudy)request.getAttribute("onstudy");
	List<Onstudy> sameList = (List<Onstudy>)request.getAttribute("sameList");
	
	int check = (Integer)request.getAttribute("check");
	
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="shortcut icon" href="img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="img/icon57.png">
    <link rel="apple-touch-icon-precomposed" href="img/icon114.png">
    <link rel="stylesheet" href="../css/header.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/onstudyDetail.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>온스터디</title>


    </head>
    <body>
        <%@ include file="../common/loginedHeader.jsp" %>

        <div id="container" style="color:#333333;">
          <div class="container-fluid container">
            <div class="row">
              <div class="col-md-12">
                <div class="content-title">
                  온스터디
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="jumbotron">
                  <h3>
                    <p><%=onstudy.getOnstudyTitle() %>&nbsp;<span class="badge dDay">D-<%=onstudy.getOnstudyDday() %></span></p>
                    <p class="badge badge-pill badge-secondary">#<%=onstudy.getCategoryNm() %></p>
                  </h3>
                  <p>
                    <b>참여 인원</b>&nbsp;<span><%=onstudy.getMemberCount() %></span>명
                  </p>
                  <p>
                    <b>­기간</b>&nbsp;<span><%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %></span> (<%=onstudy.getOnstudyWeeks()%>주)
                  </p>
                  <p>
                    <b>인증 횟수</b>&nbsp;주 <span><%=onstudy.getOnstudyCertifyCount() %></span>회 (총 <%=onstudy.getTotalCertifyCount() %>회)
                  </p>
                  <p>
                    <b>참가비 금액</b>&nbsp;<span><%=onstudy.getOnstudyFee()%></span>원
                  </p>
                  <br>
                  <h5>온스터디 진행방식</h5><hr>
                  <p>
                    <textarea class="form-control" rows="5" style="resize:none; background-color:white;" readonly></textarea>
                  </p>
                  <h5>인증시 주의사항</h5><hr>
                  <p>
                    <textarea class="form-control" rows="5" style="resize:none; background-color:white;" readonly></textarea>
                  </p>
                  <h5>추가 주의사항</h5><hr>
                  <p>
                    <textarea class="form-control" rows="5" style="resize:none; background-color:white;" readonly><%if(onstudy.getOnstudyAddComment()!=null) { %><%=onstudy.getOnstudyAddComment()%><%} %>
                    </textarea>
                  </p>
                  <h5>이 온스터디와 동시에 할 수 없어요</h5><hr>
					<%if(sameList!=null) { %>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="row">
                      <!-- for문 사용 -->
						<%for(Onstudy sameOnstudy : sameList) { %>
                        <div class="col-md-4">
                          <div class="card">
                            <img class="mb-3" alt="온스타일 이미지" src="<%if(sameOnstudy.getThumbnail() != null) { %><%=request.getContextPath()%>/resources/onstudyThumbnails/<%=sameOnstudy.getThumbnail()%> <%} else { %><%=request.getContextPath()%>/resources/onstudyThumbnails/noimage.png">
                            <div class="card-block">
                              <h5 class="card-title">
                              <%=sameOnstudy.getOnstudyTitle() %>
                              </h5>
                              <p class="card-text">
                                <span class="badge badge-pill badge-secondary">#<%=sameOnstudy.getCategoryNm() %></span><br>
                                <b>모집 마감</b>&nbsp;&nbsp;<%=sameOnstudy.getOnstudyDeadlineDt() %><br>
                                <b>참여 기간</b>&nbsp;&nbsp;<%=sameOnstudy.getOnstudyStartDt() %> ~ <%=sameOnstudy.getOnstudyEndDt() %> (<%=sameOnstudy.getOnstudyWeeks() %>주)<br>
                                <b>인증 횟수</b>&nbsp;&nbsp;주 <%=sameOnstudy.getOnstudyCertifyCount() %>회<br>
                                <b>참 가 비</b>&nbsp;&nbsp;<%=sameOnstudy.getOnstudyFee() %>원<br>
                                <!-- <a class="btn btn-outline-secondary more-btn" href="#">수정하기</a> -->
                              </p>
                            </div>
                          </div>
                        </div>
				<%} %>


                      </div>
                    </div>
                  </div>
			<% }
						}%>
                  <div class="row">
                    <div class="col-md-12">
                      <p id="onstudy-button"  class="form-row" style="float: right;"><br>
                        <a class="btn form-control orange-hover-btn" id="join" href="../onstudy/enter?no=<%=onstudy.getOnstudyNo()%>">참가하기</a>
                        <a class="btn form-control orange-btn" id="cancel" href="../onstudy/cancel?no=<%=onstudy.getOnstudyNo()%>">참가취소</a>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        </div>
        
	<%@ include file="../common/footer.jsp"%>
        <script>
          
          $(function(){

            joinButton = <%= check %>;
            // check > 0 이면 참가 중임 

            if(joinButton != 0){
              $("#join").hide();
              $("#cancel").show();
            }else{
              $("#join").show();
              $("#cancel").hide();
            }

            <%-- $("#cancel").on("click", function(){

               confirm("참가되었으며 <%=onstudy.getOnstudyFee()%>포인트가 차감됩니다.");

             }); --%>
            
            $("#cancel").on("click", function(){

              confirm("참가 취소하시겠습니까?\n취소 시 참가비는 반환됩니다.");

            });

          });
       </script>


    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
