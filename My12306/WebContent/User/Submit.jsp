<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>购票系统</title>
<link rel="stylesheet" href="../css/Admin_main.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../css/Admin_main.css">
<script src="../bootstrap/js/jquery.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/admin.js"></script>
<script src="../js/order.js"></script>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column" id="mainContent">
				<table class="table table-condensed table-bordered">
					<caption>车次信息</caption>
					<tr style="position: absolute; z-index: 2; left: 10px; top: 0px">
						<div style="position: relative;">
							<img src="../picture/2.jpg" width="1140" height="140" />
						</div>
					</tr>
					<tr>
						</th>
						<th class="col-md-1.5 column">车次</th>
						<th class="col-md-1.5 column">出发站</th>
						<th class="col-md-1.5 column">到达站</th>
						<th class="col-md-1.5 column">出发日期</th>
						<th class="col-md-1.5 column">出发时间</th>
						<th class="col-md-1.5 column">到达时间</th>
						<th class="col-md-1.5 column">历时</th>
						<th class="col-md-1.5 column">票价</th>
					</tr>
					<tbody>
							<tr>								
								<td><c:out value="${data.train.train_number}" /></td>
								<td><c:out value="${data.train.fromplace}" /></td>
								<td><c:out value="${data.train.toplace}" /></td>
								<td><c:out value="${data.train.date}" /></td>
								<td><c:out value="${data.train.begin}" /></td>
								<td><c:out value="${data.train.end}" /></td>
								<td><c:out value="${data.train.duration}" /></td>
								<td><c:out value="${data.train.price}" /></td>
							</tr>
					</tbody>
				</table>
				<table class="table table-condensed table-bordered">
					<caption>请选择需要购票的乘客</caption>	
					<tr>
						</th>
						<th class="col-md-1.5 column">选择</th>
						<th class="col-md-1.5 column">姓名</th>
						<th class="col-md-1.5 column">性别</th>
						<th class="col-md-1.5 column">證件類型</th>
						<th class="col-md-1.5 column">證件號碼</th>
					</tr>
					<tbody>
						<c:forEach items="${data.users}" var="s" varStatus="s1">
							<tr>
								<td><input type="checkbox" name="sOid" id="sOid" value="${s.id}"/></td>
								<td><c:out value="${s.realname}" /></td>
								<td>
									<c:if test='${s.sex ne "2"}'>							
										<c:out value="男"/>
									</c:if>
									<c:if test='${s.sex ne "1"}'>							
										<c:out value="女"/>
									</c:if>
								</td>
								<td><c:out value="${s.cert_type.content}" /></td>
								<td><c:out value="${s.cert}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="margin-left:550px;margin-top:50px">
	<button type="button" class="btn btn-default"style="background: orange;color:white" id="cancelBtn" name="cancelBtn">上一步</button>
	<button type="button" class="btn btn-default"style="background: orange;color:white" id="subOrder" name="subOrder">提交訂單</button>
	</div>
</body>
</html>