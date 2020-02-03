package com.semi.board.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.semi.board.model.dao.BoardDao;
import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.BoardComment;
import com.semi.board.model.vo.BoardImage;
import com.semi.board.model.vo.MemberDeclar;
public class BoardService {

	/** 게시판 게시글 수 조회용 Service
	 * @param boardType 
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(String boardType) throws Exception{
		Connection conn = getConnection();
			
		int listCount = new BoardDao().getListCount(conn, boardType);
		
		close(conn);
		return listCount;
	}

	public int getListCountSearch(String boardType, String searchKey, String searchValue) throws Exception{
		Connection conn = getConnection();
		
		String condition = null;
		// query문의 조건을 서비스단에서 가공한다.
		searchValue = "'%' || '" + searchValue +"' || '%'";
		// ex) '%공지%'
		switch(searchKey) {
			case "title" : condition = " AND BOARD_TITLE LIKE " + searchValue; break; 
			case "writer" : condition = " AND MEMBER_ID LIKE " + searchValue; break;   
			case "content" : condition = " AND BOARD_CONTENT LIKE " + searchValue; break; 
		}
		int listCount = new BoardDao().getListCountSearch(conn, boardType, searchKey, searchValue, condition);
		
		close(conn);
		return listCount;
	}

	/** 게시판 목록 조회용 Service
	 * @param currentPage
	 * @param limit
	 * @param boardType 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectList(int currentPage, int limit, String boardType) throws Exception{
		Connection conn = getConnection();
		
		List<Board> bList = new BoardDao().selectList(conn, currentPage, limit, boardType);
		
		close(conn);
		return bList;
	}


	/** 게시판 상세 조회용 Service
	 * @param boardNo
	 * @return Board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		BoardDao boardDao = new BoardDao();
		
		// 1) 게시글 상세 조회
		Board board = boardDao.selectBoard(conn, boardNo);
		
		if(board != null) {
			int result = boardDao.increaseCount(conn, boardNo);
			
			if(result>0) {
				commit(conn);
				// 반환되는 notice는 조회수 증가가 되어있지 않으므로
				// 리턴 시 조회수를 +1 시켜주어야 한다.
				board.setBoardCount(board.getBoardCount()+1);
			}else {
				rollback(conn);
				board = null; //  조회수 증가 실패 시 조회되지 않게 처리.
			}
		}
		
		close(conn);
		return board;

		}

	/** 게시글 삭제용 Service
	 * @param no
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int no) throws Exception{
		Connection conn = getConnection();
		
		int result = new BoardDao().deleteBoard(conn, no);
		
		if(result>0)	commit(conn);
		else		    rollback(conn);
		
		close(conn);
		return result;
	}

	/** 게시글 검색용 Service
	 * @param searchKey
	 * @param searchValue
	 * @param boardType 
	 * @param limit 
	 * @param currentPage 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoard(String searchKey, String searchValue, String boardType, int currentPage, int limit) throws Exception{
		Connection conn = getConnection();
		
		String condition = null;
		// query문의 조건을 서비스단에서 가공한다.
		searchValue = "'%' || '" + searchValue +"' || '%' ";
		// ex) '%공지%'
			
		switch(searchKey) {
			case "title" : condition = " BOARD_TITLE LIKE " + searchValue; break; 
			case "writer" : condition = " MEMBER_ID LIKE " + searchValue; break;   
			case "content" : condition = " BOARD_CONTENT LIKE " + searchValue; break; 
		}
			
		List<Board> bList = new BoardDao().searchBoard(conn, condition, boardType, currentPage, limit);
		close(conn);
		return bList;
	}

	/** 신고자 아이디 조회 Service
	 * @param id 
	 * @param loginId 
	 * @return result
	 * @throws Exception
	 */
	public int confirmDeclareId(String id, String loginId) throws Exception{
		Connection conn = getConnection();
		BoardDao boardDao = new BoardDao();
		int result = boardDao.confirmDeclareId(conn, id);
		
		if(result>0) {
			result = boardDao.isPossibleDelcare(conn,id,loginId);
			result += 1;
		}
		
		close(conn);
		return result;
	}
	
