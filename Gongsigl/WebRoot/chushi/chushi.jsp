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
    
    <title>My JSP 'chushi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
   <link rel="stylesheet" href="js/css/public.css" media="all">
   <link rel="stylesheet" href="js/css/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="js/lay-module/layui_ext/dtree/font/dtreefont.css">
    <link rel="stylesheet" href="js/css/shu/demo/css/treeTable.css">
<!--     <style>
        .layui-btn:not(.layui-btn-lg ):not(.layui-btn-sm):not(.layui-btn-xs) {
            height: 34px;
            line-height: 34px;
            padding: 0 8px;
        }
    </style> -->
  <body>
    <div class="layui-layout layui-layout-admin">
    
  <div class="layui-header">
    <div class="layui-logo">layui 管理布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
      
        <a href="javascript:;">
          <img src="images/20200826145930_hVn4t.jpeg" class="layui-nav-img">
         <c:forEach items="${list2}" var="li">
         	${li.ygname}										
        </c:forEach>
        </a>
        
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  
  
		<%@include file="../gongy/gongyou.jsp" %>

		
		
	<div id="div">
		
		<!-- <table id="newsList" lay-filter="newsList"></table> -->
		
		  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
	</div>
	
	
	
	</div>
	
  </body>
 <!-- 分配权限 -->
	<div style="height: 400px;overflow: auto;display: none;" id="divdiv" >
	  <ul id="database" class="dtree" data-id="0"></ul>
	</div>
    <script type="text/javascript" src="js/layui.all.js"></script>
<!--     <script type="text/javascript" src="../lay/treeTable.js"></script> -->
<!--     <script type="text/javascript" src="js/lay/modules/treeTable.js"></script> -->
<!-- <script type="text/javascript" src="js/lay/modules/layer.js"></script> -->
<script type="text/javascript" src="js/lay/modules/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/zxjs/ZxCb.js"></script>

  
</html>
