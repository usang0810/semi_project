package com.semi.cardTest.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.cardTest.model.vo.ProgressBar;
import com.semi.cardTest.model.vo.StudyCard;
import com.semi.cardTest.model.vo.recordTestResult;
import com.semi.member.model.dao.MemberDao;

public class CardTestDao {

	private Properties prop = null;
	
	 public CardTestDao() throws Exception{
	      String fileName = MemberDao.class.getResource("/com/semi/sql/CardTest/cardTest-query.properties").getPath();
	      
	      prop = new Properties();
	      
	      prop.load(new FileReader(fileName));
	}
	
	 
	 
	/** 카드 조회용 Dao
	 * @param conn
	 * @param memberNo 
	 * @param cardSetNo
	 * @return sCard
	 * @throws Exception
	 */
	public StudyCard selectCard(Connection conn, int cardSetNum, int memberNo) throws Exception{
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		StudyCard sCard = null;
		
		String query = prop.getProperty("selectCard");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, cardSetNum);
			pstmt.setInt(2, cardSetNum);
			pstmt.setInt(3, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sCard = new StudyCard(rset.getString("STUDYNOTE_TITLE"),
						rset.getInt("SET_NO"),
						rset.getString("SET_WORD"), 
						rset.getString("SET_MEAN"), 
						cardSetNum);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sCard;
	}
	
	

	/** 정답 확인용 Dao
	 * @param conn
	 * @param sCard2
	 * @return sCard
	 * @throws Exception
	 */
	public StudyCard checkAnswer(Connection conn, StudyCard sCard2) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		StudyCard sCard = null;
		
		String query = prop.getProperty("checkAnswer");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, sCard2.getStudyNoteNo());
			pstmt.setInt(2, sCard2.getCardSetNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sCard = new StudyCard(sCard2.getCardSetNo(), rset.getString("SET_WORD"), sCard2.getStudyNoteNo());
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sCard;
	}

	
	
	/** 정답여부 기록용 Dao
	 * @param conn
	 * @param cardSetNo
	 * @param result
	 * @param memberNo
	 * @param setNo 
	 * @return result2
	 * @throws Exception
	 */
	public int insertYn(Connection conn, int cardSetNo, int result, int memberNo, int setNo) throws Exception {
		
		PreparedStatement pstmt = null;
		
		int result2 = 0;
		
		String query = prop.getProperty("insertY");
		String query2 = prop.getProperty("insertN");
		
		try {
			
			
			if ( result > 0) {
				
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1, cardSetNo);
				pstmt.setInt(2, memberNo);
				pstmt.setInt(3, setNo);
				
				result2 = pstmt.executeUpdate();
				
			} else {
				pstmt = conn.prepareStatement(query2);
				
				pstmt.setInt(1, cardSetNo);
				pstmt.setInt(2, memberNo);
				pstmt.setInt(3, setNo);
				
				result2 = pstmt.executeUpdate();
			}
			
		} finally {
			close(pstmt);
		}
		
		return result2;
	}

	/** 진행 바 Dao
	 * @param conn
	 * @param cardSetNo
	 * @param memberNo
	 * @return pBar
	 * @throws Exception
	 */
	public ProgressBar checkProgress(Connection conn, int cardSetNo, int memberNo) throws Exception {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		ProgressBar pBar = null;
		
		String wholeQ = prop.getProperty("checkWholeQ");
		String solvedQ = prop.getProperty("checkSolvedQ");
		String correctQ = prop.getProperty("checkCorrectQ");
		String wrongQ = prop.getProperty("checkWrongQ");
		
		int wholeQN = 0;
		int solvedQN = 0;
		int correctQN = 0;
		int wrongQN = 0;
		
		try {
			
			pstmt = conn.prepareStatement(wholeQ);
			pstmt.setInt(1, cardSetNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				wholeQN = rset.getInt("COUNT(*)");
			}
			
			pstmt = conn.prepareStatement(solvedQ);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, cardSetNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				solvedQN = rset.getInt("COUNT(*)");
			}
			
			pstmt = conn.prepareStatement(correctQ);
			pstmt.setInt(1, cardSetNo);
			pstmt.setInt(2, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				correctQN = rset.getInt("COUNT(*)");
			}
			
			pstmt = conn.prepareStatement(wrongQ);
			pstmt.setInt(1, cardSetNo);
			pstmt.setInt(2, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				wrongQN = rset.getInt("COUNT(*)");
			}
			
			pBar = new ProgressBar(wholeQN, solvedQN, correctQN, wrongQN);
			
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return pBar;
	}
	
	

	/** 테스트 기록 초기화용 Dao
	 * @param conn
	 * @param cardSetNo
	 * @param memberNo
	 * @return resetCard
	 * @throws Exception
	 */
	public int resetRecord(Connection conn, int cardSetNo, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		
		int resetRecord = 0;
		
		String query = prop.getProperty("resetRecord");
		
		try {
		
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cardSetNo);
			pstmt.setInt(2, memberNo);
			
			resetRecord = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return resetRecord;
	}



	/** 학습노트 카드 전부 시험봤을때 결과 확인용 Dao
	 * @param conn 
	 * @param cardSetNo
	 * @param memberNo
	 * @return sList
	 */
	public List<StudyCard> checkResult(Connection conn, int cardSetNo, int memberNo) throws Exception {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<StudyCard> sList= null;
		
		String query = prop.getProperty("checkTestResult");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cardSetNo);
			pstmt.setInt(2, memberNo);
			
			rset = pstmt.executeQuery();
			
			sList = new ArrayList<StudyCard>();
			
			StudyCard sCard = null;
			
			while(rset.next()) {
				
				sCard = new StudyCard(
						rset.getInt("STUDYNOTE_SET.SET_NO"), 
						rset.getInt("STUDYNOTE_SET.STUDYNOTE_NO"), 
						rset.getInt("STUDYNOTE_TEST.STUDYNOTE_TESTER"), 
						rset.getString("STUDYNOTE_TEST.CORRECT_STATUS"), 
						rset.getDate("STUDYNOTE_TEST.TEST_DT"));
				
				sList.add(sCard);
			}
			
		}finally {
			close(pstmt);
			close(pstmt);
		}
		
		return sList;
	}



	public int recordTestResult(Connection conn, int memberNo, int cardSetNo, String recordResult, int wholeQnum, int rightQnum,
			Date testDate) throws Exception {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("recordTestResult");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cardSetNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			close(pstmt);
		}
		
		return result;
	}



	/** 테스트 결과 기록용 Dao
	 * @param conn 
	 * @param cardSetNo
	 * @param memberNo
	 * @param wholeQ
	 * @param rightQ
	 * @return
	 * @throws Exception
	 */
	public int recordResult(Connection conn, int cardSetNo, int memberNo, int wholeQ, int rightQ) throws Exception{
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("recordTestResult");
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, cardSetNo);
			pstmt.setInt(3, wholeQ);
			pstmt.setInt(4, rightQ);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
			close(pstmt);
		}
		
		return result;
	}

}
