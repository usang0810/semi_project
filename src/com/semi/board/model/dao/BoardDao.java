package com.semi.board.model.dao;

import static com.semi.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.board.model.vo.Board;
import com.semi.board.model.vo.BoardComment;
import com.semi.board.model.vo.BoardImage;

public class BoardDao {
	 private Properties prop = null;
	   
	   public BoardDao() throws Exception{
	      String fileName = BoardDao.class.getResource("/com/semi/sql/board/board-query.properties").getPath();
	      
	      prop = new Properties();
	      
	      prop.load(new FileReader(fileName));
	   }
	   
	/** 게시판 게시글 수 조회용 Dao
	 * @param conn 
	 * @param boardType 
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String boardType) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		int listCount = 0;
		String query1 = prop.getProperty("getListCount1");
		String query2 = prop.getProperty("getListCount2");
		
		try {
			stmt = conn.createStatement();
			if(boardType.equals("F")) {
				rset = stmt.executeQuery(query1);
			}else if(boardType.equals("SD")) {
				rset = stmt.executeQuery(query2);
			}
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	
	
	/** 게시판 게시글 수 조회용 Dao
	 * @param conn
	 * @param boardType
	 * @param searchKey
	 * @param searchValue
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCountSearch(Connection conn, String boardType, String searchKey, String searchValue,String condition) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		int listCount = 0;
		
		
		String query1 = prop.getProperty("getListCount1");
		String query2 = prop.getProperty("getListCount2");
		try {
			stmt = conn.createStatement();
			if(boardType.equals("FSEARCH")) {
				rset = stmt.executeQuery(query1+condition);
			}else if(boardType.equals("SDSEARCH")) {
				rset = stmt.executeQuery(query2+condition);
			}
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	/** 게시판 목록 조회용 Dao
	 * @param conn
	 * @param currentPage
	 * @param limit
	 * @param boardType 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectList(Connection conn, int currentPage, int limit, String boardType) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Board> bList = null;
		String query = null;
		
		if(boardType.charAt(0)=='F') {
			query = prop.getProperty("selectList1");
		}else {
			query = prop.getProperty("selectList2");
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			bList = new ArrayList<Board>();
			Board board = null;
			while(rset.next()) {
				board = new Board(
								  rset.getInt("RNUM"),
							      rset.getInt("BOARD_NO"),
							      rset.getString("TYPE_TRANS"),
								  rset.getString("BOARD_TITLE"),
								  rset.getString("BOARD_CONTENT"),
						          rset.getDate("BOARD_MODIFY_DT"),
						          rset.getString("MEMBER_ID"),
						          rset.getString("SECRET_STATUS").charAt(0));
				bList.add(board);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return bList;
	}
	
	/** 게시글 상세 조회용 Dao
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board(rset.getInt("RNUM"),
						          rset.getString("TYPE_TRANS"),
						          rset.getString("BOARD_TITLE"),
						          rset.getString("BOARD_CONTENT"),
						          rset.getDate("BOARD_MODIFY_DT"),
						          rset.getInt("BOARD_COUNT"),
						          rset.getString("MEMBER_ID")
						          );
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	/** 게시글 조회수 증가용 Dao
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseCount(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 게시글 삭제용 Dao
	 * @param conn
	 * @param no
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int no) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 게시글 검색용 Dao
	 * @param conn
	 * @param condition
	 * @param limit 
	 * @param currentPage 
	 * @param boardType2 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoard(Connection conn, String condition, String boardType, int currentPage, int limit) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Board> bList = null;
		
		String query1 = prop.getProperty("searchBoard1");
		String query2 = prop.getProperty("searchBoard2");
		String query3 = prop.getProperty("searchBoard3");
		
		try {
			if(boardType.equals("FSEARCH")) {
				pstmt = conn.prepareStatement(query1+condition+query3);
			}else if(boardType.equals("SDSEARCH")) {
				pstmt = conn.prepareStatement(query2+condition+query3);
			}
			
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			bList = new ArrayList<Board>();
			
			Board board = null;
			
			while(rset.next()) {
				board = new Board(
						  rset.getInt("RNUM"),
						  rset.getInt("BOARD_NO"),
					      rset.getString("TYPE_TRANS"),
						  rset.getString("BOARD_TITLE"),
						  rset.getString("BOARD_CONTENT"),
				          rset.getDate("BOARD_MODIFY_DT"),
				          rset.getString("MEMBER_ID"),
				          rset.getString("SECRET_STATUS").charAt(0));
				         
				bList.add(board);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return bList;
	}

	/** 신고자 아이디 조회 Dao
	 * @param conn
	 * @param id
	 * @return result
	 * @throws Exception
	 */
	public int confirmDeclareId(Connection conn, String id) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("confirmDeclareId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/** 댓글 등록용 Dao
	 * @param conn
	 * @param reply
	 * @param replyWriter
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, BoardComment reply, int replyWriter) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getCommentContent());
			pstmt.setInt(2, reply.getBoardCommentWriter());
			pstmt.setInt(3, replyWriter);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 댓글 리스트 조회용 Dao 
	 * @param conn
	 * @param boardId
	 * @return rList
	 * @throws Exception
	 */
	public List<BoardComment> selectReplyList(Connection conn, int boardId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BoardComment> rList = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardId);
			
			rset = pstmt.executeQuery();
			
			rList = new ArrayList<BoardComment>();
			
			BoardComment reply = null;
			
			while(rset.next()) {
				reply = new BoardComment(rset.getInt("COMMENT_NO"),
										 rset.getString("COMMENT_CONTENT"),
										 rset.getTimestamp("COMMENT_MODIFY_DT"),
										 rset.getInt("BOARD_NO"),
										 rset.getString("MEMBER_ID"));
						
				rList.add(reply);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return rList;
	}

	/** 다음 게시글 번호 반환용 Dao
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		int boardNo = 0;
		
		String query = prop.getProperty("selectNextNo");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				boardNo = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return boardNo;
	}


	/** 게시글 등록용 Dao
	 * @param conn
	 * @param board
	 * @param boardWriter
	 * @param secretStatus 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board, int boardWriter, String secretStatus) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardType());
			pstmt.setString(3, board.getBoardTitle());
			pstmt.setString(4, board.getBoardContent());
			pstmt.setInt(5,boardWriter);
			pstmt.setString(6,secretStatus);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 게시글 파일(이미지) 정보 삽입용 Dao
	 * @param conn
	 * @param file
	 * @return result
	 * @throws Exception
	 */
	public int insertBoardImage(Connection conn, BoardImage file) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoardImage");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, file.getImagePath());
			pstmt.setInt(2, file.getBoardNo());
			pstmt.setString(3, file.getImageOriginName());
			pstmt.setString(4, file.getImageChangeName());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 게시글 이미지 파일 조회용 Dao 
	 * @param conn
	 * @param boardNo
	 * @return files
	 * @throws Exception
	 */
	public List<BoardImage> selectFiles(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardImage> files = null;
		
		String query = prop.getProperty("selectFiles");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rset = pstmt.executeQuery();
			
			files = new ArrayList<BoardImage>();
			BoardImage file = null;
			while(rset.next()) {
				
				file = new BoardImage(rset.getInt(1),
						rset.getString(2),
						rset.getDate(3),
						rset.getString(4).charAt(0),
						rset.getInt(5),
						rset.getString(6),
						rset.getString(7)
				);
				files.add(file);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return files;
	}

	/** 게시글 이미지 다운로드용 Dao
	 * @param conn
	 * @param fNo
	 * @return file
	 * @throws Exception
	 */
	public BoardImage selectFile(Connection conn, int fNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardImage file = null;
		String query = prop.getProperty("selectFile");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, fNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				file = new BoardImage(rset.getString("IMAGE_PATH"),
									rset.getString("IMAGE_ORIGIN_NAME"), 
									rset.getString("IMAGE_CHANGE_NAME"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return file;
	}

	/** 회원 신고한 횟수 조회용 Dao
	 * @param conn
	 * @param id
	 * @param loginId
	 * @return result
	 * @throws Exception
	 */
	public int isPossibleDelcare(Connection conn, String id, String loginId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("isPossibleDelcare");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,loginId);
			pstmt.setString(2, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/** 신고정보테이블 작성용 Dao
	 * @param conn
	 * @param board
	 * @param boardWriter
	 * @param declareBno
	 * @return result
	 * @throws Exception
	 */
	public int insertDeclareInfo(Connection conn, Board board, int boardWriter, int declarIdNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0 ;
		
		String query = prop.getProperty("insertDeclareInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,board.getBoardNo());
			pstmt.setInt(2,declarIdNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 신고자의 아이디 조회용 Dao
	 * @param conn
	 * @param declareId
	 * @return declareBno
	 * @throws Exception
	 */
	public int findDelcareId(Connection conn, String declareId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int declareBno = 0;
		String query= prop.getProperty("findDelcareId");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,declareId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				declareBno = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return declareBno;
	}

	/** 신고당한 아이디조회용 Dao
	 * @param conn
	 * @param boardNo
	 * @return declaredId
	 * @throws Exception
	 */
	public String findDeclaredId(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String declaredId = null;
		
		String query = prop.getProperty("findDeclaredId");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				declaredId = rset.getString(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
				
		return declaredId;
				
	}

	/** 게시글 수정용 DB 가져오기 Dao
	 * @param conn
	 * @param no
	 * @return
	 * @throws Exception
	 */
	public Board updateBoardGo(Connection conn, int no) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		
		String query = prop.getProperty("updateBoardGo");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board(rset.getInt("BOARD_NO"),
							      rset.getString("BOARD_TITLE"),
								  rset.getString("BOARD_CONTENT"),
						          rset.getString("TYPE_TRANS"),
						          rset.getString("SECRET_STATUS").charAt(0)
						          );
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public int updateBoard(Connection conn, Board board, int boardWriter, String secret) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,board.getBoardTitle());
			pstmt.setString(2,board.getBoardContent());
			pstmt.setString(3,secret);
			pstmt.setInt(4,board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
				
	}

	public int updateAttachment(Connection conn, String beforePath, String imageChangeName) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAttachment");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, imageChangeName);
			pstmt.setString(2, beforePath);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	

}
