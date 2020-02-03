package com.semi.board.model.vo;

public class MemberDeclar {
	private int boardNo;
	private char declarStatus;
	private int declarMember;
	
	public MemberDeclar() {}
	
	public MemberDeclar(int boardNo, char declarStatus, int declarMember) {
		super();
		this.boardNo = boardNo;
		this.declarStatus = declarStatus;
		this.declarMember = declarMember;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public char getDeclarStatus() {
		return declarStatus;
	}

	public void setDeclarStatus(char declarStatus) {
		this.declarStatus = declarStatus;
	}

	public int getDeclarMember() {
		return declarMember;
	}

	public void setDeclarMember(int declarMember) {
		this.declarMember = declarMember;
	}

	@Override
	public String toString() {
		return "MemberDeclar [boardNo=" + boardNo + ", declarStatus=" + declarStatus + ", declarMember=" + declarMember
				+ "]";
	}
	
	
}
