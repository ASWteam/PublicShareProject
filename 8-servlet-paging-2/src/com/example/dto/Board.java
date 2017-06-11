package com.example.dto;

import java.util.Date;

public class Board {
	private int bno;
	private String title;
	private String writer;
	private Date wdate;
	private long vcount;
	private String content;

	public Board() {
		
	}

	public Board(int bno, String title, String writer, Date wdate, long vcount, String content) {
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.vcount = vcount;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public long getVcount() {
		return vcount;
	}

	public void setVcount(long vcount) {
		this.vcount = vcount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", writer=" + writer + ", wdate=" + wdate + ", vcount="
				+ vcount + ", content=" + content + "]";
	}

}
