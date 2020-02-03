package com.semi.studynote.model.dao;

import static com.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.studynote.model.vo.StudyNote;
import com.semi.studynote.model.vo.StudyNoteSet;

public class StudyNoteDao {

	private Properties prop = null;

	public StudyNoteDao() throws Exception{

		String fileName = StudyNoteDao.class.getResource("/com/semi/sql/studyNote/studyNote-query.properties").getPath();

		prop = new Properties();
		prop.load(new FileReader(fileName));

	}

	public int likeDetail(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		String query = prop.getProperty("likeDetail");
		int result = 0;
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);
			// 
			result = pstmt.executeUpdate();


		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public int insertAddDetail(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertAddDetail");
		int result = 0;
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);
			// 
			result = pstmt.executeUpdate();


		}
		finally {
			close(pstmt);
		}

		return result;
	}

	/** 좋아요 검색용 DAO
	 * @param conn
	 * @param memberNo
	 * @param noteNo
	 * @return result
	 * @throws Exception
	 */
	public int selectLikeDetail(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectLikeDetail");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = 1;
			}

		}
		finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int selectAddValue(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAddDetail");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				result = 1;
			}

		}
		finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int deleteLikeDetail(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteLikeDetail");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);

			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteAddDetail(Connection conn, int memberNo, int noteNo) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteAddDetail");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, noteNo);

			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public List selectFollower(Connection conn, int follower) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFollower");
		String followers = null;
		List result = new ArrayList();

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, follower);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				followers = rset.getString("MEMBER_ID");
				result.add(followers);
			}

		}
		finally {
			close(rset);
			close(pstmt);

		}

		return result;
	}

	public int followInsert(Connection conn, int follower, int following) throws Exception{
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertFollow");
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, following);
			pstmt.setInt(2, follower);
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public List followingSelect(Connection conn, int following) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectFollowings");
		String followings = "";
		List result = new ArrayList();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, following);
			rset = pstmt.executeQuery();
			if(rset !=null) {

				while(rset.next()) {
					followings = rset.getString("MEMBER_ID");
					result.add(followings);
				}
			}

		}
		finally {
			close(rset);
			close(pstmt);

		}

		return result;


	}

	/** 학습노트 갑지 생성 dao
	 * @param conn
	 * @param note
	 * @param category
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int createStudyNote(Connection conn, StudyNote note, int category, int memberNo) throws Exception{

		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("createStudyNote");
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, note.getStudyNoteTitle());
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, category);

			result=pstmt.executeUpdate();


		}
		finally {
			close(pstmt);
		}
		return result;

	}

	public StudyNote getStudyNote(Connection conn, StudyNote note, int category,int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getStudyNote");
		StudyNote studynote = null;
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, note.getStudyNoteTitle());
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, category);
			rset =pstmt.executeQuery(); 
			if(rset.next()) {


				studynote = new StudyNote(rset.getInt("STUDYNOTE_NO"),rset.getString("STUDYNOTE_TITLE"), 
						rset.getDate("STUDYNOTE_MODIFY_DT"), rset.getString("STUDYNOTE_WRITER"), 
						rset.getString("CATEGORY_NM"));

			}
		}
		finally {
			close(rset);
			close(pstmt);
		}

		return studynote;
	}

	public int insertStudyNoteSet(Connection conn, String[] setWord, String[] setMean,int studyNoteNo) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertStudyNoteSet");
		try {

			pstmt = conn.prepareStatement(query);
			for(int i = 0 ; i<setWord.length;i++) {

				if(setWord[i]!=null&&setMean[i]!=null&&!setWord[i].isEmpty()&&!setMean[i].isEmpty()) {

					pstmt.setString(1, setWord[i]);
					pstmt.setString(2, setMean[i]);
					pstmt.setInt(3, studyNoteNo);
					result += pstmt.executeUpdate();

				}
			}

		}
		finally {
			close(pstmt);

		}
		return result;
	}

	/** 노트 상세 조회 데이터 가져오기용 dao
	 * @param conn
	 * @param studyNoteNo
	 * @return snList
	 * @throws Exception
	 */
	public List<StudyNoteSet> selectStudyNoteSet(Connection conn, int [] studyNoteNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		StudyNoteSet studynote = null;
		String query = prop.getProperty("selectStudyNoteSet");
		ArrayList<StudyNoteSet> snList = null;
		try {

			pstmt = conn.prepareStatement(query);
			snList = new ArrayList<StudyNoteSet>();
			for(int i = 0 ; i <studyNoteNo.length ; i++) {

				pstmt.setInt(1, studyNoteNo[i]);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					studynote = new StudyNoteSet(rset.getInt("SET_NO"), rset.getString("SET_WORD"), rset.getString("SET_MEAN"), rset.getInt("STUDYNOTE_NO"));

					snList.add(studynote);
				}
			}

		}
		finally {
			close(rset);
			close(pstmt);
		}


		return snList;
	}



	public List selectCategoryNM(Connection conn, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset= null;
		List categoryNM = null;
		String result = null;
		String query = prop.getProperty("selectCategoryNM");

		try {
			categoryNM = new ArrayList();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();


			while(rset.next()) {

				result= rset.getString("CATEGORY_NM");

				categoryNM.add(result) ;

			}
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return categoryNM;
	}public List selectLike(Connection conn, int[] studyNoteNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectLike");
		List selectLike = null;		
		int result = 0;
		try {
			selectLike = new ArrayList();
			pstmt = conn.prepareStatement(query);
			for(int i = 0 ; i < studyNoteNo.length; i++) {


				pstmt.setInt(1, studyNoteNo[i]);
				rset=pstmt.executeQuery();
				while(rset.next()) {
					result = rset.getInt(1);
					selectLike.add(result);
				}
			}
		}
		finally {
			close(rset);
			close(pstmt);
		}


		return selectLike;
	}

	/** ui에 표현할 값들을 가지고 오는 dao
	 * @param conn
	 * @param memberNo
	 * @return slist
	 * @throws Exception
	 */
	public List<StudyNote> selectStudyNoteList(Connection conn, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query = prop.getProperty("selectStudyNoteList");
		StudyNote studynote = null;
		List<StudyNote> slist = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			slist = new ArrayList<StudyNote>();


			while(rset.next()) {

				studynote = new StudyNote(rset.getInt("STUDYNOTE_NO"), 
						rset.getString("STUDYNOTE_TITLE"), rset.getDate("STUDYNOTE_MODIFY_DT"),rset.getString("STUDYNOTE_STATUS").charAt(0),
						rset.getString("MEMBER_ID"),rset.getString("CATEGORY_NM"));


				slist.add(studynote);
			}

		}
		finally {
			close(rset);
			close(pstmt);
		}

		return slist;
	}



	public List selectStudyNoteSetNM(Connection conn, int[] studyNoteNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectStudyNoteSetNM");
		List selectStudyNoteSetNM = null;
		int result = 0;
		try {

			pstmt = conn.prepareStatement(query);
			selectStudyNoteSetNM = new ArrayList();
			for(int i = 0; i<studyNoteNo.length;i++) {

				pstmt.setInt(1, studyNoteNo[i]);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					result = rset.getInt(1);
					selectStudyNoteSetNM.add(result);
				}
			}


		}
		finally {
			close(rset);
			close(pstmt);
		}
		return selectStudyNoteSetNM;
	}

	public int deleteStudyNote(Connection conn, int index, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteStudyNote");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, index);
			result =pstmt.executeUpdate();  
		}
		finally {
			close(pstmt);

		}
		return result;
	}

	public boolean searchStudyNote(Connection conn, int index, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("searchStudyNote");
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, index);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			result = rset.next();
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public List<StudyNoteSet> insertStudynoteSet(Connection conn, int noteNumber) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String query = prop.getProperty("insertStudynoteSet2");
		StudyNoteSet snSet = null;
		List<StudyNoteSet> snslist = new ArrayList<StudyNoteSet>();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, noteNumber);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				snSet = new StudyNoteSet(rset.getInt("SET_NO"), rset.getString("SET_WORD"), rset.getString("SET_MEAN"), rset.getInt("STUDYNOTE_NO"));
				snslist.add(snSet);
			}
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return snslist;
	}

	public int  changeDetail(Connection conn, int rownum, int studynotenm) throws Exception{

		PreparedStatement pstmt = null;
		String query = prop.getProperty("changeDetail");
		ResultSet rset = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, studynotenm);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(rownum == rset.getInt("ROWNUM")) {
					rownum = rset.getInt("SET_NO");
				}
			}
		}
		finally {
			close(rset);
			close(pstmt);
		}

		return rownum;
	}

	public int deleteDetail(Connection conn, int changedrownum, int studynotenm) throws Exception{
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteDetail");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, changedrownum);

			result=pstmt.executeUpdate();


		}
		finally {
			close(pstmt);
		}
		return result;
	}

	public int updateStudyNoteSetWord(Connection conn, String word, int changedrownum) throws Exception{


		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateStudyNoteSetWord");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, word);
			pstmt.setInt(2, changedrownum);
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}


		return result;
	}

	public int updateStudyNoteSetMean(Connection conn, String mean, int changedrownum) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateStudyNoteSetMean");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mean);
			pstmt.setInt(2, changedrownum);
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public int selectMemberNo(Connection conn, int noteNumber) throws Exception{

		PreparedStatement pstmt = null;
		int writer = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberNo");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noteNumber);
			rset=pstmt.executeQuery();
			if(rset.next()) {writer = rset.getInt("STUDYNOTE_WRITER");
			}
		}
		finally {
			close(rset);
			close(pstmt);

		}
		return writer;
	}

	public String selectWriter(Connection conn, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String writer="";
		String query = prop.getProperty("selectWriter");
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				writer = rset.getString(1);
			}

		}
		finally {
			close(rset);
			close(pstmt);
		}


		return writer;
	}

	public int followDelete(Connection conn, int follower, int following) throws Exception{

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("followDelete");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, following);
			pstmt.setInt(2, follower);
			result=pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public List<StudyNote> searchStudyNote2(Connection conn, String condition) throws Exception{

		Statement stmt = null;
		ResultSet rset = null;
		List<StudyNote> list = null;
		String query1 =prop.getProperty("searchNotice1"); 
		String query2 =prop.getProperty("searchNotice2"); 

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query1 + condition + query2);

			list = new ArrayList<StudyNote>();

			StudyNote studyNote = null;

			while(rset.next()) {
				studyNote = new StudyNote(rset.getInt("STUDYNOTE_NO"), rset.getString("STUDYNOTE_TITLE"), 
						rset.getDate("STUDYNOTE_CREATE_DT"), rset.getDate("STUDYNOTE_MODIFY_DT"), rset.getString("MEMBER_NO"), 
						rset.getString("CATEGORY_NM"));
				list.add(studyNote);
			}
		}finally {
			close(rset);
			close(stmt);
		}

		return list;


	}

	public int updateStudyNote(Connection conn, String title, int category, int sNnum) throws Exception{

		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateStudyNote");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setInt(2, category);
			pstmt.setInt(3, sNnum);
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}

		return result;
	}

	public int addStatus(Connection conn, int noteNumber, int memberNo) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("addStatus");
		int Status =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noteNumber);
			pstmt.setInt(2, memberNo);
			rset=pstmt.executeQuery();

			if(rset.next()) {
				Status=1;
			}
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return Status;
	}

	public int[] addNoteNm(Connection conn, int memberNo, int count) throws Exception{

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("addNoteNm");
		int [] addNoteNm = new int[count] ;
		int i = 0;
		Statement stmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				addNoteNm[i]=rset.getInt("STUDYNOTE_NO");

				i++;
			}

		}finally {
			close(rset);
			close(pstmt);
		}


		return addNoteNm;
	}

	public StudyNote selectTakenStudyNote(Connection conn, int i)throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectTakenStudyNote");
		StudyNote sno = null;
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, i);
			rset=pstmt.executeQuery();

			if(rset.next()) {

				sno = new StudyNote(rset.getInt("STUDYNOTE_NO"), 
						rset.getString("STUDYNOTE_TITLE"), rset.getDate("STUDYNOTE_MODIFY_DT"),rset.getString("STUDYNOTE_STATUS").charAt(0),
						rset.getString("MEMBER_ID"),rset.getString("CATEGORY_NM"));}
		}
		finally {
			close(rset);
			close(pstmt);
		}
		return sno;
	}

	public int countNoteNm(Connection conn, int memberNo) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("countNoteNm");
		int result= 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,memberNo);
			rset=pstmt.executeQuery();

			if(rset.next()) {
				result=rset.getInt(1);
			}

		}
		finally {
			close(rset);
			close(pstmt);

		}
		return result;
	}



}
