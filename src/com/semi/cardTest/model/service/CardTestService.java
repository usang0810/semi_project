package com.semi.cardTest.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.semi.cardTest.model.dao.CardTestDao;
import com.semi.cardTest.model.vo.ProgressBar;
import com.semi.cardTest.model.vo.StudyCard;
import com.semi.cardTest.model.vo.recordTestResult;

public class CardTestService {

	
	
	/** 카드 조회용 Service
	 * @param memberNo 
	 * @param memberNo 
	 * @param cardSetNo
	 * @return sCard
	 * @throws Exception
	 */
	public StudyCard selectCard(int cardSetNum, int memberNo) throws Exception {

		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		StudyCard sCard = ctDao.selectCard(conn, cardSetNum, memberNo);
		
		close(conn);
		
		return sCard;
	}
	
	

	/** 정답 확인용 Service
	 * @param sCard2
	 * @return result
	 * @throws Exception
	 */
	public StudyCard checkAnswer(StudyCard sCard2) throws Exception{
		
		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		StudyCard sCard = ctDao.checkAnswer(conn, sCard2);
		
		close(conn);
		
		return sCard;
	}

	
	
	/** 정답여부 기록용 Service
	 * @param cardSetNo
	 * @param result
	 * @param memberNo
	 * @param setNo 
	 * @return result
	 * @throws Exception
	 */
	public int insertYn(int cardSetNo, int result, int memberNo, int setNo) throws Exception {
		
		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		int result2 = ctDao.insertYn(conn, cardSetNo, result, memberNo, setNo);
		
		if( result2 > 0) commit(conn);
		else 		   rollback(conn);
		
		close(conn);
		
		return result2;
	}

	/** 상태바 체크용 Service
	 * @param cardSetNo
	 * @param memberNo
	 * @return pBar
	 * @throws Exception
	 */
	public ProgressBar checkProgress(int cardSetNo, int memberNo) throws Exception{
		
		Connection conn = getConnection();	
		
		CardTestDao ctDao = new CardTestDao();
		
		ProgressBar pBar = ctDao.checkProgress(conn, cardSetNo, memberNo);
		
		close(conn);
		
		return pBar;
	}

	
	
	/** 테스트 기록 초기화용 Service
	 * @param cardSetNo
	 * @param memberNo
	 * @return resetRecord
	 * @throws Exception
	 */
	public int resetRecord(int cardSetNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();	
		
		CardTestDao ctDao = new CardTestDao();
		
		int resetRecord = ctDao.resetRecord(conn, cardSetNo, memberNo);
		
		if( resetRecord > 0) commit(conn);
		else 		       rollback(conn);
		
		close(conn);
		
		return resetRecord;
	}



	/** 학습노트 카드 전부 시험봤을때 결과 확인용 Service
	 * @param cardSetNo
	 * @param memberNo
	 * @return tResult
	 */
	public List<StudyCard> checkResult(int cardSetNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		List<StudyCard> tResult = ctDao.checkResult(conn, cardSetNo, memberNo);
		
		close(conn);
		
		return tResult;
	}



	public int recordTestResult(int memberNo, int cardSetNo, String recordResult, int wholeQnum, int rightQnum,
			Date testDate) throws Exception{
		
		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		int resetRecord = ctDao.recordTestResult(conn, memberNo, cardSetNo, recordResult, wholeQnum, rightQnum, testDate  );
		
		if( resetRecord > 0) commit(conn);
		else 		       rollback(conn);
		
		return resetRecord;
	}



	/** 초기화전 테스트 결과 기록용 Service
	 * @param cardSetNo
	 * @param memberNo
	 * @param wholeQ
	 * @param rightQ
	 * @return 
	 */
	public int recordResult(int cardSetNo, int memberNo, int wholeQ, int rightQ) throws Exception{
		
		Connection conn = getConnection();
		
		CardTestDao ctDao = new CardTestDao();
		
		int recordResult = ctDao.recordResult(conn, cardSetNo, memberNo, wholeQ, rightQ );
		
		if( recordResult > 0) commit(conn);
		else 		       rollback(conn);
		
		return recordResult;
	}

}
