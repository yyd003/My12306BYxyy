$(function(){
	// **用户管理页面的各按钮**
	
	var umAddBtn = $("#umAddBtn");
    // 管理页面中“添加”按钮的单击事件
	umAddBtn.click(function() {
		// 在div中装载页面
		$("#mainContent").load("userAdd.jsp");
	});
});