package com.onstudy.board.model.dao;

import static com.onstudy.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onstudy.board.model.vo.Board;
import com.onstudy.board.model.vo.BoardComment;
import com.onstudy.board.model.vo.BoardImage;

public class BoardDao {
	 private Properties prop = null;
	   
	   public BoardDao() throws Exception{
	      String fileName = BoardDao.class.getResource("/com/onstudy/sql/board/board-query.properties").getPath();
	      
	      prop = new Properties();
	      
	      prop.load(new FileReader(fileName));
	   }
	   
	/** 게시판 게시글 수 조회용 Dao
	 * @param conn 
	 * @param boardType 
	 * @param searchValue 
	 * @param searchKey 
	 * @param condition 
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String boardType, String searchKey, String searchValue, String condition) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		int listCount = 0;
		String query1 = prop.getProperty("getListCount1");
		String query2 = prop.getProperty("getListCount2");
		String query3 = prop.getProperty("getListCount3");
		
		try {
			stmt = conn.createStatement();
			if(boardType.equals("F")) {
				rset = stmt.executeQuery(query1);
			}else if(boardType.equals("SD")) {
				rset = stmt.executeQuery(query2);
			}else if(boardType.equals("FSEARCH") || boardType.equals("SDSEARCH")) {
				rset = stmt.executeQuery(query3+condition);
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
						          rset.getString("MEMBER_ID"));
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
	 * @param boardType2 
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> searchBoard(Connection conn, String condition, String boardType) throws Exception{
		Statement stmt = null; 	
		ResultSet rset = null;
		List<Board> bList = null;
		
		String query1 = prop.getProperty("searchBoard1");
		String query2 = prop.getProperty("searchBoard2");
		
		try {
			stmt = conn.createStatement();
			if(boardType.equals("FSEARCH")) {
				rset = stmt.executeQuery(query1+condition+query2);
			}else {
				rset = stmt.executeQuery(query1+condition);
			}
			bList = new ArrayList<Board>();
			
			Board board = null;
			
			while(rset.next()) {
				board = new Board(
						  rset.getInt("ROWNUM"),
						  rset.getInt("BOARD_NO"),
					      rset.getString("TYPE_TRANS"),
						  rset.getString("BOARD_TITLE"),
						  rset.getString("BOARD_CONTENT"),
				          rset.getDate("BOARD_MODIFY_DT"),
				          rset.getString("MEMBER_ID"));
				bList.add(board);
			}
		}finally {
			close(rset);
			close(stmt);
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
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board, int boardWriter) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, boardWriter);
					
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


}
