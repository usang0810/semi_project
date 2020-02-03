package com.semi.onstudy.model.vo;

import java.sql.Date;

public class CertifyBoardTotal {

	private int onstudyNo;
	private String onstudyTitle;
	private String categoryNm;
	private String imagePath;
	private Date startDt;
	private Date endDt;
	private int onstudyCertifyCount;
	private int onstudyFee;
	private int onstudyWeeks;
	private int memberCount;
	private int todayNWeek;
	private int todayCertifyCount;
	private int weekCertifyCount;
	private int totalCertifyCount;
	
	public CertifyBoardTotal() {}

	public CertifyBoardTotal(int onstudyNo, String onstudyTitle, String categoryNm, String imagePath, Date startDt,
			Date endDt, int onstudyCertifyCount, int onstudyFee, int onstudyWeeks, int memberCount, int todayNWeek,
			int todayCertifyCount, int weekCertifyCount, int totalCertifyCount) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.categoryNm = categoryNm;
		this.imagePath = imagePath;
		this.startDt = startDt;
		this.endDt = endDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.memberCount = memberCount;
		this.todayNWeek = todayNWeek;
		this.todayCertifyCount = todayCertifyCount;
		this.weekCertifyCount = weekCertifyCount;
		this.totalCertifyCount = totalCertifyCount;
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

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
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

	public int getOnstudyWeeks() {
		return onstudyWeeks;
	}

	public void setOnstudyWeeks(int onstudyWeeks) {
		this.onstudyWeeks = onstudyWeeks;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getTodayNWeek() {
		return todayNWeek;
	}

	public void setTodayNWeek(int todayNWeek) {
		this.todayNWeek = todayNWeek;
	}

	public int getTodayCertifyCount() {
		return todayCertifyCount;
	}

	public void setTodayCertifyCount(int todayCertifyCount) {
		this.todayCertifyCount = todayCertifyCount;
	}

	public int getWeekCertifyCount() {
		return weekCertifyCount;
	}

	public void setWeekCertifyCount(int weekCertifyCount) {
		this.weekCertifyCount = weekCertifyCount;
	}

	public int getTotalCertifyCount() {
		return totalCertifyCount;
	}

	public void setTotalCertifyCount(int totalCertifyCount) {
		this.totalCertifyCount = totalCertifyCount;
	}

	@Override
	public String toString() {
		return "CertifyBoardTotal [onstudyNo=" + onstudyNo + ", onstudyTitle=" + onstudyTitle + ", categoryNm="
				+ categoryNm + ", imagePath=" + imagePath + ", startDt=" + startDt + ", endDt=" + endDt
				+ ", onstudyCertifyCount=" + onstudyCertifyCount + ", onstudyFee=" + onstudyFee + ", onstudyWeeks="
				+ onstudyWeeks + ", memberCount=" + memberCount + ", todayNWeek=" + todayNWeek + ", todayCertifyCount="
				+ todayCertifyCount + ", weekCertifyCount=" + weekCertifyCount + ", totalCertifyCount="
				+ totalCertifyCount + "]";
	}

	
}
