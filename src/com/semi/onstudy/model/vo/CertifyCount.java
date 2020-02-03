package com.semi.onstudy.model.vo;

public class CertifyCount {

	private int onstudyNo;
	private int onstudyBoardWriter;
	private int todayCertifyCount;
	private int nWeek;
	private int weekCertifyCount;
	private int onstudyCertifyCount;
	private int onstudyWeeks;

	public CertifyCount() {
		super();
	}

	public CertifyCount(int onstudyNo, int onstudyBoardWriter, int nWeek) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyBoardWriter = onstudyBoardWriter;
		this.nWeek = nWeek;
	}

	public CertifyCount(int onstudyNo, int onstudyBoardWriter, int nWeek, int weekCertifyCount,
	         int onstudyCertifyCount) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyBoardWriter = onstudyBoardWriter;
		this.nWeek = nWeek;
		this.weekCertifyCount = weekCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
	}
   
	public CertifyCount(int onstudyNo, int onstudyBoardWriter, int nWeek, int weekCertifyCount, int onstudyCertifyCount,
	         int onstudyWeeks) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyBoardWriter = onstudyBoardWriter;
		this.nWeek = nWeek;
		this.weekCertifyCount = weekCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyWeeks = onstudyWeeks;
	}
   
	public CertifyCount(int onstudyNo, int weekCertifyCount, int onstudyCertifyCount, int onstudyWeeks) {
		super();
		this.onstudyNo = onstudyNo;
		this.weekCertifyCount = weekCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyWeeks = onstudyWeeks;
	}

	public CertifyCount(int onstudyNo, int onstudyBoardWriter, int todayCertifyCount, int nWeek, int weekCertifyCount,
	         int onstudyCertifyCount, int onstudyWeeks) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyBoardWriter = onstudyBoardWriter;
		this.todayCertifyCount = todayCertifyCount;
		this.nWeek = nWeek;
		this.weekCertifyCount = weekCertifyCount;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyWeeks = onstudyWeeks;
	}


	public int getOnstudyNo() {
		return onstudyNo;
	}
	
	public void setOnstudyNo(int onstudyNo) {
		this.onstudyNo = onstudyNo;
	}
	
	public int getOnstudyBoardWriter() {
		return onstudyBoardWriter;
	}
	
	public void setOnstudyBoardWriter(int onstudyBoardWriter) {
		this.onstudyBoardWriter = onstudyBoardWriter;
	}
	
	public int getTodayCertifyCount() {
		return todayCertifyCount;
	}
	
	public void setTodayCertifyCount(int todayCertifyCount) {
		this.todayCertifyCount = todayCertifyCount;
	}
	
	public int getnWeek() {
		return nWeek;
	}
	
	public void setnWeek(int nWeek) {
		this.nWeek = nWeek;
	}
	
	public int getWeekCertifyCount() {
		return weekCertifyCount;
	}
	
	public void setWeekCertifyCount(int weekCertifyCount) {
		this.weekCertifyCount = weekCertifyCount;
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

	@Override
	public String toString() {
		return "CertifyCount [onstudyNo=" + onstudyNo + ", onstudyBoardWriter=" + onstudyBoardWriter
				+ ", todayCertifyCount=" + todayCertifyCount + ", nWeek=" + nWeek + ", weekCertifyCount=" + weekCertifyCount
				+ ", onstudyCertifyCount=" + onstudyCertifyCount + ", onstudyWeeks=" + onstudyWeeks + "]";
	}

}