package com.entity;

public class BuMenB {
	private int id;
	private String bmname;
	
	public BuMenB() {}
	
	public BuMenB(int id,String bmname) {
		this.id=id;
		this.bmname=bmname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	

}
