$(function(){
	var usernameObj = $("#username");
	var uCheck = $("#uCheck");

	usernameObj.blur(function() {
		$.ajax({// 验证用户名是否存在
			type : 'post',
			url : '../register?action=check',
			data : {
				username : usernameObj.val()
			},
			dataType : 'json',
			success : function(data) {
				if (data.flag == "yes") {
					uCheck.html("此用户名已被占用，请重新选择用户名！").css({
						color : "red"
					});
					usernameObj.focus();
				} else {
					uCheck.html("此用户名可以注册！").css({
						color : "blue"
					});
				}
			},
			error : function() {
				alert("注册异常");
			}
		});
	});
    
    var provinceObj = $("#province");
    var city = $("#city");
    provinceObj.change(function (){
    	// alert("aaaa");
    	 $.ajax({
			type : 'post',
			url : '../register?action=findCity',
			data : {
				provinceid : provinceObj.val()
			},
			dataType : 'json',         
            
			success : function(data) {
				 $("#city").html("");
				 var cityList = data.data;
				 var s = '';
				 for(var i = 0; i < cityList.length; i++){
				 	s += '<option value = '  + cityList[i].id + '>' + cityList[i].city +'</option>' ;
				 }

				 $("#city").append(s);
			},
			error : function() {
				alert("省市联动异常");
			}
		});
         
    });
    //增加用户
     var uSaveBtn = $("#uSaveBtn");
     var uId = $("#uId");
     uSaveBtn.click(function(){
     	if(uId.val() == 0){
     		doAdd();
        }
        else{
        	doUpdate();
        }
     });

     function doAdd(){
     	$.ajax({
			type : 'post',
			url : 'admin?action=add',
			data : {
				username : usernameObj.val(),
				realname : $("#realname").val(),
				rule : $("#rule").val(),
				sex : $("#sex").val(),
				city : $("#city").val(),
				cert_type : $("#certType").val(),
				cert : $("#cert").val(),
				birthday : $("#birthday").val(),
				user_type : $("#userType").val(),
				content : $("#content").val()
			},
			dataType : 'json',
			success : function(data) {
				  if(data.flag == "yes"){
				  	
				  	doRefresh();
				  }
			},
			error : function() {
				alert("error");
			}
		});
     }

     function doUpdate(){
     	$.ajax({
			type : 'post',
			url : 'admin?action=update',
			data : {
				id : uId.val(),
				username : usernameObj.val(),
				realname : $("#realname").val(),
				rule : $("#rule").val(),
				sex : $("#sex").val(),
				city : $("#city").val(),
				cert_type : $("#certType").val(),
				cert : $("#cert").val(),
				birthday : $("#birthday").val(),
				user_type : $("#userType").val(),
				content : $("#content").val()
			},
			dataType : 'json',
			success : function(data) {
				  if(data.flag == "yes"){
				  	alert("修改成功")
				  	doRefresh();
				  }
			},
			error : function() {
				alert("修改异常");
			}
		});
     }

	  function doRefresh(){
	  	alert("刷新");
	    window.location.href = "admin?action=show";
	  }
});