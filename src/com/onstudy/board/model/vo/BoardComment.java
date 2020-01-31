package com.onstudy.board.model.vo;

import java.sql.Timestamp;

public class BoardComment {
	private int commentNo;
	private String commentContent;
	private Timestamp commentCreateDt;
	private Timestamp commentModifyDt;
	private int boardNo;
	private int boardCommentWriter;
	private String memberId;
	
	public BoardComment() {}

	public BoardComment(int commentNo, String commentContent, Timestamp commentModifyDt, int boardNo, String memberId) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentModifyDt = commentModifyDt;
		this.boardNo = boardNo;
		this.memberId = memberId;
	}

	public BoardComment(String commentContent, int boardCommentWriter) {
		super();
		this.commentContent = commentContent;
		this.boardCommentWriter = boardCommentWriter;
	}

	public BoardComment(int commentNo, String commentContent, Timestamp commentCreateDt, Timestamp commentModifyDt,
			int boardNo, int boardCommentWriter, String memberId) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentCreateDt = commentCreateDt;
		this.commentModifyDt = commentModifyDt;
		this.boardNo = boardNo;
		this.boardCommentWriter = boardCommentWriter;
		this.memberId = memberId;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCommentCreateDt() {
		return commentCreateDt;
	}

	public void setCommentCreateDt(Timestamp commentCreateDt) {
		this.commentCreateDt = commentCreateDt;
	}

	public Timestamp getCommentModifyDt() {
		return commentModifyDt;
	}

	public void setCommentModifyDt(Timestamp commentModifyDt) {
		this.commentModifyDt = commentModifyDt;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardCommentWriter() {
		return boardCommentWriter;
	}

	public void setBoardCommentWriter(int boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "BoardComment [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentCreateDt="
				+ commentCreateDt + ", commentModifyDt=" + commentModifyDt + ", boardNo=" + boardNo
				+ ", boardCommentWriter=" + boardCommentWriter + ", memberId=" + memberId + "]";
	}
	
	
}
