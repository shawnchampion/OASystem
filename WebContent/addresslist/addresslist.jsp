<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>
<script>
	function toPage() {
		var a = document.getElementById("mypage").value;
		//alert(a);
		document.getElementById("ccur").value = a;
		document.form.submit();
	}
	function nextPage() {
		document.getElementById("ccur").value = "${cur + 1}";
		document.form.submit();
	}
	function firstPage() {
		document.getElementById("ccur").value = 1;
		document.form.submit();
	}
	function prePage() {
		document.getElementById("ccur").value = "${cur - 1}";
		document.form.submit();
	}
	function lastPage() {
		document.getElementById("ccur").value = "${total}";
		//alert(document.getElementById("ccur").value);
		document.form.submit();
	}
</script>
</head>

<body>
	<form id="form" name="form" method="post" action="">
		<input id="ccur" name="ccur" hidden></input>
	<div align="center">
		<font color="#333333">公司通讯录</font>
	</div>
	<table width="780" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr bgcolor="EEF2FD">
			<th width="739" scope="row">
			选择查询： <label> <select name="select">
					<option>全部</option>
					<c:forEach var="dept" items="${depts }">
						<option <c:if test="${dept.name==deptname }">selected</c:if>>${dept.name }</option>
					</c:forEach>
					</select></label>
			具体查询条件： 	<label> <input type="text" name="name" value="${name }"/></label>
							<label> <input name="按钮" type="submit" value="查询" /></label>
			</th>
			<th width="275" align="right"><input name="submit2"
				type="submit" value="导出Excel" /></th>
		</tr>
	</table>
	<center>
		<table width="780" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100%"><table width="100%" border="0" cellpadding="0"
						cellspacing="1" bgcolor="B1BCEC">
						<tr>
							<td bgcolor="#FFFFFF"><table width="100%" border="0"
									cellpadding="0" cellspacing="1" bgcolor="#999999">
									<tr>
										<td height="6" bgcolor="#D3E3F5"><img
											src="../image/a666nniu020.jpg" width="1" height="1" /></td>
									</tr>
								</table>
								<table border="1" align="center"
									style="border-collapse: collapse">
									<tr bgcolor="EEF2FD">
										<th width="68" scope="row">员工编号</th>
										<td width="85">姓名</td>
										<td width="35">性别</td>
										<td width="53">年龄</td>
										<td width="70">所属部门</td>
										<td width="71">职位</td>
										<td width="142">电子邮件</td>
										<td width="142">办公电话</td>
										<td width="145">移动电话</td>
										<td width="192">住址</td>
									</tr>
									<c:forEach var="emp" items="${emps }">
										<tr bgcolor="#FFFFFF">
											<th scope="row">${emp.empid }</th>
											<td>${emp.name }</td>
											<td>${emp.sex }</td>
											<td>${emp.age }</td>
											<td>${emp.dept }</td>
											<td>${emp.pos }</td>
											<td>${emp.email }</td>
											<td>${emp.phone }</td>
											<td>${emp.telephone }</td>
											<td>${emp.address }</td>
										</tr>
									</c:forEach>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<p align="center"> 第${cur }页 共${total }页 
			<a href="#" onclick="firstPage();">首页 </a>
			<a href="#" <c:if test="${cur!=1 }">onclick="prePage();"</c:if>>上一页</a>
			<a href="#" <c:if test="${cur!=total }">onclick="nextPage();"</c:if>>下一页</a>
			<a href="#" onclick="lastPage();">尾页</a>
			转至第 <label> <select onchange="toPage();" id="mypage">
					<c:forEach begin="1" end="${total }" var="cu">
					<option value="${cu }" <c:if test="${cu==cur }">selected</c:if>>${cu }</option>
					</c:forEach>
			</select>
			</label> 页
		</p>
	</center>
	</form>
</body>
</html>
