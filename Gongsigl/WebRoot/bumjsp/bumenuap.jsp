<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改部门</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../js/css/layui-v2.5.5/css/layui.css" media="all" />
	<link rel="stylesheet" href="../js/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
	  <div class="layui-form-item">
	    <label class="layui-form-label">部门编号</label>
	    <div class="layui-input-inline">
	      	<input type="text" name="roleid" id="roleid" disabled=""	 lay-verify="required" placeholder="角色编号" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label">部门名</label>
	    <div class="layui-input-inline">
	    	<input type="text" name="rname2" id="rname2" readonly style="display:none" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	      	<input type="text" name="rname" id="rname" lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    	<button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addRole">修改部门</button>
	  </div>
</form>
<script type="text/javascript" src="../js/css/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="../js/css/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../js/uapjs/uapbm.js"></script>
</body>
</html>