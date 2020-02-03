package com.semi.onstudy.model.service;

import static com.semi.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.semi.member.model.vo.MyOnstudy;
import com.semi.onstudy.model.dao.OnstudyDao;
import com.semi.onstudy.model.vo.CAttachment;
import com.semi.onstudy.model.vo.CBoard;
import com.semi.onstudy.model.vo.CertifyBoardTotal;
import com.semi.onstudy.model.vo.CertifyCount;
import com.semi.onstudy.model.vo.Onstudy;
import com.semi.onstudy.model.vo.Thumbnail;

public class OnstudyService {

	/**
	 * 메인 리스트
	 * 
	 * @return
	 */
	public List<Onstudy> selectMainList() throws Exception {

		Connection conn = getConnection();
		List<Onstudy> mainList = new OnstudyDao().selectMainList(conn);

		close(conn);
		return mainList;
	}

	/**
	 * 로그인된 메인 온스터디 목록(참가비) 조회용 Service
	 * 
	 * @return pList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyPList() throws Exception {
		Connection conn = getConnection();
		List<Onstudy> pList = new OnstudyDao().selectOnstudyPList(conn);
		close(conn);
		return pList;
	}

	/**
	 * 온스터디 목록(인원수) 조회용 Service
	 * 
	 * @return mList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyMList() throws Exception {
		Connection conn = getConnection();
		List<Onstudy> mList = new OnstudyDao().selectOnstudyMList(conn);
		close(conn);
		return mList;
	}

	/**
	 * 온스터디 목록(최신날짜) 조회용 Service
	 * 
	 * @return dList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyDList() throws Exception {
		Connection conn = getConnection();
		List<Onstudy> dList = new OnstudyDao().selectOnstudyDList(conn);
		close(conn);
		return dList;
	}

	/**
	 * 온스터디 검색용 Service
	 * 
	 * @param searchKeyword
	 * @param searchCategory
	 * @param searchStartDt
	 * @param searchEndDt
	 * @return sList
	 * @throws Exception
	 */
	public int getListCount(String searchKeyword, String searchCategory, String searchStart, String searchEnd)
			throws Exception {

		Connection conn = getConnection();
		String condition = "";

		if (searchKeyword != "") {
			condition = " AND ONSTUDY_TITLE LIKE '%' || '" + searchKeyword.trim() + "' || '%'";
		}
		if (searchCategory != null) {
			condition += " AND CATEGORY_NM=" + "'" + searchCategory + "' ";
		}
		if (searchStart != "" && searchEnd != "") {
			condition += " AND ONSTUDY_START_DT BETWEEN '" + searchStart + "' AND '" + searchEnd + "'";
		}
		int listCount = new OnstudyDao().getListCount(conn, condition);

		return listCount;
	}

	public List<Onstudy> selectList(String searchKeyword, String searchCategory, String searchStart, String searchEnd,
			int currentPage, int limit) throws Exception {

		Connection conn = getConnection();
		String condition = "";

		if (searchKeyword != "") {
			condition = " AND ONSTUDY_TITLE LIKE '%' || '" + searchKeyword.trim() + "' || '%'";
		}
		if (searchCategory != null) {
			condition += " AND CATEGORY_NM=" + "'" + searchCategory + "' ";
		}
		if (searchStart != "" && searchEnd != "") {
			condition += " AND ONSTUDY_START_DT BETWEEN '" + searchStart + "' AND '" + searchEnd + "'";
		}

		List<Onstudy> sList = new OnstudyDao().selectList(conn, condition, currentPage, limit);
		close(conn);
		return sList;
	}

	/**
	 * 온스터디 상세 조회용 Service
	 * 
	 * @param onstudyNo
	 * @return onstudy
	 * @throws Exception
	 */
	public Onstudy selectOnstudy(int onstudyNo) throws Exception {
		Connection conn = getConnection();
		Onstudy onstudy = new OnstudyDao().selectOnstudy(conn, onstudyNo);
		close(conn);
		return onstudy;
	}

	/**
	 * 온스터디 같은 카테고리 조회용
	 * 
	 * @param categoryNm
	 * @return sameList
	 * @throws Exception
	 */
	public List<Onstudy> sameCategory(int onstudyNo) throws Exception {
		Connection conn = getConnection();
		List<Onstudy> sameList = new OnstudyDao().sameCategory(conn, onstudyNo);
		close(conn);
		return sameList;
	}

