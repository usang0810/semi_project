package com.semi.onstudy.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.semi.common.ExceptionForward;
import com.semi.common.MyFileRenamePolicy;
import com.semi.member.model.vo.Member;
import com.semi.onstudy.model.service.OnstudyService;
import com.semi.onstudy.model.vo.CAttachment;
import com.semi.onstudy.model.vo.CBoard;
import com.semi.onstudy.model.vo.CertifyBoardTotal;
import com.semi.onstudy.model.vo.CertifyCount;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.onstudy.model.vo.PageInfo;
import com.semi.onstudy.model.vo.Thumbnail;

@WebServlet("/onstudy/*")
public class OnstudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OnstudyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		String contextPath = request.getContextPath();
		
		String command = uri.substring((contextPath + "/onstudy").length());
		
		String path = null;
		RequestDispatcher view = null;
		String msg = null;
		
		OnstudyService onstudyService = new OnstudyService();
		
		// 온스터디 메인 - 온스터디 목록 (참가 인원, 날짜)
		if(command.equals("/main")) {
			try {
				// 참가인원 많은 순
				List<Onstudy> mList = onstudyService.selectOnstudyMList();
				System.out.println(mList);
				request.setAttribute("mList", mList);
				// 최신날짜 순
				List<Onstudy> dList = onstudyService.selectOnstudyDList();
				System.out.println(dList);
				request.setAttribute("dList", dList);
			} catch (Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 목록 조회", e); 
			} finally {
				path = "/WEB-INF/views/onstudy/onstudyMain.jsp";
				view=request.getRequestDispatcher(path);
				view.forward(request, response);
			}
		} 
		
		// 검색 결과
		else if (command.equals("/searchList")) {
			try {
				String searchKeyword = request.getParameter("search-keyword");
				String searchCategory = request.getParameter("search-category");
				String searchStart = request.getParameter("search-start");
				String searchEnd = request.getParameter("search-end");
				
				System.out.println(searchKeyword);
				System.out.println(searchCategory);
				System.out.println(searchStart);
				System.out.println(searchEnd);
	            
//	            System.out.println("sList : " + sList);
	            
	            
	               
//	               path="/WEB-INF/views/onstudy/onstudySearchList.jsp";
//	               view=request.getRequestDispatcher(path);
//	               view.forward(request, response);
//	               System.out.println(sList.size());
	         
	               // 현재 게시글 전체 수 -> 검색된 전체 글 수
				int listCount = onstudyService.getListCount(searchKeyword, searchCategory, searchStart, searchEnd);
				   
				int limit = 3; // 한 페이지에 보여줄 게시글의 수 
				int pagingBarSize = 5; // 보여질 페이징바의 페이지 개수
				int currentPage = 0; // 현재 페이지 번호를 표시할 변수
				int maxPage = 0; // 전체 페이지의 수(== 마지막 페이지)
				int startPage = 0; // 페이징바 시작 페이지 번호
				int endPage = 0; // 페이징바 끝 페이지 번호
				   
				// currentPage - 현재 페이지 번호를 표시할 변수 -> 1 아니면 전달받은 값
				// 처음 게시판 목록으로 화면이 전환되면 1페이지가 보여야 함
				if(request.getParameter("currentPage") == null ) { // 페이지 값이 넘어오지 않았다면
					currentPage = 1;
				} else {
				// 전달받은 값이 있을 경우 해당 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				// maxPage - 총 페이지 수(== 마지막 페이지)
				maxPage = (int)Math.ceil( ( (double)listCount / limit) );
				// startPage - 페이징바의 시작 페이지 번호
				startPage = ( currentPage - 1 ) / pagingBarSize * pagingBarSize + 1;
				// endPage - 페이징바의 끝 페이지 번호
				endPage = startPage + pagingBarSize - 1;
				if(maxPage<=endPage) {
				endPage = maxPage;
				}
				PageInfo pInf = new PageInfo(listCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				//	                  System.out.println(pInf);
			   
				List<Onstudy> sList = onstudyService.selectList(searchKeyword, searchCategory, searchStart, searchEnd, currentPage, limit);
				   
				request.setAttribute("searchKeyword", searchKeyword);
				request.setAttribute("searchCategory", searchCategory);
				request.setAttribute("searchStart", searchStart);
				request.setAttribute("searchEnd", searchEnd);
				   
				path="/WEB-INF/views/onstudy/onstudySearchList.jsp";
				request.setAttribute("pInf", pInf);
				request.setAttribute("sList", sList);
				view=request.getRequestDispatcher(path);
				view.forward(request, response);
			       
			
				} catch (Exception e){
					ExceptionForward.errorPage(request, response, "온스터디 검색", e); 
				} 
			}
		      
			else if(command.equals("/createView")) {
				
				path = "/WEB-INF/views/onstudy/onstudyCreate.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			else if(command.equals("/createOnstudy")) {
			
			try {
				// 업로드할 파일이 있는지 확인
				if(ServletFileUpload.isMultipartContent(request)) {
					
					int maxSize = 10 * 1024 * 1024;
					String root = request.getSession().getServletContext().getRealPath("/");
					String savePath = root + "resources/onstudyThumbnails/";
					
					
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					// 저장된 파일명(변경)
					String saveFile = null;
					
					Enumeration<String> files = multiRequest.getFileNames();
					
					if(files.hasMoreElements()) {
						
						String name = files.nextElement();
						System.out.println(name);
						
						if(multiRequest.getFilesystemName(name) != null) {
							
							saveFile = multiRequest.getFilesystemName(name);
						}
					}
					
//					Thumbnail thumbImg = new Thumbnail(saveFile, savePath);
					Thumbnail thumbImg = new Thumbnail(saveFile);
					
					// 썸네일 파일 외에 다른 입력값 
					String onstudyTitle = multiRequest.getParameter("onstudy-title");
					Date onstudyStartDt = Date.valueOf(multiRequest.getParameter("onstudy-start"));
					Date onstudyEndDt = Date.valueOf(multiRequest.getParameter("onstudy-end"));
					int onstudyWeeks = Integer.parseInt(multiRequest.getParameter("onstudy-weeks"));
					int onstudyTimes = Integer.parseInt(multiRequest.getParameter("onstudy-times"));
					int onstudyFee = Integer.parseInt(multiRequest.getParameter("onstudy-fee"));
					int categoryCd = Integer.parseInt(multiRequest.getParameter("onstudy-category"));
					String addNotice = multiRequest.getParameter("add-notice");
					
					
					Member loginMember = (Member)request.getSession().getAttribute("loginMember");
					
					Onstudy onstudy = new Onstudy(onstudyTitle, onstudyStartDt, onstudyEndDt, onstudyWeeks, onstudyTimes, onstudyFee, addNotice, loginMember.getMemberNo(), categoryCd);
			
					// 중복된 카테고리에 동시에 참가중인지 확인
					int sameCheck = onstudyService.checkCategory(onstudy);
					// 참가 중인 온스터디가 3개 이상이면 개설 불가
					int joinCheck = onstudyService.checkJoinCount(onstudy);
					
					if(sameCheck == 0 && joinCheck < 3) { 
						// 로그인 멤버의 현재 보유 포인트가 참가비보다 많아야 개설 가능
						if(loginMember.getMemberPoint() >= onstudyFee) {
							int result = onstudyService.createOnstudy(onstudy, thumbImg);
							
							if(result > 0) {
								loginMember.setMemberPoint(loginMember.getMemberPoint() - onstudyFee);
								request.getSession().setAttribute("loginMember", loginMember);
								msg = "온스터디 개설 성공";
							}else {
								msg = "온스터디 개설 실패";
							}
						}else {
							msg = "보유 포인트가 부족합니다.";
						}
					}else {
						if(sameCheck != 0) msg = "동일한 카테고리를 동시에 참여(개설)할 수 없습니다.";
						else if(joinCheck >= 3) msg = "동시에 3개 이상의 온스터디를 참여(개설)할 수 없습니다.";
					}
					request.getSession().setAttribute("msg", msg);
					response.sendRedirect("manage");
				}
			}
			catch (Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 개설 및 참가", e);
			}
		}
		
		// 온스터디 상세보기
		else if (command.equals("/detail")) {
			
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			
			try {
				
				// 해당 온스터디에 참여하고 있는지 확인
				int check = onstudyService.checkJoin(memberNo, onstudyNo);
				Onstudy onstudy = onstudyService.selectOnstudy(onstudyNo);
				
				// 같은 카테고리인 온스터디
				List <Onstudy> sameList = onstudyService.sameCategory(onstudyNo);
				
				request.setAttribute("check", check);
				request.setAttribute("onstudy", onstudy);
				request.setAttribute("sameList", sameList);
				path="/WEB-INF/views/onstudy/onstudyDetail.jsp";
				
				System.out.println(check);
				System.out.println(onstudy);
				System.out.println(sameList);
				
				view=request.getRequestDispatcher(path);
				view.forward(request, response);
				
			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 상세 조회", e);
			}
		}
			
		// 온스터디 참가
		else if (command.equals("/enter")) {
			
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			int onstudyNo = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				// 해당 온스터디 번호로 디비에서 정보 가져오기
				Onstudy onstudy = onstudyService.selectOnstudy(onstudyNo); // 재활용
				
				// 이 온스터디 기간의 참여 중인 온스터디 중복 카테고리 체크
				int sameCheck = onstudyService.checkCategory(onstudy);
				// 이 온스터디 기간의 참여 중인 온스터디 개수 체크
				int joinCheck = onstudyService.checkJoinCount(onstudy);
				
				// 값 넘어옴
				if(sameCheck == 0 && joinCheck < 3) { 
					
					// 로그인 멤버의 현재 보유 포인트가 참가비보다 많아야 참가 가능
					if(loginMember.getMemberPoint() >= onstudy.getOnstudyFee()) {
						
						// 참가 및 포인트 처리
						int result = onstudyService.joinOnstudy(memberNo, onstudy);
						
						if(result > 0) {
							loginMember.setMemberPoint(loginMember.getMemberPoint() - onstudy.getOnstudyFee());
							request.getSession().setAttribute("loginMember", loginMember);
							path = "certify";
							msg = "온스터디 참가 성공 : " + onstudy.getOnstudyFee() + "포인트가 차감됩니다.";
						} else {
							path="main";
							msg = "온스터디 참가 실패";
						}
						
					} else {
						path="main";
						msg = "포인트가 부족합니다.";
					}
					
				} else {
					if(sameCheck != 0) msg = "동일한 카테고리를 동시에 참가할 수 없습니다.";
					else if(joinCheck >= 3) msg = "동시에 3개 이상의 온스터디를 참가할 수 없습니다.";
					path="main";
				}
				
				request.setAttribute("msg", msg);
				response.sendRedirect(path);
					
				
			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 참가 과정", e);
			} 
		}
		
		// 온스터디 참가 취소
		else if (command.equals("/cancel")) {
			
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			int onstudyNo = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				// 해당 온스터디 번호로 디비에서 정보 가져오기
				Onstudy onstudy = onstudyService.selectOnstudy(onstudyNo); // 재활용
				
				// 개설한 사람이 참가 취소할 수 없음
				if(loginMember.getMemberNo() != onstudy.getMemberNo()) {
				
					// 참가 취소 및 포인트 처리
					int result = onstudyService.cancelOnstudy(memberNo, onstudy);
					
					if(result > 0) {
						loginMember.setMemberPoint(loginMember.getMemberPoint() + onstudy.getOnstudyFee());
						request.getSession().setAttribute("loginMember", loginMember);
						path = "certify";
						msg = "온스터디 참가 취소 성공 : " + onstudy.getOnstudyFee() + "포인트가 취소 환불됩니다.";
					} else {
						path="main";
						msg = "온스터디 참가 취소 실패";
					}
				}else {
					path="main";
					msg = "개설자는 취소가 불가능합니다.";
				}
				
				request.setAttribute("msg", msg);
				response.sendRedirect(path);
					
				
			} catch(Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 참가 취소 과정", e);
			} 
		}
		
		// 온스터디 관리
		else if(command.equals("/manage")) {
			
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			
			try {
				
				List<Onstudy> oList = onstudyService.selectOnstudyList(loginMember.getMemberNo());
				
				request.setAttribute("oList", oList);
				
				path = "/WEB-INF/views/onstudy/onstudyManage.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 관리", e);
			}
			
		}
		
		// 온스터디 수정 화면
		else if(command.equals("/updateView")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				Onstudy onstudy = onstudyService.selectUpdate(onstudyNo);
				onstudy.setOnstudyNo(onstudyNo); // 쓸 일이 있을지 없을지 모르겠으나 일단 set 하고 안 쓰면 지우자
				
				request.setAttribute("onstudy", onstudy);
				
				path = "/WEB-INF/views/onstudy/onstudyUpdate.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 수정", e);
			}
		}
		
		// 온스터디 수정 처리
		else if(command.equals("/updateOnstudy")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				// 업로드할 파일이 있는지 확인
				if(ServletFileUpload.isMultipartContent(request)) {
					
					int maxSize = 10 * 1024 * 1024;
					String root = request.getSession().getServletContext().getRealPath("/");
					String savePath = root + "resources/onstudyThumbnails/";
					
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					
					// 저장된 파일명(변경)
					String saveFile = null;
					
					Enumeration<String> files = multiRequest.getFileNames();
					
					if(files.hasMoreElements()) {
						
						String name = files.nextElement();
						System.out.println(name);
						
						if(multiRequest.getFilesystemName(name) != null) {
							
							saveFile = multiRequest.getFilesystemName(name);
						}
					}
					
					Thumbnail thumbImg = new Thumbnail(saveFile);
					
					// 썸네일 파일 외에 다른 입력값 
//					String onstudyTitle = multiRequest.getParameter("onstudy-title");
//					Date onstudyStartDt = Date.valueOf(multiRequest.getParameter("onstudy-start"));
//					Date onstudyEndDt = Date.valueOf(multiRequest.getParameter("onstudy-end"));
//					int onstudyWeeks = Integer.parseInt(multiRequest.getParameter("onstudy-weeks"));
					int onstudyTimes = Integer.parseInt(multiRequest.getParameter("onstudy-times"));
					String addNotice = multiRequest.getParameter("add-notice");
					
					Onstudy onstudy = new Onstudy(onstudyNo, onstudyTimes, addNotice);
					
					int result = onstudyService.updateOnstudy(onstudy, thumbImg);
					
					if(result > 0) {
						msg = "온스터디 수정 성공";
					}else {
						msg = "온스터디 수정 실패";
					}
					request.getSession().setAttribute("msg", msg);
					response.sendRedirect("manage");
				}
			}
			catch (Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 수정", e);
			}
		}
		
		// 온스터디 삭제
		else if(command.equals("/delete")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("no"));
			
			try {
				
				
				int result = onstudyService.deleteOnstudy(onstudyNo);
				
				if(result > 0) {
					request.getSession().setAttribute("msg", "온스터디 삭제 완료");
					path = "manage";
				}else {
					request.getSession().setAttribute("msg", "온스터디 삭제 실패");
					path = "updateView?no="+onstudyNo;
				}
				
				response.sendRedirect(path);
				
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "온스터디 수정", e);
			}
		}
		
		
		// 온스터디 인증 화면 이동
		else if(command.equals("/certify")) {
			
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
	            
			try {
			   
//			// 현재 시점을 기준으로 참가 중인 온스터디 조회
//			List<Onstudy> nList = onstudyService.nowJoin(memberNo);
//			
//			// 해당 멤버가 현재 시점을 기준으로 오늘/n주차에 인증했는지 조회
//			List<CertifyCount> twList = onstudyService.todayWeek(memberNo);
//			
//			// 해당 멤버의 현재 시점의 총 인증 수 조회
//			List<CertifyCount> ccList = onstudyService.checkRate(memberNo);
				
			List<CertifyBoardTotal> totalList = onstudyService.CertifyTotal(memberNo);
			
			
//			request.setAttribute("nList", nList);
//			request.setAttribute("twList", twList);
//			request.setAttribute("ccList", ccList);
			
			request.setAttribute("totalList", totalList);
			   
			path = "/WEB-INF/views/onstudy/onstudyCertify.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
			   
			}catch(Exception e) {
			ExceptionForward.errorPage(request, response, "온스터디 인증", e);
			}
		}
		
		// (해당 온스터디 번호의) 인증게시판으로 이동하여 목록 조회
		else if(command.equals("/boardList")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			
			try {
				// 페이징 처리(pagination)
				// 눈에 보이는 게시판에 일정 개수의 게시글만 노출되고 나머지는 페이지로 구분하여 숫자 형태로 보여주게 하는 방법
			
				// 현재 게시글 전체 수
				int listCount = onstudyService.boardListCount(onstudyNo);
				
				int limit = 12; // 한 페이지에 보여줄 게시글 수 
				int pagingBarSize = 5; // 보여질 페이징바의 페이지 개수
				
				int currentPage = 0; // 현재 페이지 번호를 표시할 변수
				int maxPage = 0; // 전체 페이지의 수(== 마지막 페이지)
				int startPage = 0; // 페이징바 시작 페이지 번호
				int endPage = 0; // 페이징바 끝 페이지 번호
				
				// currentPage 현재 페이지 번호를 표시할 변수
				// 처음 게시판 목록으로 화면이 전환이 되면 1페이지가 보여야 함
				if(request.getParameter("currentPage") == null) {
					currentPage = 1;
				}else {
					// 전달받은 값이 있을 경우 해당 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// maxPage 총 페이지 수(== 마지막 페이지)
				// limit == 5일 경우
				// 게시글의 개수가 50개일 경우 필요 페이지의 수 : 10페이지
				// 게시글의 개수가 51개일 경우 필요 페이지의 수 : 11페이지
				maxPage = (int)Math.ceil(((double)listCount / limit));
				
				// startPage 페이징바의 시작 페이지 번호
				// 페이징바에 수가 10개씩 보여질 경우
				// 시작 번호는 1, 11, 21, 31, ...
				startPage = (currentPage - 1) / pagingBarSize * pagingBarSize + 1;

				// endPage 페이징바의 끝 페이지 번호
				endPage = startPage + pagingBarSize - 1;
				if(maxPage <= endPage) {
					endPage = maxPage;
				}
				
				PageInfo pInf = new PageInfo(listCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				
				// 로그인한 멤버 no
				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
				int memberNo = loginMember.getMemberNo();
				
				// 오늘 인증 횟수 구하는 변수(1일 1회 제한이므로 0 이상이면 오늘 인증한 것으로 인증 여부 확인 가능)
				//int todayCertifyCount = onstudyService.checkToday(onstudyNo, memberNo);
				
				// 현재 날짜가 몇 주차인지 저장하는 변수
				int nWeek = onstudyService.selectNWeek(onstudyNo);
				
				// 이번주(해당주) 인증횟수 저장하는 CertifyCount 객체 생성
				CertifyCount checkCertify = onstudyService.checkCertifyCount(onstudyNo, memberNo, nWeek);
				
				List<CBoard> bList = onstudyService.selectList(currentPage, limit, onstudyNo);
				
				//request.setAttribute("todayCount", todayCertifyCount);
				request.setAttribute("checkCertify", checkCertify);
				request.setAttribute("bList", bList);
				request.setAttribute("pInf", pInf);
				request.setAttribute("onstudyNo", onstudyNo);
				
				path = "/WEB-INF/views/onstudy/onstudyBoardList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "인증 게시판 조회", e);
			}
		}
		
		// (해당 온스터디 번호의) 인증게시글 작성 화면으로 이동
		else if(command.equals("/insertForm")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			
			request.setAttribute("onstudyNo", onstudyNo);
			path = "/WEB-INF/views/onstudy/onstudyBoardInsert.jsp";
			view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
		// (해당 온스터디 번호의) 인증게시글 작성 처리
		else if(command.equals("/boardInsert")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			
			try {
				
				if(ServletFileUpload.isMultipartContent(request)) {
					
					int maxSize = 10 * 1024 * 1024; // byte 단위
					
					String root = request.getSession().getServletContext().getRealPath("/");
					
					String savePath = root + "resources/onstudyBoard/";
					
					
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					
					// 저장된 파일(변경된 파일명)
					ArrayList<String> saveFiles = new ArrayList<String>();
					
					// 원본 파일명
					ArrayList<String> originFiles = new ArrayList<String>();
					
					Enumeration<String> files = multiRequest.getFileNames();
					while(files.hasMoreElements()) {
						
						// 업로드된 파일은 역순으로 전달됨
						String name = files.nextElement();
						
						if(multiRequest.getFilesystemName(name) != null) {
							// getFileSystemName(key) : rename된 파일명 얻어오기
							saveFiles.add(multiRequest.getFilesystemName(name));
							
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}
					
					// 5. 파일 외에 나머지 게시글 입력값 얻어오기
					String boardTitle = multiRequest.getParameter("title");
					String boardContent = multiRequest.getParameter("content");
					
					CBoard board = new CBoard(boardTitle, boardContent, onstudyNo);
					
					// 회원 번호를 session에서 얻어옴
					// session은 request에서만 얻어올 수 있다
					Member loginMember = (Member)request.getSession().getAttribute("loginMember");
					int boardWriter = loginMember.getMemberNo(); // 작성자
					
					// 6. Attachment VO를 생성한 후
					// 	  Attachment를 저장할 List를 생성하여 파일 경로, 파일 원본명, 변경된 파일명을 세팅
					ArrayList<CAttachment> fList = new ArrayList<CAttachment>();
					
					// 파일 정보는 역순으로 전달됨으로 반복문을 역으로 수행하여 원래 순서대로 저장
					for(int i=originFiles.size()-1 ; i>=0 ; i--) {
						CAttachment file = new CAttachment();
						file.setChangeName(saveFiles.get(i));
						
						fList.add(file);
					}
					
					int result = onstudyService.insertBoard(board, boardWriter, fList);
					
					if(result > 0) msg = "게시글 등록 성공";
					else msg = "게시글 등록 실패";
					
					request.getSession().setAttribute("msg", msg);
					response.sendRedirect("boardList?oNo=" + onstudyNo);
				}
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 등록", e);
			}
		}
		
		// 인증 게시글 상세 조회
		else if(command.equals("/boardDetail")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			int boardNo = Integer.parseInt(request.getParameter("bNo"));
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			System.out.println("oNo : " + onstudyNo);
			System.out.println("bNo : " + boardNo);
			System.out.println("currentPage : " + currentPage);
			
			try {
				
				CBoard board = onstudyService.selectBoard(boardNo);
				
				System.out.println("1: " + board);
				if(board != null) { 
					
					List<CAttachment> files = onstudyService.selectFiles(boardNo);
					
					if(!files.isEmpty()) { // 게시글에 첨부 파일이 있을 때
						request.setAttribute("files", files);
					}
					
					path = "/WEB-INF/views/onstudy/onstudyBoardDetail.jsp";
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("board", board);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				}else {
					request.getSession().setAttribute("msg", "게시글 상세 조회 실패");
					response.sendRedirect("boardList?oNo=" + onstudyNo);
				}
				
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 상세 조회", e);
			}
		}
		
		// 인증 게시글 수정 화면 이동
		else if(command.equals("/boardUpdateView")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			int boardNo = Integer.parseInt(request.getParameter("bNo"));
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			try {
				
				// 수정 화면에 세팅할 데이터 DB에서 가져오기
				CBoard board = onstudyService.selectBoard(boardNo);
				
				if(board != null) { 
					
					List<CAttachment> files = onstudyService.selectFiles(boardNo);
					
					if(!files.isEmpty()) { // 게시글에 첨부 파일이 있을 때
						request.setAttribute("files", files);
					}
					
					path = "/WEB-INF/views/onstudy/onstudyBoardUpdate.jsp";
					request.setAttribute("board", board);
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				}else {
					request.getSession().setAttribute("msg", "게시글 수정 화면 이동 실패");
					response.sendRedirect("boardList?oNo=" + board.getOnstudyNo());
				}
				
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 수정 화면 이동", e);
			}
		}
		
		// (해당 온스터디 번호의) 인증게시글 작성 처리
		else if(command.equals("/boardUpdate")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			int boardNo = Integer.parseInt(request.getParameter("bNo"));
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
           
			try {
				int maxSize = 10 * 1024 * 1024; // byte 단위
				String root = request.getSession().getServletContext().getRealPath("/");
				String savePath = root + "resources/onstudyBoard/";
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				

				// 게시글만 작성하는 부분
				String boardTitle = multiRequest.getParameter("title");
				String boardContent = multiRequest.getParameter("content");
				CBoard board = new CBoard(boardTitle, boardContent, onstudyNo);
				board.setBoardNo(boardNo); // 글번호 set
				
				// 수정(또는 삭제)해야하는 이미지 리스트
				String[] beforeImg = multiRequest.getParameterValues("beforeImg");
				
				// 회원 번호를 session에서 얻어옴
				// session은 request에서만 얻어올 수 있다
				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
				int boardWriter = loginMember.getMemberNo(); // 작성자
				
				// 수정된 파일이 있을 경우 start
				ArrayList<CAttachment> fList = null;
				if(ServletFileUpload.isMultipartContent(request)) {
					
					// 저장된 파일(변경된 파일명)
					ArrayList<String> saveFiles = new ArrayList<String>();
					
					// 원본 파일명
					ArrayList<String> originFiles = new ArrayList<String>();
					
					Enumeration<String> files = multiRequest.getFileNames();
					while(files.hasMoreElements()) {
						
						// 업로드된 파일은 역순으로 전달됨
						String name = files.nextElement();
						
						if(multiRequest.getFilesystemName(name) != null) {
							// getFileSystemName(key) : rename된 파일명 얻어오기
							saveFiles.add(multiRequest.getFilesystemName(name));
							
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}
					
					//  Attachment VO를 생성한 후
					//  Attachment를 저장할 List를 생성하여 파일 경로, 파일 원본명, 변경된 파일명을 세팅
					fList = new ArrayList<CAttachment>();
					
					// 파일 정보는 역순으로 전달됨으로 반복문을 역으로 수행하여 원래 순서대로 저장
					for(int i=originFiles.size()-1 ; i>=0 ; i--) {
						CAttachment file = new CAttachment();
						file.setChangeName(saveFiles.get(i));
						file.setBoardNo(boardNo);
						fList.add(file);
					}
				}// // 수정된 파일이 있을 경우 end
				
				System.out.println("fList : " + fList);
				
				int result = onstudyService.updateBoard(board, boardWriter, fList, beforeImg, savePath);
				
				if(result > 0) msg = "게시글 수정 성공";
				else msg = "게시글 수정 실패";
				
				request.setAttribute("currentPage", currentPage);
				request.getSession().setAttribute("msg", msg);
				response.sendRedirect("boardList?oNo=" + onstudyNo);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 수정", e);
			}
		}
		
		// 인증 게시글 검색용 Controller
		else if(command.equals("/searchBoard")) {
			
			int onstudyNo = Integer.parseInt(request.getParameter("oNo"));
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			try {
				
				// 페이징 처리(pagination)
				// 눈에 보이는 게시판에 일정 개수의 게시글만 노출되고 나머지는 페이지로 구분하여 숫자 형태로 보여주게 하는 방법
			
				// 검색 게시글 전체 수
				int listCount = onstudyService.searchListCount(onstudyNo, searchKey, searchValue);
				
				int limit = 12; // 한 페이지에 보여줄 게시글 수 
				int pagingBarSize = 5; // 보여질 페이징바의 페이지 개수
				
				int currentPage = 0; // 현재 페이지 번호를 표시할 변수
				int maxPage = 0; // 전체 페이지의 수(== 마지막 페이지)
				int startPage = 0; // 페이징바 시작 페이지 번호
				int endPage = 0; // 페이징바 끝 페이지 번호
				
				// currentPage 현재 페이지 번호를 표시할 변수
				// 처음 게시판 목록으로 화면이 전환이 되면 1페이지가 보여야 함
				if(request.getParameter("currentPage") == null) {
					currentPage = 1;
				}else {
					// 전달받은 값이 있을 경우 해당 번호를 저장
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// maxPage 총 페이지 수(== 마지막 페이지)
				// limit == 5일 경우
				// 게시글의 개수가 50개일 경우 필요 페이지의 수 : 10페이지
				// 게시글의 개수가 51개일 경우 필요 페이지의 수 : 11페이지
				maxPage = (int)Math.ceil(((double)listCount / limit));
				
				// startPage 페이징바의 시작 페이지 번호
				// 페이징바에 수가 10개씩 보여질 경우
				// 시작 번호는 1, 11, 21, 31, ...
				startPage = (currentPage - 1) / pagingBarSize * pagingBarSize + 1;

				// endPage 페이징바의 끝 페이지 번호
				endPage = startPage + pagingBarSize - 1;
				if(maxPage <= endPage) {
					endPage = maxPage;
				}
				
				PageInfo pInf = new PageInfo(listCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				
				// 로그인한 멤버 no
				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
				int memberNo = loginMember.getMemberNo();
				
				// 오늘 인증 횟수 구하는 변수(1일 1회 제한이므로 0 이상이면 오늘 인증한 것으로 인증 여부 확인 가능)
				//int todayCertifyCount = onstudyService.checkToday(onstudyNo, memberNo);
				
				// 현재 날짜가 몇 주차인지 저장하는 변수
				int nWeek = onstudyService.selectNWeek(onstudyNo);
				
				// 이번주(해당주) 인증횟수 저장하는 CertifyCount 객체 생성
				CertifyCount checkCertify = onstudyService.checkCertifyCount(onstudyNo, memberNo, nWeek);
				
				List<CBoard> bList = onstudyService.selectList(currentPage, limit, onstudyNo);
				
				//request.setAttribute("todayCount", todayCertifyCount);
				request.setAttribute("checkCertify", checkCertify);
				request.setAttribute("bList", bList);
				request.setAttribute("pInf", pInf);
				request.setAttribute("onstudyNo", onstudyNo);
				
				path = "/WEB-INF/views/onstudy/onstudyBoardList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 검색", e);
			}
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
