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

	//��¼
	public int Dl(String loginName2,String password2);
	
	//��¼
	public int Dlm(String loginName2,String password2);

	//��ȡ��¼�û���������Ϣ
	public List<YuanGongB> Hqzh(int uid);
	
	//��ȡ��¼�û���������Ϣ
	public YuanGongB dxzh(int uid);

	//չ�����
	public List<QuanXianB> Zx(int roleid);

	//���Ұ�ť
	public List<QuanXianB> An(int mfid,int uid);

	//��ѯ�����û�ԭ��
	public List<YuanGongB> FhJson();

	//��ѯ����
	public int SjZs();

	//չ���������ɫ
	public List<JueSeB> QbJs();
	//չ����������
	public List<BuMenB> QbBm();
	//չ��������ְ��
	public List<ZhiChengB> QbZw();


	//�ж��˺����Ƿ��ظ�
	public int PdLn(String logname);

	//�����û�
	public int InZh(YuanGongB eUser);

	//ɾ���û�
	public int DlZh(int uid);

	//��ѯid��Ӧ�˺�
	public List<YuanGongB> SeZh(int uid);

	//�޸��û�
	public int UpZh(YuanGongB eUser);

	//��ѯ����Ȩ��
	public List<QuanXianB> QxZs();

	//��ѯ���н�ɫ
	public List<JueSeB> JsZs();

	//����Ȩ���õ�layui
	public List<QuanXianB> FpQx();

	//�������
	public List<QXJS> Fphx(int id);

	//���书��
	//1.ɾ��ȫ��
	public int FpSc(int id);
	//2.�����ѡ��
	public int FpTj(int id,int qid);

	//����id��ȡ��ɫ
	public int idjs(int idd);
	//����id��ȡ����
	public int idbm(int idd);
	//����id��ȡְ��
	public int idzc(int idd);
	
	
	//��֤Ȩ�����Ƿ����
		public int QxName(String name);
		
		//����Ȩ��
		public int InsQx(QuanXianB lm);
		
		//��ѯ���а�ť
		public List<Ls_Butten> SeAn();
		
		//�������Ͳ����ϼ�
		public List<QuanXianB> QxPd(int idd);
		
		//ɾ��Ȩ��
		public int DlQx(int idd);
		
		//����id����Ȩ��
		public List<QuanXianB> QxHx(int idd);
		
		//�������Ͳ����ϼ�(�޸�)
		public List<QuanXianB> XgQxPd(int idd);
		
		//�޸�Ȩ��
		public int XgQx(QuanXianB lm,int idd);

}
