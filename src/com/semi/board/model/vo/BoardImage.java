package com.semi.board.model.vo;

import java.sql.Date;

public class BoardImage {
	private int imageNo;
	private String imagePath;
	private Date uploadDt;
	private char imageStatus;
	private int boardNo;
	private String imageOriginName;
	private String imageChangeName;
	
	public BoardImage() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardImage(String imagePath, String imageOriginName, String imageChangeName) {
		super();
		this.imagePath = imagePath;
		this.imageOriginName = imageOriginName;
		this.imageChangeName = imageChangeName;
	}

	public BoardImage(int imageNo, String imagePath, Date uploadDt, char imageStatus, int boardNo,
			String imageOriginName, String imageChangeName) {
		super();
		this.imageNo = imageNo;
		this.imagePath = imagePath;
		this.uploadDt = uploadDt;
		this.imageStatus = imageStatus;
		this.boardNo = boardNo;
		this.imageOriginName = imageOriginName;
		this.imageChangeName = imageChangeName;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getUploadDt() {
		return uploadDt;
	}

	public void setUploadDt(Date uploadDt) {
		this.uploadDt = uploadDt;
	}

	public char getImageStatus() {
		return imageStatus;
	}

	public void setImageStatus(char imageStatus) {
		this.imageStatus = imageStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getImageOriginName() {
		return imageOriginName;
	}

	public void setImageOriginName(String imageOriginName) {
		this.imageOriginName = imageOriginName;
	}

	public String getImageChangeName() {
		return imageChangeName;
	}

	public void setImageChangeName(String imageChangeName) {
		this.imageChangeName = imageChangeName;
	}

	@Override
	public String toString() {
		return "BoardImage [imageNo=" + imageNo + ", imagePath=" + imagePath + ", uploadDt=" + uploadDt
				+ ", imageStatus=" + imageStatus + ", boardNo=" + boardNo + ", imageOriginName=" + imageOriginName
				+ ", imageChangeName=" + imageChangeName + "]";
	}

	
}
