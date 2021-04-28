package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Layui;
import com.entity.QXJS;
import com.entity.ShuZ;
import com.service.GongSiService;
import com.service.impl.GongSiServiceImpl;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

/**
 * Servlet implementation class FJN
 */
@WebServlet("/FPS")
public class FPS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FPS() {
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
	public void fpqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		GongSiService dls=new GongSiServiceImpl();
		Layui<ShuZ> layui=dls.FpQx();
		
		
		PrintUtil.write(layui, response);
	}
	
	public List<QXJS> fphx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		ReturnResult result = new ReturnResult();
		GongSiService dls=new GongSiServiceImpl();
		int id=Integer.parseInt(request.getParameter("userid"));
		List<QXJS> list=dls.Fphx(id);
		result.returnSuccess(list);
		return list;
		
	}
	
	public int fpqb(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		

		GongSiService dls=new GongSiServiceImpl();
		int id=Integer.parseInt(request.getParameter("userid"));
		String[] qid=request.getParameterValues("array");
		
		if(request.getParameterValues("array")==null){
			int num=dls.FpSc(id);
			return num;
		}
		
		int ins=0;
		
		if(request.getParameterValues("array")!=null) {
			Integer[] qidint=new Integer[qid.length];
			int i=0;
			for(String str:qid){
				qidint[i]=Integer.parseInt(str);
		        i++;
		    }
			

			  if(qidint.length>0&&id!=0){
				  int del=dls.FpSc(id);
				  //System.out.println(del);
					  for (int j = 0; j < qidint.length; j++) { 
						  int menuid=qidint[j];
						  ins =dls.FpTj(id, menuid); 
						 }	  
				
			  }
		}
		
		  //System.out.println(ins);
		  return ins;
		
		
	}
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return FPS.class;
	}
	

}
