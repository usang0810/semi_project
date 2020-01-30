package com.onstudy.onstudy.model.vo;

import java.sql.Date;

public class Onstudy {
	private int onstudyNo;
	private String onstudyTitle;
	private Date onstudyCreateDt;
	private Date onstudyStartDt;
	private Date onstudyEndDt;
	private int onstudyWeeks;
	private int onstudyCertifyCount;
	private int onstudyFee;
	private String onstudyAddComment;
	private String onstudyStatus;
	private int memberNo;
	private String categoryNm;
	private int categoryCd;
	private String thumbnailPath;

	public Onstudy() {
		// TODO Auto-generated constructor stub
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyCreateDt, Date onstudyStartDt, Date onstudyEndDt,
			int onstudyWeeks, int onstudyCertifyCount, int onstudyFee, String onstudyAddComment, String onstudyStatus,
			int memberNo, String categoryNm, int categoryCd, String thumbnailPath) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyCreateDt = onstudyCreateDt;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.onstudyStatus = onstudyStatus;
		this.memberNo = memberNo;
		this.categoryNm = categoryNm;
		this.categoryCd = categoryCd;
		this.thumbnailPath = thumbnailPath;
	}

	public int getOnstudyNo() {
		return onstudyNo;
	}

	public void setOnstudyNo(int onstudyNo) {
		this.onstudyNo = onstudyNo;
	}

	public String getOnstudyTitle() {
		return onstudyTitle;
	}

	public void setOnstudyTitle(String onstudyTitle) {
		this.onstudyTitle = onstudyTitle;
	}

	public Date getOnstudyCreateDt() {
		return onstudyCreateDt;
	}

	public void setOnstudyCreateDt(Date onstudyCreateDt) {
		this.onstudyCreateDt = onstudyCreateDt;
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

	public int getOnstudyWeeks() {
		return onstudyWeeks;
	}

	public void setOnstudyWeeks(int onstudyWeeks) {
		this.onstudyWeeks = onstudyWeeks;
	}

	public int getOnstudyCertifyCount() {
		return onstudyCertifyCount;
	}

	public void setOnstudyCertifyCount(int onstudyCertifyCount) {
		this.onstudyCertifyCount = onstudyCertifyCount;
	}

	public int getOnstudyFee() {
		return onstudyFee;
	}

	public void setOnstudyFee(int onstudyFee) {
		this.onstudyFee = onstudyFee;
	}

	public String getOnstudyAddComment() {
		return onstudyAddComment;
	}

	public void setOnstudyAddComment(String onstudyAddComment) {
		this.onstudyAddComment = onstudyAddComment;
	}

	public String getOnstudyStatus() {
		return onstudyStatus;
	}

	public void setOnstudyStatus(String onstudyStatus) {
		this.onstudyStatus = onstudyStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public int getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(int categoryCd) {
		this.categoryCd = categoryCd;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	@Override
	public String toString() {
		return "Onstudy [onstudyNo=" + onstudyNo + ", onstudyTitle=" + onstudyTitle + ", onstudyCreateDt="
				+ onstudyCreateDt + ", onstudyStartDt=" + onstudyStartDt + ", onstudyEndDt=" + onstudyEndDt
				+ ", onstudyWeeks=" + onstudyWeeks + ", onstudyCertifyCount=" + onstudyCertifyCount + ", onstudyFee="
				+ onstudyFee + ", onstudyAddComment=" + onstudyAddComment + ", onstudyStatus=" + onstudyStatus
				+ ", memberNo=" + memberNo + ", categoryNm=" + categoryNm + ", categoryCd=" + categoryCd
				+ ", thumbnailPath=" + thumbnailPath + "]";
	}

}
