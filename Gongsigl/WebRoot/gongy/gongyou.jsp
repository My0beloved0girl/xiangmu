<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <!--  <link rel="stylesheet" href="js/css/public.css" media="all">
   <link rel="stylesheet" href="js/css/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/font/dtreefont.css"> -->
 
 
  
  <%-- <input type="text" id="loginName" value="${user.id }"/> --%>
  
   <input type="hidden" class="uid" value="${uid}"/>
   
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
     
 			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
     <c:forEach items="${list}" var="li">
    	<c:if test="${li.type==1}">
    		 
    		    <li class="layui-nav-item">
    		 <a class="" href="javascript:;">${li.qxname}</a>
    		<c:forEach items="${list}" var="ln">
	    			<c:if test="${ln.mfatherid==li.id}">
	    				 <dl class="layui-nav-child">
	    				<%-- <a href="${ln.url}?id=${ln.id}">${ln.mname}</a> --%>
	    				  
	    				<dd><a href="javaScript:void(0)" onclick="demo('${ln.url}','${ln.id}','${ln.buttom}')">${ln.qxname}</a></dd>	
	    				 </dl>
	    			</c:if>
	    		</c:forEach>
	    		</li>
    				
    	</c:if>
    </c:forEach>
    </ul>
 	</div>
  </div>

  
 <!--  <script type="text/javascript" src="js/layui.all.js"></script>
<script type="text/javascript" src="js/lay/modules/layer.js"></script>
<script type="text/javascript" src="js/lay/modules/jquery-1.12.4.js"></script>

<script type="text/javascript" src="js/zxjs/ZxCb.js"></script>
<script type="text/javascript" src="js/zxjs/ZxList.js"></script> -->

