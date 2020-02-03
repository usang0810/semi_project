package com.semi.mainPage.model.vo;

public class Category {

	 private int categoryNo;
	 private String categoryName;
	 
	 public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Category(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	 
	
}
