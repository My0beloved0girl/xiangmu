package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BuMenB;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.utils.ReturnResult;
import com.web.AbstractServlet;
@WebServlet("/BMS")
public class BMS extends AbstractServlet {

	 public BMS() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	public int addbm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String bmname=request.getParameter("rname");
		GongSiService gs=new GongSiServiceImpl();
		BuMenB bm=new BuMenB();
		bm.setBmname(bmname);
		int num=gs.xzbm(bm);
		return num;
	}
	
	public int pdbm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("rname");
		GongSiService gs=new GongSiServiceImpl();

		int num=gs.pdbm(name);
		return num;
	}
	
	public int delbm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("roleid"));
		GongSiService gs=new GongSiServiceImpl();
		int num=gs.scbm(id);
		return num;
	}
	
	public ReturnResult hxbm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ReturnResult result = new ReturnResult();
		int id=Integer.parseInt(request.getParameter("roleid"));
		GongSiService gs=new GongSiServiceImpl();
		List<BuMenB> list=gs.hxbm(id);
		result.returnSuccess(list);
		return result;
	}
	
	public int uapbm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("roleid"));
		String bmname=request.getParameter("rname");
		GongSiService gs=new GongSiServiceImpl();
		BuMenB bm=new BuMenB();
		bm.setId(id);
		bm.setBmname(bmname);
		int num=gs.xgbm(bm);
		
		return num;
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BMS.class;
	}

}
