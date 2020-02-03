package com.semi.cardTest.model.vo;

import java.sql.Date;

public class recordTestResult {
	
	private int studyNoteTester;
	private int studyNoteNo;
	private String correctStatus;
	private int wholeQ;
	private int rightQ;
	private Date testDT;
	
	public recordTestResult() {
	}

	public recordTestResult(int studyNoteTester, int studyNoteNo, String correctStatus, int wholeQ, int rightQ,
			Date testDT) {
		super();
		this.studyNoteTester = studyNoteTester;
		this.studyNoteNo = studyNoteNo;
		this.correctStatus = correctStatus;
		this.wholeQ = wholeQ;
		this.rightQ = rightQ;
		this.testDT = testDT;
	}

	public int getStudyNoteTester() {
		return studyNoteTester;
	}

	public void setStudyNoteTester(int studyNoteTester) {
		this.studyNoteTester = studyNoteTester;
	}

	public int getStudyNoteNo() {
		return studyNoteNo;
	}

	public void setStudyNoteNo(int studyNoteNo) {
		this.studyNoteNo = studyNoteNo;
	}

	public String getCorrectStatus() {
		return correctStatus;
	}

	public void setCorrectStatus(String correctStatus) {
		this.correctStatus = correctStatus;
	}

	public int getWholeQ() {
		return wholeQ;
	}

	public void setWholeQ(int wholeQ) {
		this.wholeQ = wholeQ;
	}

	public int getRightQ() {
		return rightQ;
	}

	public void setRightQ(int rightQ) {
		this.rightQ = rightQ;
	}

	public Date getTestDT() {
		return testDT;
	}

	public void setTestDT(Date testDT) {
		this.testDT = testDT;
	}

	@Override
	public String toString() {
		return "recordTestResult [studyNoteTester=" + studyNoteTester + ", studyNoteNo=" + studyNoteNo
				+ ", correctStatus=" + correctStatus + ", wholeQ=" + wholeQ + ", rightQ=" + rightQ + ", testDT="
				+ testDT + "]";
	}
	
	

}
