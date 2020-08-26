<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA协同办公系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">

</head>
<body leftmargin="0" topmargin="0">
	<div align="center">
		
			<p>
			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%"><table width="100%" border="0"
							cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
							<tr>
								<td bgcolor="#FFFFFF"><table width="100%" border="0"
										cellpadding="0" cellspacing="1" bgcolor="#999999">
										<tr>
											<td height="6" bgcolor="#D3E3F5"><img
												src="../image/a666nniu020.jpg" width="1" height="1"></td>
										</tr>
									</table></td>
							</tr>
						</table></td>
				</tr>
			</table>
			<table width="780" style="border-collapse: collapse" border="1">
				<tr bgcolor="EEF2FD">
					<td height="38">
						<div align="center">
							个人名片夹<font size="3"> </font> <font size="3"> </font>
						</div>
						<div align="center"></div>
					</td>
				</tr>
				<tr>
					<td height="32">
						<div align="left">
						<form name="form1" method="post" 
			action="Card_Box">
							<label> <input type="button" value="添加我的名片"
								onClick="window.location.replace('Card_New')">
							</label><label>类别名称：</label><label>
							<select name="ccname">
								<option>全部</option>
								<c:forEach var="category" items="${categories }">
									<option value="${category.name}" <c:if test="${category.name==ccname }">selected</c:if>>${category.name }</option>
								</c:forEach>
							</select>
							</label><label>名字：</label> <input name="name" type="text" value="${name }">
							<input type="submit" value="查询">
								</form>
						</div>
					</td>
				</tr>
			</table>
			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr bgcolor="#FFFFFF">
					<td>
						<table width="780" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="8"></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="1" cellpadding="0" cellspacing="0">

							<tr>
								<th scope="row">分类名称</th>
								<th><strong>名字</strong></th>
								<th colspan="2"><strong>操作</strong></th>
							</tr>
							<c:forEach var="card" items="${cards}">
								<tr bgcolor="#FFFFFF">
									<td scope="row" align="center">${card.ccname }</td>
									<td align="center">${card.name }</td>
									<td align="center"><a href="Card_Info?cid=${card.cid }">详细信息</a></td>
									<td align="center"><a href="Card_Delete?cid=${card.cid }" onclick="return confirm('确定要删除吗？');">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
			</table>
	
	</div>

</body>

</html>
