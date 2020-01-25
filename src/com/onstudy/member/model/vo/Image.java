package com.onstudy.member.model.vo;

import java.sql.Date;

public class Image {
	private int imageNo;
	private String imagePath;
	private Date uploadDt;
	private char imageStatus;
	private int memberNo;
	
	public Image() {
		// TODO Auto-generated constructor stub
	}

	public Image(int imageNo, String imagePath, Date uploadDt, char imageStatus, int memberNo) {
		super();
		this.imageNo = imageNo;
		this.imagePath = imagePath;
		this.uploadDt = uploadDt;
		this.imageStatus = imageStatus;
		this.memberNo = memberNo;
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Image [imageNo=" + imageNo + ", imagePath=" + imagePath + ", uploadDt=" + uploadDt + ", imageStatus="
				+ imageStatus + ", memberNo=" + memberNo + "]";
	}
	
}
