package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.YuanGongB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;

@WebServlet("/DlS")
public class DlS extends HttpServlet {

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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String loginName=request.getParameter("name");
		//System.out.println(loginName);
		String password=request.getParameter("pwd");
		
		GongSiService dls=new GongSiServiceImpl();
		YuanGongB eu=new YuanGongB();
		//System.out.println(eu.getId());
		int num=dls.Dl(loginName, password);
		int num2=dls.Dlm(loginName, password);
		//System.out.println(num2);
		if(num>0){
			request.getRequestDispatcher("JBS?id="+num+"&nid="+num2+"").forward(request, response);
		}
		
		
	}

}
