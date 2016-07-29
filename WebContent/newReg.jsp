<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>注册页面</title>
	<link rel="stylesheet" href="">
</head>
<body>
<form action="register" method="post">
	<div style="position: absolute; z-index: 2; left: 300px; top: 1px"> 
		<table>
			<tr>
				<td width='20%'>登录名:</td>
				<td width='40%'><input type="text" id = "username" required = "true"  autofocus = "true"  onblur="processRequest()" name="username"></td>
				<td width="50%"><font color = red>*</font>
				<span id = "res"> </span>
				<span>由字母、数字、"_"组成，长度为6-30</span>
	        	</td>
	        </tr>
	        <tr>
				<td>密码:</td>
				<td><input type="password" id="psw1" onkeyup="checkStrength()" name="password"></td>
				<td><font color = red>*</font><span id="checkpsw1">不少于6位字符</span></td>	
			</tr><br><br>

	<tr>
		<td>确认密码:</td>
		<td><input type="password" id = "psw2" onblur="checkPassword()" name="password2"></td>
		<td><font color = red>*</font><span id="checkpsw2">请再次输入密码 </span></td>
	</tr>

    <td><font color="red">---详细信息---</font></td>
    <tr>
		<td width='20%'>真实姓名:</td>
		<td width='40%'><input type="text" id = "realname" required = "true" name="realname"></td>
		<td width="50%"><font color = red>*</font><span></span></td>

	</tr>

	<tr>
		<td width="20%" >性别:</td>
		<td width="40%">
			<select name="sex" id="sex">
				<option value="1">男</option>
				<option value="2">女</option>
			 
			</select>
		</td>
		<td><font color = red>*</font></td>
	</tr>
 <!-- 
	<tr>
		<td width='20%'>省份:</td>
		<td width='40%'>
		 <select name="province" id="province" placeholder = "省份" onchange="getCity()">
		 	<c:forEach items="${provinceData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.provinceid}" />">
		 		<c:out value="${s.province}"/>	
		 		</option>
		 	</c:forEach>
		        <option value="省份">省份</option>
			</select>
		   </td>
		<td width="50%"><font color = red>*</font><span></span></td>
	</tr><br><br>

    <tr>
        <td width='20%'>城市</td>
        <td>
          <select name="city" id="city" placeholder = "城市">
				<option value="城市">城市</option>
		  </select>  	
        </td> 
        <td><font color = red>*</font></td>	
    </tr><br><br>
    <tr>
		<td width="20%" >证件类型:</td>
		<td width="40%">
			<select name="cert_type" id="cert_type">
				  
				<c:forEach items="${certTypeData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.ID}" />">
		 		<c:out value="${s.content}"/>	
		 		</option>
		 	</c:forEach>
			</select>
		</td>
		<td><font color = red>*</font></td>
	</tr><br><br>
    
    <tr>
		<td>证件号码</td>
		<td><input type="cert" id = "cert" name="cert"></td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	<tr>
		<td>出生日期</td>
		<td><input type="date" id = "date" name="birthday"></td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	 <tr>
		<td width="20%" >旅客类型:</td>
		<td width="40%">
			<select name="user_type" id="user_type">
            <c:forEach items="${userTypeData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.id}" />">
		 		<c:out value="${s.content}"/>	
		 		</option>
		 	</c:forEach>

			</select>
		</td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	<tr>
		<td>备注:</td>
		<td><textarea name="content" id="content" cols="30" rows="10"></textarea></td>
	</tr><br><br>
	</table>
	<center>
		<table width="40%">
			<tr>	
				<td width="1%"><input type="checkbox" id="readAgree"></td>
				<td width="30%">我已阅读并同意接受<a href="http://www.360doc.com/content/14/1123/07/235269_427314242.shtml">铁路服务中心条款</a></td>
				
			</tr>
		</table>
		<table width="20%">
			<tr>
				<td width="20%"><input type="submit" value="提交" id="submitMess" name="submitMess" ></td>
				<td width="20%"><input type="submit" value="重置" id="repeatMess" name="repeatMess"></td>
				<td></td>
			</tr> -->
		</table>
	</div>
