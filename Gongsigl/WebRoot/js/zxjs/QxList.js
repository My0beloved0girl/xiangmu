

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
        url : 'FJN?action=qxgl',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'mname', title: '权限', minWidth:100, align:"center"},
            {field: 'mfatherid', title: '父类',  align:'center'},
            {field: 'type', title: '级别', align:'center'},
            {field: 'url', title: '路径', minWidth:150, align:'center'},
            {field: 'buttom', title: '按钮', align:'center'},
        ]]
    });

  //监听工具栏
  		treeTable.on('toolbar(newsList)', function(obj){
  			 var checkStatus = table.checkStatus(obj.config.id);
  		    var data = checkStatus.data;
  		    var userid = '';
  		    for(i=0;i<data.length;i++){
  		    	userid = data[i].id;
  		    }
  		    switch(obj.event){
  		      case 'btn-expand':	//全部展开
  		    	  insTb.expandAll('#demoTreeTb');
  		      break;
  		      
  		      case 'btn-fold':	//全部折叠
  		    	  insTb.foldAll('#demoTreeTb');
  		      break;
  		      
  		      case 'addMenu':	//新增权限
  		    	  layer.open({
  		        		title : "添加权限",
  		        		type : 2,
  		        		content : "qxmjsp/quanxAdd.jsp",
  		        		area:['800px','700px'],
  		    	  })
  		      break;
  		      
  		      case 'uapMenu':	//修改权限
  					updataMenu();
  		      break;
  			        
  		      case 'delMenu':	//删除权限
  		    	  layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
  						delMenu();
  						layer.close(index);
  		            });
  		      break;
  		    };
  		 });
  		
  	   //---------删除权限-------
  		function delMenu(){
  	    	var menuid = '';
  	    	JSON.stringify(insTb.checkStatus().map(function (d) {
  	    		menuid = d.authorityId;
  	        }));
  	    	if(menuid == null || menuid == ""){
  	    		layer.msg("请选中一个节点进行删除");
  	    	}else{
  	    		$.ajax({
  	    			url:"MenuServlet?action=delMenu",
  	    			data:{"menuid":menuid},
  	    			type:"post",
  	    			dataType:"json",
  	    			success:function(data){
  	    				//var info = eval("("+data+")");
  	    				if(data.status == 1){
  	    					layer.msg("删除成功");
  	    					insTb.reload();
  	    				}else{
  	    					layer.msg("删除失败");
  	    				}
  	    			}
  	    		})
  	    	}
  	    }

         /*---------修改权限------*/
          function updataMenu(){
          	var authorityId = '';
          	JSON.stringify(insTb.checkStatus().map(function (d) {
  				 authorityId = d.authorityId;
              }));
          	if(authorityId == null || authorityId==""){
          		layer.msg('请选择一个进行修改');
          	}else{
          		layer.open({
                		 type:2,
                		 title:"修改权限",
                		 area:['800px','700px'],
                		 content:"admin/page/system/menu/menuInfo.jsp",
                		 success:function(layero, index){
                			 $.post("MenuServlet?action=allMenuById",{"menuid":authorityId},function(data){
                				var info = eval('(' + data + ')')
                				var body = layui.layer.getChildFrame('body', index);
                				body.find("#mid").val(info.data.id);
                				body.find("#mname").val(info.data.qxname);  //权限名
                				body.find("#mfunction").val(info.data.mfunction);	//请求路径
                				var select = 'dd[lay-value='+info.data.type+']';
                				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                				body.find("#mbtn").val(info.data.mbtn);		//按钮代码
                				body.find("#icon").val(info.data.icon);		//icon图标
                				var menuid3 = info.data.mfatherid;
                				//上级的下拉框
                   			 $.post("MenuServlet?action=allMenuById",{"menuid":menuid3},function(res){
               					var cs = eval('(' + res + ')');
       		                    body.find("#fatherType2").val(cs.data.qxname);
                   			 })
                   			 
                			 })
                  	}
            	    })
          	}
          };
    
    
    
   })
	


