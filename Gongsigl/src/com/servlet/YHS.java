package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.JueSeB;
import com.entity.QuanXianB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.web.AbstractServlet;
@WebServlet("/YHS")
public class YHS extends AbstractServlet {

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
	public String ygan(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int mfid=Integer.parseInt(request.getParameter("id"));
		//System.out.println(mfid);
		int uid=Integer.parseInt(request.getParameter("uid"));
		GongSiService dls=new GongSiServiceImpl();
		List<QuanXianB> list=dls.An(mfid,uid);
		
		//System.out.println(mfid);
		
		request.setAttribute("list3", list);
		return "zymjsp/yonghh";
	}
	
	public String qxan(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int mfid=Integer.parseInt(request.getParameter("id"));
		//System.out.println(mfid);
		int uid=Integer.parseInt(request.getParameter("uid"));
		GongSiService dls=new GongSiServiceImpl();
		List<QuanXianB> list=dls.An(mfid,uid);
		
		//System.out.println(mfid);
		
		request.setAttribute("list3", list);
		return "qxmjsp/menlist";
	}
	
	public String jsan(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int mfid=Integer.parseInt(request.getParameter("id"));
		//System.out.println(mfid);
		int uid=Integer.parseInt(request.getParameter("uid"));
		GongSiService dls=new GongSiServiceImpl();
		List<QuanXianB> list=dls.An(mfid,uid);
		
		//System.out.println(mfid);
		
		request.setAttribute("list3", list);
		return "jsjjsp/quanjs";
	}

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return YHS.class;
	}

}
