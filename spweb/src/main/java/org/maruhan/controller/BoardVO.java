package org.maruhan.controller;

import java.sql.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	public int getBbo() {
		return bno;
	}
	public void setBbo(int bNO) {
		bno = bNO;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String tITLE) {
		title = tITLE;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String cONTEXT) {
		content = cONTEXT;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String wRITER) {
		writer = wRITER;
	}
	public Date getRdgdate() {
		return regdate;
	}
	public void setRegdat(Date rEGDATE) {
		regdate = rEGDATE;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date uPDATEDATE) {
		updatedate = uPDATEDATE;
	}
	
	@Override
	public String toString() {
		return "BNO=" + bno + ", TITLE=" + title + ", CONTEXT=" + content + ", WRITER=" + writer
				+ ", REGDATE=" + regdate + ", UPDATEDATE=" + updatedate + "\n";
	}
	
}
