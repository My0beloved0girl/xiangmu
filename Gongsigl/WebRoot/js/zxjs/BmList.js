
    /*------------- 加载用户数据 --------------------------------*/
    	layui.use('table', function(){
    		 var form = layui.form,
 	        layer = parent.layer === undefined ? layui.layer : top.layer,
 	        $ = layui.jquery,
 	        laydate = layui.laydate,
 	        laytpl = layui.laytpl,
 	        table = layui.table;
 	    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=bmzs',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'bmname', title: '部门', minWidth:100, align:"center"},
        ]]
    });
  //工具栏事件
	table.on('toolbar(newsList)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		var data = checkStatus.data;
		var roleid = '';
		for(i=0;i<data.length;i++){
			roleid = data[i].id;
		}
		switch(obj.event){
		  case 'deljs':	//删除角色
			  if(data.length != 1){
				  layer.msg("请选择一行数据进行操作")
				  return false;
			  }
			  layer.confirm('删除部门后,确定删除吗?', {icon: 3, title:'提示'}, function(index){
				  delRole(roleid);
				  layer.close(index);
			  });
		  break;
		  
		  case 'upajs':	//修改角色
			  if(data.length != 1){
				  layer.msg("请选择一行数据进行操作")
				  return false;
			  }else{
				  upRole(roleid);
			  }
		  break;
		  
		  case 'insjs':	//新增角色
			  addRole();
		  break;
		  
		  case 'upRoleMenu':	//修改角色权限
			  if(data.length == 0 || data.length > 1){
				  layer.msg("请选择一行数据进行操作")
				  return ;
			  }else{
				  upRoleMenu(roleid);
			  }
		  break;
	};
  });
	
	
	//删除角色
	function delRole(roleid){
		//alert(roleid);
		$.ajax({
			url:"BMS?action=delbm",
			type:"post",
			data:{"roleid":roleid},
			success:function(data){
				if(data == 1){
					layer.msg("删除成功");
					tableIns.reload("#newsList");
				}
			}
		})
	}
	
	
	//新增角色
	function addRole(){
		layui.layer.open({
    		title : "新增角色",
    		type : 2,
    		content : "bumjsp/bumenadd.jsp",
    		area:['350px','200px'],
		});
	}
	
	//修改角色
	function upRole(roleid){
		layui.layer.open({
    		title : "修改角色",
    		type : 2,
    		content : "bumjsp/bumenuap.jsp",
    		area:['350px','230px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"BMS?action=hxbm",
    				type:"post",
    				data:{"roleid":roleid},
    				success:function(data){
    					
    					var info = eval("("+data+")")
    					var body = layui.layer.getChildFrame('body', index);
    					body.find("#roleid").val(info.data[0].id);
    					body.find("#rname2").val(info.data[0].bmname);
    					body.find("#rname").val(info.data[0].bmname);
    				}
    			})
/*        			//获取新窗口对象
                var iframeWindow = layero.find('iframe')[0].contentWindow;
                //重新渲染
                iframeWindow.layui.form.render();*/
    		}
		});
	}
	
	
	
	
	
   })
	


