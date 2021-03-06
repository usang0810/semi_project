package com.semi.board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNumbering;
	private int boardNo;
	private String boardType;
	private String boardTitle;
	private String boardContent;
	private Date boardCreateDt;
	private Date boardModifyDt;
	private char boardStatus;
	private int boardCount;
	private String boardWriter;
	private String declarStatus;
	private char secretStatus;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNo, String boardTitle, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public Board(int boardNo, String boardTitle, String boardContent, String boardType, char secretStatus) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.secretStatus = secretStatus;
	}

	public Board(String boardTitle, String boardContent, String boardType) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardType = boardType;
	}

	public Board(int boardNumbering, String boardType, String boardTitle, String boardContent, Date boardModifyDt,
			int boardCount, String boardWriter) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardModifyDt = boardModifyDt;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
	}

	public Board(String boardType, String boardTitle, String boardContent, String boardWriter) {
		super();
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
	}

	public Board(String boardTitle, String boardContent) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public Board(int boardNumbering, int boardNo, String boardType, String boardTitle, String boardContent,
			Date boardCreateDt, Date boardModifyDt, char boardStatus, int boardCount, String boardWriter) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDt = boardCreateDt;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
	}
	

	public Board(int boardNo, String boardType, String boardTitle, String boardContent, Date boardModifyDt,
			char boardStatus, int boardCount, String boardWriter) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
	}

	public Board(int boardNumbering, int boardNo,  String boardType, String boardTitle, String boardContent,
			Date boardModifyDt, String boardWriter, char secretStatus) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardModifyDt = boardModifyDt;
		this.boardWriter = boardWriter;
		this.secretStatus = secretStatus;
	}
	
	public Board(int boardNumbering, int boardNo, String boardTitle, String boardContent, Date boardModifyDt,
			char boardStatus, String boardWriter) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardWriter = boardWriter;
	}
	
	public Board(int boardNumbering, int boardNo, String boardTitle, Date boardModifyDt, char boardStatus,
			String boardWriter, String declarStatus) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardWriter = boardWriter;
		this.declarStatus = declarStatus;
	}
	
	public Board(int boardNo, String boardType, String boardTitle, String boardContent, Date boardModifyDt,
			char boardStatus, int boardCount, String boardWriter, String declarStatus) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
		this.declarStatus = declarStatus;
	}

	public Board(int boardNumbering, int boardNo, String boardType, String boardTitle, String boardContent,
			Date boardCreateDt, Date boardModifyDt, char boardStatus, int boardCount, String boardWriter,
			String declarStatus) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDt = boardCreateDt;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
		this.declarStatus = declarStatus;
	}
	
	public Board(int boardNumbering, int boardNo, String boardType, String boardTitle, String boardContent,
			Date boardCreateDt, Date boardModifyDt, char boardStatus, int boardCount, String boardWriter,
			String declarStatus, char secretStatus) {
		super();
		this.boardNumbering = boardNumbering;
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCreateDt = boardCreateDt;
		this.boardModifyDt = boardModifyDt;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
		this.declarStatus = declarStatus;
		this.secretStatus = secretStatus;
	}

	public char getSecretStatus() {
		return secretStatus;
	}

	public void setSecretStatus(char secretStatus) {
		this.secretStatus = secretStatus;
	}

	public String getDeclarStatus() {
		return declarStatus;
	}

	public void setDeclarStatus(String declarStatus) {
		this.declarStatus = declarStatus;
	}

	public int getBoardNumbering() {
		return boardNumbering;
	}

	public void setBoardNumbering(int boardNumbering) {
		this.boardNumbering = boardNumbering;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
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

	public char getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(char boardStatus) {
		this.boardStatus = boardStatus;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "Board [boardNumbering=" + boardNumbering + ", boardNo=" + boardNo + ", boardType=" + boardType
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardCreateDt=" + boardCreateDt
				+ ", boardModifyDt=" + boardModifyDt + ", boardStatus=" + boardStatus + ", boardCount=" + boardCount
				+ ", boardWriter=" + boardWriter + ", declarStatus=" + declarStatus + ", secretStatus=" + secretStatus
				+ "]";
	}
	
	


}