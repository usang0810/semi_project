package com.onstudy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

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
import com.onstudy.member.model.vo.Order;
import com.onstudy.member.model.vo.PageInfo;
import com.onstudy.member.model.vo.Point;
import com.onstudy.wrapper.EncryptWrapper;
import com.oreilly.servlet.MultipartRequest;
import com.sun.xml.internal.ws.api.message.Attachment;

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
					// 접속자가 관리자 일시 관리자 페이지로 이동
					if(loginMember.getMemberGrade() == 'A') {
						session.setMaxInactiveInterval(600);
						session.setAttribute("loginMember", loginMember);
						path = request.getContextPath() + "/admin/memberList";
						
					}else {
						
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
						
						path = request.getContextPath()+"/member/main";
					}
					
					response.sendRedirect(path);
					
				} else {
					session.setAttribute("msg", "로그인 정보가 유효하지 않습니다.");
					response.sendRedirect(request.getContextPath()+"/member/login");
				}

			} catch (Exception e) {

				ExceptionForward.errorPage(request, response, "로그인 과정", e);
			}
		
			
		}else if(command.equals("/logout")) {
			request.getSession().invalidate();
			
			response.sendRedirect(request.getContextPath());
			
		}else if(command.equals("/main")) {
			path = "/WEB-INF/views/member/loginedIndex.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
			
		// 회원가입 양식으로 포워드
		}else if(command.equals("/signupForm")) {
			path = "/WEB-INF/views/member/signupForm.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
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
					
					memberPwd = EncryptWrapper.getSha512(memberPwd); // 비밀번호 수동 암호화
					
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
			path = "/WEB-INF/views/member/updateForm.jsp";
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
				
				if(result > 0) response.getWriter().print("yes");
				else response.getWriter().print("no");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "아이디 찾기", e);
			}
			
		// 회원 비밀번호 변경
		}else if(command.equals("/changePwd")) {
			String memberId = request.getParameter("id");
			String memberPwd = request.getParameter("pwd1");
			
			memberPwd = EncryptWrapper.getSha512(memberPwd);
			try {
				int result = memberService.changePwdMember(memberId, memberPwd);
				
				if(result > 0) response.getWriter().print("yes");
				else response.getWriter().print("no");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "비밀번호 변경", e);
			}
			
			
		// 회원 정보 수정
		}else if(command.equals("/update")) {
			
			HttpSession session = request.getSession();
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			String memberPwd = request.getParameter("newPwd1");
			String memberPhone = request.getParameter("phone1") + "-"
								+ request.getParameter("phone2") + "-"
								+ request.getParameter("phone3");
			int bankCode =Integer.parseInt(request.getParameter("bankCode"));
			String memberAccount = request.getParameter("bankAccount");
			
			Member updateMember = new Member(memberNo, memberPwd, memberPhone, memberAccount, bankCode);
			
			try {
				int result = memberService.updateMember(updateMember);
				
				if(result > 0) {
					msg = "회원 정보 수정 성공";
					updateMember = (Member)session.getAttribute("loginMember");
					updateMember.setMemberPhone(memberPhone);
					updateMember.setBankCode(bankCode);
					updateMember.setMemberAccount(memberAccount);
					
					session.setAttribute("loginMember", updateMember);
					
				}else msg = "회원 정보 수정 실패";
				
				session.setAttribute("msg", msg);
				response.sendRedirect(request.getContextPath() + "/member/updateForm");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "회원 정보 수정", e);
			}
			
		// 회원 프로필 이미지 수정
		}else if(command.equals("/updateProfile")) {
			
			try {
				// 요청(reqqust)가 multipart/form-data 가 포함이 되어 있는지
				if(ServletFileUpload.isMultipartContent(request)) {

					int maxSize = 10 * 1024 * 1024;
					String root = request.getSession().getServletContext().getRealPath("/");
					
					String savePath = root + "resource/profileImages/";
							
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					HttpSession session = request.getSession();
					int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
					
					// 회원이 가지고 있던 프로필 사진 삭제
					int result = memberService.deleteProfileImg(memberNo);
					int imgResult = 0;
					String imagePath = null;
					
					// 기존 이미지가 없다면 result가 0이 나오므로 조건문을 걸지 않음
					// 변경된 파일명을 저장할 변수
					String saveFileName = null;
					
					Enumeration<String> files = multiRequest.getFileNames();
					
					if(files.hasMoreElements()) {
						
						String name = files.nextElement();
						
						// null이 아니면 프로필사진이 존재
						if(multiRequest.getFilesystemName(name) != null) {
							saveFileName = multiRequest.getFilesystemName(name);
						}
					}

					if(saveFileName != null) {
						Image profileImage = new Image();
						imagePath = savePath + saveFileName;
						profileImage.setImagePath(imagePath);
						profileImage.setMemberNo(memberNo);
						
						// DB에 경로 저장
						imgResult = memberService.insertProfileImage(profileImage);
					}
				
					if(imgResult > 0) {
						msg = "프로필 이미지 변경 성공";
						// 로그인 성공 시 회원의 프로필 이미지경로를 가져옴
						if(imagePath != null) {
							String[] paths = imagePath.split("\\\\"); // "\"를 기준으로 구분
							imagePath = "/" + paths[paths.length - 1]; // "/"경로에 뒤에 제일 마지막 요소 붙임						
						}
						
						session.setAttribute("memberImagePath", imagePath);
						
					}else msg = "프로필 이미지 변경 실패";
					
					session.setAttribute("msg", msg);
					
					// 성공 및 실패 시 index.jsp로 이동
					response.sendRedirect(request.getContextPath() + "/member/updateForm");
				}
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "회원가입", e);
			}
			
		// 포인트 관리 페이지로 포워드
		}else if(command.equals("/pointDetail")) {
			// 회원의 포인트 내역 DB에서 가져옴
			HttpSession session = request.getSession();
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
			char pointInOut = request.getParameter("pointInOut").charAt(0); // 입출금 내역 코드
			// 'W' : 전체, 'A' : 입금, 'M' : 출금
			
			int pointMonth = Integer.parseInt(request.getParameter("pointMonth")); // 입출금 기간 코드
			pointMonth = pointMonth * (-1); // ADD_MONTH 함수를 이용해서 날짜계산을 하기 위해 전달받은 파라미터를 음수로 변환
			// 0 : 전체, 그외 월 수
			
			try {
				// 페이징 처리(pagination)
				// 눈에 보이는 게시판에 일정 개수의 게시글만 노출되고
				// 나머지는 페이지로 구분하여 숫자 형태로 보여주게하는 방법
			
				// 현재 회원의 포인트 내역 전체 수
				int pListCount = memberService.getPointListCount(memberNo, pointInOut, pointMonth);
				
				int limit = 5; // 한 페이지에 보여질 게시글의 수
				int pagingBarSize = 10; // 보여질 페이징바의 페이지 개수
				int currentPage = 0; // 현재 페이지 번호를 표시할 변수
				int maxPage = 0; // 전체 페이지의 수 (== 마지막 페이지)
				int startPage = 0; // 페이징바 시작 페이지 번호
				int endPage = 0; // 페이징바 끝 페이지 번호
				
				// currentPage - 현재 페이지 번호를 표시할 변수
				// 처음 게시판 목록으로 화면이 전환이되면 1페이지가 보여야 함
				if(request.getParameter("currentPage") == null) {
					currentPage = 1;
				}else {
					// 전달받은 값이 있을 경우 해당 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// maxPage - 총 페이지 수(== 마지막 페이지)
				maxPage = (int)Math.ceil( ( (double)pListCount / limit ) );
				
				startPage = (currentPage - 1) / pagingBarSize * pagingBarSize + 1;
				
				// endPage - 페이징바의 끝 페이지 번호
				endPage = startPage + pagingBarSize - 1;
				if(maxPage <= endPage) {
					endPage = maxPage;
				}
				
				PageInfo pInf = new PageInfo(pListCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				
				List<Point> pList = memberService.selectPointList(memberNo, pointInOut, pointMonth, currentPage, limit);
				
				request.setAttribute("pInf", pInf);
				request.setAttribute("pList", pList);
				
				path = "/WEB-INF/views/member/pointDetail.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "포인트 관리 페이지 이동", e);
			}
			
			
			
		// 포인트 환급 페이지로 포워드
		}else if(command.equals("/pointPayBackForm")) {
			path = "/WEB-INF/views/member/pointPayBackForm.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		// 포인트 충전 페이지로 포워드
		}else if(command.equals("/pointChargeForm")) {
			path = "/WEB-INF/views/member/pointChargeForm.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			
		// 회원 포인트 충전(무통장 입금)
		}else if(command.equals("/pointCharge")) {
			HttpSession session = request.getSession();
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			int pointCharge = Integer.parseInt(request.getParameter("pointCharge"));
			
			// 1은 계정에 포인트 입금
			Point point = new Point(pointCharge, 'A', memberNo, 1);
			int memberPoint = 0;
			try {
				int result = memberService.updatePoint(point);
				
				// 포인트가 성공적으로 삽입되었으면 업데이트 된 회원의 포인트를 가져옴
				if(result > 0) {
					memberPoint = memberService.getMemberPoint(memberNo);
					
					if(memberPoint != -1) {
						Member loginMember = (Member)session.getAttribute("loginMember");
						loginMember.setMemberPoint(memberPoint);
						
						session.setAttribute("loginMember", loginMember);
					}
				}
				
				if(result <= 0 || memberPoint == -1) msg = "포인트 충전 실패";
				else msg = "포인트 충전 성공";
				
				session.setAttribute("msg", msg);
				
				response.sendRedirect(request.getContextPath() + "/member/mypage");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "포인트 충전", e);
			}
			
		// 회원 포인트 충전(카드)
		}else if(command.equals("/pointCardCharge")) {
			Order order = new Order(request.getParameter("name"),
									Integer.parseInt(request.getParameter("amount")),
									request.getParameter("buyer_name"),
									request.getParameter("buyer_tel"));
			
			try {
				String merchantUid = memberService.insertOrder(order);
				response.getWriter().print(merchantUid);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "카드 결제", e);
			}
			
		// 카드 결제 성공 시
		}else if(command.equals("/insertImpUid")) {
			
			int memberNo = ((Member)request.getSession().getAttribute("loginMember")).getMemberNo();
			int pointCharge = Integer.parseInt(request.getParameter("amount"));
			Point point = new Point(pointCharge, 'A', memberNo, 1);
			
			String impUid = request.getParameter("imp_uid");
			String merchantUid = request.getParameter("merchant_uid");
			Order order = new Order(merchantUid, impUid, '2');
			
			System.out.println(impUid);
			System.out.println(merchantUid);
			
			int memberPoint = 0;
			try {
				int result = memberService.updateOrder(order, point);
				
				if(result > 0) {
					memberPoint = memberService.getMemberPoint(memberNo);
					
					if(memberPoint != -1) {
						HttpSession session = request.getSession();
						Member loginMember = (Member)session.getAttribute("loginMember");
						loginMember.setMemberPoint(memberPoint);
						
						session.setAttribute("loginMember", loginMember);
					}
				}
				
				response.getWriter().print(result);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "카드 결제", e);
			}
			
			
			
		// 회원 포인트 환급
		}else if(command.equals("/pointPayBack")) {
			HttpSession session = request.getSession();
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			int pointPayBack = Integer.parseInt(request.getParameter("pointPayBack"));
			
			Point point = new Point(pointPayBack, 'M', memberNo, 2);
			int memberPoint = 0;
			
			try {
				int result = memberService.updatePoint(point);
				
				// 포인트가 성공적으로 삽입되었으면 업데이트 된 회원의 포인트를 가져옴
				if(result > 0) {
					memberPoint = memberService.getMemberPoint(memberNo);
					
					if(memberPoint != -1) {
						Member loginMember = (Member)session.getAttribute("loginMember");
						loginMember.setMemberPoint(memberPoint);
						
						session.setAttribute("loginMember", loginMember);
					}
				}
				
				if(result <= 0 || memberPoint == -1) msg = "포인트 환급 실패";
				else msg = "포인트 환급 성공";
				
				session.setAttribute("msg", msg);
				
				response.sendRedirect(request.getContextPath() + "/member/mypage");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "포인트 환급", e);
			}
			
		// 회원 팔로우 관리 페이지 포워드
		}else if(command.equals("/followDetail")) {
			path = "/WEB-INF/views/member/followDetail.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
