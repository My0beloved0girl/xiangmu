/*alert("11111");*/
layui.config({
    base: 'js/lay/modules/'
}).extend({  //表格树依赖我另外写的tableEdit模块，本项目就有。
	treeTable:'treeTable'
}).use(['table','layer',"treeTable"], function () {
    var table = layui.table
        ,treeTable = layui.treeTable;
        
        // 渲染表格
		var insTb = treeTable.render({
            elem: '#newsList',
            url: 'FJN?action=qxgl',
            toolbar: '#toolbarDemo',
            height: 'full-115',
            tree: {
                iconIndex: 2,           // 折叠图标显示在第几列
                isPidData: true,        // 是否是id、pid形式数据
                idName: 'id',  // id字段名称
                pidName: 'mfatherid'     // pid字段名称
            },
            cols: [[
            	{field: 'id', title: '权限编号',width:10},
                {type: 'radio'},
                {field: 'qxname', title: '权限名称'},
                {field: 'type', width: 80, align: 'center', title: '类型', templet: function (d) {
                        if (d.type == 3) {
                            return '<span class="layui-badge layui-bg-orange">按钮</span>';
                        }
                        if (d.type == 2) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } else {
                            return '<span class="layui-badge layui-bg-green">菜单</span>';
                        }
                }}
            ]]
        });
		
		//监听工具栏
		treeTable.on('toolbar(newsList)', function(obj){
		    switch(obj.event){
		      case 'btn-expand':	//全部展开
		    	  insTb.expandAll('#newsList');
		      break;
		      
		      case 'btn-fold':	//全部折叠
		    	  insTb.foldAll('#newsList');
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
	    		menuid = d.id;
	        }));
	    	
	    	if(menuid == null || menuid == ""){
	    		layer.msg("请选中一个节点进行删除");
	    	}else{
	    		//alert(menuid)
	    		$.ajax({
	    			url:"QXS?action=dlqx",
	    			data:{"menuid":menuid},
	    			type:"post",
	    			dataType:"json",
	    			success:function(data){
	    				//var info = eval("("+data+")");
	    				if(data == 1){
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
				 authorityId = d.id;
            }));
        	if(authorityId == null || authorityId==""){
        		layer.msg('请选择一个进行修改');
        	}else{
        		layer.open({
              		 type:2,
              		 title:"修改权限",
              		 area:['800px','700px'],
              		 async:false,
              		 content:"qxmjsp/quanxInfo.jsp",
              		 success:function(layero, index){
              			 $.post("QXS?action=qxhx",{"menuid":authorityId},function(data){
              				
              				var info = eval('(' + data + ')')
              				var body = layui.layer.getChildFrame('body', index);
              				body.find("#mid").val(info.data[0].id);
              				var id=info.data[0].id;
              				body.find("#mname").val(info.data[0].qxname);  //权限名
              				body.find("#mfunction").val(info.data[0].url);	//请求路径
              				var select = 'dd[lay-value='+info.data[0].type+']';
              				body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
              				body.find("#mbtn").val(info.data[0].buttom);		//按钮代码
              				var menuid3 = info.data[0].mfatherid;
              				//上级的下拉框
                 			 $.post("QXS?action=xgqxpd",{"id":menuid3},function(res){
                 				
             					var cs = eval('(' + res + ')');
             					//console.log(cs);
             					/*alert(cs.data[0].mfatherid);*/
//             					alert(cs.data.mfatherid);
             					//alert(JSON.stringify(cs.data))
             					 body.find("#fatherType2").val(cs.data[0].qxname);

             					
                 			 })
                 			 
              			 })
                	}
          	    })
        	}
        };
});