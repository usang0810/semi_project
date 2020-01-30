package com.onstudy.admin.model.dao;

import static com.onstudy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onstudy.member.model.dao.MemberDao;
import com.onstudy.member.model.vo.Member;
import com.onstudy.onstudy.model.vo.Onstudy;
import com.onstudy.studynote.model.vo.StudyNote;

public class AdminDao {
	private Properties prop = null;

	public AdminDao() throws Exception {
		// member 관련 sql 파일을 관리할 properties 파일 생성
		String fileName = MemberDao.class.getResource("/com/onstudy/sql/admin/admin-query.properties").getPath();

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
											rset.getInt("ALL_COUNT"));
				oList.add(onstudy);
			}
				
		}finally {
			close(rset);
			close(stmt);
		}
		
		return oList;
	}


}
