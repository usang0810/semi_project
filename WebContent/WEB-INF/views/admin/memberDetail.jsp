<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.onstudy.onstudy.model.vo.Onstudy"%>
<%@page import="com.onstudy.studynote.model.vo.StudyNote"%>
<%
	Member member = (Member)request.getAttribute("member");
	List<StudyNote> noteList = (List<StudyNote>)request.getAttribute("noteList");
	List<Onstudy> pList = (List<Onstudy>)request.getAttribute("pOnstudyList");
	List<Onstudy> eList = (List<Onstudy>)request.getAttribute("eOnstudyList");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">

  <title>온스터디</title>
  <%@ include file="sideBar.jsp"%>
  <link rel="stylesheet" href="../css/adminPage-member-info.css">
</head>

<body>

  <!-- 카테고리, 검색input, 버튼 -->
  <div id="container">
    <div class="container">
      <h2 class="content-title">회원 상세 정보</h2>
      <div class="board-content">

        <!-- 테이블 -->
        <div class="row">
          <div class="col-md-12">
            <table class="table table-bordered container">
                  <tbody>
                    <tr>
                      <th>번호</th>
                      <td><%=member.getMemberNo() %></td>
                    </tr>
                    <tr>
                      <th>아이디</th>
                      <td><%=member.getMemberId() %></td>
                    </tr>
                    <tr>
                      <th>이름</th>
                      <td><%=member.getMemberNm() %></td>
                    </tr>
                    <tr>
                      <th>전화번호</th>
                      <td><%=member.getMemberPhone() %></td>
                    </tr>
                    <tr>
                      <th>학습노트</th>
                      <td>
	                      <%if(noteList.isEmpty()){ %>
	                  	  	  <span>-</span>
	                   	  <%}else{ %>
	                   		  <a href="#"><%=noteList.get(0).getStudyNoteTitle() %></a>                  	  
	                      <%} %>
	                      <%for(int i=1; i < noteList.size(); i++){ %>
	                      	, <a href="#"><%=noteList.get(i).getStudyNoteTitle() %></a>
	                      <%} %>
                      </td>
                    </tr>
                    <tr>
                      <th>참여중인 온스터디</th>
                      <td>
                      	  <%if(pList.isEmpty()){ %>
	                  	  	  <span>-</span>
                      	  <%}else{ %>
	                   		  <a href="#"><%=pList.get(0).getOnstudyTitle() %></a>                  	  
                      	  <%} %>
	                      <%for(int i=1; i < pList.size(); i++){ %>
	                      	, <a href="#"><%=pList.get(i).getOnstudyTitle() %></a>
	                      <%} %>
                      </td>
                    </tr>
                    <tr>
                      <th>참여했던 온스터디</th>
                      <td>
                      	  <%if(eList.isEmpty()){ %>
                      	  	  <span>-</span>
                      	  <%}else{ %>
	                      	  <span><%=eList.get(0).getOnstudyTitle() %></span>                      	  
                      	  <%} %>
	                      <%for(int i=1; i < eList.size(); i++){ %>
	                      	  <span>, <%=eList.get(i).getOnstudyTitle() %></span>
	                      <%} %>
                      </td>
                    </tr>
                    <tr>
                      <th>포인트</th>
                      <td><%=member.getMemberPoint() %></td>
                    </tr>
                    <tr>
                      <th>가입일</th>
                      <td><%=member.getMemberEnrollDt() %></td>
                    </tr>
                    <tr>
                      <th>은행명</th>
                      <td><%=member.getBankName() %></td>
                    </tr>
                    <tr>
                      <th>계좌번호</th>
                      <td><%=member.getMemberAccount() %></td>
                    </tr>
                    <tr>
                      <th>신고회수</th>
                      <td><%=member.getMemberDeclarCount() %></td>
                    </tr>
                    <tr>
                      <th>정지여부</th>
                      <td><%=member.getMemberStatus() %></td>
                    </tr>
              </tbody>
            </table>
            <!-- 테이블-->
          </div>
        </div>

        <!-- 회원정지, 회원복구, 삭제 버튼 -->
        <div id="btn-area" style="margin-bottom: 100px;">

		<%if(member.getMemberStatus() == 'Y'){ %>
			<button type="button" class="btn form-control orange-hover-btn " data-toggle="modal" data-target="#stopMember"
            	id="stopMemberButton">회원 정지</button>
		<%}else if(member.getMemberStatus() == 'S'){ %>
			<button type="button" class="btn form-control orange-hover-btn " data-toggle="modal" data-target="#reMember"
            	id="reMemberButton">회원 복구</button>		
		<%}else{ %>
			<button type="button" class="btn form-control orange-hover-btn " data-toggle="modal" data-target="#reMember"
            	id="reMemberButton">회원 복구</button>
            
            <button type="button" class="btn form-control orange-hover-btn " data-toggle="modal" data-target="#deleteMember"
             id="deleteMemberButton">회원 삭제</button>
		<%} %>
		  <!-- 회원 정지 모달 -->
          <div class="modal fade" id="stopMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                      aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
               		이 회원을 정지 시키겠습니까?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal" value="S" id="stopBtn">정지</button>
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal">취소</button>
                </div>
              </div>
            </div>
          </div>
		
		  <!-- 회원 복구 모달 -->
          <div class="modal fade" id="reMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                      aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
               		이 회원을 복구 시키겠습니까?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal" value="Y" id="reBtn">복구</button>
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal">취소</button>
                </div>
              </div>
            </div>
          </div>
          
          <!-- 회원 삭제 모달 -->
          <div class="modal fade" id="deleteMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                      aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                		 이 회원을 삭제하시겠습니까?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal" value="N" id="deleteBtn">삭제</button>
                  <button type="button" class="btn form-control orange-hover-btn modal-btn" data-dismiss="modal">취소</button>
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
  			location.href="changeMemberStatus?memberNo=<%=member.getMemberNo() %>&status=" + status;
  		});
  	});
  </script>
  
</body>

</html>