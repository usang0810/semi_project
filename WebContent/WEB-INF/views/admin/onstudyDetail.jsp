<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.onstudy.onstudy.model.vo.Onstudy"%>
<%	Onstudy onstudy = (Onstudy)request.getAttribute("onstudy"); %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <%@ include file="sideBar.jsp" %>
  <link rel="stylesheet" href="../css/adminPage-onstudy-info.css">
  <title>온스터디</title>

</head>

<body>

  <div id="container">
    <div class="container">
      <h2 class="content-title">온스터디 상세 정보</h2>
      <div class="board-content">


        <!-- 테이블 -->
        <div class="row">
          <div class="col-md-12">
            <table class="table table-bordered container">
              <tbody>
                <tr>
                  <th>번호</th>
                  <td><%=onstudy.getOnstudyNo() %></td>
                </tr>
                <tr>
                  <th>온스터디명</th>
                  <td><%=onstudy.getOnstudyTitle() %></td>
                </tr>
                <tr>
                  <th>카테고리</th>
                  <td><%=onstudy.getCategoryNm() %></td>
                </tr>
                <tr>
                  <th>참여인원</th>
                  <td><%=onstudy.getPartiMembers() %>명</td>
                </tr>
                <tr>
                  <th>기간</th>
                  <td><%=onstudy.getOnstudyStartDt() %> ~ <%=onstudy.getOnstudyEndDt() %></td>
                </tr>
                <tr>
                  <th>참가비</th>
                  <td><%=onstudy.getOnstudyFee() %></td>
                </tr>
                <tr>
                  <th>인증 빈도</th>
                  <td>주 <%=onstudy.getOnstudyCertifyCount() %>회</td>
                </tr>
                <tr>
                  <th>개설자</th>
                  <td><a href="memberDetail?memberNo=<%=onstudy.getMemberNo() %>"><%=onstudy.getMemberId() %></a></td>
                </tr>
                <tr>
                  <th>
                  	삭제 여부(Y : 정상, N : 삭제)
                  </th>
                  <td><%=onstudy.getOnstudyStatus() %></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <!-- 테이블-->

        <!-- 회원정지, 삭제 버튼 -->
        <div id="btn-area">
		  
		  <%if(onstudy.getOnstudyStatus().equals("Y")){ %>
	          <button type="button" class="btn form-control orange-hover-btn " data-toggle="modal"
	            data-target="#deleteMember" id="deleteButton">삭제</button>
		  
		  <%}else{ %>
		  	  <button type="button" class="btn form-control orange-hover-btn " data-toggle="modal"
	            data-target="#reMember" id="reButton">복구</button>
		  <%} %>

          <!-- <button type="button" class="btn form-control orange-hover-btn" id="completeCorrection">수정 완료</button> -->

          <div class="modal fade" id="deleteMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                      aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                 		 해당 온스터디를 삭제 하시겠습니까?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn form-control orange-hover-btn" data-dismiss="modal" value="N" id="deleteBtn">삭제</button>
                  <button type="button" class="btn form-control orange-hover-btn" data-dismiss="modal" id="modalBtn">취소</button>
                </div>
              </div>
            </div>
          </div>
          
          <div class="modal fade" id="reMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                      aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                 		 해당 온스터디를 복구 하시겠습니까?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn form-control orange-hover-btn" data-dismiss="modal" value="Y" id="reBtn">복구</button>
                  <button type="button" class="btn form-control orange-hover-btn" data-dismiss="modal" id="modalBtn">취소</button>
                </div>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    </div>
  </div>
  
  <script>
 	 $(function(){
		$(".modal-footer button:first-child").on("click", function(){
			var status = $(this).val();
			location.href="changeOnstudyStatus?onstudyNo=<%=onstudy.getOnstudyNo() %>&status=" + status;
		});
	});
  </script>
  
</body>

</html>