package com.entity;

public class YuanGongB {
	private int id;
	private String ygname;
	private String dlname;
	private String passwd;
	private int bumen;
	private int zhicheng;
	private int juese;
	private int sex;
	
	private String bmname;
	private String zcname;
	private String jsname;
	
	public YuanGongB() {}
	
	public YuanGongB(int id,String ygname,String dlname,String passwd
			,int bumen,int zhicheng,int juese,int sex) {
		
		this.id=id;
		this.ygname=ygname;
		this.dlname=dlname;
		this.passwd=passwd;
		this.bumen=bumen;
		this.zhicheng=zhicheng;
		this.juese=juese;
		this.sex=sex;
	}
	
	public YuanGongB(int id,String ygname,String dlname,String passwd
			,String bmname,String zcname,String jsname,int sex){
		
		this.id=id;
		this.ygname=ygname;
		this.dlname=dlname;
		this.passwd=passwd;
		this.bmname=bmname;
		this.zcname=zcname;
		this.jsname=jsname;
		this.sex=sex;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getBumen() {
		return bumen;
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

	public String getJsname() {
		return jsname;
	}

	public void setJsname(String jsname) {
		this.jsname = jsname;
	}

	public void setBumen(int bumen) {
		this.bumen = bumen;
	}

	public int getZhicheng() {
		return zhicheng;
	}

	public void setZhicheng(int zhicheng) {
		this.zhicheng = zhicheng;
	}

	public int getJuese() {
		return juese;
	}

	public void setJuese(int juese) {
		this.juese = juese;
	}
	
	

}
