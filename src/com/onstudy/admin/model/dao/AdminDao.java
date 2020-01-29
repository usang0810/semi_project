package com.onstudy.admin.model.dao;

import static com.onstudy.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onstudy.member.model.dao.MemberDao;
import com.onstudy.member.model.vo.Member;

public class AdminDao {
	private Properties prop = null;

	public AdminDao() throws Exception {
		// member 관련 sql 파일을 관리할 properties 파일 생성
		String fileName = MemberDao.class.getResource("/com/onstudy/sql/admin/admin-query.properties").getPath();

		prop = new Properties();

		prop.load(new FileReader(fileName));
	}

	/** 조건에 맞는 회원수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @param parseInt
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(Connection conn, String subQuery, int parseInt) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int mListCount = 0;
		
		String query = prop.getProperty("getMemberListCount");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			pstmt.setInt(1, parseInt);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mListCount;
	}

	/** 조건에 맞는 회원수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @param content
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(Connection conn, String subQuery, String content) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int mListCount = 0;
		
		String query = prop.getProperty("getMemberListCount");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			pstmt.setString(1, content);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mListCount;
	}
	
	/**전체 회원수 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(Connection conn, String subQuery) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int mListCount = 0;
		
		String query = prop.getProperty("getMemberListCount");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mListCount;
	}

	/** 전체 회원수 조회용 Dao
	 * @param conn
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(Connection conn) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int mListCount = 0;
		
		String query = prop.getProperty("getMemberListCount");
		try {
			pstmt = conn.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mListCount;
	}

	/** 회원수 목록 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @param parseInt
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn, String subQuery, int parseInt) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Member> mList = null;
		
		String query = prop.getProperty("selectMemberList");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			pstmt.setInt(1, parseInt);
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<Member>();
			
			Member member = null;
			while(rset.next()) {
				member = new Member(rset.getInt("MEMBER_NO"),
									rset.getString("MEMBER_ID"),
									rset.getString("MEMBER_NM"), 
									rset.getString("MEMBER_PHONE"),
									rset.getDate("MEMBER_ENROLL_DT"),
									rset.getInt("MEMBER_POINT"),
									rset.getInt("MEMBER_DECLAR_COUNT"),
									rset.getString("MEMBER_STATUS").charAt(0),
									rset.getString("MEMBER_ACCOUNT"),
									rset.getInt("BANK_CD"));
				
				mList.add(member);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mList;
	}

	/** 회원수 목록 조회용 Dao
	 * @param conn
	 * @param subQuery
	 * @param content
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn, String subQuery, String content) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<Member> mList = null;
		
		String query = prop.getProperty("selectMemberList");
		try {
			pstmt = conn.prepareStatement(query + subQuery);
			pstmt.setString(1, content);
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<Member>();
			
			Member member = null;
			while(rset.next()) {
				member = new Member(rset.getInt("MEMBER_NO"),
									rset.getString("MEMBER_ID"),
									rset.getString("MEMBER_NM"), 
									rset.getString("MEMBER_PHONE"),
									rset.getDate("MEMBER_ENROLL_DT"),
									rset.getInt("MEMBER_POINT"),
									rset.getInt("MEMBER_DECLAR_COUNT"),
									rset.getString("MEMBER_STATUS").charAt(0),
									rset.getString("MEMBER_ACCOUNT"),
									rset.getInt("BANK_CD"));
				
				mList.add(member);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mList;
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


}