</form>
	<!-- <table width="50%">
	<td>
		<font color="red">---登录信息---</font>
	</td>
	<td >
		<input type="submit" value = "数据初始化"  onclick= "init()"/>
    </td>
    <td>
    	注：标有*处均为必填项<%=request.getSession().getAttribute("userTypeData")%>
    </td>
   
	<tr>
		<td width='20%'>登录名:</td>
		<td width='40%'><input type="text" id = "username" required = "true"  autofocus = "true"  onblur="processRequest()" name="username"></td>
		<td width="50%"><font color = red>*</font>
		<span id = "res"> </span>
		<span>由字母、数字、"_"组成，长度为6-30</span>
		</td>

	</tr><br><br>
	
	<tr>
		<td>密码:</td>
		<td><input type="password" id="psw1" onkeyup="checkStrength()" name="password"></td>
		<td><font color = red>*</font><span id="checkpsw1">不少于6位字符</span></td>	
	</tr><br><br>

	<tr>
		<td>确认密码:</td>
		<td><input type="password" id = "psw2" onblur="checkPassword()" name="password2"></td>
		<td><font color = red>*</font><span id="checkpsw2">请再次输入密码 </span></td>
	</tr>

    <td><font color="red">---详细信息---</font></td>
    <tr>
		<td width='20%'>真实姓名:</td>
		<td width='40%'><input type="text" id = "realname" required = "true" name="realname"></td>
		<td width="50%"><font color = red>*</font><span></span></td>

	</tr><br><br>
	<tr>
		<td width="20%" >性别:</td>
		<td width="40%">
		<!-- <input type="radio" name = "ç·" id = "sexman" checked = "checked">ç·
		<input type="radio" name = "å¥³" id = "sexwoman">å¥³ -->
			<!-- <select name="sex" id="sex">
				<option value="1">男</option>
				<option value="2">女</option>
			<!-- 	<!-- <option value="å¶ä»">å¶ä»</option> -->
			<!-- </select>
		</td>
		<td><font color = red>*</font></td>
	</tr><br><br> 
 
	<tr>
		<td width='20%'>省份:</td>
		<td width='40%'>
		 <select name="province" id="province" placeholder = "省份" onchange="getCity()">
		 	<c:forEach items="${provinceData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.provinceid}" />">
		 		<c:out value="${s.province}"/>	
		 		</option>
		 	</c:forEach>
		        <option value="省份">省份</option>
			</select>
		   </td>
		<td width="50%"><font color = red>*</font><span></span></td>
	</tr><br><br>

    <tr>
        <td width='20%'>城市</td>
        <td>
          <select name="city" id="city" placeholder = "城市">
				<option value="城市">城市</option>
		  </select>  	
        </td> 
        <td><font color = red>*</font></td>	
    </tr><br><br>
    <tr>
		<td width="20%" >证件类型:</td>
		<td width="40%">
		<!-- <input type="radio" name = "ç·" id = "sexman" checked = "checked">ç·
		<input type="radio" name = "å¥³" id = "sexwoman">å¥³ -->
			<!-- <select name="cert_type" id="cert_type">
				<option value="1">二代身份证</option>
				<option value="2">港澳通行证</option>
				<option value="3">台湾通行证</option>
				<option value="4">护照</option> 
				<c:forEach items="${certTypeData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.ID}" />">
		 		<c:out value="${s.content}"/>	
		 		</option>
		 	</c:forEach>
			</select>
		</td>
		<td><font color = red>*</font></td>
	</tr><br><br>
    
    <tr>
		<td>证件号码</td>
		<td><input type="cert" id = "cert" name="cert"></td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	<tr>
		<td>出生日期</td>
		<td><input type="date" id = "date" name="birthday"></td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	 <tr>
		<td width="20%" >旅客类型:</td>
		<td width="40%">
			<select name="user_type" id="user_type">
				<!-- <option value="1">成人</option>
				<option value="2">儿童</option>
				<option value="3">学生</option>
				<option value="4">残疾军人、伤残人民警察</option> 
            <c:forEach items="${userTypeData.data}" var="s" varStatus="s1">
		 		<option value="<c:out value="${s.id}" />">
		 		<c:out value="${s.content}"/>	
		 		</option>
		 	</c:forEach>

			</select>
		</td>
		<td><font color = red>*</font></td>
	</tr><br><br>

	<tr>
		<td>备注:</td>
		<td><textarea name="content" id="content" cols="30" rows="10"></textarea></td>
	</tr><br><br>
	</table>
	<center>
		<table width="40%">
			<tr>	
				<td width="1%"><input type="checkbox" id="readAgree"></td>
				<td width="30%">我已阅读并同意接受<a href="http://www.360doc.com/content/14/1123/07/235269_427314242.shtml">铁路服务中心条款</a></td>
				
			</tr>
		</table>
		<table width="20%">
			<tr>
				<td width="20%"><input type="submit" value="提交" id="submitMess" name="submitMess" ></td>
				<td width="20%"><input type="submit" value="重置" id="repeatMess" name="repeatMess"></td>
				<td></td>
			</tr>
		</table>
	</center> 
   </div> 

</form>
<script  language="javascript" type="text/javascript" src="jss/common.js"></script>
<script  language="javascript" type="text/javascript" src="jss/process.js"></script> 
<script  language="javascript" type="text/javascript" src="jss/reg.js"></script>-->
</body>
</html>