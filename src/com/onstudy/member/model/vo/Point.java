package com.onstudy.member.model.vo;

import java.sql.Date;

public class Point {
	private int pointNo;
	private int point;
	private char pointStatus;
	private Date pointUpdateDt;
	private int memberNo;
	private String memberName;
	private int pointDetailCd;
	private String pointDetailNm;
	
	public Point() {
		// TODO Auto-generated constructor stub
	}
	
	public Point(int point, char pointStatus, int memberNo, int pointDetailCd) {
		super();
		this.point = point;
		this.pointStatus = pointStatus;
		this.memberNo = memberNo;
		this.pointDetailCd = pointDetailCd;
	}
	
	public Point(int point, char pointStatus, Date pointUpdateDt, String memberName, String pointDetailNm) {
		super();
		this.point = point;
		this.pointStatus = pointStatus;
		this.pointUpdateDt = pointUpdateDt;
		this.memberName = memberName;
		this.pointDetailNm = pointDetailNm;
	}

	public Point(int pointNo, int point, char pointStatus, Date pointUpdateDt, int memberNo, int pointDetailCd) {
		super();
		this.pointNo = pointNo;
		this.point = point;
		this.pointStatus = pointStatus;
		this.pointUpdateDt = pointUpdateDt;
		this.memberNo = memberNo;
		this.pointDetailCd = pointDetailCd;
	}
	
	public Point(int pointNo, int point, char pointStatus, Date pointUpdateDt, int memberNo, String memberName,
			int pointDetailCd, String pointDetailNm) {
		super();
		this.pointNo = pointNo;
		this.point = point;
		this.pointStatus = pointStatus;
		this.pointUpdateDt = pointUpdateDt;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.pointDetailCd = pointDetailCd;
		this.pointDetailNm = pointDetailNm;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPointDetailNm() {
		return pointDetailNm;
	}

	public void setPointDetailNm(String pointDetailNm) {
		this.pointDetailNm = pointDetailNm;
	}


	public int getPointNo() {
		return pointNo;
	}

	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public char getPointStatus() {
		return pointStatus;
	}

	public void setPointStatus(char pointStatus) {
		this.pointStatus = pointStatus;
	}

	public Date getPointUpdateDt() {
		return pointUpdateDt;
	}

	public void setPointUpdateDt(Date pointUpdateDt) {
		this.pointUpdateDt = pointUpdateDt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getPointDetailCd() {
		return pointDetailCd;
	}

	public void setPointDetailCd(int pointDetailCd) {
		this.pointDetailCd = pointDetailCd;
	}

	@Override
	public String toString() {
		return "Point [pointNo=" + pointNo + ", point=" + point + ", pointStatus=" + pointStatus + ", pointUpdateDt="
				+ pointUpdateDt + ", memberNo=" + memberNo + ", memberName=" + memberName + ", pointDetailCd="
				+ pointDetailCd + ", pointDetailNm=" + pointDetailNm + "]";
	}
	
	
}
