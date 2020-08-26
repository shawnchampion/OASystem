<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000
}
-->
</style>
</head>

<body>
	<center>

		<p>未读留言</p>
		<form id="form1" name="form1" method="post" action="">
			<div>
				<p>
					留言人姓名： <input name="name" type="text" /> <input type="button"
						name="Submit2" value="查询" />
				</p>
			</div>
		</form>
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
								<table width="780" style="border-collapse: collapse" border="1">
									<tr bgcolor="EEF2FD">
										<td width="197">标题</td>
										<td width="78">留言人</td>
										<td width="236">留言时间</td>
										<td width="78">状态</td>
										<td width="76">操作</td>
									</tr>
									<c:forEach var="msg" items="${msgs }">
										<tr bgcolor="#FFFFFF">
											<td><a href="Message_Read?msgid=${msg.msgid }">${msg.header }</a></td>
											<td>${msg.sendername }</td>
											<td>${msg.sendtime }</td>
											<td><span class="STYLE1">未读</span></td>
											<td><a href="Message_Delete?msgid=${msg.msgid }"
												onclick="return confirm('确定要删除吗？');">删除</a></td>
										</tr>
									</c:forEach>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</center>
</body>
</html>
