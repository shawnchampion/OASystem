<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<title>无标题文档</title>
<!-- TemplateParam name="OptionalRegion1" type="boolean" value="true" -->
</head>
<body>
	<form action="<%=request.getContextPath()%>/Card_Category_New" method="post">
		<table width="780">
			<tr>
				<td align="center">新建名片分类</td>
			</tr>
		</table>
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
								</table>
								<table width="100%" border="0" cellpadding="2" cellspacing="1"
									bgcolor="#CCCCCC">
									<tr bgcolor="#FFFFFF">
										<td width="46%"><div align="right">名称</div></td>
										<td width="54%"><div align="left">
												<input type="text" name="ccname">
											</div></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
				<td width="4" valign="top" background="../image/danghangbg6.jpg"><img
					src="../image/danghangbg7.jpg" width="4" height="6"></td>
			</tr>
			<tr>
				<td background="../image/danghangbg5.jpg"><img
					src="../image/danghangbg3.jpg" width="6" height="4"></td>
				<td><img src="../image/danghangbg4.jpg" width="4" height="4"></td>
			</tr>
		</table>
		<table width="780">
			<tr>
				<td align="center"><input type="submit" value="提交"> <input
					type="reset" value="重置" onClick="window.location.reload(true);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
