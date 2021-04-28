package com.dao;

import java.util.List;

import com.entity.BuMenB;
import com.entity.JueSeB;
import com.entity.Ls_Butten;
import com.entity.QXJS;
import com.entity.QuanXianB;
import com.entity.YuanGongB;
import com.entity.ZhiChengB;


public interface GongSi {

	//登录
	public int Dl(String loginName2,String password2);
	
	//登录
	public int Dlm(String loginName2,String password2);

	//获取登录用户的所有信息
	public List<YuanGongB> Hqzh(int uid);
	
	//获取登录用户的所有信息
	public YuanGongB dxzh(int uid);

	//展现左侧
	public List<QuanXianB> Zx(int roleid);

	//查找按钮
	public List<QuanXianB> An(int mfid,int uid);

	//查询所有用户原表
	public List<YuanGongB> FhJson();

	//查询总数
	public int SjZs();

	//展现下拉框角色
	public List<JueSeB> QbJs();
	//展现下拉框部门
	public List<BuMenB> QbBm();
	//展现下拉框职务
	public List<ZhiChengB> QbZw();


	//判断账号名是否重复
	public int PdLn(String logname);

	//新增用户
	public int InZh(YuanGongB eUser);

	//删除用户
	public int DlZh(int uid);

	//查询id对应账号
	public List<YuanGongB> SeZh(int uid);

	//修改用户
	public int UpZh(YuanGongB eUser);

	//查询所有权限
	public List<QuanXianB> QxZs();

	//查询所有角色
	public List<JueSeB> JsZs();

	//分配权限用到layui
	public List<QuanXianB> FpQx();

	//分配回显
	public List<QXJS> Fphx(int id);

	//分配功能
	//1.删除全部
	public int FpSc(int id);
	//2.添加所选的
	public int FpTj(int id,int qid);

	//根据id获取角色
	public int idjs(int idd);
	//根据id获取部门
	public int idbm(int idd);
	//根据id获取职称
	public int idzc(int idd);
	
	
	//验证权限名是否存在
		public int QxName(String name);
		
		//新增权限
		public int InsQx(QuanXianB lm);
		
		//查询所有按钮
		public List<Ls_Butten> SeAn();
		
		//根据类型查找上级
		public List<QuanXianB> QxPd(int idd);
		
		//删除权限
		public int DlQx(int idd);
		
		//根据id回显权限
		public List<QuanXianB> QxHx(int idd);
		
		//根据类型查找上级(修改)
		public List<QuanXianB> XgQxPd(int idd);
		
		//修改权限
		public int XgQx(QuanXianB lm,int idd);

}
