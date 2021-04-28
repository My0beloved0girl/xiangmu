package com.entity;

public class JueSeB {
	
	private int id;
	private String jsname;
		
	private String ygname;
	private String dlname;
	private String bmname;
	private String zcname;
	private int sex;

	
	public JueSeB() {}
	
	public JueSeB(int id,String jsname) {
		this.id=id;
		this.jsname=jsname;
	}
	
	public JueSeB(int id,String jsname,String ygname,String dlname
			,String bmname,String zcname,int sex){
		
		this.id=id;
		this.ygname=ygname;
		this.dlname=dlname;
		this.bmname=bmname;
		this.zcname=zcname;
		this.jsname=jsname;
		this.sex=sex;
	}

	
	public String getYgname() {
		return ygname;
	}

	public void setYgname(String ygname) {
		this.ygname = ygname;
	}

	public String getDlname() {
		return dlname;
	}

	public void setDlname(String dlname) {
		this.dlname = dlname;
	}

	public String getBmname() {
		return bmname;
	}

	public void setBmname(String bmname) {
		this.bmname = bmname;
	}

	public String getZcname() {
		return zcname;
	}

	public void setZcname(String zcname) {
		this.zcname = zcname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJsname() {
		return jsname;
	}

	public void setJsname(String jsname) {
		this.jsname = jsname;
	}
	
	
}
