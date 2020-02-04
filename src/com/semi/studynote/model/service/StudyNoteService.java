package com.semi.studynote.model.service;

import static com.semi.common.JDBCTemplate.close;
import static com.semi.common.JDBCTemplate.commit;
import static com.semi.common.JDBCTemplate.getConnection;
import static com.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.semi.studynote.model.dao.StudyNoteDao;
import com.semi.studynote.model.vo.StudyNote;
import com.semi.studynote.model.vo.StudyNoteSet;
public class StudyNoteService{

	/** 좋아요 입력용 service 좋아요 추가시 1 / 삭제시 2
	 * @param memberNo
	 * @param noteNo
	 * @return
	 * @throws Exception
	 */
	public int likeDetail(int memberNo, int noteNo) throws Exception{
		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();


		// 좋아요 검색용
		// 좋아요가 되어 있으면 1을 리턴
		int result = dao.selectLikeDetail(conn, memberNo, noteNo);

		if(result ==0) {
			result = dao.likeDetail(conn, memberNo, noteNo); 
			// 좋아요가 되면 1을 리턴
		}else if(result ==1){
			result = dao.deleteLikeDetail(conn, memberNo, noteNo);
			// 좋아요를 삭제하면 2를 리턴
			result = 2;
		}
		if(result >0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public int addValue(int memberNo, int noteNo) throws Exception{
		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();


		// 좋아요 검색용
		// 좋아요가 되어 있으면 1을 리턴
		int result = dao.selectAddValue(conn, memberNo, noteNo);
		if(result ==0) {
			result = dao.insertAddDetail(conn, memberNo, noteNo); 
			// 좋아요가 되면 1을 리턴
		}else if(result ==1){
			result = dao.deleteAddDetail(conn, memberNo, noteNo);
			// 좋아요를 삭제하면 2를 리턴
			result = 2;
		}

		if(result >0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}



	/** 팔로우 추가시 작성 Service
	 * @param follower
	 * @param following
	 * @return 
	 * @throws Exception
	 */
	public int followInsert(int follower, int following) throws Exception{


		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();


		int	result = dao.followInsert(conn,follower,following);
		// 팔로우 삽입

		if(result>0) commit(conn);
		else rollback(conn);


		close(conn);
		return result;
	}

	public List followerSelect(int follower) throws Exception{

		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();

		List result = dao.selectFollower(conn,follower);

		close(conn);
		return result;
	}

	public List followingSelect( int following) throws Exception{

		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();

		List result = dao.followingSelect(conn,following);
		close(conn);
		return result;
	}

	/** 학습노트 갑지 생성 Service
	 * @param note
	 * @param category
	 * @param memberNo
	 * @return createStudyNote
	 * @throws Exception
	 */
	public StudyNote createStudyNote(StudyNote note, int category, int memberNo) throws Exception{

		Connection conn = getConnection();

		int result = new StudyNoteDao().createStudyNote(conn, note,category,memberNo);
		StudyNote createStudyNote = null;
		if(result>0) {
			commit(conn);

			createStudyNote = new StudyNoteDao().getStudyNote(conn,note,category,memberNo);
		}


		else rollback(conn);
		close(conn);
		return createStudyNote;
	}

	public int insertStudyNoteSet(String[] setWord, String[] setMean, int studyNoteNo) throws Exception{
		Connection conn = getConnection();
		int result = new StudyNoteDao().insertStudyNoteSet(conn,setWord,setMean,studyNoteNo);

		if(result>0)commit(conn);
		else rollback(conn);

		close(conn);
		return result;
	}

	public List<StudyNoteSet> selectStudyNoteSet(int[] studyNoteNo) throws Exception{
		Connection conn = getConnection();

		List<StudyNoteSet> snList = new StudyNoteDao().selectStudyNoteSet(conn,studyNoteNo);


		close(conn);
		return snList;
	}



	public List selectCategoryNM(int memberNo) throws Exception{
		Connection conn = getConnection();

		List categoryNM = new StudyNoteDao().selectCategoryNM(conn,memberNo);
		return categoryNM;
	}

	/** ui에 표현할 값들을 가지고 오는 service
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<StudyNote> selectStudyNoteList(int memberNo) throws Exception{

		Connection conn = getConnection();

		List<StudyNote> slist = new StudyNoteDao().selectStudyNoteList(conn,memberNo); 

		return slist;
	}

	/** 학습노트의 좋아요 숫자를 가지고 오는 Service
	 * @param studyNoteNo
	 * @return selectLieke
	 * @throws Exception
	 */
	public List selectLike(int[] studyNoteNo) throws Exception{

		Connection conn = getConnection();

		List selectLike =  new StudyNoteDao().selectLike(conn,studyNoteNo);


		return selectLike;
	}

	/** 노트세트에 몇개의 단어가 있는지 가지고 오는 Service
	 * @param studyNoteNo
	 * @return selectStudyNoteSetNM
	 * @throws Exception
	 */
	public List selectStudyNoteSetNM(int[] studyNoteNo) throws Exception{

		Connection conn = getConnection();

		List selectStudyNoteSetNM = new StudyNoteDao().selectStudyNoteSetNM(conn,studyNoteNo);

		return selectStudyNoteSetNM;
	}

	public int deleteStudyNote(int index, int memberNo) throws Exception{

		Connection conn = getConnection();
		int result = 0;
		boolean flag = new StudyNoteDao().searchStudyNote(conn,index,memberNo);
		if(flag) {

			result = new StudyNoteDao().deleteStudyNote(conn,index,memberNo);
		}

		if(result>0) commit(conn);
		else rollback(conn);
		return result;
	}

	public List<StudyNoteSet> insertStudynoteSet(int noteNumber) throws Exception{

		Connection conn = getConnection();

		List<StudyNoteSet> snslist = new StudyNoteDao().insertStudynoteSet(conn,noteNumber);

		return snslist;
	}

	public int deleteDetail(int rownum, int studynotenm) throws Exception{

		Connection conn = getConnection();

		int changedrownum = new StudyNoteDao().changeDetail(conn,rownum,studynotenm);

		int result = new StudyNoteDao().deleteDetail(conn,changedrownum,studynotenm);

		if(result>0) commit(conn);
		else rollback(conn);

		return result;
	}

	public void updateStudyNoteSetWord(String word, int rownum, int sNnum) throws Exception{
		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();

		int changedrownum = dao.changeDetail(conn, rownum, sNnum);

		int result =  dao.updateStudyNoteSetWord(conn,word,changedrownum);

		if(result>0) commit(conn);
		else rollback(conn);


	}

	public void updateStudyNoteSetMean(String mean, int rownum, int sNnum) throws Exception{
		Connection conn = getConnection();

		StudyNoteDao dao = new StudyNoteDao();

		int changedrownum = dao.changeDetail(conn, rownum, sNnum);

		int result =  dao.updateStudyNoteSetMean(conn,mean,changedrownum);

		if(result>0) commit(conn);
		else rollback(conn);

	}

	public String selectWriter(int noteNumber) throws Exception{

		Connection conn = getConnection();

		int memberNo = new StudyNoteDao().selectMemberNo(conn, noteNumber);

		String writer = new StudyNoteDao().selectWriter(conn,memberNo);

		return writer;
	}

	public int selectWriterNo(int noteNumber) throws Exception{
		Connection conn= getConnection();

		int writer = new StudyNoteDao().selectMemberNo(conn, noteNumber);
		return writer;
	}

	public int followDelete(int follower, int following) throws Exception{

		Connection conn = getConnection();

		int followflag = new StudyNoteDao().followDelete(conn, follower,following);

		if(followflag>0) commit(conn);
		else rollback(conn);


		return followflag;
	}

	public List<StudyNote> searchStudyNote(String searchKey, String searchValue) throws Exception{
		Connection conn = getConnection();
		String condition = "";
		searchValue = "'%'||'" + searchValue + "'||'%'";

		switch(searchKey){
		case "all" : condition = " (MEMBER_ID LIKE" + searchValue + "OR CATEGORY_NM LIKE" + searchValue + "OR STUDYNOTE_TITLE LIKE"+searchValue +") "; break;
		case "writer" : condition= " MEMBER_ID LIKE" +searchValue ;  break;
		case "category" : condition=" CATEGORY_NM LIKE" +searchValue;  break;
		case "title" : condition = " STUDYNOTE_TITLE LIKE"+searchValue; break;
		}

		List<StudyNote> snlist = new StudyNoteDao().searchStudyNote2(conn, condition);

		return snlist;
	}

	public void updateStudyNote(String title, int category, int sNnum) throws Exception{

		Connection conn = getConnection();

		int result = new StudyNoteDao().updateStudyNote(conn,title,category,sNnum);

		if(result>0)commit(conn);
		else rollback(conn);

	}

	public int addStatus(int noteNumber, int memberNo) throws Exception{

		Connection conn = getConnection();

		int Status = new StudyNoteDao().addStatus(conn,noteNumber,memberNo);

		return Status;
	}

	public int[] addNoteNm(int memberNo) throws Exception{
		Connection conn= getConnection();
		
		StudyNoteDao dao = new StudyNoteDao();
		
		int count = dao.countNoteNm(conn, memberNo);
		
		
		int [] addNoteNm = new StudyNoteDao().addNoteNm(conn,memberNo,count);
		
		return addNoteNm;
	}

	public StudyNote selectTakenStudyNote(int i) throws Exception{

		Connection conn = getConnection();
		
		StudyNote notes = new StudyNoteDao().selectTakenStudyNote(conn,i);
				
		
		return notes;
	}

	public int selectLikeDetail(int memberNo, int noteNumber) throws Exception{

		Connection conn = getConnection();
		
		StudyNoteDao dao = new StudyNoteDao();


		// 좋아요 검색용
		// 좋아요가 되어 있으면 1을 리턴
		int result = dao.selectLikeDetail(conn, memberNo, noteNumber);

		
		return result;
	}











}
