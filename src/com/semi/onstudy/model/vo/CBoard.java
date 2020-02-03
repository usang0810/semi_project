package com.semi.onstudy.model.vo;

import java.sql.Date;

public class CBoard {
	private int rowNum;
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private Date boardCreateDt;
	private Date boardModifyDt;
	private int boardCount;
	private int onstudyNo;
	private String boardWriterId;
	
	public CBoard() {
	}

	public CBoard(String boardTitle, String boardContent, int onstudyNo) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.onstudyNo = onstudyNo;
	}

	// 게시글 목록 조회에 사용되는 Dao
	public CBoard(int rowNum, int boardNo, String boardTitle, Date boardCreateDt, Date boardModifyDt, int boardCount,
			int onstudyNo, String boardWriterId) {
		super();
		this.rowNum = rowNum;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCreateDt = boardCreateDt;
		this.boardModifyDt = boardModifyDt;
		this.boardCount = boardCount;
		this.onstudyNo = onstudyNo;
		this.boardWriterId = boardWriterId;
	}
	
	// 게시글 상세 조회에 사용되는 Dao 
	public CBoard(int rowNum, int boardNo, String boardTitle, String boardContent, Date boardCreateDt,
			Date boardModifyDt, int boardCount, int onstudyNo, String boardWriterId) {
		super();
		this.rowNum = rowNum;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDt = boardCreateDt;
		this.boardModifyDt = boardModifyDt;
		this.boardCount = boardCount;
		this.onstudyNo = onstudyNo;
		this.boardWriterId = boardWriterId;
	}


	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardCreateDt() {
		return boardCreateDt;
	}

	public void setBoardCreateDt(Date boardCreateDt) {
		this.boardCreateDt = boardCreateDt;
	}

	public Date getBoardModifyDt() {
		return boardModifyDt;
	}

	public void setBoardModifyDt(Date boardModifyDt) {
		this.boardModifyDt = boardModifyDt;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getOnstudyNo() {
		return onstudyNo;
	}

	public void setOnstudyNo(int onstudyNo) {
		this.onstudyNo = onstudyNo;
	}

	public String getBoardWriterId() {
		return boardWriterId;
	}

	public void setBoardWriterId(String boardWriterId) {
		this.boardWriterId = boardWriterId;
	}

	@Override
	public String toString() {
		return "CBoard [rowNum=" + rowNum + ", boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardCreateDt=" + boardCreateDt + ", boardModifyDt=" + boardModifyDt
				+ ", boardCount=" + boardCount + ", onstudyNo=" + onstudyNo + ", boardWriterId=" + boardWriterId + "]";
	}



}
