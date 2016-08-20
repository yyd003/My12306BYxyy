$(function() {

	var bookBtn = $('button[name="bookBtn"]');
	var myfromplace = $("#myfromplace").val();
	var tofromplace = $("#mytoplace").val();
	var date = $("#mydate").val();
    
   //  $(".a").each(function(){
   //  	$(this).click(function(){
   //  		 // alert("aaa");
   //  		 alert($('button[bookBtn]').val());
   // //  		var a = confirm("确定要预定\n"+) 
   // //  		if (confirm("确定要删除\n" + ids + "\n共" + ids.length + "条记录？")) {
			// // 	doDelete(ids);
			// // } 
   //  	})
   //  });
 
   //  点击预定按钮做出反应
       bookBtn.each(function(){
    	$(this).click(function(){
    		window.location.href="../User/user?action=order&ticketid="+$(this).val();
//    		$.ajax({
//    			type : 'post',
//    			url : '../User/user?action=order',
//    			data : {
//    				ticketid:$(this).val()
//    			},
//    			dataType : 'json',
//    			success : function(data) {
//    				
//    			},
//    			error : function() {
//    				alert("无法跳转至订票页面，请稍后重试");
//    			}
//    		});
    	})
    });
  
	// searchBtn.click(function(){
	// 	alert(myfromplace);
	// 	// alert("haha");
	// 	//window.location.href="../admin?action=show";
	// 	window.location.href="user?action=search&myfromplace="+myfromplace+"&mytoplace="+mytoplace+"&mydate="+mydate;	
 //    })
	// $("#uBuyBtn").click(function(){
	// 	alert("train");
	// 	window.location.href="Train.jsp";
	// });
});