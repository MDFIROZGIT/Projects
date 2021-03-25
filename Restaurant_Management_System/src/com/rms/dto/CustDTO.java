package com.rms.dto;

import java.time.LocalDate;

public class CustDTO {
	private int cid;
	private String cname;
	private int tlocation;
	private int tsites;
	private String time;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getTlocation() {
		return tlocation;
	}
	public void setTlocation(int tlocation) {
		this.tlocation = tlocation;
	}
	public int getTsites() {
		return tsites;
	}
	public void setTsites(int tsites) {
		this.tsites = tsites;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
