package com.onstudy.member.model.dao;

import static com.onstudy.common.JDBCTemplate.*;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.onstudy.member.model.vo.Image;
import com.onstudy.member.model.vo.Member;

public class MemberDao {
	   private Properties prop = null;
	   
	   public MemberDao() throws Exception{
	      // member 관련 sql 파일을 관리할 properties 파일 생성
	      String fileName = MemberDao.class.getResource("/com/onstudy/sql/member/member-query.properties").getPath();
	      
	      prop = new Properties();
	      
	      prop.load(new FileReader(fileName));
	   }

	   /** 로그인용 Dao
	    * @param conn
	    * @param inputMember
	    * @return loginMember
	    * @throws Exception
	    */
	   public Member selectMember(Connection conn, Member inputMember) throws Exception{
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      Member loginMember = null;
	      
	      String query = prop.getProperty("selectMember");
	      
	      try {
	         
	         pstmt = conn.prepareStatement(query);
	         
	         pstmt.setString(1, inputMember.getMemberId());
	         pstmt.setString(2, inputMember.getMemberPwd());
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            
	            int memberNo = rset.getInt("MEMBER_NO");
	            String memberId = rset.getString("MEMBER_ID");
	            String memberPwd = rset.getString("MEMBER_PWD");
	            String memberNm = rset.getString("MEMBER_NM");
	            String memberPhone = rset.getString("MEMBER_PHONE");
	            char memberGrade = rset.getString("MEMBER_GRADE").charAt(0);
	            Date memberEnrollDt = rset.getDate("MEMBER_ENROLL_DT");
	            int memberPoint = rset.getInt("MEMBER_POINT");
	            int memberDeclarCount = rset.getInt("MEMBER_DECLAR_COUNT");
	            char memberStatus = rset.getString("MEMBER_STATUS").charAt(0);
	            String memberAccount = rset.getString("MEMBER_ACCOUNT");
	            int bankCode = rset.getInt("BANK_CD");
	            
	            loginMember = new Member(memberNo, memberId, memberPwd, memberNm, memberPhone, memberGrade, memberEnrollDt, memberPoint, memberDeclarCount, memberStatus, memberAccount, bankCode);
	         }
	         
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return loginMember;
	   }

	/** 회원 가입용 Dao
	 * @param conn
	 * @param signupMember
	 * @return result
	 * @throws Exception
	 */
	public int signupMember(Connection conn, Member signupMember) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("signupMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, signupMember.getMemberId());
			pstmt.setString(2, signupMember.getMemberPwd());
			pstmt.setString(3, signupMember.getMemberNm());
			pstmt.setString(4, signupMember.getMemberPhone());
			pstmt.setString(5, signupMember.getMemberAccount());
			pstmt.setInt(6, signupMember.getBankCode());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 번호 조회용 Dao
	 * @param conn
	 * @param memberId
	 * @return memberNo
	 * @throws Exception
	 */
	public int selectMemberNo(Connection conn, String memberId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int memberNo = 0;
		
		String query = prop.getProperty("selectMemberNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberNo = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return memberNo;
	}

	/** 회원 프로필 이미지 삽입용 Dao
	 * @param conn
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int insertProfileImage(Connection conn, Image profileImage) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertProfileImage");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, profileImage.getImagePath());
			pstmt.setInt(2, profileImage.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 아이디 중복 검사용 Dao
	 * @param conn
	 * @param inputId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(Connection conn, String inputId) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("idDupCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			
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
}
