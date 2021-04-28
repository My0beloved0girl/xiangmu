

layui.extend({
    dtree: '{/}js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    

    /*------------- 加载用户数据 --------------------------------*/

    /*	layui.use(['form','layer','laydate','table','laytpl','dtree'], function(){
    		 var form = layui.form,
    	        layer = parent.layer === undefined ? layui.layer : top.layer,
    	        $ = layui.jquery,
    	        laydate = layui.laydate,
    	        laytpl = layui.laytpl,
    	        table = layui.table;
    	    	var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;*/
    	/*var buttom=$(".buttom").val();
    	alert(buttom); 		*/
    var tableIns = table.render({
        elem: '#newsList',
        url : 'FJN?action=sjzx',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
        	{fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'ygname', title: '真实姓名', minWidth:100, align:"center"},
            {field: 'dlname', title: '登录名',  align:'center'},
            {field: 'bmname', title: '部门', minWidth:100, align:"center"},
            {field: 'zcname', title: '职务',  align:'center'},
            {field: 'jsname', title: '角色', minWidth:100, align:"center"},
            {field: 'sex', title: '用户性别', align:'center',templet:function(d){
                return d.sex == "1" ? "男" : "女";
            }}
        ]]
    });

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function(){
    	var like = $("#likename").val()
    	 tableIns.reload({
	      /*url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,*/
	      url:"http://localhost:8080/Htgl/ZHS?action=sszh&uname="+like,
	      page: {
	        curr: 1 //重新从第 1 页开始
	      }
	    });
    })
    
    
 //工具栏事件
	
 table.on('toolbar(newsList)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    var data = checkStatus.data;
	    var userid = '';
	    for(i=0;i<data.length;i++){
	    	userid = data[i].id;
	    }
	    switch(obj.event){
	      case 'hairMenu':	//分配权限
				if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					hair(userid);
				}
	      break;
	      
	      case 'insUser':	//新增用户
	    	  addUser();
	      break;
	      
	      case 'hairRole':	//分配角色
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					//HairRole(userid);
				}
	      break;
	      
	      case 'uapUser':	//修改用户信息
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{
					upUser(userid);
				}
	      break;
		        
	      case 'delUser':	//删除用户
	    	  if(data.length == 0 || data.length > 1){
					layer.msg("请选择一行数据进行操作")
					return ;
				}else{	
					layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
						var uid=$(".uid").val();
						if(userid == uid){	
							layer.msg("你正在登录当前账号,无法删除")
						}else{
							delUser(userid);
							layer.close(index);
						}
		            });
				}
	      break;
	    };
	  });
  //分配权限
    function hair(userid){
    	//alert(1);
    	layui.layer.open({
    		title : "分配权限",
    		type : 1,
    		content : $("#divdiv"),
    		area:['300px','500px'],
    		
    		success:function(){
    			 //alert(userid);
    		    //给dtree树加载数据
    			dtree.render({
   				  elem: "#database",
   				  url: "/Htgl/FPS?action=fpqx",
   				  dataStyle: "layuiStyle",  //使用layui风格的数据格式
   				  dataFormat: "list",  //配置data的风格为list
   				  response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
   				  checkbar:true,
   				  line: true,  // 显示树线
   				  done: function(res, $ul, first){
   					  $.ajax({
   						  url:"/Htgl/FPS?action=fphx",
   						  type:"post",
   						  data:{"userid":userid},
   						  success:function(res){
   							  var cs = eval('(' + res + ')');
   							  $.each(cs,function(index,row){
   								dtree.chooseDataInit("database",[row.menuid]); // 初始化选中
   							  })
   						  }
   					  })
   		    	  }
    			});
    		},
    		btn:['分配权限'],
    		yes: function(index, layero){
    			//alert(index);
    			//alert(layero);
    			var params = dtree.getCheckbarNodesParam("database");
    			var infos = JSON.stringify(params);
    			var cs = eval('(' + infos + ')');
    			var menuidList = new Array();	//所有选中值的权限id
    			//alert(menuidList.length);
    			$.each(cs,function(index,row){
   					menuidList[index] = row.nodeId;
    			})
    			$.ajax({
    				url:"/Htgl/FPS?action=fpqb",
    				data:{"array":menuidList,"userid":userid},
    				type:"post",
    				traditional:true,
    				success:function(data){
    					if(data !=0){
    						layer.msg("分配成功");
    						layer.close(index)	//关闭
    					}else{
    						layer.msg("分配失败");
    					}
    				}
    			})
    		}
    	})
    }
    
    //修改用户
    function upUser(userid){
    	layui.layer.open({
    		title : "修改用户信息",
    		type : 2,
    		content : "zymjsp/yonghInfo.jsp",
    		area:['400px','540px'],
    		success:function(layero, index){
    			$.ajax({
    				url:"ZHS?action=sezh",
    				type:"post",
    				data:{"userid":userid},
    				success:function(data){	
    					//console.log(data);
    					var info = eval('(' + data + ')');
    					//获取iframe页的DOM
    					
          				var body = layui.layer.getChildFrame('body', index);
          			
          				body.find("#uid").val(info.data[0].id);
    					body.find("#uname2").val(info.data[0].dlname);
    					body.find("#uname").val(info.data[0].dlname);
    					body.find("#password").val(info.data[0].passwd);
    					body.find("#realName").val(info.data[0].ygname);
    					//性别(单选)
    					var sex2 = info.data[0].sex;
    					if(sex2 == 1){
    						body.find("#sex1").prop("checked",true);
    					}else{
    						body.find("#sex2").prop("checked",true);
    					}
    					/*------下拉框赋值--------*/
    					/*$.ajax({
    						  url:"ZHS?action=qbjs",
    						  type:"post",
    						  async:false,
    						  success:function(data){
    							  var info = eval("("+data+")");
    							  var row = info.data;
    							  var role = body.find("#role1");
    							  $.ajax({
    								  url:"ZHS?action=pdjs",	//查询用户是否有角色有返回1,没有返回0
    								  data:{"userid":userid},
    								  type:"post",
    								  async:false,
    								  success:function(data){
    									console.log(data);
    									  if(data == 0){
    										  var html = '<option value="0">无角色</option>';
    									  }else{
    										  var html = '';
    									  }
    	    							  $.each(row,function(index,item){
    	    								  html += '<option value="'+item.id+'">'+item.jsname+'</option>';
    	    							  })
    	    							  role.html(html);
    	    							//获取新窗口对象
    			                        var iframeWindow = layero.find('iframe')[0].contentWindow;
    			                        //重新渲染
    			                        iframeWindow.layui.form.render();
    								  }
    							  })
    							  
    						  }
    					  })*/
    					/*  ------下拉框赋值--------*/
    					//赋值后选中
    					$.ajax({
    						url:"ZHS?action=fzjs",
    						type:"post",
    						data:{"userid":userid},
    						 async:false,
    						success:function(data){ 
    							//console.log(data);
    							//alert(data)
    							var info2 = eval("("+data+")")
    							//alert(data);
    							if(data == 0){
    								var select = 'dd[lay-value="0"]';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}else{
    								//alert(data);
    								var select = 'dd[lay-value='+data+']';
        							body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}
    						}
    					})
    					$.ajax({
    						url:"ZHS?action=fzbm",
    						type:"post",
    						data:{"userid":userid},
    						 async:false,
    						success:function(data){ 
    							//console.log(data);
    							//alert(data)
    							var info2 = eval("("+data+")")
    							//alert(data);
    							if(data == 0){
    								var select = 'dd[lay-value="0"]';
        							body.find("#bm").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}else{
    								//alert(data);
    								var select = 'dd[lay-value='+data+']';
        							body.find("#bm").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}
    						}
    					})
    					$.ajax({
    						url:"ZHS?action=fzzc",
    						type:"post",
    						data:{"userid":userid},
    						 async:false,
    						success:function(data){ 
    							//console.log(data);
    							//alert(data)
    							var info2 = eval("("+data+")")
    							//alert(data);
    							if(data == 0){
    								var select = 'dd[lay-value="0"]';
        							body.find("#zw").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}else{
    								//alert(data);
    								var select = 'dd[lay-value='+data+']';
        							body.find("#zw").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
    							}
    						}
    					})
                        //获取新窗口对象
                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                        //重新渲染
                        iframeWindow.layui.form.render();
    				}
    			})
    		}
    	})
    }
 
 
 
 //删除用户
 function delUser(userid){
 	$.ajax({
 		url:"ZHS?action=dlzh",
 		data:{"userid":userid},
 		type:"post",
 		success:function(data){
 			if(data == 1){
 				layer.msg("删除成功")
 				tableIns.reload("#newsList");
 			}
 		}
 	})
 }
 
 
 //添加用户
 function addUser(){
 	layui.layer.open({
 		title : "添加用户",
 		type : 2,
 		content : "zymjsp/yonghAdd.jsp",
 		area:['400px','540px'],
 	})
 }
 
 
 
 
 
 
 
  })