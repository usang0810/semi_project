package com.semi.member.model.vo;

import java.sql.Date;

public class MyOnstudy {
	
	private int rowNum;
	private int memberNo;
	private int onstudyNo;
	private double refundD;
	private String onstudyTitle;
	private Date onstudyStartDt;
	private Date onstudyEndDt;
	private int closeCheck;
	private int myCertifyCount;
	private int onstudyCertifyCount;
	private int onstudyWeeks;
	private int onstudyFee;
	private String categoryNm;
	private String imageName;
	
	public MyOnstudy() {}

	public MyOnstudy(int memberNo, int onstudyNo, double refundD, String onstudyTitle, Date onstudyStartDt,
			Date onstudyEndDt, int closeCheck, int myCertifyCount, int onstudyCertifyCount, int onstudyWeeks, int onstudyFee,
			String categoryNm, String imageName) {
		super();
		this.memberNo = memberNo;
		this.onstudyNo = onstudyNo;
		this.refundD = refundD;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.closeCheck = closeCheck;
		this.myCertifyCount = myCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
		this.imageName = imageName;
	}

	public MyOnstudy(int rowNum, int memberNo, int onstudyNo, double refundD, String onstudyTitle, Date onstudyStartDt,
			Date onstudyEndDt, int myCertifyCount, int onstudyCertifyCount, int onstudyWeeks, int onstudyFee,
			String categoryNm, String imageName) {
		super();
		this.rowNum = rowNum;
		this.memberNo = memberNo;
		this.onstudyNo = onstudyNo;
		this.refundD = refundD;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.myCertifyCount = myCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
		this.imageName = imageName;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getOnstudyNo() {
		return onstudyNo;
	}

	public void setOnstudyNo(int onstudyNo) {
		this.onstudyNo = onstudyNo;
	}

	public double getRefundD() {
		return refundD;
	}

	public void setRefundD(double refundD) {
		this.refundD = refundD;
	}

	public String getOnstudyTitle() {
		return onstudyTitle;
	}

	public void setOnstudyTitle(String onstudyTitle) {
		this.onstudyTitle = onstudyTitle;
	}

	public Date getOnstudyStartDt() {
		return onstudyStartDt;
	}

	public void setOnstudyStartDt(Date onstudyStartDt) {
		this.onstudyStartDt = onstudyStartDt;
	}

	public Date getOnstudyEndDt() {
		return onstudyEndDt;
	}

	public void setOnstudyEndDt(Date onstudyEndDt) {
		this.onstudyEndDt = onstudyEndDt;
	}
	
	public int getCloseCheck() {
		return closeCheck;
	}

	public void setCloseCheck(int closeCheck) {
		this.closeCheck = closeCheck;
	}

	public int getMyCertifyCount() {
		return myCertifyCount;
	}

	public void setMyCertifyCount(int myCertifyCount) {
		this.myCertifyCount = myCertifyCount;
	}

	public int getOnstudyCertifyCount() {
		return onstudyCertifyCount;
	}

	public void setOnstudyCertifyCount(int onstudyCertifyCount) {
		this.onstudyCertifyCount = onstudyCertifyCount;
	}

	public int getOnstudyWeeks() {
		return onstudyWeeks;
	}

	public void setOnstudyWeeks(int onstudyWeeks) {
		this.onstudyWeeks = onstudyWeeks;
	}

	public int getOnstudyFee() {
		return onstudyFee;
	}

	public void setOnstudyFee(int onstudyFee) {
		this.onstudyFee = onstudyFee;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "MyOnstudy [rowNum=" + rowNum + ", memberNo=" + memberNo + ", onstudyNo=" + onstudyNo + ", refundD="
				+ refundD + ", onstudyTitle=" + onstudyTitle + ", onstudyStartDt=" + onstudyStartDt + ", onstudyEndDt="
				+ onstudyEndDt + ", myCertifyCount=" + myCertifyCount + ", onstudyCertifyCount=" + onstudyCertifyCount
				+ ", onstudyWeeks=" + onstudyWeeks + ", onstudyFee=" + onstudyFee + ", categoryNm=" + categoryNm
				+ ", imageName=" + imageName + "]";
	}
	
}
