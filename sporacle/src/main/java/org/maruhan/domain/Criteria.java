package org.maruhan.domain;

public class Criteria {
	
	private int pageNo;
	private int perPage;

	private String type;
	private String keyword;
	
	
	
	public Criteria(){
		this.pageNo = 1;
		this.perPage = 10;
	}
	
	
	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public double getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Criteria [pageNo=" + pageNo + ", perPage=" + perPage + ", type=" + type + ", keyword=" + keyword + "]\n";
	}

	
}
