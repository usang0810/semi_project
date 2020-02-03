package com.semi.studynote.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.common.ExceptionForward;
import com.semi.member.model.service.MemberService;
import com.semi.member.model.vo.Member;
import com.semi.studynote.model.service.StudyNoteService;
import com.semi.studynote.model.vo.StudyNote;
import com.semi.studynote.model.vo.StudyNoteSet;


@WebServlet("/StudyNoteController/*")
public class StudyNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudyNoteController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath+"/StudyNoteController").length());

		StudyNoteService SNservice = new StudyNoteService();
		String msg = null;
		String path = null;
		RequestDispatcher view = null;


		if(command.equals("/make")) {

			try {
				path = "/WEB-INF/views/studyNote/studyNoteMake.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
			catch(Exception e) {
				ExceptionForward.errorPage(request, response, "좋아요 버튼 클릭", e);

			}
		}

		// 좋아요 관련 controller
		else if(command.equals("/likeDetail")) {
			int memberNo = Integer.parseInt(request.getParameter("following"));
			int noteNo = Integer.parseInt(request.getParameter("SNnum"));


			try {
				int likeDetail = SNservice.likeDetail(memberNo,noteNo);
				System.out.println("좋아요의 값"+likeDetail);
				// 숫자 1만 좋아요 활성화
				response.getWriter().print(likeDetail);

			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "좋아요 버튼 클릭", e);
			}
		}
		// follow 관련 controller
		else if(command.equals("/followInsert")) {

			System.out.println("follow 만들기 삽입버튼 들어옴");

			int follower = Integer.parseInt(request.getParameter("follower"));

			int following = Integer.parseInt(request.getParameter("following"));
			try {


				int followInsert = SNservice.followInsert(follower,following);

				response.getWriter().print(followInsert);

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "팔로우 삽입", e);
			}




		}else if(command.equals("/followDelete")) {
			System.out.println("follow 만들기 삭제 버튼 들어옴");	

			int follower = Integer.parseInt(request.getParameter("follower"));

			int following = Integer.parseInt(request.getParameter("following"));
			try {


				int followInsert = SNservice.followDelete(follower,following);

				response.getWriter().print(followInsert);

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "팔로우 삽입", e);
			}

		}
		else if(command.equals("/followSelect")) {
			HttpSession session = request.getSession();
			int follower = (int)session.getAttribute("memberNo");
			int following = Integer.parseInt(request.getParameter("targetId"));



			try {

				List followers = SNservice.followerSelect(follower);
				List followings = SNservice.followingSelect(following);

				request.setAttribute("followers", followers);
				request.setAttribute("followings", followings);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "팔로우", e);
			}

		} // 생성
		else if(command.equals("/createStudyNote")) {
			HttpSession session = request.getSession();
			String title = request.getParameter("title");


			Member loginMember = (Member)session.getAttribute("loginMember");

			System.out.println(loginMember);
			String[] setWord = request.getParameterValues("setWord");
			String[] setMean = request.getParameterValues("setMean");

			System.out.println(setWord.toString());
			System.out.println(setMean.toString());

			int memberNo = loginMember.getMemberNo();




			int category =  Integer.parseInt(request.getParameter("category"));
			System.out.println(category);
			try {

				StudyNote note = new StudyNote();

				note.setStudyNoteTitle(title);

				System.out.println(category);

				StudyNote createStudyNote = SNservice.createStudyNote(note,category,memberNo);

				int studyNoteNo = createStudyNote.getStudyNoteNo();


				int result=	SNservice.insertStudyNoteSet(setWord,setMean,studyNoteNo);




				response.sendRedirect("selectStudyNoteSet");

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "학습노트생성", e);
			}

		} // 수정


		else if(command.equals("/loadingStudyNote")) {



			HttpSession session = request.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			int noteNumber = Integer.parseInt(request.getParameter("noteNumber"));


			try {
				// 가져오기 시작
				List<StudyNote> snlist = SNservice.selectStudyNoteList(memberNo);
				// noteNo / title / modify_dt / ID / category_NM



				// snlist의 값을 변경해 줘야함
				int snlistIndex = 0; 

				for(int i = 0 ; i<snlist.size();i++) {
					if(snlist.get(i).getStudyNoteNo()==noteNumber) {
						snlistIndex = i;
					}
				}

				System.out.println(snlist.get(0).getcategoryNM());				
				List<StudyNoteSet> snslist = SNservice.insertStudynoteSet(noteNumber);
				// setNo - 식별자 / setWord -문 / setMean - 답 / studyNoteNo -노트번호 

				request.setAttribute("snlist", snlist);
				request.setAttribute("snslist", snslist);
				request.setAttribute("SNnum", noteNumber);
				request.setAttribute("snlistIndex", snlistIndex);
				path = "/WEB-INF/views/studyNote/myStudyNoteAdjust.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "학습노트수정창작성", e);
			}

		}

		// 내 학습노트 관리 가는 곳
		else if (command.equals("/selectStudyNoteSet")) {
			HttpSession session = request.getSession();




			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			System.out.println(memberNo);

			int [] studyNoteNo = null;
			try{
				// 카테고리명 가져올 친구

				List categorynm = SNservice.selectCategoryNM(memberNo);

				
				
				
				// ui에 표현할 값들을 가지고 오는 list

				List<StudyNote> notelist = SNservice.selectStudyNoteList(memberNo);
				// 추가한 친구 노트 가져오기
				
				int[] addNoteNm = SNservice.addNoteNm(memberNo);
				
				// 추가한 친구 단어장 가져오기
				System.out.println("추가한 친구 단어장 가져오기");
				System.out.println(addNoteNm);
				if(addNoteNm!=null ) {
					for(int i =0; i<addNoteNm.length; i++) {
						System.out.println(addNoteNm[i]);
						StudyNote notes= SNservice.selectTakenStudyNote(addNoteNm[i]);
						notelist.add(notes);
						// addSnList - / noteNo/ title / modifyDT / memberId / CategoryNM / 
					}
				}
				
				
				studyNoteNo = new int [notelist.size()];
				for( int i = 0; i <notelist.size();i++) {
					System.out.println("for문 문제");
					studyNoteNo[i] =notelist.get(i).getStudyNoteNo();
					System.out.println("i:"+studyNoteNo[i]);
				}

				// 좋아요 숫자를 가져올 친구
				List selectlike = SNservice.selectLike(studyNoteNo); 

				// 단어장의 단어 숫자를 가져올 친구
				List selectStudyNoteSetNM = SNservice.selectStudyNoteSetNM(studyNoteNo);



				///

				request.setAttribute("categorynm", categorynm);
				request.setAttribute("notelist", notelist);
				request.setAttribute("selectlike", selectlike);
				request.setAttribute("selectStudyNoteSetNM", selectStudyNoteSetNM);

				// snlist의 memberId는 쓴사람이다.

				path = "/WEB-INF/views/studyNote/myStudyNoteManage.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);

			}
			catch(Exception e) {
				ExceptionForward.errorPage(request, response, "학습노트상세조회", e);
			}

		}else if (command.equals("/delete")) {

			HttpSession session = request.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			int index = Integer.parseInt(request.getParameter("index"));


			try {

				int result = SNservice.deleteStudyNote(index,memberNo);



				response.getWriter().print(result);

			}
			catch(Exception e) {
				ExceptionForward.errorPage(request, response, "학습노트 삭제", e);
			}




		}else if (command.equals("/updateStudyNote")) {
			HttpSession session = request.getSession();
			String title = request.getParameter("title");


			Member loginMember = (Member)session.getAttribute("loginMember");


			String[] setWord = request.getParameterValues("setWord");
			String[] setMean = request.getParameterValues("setMean");

			int memberNo = loginMember.getMemberNo();


			// 노트번호
			int SNnum = Integer.parseInt(request.getParameter("SNnum").trim());


			// 쿼리문 가져와서 문 끼리 비교 답끼리 비교해서 변경사항 있으면 업데이트


			int category =  Integer.parseInt(request.getParameter("category"));

			try {
				// 리스트로 기존의 값을 가져올 것

				int [] SNnums = new int [1];
				SNnums[0] = SNnum;


				SNservice.updateStudyNote(title,category,SNnum);


				List<StudyNoteSet> snlist  = SNservice.selectStudyNoteSet(SNnums);
				// note-set 변경작업
				System.out.println(snlist.size());
				for(int i =0 ; i<snlist.size();i++) {

					if(!snlist.get(i).getSetWord().equals(setWord[i])) {

						SNservice.updateStudyNoteSetWord(setWord[i],(i+1),SNnum);

					}else if(!snlist.get(i).getSetMean().equals(setMean[i])) {

						SNservice.updateStudyNoteSetMean(setMean[i],(i+1),SNnum);
					}
				}
				// note-set 삽입작업


				String SetWord2[] = new String [setWord.length-snlist.size()];
				String SetMean2[] = new String [setMean.length-snlist.size()];
				int j = 0;
				for(int i = snlist.size(); i<setWord.length;i++) {

					SetWord2[j] = setWord[i];	
					System.out.println("setword"+i+"번째의"+setWord[i]);
					SetMean2[j] = setMean[i];
					System.out.println("setword"+i+"번째의"+setMean[i]);
					j++;
				}

				int updateMany = SNservice.insertStudyNoteSet(SetWord2, SetMean2, SNnum);




				StudyNote note = new StudyNote();

				note.setStudyNoteTitle(title);


				response.sendRedirect("selectStudyNoteSet");
			}
			catch(Exception e) {

				ExceptionForward.errorPage(request, response, "학습노트수정", e);
			}
		}else if (command.equals("/deleteDetail")) {



			HttpSession session = request.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo();
			int rownum = Integer.parseInt(request.getParameter("rownum").trim());


			int studynotenm = Integer.parseInt(request.getParameter("SNnum").trim());


			try {

				int result = SNservice.deleteDetail(rownum,studynotenm);

				response.getWriter().print(result);

			}catch(Exception e) {

				ExceptionForward.errorPage(request, response, "학습노트상세 삭제", e);
			}



		}else if (command.equals("/movetodetail")) {

			HttpSession session = request.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo();

			int noteNumber = Integer.parseInt(request.getParameter("noteNumber").trim());
			try {

				List<StudyNote> snlist = SNservice.selectStudyNoteList(memberNo);
				// noteNo / title / modify_dt / ID / category_NM

				List<StudyNoteSet> snslist = SNservice.insertStudynoteSet(noteNumber);
				// setNo - 식별자 / setWord -문 / setMean - 답 / studyNoteNo -노트번호 

				// 좋아요 가져가야함

				// 내가 좋아요를 하고 있으면 1을 아니면 0을 보내자

				int displayLike = SNservice.selectLikeDetail(memberNo,noteNumber);

				


				// 팔로우 가져가야함


				//// 추가하기 상태 확인

				// 노트 번호  + 내 아이디
				int addStatus = SNservice.addStatus(noteNumber,memberNo);


				// 노트 넘버를 통해서 작성자 찾기
				// id 가져와야함
				String writerId = SNservice.selectWriter(noteNumber);

				// 작성한 memberNo

				int writer = SNservice.selectWriterNo(noteNumber);



				List followers = SNservice.followerSelect(memberNo);
				List followings = SNservice.followingSelect(writer);


				// 내가 팔로우를 하고 있다면 1을 아니면 0을 보내자
				// 나는 memberNo 팔로우 목적자 followers - id임
				String memberId = loginMember.getMemberId();
				int followFlag = 0;

				if(!followers.isEmpty()&& followers!=null) {
					for(int i = 0 ; i<followers.size(); i++) {
						if(memberId.equals(followers.get(i))) {
							followFlag = 1;
						}
					}
				}else{
					followFlag = 0;
				}
				
				String imagePath = new MemberService().selectImagePath(memberNo);
				if(imagePath != null) {
					String[] paths = imagePath.split("\\\\"); // "\"를 기준으로 구분
					imagePath = "/" + paths[paths.length - 1];
					
				}


				request.setAttribute("imagePath", imagePath);
				// 팔로우중인지 구별해주는 식별자 팔로우 중이면 1 아니면 0 
				request.setAttribute("followFlag", followFlag);
				request.setAttribute("writer", writer);
				request.setAttribute("writerId", writerId);

				request.setAttribute("followings", followings);
				request.setAttribute("addStatus", addStatus);

				request.setAttribute("displayLike", displayLike);
				request.setAttribute("snlist", snlist);
				request.setAttribute("snslist", snslist);
				path = "/WEB-INF/views/studyNote/studyNoteDetail.jsp";

				view = request.getRequestDispatcher(path);
				view.forward(request, response);



			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "학습노트상세보기", e);

			}

		}else if(command.equals("/search")) {


			System.out.println("controller 들어옴");
			String searchKey = (String) request.getParameter("searchKey");
			String searchValue = (String)request.getParameter("searchValue");

			int [] studyNoteNo = null;
			try {

				System.out.println("sv ="+searchValue);
				System.out.println("sㅏ ="+searchKey);

				List<StudyNote> snlist = SNservice.searchStudyNote(searchKey,searchValue);




				studyNoteNo = new int [snlist.size()];
				for( int i = 0; i <snlist.size();i++) {
					studyNoteNo[i] =snlist.get(i).getStudyNoteNo();
				}
				// 좋아요를 표시해주는 숫자
				List selectlike = SNservice.selectLike(studyNoteNo); 

				// 단어장의 단어 숫자를 가져올 친구
				List selectStudyNoteSetNM = SNservice.selectStudyNoteSetNM(studyNoteNo);


				path="/WEB-INF/views/studyNote/searchStudyNote.jsp";
				request.setAttribute("snlist", snlist);
				request.setAttribute("selectlike", selectlike);
				request.setAttribute("selectStudyNoteSetNM", selectStudyNoteSetNM);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);

				System.out.println("controller 나감");

			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "학습노트검색", e);

			}


		}else if(command.equals("/list")) {


			try {

				List<StudyNote> snlist = new ArrayList<StudyNote>();  
				String searchKey = "";
				String searchValue = "";
				List selectlike = new ArrayList();
				List selectStudyNoteSetNM = new ArrayList();
				int likeDetail = 0;

				request.setAttribute("likeDetail", likeDetail);
				request.setAttribute("snlist", snlist);
				request.setAttribute("selectlike", selectlike);
				request.setAttribute("selectStudyNoteSetNM", selectStudyNoteSetNM);


				path="/WEB-INF/views/studyNote/searchStudyNote.jsp";


				view = request.getRequestDispatcher(path);

				view.forward(request, response);



			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "학습노트검색창 입장", e);

			}


		}else if(command.equals("/addValue")) {
			HttpSession session = request.getSession();

			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			System.out.println("memNo"+memberNo);

			int noteNo = Integer.parseInt(request.getParameter("SNnum"));

			System.out.println("nonum"+noteNo);

			try {
				int addValue = SNservice.addValue(memberNo,noteNo);
				System.out.println("가져오기의 값"+addValue);
				// 숫자 1만 좋아요 활성화
				response.getWriter().print(addValue);

			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "좋아요 버튼 클릭", e);
			}


		}





	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
