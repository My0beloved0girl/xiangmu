package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BuMenB;
import com.entity.JueSeB;
import com.entity.Layui;
import com.entity.QuanXianB;
import com.entity.YuanGongB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.utils.PrintUtil;
import com.web.AbstractServlet;



/**
 * Servlet implementation class FJN
 */
@WebServlet("/FJN")
public class FJN extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FJN() {
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
	public void sjzx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		Layui<YuanGongB> layui=dls.FhJson();
		
		
		PrintUtil.write(layui, response);
	}

	public void qxgl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		Layui<QuanXianB> layui=dls.QxZs();
		PrintUtil.write(layui, response);
        
	}
	
	public void jsgl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		Layui<JueSeB> layui=dls.JsZs();
		PrintUtil.write(layui, response);
        
	}
	
	public void bmzs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		Layui<BuMenB> layui=dls.cxbm();
		PrintUtil.write(layui, response);
        
	}
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return FJN.class;
	}
	

}