	/** 댓글 등록용 Service
	 * @param reply
	 * @param replyWriter
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(BoardComment reply, int replyWriter) throws Exception{
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn, reply, replyWriter);
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		return result;
	}

	/** 댓글 리스트 조회용 Service
	 * @param boardId
	 * @return rList;
	 * @throws Exception
	 */
	public List<BoardComment> selectReplyList(int boardId) throws Exception{
		Connection conn = getConnection();
		
		List<BoardComment> rList = new BoardDao().selectReplyList(conn, boardId);
		
		close(conn);
		return rList;
	}

	
	/** 게시글 이미지 조회용 Service
	 * @param boardNo
	 * @return files
	 * @throws Exception
	 */
	public List<BoardImage> selectFiles(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		List<BoardImage> files = new BoardDao().selectFiles(conn, boardNo);
		
		close(conn);
		return files;
	}

	
	/** 게시글 이미지 다운로드용 Service
	 * @param fNo
	 * @return file
	 * @throws Exception
	 */
	public BoardImage selectFile(int fNo) throws Exception{
		Connection conn = getConnection();
		
		BoardImage file = new BoardDao().selectFile(conn, fNo);
		
		close(conn);
		return file;
	}
	
	/**게시글 작성용 Service(자유, 건의)
	 * @param board
	 * @param boardWriter
	 * @param fList
	 * @param secretStatus
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board, int boardWriter, ArrayList<BoardImage> fList, String secretStatus) throws Exception{
	Connection conn = getConnection();
		
		BoardDao boardDao = new BoardDao();
		
		int result = 0;
		
		// 1) 등록될 게시글의 번호를 얻어옴.
		//    -> SEQ_BNO.NEXTVAL 값을 얻어와라!
		int boardNo = boardDao.selectNextNo(conn);
		
		if(boardNo>0) { // 게시글 번호를 얻어온 경우
			// 2) 게시글(Board)를 DB에 먼저 삽입
			board.setBoardNo(boardNo);
			board.setBoardContent(board.getBoardContent().replace("\r\n", "<br>"));
			
			result = boardDao.insertBoard(conn, board, boardWriter,secretStatus);
			
			if(result>0 && !fList.isEmpty()) { // 게시글 삽입 성공 시 
				result = 0; // 트랜잭션 처리를 위해 재활용
				
				// 3) fList의 데이터를 하나씩 DB에 삽입
				for(BoardImage file : fList) {
					// 현재 게시글 번호 추가
					file.setBoardNo(boardNo);
					
					result = boardDao.insertBoardImage(conn, file);
					if(result == 0) break; // <= 삽입 실패시 , 무조건 멈춘다. 
				}
			}
		}
		
		// 4) 트랜잭션 처리
		if(result>0) commit(conn);
		else {
			// 5) DB 삽입 실패 시 
			// 서버에 저장된 파일을 삭제
			for(BoardImage file : fList) {
				String path = file.getImagePath();
				String saveFile = file.getImageChangeName();
				
				File failedFile = new File(path+saveFile);
				// -> 매개변수로 지정된 경로의 파일을 취급할 수 있음.
				
				failedFile.delete();
			}
			rollback(conn);
		}
		close(conn);
		return result;	
	}
	
	/** 게시글 작성용 Service(신고)
	 * @param board
	 * @param boardWriter
	 * @param fList
	 * @param category 
	 * @param secretStatus 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard2(Board board, int boardWriter, ArrayList<BoardImage> fList, String secretStatus, String declareId) throws Exception{
		Connection conn = getConnection();
		
		BoardDao boardDao = new BoardDao();
		
		int result1 = 0;
		int declarIdNo = 0;
		int result = 0;
		// 1) 등록될 게시글의 번호를 얻어옴.
		//    -> SEQ_BNO.NEXTVAL 값을 얻어와라!
		int boardNo = boardDao.selectNextNo(conn);
		
		if(boardNo>0) { // 게시글 번호를 얻어온 경우
			// 2) 게시글(Board)를 DB에 먼저 삽입
			board.setBoardNo(boardNo);
			board.setBoardContent(board.getBoardContent().replace("\r\n", "<br>"));
			// 신고 게시글 작성
			result1 = boardDao.insertBoard(conn, board, boardWriter,secretStatus);
			
			if(result1>0) { // 성공했다면,
				 
				// 신고자의 아이디 조회용 	
				declarIdNo = boardDao.findDelcareId(conn, declareId);
				
				if(declarIdNo>0) { // 성공했다면,
					
					// 신고정보 테이블에 추가하기 
					result = boardDao.insertDeclareInfo(conn,board,boardWriter,declarIdNo);
			
					if(result>0 && !fList.isEmpty()) { // 게시글 삽입 성공 시 
						result = 0; // 트랜잭션 처리를 위해 재활용
						
						// 3) fList의 데이터를 하나씩 DB에 삽입
						for(BoardImage file : fList) {
							// 현재 게시글 번호 추가
							file.setBoardNo(boardNo);
							
							result = boardDao.insertBoardImage(conn, file);
							
							if(result == 0) break; // <= 삽입 실패시 , 무조건 멈춘다. 
						}
					}
				}
			}
		}
		
		// 4) 트랜잭션 처리
		if(result>0) commit(conn);
		else {
			// 5) DB 삽입 실패 시 
			// 서버에 저장된 파일을 삭제
			for(BoardImage file : fList) {
				String path = file.getImagePath();
				String saveFile = file.getImageChangeName();
				
				File failedFile = new File(path+saveFile);
				// -> 매개변수로 지정된 경로의 파일을 취급할 수 있음.
				
				failedFile.delete();
			}
			rollback(conn);
		}
		close(conn);
		return result;	
	}

	/** 수정화면용 Service
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public Board updateBoardGo(int no) throws Exception{
		Connection conn = getConnection();
		
		Board board = new BoardDao().updateBoardGo(conn, no);
	
		board.setBoardContent(board.getBoardContent().replace("<br>", "\r\n"));
		
		close(conn);
		return board;
		
	}

	/** 신고당한 아이디 조회용 Service
	 * @param boardNo
	 * @return declaredId
	 * @throws Exception
	 */
	public String findDeclaredId(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		String declaredId = new BoardDao().findDeclaredId(conn, boardNo);
		
		close(conn);
		return declaredId;
	}

