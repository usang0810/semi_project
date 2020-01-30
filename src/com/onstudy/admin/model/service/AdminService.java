package com.onstudy.admin.model.service;

import static com.onstudy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.onstudy.admin.model.dao.AdminDao;
import com.onstudy.member.model.vo.Member;
import com.onstudy.onstudy.model.vo.Onstudy;
import com.onstudy.studynote.model.vo.StudyNote;

import oracle.sql.DATE;

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
		int mListCount = 0;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "회원번호":	subQuery = " AND MEMBER_NO='" + content + "'"; break;
			case "아이디":	subQuery = " AND MEMBER_ID='" + content + "'"; break;
			case "이름":		subQuery = " AND MEMBER_NM='" + content + "'"; break;
			case "전화번호":	subQuery = " AND MEMBER_PHONE='" + content + "'"; break;
			case "포인트":	subQuery = " AND MEMBER_POINT='" + content + "'"; break;
			case "신고회수":	subQuery = " AND MEMBER_DECLAR_COUNT='" + content + "'"; break;
			case "정지여부":	subQuery = " AND MEMBER_STATUS='" + content + "'"; break;
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
		String thirdQuery = "'" + content + "') WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition != null) {
			switch(condition) {
			case "회원번호":	subQuery = " WHERE MEMBER_NO=" + thirdQuery; break;
			case "아이디":	subQuery = " WHERE MEMBER_ID=" + thirdQuery; break;
			case "이름":		subQuery = " WHERE MEMBER_NM=" + thirdQuery; break;
			case "전화번호":	subQuery = " WHERE MEMBER_PHONE=" + thirdQuery; break;
			case "포인트":	subQuery = " WHERE MEMBER_POINT=" + thirdQuery; break;
			case "신고회수":	subQuery = " WHERE MEMBER_DECLAR_COUNT=" + thirdQuery; break;
			case "정지여부":	subQuery = " WHERE MEMBER_STATUS=" + thirdQuery; break;
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

}
