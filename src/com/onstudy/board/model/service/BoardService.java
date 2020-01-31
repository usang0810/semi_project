package com.onstudy.board.model.service;

import static com.onstudy.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.onstudy.board.model.dao.BoardDao;
import com.onstudy.board.model.vo.Board;
import com.onstudy.board.model.vo.BoardComment;
import com.onstudy.board.model.vo.BoardImage;
public class BoardService {

	/** 게시판 게시글 수 조회용 Service
	 * @param boardType 
	 * @param searchValue 
	 * @param searchKey 
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(String boardType, String searchKey, String searchValue) throws Exception{
		Connection conn = getConnection();
		
		String condition = null;
		// query문의 조건을 서비스단에서 가공한다.
		searchValue = "'%' || '" + searchValue +"' || '%'";
		// ex) '%공지%'
			if(boardType.equals("FSEARCH")) {
				switch(searchKey) {
					case "title" : condition = " BOARD_TITLE LIKE " + searchValue; break; 
					case "writer" : condition = " MEMBER_ID LIKE " + searchValue; break;   
					case "content" : condition = " BOARD_CONTENT LIKE " + searchValue; break; 
				}
			}else if(boardType.equals("SDSEARCH")){
				switch(searchKey) {
					case "all" : condition = " BOARD_TYPE IN('S','D')"; break; 
					case "onlySuggest" : condition = " BOARD_TYPE = 'S' "; break;   
					case "onlyDeclare" : condition = " BOARD_TYPE = 'D' "; break; 
				}
				condition += " AND (BOARD_TITLE LIKE " + searchValue + "OR BOARD_CONTENT LIKE " + searchValue + ") AND BOARD_STATUS = 'Y' ORDER BY BOARD_MODIFY_DT DESC"; 
			}
			
			int listCount = new BoardDao().getListCount(conn, boardType, searchKey, searchValue, condition);
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
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoard(String searchKey, String searchValue, String boardType) throws Exception{
		Connection conn = getConnection();
		
		String condition = null;
		// query문의 조건을 서비스단에서 가공한다.
		searchValue = "'%' || '" + searchValue +"' || '%'";
		// ex) '%공지%'
			if(boardType.equals("FSEARCH")) {
				switch(searchKey) {
					case "title" : condition = " BOARD_TITLE LIKE " + searchValue; break; 
					case "writer" : condition = " MEMBER_ID LIKE " + searchValue; break;   
					case "content" : condition = " BOARD_CONTENT LIKE " + searchValue; break; 
				}
			}else if(boardType.equals("SDSEARCH")){
				switch(searchKey) {
					case "all" : condition = " BOARD_TYPE IN('S','D')"; break; 
					case "onlySuggest" : condition = " BOARD_TYPE = 'S' "; break;   
					case "onlyDeclare" : condition = " BOARD_TYPE = 'D' "; break; 
				}
				condition += " AND (BOARD_TITLE LIKE " + searchValue + "OR BOARD_CONTENT LIKE " + searchValue + ") AND BOARD_STATUS = 'Y' ORDER BY BOARD_MODIFY_DT DESC"; 
			}
			List<Board> bList = new BoardDao().searchBoard(conn, condition, boardType);
			close(conn);
			return bList;
	}

//	/** 신고자 아이디 조회 Service
//	 * @param id
//	 * @return result
//	 * @throws Exception
//	 */
//	public int confirmDeclareId(String id) throws Exception{
//		Connection conn = getConnection();
//		int result = new BoardDao().confirmDeclareId(conn, id);
//		close(conn);
//		return result;
//	}
	
	/** 댓글 등록용 Service
	 * @param reply
	 * @param replyWriter
	 * @return resul
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

	/** 게시글 등록용 Service
	 * @param board
	 * @param boardWriter
	 * @param fList
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board, int boardWriter, ArrayList<BoardImage> fList) throws Exception{
		Connection conn = getConnection();
		
		BoardDao boardDao = new BoardDao();
		
		int result = 0;
		
		// 1) 등록될 게시글의 번호를 얻어옴.
		//    -> SEQ_BNO.NEXTVAL 값을 얻어와라!
		int boardNo = boardDao.selectNextNo(conn);
		
		if(boardNo>0) { // 게시글 번호를 얻어온 경우
			// 2) 게시글(Board)를 DB에 먼저 삽입
			board.setBoardNo(boardNo);
			result = boardDao.insertBoard(conn, board, boardWriter);
			
			if(result>0) { // 게시글 삽입 성공 시 
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
	
	

}
