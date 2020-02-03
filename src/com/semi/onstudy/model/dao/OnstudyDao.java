package com.semi.onstudy.model.dao;

import static com.semi.common.JDBCTemplate.*;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.member.model.dao.MemberDao;
import com.semi.member.model.vo.MyOnstudy;
import com.semi.onstudy.model.vo.CAttachment;
import com.semi.onstudy.model.vo.CBoard;
import com.semi.onstudy.model.vo.CertifyBoardTotal;
import com.semi.onstudy.model.vo.CertifyCount;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.onstudy.model.vo.Thumbnail;

public class OnstudyDao {

	private Properties prop = null;
   
	public OnstudyDao() throws Exception{

		String fileName = MemberDao.class.getResource("/com/semi/sql/onstudy/onstudy-query.properties").getPath();
	      
		prop = new Properties();
		      
		prop.load(new FileReader(fileName));
	
	}
   

	// 메인
	public List<Onstudy> selectMainList(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		List<Onstudy> mainList = null;
		String query = prop.getProperty("selectMainList");
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			mainList=new ArrayList<Onstudy>();
			Onstudy onstudy = null;
		while(rset.next()) {
			onstudy = new Onstudy(rset.getInt("ONSTUDY_NO"),
									rset.getString("ONSTUDY_TITLE"),
									rset.getInt("MEMBER_COUNT"),
									rset.getDate("ONSTUDY_START_DT"),
									rset.getDate("ONSTUDY_END_DT"),
									rset.getDate("ONSTUDY_DEADLINE_DT"),
									rset.getInt("ONSTUDY_CERTIFY_COUNT"),
									rset.getInt("ONSTUDY_FEE"),
									rset.getInt("ONSTUDY_WEEKS"),
									rset.getString("CATEGORY_NM"),
									rset.getInt("ONSTUDY_Dday"),
									rset.getString("IMAGE_PATH"));
			mainList.add(onstudy);
		}
		} finally {
		close(rset);
		close(stmt);
		}
		return mainList;
	}

   
   /** 로그인된 메인 온스터디 목록 조회용 Dao
	 * @param conn
	 * @return pList
	 * @throws Exception 
	 */
	public List<Onstudy> selectOnstudyPList(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		List<Onstudy> pList = null;
		String query = prop.getProperty("selectOnstudyPList");
		try {
			stmt = conn.createStatement();
			rset=stmt.executeQuery(query);
			pList = new ArrayList<Onstudy>();
			Onstudy onstudy = null;
			while (rset.next()) {
				onstudy = new Onstudy(rset.getInt("ONSTUDY_NO"),
						rset.getString("ONSTUDY_TITLE"),
						rset.getInt("ONSTUDY_CERTIFY_COUNT"),
						rset.getDate("ONSTUDY_DEADLINE_DT"),
						rset.getInt("MEMBER_COUNT"),
						rset.getInt("ONSTUDY_DDAY"),
						rset.getInt("SUM_FEE"),
						rset.getString("IMAGE_PATH"));
				pList.add(onstudy);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return pList;
	}
	
	/** 온스터디 목록(참여인원) 조회용 Dao
	 * @param conn
	 * @return mList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyMList(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		List<Onstudy> mList = null;
		String query = prop.getProperty("selectOnstudyMList");
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			mList=new ArrayList<Onstudy>();
			Onstudy onstudy = null;
			while(rset.next()) {
				onstudy = new Onstudy(rset.getInt("ONSTUDY_NO"),
									rset.getString("ONSTUDY_TITLE"),
									rset.getDate("ONSTUDY_START_DT"),
									rset.getDate("ONSTUDY_END_DT"),
									rset.getInt("ONSTUDY_CERTIFY_COUNT"),
									rset.getInt("ONSTUDY_FEE"),
									rset.getInt("ONSTUDY_WEEKS"),
									rset.getDate("ONSTUDY_DEADLINE_DT"),
									rset.getString("CATEGORY_NM"),
									rset.getInt("MEMBER_COUNT"),
									rset.getString("IMAGE_PATH"));
				mList.add(onstudy);
			}
		} finally {
			close(rset);
			close(stmt);
		}	
		return mList;
	}

	/** 온스터디 목록(최신날짜) 조회용 Dao
	 * @param conn
	 * @return dList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyDList(Connection conn) throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		List<Onstudy> dList = null;
		String query = prop.getProperty("selectOnstudyDList");
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query);
			dList=new ArrayList<Onstudy>();
			Onstudy onstudy = null;
			while(rset.next()) {
				onstudy = new Onstudy(rset.getInt("ONSTUDY_NO"),
									rset.getString("ONSTUDY_TITLE"),
									rset.getDate("ONSTUDY_START_DT"),
									rset.getDate("ONSTUDY_END_DT"),
									rset.getInt("ONSTUDY_CERTIFY_COUNT"),
									rset.getInt("ONSTUDY_FEE"),
									rset.getInt("ONSTUDY_WEEKS"),
									rset.getDate("ONSTUDY_DEADLINE_DT"),
									rset.getString("CATEGORY_NM"),
									rset.getString("IMAGE_PATH"));
				dList.add(onstudy);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return dList;
	}
	
	/** 검색결과수 조회
	    * @param conn
	    * @param condition
	    * @return
	    * @throws Exception
	    */
	public int getListCount(Connection conn, String condition) throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String query = prop.getProperty("getListCount");
		
		try {
			stmt=conn.createStatement();
			rset=stmt.executeQuery(query+condition+")");
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	   
	   
	   /** 검색결과 조회용
	* @param conn
	* @param currentPage
	* @param limit
	* @return
	* @throws Exception
	*/
	public List<Onstudy> selectList(Connection conn, String condition, int currentPage, int limit) throws Exception {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Onstudy> sList = null;
		String query1 = prop.getProperty("searchList1");
		String query2 = prop.getProperty("searchList2");
		try {
		     //쿼리문 실행시 between 조건에 사용될 값 
		
			int startRow = (currentPage-1)*limit+1;
			int endRow = startRow+limit-1;
			pstmt=conn.prepareStatement(query1+condition+query2);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset=pstmt.executeQuery();
			 
			sList=new ArrayList<Onstudy>();
			Onstudy onstudy = null;
				
			while(rset.next()) {
				onstudy = new Onstudy(rset.getInt("RNUM"),
										rset.getInt("ONSTUDY_NO"),
										rset.getString("ONSTUDY_TITLE"),
										rset.getDate("ONSTUDY_START_DT"),
										rset.getDate("ONSTUDY_END_DT"),
										rset.getInt("ONSTUDY_CERTIFY_COUNT"),
										rset.getInt("ONSTUDY_FEE"),
										rset.getInt("ONSTUDY_WEEKS"),
										rset.getDate("ONSTUDY_DEADLINE_DT"),
										rset.getString("CATEGORY_NM"),
										rset.getString("IMAGE_PATH"));
				sList.add(onstudy);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return sList;
	}
	

	/** 온스터디 상세조회용 Dao
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
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				onstudy = new Onstudy(onstudyNo,
									rset.getString("ONSTUDY_TITLE"),
									rset.getDate("ONSTUDY_START_DT"),
									rset.getDate("ONSTUDY_END_DT"),
									rset.getInt("ONSTUDY_CERTIFY_COUNT"),
									rset.getInt("ONSTUDY_FEE"),
									rset.getString("ONSTUDY_ADD_COMMENT"),
									rset.getInt("ONSTUDY_WEEKS"),
									rset.getString("CATEGORY_NM"),
									rset.getInt("MEMBER_COUNT"),
									rset.getInt("ONSTUDY_Dday"),
									rset.getInt("TOTAL_CERTIFY_COUNT"));
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return onstudy;
	}

	/** 같은 카테고리 온스터디 조회용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @return sameList
	 * @throws Exception
	 */
	public List<Onstudy> sameCategory(Connection conn, int onstudyNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List <Onstudy> sameList = null;
		String query =  prop.getProperty("sameCategory");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			pstmt.setInt(2, onstudyNo);
			rset=pstmt.executeQuery();
			sameList = new ArrayList <Onstudy>();
			Onstudy sameCategory = null;
			while(rset.next()) {
				sameCategory = new Onstudy(rset.getString("ONSTUDY_TITLE"),
										rset.getDate("ONSTUDY_START_DT"),
										rset.getDate("ONSTUDY_END_DT"),
										rset.getInt("ONSTUDY_CERTIFY_COUNT"),
										rset.getInt("ONSTUDY_FEE"),
										rset.getInt("ONSTUDY_WEEKS"),
										rset.getDate("ONSTUDY_DEADLINE_DT"),
										rset.getString("IMAGE_PATH"),
										rset.getString("CATEGORY_NM"));
				sameList.add(sameCategory);
				System.out.println(sameCategory);
				System.out.println("sameList : " +sameList);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return sameList;
	}
   
	/** 개설자가 같은 날짜에 동일한 카테고리의 온스터디에 참여하고 있는지 확인
	 * @param conn
	 * @param onstudy
	 * @return sameCheck
	 * @throws Exception
	 */
	public int checkCategory(Connection conn, Onstudy onstudy) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int sameCheck = 0;
		String query = prop.getProperty("checkCategory");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, onstudy.getMemberNo());
			pstmt.setInt(2, onstudy.getCategoryCd());
			pstmt.setDate(3, onstudy.getOnstudyStartDt());
			pstmt.setDate(4, onstudy.getOnstudyEndDt());
			pstmt.setDate(5, onstudy.getOnstudyStartDt());
			pstmt.setDate(6, onstudy.getOnstudyEndDt());
			pstmt.setDate(7, onstudy.getOnstudyStartDt());
			pstmt.setDate(8, onstudy.getOnstudyEndDt());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sameCheck = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return sameCheck;
	}
	
	/** 참가중인 온스터디 개수 체크용 Dao
	 * @param conn
	 * @param memberNo
	 * @return joinCheck
	 * @throws Exception
	 */
	public int checkJoinCount(Connection conn, Onstudy onstudy) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int joinCheck = 0;
		String query = prop.getProperty("checkJoinCount");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, onstudy.getMemberNo());
			pstmt.setDate(2, onstudy.getOnstudyStartDt());
			pstmt.setDate(3, onstudy.getOnstudyEndDt());
			pstmt.setDate(4, onstudy.getOnstudyStartDt());
			pstmt.setDate(5, onstudy.getOnstudyEndDt());
			pstmt.setDate(6, onstudy.getOnstudyStartDt());
			pstmt.setDate(7, onstudy.getOnstudyEndDt());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				joinCheck = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return joinCheck;
	}
   
	/** 다음 온스터디 번호 반환용 Dao
	 * @param conn
	 * @return onstudyNo
	 * @throws Exception
	 */
	public int selectNextNo(Connection conn) throws Exception{
		
		Statement stmt = null;
		ResultSet rset = null;
		int onstudyNo = 0;
		String query = prop.getProperty("selectNextNo");
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				onstudyNo = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(stmt);
		}
		return onstudyNo;
	}
	
	/** 온스터디 개설용 Dao
	 * @param conn
	 * @param onstudy
	 * @return result
	 * @throws Exception
	 */
	public int createOnstudy(Connection conn, Onstudy onstudy) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("createOnstudy");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, onstudy.getOnstudyNo());
			pstmt.setString(2, onstudy.getOnstudyTitle());
			pstmt.setDate(3, onstudy.getOnstudyStartDt());
			pstmt.setDate(4, onstudy.getOnstudyEndDt());
			pstmt.setInt(5, onstudy.getOnstudyCertifyCount());
			pstmt.setInt(6, onstudy.getOnstudyFee());
			pstmt.setString(7, onstudy.getOnstudyAddComment());
			pstmt.setInt(8, onstudy.getOnstudyWeeks());
			pstmt.setInt(9, onstudy.getMemberNo());
			pstmt.setInt(10, onstudy.getCategoryCd());

			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/** 온스터디 썸네일 정보 삽입용 Dao 
	 * @param conn
	 * @param thumbImg
	 * @return result
	 * @throws Exception
	 */
	public int insertThumbnail(Connection conn, Thumbnail thumbImg) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, thumbImg.getChangeName());
			pstmt.setInt(2, thumbImg.getOnstudyNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/** 해당 온스터디에 참가하고 있는지 확인하는 Dao
	 * @param conn
	 * @param memberNo
	 * @param onstudyNo
	 * @return check
	 * @throws Exception
	 */
	public int checkJoin(Connection conn, int memberNo, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int check = 0;
		String query = prop.getProperty("checkJoin");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				check = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return check;
	}
	
	/** 온스터디 참가용 Dao
	 * @param conn
	 * @param memberNo
	 * @param onstudyNo
	 * @return result
	 * @throws Exception
	 */
	public int joinOnstudy(Connection conn, int memberNo, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("joinOnstudy");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, onstudyNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 온스터디 참가 포인트 차감 Dao
	 * @param conn
	 * @param onstudyFee
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int joinPoint(Connection conn, int onstudyFee, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("joinPoint");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyFee);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 온스터디 참가취소용 Dao
	 * @param conn
	 * @param memberNo
	 * @param onstudyNo
	 * @return result
	 * @throws Exception
	 */
	public int cancelOnstudy(Connection conn, int memberNo, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("cancelOnstudy");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, onstudyNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 온스터디 참가 포인트 취소 환불 Dao
	 * @param conn
	 * @param onstudyFee
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int cancelPoint(Connection conn, int onstudyFee, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("cancelPoint");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyFee);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	/** 현재 로그인한 멤버가 개설한 온스터디 개수를 조회하는 Service
	 * @param conn
	 * @param memberNo
	 * @return onstudyCount
	 * @throws Exception
	 */
	public int manageCount(Connection conn, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int onstudyCount = 0;
		String query = prop.getProperty("manageCount");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				onstudyCount = rset.getInt(1);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return onstudyCount;
	}

	/** 개설한 온스터디 + 카테고리 이름 + 썸네일 경로를 조회하는 Dao
	 * @param conn
	 * @param memberNo
	 * @return oList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyList(Connection conn, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Onstudy> oList = null;
		String query = prop.getProperty("selectOnstudyList");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			oList = new ArrayList<Onstudy>();
			Onstudy onstudy = null;
			
			while(rset.next()) {
				
				onstudy = new Onstudy(rset.getInt("ONSTUDY_NO")
									, rset.getString("ONSTUDY_TITLE")
									, rset.getDate("ONSTUDY_START_DT")
									, rset.getDate("ONSTUDY_END_DT")
									, rset.getInt("ONSTUDY_WEEKS")
									, rset.getInt("ONSTUDY_CERTIFY_COUNT")
									, rset.getInt("ONSTUDY_FEE")
									, rset.getString("CATEGORY_NM")
									, rset.getString("IMAGE_PATH"));
				
				oList.add(onstudy);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return oList;
	}

	/** 온스터디 수정 화면에 온스터디 정보 보여주기 위해 데이터 가져오는 Service
	 * @param conn
	 * @param onstudyNo
	 * @return onstudy
	 * @throws Exception
	 */
	public Onstudy selectUpdate(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Onstudy onstudy = null;
		String query = prop.getProperty("selectUpdate");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				onstudy = new Onstudy(rset.getString("ONSTUDY_TITLE")
						, rset.getString("IMAGE_PATH")
						, rset.getDate("ONSTUDY_START_DT")
						, rset.getDate("ONSTUDY_END_DT")
						, rset.getInt("ONSTUDY_WEEKS")
						, rset.getInt("ONSTUDY_CERTIFY_COUNT")
						, rset.getString("ONSTUDY_ADD_COMMENT"));
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return onstudy;
	}
	 
	/** 온스터디에 썸네일이 존재하는지 확인하는 Dao -> 온스터디 수정, 삭제에서 사용
	 * @param conn
	 * @param onstudyNo
	 * @return check
	 * @throws Exception
	 */
	public int checkThumbnail(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int check = 0;
		String query = prop.getProperty("checkThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				check = rset.getInt(1);
			}
		}finally {
			close(pstmt);
		}
		return check;
	}
	
	/** 기존 썸네일 파일 이름 조회용 Dao
	 * @param conn 
	 * @param onstudyNo
	 * @return nowThumbnail
	 * @throws Exception
	 */
	public String selectThumbnail(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String nowThumbnail = null;
		String query = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nowThumbnail = rset.getString(1);
			}
		}finally {
			close(pstmt);
		}
		return nowThumbnail;
	}

	/** 온스터디 수정 Dao
	 * @param conn
	 * @param onstudy
	 * @return result 
	 * @throws Exception
	 */
	public int updateOnstudy(Connection conn, Onstudy onstudy) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateOnstudy");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, onstudy.getOnstudyCertifyCount());
			pstmt.setString(2, onstudy.getOnstudyAddComment());
			pstmt.setInt(3, onstudy.getOnstudyNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/** 썸네일 수정용 Dao
	 * @param conn
	 * @param thumbImg
	 * @return result
	 * @throws Exception
	 */
	public int updateThumbnail(Connection conn, Thumbnail thumbImg) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, thumbImg.getChangeName());
			pstmt.setInt(2, thumbImg.getOnstudyNo());
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 온스터디 삭제 Dao
	 * @param conn 
	 * @param onstudyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteOnstudy(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteOnstudy");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 썸네일 삭제 Dao
	 * @param conn
	 * @param onstudyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteThumbnail(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 현재 시점의 해당 멤버가 참가 중인 온스터디 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return nList
	 * @throws Exception
	 */
	public List<Onstudy> nowJoin(Connection conn, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Onstudy> nList = null;
		String query = prop.getProperty("nowJoin");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			
			nList = new ArrayList<Onstudy>();
			Onstudy onstudy = null;
			
			while(rset.next()) {
				
				onstudy = new Onstudy(rset.getInt("ONSTUDY_NO")
									, rset.getString("ONSTUDY_TITLE")
									, rset.getDate("ONSTUDY_START_DT")
									, rset.getDate("ONSTUDY_END_DT")
									, rset.getInt("ONSTUDY_WEEKS")
									, rset.getInt("ONSTUDY_CERTIFY_COUNT")
									, rset.getInt("ONSTUDY_FEE")
									, rset.getString("CATEGORY_NM")
									, rset.getString("IMAGE_PATH")
									, rset.getInt("MEMBER_COUNT")
									, rset.getInt("TODAY_CERTIFY_CHECK"));
				nList.add(onstudy);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return nList;
	}
	
	/** 해당 멤버가 현재 시점을 기준으로 오늘/n주차에 인증했는지 조회용 Dao
	 * @param conn
	 * @param memberNo
	 * @return twList
	 * @throws Exception
	 */
	public List<CertifyCount> todayWeek(Connection conn, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CertifyCount> twList = null;
		CertifyCount certifyCount= null;
		String query = prop.getProperty("todayWeek");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			twList = new ArrayList<CertifyCount>();
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				certifyCount = new CertifyCount(rset.getInt("ONSTUDY_NO"),
												memberNo,
												rset.getInt("TODAY_CERTIFY_COUNT"),
												rset.getInt("N_WEEK"),
												rset.getInt("WEEK_CERTIFY_COUNT"),
												rset.getInt("ONSTUDY_CERTIFY_COUNT"),
												rset.getInt("ONSTUDY_WEEKS"));
				twList.add(certifyCount);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return twList;
	}
	
	
	/** 멤버+온스터디별 인증횟수 , 온스터디별 총 인증횟수 조회용 Dao
    * @param conn
    * @param memberNo
    * @return ccList
    * @throws Exception
    */
	public List<CertifyCount> checkRate(Connection conn, int memberNo) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CertifyCount> ccList = null;
		CertifyCount certifyCount= null;
		String query = prop.getProperty("certifyRate");
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			ccList=new ArrayList<CertifyCount>();
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				certifyCount = new CertifyCount(rset.getInt("ONSTUDY_NO"),
												rset.getInt("SUM(WEEK_CERTIFY_COUNT)"),
												rset.getInt("ONSTUDY_CERTIFY_COUNT"),
												rset.getInt("ONSTUDY_WEEKS"));
				ccList.add(certifyCount);
			}
		} finally {
			close(rset);
			close(pstmt);
		}
		return ccList;
	}

	/** 현재 온스터디 인증 게시글 전체 수 조회용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @return listCount
	 * @throws Exception
	 */
	public int boardListCount(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String query = prop.getProperty("boardListCount");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	/** 현재 온스터디 인증 게시글 조회용 Dao
	 * @param conn
	 * @param currentPage
	 * @param limit
	 * @param onstudyNo
	 * @return bList
	 * @throws Exception
	 */
	public List<CBoard> selectList(Connection conn, int currentPage, int limit, int onstudyNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CBoard> bList = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			// 쿼리문 실행 시 between 조건에 사용될 값
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, onstudyNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			bList = new ArrayList<CBoard>();
			CBoard cBoard = null;
			
			while(rset.next()) {
				
				cBoard = new CBoard(rset.getInt("RNUM")
									, rset.getInt("ONSTUDY_BOARD_NO")
									, rset.getString("ONSTUDY_BOARD_TITLE")
									, rset.getDate("ONSTUDY_BOARD_CREATE_DT")
									, rset.getDate("ONSTUDY_BOARD_MODIFY_DT")
									, rset.getInt("ONSTUDY_BOARD_COUNT")
									, rset.getInt("ONSTUDY_NO")
									, rset.getString("MEMBER_ID"));
				bList.add(cBoard);
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return bList;
	}

	/** 등록될 게시글의 게시글 번호 반환용 Dao
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int selectNextBoardNo(Connection conn) throws Exception{
		
		Statement stmt = null;
		ResultSet rset = null;
		int boardNo = 0;
		String query = prop.getProperty("selectNextBoardNo");
		
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

	/** 인증 게시글 등록용 Dao
	 * @param conn
	 * @param board
	 * @param boardWriter
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, CBoard board, int boardWriter) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getOnstudyNo());
			pstmt.setInt(5, boardWriter);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 인증 게시글 첨부 파일 정보 삽입용 Dao
	 * @param conn
	 * @param file
	 * @return result
	 * @throws Exception
	 */
	public int insertAttachment(Connection conn, CAttachment file) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, file.getChangeName());
			pstmt.setInt(2, file.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	/** 인증게시글 내용 수정
	 * @param conn
	 * @param board
	 * @param boardWriter
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, CBoard board, int boardWriter) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 수정하려는 게시글에 있는 이미지 조회
	 * @param conn
	 * @param boardNo
	 * @return imgList
	 * @throws Exception
	 */
	public List<String> selectImgList(Connection conn, int boardNo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> imgList = null;
		String query = prop.getProperty("selectImgList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			imgList = new ArrayList<String>();
			while(rset.next()) {
				imgList.add(rset.getString(1));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return imgList;
	}

	/** 게시글 첨부 이미지 수정용 Dao
	 * @param conn
	 * @param beforePath
	 * @param changeName
	 * @return result
	 * @throws Exception
	 */
	public int updateAttachment(Connection conn, String beforePath, String changeName) throws Exception{
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAttachment");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, changeName);
			pstmt.setString(2, beforePath);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 인증 게시글 상세 조회용 Dao
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public CBoard selectBoard(Connection conn, int boardNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CBoard board = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new CBoard(rset.getInt("RNUM"),
								boardNo,
								rset.getString("ONSTUDY_BOARD_TITLE"),
								rset.getString("ONSTUDY_BOARD_CONTENT"),
								rset.getDate("ONSTUDY_BOARD_CREATE_DT"),
								rset.getDate("ONSTUDY_BOARD_MODIFY_DT"),
								rset.getInt("ONSTUDY_BOARD_COUNT"),
								rset.getInt("ONSTUDY_NO"),
								rset.getString("MEMBER_ID"));
			}
			
		}finally {
			close(rset);
			close(pstmt);
		}
		return board;
	}

	/** 게시글 상세조회 성공 시 조회수 증가용 Dao
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

	/** 인증 게시글 이미지 파일 조회용 Dao
	 * @param conn
	 * @param boardNo
	 * @return files
	 * @throws Exception
	 */
	public List<CAttachment> selectFiles(Connection conn, int boardNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CAttachment> files = null;
		String query = prop.getProperty("selectFiles");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			files = new ArrayList<CAttachment>();
			CAttachment file = null;
			
			while(rset.next()) {
				
				file = new CAttachment(rset.getInt("IMAGE_NO"),
										rset.getString("IMAGE_PATH"),
										boardNo);
				files.add(file);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return files;
	}
	
	/** 검색 게시글 개수 조회용
	 * @param conn
	 * @param onstudyNo
	 * @param condition
	 * @return listCount
	 * @throws Exception
	 */
	public int searchListCount(Connection conn, int onstudyNo, String condition) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("searchListCount");
		
		try {
			
			pstmt = conn.prepareStatement(query + condition); 
			pstmt.setInt(1, onstudyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	/** 인증 게시글 검색 리스트 반환용 Dao
	 * @param conn
	 * @param currentPage 
	 * @param limit 
	 * @param onstudyNo 
	 * @param condition
	 * @return bList
	 * @throws Exception
	 */
	public List<CBoard> searchList(Connection conn, int currentPage, int limit, int onstudyNo, String condition) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CBoard> bList = null;
		
		String query = prop.getProperty("searchList");
		//String query2 = prop.getProperty("searchNotice2");
		
		try {
			
			// 쿼리문 실행 시 between 조건에 사용될 값
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query + condition);
			
			pstmt.setInt(1, onstudyNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			bList = new ArrayList<CBoard>();
			
			CBoard cBoard = null;
			
			while(rset.next()) {
				cBoard = new CBoard(rset.getInt("RNUM")
						, rset.getInt("ONSTUDY_BOARD_NO")
						, rset.getString("ONSTUDY_BOARD_TITLE")
						, rset.getString("ONSTUDY_BOARD_CONTENT")
						, rset.getDate("ONSTUDY_BOARD_CREATE_DT")
						, rset.getDate("ONSTUDY_BOARD_MODIFY_DT")
						, rset.getInt("ONSTUDY_BOARD_COUNT")
						, rset.getInt("ONSTUDY_NO")
						, rset.getString("MEMBER_ID"));
				bList.add(cBoard);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return bList;
	}

	/** 멤버가 해당 온스터디에 오늘 인증했는지 확인용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @param memberNo
	 * @return todayCertifyCheck
	 * @throws Exception
	 */
	public int checkToday(Connection conn, int onstudyNo, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int todayCertifyCount = 0;
		
		String query = prop.getProperty("checkToday");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, onstudyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				todayCertifyCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return todayCertifyCount;
	}

	/** 현재 날짜가 몇 주차인지 확인용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @return nWeek
	 * @throws Exception
	 */
	public int selectNWeek(Connection conn, int onstudyNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int nWeek = 0;
		
		String query = prop.getProperty("selectNWeek");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nWeek = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return nWeek;
	}

	/** 주에 인증 횟수 확인용 Dao
	 * @param conn
	 * @param onstudyNo
	 * @param memberNo
	 * @param nWeek
	 * @return checkCertify
	 * @throws Exception
	 */
	public CertifyCount checkCertifyCount(Connection conn, int onstudyNo, int memberNo, int nWeek) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CertifyCount checkCertify = null;
		
		String query = prop.getProperty("checkCertifyCount");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, onstudyNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, nWeek);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				checkCertify = new CertifyCount(onstudyNo
												, memberNo
												, rset.getInt("TODAY_CERTIFY_COUNT")
												, nWeek
												, rset.getInt("WEEK_CERTIFY_COUNT")
												, rset.getInt("ONSTUDY_CERTIFY_COUNT")
												,  rset.getInt("ONSTUDY_WEEKS"));
						
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return checkCertify;
	}

	
	
//////////////////////////////////마이페이지/////////////////////////////////////////////	
	
	
	/** 내 온스터디 내역 개수 조회하는 Dao
	 * @param conn
	 * @param memberNo
	 * @return listCount
	 * @throws Exception
	 */
	public int myOnstudyCount(Connection conn, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("onstudyCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	/** 내 온스터디 내역 리스트조회하는 Dao
	 * @param conn
	 * @param memberNo
	 * @return myList
	 * @throws Exception
	 */
	public List<MyOnstudy> myOnstudyList(Connection conn, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MyOnstudy> myList = null;
		
		String query = prop.getProperty("myOnstudyList");
		System.out.println(query);
		try {
			
			// 쿼리문 실행 시 between 조건에 사용될 값
			//int startRow = (currentPage - 1) * limit + 1;
			//int endRow = startRow + limit - 1;
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			
			myList = new ArrayList<MyOnstudy>();
			
			MyOnstudy myOnstudy = null;
			
			while(rset.next()) {
				
				myOnstudy = new MyOnstudy(rset.getInt("MEMBER_NO")
										, rset.getInt("ONSTUDY_NO")
										, rset.getDouble("REFUND")
										, rset.getString("ONSTUDY_TITLE")
										, rset.getDate("ONSTUDY_START_DT")
										, rset.getDate("ONSTUDY_END_DT")
										, rset.getInt("CLOSE_CHECK")
										, rset.getInt("MY_CERTIFY_COUNT")
										, rset.getInt("ONSTUDY_CERTIFY_COUNT")
										, rset.getInt("ONSTUDY_WEEKS")
										, rset.getInt("ONSTUDY_FEE")
										, rset.getString("CATEGORY_NM")
										, rset.getString("IMAGE_PATH"));
				myList.add(myOnstudy);
			}
			
		}finally{
			close(rset);
			close(pstmt);
		}
		return myList;
	}

	/** 인증게시판에 보여주는 정보 모두 조회하는 Service
	 * @param conn
	 * @param memberNo
	 * @return totalList
	 * @throws Exception
	 */
	public List<CertifyBoardTotal> CertifyTotal(Connection conn, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<CertifyBoardTotal> totalList = null;
		String query = prop.getProperty("certifyTotal");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, memberNo);
			pstmt.setInt(4, memberNo);
			rset = pstmt.executeQuery();
			
			totalList = new ArrayList<CertifyBoardTotal>();
			CertifyBoardTotal cbt = null;
			
			while(rset.next()) {
				cbt = new CertifyBoardTotal(rset.getInt("ONSTUDY_NO")
										, rset.getString("ONSTUDY_TITLE")
										, rset.getString("CATEGORY_NM")
										, rset.getString("IMAGE_PATH")
										, rset.getDate("ONSTUDY_START_DT")
										, rset.getDate("ONSTUDY_END_DT")
										, rset.getInt("ONSTUDY_CERTIFY_COUNT")
										, rset.getInt("ONSTUDY_FEE")
										, rset.getInt("ONSTUDY_WEEKS")
										, rset.getInt("MEMBER_COUNT")
										, rset.getInt("TODAY_WEEK")
										, rset.getInt("TODAY_CERTIFY_COUNT")
										, rset.getInt("WEEK_CERTIFY_COUNT")
										, rset.getInt("TOTAL_COUNT"));
				
				totalList.add(cbt);
			}
		}finally {
			close(rset);
			close(pstmt);
		}
		return totalList;
	}







}











