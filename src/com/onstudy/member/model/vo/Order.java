package com.onstudy.member.model.vo;

public class Order {
	private String merchantUid;
	private String impUid;
	private String name;
	private int amount;
	private String buyerName;
	private String buyerTel;
	private char statusCode;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String merchantUid, String impUid, char statusCode) {
		super();
		this.merchantUid = merchantUid;
		this.impUid = impUid;
		this.statusCode = statusCode;
	}

	public Order(String name, int amount, String buyerName, String buyerTel) {
		super();
		this.name = name;
		this.amount = amount;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
	}

	public Order(String merchantUid, String impUid, String name, int amount, String buyerName, String buyerTel,
			char statusCode) {
		super();
		this.merchantUid = merchantUid;
		this.impUid = impUid;
		this.name = name;
		this.amount = amount;
		this.buyerName = buyerName;
		this.buyerTel = buyerTel;
		this.statusCode = statusCode;
	}

	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTel() {
		return buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public char getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(char statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "Order [merchantUid=" + merchantUid + ", impUid=" + impUid + ", name=" + name + ", amount=" + amount
				+ ", buyerName=" + buyerName + ", buyerTel=" + buyerTel + ", statusCode=" + statusCode + "]";
	}

}
