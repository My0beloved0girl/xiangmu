layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;

  //展现下拉框角色信息
  $.ajax({
	  url:"../ZHS?action=qbjs",
	  type:"post",
	  success:function(data){
		 // alert(data);
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#role1");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.jsname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  //展现下拉框部门信息
  $.ajax({
	  url:"../ZHS?action=qbbm",
	  type:"post",
	  success:function(data){
		 // alert(data);
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#bm");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.bmname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  //展现下拉框部门信息
  $.ajax({
	  url:"../ZHS?action=qbzw",
	  type:"post",
	  success:function(data){
		 // alert(data);
		  var info = eval("("+data+")");
		  var row = info.data;
		  var role = $("#zw");
		  var html = '';
		  $.each(row,function(index,item){
			  html += '<option value="'+item.id+'">'+item.zcname+'</option>';
		  })
		  role.html(html);
		  form.render("select");
	  }
  })
  
  //判断账号名是否重复
  function checkUname(uname){
	  var is = false;
	  $.ajax({
		  url:"../ZHS?action=pdln",
		  data:{"uname":uname},
		  async:false,
		  type:"post",
		  success:function(data){
			  //alert(data)
			  if(data == 0){
				  is = true;
			  }else{
				  is = false;
			  }
			  
		  }
	  })
	  return is;
  }
  
  $("#uname").blur(function(){
	  var name = $("#uname").val();
	  if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
		  }
	  }
  })
  
  
  $("#tijiao").click(function(){
	  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	  var name = $("#uname").val();
	  var pass = $("#password").val();
	  var realName = $("#realName").val();
	  var sex = $("input[type='radio']:checked").val();
	  var role = $("select[name='role1']").val();
	  var bm = $("select[name='bm']").val();
	  var zw = $("select[name='zw']").val();
	  //alert(sex);
	 // alert(role);
	  var data = {
			  "name":name,
			  "pass":pass,
			  "realName":realName,
			  "sex":sex,
			  "role":role,
			  "bm":bm,
			  "zw":zw
	  }
	  if(name.length<3){
		  layer.alert("登录名不能小于3位数")
		  return false;
	  }else if(pass.length < 5 || pass.length > 19){
		  layer.alert('密码必须6到12位，且不能出现空格');
		  return false;
	  }else if(realName.length == "" || realName.length == null){
		  layer.alert('真实姓名不能为空');
		  return false;
	  }else if(!name.length == "" || !name.length == null){
		  var check = checkUname(name);
		  if(check == false){
			  layer.alert("登录账号已存在! 请重新输入")
			  return false;
		  }
	  }
	  $.ajax({
	  		url:"../ZHS?action=inzh",
			data:data,
			tyep:"post",
			success:function(data){
				if(data == 1){
					layer.msg("添加成功")
					setTimeout(function(){
						layer.closeAll("iframe");
		
			            //刷新父页面
			           parent.location.reload();
		        	},1000);
				}else{
					layer.msg("系统异常");
				}
				
			}
	  })
	  return false;
  })
  
});
