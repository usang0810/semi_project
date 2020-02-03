package com.semi.admin.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.semi.admin.model.dao.AdminDao;
import com.semi.board.model.dao.BoardDao;
import com.semi.board.model.vo.Board;
import com.semi.member.model.vo.Member;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.studynote.model.vo.StudyNote;

public class AdminService {

	/** 조건에 맞는 회원수 조회용 Service
	 * @param condition
	 * @param content
	 * @return mListCount
	 * @throws Exception
	 */
	public int getMemberListCount(String condition, String content) throws Exception{
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		
		// condition이 null일 경우 쿼리에 null이 들어가는 것을 방지
		String subQuery = "";
		char check;
		int mListCount = 0;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "전화번호":	subQuery = " AND MEMBER_PHONE='" + content + "'"; break;
			case "정지여부":	subQuery = " AND MEMBER_STATUS='" + content + "'"; break;
			case "아이디":	subQuery = " AND MEMBER_ID LIKE '%' || '" + content + "' || '%'"; break;
			case "이름":		subQuery = " AND MEMBER_NM LIKE '%' || '" + content + "' || '%'"; break;
			case "회원번호":	for(int i=0; i<content.length(); i++) {
								check = content.charAt(i);
								if(check < 48 || check > 59) {
									content = "";
									break;
								}
							}
							subQuery = " AND MEMBER_NO='" + content + "'"; break;
			case "포인트":	subQuery = " AND MEMBER_POINT='" + content + "'"; break;
			case "신고회수":	subQuery = " AND MEMBER_DECLAR_COUNT='" + content + "'"; break;
			}
		}

		mListCount = adminDao.getMemberListCount(conn, subQuery);				
			
		close(conn);
		return mListCount;
	}

	/** 회원 목록 조회용 Service
	 * @param condition
	 * @param content
	 * @param currentPage
	 * @param limit
	 * @return mList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(String condition, String content, int currentPage, int limit) throws Exception{
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		List<Member> mList = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String subQuery = ") WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		String thirdQuery = "'" + content + "'";
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "회원번호":	subQuery = " WHERE MEMBER_NO=" + thirdQuery + subQuery; break;
			case "전화번호":	subQuery = " WHERE MEMBER_PHONE=" + thirdQuery + subQuery; break;
			case "포인트":	subQuery = " WHERE MEMBER_POINT=" + thirdQuery + subQuery; break;
			case "신고회수":	subQuery = " WHERE MEMBER_DECLAR_COUNT=" + thirdQuery + subQuery; break;
			case "정지여부":	subQuery = " WHERE MEMBER_STATUS=" + thirdQuery + subQuery; break;
			case "아이디":	subQuery = " WHERE MEMBER_ID LIKE '%' || " + thirdQuery +" || '%'" + subQuery; break;
			case "이름":		subQuery = " WHERE MEMBER_NM LIKE '%' || " + thirdQuery +" || '%'" + subQuery; break;
			}
		}
		
		mList = adminDao.selectMemberList(conn, subQuery);
		
		return mList;
	}

	/** 회원 조회용 Service
	 * @param memberNo
	 * @return member
	 * @throws Exception
	 */
	public Member getMember(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		Member member = new AdminDao().getMember(conn, memberNo);
		
		close(conn);
		return member;
	}

	/** 회원 학습노트 리스트 조회용 Service
	 * @param memberNo
	 * @return noteList
	 * @throws Exception
	 */
	public List<StudyNote> getNoteList(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		List<StudyNote> noteList = new AdminDao().getNoteList(conn, memberNo);
		
		close(conn);
		return noteList;
	}

	/** 회원 온스터디 리스트 조회용 Service
	 * @param memberNo
	 * @return onstudyList
	 * @throws Exception
	 */
	public List<Onstudy> getOnstudyList(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		List<Onstudy> onstudyList = new AdminDao().getOnstudyList(conn, memberNo);
		
		close(conn);
		return onstudyList;
	}

	/** 회원 온스터디 리스트 조회용 Service(조건)
	 * @param memberNo
	 * @param i
	 * @return onstudyList
	 * @throws Exception
	 */
	public List<Onstudy> getOnstudyList(int memberNo, int i) throws Exception{
		Connection conn = getConnection();
		
		String subQuery = "";
		if(i == 1)	subQuery = " AND ONSTUDY_END_DT >= SYSDATE";
		else		subQuery = " AND ONSTUDY_END_DT < SYSDATE";
		
		List<Onstudy> onstudyList = new AdminDao().getOnstudyList(conn, memberNo, subQuery);
		
		close(conn);
		return onstudyList;
	}

	/** 회원 상태 정보 변경용 Service
	 * @param memberNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeMemberStatus(int memberNo, String status) throws Exception{
		Connection conn = getConnection();
		
		int result = new AdminDao().changeMemberStatus(conn, memberNo, status);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 삭제용 Service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteMember(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteMember(conn, memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 온스터디 수 조회용 Service
	 * @param condition
	 * @param content
	 * @return oListCount
	 * @throws Exception
	 */
	public int getOnstudyListCount(String condition, String content) throws Exception{
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		
		// condition이 null일 경우 쿼리에 null이 들어가는 것을 방지
		String subQuery = "";
		int mListCount = 0;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "온스터디번호":	subQuery = " WHERE ONSTUDY_NO='" + content + "'"; break;
			case "참여인원":		subQuery = " WHERE ALL_COUNT='" + content + "'"; break;
			case "시작일":		subQuery = " WHERE ONSTUDY_START_DT='" + content + "'"; break;
			case "종료일":		subQuery = " WHERE ONSTUDY_END_DT='" + content + "'"; break;
			case "참가비":		subQuery = " WHERE ONSTUDY_FEE='" + content + "'"; break;
			case "삭제여부":		subQuery = " WHERE ONSTUDY_STATUS='" + content + "'"; break;
			case "온스터디명":		subQuery = " WHERE ONSTUDY_TITLE LIKE '%' || '" + content + "' || '%'"; break;
			case "카테고리":		subQuery = " WHERE CATEGORY_NM LIKE '%' || '" + content + "' || '%'"; break;
			}
		}

		mListCount = adminDao.getOnstudyListCount(conn, subQuery);				
			
		close(conn);
		return mListCount;
	}

	/** 온스터디 목록 조회용 Service
	 * @param condition
	 * @param content
	 * @param currentPage
	 * @param limit
	 * @return oList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyList(String condition, String content, int currentPage, int limit) throws Exception{
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		List<Onstudy> oList = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String subQuery = ") WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		String thirdQuery = "'" + content + "'";
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "온스터디번호":	subQuery = " WHERE ONSTUDY_NO=" + thirdQuery + subQuery; break;
			case "참여인원":		subQuery = " WHERE ALL_COUNT=" + thirdQuery + subQuery; break;
			case "시작일":		subQuery = " WHERE ONSTUDY_START_DT=" + thirdQuery + subQuery; break;
			case "종료일":		subQuery = " WHERE ONSTUDY_END_DT=" + thirdQuery + subQuery; break;
			case "참가비":		subQuery = " WHERE ONSTUDY_FEE=" + thirdQuery + subQuery; break;
			case "삭제여부":		subQuery = " WHERE ONSTUDY_STATUS=" + thirdQuery + subQuery; break;
			case "온스터디명":		subQuery = " WHERE ONSTUDY_TITLE LIKE '%' || " + thirdQuery +" || '%'" + subQuery; break;
			case "카테고리":		subQuery = " WHERE CATEGORY_NM LIKE '%' || " + thirdQuery +" || '%'" + subQuery; break;
			}
		}
		
		oList = adminDao.selectOnstudyList(conn, subQuery);
		
		close(conn);
		return oList;
	}

	/** 온스터디 상세 조회용 Service
	 * @param onstudyNo
	 * @return onstudy
	 * @throws Exception
	 */
	public Onstudy selectOnstudy(int onstudyNo) throws Exception{
		Connection conn = getConnection();
		
		Onstudy onstudy = new AdminDao().selectOnstudy(conn,  onstudyNo);
		
		close(conn);
		return onstudy;
	}

	/** 온스터디 상태 변경용 Service
	 * @param onstudyNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeOnstudyStatus(int onstudyNo, String status) throws Exception{
		Connection conn = getConnection();
		
		int result = new AdminDao().changeOnstudyStatus(conn, onstudyNo, status);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 게시판 수 조회용 Service
	 * @param boardType
	 * @param searchKey
	 * @param searchValue
	 * @return bListCount
	 * @throws Exception
	 */
	public int getBoardListCount(String boardType, String searchKey, String searchValue) throws Exception{
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		
		String subQuery = "'" + boardType + "'";
		int mListCount = 0;
		
		if(searchKey != null) {
			switch(searchKey) {
			case "게시글번호":	subQuery += " AND BOARD_NO='" + searchValue + "'"; break;
			case "제목":		subQuery += " AND BOARD_TITLE LIKE '%' || '" + searchValue + "' || '%'"; break;
			case "작성자":	subQuery += " AND MEMBER_ID LIKE '%' || '" + searchValue + "' || '%'"; break;
			case "작성일":	subQuery += " AND BOARD_MODIFY_DT='" + searchValue + "'"; break;
			case "내용":		subQuery += " AND BOARD_CONTENT LIKE '%' || '" + searchValue + "' || '%'"; break;
			case "삭제여부":	subQuery += " AND BOARD_STATUS='" + searchValue + "'"; break;
			case "신고처리상태":subQuery += " AND DECLAR_STATUS='" + searchValue + "'"; break;
			}
		}

		mListCount = adminDao.getBoardListCount(conn, subQuery);				
			
		close(conn);
		return mListCount;
	}
	
	/** 게시판 목록 조회용 Service
	 * @param boardType
	 * @param searchKey
	 * @param searchValue
	 * @param currentPage
	 * @param limit
	 * @return bList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(String boardType, String searchKey, String searchValue, int currentPage,
			int limit) throws Exception{
		
		Connection conn = getConnection();
		
		AdminDao adminDao = new AdminDao();
		List<Board> bList = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String subQuery = "'" + boardType + "'";
		String thirdQuery = " ORDER BY BOARD_MODIFY_DT DESC)) WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		
		if(searchKey != null) {
			switch(searchKey) {
			case "게시글번호":	subQuery += " AND BOARD_NO='" + searchValue + "'" + thirdQuery; break;
			case "제목":		subQuery += " AND BOARD_TITLE LIKE '%' || '" + searchValue + "' || '%'" + thirdQuery; break;
			case "작성자":	subQuery += " AND MEMBER_ID LIKE '%' || '" + searchValue + "' || '%'" + thirdQuery; break;
			case "작성일":	subQuery += " AND BOARD_MODIFY_DT='" + searchValue + "'" + thirdQuery; break;
			case "내용":		subQuery += " AND BOARD_CONTENT LIKE '%' || '" + searchValue + "' || '%'" + thirdQuery; break;
			case "삭제여부":	subQuery += " AND BOARD_STATUS='" + searchValue + "'" + thirdQuery; break;
			case "신고처리상태":subQuery += " AND DECLAR_STATUS='" + searchValue + "'" + thirdQuery; break;
			// 페이지 이동시에는 searchKey의 값을 String "null"로 인식하기 때문에 default를 설정
			default:		subQuery += thirdQuery;
			}			
		}else {
			// 게시판을 처음 들어갈때는 searchKey의 값을 null자체로 인식하기 때문에 else로 구분
			subQuery += thirdQuery;
		}
	
		bList = adminDao.selectBoardList(conn, subQuery);
		
		close(conn);
		return bList;
		
	}

	/** 게시판 상세조회용 Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		// 1) 게시글 상세 조회
		Board board = new AdminDao().selectBoard(conn, boardNo);
		
		if(board != null) {
			int result = new BoardDao().increaseCount(conn, boardNo);
			
			if(result>0) {
				commit(conn);
				// 반환되는 notice는 조회수 증가가 되어있지 않으므로
				// 리턴 시 조회수를 +1 시켜주어야 한다.
				board.setBoardCount(board.getBoardCount()+1);
			}else {
				rollback(conn);
				board = null; //  조회수 증가 실패 시 조회되지 않게 처리.
			}
		}
		
		close(conn);
		return board;
	}

	/** 게시판 상태변경용 Service
	 * @param boardNo
	 * @param status
	 * @return result
	 * @throws Exception
	 */
	public int changeBoardStatus(int boardNo, String status) throws Exception{
		Connection conn = getConnection();
		
		if(status.equals("Y")) status = "N";
		else if(status.equals("N")) status = "Y";
		
		int result = new AdminDao().changeBoardStatus(conn, boardNo, status);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 신고 대상자 아이디 조회용 Service
	 * @param boardNo
	 * @return declarId
	 * @throws Exception
	 */
	public String selectDeclarId(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		String declarId = new AdminDao().selectDeclarId(conn, boardNo);
		
		close(conn);
		return declarId;
	}

	/** 신고 게시판 처리 상태 변경용 Service
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int changeDeclarStatus(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new AdminDao().changeDeclarStatus(conn, boardNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 신고횟수 증가용 Service
	 * @param declarId
	 * @return result
	 * @throws Exception
	 */
	public int updateDeclarCount(String declarId) throws Exception{
		Connection conn = getConnection();
		
		int result = new AdminDao().updateDeclarCount(conn, declarId);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}



}