	public int updateBoard(Board board, int boardWriter, ArrayList<BoardImage> fList, String[] beforeImg,
			String savePath, String secret) throws Exception{
		
		Connection conn = getConnection();
		BoardDao boardDao = new BoardDao();
		int result = 0;
		
		int boardNo = board.getBoardNo();
			
		// 게시글(Board)를 DB에 먼저 수정
		board.setBoardNo(boardNo);
		result = boardDao.updateBoard(conn, board, boardWriter, secret);
		
		if(result > 0 && !fList.isEmpty()) { // 게시글 수정 성공 시
			result = 0; // 트랜잭션 처리를 위해 재활용
			// 기존  		수정
			//          1,2,3  --> 1,2,3 추가
			//  1,2     3,4    --> 1,2 수정
			//  1,2		1,3,4  --> 2수정, 4추가
			
			//  1,2            --> 1,2 삭제
			//  1,2     1      --> 2 삭제
//			
//			if(beforeImg != null) {
//				// 수정하려는 게시글에 있는 이미지 조회
//				List<BoardImage> imgList = boardDao.selectFiles(conn, board.getBoardNo());
//				
//				int idx = 0; // fList 접근용 
//				for(String beforePath : beforeImg) {
//	               if(!beforePath.equals("")) { 
//	            	   // 첨부 파일의 수정내용이 있다면
//	            	   System.out.println("beforePath : " + beforePath);
//	            	   System.out.println("fList.get(idx).getImageChangeName() : " + fList.get(idx).getImageChangeName());
//	                  result = boardDao.updateAttachment(conn, beforePath, fList.get(idx).getImageChangeName());
//	                  if(result == 0) break;
//	                  idx++;
//	               }
//				}
//				
//				//if(result !=0 && idx < fList.size()) {
//				if(idx < fList.size()) {
//					for(int i=idx ; i<fList.size() ; i++) {
//						result = boardDao.insertBoardImage(conn, fList.get(i));
//						if(result == 0) break;
//					}
//				}
//				
//				
//				
//			}else {
//				// 이미지가 없던글에 이미지 추가 시
//				// fList의 데이터를 하나씩 DB에 삽입
//				for(BoardImage file : fList) {
//					// 현재 게시글 번호 추가
//					
//					file.setBoardNo(boardNo);
//					result = boardDao.insertBoardImage(conn, file);
//					// 삽입 실패 시
//					if(result == 0) break;
//				}
//			}
		}
		
		// 4) 트랜잭션 처리
		if(result > 0) {
			commit(conn);
			if(beforeImg != null) {
				for(String beforePath : beforeImg) {
		            File faildFile = new File(savePath+beforePath);
		            faildFile.delete();
	            }
			}
		}
		else {
			
			// 5) DB 삽입 실패 시 서버에 저장된 파일을 삭제
			for(BoardImage file : fList) {
				String path = file.getImagePath();
				String saveFile = file.getImageChangeName();
				
				File failedFile = new File(path + saveFile);
				
				failedFile.delete();
			}
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
