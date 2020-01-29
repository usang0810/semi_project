package com.onstudy.admin.model.service;

import static com.onstudy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.onstudy.admin.model.dao.AdminDao;
import com.onstudy.member.model.vo.Member;

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
		
		String subQuery = null;
		int mListCount = 0;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition == null) mListCount = adminDao.getMemberListCount(conn);
		else {
			if(condition.equals("회원번호"))		subQuery = " AND MEMBER_NO='" + content + "'";
			else if(condition.equals("아이디"))	subQuery = " AND MEMBER_ID='" + content + "'";
			else if(condition.equals("이름"))		subQuery = " AND MEMBER_NM='" + content + "'";
			else if(condition.equals("전화번호"))	subQuery = " AND MEMBER_PHONE='" + content + "'";
			else if(condition.equals("포인트"))	subQuery = " AND MEMBER_POINT='" + content + "'";
			else if(condition.equals("신고회수"))	subQuery = " AND MEMBER_DECLAR_COUNT='" + content + "'";
			else if(condition.equals("정지여부"))	subQuery = " AND MEMBER_STATUS='" + content + "'";

			System.out.println(subQuery);
			mListCount = adminDao.getMemberListCount(conn, subQuery);				
		}
			
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
		String subQuery = null;
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		String thirdQuery = "'" + content + "') WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		
		// 회원번호, 아이디, 이름, 전화번호, 포인트, 신고회수, 정지여부
		if(condition == null) subQuery = ") WHERE RNUM BETWEEN " + startRow + " AND " + endRow;
		else if(condition.equals("회원번호"))	subQuery = " WHERE MEMBER_NO=" + thirdQuery;
		else if(condition.equals("아이디"))	subQuery = " WHERE MEMBER_ID=" + thirdQuery;
		else if(condition.equals("이름"))		subQuery = " WHERE MEMBER_NM=" + thirdQuery;
		else if(condition.equals("전화번호"))	subQuery = " WHERE MEMBER_PHONE=" + thirdQuery;
		else if(condition.equals("포인트"))	subQuery = " WHERE MEMBER_POINT=" + thirdQuery;
		else if(condition.equals("신고회수"))	subQuery = " WHERE MEMBER_DECLAR_COUNT=" + thirdQuery;
		else if(condition.equals("정지여부"))	subQuery = " WHERE MEMBER_STATUS=" + thirdQuery;
		
		mList = adminDao.selectMemberList(conn, subQuery);
		
		return mList;
	}

}
