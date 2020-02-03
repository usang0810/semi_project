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
                    <textarea class="form-control" rows="5" style="resize:none; background-color:white;" readonly>
온스터디의 기간은 최소 2주이상 최대 8주이하로 진행됩니다.
온스터디는 일주일에 최소 3회이상 인증하는 방식으로 진행됩니다.
온스터디 인증은 해당 온스터디의 게시판에 파일을 올리는 형식으로 인증해야 합니다.
참가할때 포인트를 지불하고 온스터디의 기간이 끝나면 회원님의 참여율에 따라 포인트가 환급됩니다.
참가한 온스터디의 게시판에서 다른 회원의 인증 게시판을 확인하고 부당하다고 생각되면 신고게시판에 해당 회원을 신고해주세요.
신고횟수가 누적된 회원은 정지처리됩니다.
                    </textarea>
                  </p>
                  <h5>인증시 주의사항</h5><hr>
                  <p>
                    <textarea class="form-control" rows="5" style="resize:none; background-color:white;" readonly>
온스터디는 개설시 삭제할 수 없습니다. 수정밖에 안되니 주의하여 개설해주세요.
온스터디는 참여율로 포인트를 환급해드립니다.
참여율 50%미만이면 포인트를 환급받지 못하니 주의해주세요.
참여율 50%이상 75%이하이면 포인트의 절반만 환급받을 수 있습니다.
참여율이 75%이상 90%이하이면 포인트의 100%를 환급받을 수 있습니다.
참여율이 90%이상이면 해당 온스터디의 남은 포인트를 추가로 지급해드립니다.
                    </textarea>
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

    </body>
</html>
