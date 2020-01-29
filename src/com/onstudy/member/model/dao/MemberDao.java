package com.onstudy.member.model.dao;

import static com.onstudy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.onstudy.member.model.vo.Image;
import com.onstudy.member.model.vo.Member;
import com.onstudy.member.model.vo.Order;
import com.onstudy.member.model.vo.Point;

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

	/** 회원 이미지 경로 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return imagePath
	 * @throws Exception
	 */
	public String selectImagePath(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String imagePath = null;
		
		String query = prop.getProperty("selectImagePath");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				imagePath = rset.getString(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return imagePath;
	}

	/** 회원 비밀번호 일치 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @param memberPwd
	 * @return result
	 * @throws Exception
	 */
	public int pwdCheck(Connection conn, int memberNo, String memberPwd) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("pwdCheck");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, memberPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 1;
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 탈퇴용 Dao
	 * @param memberNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("secession");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 회원 아이디 찾기용 Dao
	 * @param conn
	 * @param memberPhone
	 * @return findIdMember
	 * @throws Exception
	 */
	public Member findIdMember(Connection conn, String memberPhone) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member findIdMember = null;
		
		String query = prop.getProperty("findIdMmeber");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberPhone);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				findIdMember = new Member(rset.getString("MEMBER_ID"),
										rset.getString("MEMBER_NM"),
										rset.getDate("MEMBER_ENROLL_DT"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return findIdMember;
	}

	/** 회원 비밀번호 찾기용 Dao
	 * @param conn
	 * @param memberId
	 * @param memberPhone
	 * @return result
	 * @throws Exception
	 */
	public int findPwdMember(Connection conn, String memberId, String memberPhone) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("findPwdMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPhone);
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

	/** 회원 정보 수정용 Dao
	 * @param conn
	 * @param updateMember
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member updateMember) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, updateMember.getMemberPwd());
			pstmt.setString(2, updateMember.getMemberPhone());
			pstmt.setString(3, updateMember.getMemberAccount());
			pstmt.setInt(4, updateMember.getBankCode());
			pstmt.setInt(5, updateMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 기존 프로필 사진 삭제용 Dao
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteProfileImg(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteProfileImg");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 계정 포인트 업데이트용 Dao
	 * @param conn
	 * @param point
	 * @return result
	 * @throws Exception
	 */
	public int updatePoint(Connection conn, Point point) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePoint");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, point.getPoint());
			pstmt.setString(2, point.getPointStatus()+"");
			pstmt.setInt(3, point.getMemberNo());
			pstmt.setInt(4, point.getPointDetailCd());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 포인트 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return point
	 * @throws Exception
	 */
	public int getMemberPoint(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int point = -1;
		
		String query = prop.getProperty("getMemberPoint");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				point = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return point;
	}

	/** 회원 비밀번호 변경용 Dao
	 * @param conn
	 * @param memberId
	 * @param memberPwd
	 * @return result
	 * @throws Exception
	 */
	public int changePwdMember(Connection conn, String memberId, String memberPwd) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("changePwdMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberPwd);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/** 회원 포인트 내역 갯수 조회용 Dao(특정 기간, 입금 또는 출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointInOut
	 * @param pointMonth
	 * @param queryTitle
	 * @return pListCount
	 * @throws Exception
	 */
	public int getPointListCount(Connection conn, int memberNo, char pointInOut, int pointMonth, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int pListCount = 0;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, pointMonth);
			pstmt.setString(3, pointInOut+"");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pListCount;
	}
	
	/** 회원 포인트 내역 갯수 조회용 Dao(모든 기간, 입금 또는 출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointInOut
	 * @param queryTitle
	 * @return pListCount
	 * @throws Exception
	 */
	public int getPointListCount(Connection conn, int memberNo, char pointInOut, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int pListCount = 0;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, pointInOut+"");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pListCount;
	}
	
	/** 회원 포인트 내역 갯수 조회용 Dao(특정 기간, 입출금 모두 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointMonth
	 * @param queryTitle
	 * @return pListCount
	 * @throws Exception
	 */
	public int getPointListCount(Connection conn, int memberNo, int pointMonth, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int pListCount = 0;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, pointMonth);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pListCount;
	}

	/** 회원 포인트 내역 갯수 조회용 Dao(모든 조건)
	 * @param memberNo
	 * @param conn
	 * @param queryTitle
	 * @return pListCount
	 * @throws Exception
	 */
	public int getPointListCount(Connection conn, int memberNo, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int pListCount = 0;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pListCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pListCount;
	}
	

	/** 회원 포인트 내역 리스트 조회용 Dao (특정 기간, 입금 또는 출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointInOut
	 * @param pointMonth
	 * @param currentPage
	 * @param limit
	 * @param queryTitle
	 * @return pList
	 * @throws Exception
	 */
	public List<Point> selectPointList(Connection conn, int memberNo, char pointInOut, int pointMonth, int currentPage,
			int limit, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> pList = null;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, pointMonth);
			pstmt.setString(3, pointInOut+"");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Point>();
			
			Point point = null;
			
			while(rset.next()) {
				point = new Point(rset.getInt("POINT"),
								rset.getString("POINT_STATUS").charAt(0),
								rset.getDate("POINT_UPDATE_DT"),
								rset.getString("MEMBER_NM"),
								rset.getString("POINT_DETAIL_NM"));
				
				pList.add(point);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pList;
	}

	/** 회원 포인트 내역 리스트 조회용 Dao (모든 기간, 입금 또는 출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointInOut
	 * @param currentPage
	 * @param limit
	 * @param queryTitle
	 * @return pList
	 * @throws Exception
	 */
	public List<Point> selectPointList(Connection conn, int memberNo, char pointInOut, int currentPage, int limit,
			String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> pList = null;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, pointInOut+"");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Point>();
			
			Point point = null;
			
			while(rset.next()) {
				point = new Point(rset.getInt("POINT"),
								rset.getString("POINT_STATUS").charAt(0),
								rset.getDate("POINT_UPDATE_DT"),
								rset.getString("MEMBER_NM"),
								rset.getString("POINT_DETAIL_NM"));
				
				pList.add(point);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pList;
	}

	/** 회원 포인트 내역 리스트 조회용 Dao (특정 기간, 입출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param pointMonth
	 * @param currentPage
	 * @param limit
	 * @param queryTitle
	 * @return pList
	 * @throws Exception
	 */
	public List<Point> selectPointList(Connection conn, int memberNo, int pointMonth, int currentPage, int limit,
			String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> pList = null;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, pointMonth);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Point>();
			
			Point point = null;
			
			while(rset.next()) {
				point = new Point(rset.getInt("POINT"),
								rset.getString("POINT_STATUS").charAt(0),
								rset.getDate("POINT_UPDATE_DT"),
								rset.getString("MEMBER_NM"),
								rset.getString("POINT_DETAIL_NM"));
				
				pList.add(point);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pList;
	}

	/** 회원 포인트 내역 리스트 조회용 Dao (모든 기간, 입출금 조회)
	 * @param conn
	 * @param memberNo
	 * @param currentPage
	 * @param limit
	 * @param queryTitle
	 * @return pList
	 * @throws Exception
	 */
	public List<Point> selectPointList(Connection conn, int memberNo, int currentPage, int limit, String queryTitle) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Point> pList = null;
		
		String query = prop.getProperty(queryTitle);
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			pList = new ArrayList<Point>();
			
			Point point = null;
			
			while(rset.next()) {
				point = new Point(rset.getInt("POINT"),
								rset.getString("POINT_STATUS").charAt(0),
								rset.getDate("POINT_UPDATE_DT"),
								rset.getString("MEMBER_NM"),
								rset.getString("POINT_DETAIL_NM"));
				
				pList.add(point);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pList;
	}

	/** 상품 고유번호 생성용 Dao
	 * @param conn
	 * @return merchantUid
	 * @throws Exception
	 */
	public String createMerchantUid(Connection conn) throws Exception{
		Statement stmt = null;
		ResultSet rset = null;
		String merchantUid = null;
		
		String query = prop.getProperty("createMerchantUid");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				merchantUid = rset.getString(1);
			}
			
		}finally {
			close(rset);
			close(stmt);
		}
		
		return merchantUid;
		
	}

	/** 상품정보 삽입용 Dao
	 * @param conn
	 * @param order
	 * @param merchantUid
	 * @return result
	 * @throws Exception
	 */
	public int insertOrder(Connection conn, Order order, String merchantUid) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrder");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, merchantUid);
			pstmt.setString(2, order.getName());
			pstmt.setInt(3, order.getAmount());
			pstmt.setString(4, order.getBuyerName());
			pstmt.setString(5, order.getBuyerTel());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 상품정보 수정용 Dao
	 * @param conn
	 * @param order
	 * @return result
	 * @throws Exception
	 */
	public int updateOrder(Connection conn, Order order) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateOrder");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, order.getImpUid());
			pstmt.setString(2, order.getStatusCode() + "");
			pstmt.setString(3, order.getMerchantUid());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	

}
