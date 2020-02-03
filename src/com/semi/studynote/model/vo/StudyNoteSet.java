package com.semi.studynote.model.vo;

public class StudyNoteSet {

	private int setNo;
	private String setWord;
	private String setMean;
	private int studyNoteNo;
	
	public StudyNoteSet() {
		// TODO Auto-generated constructor stub
	}

	public int getSetNo() {
		return setNo;
	}

	public void setSetNo(int setNo) {
		this.setNo = setNo;
	}

	public String getSetWord() {
		return setWord;
	}

	public void setSetWord(String setWord) {
		this.setWord = setWord;
	}

	public String getSetMean() {
		return setMean;
	}

	public void setSetMean(String setMean) {
		this.setMean = setMean;
	}

	public int getStudyNoteNo() {
		return studyNoteNo;
	}

	public void setStudyNoteNo(int studyNoteNo) {
		this.studyNoteNo = studyNoteNo;
	}

	public StudyNoteSet(int setNo, String setWord, String setMean, int studyNoteNo) {
		super();
		this.setNo = setNo;
		this.setWord = setWord;
		this.setMean = setMean;
		this.studyNoteNo = studyNoteNo;
	}

	@Override
	public String toString() {
		return "StudyNoteSet [setNo=" + setNo + ", setWord=" + setWord + ", setMean=" + setMean + ", studyNoteNo="
				+ studyNoteNo + "]";
	}
	
	
}
