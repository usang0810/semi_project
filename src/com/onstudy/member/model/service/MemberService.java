package com.onstudy.member.model.service;

import static com.onstudy.common.JDBCTemplate.close;
import static com.onstudy.common.JDBCTemplate.commit;
import static com.onstudy.common.JDBCTemplate.getConnection;
import static com.onstudy.common.JDBCTemplate.rollback;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import com.onstudy.member.model.dao.MemberDao;
import com.onstudy.member.model.vo.Image;
import com.onstudy.member.model.vo.Member;
import com.onstudy.member.model.vo.Point;

public class MemberService {

	/** 로그인용 Service
	 * @param inputMember
	 * @return loginMember
	 * @throws Exception
	 */
	public Member selectMember(Member inputMember) throws Exception {
		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		
		Member loginMember = memberDao.selectMember(conn, inputMember);
		
		close(conn);
		
		return loginMember;
	}
	
	/** 회원 이미지 경로 조회용 Service
	 * @param memberNo
	 * @return imagePath
	 * @throws Exception
	 */
	public String selectImagePath(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		String imagePath = new MemberDao().selectImagePath(conn, memberNo);
		
		close(conn);
		return imagePath;
	}

	/** 회원가입용 Service
	 * @param signupMember
	 * @return result
	 * @throws Exception
	 */
	public int signupMember(Member signupMember) throws Exception{
		Connection conn = getConnection();
		MemberDao memberDao = new MemberDao();
		
		// 은행코드와 계좌번호 입력이 있는지 확인
		// 프로필 사진을 업로드 했는지 확인
		int result = memberDao.signupMember(conn, signupMember);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 번호 조회용 Service
	 * @param memberId
	 * @return memberNo
	 * @throws Exception
	 */
	public int selectMemberNo(String memberId) throws Exception{
		Connection conn = getConnection();
		
		int memberNo = new MemberDao().selectMemberNo(conn, memberId);
		
		close(conn);
		return memberNo;
	}

	/** 회원 프로필 이미지 삽입용 Service
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int insertProfileImage(Image profileImage) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().insertProfileImage(conn, profileImage);
		
		if(result > 0) commit(conn);
		else {
			// 이미지 삽입 실패 시 서버의 이미지 삭제
			
			File failedFile = new File(profileImage.getImagePath());
			
			failedFile.delete();
			
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	/** 아이디 중복 검사용 Service
	 * @param inputId
	 * @return result
	 * @throws Exception
	 */
	public int idDupCheck(String inputId) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().idDupCheck(conn, inputId);
		
		close(conn);
		return result;
	}

	/** 회원 비밀번호 일치 조회용 Service
	 * @param memberNo
	 * @param memberPwd
	 * @return result
	 * @throws Exception
	 */
	public int pwdCheck(int memberNo, String memberPwd) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().pwdCheck(conn, memberNo, memberPwd);
		
		close(conn);
		return result;
	}

	/** 회원 탈퇴용 Service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().secession(conn, memberNo);
		
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 ID 찾기용 Service
	 * @param memberPhone
	 * @return findIdMember
	 * @throws Exception
	 */
	public Member findIdMember(String memberPhone) throws Exception{
		Connection conn = getConnection();
		
		Member findIdMember = new MemberDao().findIdMember(conn, memberPhone);
		
		close(conn);
		return findIdMember;
	}

	/** 회원 비밀번호 찾기용 Service
	 * @param memberId
	 * @param memberPhone
	 * @return result
	 * @throws Exception
	 */
	public int findPwdMember(String memberId, String memberPhone) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().findPwdMember(conn, memberId, memberPhone);
		
		close(conn);
		return result;
	}

	/** 회원 정보 수정용 Service
	 * @param updateMember
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member updateMember) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, updateMember);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 기존 프로필 사진 삭제용 Service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteProfileImg(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteProfileImg(conn, memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 계정 포인트 업데이트용 Service
	 * @param point
	 * @return result
	 * @throws Exception
	 */
	public int updatePoint(Point point) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePoint(conn, point);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 포인트 조회용 Service
	 * @param memberNo
	 * @return point
	 * @throws Exception
	 */
	public int getMemberPoint(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int point = new MemberDao().getMemberPoint(conn, memberNo);

		close(conn);
		return point;
	}

	/** 회원 비밀번호 변경용 Service
	 * @param memberId
	 * @param memberPwd
	 * @return result
	 * @throws Exception
	 */
	public int changePwdMember(String memberId, String memberPwd) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().changePwdMember(conn, memberId, memberPwd);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 회원 포인트 내역 갯수 조회용 Service
	 * @param memberNo
	 * @return pListCount
	 */
	public int getPointListCount(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = new MemberDao().getPointListCount(conn, memberNo);
		
		close(conn);
		return result;
	}

//	/** 회원 포인트 내역 리스트 조회용 Service
//	 * @param memberNo
//	 * @param currentPage
//	 * @param limit
//	 * @return pList
//	 * @throws Exception
//	 */
//	public List<Point> selectPointList(int memberNo, int currentPage, int limit) throws Exception{
//		Connection conn = getConnection();
//		
//		List<Point> pList = new MemberDao().selectPointList(conn, memberNo, currentPage, limit);
//		
//		close(conn);
//		return pList;
//	}

	/** 회원 포인트 내역 리스트 조회용 Service
	 * @param memberNo
	 * @param pointInOut
	 * @param pointMonth
	 * @param currentPage
	 * @param limit
	 * @return pList
	 * @throws Exception
	 */
	public List<Point> selectPointList(int memberNo, char pointInOut, int pointMonth, int currentPage, int limit) throws Exception{
		Connection conn = getConnection();
		List<Point> pList = null;
		
		String queryTitle = null;
		
		if(pointInOut != 'W' && pointMonth != 0) {
			queryTitle = "selectPointList1";
			pList = new MemberDao().selectPointList(conn, memberNo, pointInOut, pointMonth, currentPage, limit, queryTitle);
			
		}else if(pointInOut != 'W' && pointMonth == 0) {
			queryTitle = "selectPointList2";
			pList = new MemberDao().selectPointList(conn, memberNo, pointInOut, currentPage, limit, queryTitle);
			
		}else if(pointInOut == 'W' && pointMonth != 0) {
			queryTitle = "selectPointList3";
			pList = new MemberDao().selectPointList(conn, memberNo, pointMonth, currentPage, limit, queryTitle);
			
		}else {
			queryTitle = "selectPointList4";
			pList = new MemberDao().selectPointList(conn, memberNo, currentPage, limit, queryTitle);
		}
		
		close(conn);
		return pList;
	}



}
