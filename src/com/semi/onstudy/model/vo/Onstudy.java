package com.semi.onstudy.model.vo;

import java.sql.Date;

public class Onstudy {
	private int rnum;
	private int onstudyNo;
	private String onstudyTitle;
	private Date onstudyCreateDt;
	private Date onstudyStartDt;
	private Date onstudyEndDt;
	private int onstudyCertifyCount;
	private int onstudyFee;
	private String onstudyAddComment;
	private String onstudyStatus;
	private int onstudyWeeks;
	private int onstudyWriter;
	private int categoryCd;

	private Date onstudyDeadlineDt;
	private String categoryNm;
	private int memberCount;
	private int onstudyDday;
	private int totalCertifyCount;
	private int sumFee;
	private String thumbnail;
	private int memberNo;
	private int memberCertify;

	private String memberId;
	private String thumbnailPath;
	private int partiMembers;

	public Onstudy() {
		// TODO Auto-generated constructor stub
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyFee,
			String categoryNm, int partiMembers, String onstudyStatus) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
		this.partiMembers = partiMembers;
		this.onstudyStatus = onstudyStatus;
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, String onstudyStatus, String memberId, String categoryNm, int partiMembers, int memberNo) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyStatus = onstudyStatus;
		this.memberId = memberId;
		this.categoryNm = categoryNm;
		this.partiMembers = partiMembers;
		this.memberNo = memberNo;
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

	// 사용하는 생성자임 삭제 ㄴㄴ dao의 insertOnstudy
	public Onstudy(String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyWeeks,
			int onstudyCertifyCount, int onstudyFee, String onstudyAddComment, int memberNo, int categoryCd) {
		super();
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.memberNo = memberNo;
		this.categoryCd = categoryCd;
	}

	// 사용하는 생성자임 삭제 ㄴㄴ dao의 selectOnstudyList
	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyWeeks,
			int onstudyCertifyCount, int onstudyFee, String categoryNm, String thumbnail) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
		this.thumbnail = thumbnail;
	}

	// 사용하는 생성자임 삭제 ㄴㄴ dao의 selectUpdate
	public Onstudy(String onstudyTitle, String thumbnail, Date onstudyStartDt, Date onstudyEndDt, int onstudyWeeks,
			int onstudyCertifyCount, String onstudyAddComment) {
		super();
		this.onstudyTitle = onstudyTitle;
		this.thumbnail = thumbnail;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyAddComment = onstudyAddComment;
	}

	// 사용하는 생성자임 삭제 ㄴㄴ dao의 updateOnstudy
	public Onstudy(int onstudyNo, int onstudyCertifyCount, String onstudyAddComment) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyAddComment = onstudyAddComment;
	}

	// 사용하는 생성자임 삭제 ㄴㄴ dao의 nowJoin
	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyWeeks,
			int onstudyCertifyCount, int onstudyFee, String categoryNm, String thumbnail, int memberCount,
			int todayCertifyCheck) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
		this.thumbnail = thumbnail;
		this.memberCount = memberCount;
	}

	//// 메인 리스트
	public Onstudy(int onstudyNo, String onstudyTitle, int memberCount, Date onstudyStartDt, Date onstudyEndDt,
			Date onstudyDeadlineDt, int onstudyCertifyCount, int onstudyFee, int onstudyWeeks, String categoryNm,
			int onstudyDday, String thumbnail) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.memberCount = memberCount;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.categoryNm = categoryNm;
		this.onstudyDday = onstudyDday;
		this.thumbnail = thumbnail;
	}

	// pList
	public Onstudy(int onstudyNo, String onstudyTitle, int onstudyCertifyCount, Date onstudyDeadlineDt, int memberCount,
			int onstudyDday, int sumFee, String thumbnail) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.memberCount = memberCount;
		this.onstudyDday = onstudyDday;
		this.sumFee = sumFee;
		this.thumbnail = thumbnail;
	}

	// 언니 검색용
	public Onstudy(int rnum, int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt,
			int onstudyCertifyCount, int onstudyFee, int onstudyWeeks, Date onstudyDeadlineDt, String categoryNm,
			String thumbnail) {
		super();
		this.rnum = rnum;
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.categoryNm = categoryNm;
		this.thumbnail = thumbnail;
	}

	// 언니 사용 온스터디 목록(참여인원) 조회용 Dao
	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, int onstudyWeeks, Date onstudyDeadlineDt, String categoryNm, int memberCount,
			String thumbnail) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.categoryNm = categoryNm;
		this.memberCount = memberCount;
		this.thumbnail = thumbnail;
	}

	// 언니 사용 온스터디 목록(최신날짜) 조회용 Dao
	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, int onstudyWeeks, Date onstudyDeadlineDt, String categoryNm, String thumbnail) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.categoryNm = categoryNm;
		this.thumbnail = thumbnail;
	}

	// 언니 사용 온스터디 상세조회용 Dao
	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, String onstudyAddComment, int onstudyWeeks, String categoryNm, int memberCount,
			int onstudyDday, int totalCertifyCount) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.onstudyWeeks = onstudyWeeks;
		this.categoryNm = categoryNm;
		this.memberCount = memberCount;
		this.onstudyDday = onstudyDday;
		this.totalCertifyCount = totalCertifyCount;
	}

	// 언니 사용 같은 카테고리 온스터디 조회용 Dao
	public Onstudy(String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount, int onstudyFee,
			int onstudyWeeks, Date onstudyDeadlineDt, String thumbnail, String categoryNm) {
		super();
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.thumbnail = thumbnail;
		this.categoryNm = categoryNm;
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, String categoryNm) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.categoryNm = categoryNm;
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyStartDt, Date onstudyEndDt, int onstudyCertifyCount,
			int onstudyFee, String onstudyAddComment, String categoryNm) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.categoryNm = categoryNm;
	}

	public Onstudy(int onstudyNo, String onstudyTitle, Date onstudyCreateDt, Date onstudyStartDt, Date onstudyEndDt,
			int onstudyCertifyCount, int onstudyFee, String onstudyAddComment, String onstudyStatus,
			String categoryNm) {
		super();
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyCreateDt = onstudyCreateDt;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.onstudyStatus = onstudyStatus;
		this.categoryNm = categoryNm;
	}

	// 모든 변수 포함 생성자
	public Onstudy(int rnum, int onstudyNo, String onstudyTitle, Date onstudyCreateDt, Date onstudyStartDt,
			Date onstudyEndDt, int onstudyCertifyCount, int onstudyFee, String onstudyAddComment, String onstudyStatus,
			int onstudyWeeks, int onstudyWriter, int categoryCd, Date onstudyDeadlineDt, String categoryNm,
			int memberCount, int onstudyDday, int totalCertifyCount, int sumFee, String thumbnail, int memberNo,
			int memberCertify) {
		super();
		this.rnum = rnum;
		this.onstudyNo = onstudyNo;
		this.onstudyTitle = onstudyTitle;
		this.onstudyCreateDt = onstudyCreateDt;
		this.onstudyStartDt = onstudyStartDt;
		this.onstudyEndDt = onstudyEndDt;
		this.onstudyCertifyCount = onstudyCertifyCount;
		this.onstudyFee = onstudyFee;
		this.onstudyAddComment = onstudyAddComment;
		this.onstudyStatus = onstudyStatus;
		this.onstudyWeeks = onstudyWeeks;
		this.onstudyWriter = onstudyWriter;
		this.categoryCd = categoryCd;
		this.onstudyDeadlineDt = onstudyDeadlineDt;
		this.categoryNm = categoryNm;
		this.memberCount = memberCount;
		this.onstudyDday = onstudyDday;
		this.totalCertifyCount = totalCertifyCount;
		this.sumFee = sumFee;
		this.thumbnail = thumbnail;
		this.memberNo = memberNo;
		this.memberCertify = memberCertify;
	}
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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

	public int getOnstudyWeeks() {
		return onstudyWeeks;
	}

	public void setOnstudyWeeks(int onstudyWeeks) {
		this.onstudyWeeks = onstudyWeeks;
	}

	public int getOnstudyWriter() {
		return onstudyWriter;
	}

	public void setOnstudyWriter(int onstudyWriter) {
		this.onstudyWriter = onstudyWriter;
	}

	public int getCategoryCd() {
		return categoryCd;
	}

	public void setCategoryCd(int categoryCd) {
		this.categoryCd = categoryCd;
	}

	public Date getOnstudyDeadlineDt() {
		return onstudyDeadlineDt;
	}

	public void setOnstudyDeadlineDt(Date onstudyDeadlineDt) {
		this.onstudyDeadlineDt = onstudyDeadlineDt;
	}

	public String getCategoryNm() {
		return categoryNm;
	}

	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public int getOnstudyDday() {
		return onstudyDday;
	}

	public void setOnstudyDday(int onstudyDday) {
		this.onstudyDday = onstudyDday;
	}

	public int getTotalCertifyCount() {
		return totalCertifyCount;
	}

	public void setTotalCertifyCount(int totalCertifyCount) {
		this.totalCertifyCount = totalCertifyCount;
	}

	public int getSumFee() {
		return sumFee;
	}

	public void setSumFee(int sumFee) {
		this.sumFee = sumFee;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getMemberCertify() {
		return memberCertify;
	}

	public void setMemberCertify(int memberCertify) {
		this.memberCertify = memberCertify;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getPartiMembers() {
		return partiMembers;
	}

	public void setPartiMembers(int partiMembers) {
		this.partiMembers = partiMembers;
	}


	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	
	@Override
	public String toString() {
		return "Onstudy [rnum=" + rnum + ", onstudyNo=" + onstudyNo + ", onstudyTitle=" + onstudyTitle
				+ ", onstudyCreateDt=" + onstudyCreateDt + ", onstudyStartDt=" + onstudyStartDt + ", onstudyEndDt="
				+ onstudyEndDt + ", onstudyCertifyCount=" + onstudyCertifyCount + ", onstudyFee=" + onstudyFee
				+ ", onstudyAddComment=" + onstudyAddComment + ", onstudyStatus=" + onstudyStatus + ", onstudyWeeks="
				+ onstudyWeeks + ", onstudyWriter=" + onstudyWriter + ", categoryCd=" + categoryCd
				+ ", onstudyDeadlineDt=" + onstudyDeadlineDt + ", categoryNm=" + categoryNm + ", memberCount="
				+ memberCount + ", onstudyDday=" + onstudyDday + ", totalCertifyCount=" + totalCertifyCount
				+ ", sumFee=" + sumFee + ", thumbnail=" + thumbnail + ", memberNo=" + memberNo + ", memberCertify="
				+ memberCertify + ", memberId=" + memberId + ", thumbnailPath=" + thumbnailPath + ", partiMembers="
				+ partiMembers + "]";
	}
	
}
