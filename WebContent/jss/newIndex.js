$(function(){
	// **用户管理页面的各按钮**
	
	var umAddBtn = $("#umAddBtn");
	// var usernameObj = $("#username");
    // 管理页面中“添加”按钮的单击事件
	umAddBtn.click(function() {
		// 在div中装载页面
		$("#mainContent").load("userAdd.jsp");
	});

	var umDelBtn = $("#umDelBtn");
	umDelBtn.click(function() {
		 var ids = [];
		 $('input[name="sUid"]:checked').each(function(){
		 	ids.push($(this).val());
		 });
		 if (ids.length == 0) {
		 	alert("请选择至少一条记录");
		 } else{
		 	if (confirm("确定删除" + ids +"号" + ids.length + "条记录")) {
		 		alert("aaaa");
		 		doDel(ids);
		 	} else{
		 		$('input[name = "sUid"]').attr("checked",false);

		 	}
		 };	 
	});

	function doDel(ids){
		$.ajax({
			type : 'post',
			url : 'admin?action=del',
			data : {
				ids_del : ids.toString()
			},
			dataType : 'json',                
			success : function(data) {
				  if (data.flag == "yes") {
				  	alert("删除成功!");
				  	doRefresh();
				  } else{
				  	alert("删除失败!");
				  };
			},
			error : function() {
				alert("删除异常");
			}
		});
	}

	 function doRefresh(){  
	   window.location.href = "admin?action=show";
	  }
    
    var umUpdBtn = $("#umUpdBtn");
	umUpdBtn.click(function() {
		 var ids = [];
		 $('input[name="sUid"]:checked').each(function(){
		 	ids.push($(this).val());
		 });
		 if (ids.length != 1) {
		 	alert("请选择一条记录");
		 } else{
		 	 window.location.href = "admin?action=findAndPush&id=" + ids[0];
		 };	 
	});

});