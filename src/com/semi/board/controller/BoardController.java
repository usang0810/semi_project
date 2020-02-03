package com.semi.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.semi.board.model.service.BoardService;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.BoardComment;
import com.semi.board.model.vo.BoardImage;
import com.semi.board.model.vo.PageInfo;
import com.semi.common.ExceptionForward;
import com.semi.common.MyFileRenamePolicy;
import com.semi.member.model.vo.Member;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String contextPath =  request.getContextPath();
		String command = uri.substring((contextPath +"/board").length());
		
		String msg = null;
		String path = null; 
		RequestDispatcher view = null;
		BoardService boardService = new BoardService();
		
		// 게시판 게시글 수 조회용 Controller
		if(command.equals("/freeBoardList") || command.equals("/declareBoardList")) {
			try {	
				String boardType = request.getParameter("boardType");
				String searchKey = request.getParameter("searchKey");
				String searchValue = request.getParameter("searchValue");
				
				int listCount = 0;
				if(boardType.equals("F") || boardType.equals("SD")) {
					listCount = boardService.getListCount(boardType);
				}else {
					listCount = boardService.getListCountSearch(boardType,searchKey,searchValue);					
				}
				
				int limit = 12;			
				int pagingBarSize = 5; 
				
				int currentPage = 0;    
				int maxPage = 0;        
				int startPage = 0;      
				int endPage = 0;		
				
				if(request.getParameter("currentPage")==null) {
					currentPage = 1;
				}else { 
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				maxPage = (int)Math.ceil ( ( (double)listCount / limit ) );
				
				startPage = (currentPage-1) / pagingBarSize * pagingBarSize + 1;
				
				endPage = startPage + pagingBarSize - 1;
				if(maxPage <= endPage) {
					endPage = maxPage;
				}
				
				PageInfo pInf = new PageInfo(listCount, limit, pagingBarSize, currentPage, maxPage, startPage, endPage);
				List<Board> bList = null;
				
				if(boardType.equals("F") || boardType.equals("SD")) {
					bList = boardService.selectList(currentPage,limit,boardType);
				}else {
					bList = boardService.searchBoard(searchKey, searchValue, boardType,currentPage,limit);
				}
				
				if(command.equals("/freeBoardList")) {
					path="/WEB-INF/views/board/freeBoardList.jsp";
				}else {
					path="/WEB-INF/views/board/declareBoardList.jsp";
				}
				
				request.setAttribute("bList", bList);
				request.setAttribute("boardType",boardType);
				request.setAttribute("pInf", pInf);
				view=request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시판 목록 조회", e);
			}
		}
		
		// 게시글 작성화면 이동용 Controller
		else if(command.equals("/goInsertFreeBoard")) {
			path = "/WEB-INF/views/board/freeBoardInsert.jsp";
			view= request.getRequestDispatcher(path);
			view.forward(request, response);
		}else if(command.equals("/goInsertDeclareBoard")) {
			path = "/WEB-INF/views/board/declareBoardInsert.jsp";
			view= request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
		 //게시글 상세조회 Controller	
		else if(command.equals("/freeBoardDetail") || command.equals("/declareBoardDetail")) {
			int boardNo = Integer.parseInt(request.getParameter("no"));
			int boardNumbering = Integer.parseInt(request.getParameter("Numbering"));
			try {
				Board board = boardService.selectBoard(boardNo);
				
				if(board!=null) {
					
					List<BoardImage> files = boardService.selectFiles(boardNo);
					
					if(!files.isEmpty()) {
						request.setAttribute("files", files);
					}
					
					String declaredId = boardService.findDeclaredId(boardNo);
					if(declaredId != null) {
						request.setAttribute("declaredId", declaredId);
					}
					request.setAttribute("board", board);
					request.setAttribute("no",boardNo);
					request.setAttribute("boardNumbering",boardNumbering);
					
					if(command.equals("/freeBoardDetail")) {
						path = "/WEB-INF/views/board/freeBoardDetail.jsp";
					}else {
						path = "/WEB-INF/views/board/declareBoardDetail.jsp";
					}
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
					
				}else {
					request.getSession().setAttribute("msg","게시글 상세 조회 실패");
					
					if(command.equals("/declareBoardDetail")) {
						response.sendRedirect("declareBoardList");
					}else {
						response.sendRedirect("freeBoardList");
					}
				}
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 상세 조회", e);
			}
		}
		
		// 게시글 삭제용 Controller
		else if(command.equals("/deleteBoard")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String boardType = request.getParameter("boardType");
					
			try {
				int result = boardService.deleteBoard(no);
				
				if(result>0) {
					msg = "게시글이 성공적으로 삭제되었습니다.";
					if(boardType.equals("F")) {
						path = "freeBoardList?boardType=F";
					}else {
						path = "declareBoardList?boardType=SD";
					}
				}else {
					msg = "게시글 삭제에 실패하였습니다.";
					
					if(boardType.equals("F")) {
						path = "freeBoardDetail?no="+no;
					}else {
						path = "declareBoardDetail?no="+no;
					}
				}
				request.getSession().setAttribute("msg",msg);
				response.sendRedirect(path);
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 삭제", e);
			}
		}
		
		 //신고자 아이디 조회 Controller
		else if(command.equals("/confirmDeclareId")) {
			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
			
			String loginId = loginMember.getMemberId();
			String id = request.getParameter("declareId");
			
			try {
				int result = boardService.confirmDeclareId(id,loginId);
				
				response.getWriter().print(result);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "신고 아이디 확인", e);
			}
		}
		
		// 댓글 등록용 Controller
		else if(command.equals("/insertReply")) {
			int replyWriter = Integer.parseInt(request.getParameter("writer"));
			int boardId = Integer.parseInt(request.getParameter("boardNo"));
			String replyContent = request.getParameter("content");
			
			BoardComment reply = new BoardComment(replyContent, boardId);
			
			try {
				int result = boardService.insertReply(reply,replyWriter);
				
				// ajax는 forward, sendRedirect 잘 안쓴다.
				response.getWriter().print(result);
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "댓글 등록", e);
			}
		}
		
		// 댓글 리스트 출력용 Controller
		else if(command.equals("/selectReplyList")) {
			int boardId = Integer.parseInt(request.getParameter("boardNo"));
			
			try {
				List<BoardComment> rList = boardService.selectReplyList(boardId);
				
				response.setCharacterEncoding("UTF-8");
				
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create(); 
				
				gson.toJson(rList, response.getWriter());
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response,"댓글 조회", e);
			}
		}
		
		// 게시글 작성용 Controller
		else if(command.equals("/freeBoardInsertDo") || command.equals("/declareBoardInsertDo")) {
						
			try {
				if(ServletFileUpload.isMultipartContent(request) ) { //<= 요청(request)가 multipart/form-data가 포함되어있냐?
					int maxSize = 10 * 1024 * 1024;
					
					String root = request.getSession().getServletContext().getRealPath("/");
					
					String savePath = root + "resources/boardImages/"; 
					
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					// 저장된 파일(변경된 파일명)
					ArrayList<String> saveFiles = new ArrayList<String>();
					
					// 원본 파일명
					ArrayList<String> originFiles = new ArrayList<String>();
					
					Enumeration<String> files = multiRequest.getFileNames();
					
					while(files.hasMoreElements()) {
						
						String name = files.nextElement();
						
						if(multiRequest.getFilesystemName(name) != null) {
							
							saveFiles.add(multiRequest.getFilesystemName(name));
							
							originFiles.add(multiRequest.getOriginalFileName(name));
						}
					}
					String boardTitle = multiRequest.getParameter("title");
					String boardContent = multiRequest.getParameter("content");
					String category = multiRequest.getParameter("category");
					String declareId = multiRequest.getParameter("declareId");
					String secretStatus = multiRequest.getParameter("secretStatus");
					String secret = null;
					if(secretStatus == null) {
						secret = "N";
					}else {
						secret = "Y";
					}
					Board board = new Board(boardTitle, boardContent, category);
					
					// 회원 번호를 session에서 얻어옴
					// session은 일반 request에서만! 얻어올 수 있다!
					Member loginMember = (Member)request.getSession().getAttribute("loginMember");
					
					int boardWriter = loginMember.getMemberNo();
					
					// 6. BoardImage VO를 생성한 후 
					//    BoardImage들을 저장할 List를 생성하여
					//    파일 경로, 파일 원본명, 변경된 파일명을 세팅
					
					ArrayList<BoardImage> fList = new ArrayList<BoardImage>();
					
					// 파일정보는 역순으로 전달되므로, 반복문을 역으로 수행하여 원래 순서대로 저장
					for(int i = originFiles.size()-1; i>=0; i--) {
						BoardImage file = new BoardImage();
						file.setImagePath(savePath);
						file.setImageOriginName(originFiles.get(i));
						file.setImageChangeName(saveFiles.get(i));
						
						fList.add(file);
					}
					int result = 0;
					if(category.equals("F") || category.equals("S")) {
						result = boardService.insertBoard(board, boardWriter, fList, secret); 
					}else {
						 result = boardService.insertBoard2(board, boardWriter, fList, secret,declareId); 
					}
					
					if(result>0) msg="게시글 등록 성공";
					else         msg="게시글 등록 실패";
					
					request.getSession().setAttribute("msg",msg);
					if(category.equals("F")) {
						response.sendRedirect("freeBoardList?boardType=F");
					}else {
						response.sendRedirect("declareBoardList?boardType=SD");
					}
				} 
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 등록", e);
			}
		}
		
		// 이미지 파일 다운로드 Controller
		else if(command.equals("/imageDownload")) {
			int fNo = Integer.parseInt(request.getParameter("fNo"));
			try {
				BoardImage file = new BoardService().selectFile(fNo);
				
				if(file != null) {
					
					ServletOutputStream downOut = response.getOutputStream();
					
					File downloadFile = new File(file.getImagePath() + file.getImageChangeName());
					
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downloadFile));
					
					// setHeader가 있어야 다운로드 가능.
					response.setHeader("Content-Disposition", "attachment; "
							+ "filename=\"" + new String(file.getImageOriginName().getBytes("UTF-8"), "ISO-8859-1") + "\"");

					// 스트림을 통해 내보낼 파일의 크기 지정
					response.setContentLength((int)downloadFile.length());
					
					int readBytes = 0;
					while((readBytes = bis.read()) != -1) {
						downOut.write(readBytes);
					}
					
					// 사용 스트림 반환
					bis.close();
					downOut.close();
				}
			
			}catch (Exception e) {
				ExceptionForward.errorPage(request, response, "이미지 다운로드", e);
			}

		}
		// 게시글 수정화면 출력용 Controller
		else if(command.equals("/updateFreeBoardGo") || command.equals("/updateDeclareBoardGo")) {
			
			int no = Integer.parseInt(request.getParameter("no"));
			String category = request.getParameter("category");
			
			try {
				// 수정 화면에 세팅할 데이터 DB에서 가져오기
				Board board = new BoardService().updateBoardGo(no);
				
				if(board!=null) {
					
					List<BoardImage> files = new BoardService().selectFiles(no);
					
					if(!files.isEmpty()) {
						request.setAttribute("files", files);
					}
					
					request.setAttribute("board", board);
					request.setAttribute("files", files);
					if(category.equals("자유")) {
						path = "/WEB-INF/views/board/updateFreeBoard.jsp";
					}else if(category.equals("건의")) {
						path = "/WEB-INF/views/board/updateDeclareBoard.jsp";
					}else if(category.equals("신고")) {
						String declareId = request.getParameter("declareId");
						request.setAttribute("declareId", declareId);
						path = "/WEB-INF/views/board/updateDeclareBoard.jsp";
					}
					
					view = request.getRequestDispatcher(path);
					view.forward(request, response);
				}else {
					request.getSession().setAttribute("msg","자유게시판 수정 화면 출력 실패");
				}
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "자유게시판 수정화면으로 전환하는 ", e);
			}
		}
		
		// 게시글 수정용 Controller
		else if(command.equals("/updateBoard")) {
			int bNo = Integer.parseInt(request.getParameter("bNo"));
			String secret = request.getParameter("secret");
			
			try {
				int maxSize = 10 * 1024 * 1024; // byte 단위
				String root = request.getSession().getServletContext().getRealPath("/");
				String savePath = root + "resources/boardImages/";
				MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());

				// 게시글만 작성하는 부분
				String boardTitle = multiRequest.getParameter("title");
				String boardContent = multiRequest.getParameter("content");
				Board board = new Board(bNo, boardTitle, boardContent);
				
				// 수정(또는 삭제)해야하는 이미지 리스트
				String[] beforeImg = multiRequest.getParameterValues("beforeImg");
				
				// 회원 번호를 session에서 얻어옴
				// session은 request에서만 얻어올 수 있다
				Member loginMember = (Member)request.getSession().getAttribute("loginMember");
				int boardWriter = loginMember.getMemberNo(); // 작성자
				
				// 수정된 파일이 있을 경우 start
				ArrayList<BoardImage> fList = null;
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
					
					fList = new ArrayList<BoardImage>();
					
					// 파일 정보는 역순으로 전달됨으로 반복문을 역으로 수행하여 원래 순서대로 저장
					for(int i=originFiles.size()-1 ; i>=0 ; i--) {
						BoardImage file = new BoardImage();
						file.setImagePath(savePath);
						file.setImageOriginName(originFiles.get(i));
						file.setImageChangeName(saveFiles.get(i));
						
						fList.add(file);
					}
				}// // 수정된 파일이 있을 경우 end
				
				
				int result = boardService.updateBoard(board, boardWriter, fList, beforeImg, savePath, secret);
				
				if(result > 0) msg = "게시글 수정 성공";
				else msg = "게시글 수정 실패";
				
				request.getSession().setAttribute("msg", msg);
				response.sendRedirect("freeBoardList?boardType=F");
				
			}catch(Exception e) {
				ExceptionForward.errorPage(request, response, "게시글 수정", e);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
