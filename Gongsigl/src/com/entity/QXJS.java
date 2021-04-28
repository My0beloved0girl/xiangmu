package com.entity;

public class QXJS {
	private int jueseid;
	private int quanxianid;
	
	public QXJS() {};
	
	public QXJS(int jueseid,int quanxianid) {
		this.jueseid=jueseid;
		this.quanxianid=quanxianid;
		
	}

	public int getJueseid() {
		return jueseid;
	}

	public void setJueseid(int jueseid) {
		this.jueseid = jueseid;
	}

	public int getQuanxianid() {
		return quanxianid;
	}

	public void setQuanxianid(int quanxianid) {
		this.quanxianid = quanxianid;
	};

	
}
