package com.semi.onstudy.model.vo;

public class Thumbnail {

	private int imageNo;
	private String changeName;
	private int onstudyNo;
	
	public Thumbnail() {}

	public Thumbnail(String changeName) {
		super();
		this.changeName = changeName;
	}

	public Thumbnail(int imageNo, String changeName, int onstudyNo) {
		super();
		this.imageNo = imageNo;
		this.changeName = changeName;
		this.onstudyNo = onstudyNo;
	}

	public int getImageNo() {
		return imageNo;
	}

	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	

	public int getOnstudyNo() {
		return onstudyNo;
	}

	public void setOnstudyNo(int onstudyNo) {
		this.onstudyNo = onstudyNo;
	}

	@Override
	public String toString() {
		return "Thumbnail [imageNo=" + imageNo + ", changeName=" + changeName + ", onstudyNo="
				+ onstudyNo + "]";
	}

}
