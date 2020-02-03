package com.semi.cardTest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.cardTest.model.service.CardTestService;
import com.semi.cardTest.model.vo.ProgressBar;
import com.semi.cardTest.model.vo.StudyCard;
import com.semi.common.ExceptionForward;
import com.semi.member.model.vo.Member;

@WebServlet("/cardTest/*")
public class CardTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CardTestController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		String contextPath = request.getContextPath();

		String command = uri.substring((contextPath + "/cardTest").length());

		String path = null;

		RequestDispatcher view = null;

		String msg = null;

		CardTestService ctService = new CardTestService();

		HttpSession session = request.getSession();

		// 학습 카드 보는 화면 -> 주관식 문제풀기 클릭해서 문제푸는 화면으로 넘어감
		/*
		 * if(command.equals("/cardView")) {
		 * 
		 * try {
		 * 
		 * path = "/WEB-INF/views/cardTest/cardView.jsp"; view =
		 * request.getRequestDispatcher(path); view.forward(request, response);
		 * 
		 * } catch(Exception e) { ExceptionForward.errorPage(request, response,
		 * "카드를 불러오는 과정", e); } }
		 */

		// 문제 불러오고 보여주는 화면
		if (command.equals("/test")) {
			// studynoteNo 가져옴

			System.out.println(request.getParameter("SNnum"));
			
			 int SNnum = Integer.parseInt(request.getParameter("SNnum"));
			 
//			 session.setMaxInactiveInterval(600);
//		     session.setAttribute("SNnum", SNnum);
		 

			// int cardSetNo = 1; 

			ProgressBar pBar = null;

			try {

				Member loginMember = (Member) session.getAttribute("loginMember");

				int memberNo = loginMember.getMemberNo();

				pBar = ctService.checkProgress(SNnum, memberNo);

				int leftCardNum = (pBar.getWholeQuestion() - pBar.getSolvedQuestion());

				StudyCard sCard = ctService.selectCard(SNnum);

				if (leftCardNum > 0) {
//
					session.setMaxInactiveInterval(600);
					session.setAttribute("sCard", sCard);
					session.setAttribute("proBar", pBar);


//					request.setAttribute("cardSet", sCard);
//					request.setAttribute("proBar", pBar);
					
					request.setAttribute("SNnum", SNnum);
					
//					System.out.println("문제 : " + sCard.getCardSetMean());
//					response.sendRedirect("test?SNnum=" + SNnum);
					path = "/WEB-INF/views/cardTest/examPage.jsp";
					view = request.getRequestDispatcher(path);
//
					view.forward(request, response);


				} else {
					String reset = "초기화";

					System.out.println(reset);

					request.getSession().setAttribute("msg2", reset);
					response.sendRedirect("../StudyNoteController/movetodetail?noteNumber=" + SNnum);
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "시험을 불러오는 과정", e);
			}

		}

		// 정답 체크
		else if (command.equals("/checkAnswer")) {

			int SNnum = Integer.parseInt(request.getParameter("SNnum"));
//			int CardNo = Integer.parseInt(request.getParameter("CardNo"));
			
			System.out.println(SNnum);

			String answer = request.getParameter("answer").toUpperCase();

			StudyCard sCard3 = (StudyCard) session.getAttribute("sCard");

			String cardName = sCard3.getStudyNoteTitle();

			int questionNo = sCard3.getCardSetNo();

			System.out.println("사용자가 입력한 정답 :" + answer);

			System.out.println("문제번호 :" + questionNo);

			Member loginMember = (Member) session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo();

			ProgressBar pBar = null;

			String msg1 = null;

			try {

				pBar = ctService.checkProgress(SNnum, memberNo);

				// 남아있는 문제 개수 확인
				int leftCardNum = (pBar.getWholeQuestion() - pBar.getSolvedQuestion());

				StudyCard sCard2 = new StudyCard(questionNo, SNnum);

				StudyCard sCard = ctService.checkAnswer(sCard2);

				System.out.println(sCard.getCardSetWord());
				
				String answer1 = sCard.getCardSetWord().toUpperCase();

				PrintWriter out = response.getWriter();

				int result = 0;

				if (1 >= leftCardNum) {
					if (answer.equals(answer1)) {

						msg = "정답 입니다.";
						out.println("Y");
						result = 1;
						// checkReset = true;
					} else {

						msg = "오답 입니다.";
						out.println("N");
						result = 0;
						// checkReset = true;
					}

					System.out.println("DB에 있는 정답 :" + answer1);

					int setNo = sCard.getCardSetNo();

					// 정답 여부 기록용
					int result2 = ctService.insertYn(SNnum, result, memberNo, setNo);

					ProgressBar pBar2 = ctService.checkProgress(SNnum, memberNo);

					int wholeQNum = (pBar2.getWholeQuestion());

					int correctQNum = (pBar2.getCorrectAnswer());

					int percentage = (int) ((double) pBar2.getCorrectAnswer() / pBar2.getWholeQuestion() * 100);

					String msg2 = msg + "\\n\\n모든 문제를 풀었습니다.\\n\\n" + cardName + " 학습카드 문제\\n" + "총 " + wholeQNum
							+ " 문제중  " + correctQNum + " 문제 맞으셨습니다.\\n" + "\\n정답률 " + percentage + "%";

					System.out.println("결과 :" + msg2);

					session.setAttribute("msg", msg2);

					response.sendRedirect("../StudyNoteController/movetodetail?noteNumber=" + SNnum);

				} else {

					if (answer.equals(answer1)) {
						msg = "정답 입니다.";
						out.println("Y");
						result = 1;

					} else {
						msg = "오답 입니다.";
						out.println("N");
						result = 0;
					}

					System.out.println("DB에 있는 정답 :" + answer1);
					System.out.println("결과 :" + msg);

					int setNo = sCard.getCardSetNo();

					// 정답 여부 기록용
					int result2 = ctService.insertYn(SNnum, result, memberNo, setNo);

					session.setAttribute("msg", msg);

					response.sendRedirect("test?SNnum=" + SNnum);
				}

			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "정답을 체크하는 과정", e);

			}

		}

		else if (command.equals("/resetCard")) {

			int cardSetNo = Integer.parseInt(request.getParameter("SNnum"));

			// int resetResult = 0;

			Member loginMember = (Member) session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo();

			ProgressBar pBar = null;

			try {

				pBar = ctService.checkProgress(cardSetNo, memberNo);

				int wholeQ = pBar.getWholeQuestion();

				int rightQ = pBar.getCorrectAnswer();

				int leftCardNum = (pBar.getWholeQuestion() - pBar.getSolvedQuestion());

				StudyCard sCard = ctService.selectCard(cardSetNo);

				int recordResult = ctService.recordResult(cardSetNo, memberNo, wholeQ, rightQ);

				int record = ctService.resetRecord(cardSetNo, memberNo);

				// resetResult = ctService.resetRecord(cardSetNo, memberNo);

				// List<StudyCard> tResult = ctService.checkResult(cardSetNo, memberNo);

				// String recordResult = null;

				// Date testDate = null;

				// for ( StudyCard studyCard : tResult) {

				// recordResult += studyCard.getStudyNoteNo() + "번 문제 결과" +
				// studyCard.getCorrectStatus()+"," ;

				// testDate = studyCard.getTestDt();
				// }

				// int wholeQnum = pBar.getWholeQuestion();
				// int rightQnum = pBar.getCorrectAnswer();

				// int record = ctService.recordTestResult(memberNo, cardSetNo, recordResult,
				// wholeQnum, rightQnum, testDate );

				if (record > 0) {

					System.out.println("초기화 성공");

					response.sendRedirect("../StudyNoteController/movetodetail?noteNumber=" + cardSetNo);

				} else {
					System.out.println("초기화 실패");

					response.sendRedirect("../StudyNoteController/movetodetail?noteNumber" + cardSetNo);
				}

			} catch (Exception e) {

				System.out.println("조회된 회원번호 : " + memberNo);
				System.out.println("조회된 카드셋 번호 : " + cardSetNo);

				ExceptionForward.errorPage(request, response, "초기화 하는 과정", e);

			}
		}

		else if (command.equals("/skip")) {

			int cardSetNo = 1;

			Member loginMember = (Member) session.getAttribute("loginMember");

			int memberNo = loginMember.getMemberNo();

			int result = 0;

			StudyCard sCard = (StudyCard) session.getAttribute("sCard");

			int setNo = sCard.getCardSetNo();
			try {

				int result1 = ctService.insertYn(cardSetNo, result, memberNo, setNo);

				response.sendRedirect("test");

			} catch (Exception e) {

				ExceptionForward.errorPage(request, response, "초기화 하는 과정", e);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
