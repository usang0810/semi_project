package com.semi.studynote.model.vo;

import java.sql.Date;

public class StudyNote {
    private int studyNoteNo;
	private String studyNoteTitle;
	private Date studyNoteCreateDate;
	private Date studyNoteModifyDate;
	private char studyNoteStatus;
	private String memberId;
	private String categoryNM;
	
	public StudyNote() {
		// TODO Auto-generated constructor stub
	}
	
	public StudyNote(int studyNoteNo, String studyNoteTitle, Date studyNoteCreateDate, Date studyNoteModifyDate,
			char studyNoteStatus, String memberId, String categoryNM) {
		super();
		this.studyNoteNo = studyNoteNo;
		this.studyNoteTitle = studyNoteTitle;
		this.studyNoteCreateDate = studyNoteCreateDate;
		this.studyNoteModifyDate = studyNoteModifyDate;
		this.studyNoteStatus = studyNoteStatus;
		this.memberId = memberId;
		this.categoryNM = categoryNM;
	}

	public int getStudyNoteNo() {
		return studyNoteNo;
	}

	public void setStudyNoteNo(int studyNoteNo) {
		this.studyNoteNo = studyNoteNo;
	}

	public String getStudyNoteTitle() {
		return studyNoteTitle;
	}

	public void setStudyNoteTitle(String studyNoteTitle) {
		this.studyNoteTitle = studyNoteTitle;
	}

	public Date getStudyNoteCreateDate() {
		return studyNoteCreateDate;
	}

	public void setStudyNoteCreateDate(Date studyNoteCreateDate) {
		this.studyNoteCreateDate = studyNoteCreateDate;
	}

	public Date getStudyNoteModifyDate() {
		return studyNoteModifyDate;
	}

	public void setStudyNoteModifyDate(Date studyNoteModifyDate) {
		this.studyNoteModifyDate = studyNoteModifyDate;
	}

	public char getStudyNoteStatus() {
		return studyNoteStatus;
	}

	public void setStudyNoteStatus(char studyNoteStatus) {
		this.studyNoteStatus = studyNoteStatus;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCategoryNM() {
		return categoryNM;
	}

	public void setCategoryNM(String categoryNM) {
		this.categoryNM = categoryNM;
	}

	@Override
	public String toString() {
		return "StudyNote [studyNoteNo=" + studyNoteNo + ", studyNoteTitle=" + studyNoteTitle + ", studyNoteCreateDate="
				+ studyNoteCreateDate + ", studyNoteModifyDate=" + studyNoteModifyDate + ", studyNoteStatus="
				+ studyNoteStatus + ", memberId=" + memberId + ", categoryNM=" + categoryNM + "]";
	}
	
	
}
