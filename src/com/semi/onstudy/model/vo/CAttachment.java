package com.semi.onstudy.model.vo;

public class CAttachment {

	private int boardImageNo; // 이미지 번호
	private String changeName; // 이미지 파일 이름
	private int boardNo; // 인증게시글 번호
	
	public CAttachment() {
		super();
	}

	public CAttachment(String changeName) {
		super();
		this.changeName = changeName;
	}

	public CAttachment(int boardImageNo, String changeName, int boardNo) {
		super();
		this.boardImageNo = boardImageNo;
		this.changeName = changeName;
		this.boardNo = boardNo;
	}

	public int getBoardImageNo() {
		return boardImageNo;
	}

	public void setBoardImageNo(int boardImageNo) {
		this.boardImageNo = boardImageNo;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CAttachment [boardImageNo=" + boardImageNo + ", changeName=" + changeName + ", boardNo=" + boardNo
				+ "]";
	}
	
}
