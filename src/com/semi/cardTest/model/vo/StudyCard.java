package com.semi.cardTest.model.vo;

import java.sql.Date;

public class StudyCard {
	
	private String studyNoteTitle;
	private int cardSetNo;
	private String cardSetWord;
	private String cardSetMean;
	private int studyNoteNo;
	private int studyNoteTester;
	private String correctStatus;
	private Date testDt;
	
	public StudyCard() {
	}
	
	
	public StudyCard(int cardSetNo, int studyNoteNo, int studyNoteTester, String correctStatus, Date testDt) {
		super();
		this.cardSetNo = cardSetNo;
		this.studyNoteNo = studyNoteNo;
		this.studyNoteTester = studyNoteTester;
		this.correctStatus = correctStatus;
		this.testDt = testDt;
	}

	

	public StudyCard(int cardSetNo, String cardSetWord, int studyNoteNo) {
		super();
		this.cardSetNo = cardSetNo;
		this.cardSetWord = cardSetWord;
		this.studyNoteNo = studyNoteNo;
	}


	public StudyCard(int cardSetNo, int studyNoteNo) {
		super();
		this.cardSetNo = cardSetNo;
		this.studyNoteNo = studyNoteNo;
	}


	public StudyCard(String cardSetMean, int studyNoteNo) {
		super();
		this.cardSetMean = cardSetMean;
		this.studyNoteNo = studyNoteNo;
	}

	public StudyCard(int cardSetNo, String cardSetWord, String cardSetMean, int studyNoteNo) {
		super();
		this.cardSetNo = cardSetNo;
		this.cardSetWord = cardSetWord;
		this.cardSetMean = cardSetMean;
		this.studyNoteNo = studyNoteNo;
	}

	public StudyCard(String studyNoteTitle, int cardSetNo, String cardSetWord, String cardSetMean, int studyNoteNo) {
		super();
		this.studyNoteTitle = studyNoteTitle;
		this.cardSetNo = cardSetNo;
		this.cardSetWord = cardSetWord;
		this.cardSetMean = cardSetMean;
		this.studyNoteNo = studyNoteNo;
	}

	public StudyCard(String studyNoteTitle, int cardSetNo, String cardSetWord, String cardSetMean, int studyNoteNo,
			int studyNoteTester, String correctStatus, Date testDt) {
		super();
		this.studyNoteTitle = studyNoteTitle;
		this.cardSetNo = cardSetNo;
		this.cardSetWord = cardSetWord;
		this.cardSetMean = cardSetMean;
		this.studyNoteNo = studyNoteNo;
		this.studyNoteTester = studyNoteTester;
		this.correctStatus = correctStatus;
		this.testDt = testDt;
	}

	public String getStudyNoteTitle() {
		return studyNoteTitle;
	}

	public void setStudyNoteTitle(String studyNoteTitle) {
		this.studyNoteTitle = studyNoteTitle;
	}

	public int getCardSetNo() {
		return cardSetNo;
	}

	public void setCardSetNo(int cardSetNo) {
		this.cardSetNo = cardSetNo;
	}

	public String getCardSetWord() {
		return cardSetWord;
	}

	public void setCardSetWord(String cardSetWord) {
		this.cardSetWord = cardSetWord;
	}

	public String getCardSetMean() {
		return cardSetMean;
	}

	public void setCardSetMean(String cardSetMean) {
		this.cardSetMean = cardSetMean;
	}

	public int getStudyNoteNo() {
		return studyNoteNo;
	}

	public void setStudyNoteNo(int studyNoteNo) {
		this.studyNoteNo = studyNoteNo;
	}

	public int getStudyNoteTester() {
		return studyNoteTester;
	}

	public void setStudyNoteTester(int studyNoteTester) {
		this.studyNoteTester = studyNoteTester;
	}

	public String getCorrectStatus() {
		return correctStatus;
	}

	public void setCorrectStatus(String correctStatus) {
		this.correctStatus = correctStatus;
	}

	public Date getTestDt() {
		return testDt;
	}

	public void setTestDt(Date testDt) {
		this.testDt = testDt;
	}

	@Override
	public String toString() {
		return "StudyCard [studyNoteTitle=" + studyNoteTitle + ", cardSetNo=" + cardSetNo + ", cardSetWord="
				+ cardSetWord + ", cardSetMean=" + cardSetMean + ", studyNoteNo=" + studyNoteNo + ", studyNoteTester="
				+ studyNoteTester + ", correctStatus=" + correctStatus + ", testDt=" + testDt + "]";
	}
	
}

