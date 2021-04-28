<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhanxian.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>
  <!--   <link rel="stylesheet" href="js/css/public.css" media="all">
   <link rel="stylesheet" href="js/css/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/font/dtreefont.css">
     -->
    
    
    <input type="text" id="loginName" value="${user.id }" style="display:none"/>
    <!-- 内容主体区域 -->
    <div id="ssdiv">
  <div class="layui-body"> 
   <div class="layuimini-container">
   
	<div class="layuimini-main">
	
		<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="uname" id="likename" class="layui-input" placeholder="请输入查找的登录名" />
				</div>
			</div>
			<div class="layui-inline">
				<button type="button" class="layui-btn" lay-filter="doSubmit" id="doSubmit">
		            <i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
				</button>
			</div> 
		</blockquote> 
	</div>
		
		
		
		<div class="layui-btn-container" id="toolbarDemo">
				<c:forEach items="${list3}" var="ls">
					${ls.buttom}

				</c:forEach>
		</div> 


		<table id="newsList" lay-filter="newsList"></table>

<!--    	  table class="layui-hide" id="test" lay-filter="test"></table> -->

<div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
	</div>
 </div>
    
</div>
  
  

</body>
<!-- <script type="text/javascript" src="js/zxjs/ZxList.js"></script>
    <script type="text/javascript" src="js/layui.all.js"></script>
<script type="text/javascript" src="js/lay/modules/layer.js"></script>
<script type="text/javascript" src="js/lay/modules/jquery-1.12.4.js"></script>

<script type="text/javascript" src="js/zxjs/ZxCb.js"></script> -->
</html>




