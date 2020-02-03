package com.semi.studynote.model.vo;

import java.sql.Date;

public class LikeDetail {

	private int memberNo;
	private Date studyNoteNo;
	private Date likeDt;
	
	public LikeDetail() {

	}
	
	public LikeDetail(int memberNo, Date studyNoteNo, Date likeDt) {
		super();
		this.memberNo = memberNo;
		this.studyNoteNo = studyNoteNo;
		this.likeDt = likeDt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getStudyNoteNo() {
		return studyNoteNo;
	}

	public void setStudyNoteNo(Date studyNoteNo) {
		this.studyNoteNo = studyNoteNo;
	}

	public Date getLikeDt() {
		return likeDt;
	}

	public void setLikeDt(Date likeDt) {
		this.likeDt = likeDt;
	}

	@Override
	public String toString() {
		return "LikeDetail [memberNo=" + memberNo + ", studyNoteNo=" + studyNoteNo + ", likeDt=" + likeDt + "]";
	}
	
	
	
	
}
