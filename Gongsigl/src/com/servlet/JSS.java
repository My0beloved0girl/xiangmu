package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.AbstractServlet;

/**
 * Servlet implementation class FJN
 */
@WebServlet("/JSS")
public class JSS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSS() {
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
	
	/*
	 * public int pdjs(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * String name=request.getParameter("rname"); DengLuService dls=new
	 * DLServiceImpl(); int num=dls.Pdjs(name);
	 * 
	 * return num; }
	 */
	
	/*
	 * public int addjs(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * String name=request.getParameter("rname"); DengLuService dls=new
	 * DLServiceImpl(); Ls_Role lr=new Ls_Role(); lr.setRname(name);
	 * 
	 * int num=dls.InJs(lr);
	 * 
	 * return num; }
	 */
	
	/*
	 * public int deljs(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * int idd=Integer.parseInt(request.getParameter("roleid"));
	 * //System.out.println(idd); DengLuService dls=new DLServiceImpl();
	 * 
	 * int num=dls.DlJs(idd);
	 * 
	 * return num; }
	 */
	
	/*
	 * public ReturnResult idjs(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * ReturnResult result = new ReturnResult(); int
	 * idd=Integer.parseInt(request.getParameter("roleid")); DengLuService dls=new
	 * DLServiceImpl(); List<Ls_Role> list=dls.idjs(idd);
	 * 
	 * 
	 * result.returnSuccess(list); return result; }
	 */
	/*
	 * public int uapjs(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException {
	 * response.setContentType("text/html;charset=utf-8");
	 * request.setCharacterEncoding("utf-8");
	 * 
	 * 
	 * int roleid=Integer.parseInt(request.getParameter("roleid")); String
	 * rname=request.getParameter("rname");
	 * 
	 * DengLuService dls=new DLServiceImpl(); Ls_Role lr=new Ls_Role();
	 * 
	 * lr.setRname(rname);
	 * 
	 * int num=dls.uapjs(lr, roleid);
	 * 
	 * return num; }
	 */
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return JSS.class;
	}
	

}
