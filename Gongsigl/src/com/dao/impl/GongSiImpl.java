package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.GongSi;
import com.entity.BuMenB;
import com.entity.JueSeB;
import com.entity.Ls_Butten;
import com.entity.QXJS;
import com.entity.QuanXianB;
import com.entity.YuanGongB;
import com.entity.ZhiChengB;
import com.utils.DataBaseUtil;

public class GongSiImpl extends BaseDao implements GongSi {

	@Override
	public int Dl(String loginName2, String password2) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<YuanGongB> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM yuangongb where dlname=? and passwd=?";	
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginName2);
			ps.setString(2, password2);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<YuanGongB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String passwd= rs.getString("passwd");
					int bumen= rs.getInt("bumen");
					int zhicheng= rs.getInt("zhicheng");
					int juese= rs.getInt("juese");
					int sex= rs.getInt("sex");
					list.add(new YuanGongB(id, ygname, dlname, passwd, bumen, zhicheng, juese,sex));
					return rs.getInt("juese");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return 0;
	}
	
	public int Dlm(String loginName2, String password2) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<YuanGongB> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM yuangongb where dlname=? and passwd=?";	
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginName2);
			ps.setString(2, password2);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<YuanGongB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String passwd= rs.getString("passwd");
					int bumen= rs.getInt("bumen");
					int zhicheng= rs.getInt("zhicheng");
					int juese= rs.getInt("juese");
					int sex= rs.getInt("sex");
					list.add(new YuanGongB(id, ygname, dlname, passwd, bumen, zhicheng, juese,sex));
					return rs.getInt("id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return 0;
	}

	@Override
	public List<YuanGongB> Hqzh(int uid) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<YuanGongB> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM yuangongb WHERE id='"+uid+"'";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<YuanGongB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String passwd= rs.getString("passwd");
					int bumen= rs.getInt("bumen");
					int zhicheng= rs.getInt("zhicheng");
					int juese= rs.getInt("juese");
					int sex= rs.getInt("sex");
					list.add(new YuanGongB(id, ygname, dlname, passwd, bumen, zhicheng, juese,sex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<QuanXianB> Zx(int roleid) {
		Connection conn=getConnection();
		List<QuanXianB> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM quanxian WHERE id IN(SELECT quanxianid FROM qxjs WHERE jueseid='"+roleid+"')";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {	
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url=rs.getString("url");
					String buttom=rs.getString("buttom");
					
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<QuanXianB> An(int mfid, int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM quanxian WHERE mfatherid='"+mfid+"' AND TYPE=3 AND id IN(SELECT quanxianid FROM qxjs WHERE jueseid='"+uid+"')";
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {	
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url=rs.getString("url");
					String buttom=rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<YuanGongB> FhJson() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT yg.id,yg.ygname,yg.dlname,yg.passwd,bm.bmname,zc.zcname,js.jsname,yg.sex  FROM yuangongb AS yg,bumenb AS bm,zhichengb AS zc,jueseb AS js \r\n" + 
				"WHERE yg.bumen=bm.id AND yg.zhicheng=zc.id AND yg.juese=js.id";
		List<YuanGongB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<YuanGongB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String passwd= rs.getString("passwd");
					String bmname= rs.getString("bmname");
					String zcname= rs.getString("zcname");
					String jsname= rs.getString("jsname");
					int sex = rs.getInt("sex");
					list.add(new YuanGongB(id, ygname, dlname, passwd, bmname, zcname, jsname,sex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public int SjZs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT COUNT(1) FROM yuangongb ";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("COUNT(1)");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	@Override
	public List<JueSeB> QbJs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM jueseb";
		List<JueSeB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<JueSeB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String jsname= rs.getString("jsname");
					list.add(new JueSeB(id, jsname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<BuMenB> QbBm() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM bumenb";
		List<BuMenB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<BuMenB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String bmname= rs.getString("bmname");
					list.add(new BuMenB(id, bmname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<ZhiChengB> QbZw() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM zhichengb";
		List<ZhiChengB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<ZhiChengB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String zcname= rs.getString("zcname");
					list.add(new ZhiChengB(id, zcname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public int PdLn(String logname) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM yuangongb WHERE dlname='"+logname+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	@Override
	public int InZh(YuanGongB eUser) {
		String sql="INSERT INTO `yuangongb`(ygname,`dlname`,`passwd`,`bumen`,`zhicheng`,`juese`,`sex`) VALUES(?,?,?,?,?,?,?)";
		int num=executeUpdate(sql,eUser.getYgname(),eUser.getDlname(),eUser.getPasswd(),eUser.getBumen(),eUser.getZhicheng(),eUser.getJuese(),eUser.getSex());
		return num;
	}

	@Override
	public int DlZh(int uid) {
		String sql="delete from yuangongb where id=?";
		int num=executeUpdate(sql,uid);
		return num;
	}

	@Override
	public List<YuanGongB> SeZh(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM yuangongb WHERE id='"+uid+"'  ";
		List<YuanGongB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<YuanGongB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String passwd= rs.getString("passwd");
					int bumen= rs.getInt("bumen");
					int zhicheng= rs.getInt("zhicheng");
					int juese= rs.getInt("juese");
					int sex= rs.getInt("sex");
					list.add(new YuanGongB(id, ygname, dlname, passwd, bumen, zhicheng, juese,sex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public int UpZh(YuanGongB eUser) {
		String sql="update yuangongb set ygname=?,dlname=?,passwd=?,bumen=?,zhicheng=?,juese=?,sex=?  where id=? ";
		int num=executeUpdate(sql,eUser.getYgname(),eUser.getDlname(),eUser.getPasswd(),eUser.getBumen(),eUser.getZhicheng(),eUser.getJuese(),eUser.getSex(),eUser.getId());
		return num;
	}

	@Override
	public List<QuanXianB> QxZs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM quanxian";
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<JueSeB> JsZs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT js.`id`,js.jsname,yg.ygname,yg.dlname,bm.bmname,zc.zcname,yg.sex  FROM yuangongb AS yg,bumenb AS bm,zhichengb AS zc,jueseb AS js \r\n" + 
				"WHERE yg.bumen=bm.id AND yg.zhicheng=zc.id  AND yg.juese=js.id ORDER BY js.jsname";
		List<JueSeB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<JueSeB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String jsname= rs.getString("jsname");
					String ygname= rs.getString("ygname");
					String dlname= rs.getString("dlname");
					String bmname= rs.getString("bmname");
					String zcname= rs.getString("zcname");
					int sex = rs.getInt("sex");
					list.add(new JueSeB(id, jsname, ygname, dlname, bmname, zcname, sex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<QuanXianB> FpQx() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM quanxian";
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<QXJS> Fphx(int id) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM qxjs WHERE jueseid='"+id+"'";
		List<QXJS> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QXJS>();
				while (rs.next()) {
					int jueseid = rs.getInt("jueseid");
					int quanxianid= rs.getInt("quanxianid");
					list.add(new QXJS(jueseid, quanxianid));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public int FpSc(int id) {
		String sql="delete from qxjs where jueseid=?";
		int num=executeUpdate(sql,id);
		return num;
	}

	@Override
	public int FpTj(int id, int qid) {
		String sql="INSERT INTO qxjs(jueseid,quanxianid) VALUES(?,?)";
		int num=executeUpdate(sql,id,qid);
		return num;
	}

	@Override
	public int idjs(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM jueseb WHERE id='"+idd+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	@Override
	public int idbm(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM bumenb WHERE id='"+idd+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	@Override
	public int idzc(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM zhichengb WHERE id='"+idd+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	@Override
	public YuanGongB dxzh(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM  yuangongb WHERE id='"+uid+"'";
		YuanGongB yuanGongB= null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {		
				while (rs.next()) {
					int id = rs.getInt("id");
					String ygname = rs.getString("ygname");
					String dlname = rs.getString("dlname");
					String passwd = rs.getString("passwd");
					int bumen = rs.getInt("bumen");
					int zhicheng = rs.getInt("zhicheng");
					int juese = rs.getInt("juese");
					int sex = rs.getInt("sex");
					yuanGongB=new YuanGongB(id, ygname, dlname, passwd, bumen, zhicheng, juese, sex);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return yuanGongB;
	}
	
	@Override
	public int QxName(String name) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM quanxian WHERE qxname='"+name+"'  ";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}


	@Override
	public int InsQx(QuanXianB lm) {
		String sql="INSERT INTO `quanxian`(qxname,`mfatherid`,`type`,`url`,`buttom`) VALUES(?,?,?,?,?)";
		int num=executeUpdate(sql,lm.getQxname(),lm.getMfatherid(),lm.getType(),lm.getUrl(),lm.getButtom());
		return num;
	}


	@Override
	public List<Ls_Butten> SeAn() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_butten";
		List<Ls_Butten> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Butten>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String btntype= rs.getString("btntype");
					list.add(new Ls_Butten(id, btntype));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<QuanXianB> QxPd(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql=null;
		if(idd==2) {
			idd--;
			sql="select * from quanxian where type='"+idd+"'";
		}else if(idd==3) {
			idd--;
			sql="select * from quanxian where type='"+idd+"'";
		}else {
			sql="select * from quanxian where type='"+idd+"'";
		}
		
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int DlQx(int idd) {
		String sql="delete from quanxian where id=?";
		int num=executeUpdate(sql,idd);
		return num;
	}


	@Override
	public List<QuanXianB> QxHx(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="select * from quanxian where id='"+idd+"'";
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<QuanXianB> XgQxPd(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="select * from quanxian where id='"+idd+"'";
		
		List<QuanXianB> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<QuanXianB>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String qxname= rs.getString("qxname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new QuanXianB(id, qxname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int XgQx(QuanXianB lm,int idd) {
		String sql="update quanxian set qxname=?,mfatherid=?,type=?,url=?,buttom=?  where id=? ";
		int num=executeUpdate(sql,lm.getQxname(),lm.getMfatherid(),lm.getType(),lm.getUrl(),lm.getButtom(),idd);
		return num;
	}

}
