package com.onstudy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.onstudy.common.ExceptionForward;
import com.onstudy.common.MyFileRenamePolicy;
import com.onstudy.member.model.service.MemberService;
import com.onstudy.member.model.vo.Image;
import com.onstudy.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();

		String contextPath = request.getContextPath();

		String command = uri.substring((contextPath + "/member").length());

		String path = null;
		RequestDispatcher view = null;
		String msg = null;

		MemberService memberService = new MemberService();

		if (command.equals("/login")) {

			path = "/WEB-INF/views/member/login.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}

		// 로그인 화면
		else if (command.equals("/loginedIndex")) {

			String memberId = request.getParameter("inputId");
			String memberPwd = request.getParameter("inputPassword");

			Member inputMember = new Member(memberId, memberPwd);

			try {

				Member loginMember = memberService.selectMember(inputMember);

				HttpSession session = request.getSession();

				if (loginMember != null) {
					
					// 로그인 성공 시 회원의 프로필 이미지경로를 가져옴
					String imagePath = memberService.selectImagePath(loginMember.getMemberNo());
					if(imagePath != null) {
						String[] paths = imagePath.split("\\\\"); // "\"를 기준으로 구분
						imagePath = "/" + paths[paths.length - 1]; // "/"경로에 뒤에 제일 마지막 요소 붙임						
					}
					
					session.setAttribute("memberImagePath", imagePath);

					session.setMaxInactiveInterval(600);
					session.setAttribute("loginMember", loginMember);

					// 아이디 저장
					String save = request.getParameter("save");
					Cookie cookie = new Cookie("saveId", memberId);
					if (save != null) {
						cookie.setMaxAge(60 * 60 * 24 * 7);
					} else {
						cookie.setMaxAge(0);
					}
					cookie.setPath("/");
					response.addCookie(cookie);

					response.sendRedirect(request.getContextPath()+"/member/main");

				} else {
					session.setAttribute("msg", "로그인 정보가 유효하지 않습니다.");
					response.sendRedirect(request.getContextPath());
				}

			} catch (Exception e) {

				ExceptionForward.errorPage(request, response, "로그인 과정", e);
			}

		}else if(command.equals("/main")) {
			path = "/WEB-INF/views/member/loginedIndex.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
			
		// 회원가입 양식으로 포워드
		}else if(command.equals("/signupForm")) {
			path = "/WEB-INF/views/member/signupForm.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		// TODO multipart 로 진행시 비밀번호 암호화가 안됨
		// 회원가입
		}else if(command.equals("/signup")) {
			
			try {
				// 요청(reqqust)가 multipart/form-data 가 포함이 되어 있는지
				if(ServletFileUpload.isMultipartContent(request)) {

					int maxSize = 10 * 1024 * 1024;
					String root = request.getSession().getServletContext().getRealPath("/");
					
					String savePath = root + "resource/profileImages/";
							
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					String memberId = multiRequest.getParameter("signupId");
					String memberPwd = multiRequest.getParameter("signupPwd");
					String memberNm = multiRequest.getParameter("signupName");
					String memberPhone = multiRequest.getParameter("phone1") + "-"
										+ multiRequest.getParameter("phone2") + "-"
										+ multiRequest.getParameter("phone3");
					int bankCode =Integer.parseInt(multiRequest.getParameter("bankCode"));
					String memberAccount = multiRequest.getParameter("bankAccount");
					
					Member signupMember = new Member(memberId, memberPwd, memberNm, memberPhone, memberAccount, bankCode);
					
					int result = memberService.signupMember(signupMember);
					int imgResult = 1; // 프로필 이미지를 안넣을 경우를 대비해서 초기값 1
					
					// 회원가입 성공 시 프로필 이미지 검사 후 DB에 저장
					if(result > 0) {
						
						// 변경된 파일명을 저장할 변수
						String saveFileName = null;
						
						Enumeration<String> files = multiRequest.getFileNames();
						
						if(files.hasMoreElements()) {
							
							// 업로드된 파일은 역순으로 전달됨.
							String name = files.nextElement();
							
							// null이 아니면 프로필사진이 존재
							if(multiRequest.getFilesystemName(name) != null) {
								saveFileName = multiRequest.getFilesystemName(name);
							}
						}
						
						// 프로필 사진이 있다면 사진경로를 저장하기 위해 회원 번호를 DB에서 가져와야 함
						if(saveFileName != null) {
							int memberNo = memberService.selectMemberNo(memberId);
							
							Image profileImage = new Image();
							profileImage.setImagePath(savePath + saveFileName);
							profileImage.setMemberNo(memberNo);
							
							// DB에 경로 저장
							imgResult = memberService.insertProfileImage(profileImage);
						}
					}
					
					if(result > 0 && imgResult > 0) msg = "회원가입 성공";
					else msg = "회원가입 실패";
					
					request.getSession().setAttribute("msg", msg);
					
					// 성공 및 실패 시 index.jsp로 이동
					response.sendRedirect(request.getContextPath());
				}
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "회원가입", e);
			}
			
		
		// 아이디 중복 검사
		}else if(command.equals("/idDupCheck")) {
			
			String inputId = request.getParameter("id");
			
			try {
				int result = memberService.idDupCheck(inputId);
				
				PrintWriter out = response.getWriter();
				
				if(result > 0) out.append("no");
				else out.append("yes");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "아이디 중복 검사", e);
			}
			
		// 마이페이지 포워드
		}else if(command.equals("/mypage")) {
			path = "/WEB-INF/views/member/mypage.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		// 회원탈퇴 페이지 포워드
		}else if(command.equals("/secessionForm")) {
			path = "/WEB-INF/views/member/secession.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		// 회원정보 수정 페이지 포워드	
		}else if(command.equals("/updateForm")) {
			path = "/WEB-INF/views/member/update.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		
		// DB에 저장된 비밀번호와 입력한 비밀번호가 일치하는지 확인 후 경로 지정
		}else if(command.equals("/pwdCheck")) {
			HttpSession session = request.getSession();
			int memberNo = ((Member)(session.getAttribute("loginMember"))).getMemberNo();
			String memberPwd = request.getParameter("inputPassword");
			String setPath = request.getParameter("setPath");
			
			try {
				int result = memberService.pwdCheck(memberNo, memberPwd);
				
				if(result > 0) {
					
					if(setPath.equals("secession")) path="secessionForm";
					else path="updateForm";
					
				}else {
					msg = "비밀번호가 일치하지 않습니다.";
					path = "mypage";
					session.setAttribute("msg", msg);
				}
				
				response.sendRedirect(path);
				
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "비밀번호 일치 조회", e);
			}
			
		// 회원탈퇴
		}else if(command.equals("/secession")) {
//			String checkSecession = request.getParameter("checkSecession");
//			String checks[] = request.getParameterValues("checkSecession");
//			
//			System.out.println("checkSecession : " + checkSecession);
//			System.out.println("checks : " + checks);
			HttpSession session = request.getSession();
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
			try {
				int result = memberService.secession(memberNo);
				
				if(result > 0) {
					msg = "회원 탈퇴되었습니다.";
				}else {
					msg = "회원 탈퇴에 실패하였습니다.";
				}
				
				session.setAttribute("msg", msg);
				response.sendRedirect(request.getContextPath());
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "회원 탈퇴", e);
			}
			
		// 회원 아이디 찾기
		}else if(command.equals("/findId")) {
			String memberPhone = request.getParameter("phone1") + "-"
								+ request.getParameter("phone2") + "-"
								+ request.getParameter("phone3");
			
			
			try {
				Member findIdMember = memberService.findIdMember(memberPhone);
				JSONObject jsonMember = new JSONObject();
				
				if(findIdMember != null) {
					
					String secretId = findIdMember.getMemberId().substring(0, findIdMember.getMemberId().length()-3);
					secretId += "***";
					findIdMember.setMemberId(secretId);
					
					String secretNm = findIdMember.getMemberNm().substring(0, findIdMember.getMemberNm().length()-1);
					secretNm += "*";
					findIdMember.setMemberNm(secretNm);
					
					jsonMember.put("check", "yes");
					jsonMember.put("id", findIdMember.getMemberId());
					jsonMember.put("name", findIdMember.getMemberNm());
					jsonMember.put("date", findIdMember.getMemberEnrollDt().toString()); // String으로 안바꿔주면 에러남
					
				}else {
					jsonMember.put("check", "no");
				}
				
				response.getWriter().print(jsonMember);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "아이디 찾기", e);
			}
			
		// 회원 비밀번호 찾기 및 변경
		}else if(command.equals("/findPwd")) {
			String memberId = request.getParameter("id");
			String memberPhone = request.getParameter("phone1") + "-"
								+ request.getParameter("phone2") + "-"
								+ request.getParameter("phone3");
			
			try {
				int result = memberService.findPwdMember(memberId, memberPhone);
				
				if(result > 0) {
					response.getWriter().print("yes");
				}else {
					response.getWriter().print("no");
				}
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "아이디 찾기", e);
			}
			
		}
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
