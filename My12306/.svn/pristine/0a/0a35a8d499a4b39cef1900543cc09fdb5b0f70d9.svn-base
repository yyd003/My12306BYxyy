$(function() {
	function doReFresh() {
		window.location.href = "user?action=show";
	}

	// 点击“查看并购票” 按钮
	var uBuyBtn = $("#uBuyBtn");
	uBuyBtn.click(function() {
		window.location.href = "../User/Train.jsp";
	})

	$("#subOrder").click(
		function() {
			var ids = [];
			$('input[name="sOid"]:checked').each(function() {
				ids.push($(this).val());
			});
			if (ids.length == 0) {
				alert("请至少选择一位乘客！");
			} else {
				if (confirm("是否购票？")) {
					window.location.href = "../User/user?action=submitOrder&passengers[]="
							+ ids;
				} else {
					$('input[name="sOid"]').attr("checked", false);
				}
			}
	});
	
	// 点击取消订单按钮
// $("#umDeleteBtn").click(function() {
// var ids = [];
// $('input[name="sUid"]:checked').each(function() {
// ids.push($(this).val());
// });
// if (ids.length == 0) {
// alert("请至少选择一个订单");
// } else {
// if (confirm("此操作不可撤销！ 是否继续？")) {
// doDelete(ids);
// } else {
// $('input[name="sUid"]').attr("checked", false);
// }
// }
// });
// function doDelete(ids) {
// $.ajax({
// type : 'post',
// url : 'user?action=cancel',
// data : {
// ids_d : ids.toString()
// },
// dataType : 'json',
// success : function(data) {
// if (data.flag == "yes") {
// alert("订单取消成功");
// doReFresh();
// } else {
// alert("订单取消异常");
// }
// },
// error : function() {
// alert("异常");
// }
// });
// }

	// 点击提交订单按钮
	$("#umDeleteBtn")
			.click(
					function() {
						var ids = [];
						$('input[name="sODid"]:checked').each(function() {
							ids.push($(this).val());
						});
						if (ids.length == 0) {
							alert("请至少选择一张票！");
						} else {
							if (confirm("是否退票？")) {
								window.location.href = "../User/user?action=deleteDetail&detailsId[]="
										+ ids;
							} else {
								$('input[name="sODid"]').attr("checked", false);
							}
						}
					});
	
// $("#umDeleteBtn").click(function() {
// var ids = [];
// $('input[name="sUid"]:checked').each(function() {
// ids.push($(this).val());
// });
// if (ids.length == 0) {
// alert("请至少选择一条记录");
// } else {
// if (confirm("确定要删除\n" + ids + "\n共" + ids.length + "条记录？")) {
// doDelete(ids);
// } else {
// $('input[name="sUid"]').attr("checked", false);
// }
// }
// });
// function doDelete(ids) {
// $.ajax({
// type : 'post',
// url : 'admin?action=delete',
// data : {
// ids_d : ids.toString()
// },
// dataType : 'json',
// success : function(data) {
// if (data.flag == "yes") {
// alert("数据删除成功");
// doReFresh();
// } else {
// alert("数据删除异常");
// }
// },
// error : function() {
// alert("异常");
// }
// });
// }
	
	$("#cancelBtn").click(function() {
		window.location.href = "../User/Train.jsp";
	});

	var cilckDiv = $('div[name="cilckDiv"]');
	cilckDiv.each(function() {		 
		$(this).click(function() {
			// alert($(this).attr("value"));
			window.location.href = "../User/user?action=showOrderDetail&orderDetailId=" + $(this).attr("value");
		});

	});
	

});