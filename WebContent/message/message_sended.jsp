<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
</head>

<body>
	<form action="" method="post">
		<p align="center">发件箱</p>
		<p align="center">
			接收人姓名： <input type="text" name="name" /> <input type="submit"
				value="查询" />
		</p>
	</form>
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
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<table width="780" style="border-collapse: collapse" border="1">
			<tr bgcolor="EEF2FD">
				<td width="56%"><div align="center">标题</div></td>
				<td width="11%"><div align="center">收件人</div></td>
				<td width="23%"><div align="center">发送时间</div></td>
				<td width="10%"><div align="center">操作</div></td>
			</tr>
			<c:forEach var="msg" items="${msgs }">
				<tr bgcolor="#FFFFFF">
					<td><a href="yifasong.html">${msg.header }</a></td>
					<td><div align="center">${msg.receivername }</div></td>
					<td><div align="center">${msg.sendtime }</div></td>
					<td><div align="center">
							<a class="cmdField"></a><a
								href="Message_Delete?msgid=${msg.msgid }"
								onclick="return confirm('确定要删除吗？');">删除</a>
						</div></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>