	/**
	 * 동일 카테고리 체크용 Service
	 * 
	 * @param onstudy
	 * @return sameCheck
	 * @throws Exception
	 */
	public int checkCategory(Onstudy onstudy) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		// 개설자가 같은 날짜에 중복된 카테고리의 온스터디에 참가하고 있는지 확인
		int sameCheck = onstudyDao.checkCategory(conn, onstudy);

		close(conn);
		return sameCheck;
	}

	/**
	 * 참가중인 온스터디 개수 체크용 Service
	 * 
	 * @param onstudy
	 * @return joinCheck
	 * @throws Exception
	 */
	public int checkJoinCount(Onstudy onstudy) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		// 개설자가 같은 날짜에 중복된 카테고리의 온스터디에 참가하고 있는지 확인
		int joinCheck = onstudyDao.checkJoinCount(conn, onstudy);

		close(conn);
		return joinCheck;
	}

	/**
	 * 온스터디 개설용 Service
	 * 
	 * @param onstudy
	 * @param saveFile
	 * @return result
	 * @throws Exception
	 */
	public int createOnstudy(Onstudy onstudy, Thumbnail thumbImg) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		// 등록될 온서비스의 번호를 얻어옴
		int nextNo = onstudyDao.selectNextNo(conn);
		onstudy.setOnstudyNo(nextNo);

		int result = 0;

		if (nextNo > 0) {
			result = onstudyDao.createOnstudy(conn, onstudy); // 썸네일을 제외한 온스터디 정보 insert

			if (result > 0 && thumbImg.getChangeName() != null) { // 온스터디 개설되고 썸네일 이미지가 존재할 때 썸네일 삽입
				result = 0; // 재활용

				thumbImg.setOnstudyNo(onstudy.getOnstudyNo());
				result = onstudyDao.insertThumbnail(conn, thumbImg);
			}
			;

			if (result > 0) { // 개설되면 참가해야 함

				int check = onstudyDao.joinOnstudy(conn, onstudy.getMemberNo(), onstudy.getOnstudyNo());

				if (check > 0) { // 참가 성공하면 포인트 차감
					check = onstudyDao.joinPoint(conn, onstudy.getOnstudyFee(), onstudy.getMemberNo());
				}

				if (check > 0)
					result = 1;
				else
					result = 0;
			}
		}

		// 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {
			// DB 삽입 실패 시 서버에 저장된 파일 삭제
			File failedFile = new File("/WEB-INF/views/onstudy/resources/" + thumbImg.getChangeName());
			failedFile.delete();
		}

		close(conn);
		return result;
	}

	/**
	 * 해당 온스터디에 참가하고 있는지 확인하는 Service
	 * 
	 * @param memberNo
	 * @param onstudyNo
	 * @return check
	 * @throws Exception
	 */
	public int checkJoin(int memberNo, int onstudyNo) throws Exception {
		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();
		int check = onstudyDao.checkJoin(conn, memberNo, onstudyNo);

		close(conn);
		return check;
	}

	// 개설자는 개설하면서 참가하기 때문에 개설자 외의 멤버만 사용
	/**
	 * 온스터디 참가용 Service
	 * 
	 * @param memberNo
	 * @param onstudy
	 * @return result
	 * @throws Exception
	 */
	public int joinOnstudy(int memberNo, Onstudy onstudy) throws Exception {
		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		int result = onstudyDao.joinOnstudy(conn, memberNo, onstudy.getOnstudyNo());

		if (result > 0) { // 멤버 온스터디 리스트 삽입 성공 시

			// 포인트 테이블에 삽입
			result = onstudyDao.joinPoint(conn, onstudy.getOnstudyFee(), memberNo);

		}
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	/**
	 * 온스터디 참가 취소용 Service
	 * 
	 * @param memberNo
	 * @param onstudy
	 * @return result
	 * @throws Exception
	 */
	public int cancelOnstudy(int memberNo, Onstudy onstudy) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		// 멤버 온스터디 리스트 삭제
		int result = onstudyDao.cancelOnstudy(conn, memberNo, onstudy.getOnstudyNo());

		if (result > 0) { // 멤버 온스터디 리스트 삭제 성공 시

			// 포인트 테이블에 취소환불 삽입
			result = onstudyDao.cancelPoint(conn, onstudy.getOnstudyFee(), memberNo);

		}
		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	/**
	 * 현재 로그인한 멤버가 개설한 온스터디 개수를 조회하는 Service
	 * 
	 * @param memberNo
	 * @return onstudyCount
	 * @throws Exception
	 */
	public int manageCount(int memberNo) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		int onstudyCount = onstudyDao.manageCount(conn, memberNo);

		close(conn);
		return onstudyCount;
	}

	/**
	 * 개설한 온스터디 + 카테고리 이름 + 썸네일 경로를 조회하는 Service
	 * 
	 * @param memberNo
	 * @return oList
	 * @throws Exception
	 */
	public List<Onstudy> selectOnstudyList(int memberNo) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		List<Onstudy> oList = onstudyDao.selectOnstudyList(conn, memberNo);

		close(conn);
		return oList;
	}

	/**
	 * 온스터디 수정 화면에 온스터디 정보 보여주기 위해 데이터 가져오는 Service
	 * 
	 * @param onstudyNo
	 * @return onstudy
	 * @throws Exception
	 */
	public Onstudy selectUpdate(int onstudyNo) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		Onstudy onstudy = onstudyDao.selectUpdate(conn, onstudyNo);

		close(conn);
		return onstudy;
	}

	/**
	 * 온스터디에 썸네일이 존재하는지 확인하는 Service
	 * 
	 * @param onstudyNo
	 * @return check
	 * @throws Exception
	 */
