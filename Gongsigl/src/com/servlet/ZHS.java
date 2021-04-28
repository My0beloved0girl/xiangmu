package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BuMenB;
import com.entity.JueSeB;
import com.entity.YuanGongB;
import com.entity.ZhiChengB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.utils.ReturnResult;
import com.web.AbstractServlet;
@WebServlet("/ZHS")
public class ZHS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	//查找所有角色
	public ReturnResult qbjs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		List<JueSeB> list=dls.QbJs();
		result.returnSuccess(list);
		return result;
	}

	//查找所有部门
	public ReturnResult qbbm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		List<BuMenB> list=dls.QbBm();
		result.returnSuccess(list);
		return result;
	}

	//查找所有职务
	public ReturnResult qbzw(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		List<ZhiChengB> list=dls.QbZw();
		result.returnSuccess(list);
		return result;
	}

	/*
	 * //搜索账号 public void sszh(HttpServletRequest request, HttpServletResponse
	 * response)throws ServletException, IOException{
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * String name=request.getParameter("uname");
	 * 
	 * DengLuService dls=new DLServiceImpl(); Layui<Easybuy_User>
	 * layui=dls.SsCx(name);
	 * 
	 * PrintUtil.write(layui, response); }
	 */

	//判断登录名是否重复
	public int pdln(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String logname=request.getParameter("uname");
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.PdLn(logname); 
		return num;
	}

	//添加账号
	public int inzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("name");
		String password=request.getParameter("pass");
		String loginName=request.getParameter("realName");
		int sex=Integer.parseInt(request.getParameter("sex"));
		int bm=Integer.parseInt(request.getParameter("bm"));
		int zw=Integer.parseInt(request.getParameter("zw"));
		int type=Integer.parseInt(request.getParameter("role"));


		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		YuanGongB eu=new YuanGongB();

		eu.setDlname(userName);
		eu.setPasswd(password);
		eu.setYgname(loginName);
		eu.setSex(sex);
		eu.setBumen(bm);
		eu.setZhicheng(zw);
		eu.setJuese(type);



		int num=dls.InZh(eu); 
		return num;
	}

	//删除账号
	public int dlzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		int uid=Integer.parseInt(request.getParameter("userid"));
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.DlZh(uid); 
		return num;
	}


	//查询id账号
	public ReturnResult sezh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		ReturnResult result = new ReturnResult();
		int uid=Integer.parseInt(request.getParameter("userid"));
		GongSiService dls=new GongSiServiceImpl();
		List<YuanGongB> list=dls.SeZh(uid); 


		result.returnSuccess(list);
		return result;
	}

	//根据用户id查询角色
	/*
	 * public int pdjs(HttpServletRequest request, HttpServletResponse
	 * response)throws ServletException, IOException{
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * int uid=Integer.parseInt(request.getParameter("userid")); DengLuService
	 * dls=new DLServiceImpl(); int num=dls.PdJs(uid);
	 * 
	 * return num; }
	 */

	//根据用户id查询角色
	public int fzjs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		int uid=Integer.parseInt(request.getParameter("userid"));

		GongSiService dls=new GongSiServiceImpl();
		YuanGongB yg=dls.dxzh(uid);

		int num=dls.idjs(yg.getJuese()); 

		return num;
	}
	
	//根据用户id查询部门
		public int fzbm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");

			int uid=Integer.parseInt(request.getParameter("userid"));

			GongSiService dls=new GongSiServiceImpl();
			YuanGongB yg=dls.dxzh(uid);

			int num=dls.idbm(yg.getBumen()); 

			return num;
		}
		
		
		//根据用户id查询职称
		public int fzzc(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");

			int uid=Integer.parseInt(request.getParameter("userid"));

			GongSiService dls=new GongSiServiceImpl();
			YuanGongB yg=dls.dxzh(uid);

			int num=dls.idzc(yg.getZhicheng()); 

			return num;
		}

	//修改角色
	public int upzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("uid"));
		String userName=request.getParameter("name");
		String password=request.getParameter("pass");
		String loginName=request.getParameter("realName");
		int sex=Integer.parseInt(request.getParameter("sex"));
		int bm=Integer.parseInt(request.getParameter("bm"));
		int zw=Integer.parseInt(request.getParameter("zw"));
		int type=Integer.parseInt(request.getParameter("role"));


		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		YuanGongB eu=new YuanGongB();
		
		eu.setDlname(userName);
		eu.setPasswd(password);
		eu.setYgname(loginName);
		eu.setSex(sex);
		eu.setBumen(bm);
		eu.setZhicheng(zw);
		eu.setJuese(type);
		eu.setId(id);



		int num=dls.UpZh(eu);
		//System.out.println(num);
		return num;

	}	


	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return ZHS.class;
	}

}
