<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <link rel="stylesheet" href="../js/css/layui-v2.5.5/css/layui.css" media="all" />
	<link rel="stylesheet" href="../js/css/public.css" media="all" />
   <!--  <link rel="stylesheet" href="../js/css/shu/demo/css/treeTable.css"> -->
    <style>
        .layui-btn:not(.layui-btn-lg ):not(.layui-btn-sm):not(.layui-btn-xs) {
            height: 34px;
            line-height: 34px;
            padding: 0 8px;
        }
    </style>
</head>
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
        	<button class="layui-btn" lay-event="btn-expand">全部展开</button>
	        	<button class="layui-btn layui-btn-normal" lay-event="btn-fold">全部折叠</button>&nbsp;
				<c:forEach items="${list3}" var="ls">
					${ls.buttom}&nbsp;
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

<script type="text/javascript" src="../js/css/layui-v2.5.5/layui.js"></script>
<!-- <script src="../js/lay-config.js?v=1.0.4" charset="utf-8"></script> -->
<script type="text/javascript" src="../js/zxjs/menlist.js"></script>
<%-- <script type="text/javascript" src="<%=basePath %>admin/pagejs/system/menu/menuList.js"></script> --%>
</body>
</html>