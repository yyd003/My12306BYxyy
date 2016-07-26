var req = false;
function processRequest(){
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	}else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if (req) {
		var url = "register?action=check";
		req.open("post",url,false);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		var username = document.getElementById("username").value;
		req.onreadystatechange = updatePage;
		req.send("username="+username);
	}

}

function updatePage(){
	if(req.readyState == 4){
		if (req.status == 200) {
			var res = req.responseText;
			if (res == 1) {
				document.getElementById("res").innerHTML = "可以使用";

			}else {
				document.getElementById("res").innerHTML = "已经被使用";
				document.getElementById("username").focus();
			}
		}
	}
}