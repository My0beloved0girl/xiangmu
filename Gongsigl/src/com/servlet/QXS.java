package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Ls_Butten;
import com.entity.QuanXianB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

/**
 * Servlet implementation class FJN
 */
@WebServlet("/QXS")
public class QXS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QXS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public int qxname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("mname");
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.QxName(name);
		
		return num;
	}
	
	public List<Ls_Butten> sean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		List<Ls_Butten> list=dls.SeAn();
		
		return list;
	}
	
	public List<QuanXianB> qxpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		List<QuanXianB> list=null;
		if(request.getParameter("type")!=null) {
			int idd=Integer.parseInt(request.getParameter("type"));
			GongSiService dls=new GongSiServiceImpl();
			list=dls.QxPd(idd);
		}
		
		return list;
	}

	public int insqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String mname=request.getParameter("mname");
		int type=Integer.parseInt(request.getParameter("type2"));
		int mfatherid=Integer.parseInt(request.getParameter("father"));
		String url=request.getParameter("mfunction");
		String buttom=request.getParameter("mbtn");
	
		
		QuanXianB lm=new QuanXianB();
		lm.setQxname(mname);
		lm.setMfatherid(mfatherid);
		lm.setType(type);
		lm.setUrl(url);
		lm.setButtom(buttom);
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.InsQx(lm);
		
		return num;
	}
	
	public int dlqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int idd=Integer.parseInt(request.getParameter("menuid"));
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.DlQx(idd);
		
		return num;
	}
	
	public ReturnResult qxhx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int idd=Integer.parseInt(request.getParameter("menuid"));
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		List<QuanXianB> list=dls.QxHx(idd);
		result.returnSuccess(list);
		return result;
	}
	
	public ReturnResult xgqxpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ReturnResult result = new ReturnResult();
		List<QuanXianB> list=null;
		if(request.getParameter("id")!=null) {
			int idd=Integer.parseInt(request.getParameter("id"));
			GongSiService dls=new GongSiServiceImpl();
			list=dls.XgQxPd(idd);
		}
		result.returnSuccess(list);
		return result;
	}
	
	public int xgqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");


		int idd=Integer.parseInt(request.getParameter("mid"));
		String mname=request.getParameter("mname");
		int type=Integer.parseInt(request.getParameter("type2"));
		int mfatherid=Integer.parseInt(request.getParameter("father"));
		String url=request.getParameter("mfunction");
		String buttom=request.getParameter("mbtn");
		
		/*
		 * System.out.println(idd); System.out.println(mname); System.out.println(type);
		 * System.out.println(mfatherid); System.out.println(url);
		 * System.out.println(buttom);
		 */
		
		
		QuanXianB lm=new QuanXianB();
		lm.setQxname(mname);
		lm.setMfatherid(mfatherid);
		lm.setType(type);
		lm.setUrl(url);
		lm.setButtom(buttom);
		GongSiService dls=new GongSiServiceImpl();
		int num=dls.XgQx(lm, idd);
	
		return num;
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QXS.class;
	}
	

}
