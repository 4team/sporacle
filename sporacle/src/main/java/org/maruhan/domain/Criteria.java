package org.maruhan.domain;

public class Criteria {
	
	private Integer pageNo;
	private int perPage;
	private Integer totalCount;
	private Integer bno;

	private String type;
	private String keyword;
	
	
	
	public Criteria(){
		this.pageNo = 1;
		this.perPage = 10;
	}
	
	
	public String getLink(){
		String str = "pageNo="+getPageNo();
		
		if(bno!=null){
			str+="&bno="+getBno();
		}
		
		if(type!=null){
			str+="&type="+getType();
		}
		
		if(keyword!=null){
			str+="&keyword="+getKeyword();
		}
		if(totalCount != null){
			str+="&totalCount="+getTotalCount();
		}
		return str;
	}
	
	public String getPaging(){
		
		String str = "&totalCount="+totalCount;
		
		if(bno!=null){
			str+="&bno="+getBno();
		}
		
		if(type!=null){
			str+="&type="+getType();
		}
		
		if(keyword!=null){
			str+="&keyword="+getKeyword();
		}

		return str;
	}
	
	
	
	public Integer getBno() {
		return bno;
	}


	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
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
		return "Criteria [pageNo=" + pageNo + ", perPage=" + perPage + ", totalCount=" + totalCount + ", bno=" + bno
				+ ", type=" + type + ", keyword=" + keyword + "]\n";
	}

}
