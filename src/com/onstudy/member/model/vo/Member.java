package com.onstudy.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberNm;
	private String memberPhone;
	private char memberGrade;
	private Date memberEnrollDt;
	private int memberPoint;
	private int memberDeclarCount;
	private char memberStatus;
	private String memberAccount;
	private int bankCode;
	private String bankName;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	
	public Member(String memberId, String memberNm, Date memberEnrollDt) {
		super();
		this.memberId = memberId;
		this.memberNm = memberNm;
		this.memberEnrollDt = memberEnrollDt;
	}

	public Member(int memberNo, String memberPwd, String memberPhone, String memberAccount, int bankCode) {
		super();
		this.memberNo = memberNo;
		this.memberPwd = memberPwd;
		this.memberPhone = memberPhone;
		this.memberAccount = memberAccount;
		this.bankCode = bankCode;
	}

	public Member(String memberId, String memberPwd, String memberNm, String memberPhone, String memberAccount,
			int bankCode) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberAccount = memberAccount;
		this.bankCode = bankCode;
	}
	
	public Member(int memberNo, String memberId, String memberNm, String memberPhone, int memberPoint,
			int memberDeclarCount, char memberStatus) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberPoint = memberPoint;
		this.memberDeclarCount = memberDeclarCount;
		this.memberStatus = memberStatus;
	}

	public Member(int memberNo, String memberId, String memberNm, String memberPhone, Date memberEnrollDt,
			int memberPoint, int memberDeclarCount, char memberStatus, String memberAccount, int bankCode) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberEnrollDt = memberEnrollDt;
		this.memberPoint = memberPoint;
		this.memberDeclarCount = memberDeclarCount;
		this.memberStatus = memberStatus;
		this.memberAccount = memberAccount;
		this.bankCode = bankCode;
	}
	
	

	public Member(int memberNo, String memberId, String memberNm, String memberPhone, Date memberEnrollDt,
			int memberPoint, int memberDeclarCount, char memberStatus, String memberAccount, String bankName) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberEnrollDt = memberEnrollDt;
		this.memberPoint = memberPoint;
		this.memberDeclarCount = memberDeclarCount;
		this.memberStatus = memberStatus;
		this.memberAccount = memberAccount;
		this.bankName = bankName;
	}

	public Member(int memberNo, String memberId, String memberPwd, String memberNm, String memberPhone,
			char memberGrade, Date memberEnrollDt, int memberPoint, int memberDeclarCount, char memberStatus,
			String memberAccount, int bankCode) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNm = memberNm;
		this.memberPhone = memberPhone;
		this.memberGrade = memberGrade;
		this.memberEnrollDt = memberEnrollDt;
		this.memberPoint = memberPoint;
		this.memberDeclarCount = memberDeclarCount;
		this.memberStatus = memberStatus;
		this.memberAccount = memberAccount;
		this.bankCode = bankCode;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberNm() {
		return memberNm;
	}

	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public char getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(char memberGrade) {
		this.memberGrade = memberGrade;
	}

	public Date getMemberEnrollDt() {
		return memberEnrollDt;
	}

	public void setMemberEnrollDt(Date memberEnrollDt) {
		this.memberEnrollDt = memberEnrollDt;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public int getMemberDeclarCount() {
		return memberDeclarCount;
	}

	public void setMemberDeclarCount(int memberDeclarCount) {
		this.memberDeclarCount = memberDeclarCount;
	}

	public char getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(char memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNm="
				+ memberNm + ", memberPhone=" + memberPhone + ", memberGrade=" + memberGrade + ", memberEnrollDt="
				+ memberEnrollDt + ", memberPoint=" + memberPoint + ", memberDeclarCount=" + memberDeclarCount
				+ ", memberStatus=" + memberStatus + ", memberAccount=" + memberAccount + ", bankCode=" + bankCode
				+ ", bankName=" + bankName + "]";
	}

}