package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.GongSi;
import com.dao.impl.GongSiImpl;
import com.entity.BuMenB;
import com.entity.JueSeB;
import com.entity.Layui;
import com.entity.Ls_Butten;
import com.entity.QXJS;
import com.entity.QuanXianB;
import com.entity.ShuZ;
import com.entity.YuanGongB;
import com.entity.ZhiChengB;
import com.service.GongSiService;

public class GongSiServiceImpl implements GongSiService {

	GongSi gs=new GongSiImpl();
	
	@Override
	public int Dl(String loginName2, String password2) {
		// TODO Auto-generated method stub
		return gs.Dl(loginName2, password2);
	}

	@Override
	public List<YuanGongB> Hqzh(int uid) {
		// TODO Auto-generated method stub
		return gs.Hqzh(uid);
	}

	@Override
	public List<QuanXianB> Zx(int roleid) {
		// TODO Auto-generated method stub
		return gs.Zx(roleid);
	}

	@Override
	public List<QuanXianB> An(int mfid, int uid) {
		// TODO Auto-generated method stub
		return gs.An(mfid, uid);
	}

	@Override
	public Layui<YuanGongB> FhJson() {
		// TODO Auto-generated method stub
		List<YuanGongB> list=gs.FhJson();
		//System.out.println(list);
		int num=gs.SjZs();
		//System.out.println(num);
		//System.out.println(list);
		Layui<YuanGongB> layui=new Layui<YuanGongB>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			//System.out.println(layui);
			
		return layui;
	}

	@Override
	public int SjZs() {
		// TODO Auto-generated method stub
		return gs.SjZs();
	}

	@Override
	public List<JueSeB> QbJs() {
		// TODO Auto-generated method stub
		return gs.QbJs();
	}

	@Override
	public List<BuMenB> QbBm() {
		// TODO Auto-generated method stub
		return gs.QbBm();
	}

	@Override
	public List<ZhiChengB> QbZw() {
		// TODO Auto-generated method stub
		return gs.QbZw();
	}

	@Override
	public int PdLn(String logname) {
		// TODO Auto-generated method stub
		return gs.PdLn(logname);
	}

	@Override
	public int InZh(YuanGongB eUser) {
		// TODO Auto-generated method stub
		return gs.InZh(eUser);
	}

	@Override
	public int DlZh(int uid) {
		// TODO Auto-generated method stub
		return gs.DlZh(uid);
	}

	@Override
	public List<YuanGongB> SeZh(int uid) {
		// TODO Auto-generated method stub
		return gs.SeZh(uid);
	}

	@Override
	public int UpZh(YuanGongB eUser) {
		// TODO Auto-generated method stub
		return gs.UpZh(eUser);
	}

	@Override
	public Layui<QuanXianB> QxZs() {
		List<QuanXianB> list=gs.QxZs();
		int num=gs.SjZs();
		Layui<QuanXianB> layui=new Layui<QuanXianB>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}

	@Override
	public Layui<JueSeB> JsZs() {
		// TODO Auto-generated method stub
		List<JueSeB> list=gs.JsZs();
		int num=gs.SjZs();
		Layui<JueSeB> layui=new Layui<JueSeB>();
		
		layui.setCode(0);
		layui.setMsg("");
		layui.setCount(num);
		layui.setData(list);
		
		return layui;
	}

	@Override
	public Layui<ShuZ> FpQx() {
		List<QuanXianB> seleAllMenu = gs.FpQx();
		Layui<ShuZ> layui = new Layui<ShuZ>();
		layui.setCode(0);
		layui.setCount(0);
		layui.setMsg("");
		List<ShuZ> fenList = new ArrayList<ShuZ>();
		for (QuanXianB lsmenu : seleAllMenu) {
			ShuZ fen = new ShuZ();
			fen.setId(lsmenu.getId());
			fen.setParentId(lsmenu.getMfatherid());
			fen.setTitle(lsmenu.getQxname());
			fen.setCheckArr("0");
			fenList.add(fen);
		}
		layui.setData(fenList);
		return layui;
	}

	@Override
	public List<QXJS> Fphx(int id) {
		// TODO Auto-generated method stub
		return gs.Fphx(id);
	}

	@Override
	public int FpSc(int id) {
		// TODO Auto-generated method stub
		return gs.FpSc(id);
	}

	@Override
	public int FpTj(int id, int qid) {
		// TODO Auto-generated method stub
		return gs.FpTj(id, qid);
	}

	@Override
	public int idjs(int idd) {
		// TODO Auto-generated method stub
		return gs.idjs(idd);
	}

	@Override
	public int idbm(int idd) {
		// TODO Auto-generated method stub
		return gs.idbm(idd);
	}

	@Override
	public int idzc(int idd) {
		// TODO Auto-generated method stub
		return gs.idzc(idd);
	}

	@Override
	public YuanGongB dxzh(int uid) {
		// TODO Auto-generated method stub
		return gs.dxzh(uid);
	}

	@Override
	public int QxName(String name) {
		// TODO Auto-generated method stub
		return gs.QxName(name);
	}

	@Override
	public int InsQx(QuanXianB lm) {
		// TODO Auto-generated method stub
		return gs.InsQx(lm);
	}

	@Override
	public List<Ls_Butten> SeAn() {
		// TODO Auto-generated method stub
		return gs.SeAn();
	}

	@Override
	public List<QuanXianB> QxPd(int idd) {
		// TODO Auto-generated method stub
		return gs.QxPd(idd);
	}

	@Override
	public int DlQx(int idd) {
		// TODO Auto-generated method stub
		return gs.DlQx(idd);
	}

	@Override
	public List<QuanXianB> QxHx(int idd) {
		// TODO Auto-generated method stub
		return gs.QxHx(idd);
	}

	@Override
	public List<QuanXianB> XgQxPd(int idd) {
		// TODO Auto-generated method stub
		return gs.XgQxPd(idd);
	}

	@Override
	public int XgQx(QuanXianB lm, int idd) {
		// TODO Auto-generated method stub
		return gs.XgQx(lm, idd);
	}

	@Override
	public int Dlm(String loginName2, String password2) {
		// TODO Auto-generated method stub
		return gs.Dlm(loginName2, password2);
	}
	
	
	

}
