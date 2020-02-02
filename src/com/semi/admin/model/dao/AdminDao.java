package com.semi.admin.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.board.model.vo.Board;
import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.Member;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.studynote.model.vo.StudyNote;

public class AdminDao {
	private Properties prop = null;

	public AdminDao() throws Exception {
		// member 관련 sql 파일을 관리할 properties 파일 생성
		String fileName = MemberDao.class.getResource("/com/semi/sql/admin/admin-query.properties").getPath();

		prop = new Properties();

		prop.load(new FileReader(fileName));
	}
	
	/**전체 회원수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(Connection conn, String subQuery) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		int mListCount = 0;
		
		String query = prop.getProperty("getMemberListCount");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query + subQuery);
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return mListCount;
	}

	/** 회원수 목록 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn, String subQuery) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Member> mList = null;
		
		String query = prop.getProperty("selectMemberList");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<Member>();
			
			Member member = null;
			while(rset.next()) {
				member = new Member(rset.getInt("MEMBER_NO"),
									rset.getString("MEMBER_ID"),
									rset.getString("MEMBER_NM"), 
									rset.getString("MEMBER_PHONE"),
									rset.getInt("MEMBER_POINT"),
									rset.getInt("MEMBER_DECLAR_COUNT"),
									rset.getString("MEMBER_STATUS").charAt(0));
				
				mList.add(member);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mList;
	}

	/** 회원 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return member
	 */
	public Member getMember(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member member = null;
		String query = prop.getProperty("getMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(memberNo,
									rset.getString("MEMBER_ID"),
									rset.getString("MEMBER_NM"),
									rset.getString("MEMBER_PHONE"),
									rset.getDate("MEMBER_ENROLL_DT"),
									rset.getInt("MEMBER_POINT"),
									rset.getInt("MEMBER_DECLAR_COUNT"),
									rset.getString("MEMBER_STATUS").charAt(0),
									rset.getString("ACCOUNT"),
									rset.getString("BANK_NM"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	/** 학습노트 리스트 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return noteList
	 * @throws Exception
	 */
	public List<StudyNote> getNoteList(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<StudyNote> noteList = null;
		
		String query = prop.getProperty("getNoteList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			noteList = new ArrayList<StudyNote>();
			
			while(rset.next()) {
				StudyNote studyNote = new StudyNote();
				studyNote.setStudyNoteNo(rset.getInt("STUDYNOTE_NO"));
				studyNote.setStudyNoteTitle(rset.getString("STUDYNOTE_TITLE"));
				
				noteList.add(studyNote);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return noteList;
	}

	/** 회원 온스터디 리스트 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return onstudyList
	 * @throws Exception
	 */
	public List<Onstudy> getOnstudyList(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Onstudy> noteList = null;
		
		String query = prop.getProperty("getOnstudyList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			noteList = new ArrayList<Onstudy>();
			
			while(rset.next()) {
				Onstudy onstudy = new Onstudy();
				onstudy.setOnstudyNo(rset.getInt("ONSTUDY_NO"));
				onstudy.setOnstudyTitle(rset.getString("ONSTUDY_TITLE"));
				onstudy.setOnstudyEndDt(rset.getDate("ONSTUDY_END_DT"));
				
				noteList.add(onstudy);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return noteList;
	}

	/** 회원 온스터디 리스트 조회용 Dao(조건)
	 * @param conn
	 * @param memberNo
	 * @param subQuery
	 * @return onstudyList
	 * @throws Exception 
	 */
	public List<Onstudy> getOnstudyList(Connection conn, int memberNo, String subQuery) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Onstudy> noteList = null;
		
		String query = prop.getProperty("getOnstudyList");
		
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			noteList = new ArrayList<Onstudy>();
			
			while(rset.next()) {
				Onstudy onstudy = new Onstudy();
				onstudy.setOnstudyNo(rset.getInt("ONSTUDY_NO"));
				onstudy.setOnstudyTitle(rset.getString("ONSTUDY_TITLE"));
				onstudy.setOnstudyEndDt(rset.getDate("ONSTUDY_END_DT"));
				
				noteList.add(onstudy);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return noteList;
	}

	/** 회원 상태 정보 수정용 Dao
	 * @param conn
	 * @param memberNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeMemberStatus(Connection conn, int memberNo, String status) throws Exception{
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("changeMemberStatus");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 삭제용 Dao
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 온스터디 수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return oListCount
	 * @throws Exception
	 */
	public int getOnstudyListCount(Connection conn, String subQuery) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("getOnstudyListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query + subQuery);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		}finally {
			close(stmt);
		}
		
		return result;
	}

	/** 온스터디 목록 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return oList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyList(Connection conn, String subQuery) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		List<Onstudy> oList = null;
		
		String query = prop.getProperty("selectOnstudyList");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query + subQuery);
			
			oList = new ArrayList<Onstudy>();
			
			while(rset.next()) {
				Onstudy onstudy = new Onstudy(rset.getInt("ONSTUDY_NO"),
											rset.getString("ONSTUDY_TITLE"),
											rset.getDate("ONSTUDY_START_DT"),
											rset.getDate("ONSTUDY_END_DT"),
											rset.getInt("ONSTUDY_FEE"), 
											rset.getString("CATEGORY_NM"),
											rset.getInt("ALL_COUNT"),
											rset.getString("ONSTUDY_STATUS"));
				
				oList.add(onstudy);
			}
				
		}finally {
			close(rset);
			close(stmt);
		}
		
		return oList;
	}

	/** 온스터디 상세 조회용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @return onstudy
	 * @throws Exception
	 */
	public Onstudy selectOnstudy(Connection conn, int onstudyNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Onstudy onstudy = null;
		
		String query = prop.getProperty("selectOnstudy");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				onstudy = new Onstudy(onstudyNo,
									rset.getString("ONSTUDY_TITLE"),
									rset.getDate("ONSTUDY_START_DT"),
									rset.getDate("ONSTUDY_END_DT"),
									rset.getInt("ONSTUDY_CERTIFY_COUNT"),
									rset.getInt("ONSTUDY_FEE"),
									rset.getString("ONSTUDY_STATUS"),
									rset.getString("MEMBER_ID"),
									rset.getString("CATEGORY_NM"),
									rset.getInt("ALL_COUNT"),
									rset.getInt("MEMBER_NO"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return onstudy;
	}

	/** 온스터디 상태 변경용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeOnstudyStatus(Connection conn, int onstudyNo, String status) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeOnstudyStatus");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, onstudyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 게시판 목록 수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return bListCount
	 * @throws Exception
	 */
	public int getBoardListCount(Connection conn, String subQuery) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		int bListCount = 0;
		String query = prop.getProperty("getBoardListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query + subQuery);
			
			if(rset.next()) {
				bListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return bListCount;
	}

	/** 게시판 목록 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, String subQuery) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		
		List<Board> bList = null;
		
		String query = prop.getProperty("getBoardList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query + subQuery);
			
			bList = new ArrayList<Board>();
			Board board = null;
			
			while(rset.next()) {
				board = new Board(rset.getInt("RNUM"),
								rset.getInt("BOARD_NO"),
								rset.getString("BOARD_TITLE"),
								rset.getDate("BOARD_MODIFY_DT"),
								rset.getString("BOARD_STATUS").charAt(0),
								rset.getString("MEMBER_ID"),
								rset.getString("DECLAR_STATUS"));
				bList.add(board);
			}
			
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return bList;
	}

	/** 게시글 상세조회용 Dao
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
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board(boardNo,
								rset.getString("BOARD_TYPE"),
								rset.getString("BOARD_TITLE"),
								rset.getString("BOARD_CONTENT"),
								rset.getDate("BOARD_MODIFY_DT"),
								rset.getString("BOARD_STATUS").charAt(0),
								rset.getInt("BOARD_COUNT"),
								rset.getString("MEMBER_ID"),
								rset.getString("DECLAR_STATUS"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	/** 게시판 상태 변경용 Dao
	 * @param conn
	 * @param boardNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeBoardStatus(Connection conn, int boardNo, String status) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeBoardStatus");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 신고 대상자 아이디 조회용 Dao
	 * @param conn
	 * @param boardNo
	 * @return declarId
	 * @throws Exception
	 */
	public String selectDeclarId(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String declarId = null;
		String query = prop.getProperty("selectDeclarId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				declarId = rset.getString(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return declarId;
	}

	/** 신고 게시판 처리 상태 변경용 Dao
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int changeDeclarStatus(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changeDeclarStatus");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 신고 횟수 증가용 Dao
	 * @param conn
	 * @param declarId
	 * @return result
	 * @throws Exception
	 */
	public int updateDeclarCount(Connection conn, String declarId) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateDeclarCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, declarId);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


}
