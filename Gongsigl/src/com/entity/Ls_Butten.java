package com.entity;

public class Ls_Butten {
	private int id;
	private String btntype;
	
	public Ls_Butten() {};
	
	public Ls_Butten(int id,String btntype) {
		this.id=id;
		this.btntype=btntype;
		
	};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBtntype() {
		return btntype;
	}
	public void setBtntype(String btntype) {
		this.btntype = btntype;
	}
	
	

}