//	public int checkThumbnail(int onstudyNo) throws Exception{
//		
//		Connection conn = getConnection();
//		int check = new OnstudyDao().checkThumbnail(conn, onstudyNo);
//		
//		close(conn);
//		return check;
//	}

	/**
	 * 온스터디 + 온스터디 썸네일 수정 Service
	 * 
	 * @param onstudy
	 * @param thumbImg
	 * @return result
	 * @throws Exception
	 */
	public int updateOnstudy(Onstudy onstudy, Thumbnail thumbImg) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		// 수정할 온스터디의 썸네일이 존재하는지 확인
		int check = onstudyDao.checkThumbnail(conn, onstudy.getOnstudyNo());

		int result = 0;

		String nowThumbnail = null;

		result = onstudyDao.updateOnstudy(conn, onstudy); // 썸네일을 제외한 온스터디 정보 update

		System.out.println("result : " + result);

		if (result > 0 && thumbImg.getChangeName() != null) { // 온스터디 정보가 수정되고, 수정 화면에서 선택한 썸네일이 있다면

			result = 0; // 재활용

			// 썸네일을 수정할 온스터디 번호 썸네일 생성자에 세팅
			thumbImg.setOnstudyNo(onstudy.getOnstudyNo());

			// 기존 썸네일이 있다면 파일 이름 업데이트
			if (check > 0) {
				// 서버에 있는 기존 썸네일 파일 삭제하기 위해 기존 썸네일 이름 가져오기
				nowThumbnail = onstudyDao.selectThumbnail(conn, onstudy.getOnstudyNo());

				// 서버에 있는 기존 썸네일 삭제
				File failedFile = new File("/WEB-INF/views/onstudy/resources/" + nowThumbnail);
				failedFile.delete();

				result = onstudyDao.updateThumbnail(conn, thumbImg);

			} else { // 기존 썸네일이 없다면 insert

				result = onstudyDao.insertThumbnail(conn, thumbImg);
			}

		}
		;

		// 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {
			// DB 삽입 실패 시 서버에 저장된 파일 삭제
			File failedFile = new File("/WEB-INF/views/onstudy/resources/" + thumbImg.getChangeName());
			failedFile.delete();
		}

		close(conn);
		return result;
	}

	/**
	 * 온스터디 + 온스터디 썸네일 삭제 Service
	 * 
	 * @param onstudyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteOnstudy(int onstudyNo) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();
		int result = 0;

		// 온스터디에 썸네일이 존재하는지 확인
		int check = onstudyDao.checkThumbnail(conn, onstudyNo);

		result = onstudyDao.deleteOnstudy(conn, onstudyNo); // 해당 온스터디의 status 변화 -> member_onstudy_list 삭제 안해도 됨

		if (result > 0 && check > 0) { // 썸네일이 존재하면 onstudy_image 테이블에서 데이터 삭제하고 실제 서버에서도 삭제

			result = 0; // 재사용을 위한 초기화

			result = onstudyDao.deleteThumbnail(conn, onstudyNo);

			// 썸네일이 삭제됐다면 서버에서도 삭제 해야 함
			if (result > 0) {
				// 서버에 있는 썸네일 파일 삭제하기 위해 해당 온스터디 썸네일 이름 가져오기
				String nowThumbnail = onstudyDao.selectThumbnail(conn, onstudyNo);

				// 서버에 있는 기존 썸네일 삭제
				File failedFile = new File("/WEB-INF/views/onstudy/resources/" + nowThumbnail);
				failedFile.delete();
			}
		}

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

	/**
	 * 현재 시점의 해당 멤버가 참가 중인 온스터디 조회용 Service
	 * 
	 * @param memberNo
	 * @return nList
	 * @throws Exception
	 */
	public List<Onstudy> nowJoin(int memberNo) throws Exception {

		Connection conn = getConnection();
		List<Onstudy> nList = new OnstudyDao().nowJoin(conn, memberNo);

		close(conn);
		return nList;
	}

	/**
	 * 해당 멤버가 현재 시점을 기준으로 오늘/n주차에 인증했는지 조회용 Service
	 * 
	 * @param memberNo
	 * @return twList
	 * @throws Exception
	 */
	public List<CertifyCount> todayWeek(int memberNo) throws Exception {
		Connection conn = getConnection();
		List<CertifyCount> twList = new OnstudyDao().todayWeek(conn, memberNo);

		close(conn);
		return twList;
	}

	/**
	 * 멤버+온스터디별 인증횟수 , 온스터디별 총 인증횟수 조회용 Service
	 * 
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<CertifyCount> checkRate(int memberNo) throws Exception {
		Connection conn = getConnection();
		List<CertifyCount> ccList = new OnstudyDao().checkRate(conn, memberNo);
		return ccList;
	}

	/**
	 * 현재 온스터디 인증 게시글 전체 수 조회용 Service
	 * 
	 * @param onstudyNo
	 * @return listCount
	 * @throws Exception
	 */
	public int boardListCount(int onstudyNo) throws Exception {

		Connection conn = getConnection();
		int listCount = new OnstudyDao().boardListCount(conn, onstudyNo);

		close(conn);
		return listCount;
	}

	/**
	 * 현재 온스터디 인증 게시글 조회용 Service
	 * 
	 * @param currentPage
	 * @param limit
	 * @param onstudyNo
	 * @return bList
	 * @throws Exception
	 */
	public List<CBoard> selectList(int currentPage, int limit, int onstudyNo) throws Exception {

		Connection conn = getConnection();

		List<CBoard> bList = new OnstudyDao().selectList(conn, currentPage, limit, onstudyNo);

		close(conn);
		return bList;
	}

	/**
	 * 인증 게시글 등록용 Service
	 * 
	 * @param board
	 * @param boardWriter
	 * @param fList
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(CBoard board, int boardWriter, ArrayList<CAttachment> fList) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();
		int result = 0;

		// 1) 등록될 게시글의 번호를 얻어옴 -> SEQ_BNO.NEXTVAL 값을 얻어온다
		int boardNo = onstudyDao.selectNextBoardNo(conn);

		if (boardNo > 0) { // 게시글 번호를 얻어온 경우

			// 2) 게시글(Board)를 DB에 먼저 삽입
			board.setBoardNo(boardNo);
			result = onstudyDao.insertBoard(conn, board, boardWriter);

			if (result > 0 && !fList.isEmpty()) { // 게시글 삽입 성공 시
				result = 0; // 트랜잭션 처리를 위해 재활용

				// 3) fList의 데이터를 하나씩 DB에 삽입
				for (CAttachment file : fList) {

					// 현재 게시글 번호 추가
					file.setBoardNo(boardNo);

					result = onstudyDao.insertAttachment(conn, file);

					// 삽입 실패 시
					if (result == 0)
						break;
				}
			}
		}

		// 4) 트랜잭션 처리
		if (result > 0)
			commit(conn);
		else {

			// 5) DB 삽입 실패 시 서버에 저장된 파일을 삭제
			for (CAttachment file : fList) {

				String saveFile = file.getChangeName();

				File failedFile = new File("/WEB-INF/views/onstudy/resources/" + saveFile);

				failedFile.delete();
			}
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 인증 게시글 상세 조회용 Service
	 * 
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public CBoard selectBoard(int boardNo) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();

		CBoard board = onstudyDao.selectBoard(conn, boardNo);

		// 게시글 상세조회 성공 시 조회수 증가
		if (board != null) {
			int result = onstudyDao.increaseCount(conn, boardNo);

			// 조회수 증가 성공 시
			if (result > 0) {
				commit(conn);
				board.setBoardCount(board.getBoardCount() + 1);
			} else {
				rollback(conn);
				board = null; // 조회수 증가 실패 시 조회되는 내용 없음
			}
		}

		close(conn);
		return board;
	}

	/**
	 * 인증 게시글 이미지 파일 조회용 Service
	 * 
	 * @param boardNo
	 * @return files
	 * @throws Exception
	 */
	public List<CAttachment> selectFiles(int boardNo) throws Exception {
		Connection conn = getConnection();

		List<CAttachment> files = new OnstudyDao().selectFiles(conn, boardNo);

		close(conn);
		return files;
	}

	/**
	 * 인증 게시글 수정용 Service
	 * 
	 * @param board
	 * @param boardWriter
	 * @param fList
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(CBoard board, int boardWriter, ArrayList<CAttachment> fList, String[] beforeImg,
			String savePath) throws Exception {

		Connection conn = getConnection();
		OnstudyDao onstudyDao = new OnstudyDao();
		int result = 0;

		int boardNo = board.getBoardNo();

		// 게시글(Board)를 DB에 먼저 수정
		board.setBoardNo(boardNo);
		result = onstudyDao.updateBoard(conn, board, boardWriter);

		System.out.println(fList);

		if (result > 0 && !fList.isEmpty()) { // 게시글 수정 성공 시
			result = 0; // 트랜잭션 처리를 위해 재활용
			// 기존 수정
			// 1,2,3 --> 1,2,3 추가
			// 1,2 3,4 --> 1,2 수정
			// 1,2 1,3,4 --> 2수정, 4추가

			// 1,2 --> 1,2 삭제
			// 1,2 1 --> 2 삭제

			if (beforeImg != null) {
				// 수정하려는 게시글에 있는 이미지 조회
				List<String> imgList = onstudyDao.selectImgList(conn, board.getBoardNo());

				int idx = 0; // fList 접근용
				for (String beforePath : beforeImg) {
					if (!beforePath.equals("")) {
						// 첨부 파일의 수정내용이 있다면
						result = onstudyDao.updateAttachment(conn, beforePath, fList.get(idx).getChangeName());
						if (result == 0)
							break;
						idx++;
					}
				}

				System.out.println("idx : " + idx);
				System.out.println("fList.size() : " + fList.size());

				// if(result !=0 && idx < fList.size()) {
				if (idx < fList.size()) {
					for (int i = idx; i < fList.size(); i++) {
						result = onstudyDao.insertAttachment(conn, fList.get(i));
						System.out.println("1111111111111 : " + result);
						if (result == 0)
							break;
					}
				}

				System.out.println("insertR : " + result);

			} else {
				// 이미지가 없던글에 이미지 추가 시
				// fList의 데이터를 하나씩 DB에 삽입
				for (CAttachment file : fList) {
					// 현재 게시글 번호 추가
					file.setBoardNo(boardNo);
					result = onstudyDao.insertAttachment(conn, file);
					// 삽입 실패 시
					if (result == 0)
						break;
				}
			}
		}

		// 4) 트랜잭션 처리
		if (result > 0) {
			commit(conn);
			if (beforeImg != null) {
				for (String beforePath : beforeImg) {
					File faildFile = new File(savePath + beforePath);
					faildFile.delete();
				}
			}
		} else {

			// 5) DB 삽입 실패 시 서버에 저장된 파일을 삭제
			for (CAttachment file : fList) {

				String saveFile = file.getChangeName();

				File failedFile = new File(savePath + saveFile);

				failedFile.delete();
			}
			rollback(conn);
		}
		close(conn);
		return result;
	}

	/**
	 * 검색 게시글 개수 조회용 Service
	 * 
	 * @param onstudyNo
	 * @param searchValue
	 * @param searchKey
	 * @return listCount
	 * @throws Exception
	 */
	public int searchListCount(int onstudyNo, String searchKey, String searchValue) throws Exception {

		Connection conn = getConnection();

		String condition = null;

		searchValue = "'%' || '" + searchValue + "' || '%'";
		// '%공지%'

		switch (searchKey) {
		case "title":
			condition = " ONSTUDY_BOARD_TITLE LIKE " + searchValue;
			break;
		case "writer":
			condition = " MEMBER_ID LIKE " + searchValue;
			break;
		case "content":
			condition = " ONSTUDY_BOARD_CONTENT LIKE " + searchValue;
			break;
		}

		int listCount = new OnstudyDao().searchListCount(conn, onstudyNo, condition);

		close(conn);
		return listCount;
	}

	/**
	 * 인증 게시글 검색 리스트 반환용 Service
	 * 
	 * @param currentPage
	 * @param limit
	 * @param onstudyNo
	 * @param searchKey
	 * @param searchValue
	 * @return bList
	 * @throws Exception
	 */
	public List<CBoard> searchList(int currentPage, int limit, int onstudyNo, String searchKey, String searchValue)
			throws Exception {

		Connection conn = getConnection();

		String condition = null;

		searchValue = "'%' || '" + searchValue + "' || '%'";
		// '%공지%'

		switch (searchKey) {
		case "title":
			condition = " ONSTUDY_BOARD_TITLE LIKE " + searchValue;
			break;
		case "writer":
			condition = " MEMBER_ID LIKE " + searchValue;
			break;
		case "content":
			condition = " ONSTUDY_BOARD_CONTENT LIKE " + searchValue;
			break;
		}

		List<CBoard> blist = new OnstudyDao().searchList(conn, currentPage, limit, onstudyNo, condition);

		close(conn);
		return blist;
	}

	/**
	 * 멤버가 해당 온스터디에 오늘 인증했는지 확인용 Service
	 * 
	 * @param onstudyNo
	 * @param memberNo
	 * @return todayCertifyCount
	 * @throws Exception
	 */
	public int checkToday(int onstudyNo, int memberNo) throws Exception {

		Connection conn = getConnection();
		int todayCertifyCount = new OnstudyDao().checkToday(conn, onstudyNo, memberNo);

		close(conn);
		return todayCertifyCount;
	}

	/**
	 * 현재 날짜가 몇 주차인지 확인용 Service
	 * 
	 * @param onstudyNo
	 * @return nWeek
	 * @throws Exception
	 */
	public int selectNWeek(int onstudyNo) throws Exception {

		Connection conn = getConnection();
		int nWeek = new OnstudyDao().selectNWeek(conn, onstudyNo);

		close(conn);
		return nWeek;
	}

	/**
	 * 주에 인증 횟수 확인용 Service
	 * 
	 * @param onstudyNo
	 * @param memberNo
	 * @param nWeek
	 * @return checkCertify
	 * @throws Exception
	 */
	public CertifyCount checkCertifyCount(int onstudyNo, int memberNo, int nWeek) throws Exception {

		Connection conn = getConnection();
		CertifyCount checkCertify = new OnstudyDao().checkCertifyCount(conn, onstudyNo, memberNo, nWeek);

		close(conn);
		return checkCertify;
	}

	////////////////////////////////////// 마이페이지//////////////////////////////////////////////////

	/**
	 * 내 온스터디 내역 개수 조회하는 Service
	 * 
	 * @param memberNo
	 * @return listCount
	 * @throws Exception
	 */
	public int myOnstudyCount(int memberNo) throws Exception {

		Connection conn = getConnection();
		int listCount = new OnstudyDao().myOnstudyCount(conn, memberNo);

		close(conn);
		return listCount;
	}

	/**
	 * 내 온스터디 내역 리스트조회하는 Service
	 * 
	 * @param memberNo
	 * @return myList
	 * @throws Exception
	 */
	public List<MyOnstudy> myOnstudyList(int memberNo) throws Exception {

		Connection conn = getConnection();
		List<MyOnstudy> myList = new OnstudyDao().myOnstudyList(conn, memberNo);

		close(conn);
		return myList;
	}

	/**
	 * 인증게시판에 보여주는 정보 모두 조회하는 Service
	 * 
	 * @param memberNo
	 * @return totalList
	 * @throws Exception
	 */
	public List<CertifyBoardTotal> CertifyTotal(int memberNo) throws Exception {
		Connection conn = getConnection();
		List<CertifyBoardTotal> totalList = new OnstudyDao().CertifyTotal(conn, memberNo);

		close(conn);
		return totalList;
	}

	/**
	 * 환급금 insert service
	 * 
	 * @param onstudyNo
	 * @param memberNo
	 * @param refund
	 * @return result
	 * @throws Exception
	 */
	public static int refund(int onstudyNo, int memberNo, int refund) throws Exception {
		Connection conn = getConnection();
		int result = new OnstudyDao().refund(conn, onstudyNo, memberNo, refund);

		if (result > 0) {
			result = new OnstudyDao().insertPoint(conn, memberNo, refund);
		}

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		return result;
	}

}
