package com.entity;

public class QuanXianB {
	
	private int id;
	private String qxname;
	private int mfatherid;
	private int type;
	private String url;
	private String buttom;

	public QuanXianB(){}
	
	public QuanXianB(int id,String qxname,int mfatherid,int type,String url,String buttom){
		this.id=id;
		this.qxname=qxname;
		this.mfatherid=mfatherid;
		this.type=type;
		this.url=url;
		this.buttom=buttom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQxname() {
		return qxname;
	}

	public void setQxname(String qxname) {
		this.qxname = qxname;
	}

	public int getMfatherid() {
		return mfatherid;
	}

	public void setMfatherid(int mfatherid) {
		this.mfatherid = mfatherid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getButtom() {
		return buttom;
	}

	public void setButtom(String buttom) {
		this.buttom = buttom;
	}
	
	

}
