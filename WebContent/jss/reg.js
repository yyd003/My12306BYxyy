function init(){
	window.location.href = "register?action=show";
}

var province = document.getElementById('province');
var cityObj  = document.getElementById('city');

function getCity() {
	if (window.XMLHttpRequest) {
		req1 = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req1 = new ActiveXObject("Microsoft.XMLHTTP");
	}

	if (req1) {
		var url = "register?action=findCity";
		// POST方式
		req1.open("post", url, false);
		// POST方式需要自己设置http的请求头
		req1.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		var provinceid = document.getElementById("province").value;
		req1.onreadystatechange = getCityData;
		// 有点儿像preparedState,先执行，再传参数
		req1.send("provinceid=" + provinceid);
	}
}


function getCityData() {
	if (req1.readyState == 4) {
		if (req1.status == 200) {
			var jsonStr = req1.responseText;
			if (jsonStr != null) {
				// 将json字符串转换成js数组
				var dataArray = eval("(" + jsonStr + ")").data;
				// 清空city列表
				cityObj.innerHTML = "";
				// 添加city列表
				for (var i = 0; i < dataArray.length; i++) {
					var childOption = document.createElement('option');
					childOption.value = dataArray[i].id;
					childOption.text = dataArray[i].city;
					cityObj.options.add(childOption);
				}
			}
		}
	}
}