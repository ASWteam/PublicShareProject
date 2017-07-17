package com.shit.dto;

public class UCalendar {
	private int id;
	private String title;
	private String tooltip;
	private String context;
	private String start;
	private String end;
//	private String color;
	public UCalendar() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStartdate() {
		return start;
	}
	public void setStartdate(String startdate) {
		this.start = startdate;
	}
	public String getEnddate() {
		return end;
	}
	public void setEnddate(String enddate) {
		this.end = enddate;
	}
	@Override
	public String toString() {
		return "Calendar [id=" + id + ", title=" + title + ", tooltip=" + tooltip + ", context=" + context
				+ ", startdate=" + start + ", enddate=" + end + "]";
	}
	public UCalendar(int id, String title, String tooltip, String context, String startdate, String enddate) {
		super();
		this.id = id;
		this.title = title;
		this.tooltip = tooltip;
		this.context = context;
		this.start = startdate;
		this.end = enddate;
	}	
}
