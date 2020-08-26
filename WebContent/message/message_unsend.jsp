<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>草稿箱</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF
}
-->
</style>
</head>

<body>
	<center>
		<p>草稿箱</p>
		<form action="" method="post">
			<p>
				接收人姓名： <input type="text" name="name" /> <input name="button"
					type="submit" value="查询" />
			</p>
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
										<th width="237" height="20">标题</th>
										<th width="159">收件人</th>
										<th width="245">保存时间</th>
										<th width="145">操作</th>
									</tr>
									<c:forEach var="msg" items="${msgs }">
										<tr>
											<td><a href="Message_Read?msgid=${msg.msgid }">${msg.header }</a></td>
											<td>${msg.receivername }</td>
											<td>${msg.sendtime }</td>
											<td><div align="left">
													<a class="cmdField"></a><a
														href="Message_Delete?msgid=${msg.msgid }"
														onclick="return confirm('确定要删除吗？');">删除</a>
												</div></td>
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
