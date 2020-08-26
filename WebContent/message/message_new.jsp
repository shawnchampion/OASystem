<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form id="form" name="form" method="post" action="<%=request.getContextPath()%>/Message_New">
		<div align="center">
			<p>发送留言</p>
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
					<td width="121" height="29"><div align="right">收件人员工号：</div></td>
					<td width="483">
						<div align="left">
							<label> <input name="receiverid" type="text" size="40" />
								<span class="STYLE1">*</span>（内容不能为空）
							</label>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="28"><div align="right">收件人姓名：</div></td>
					<td>
						<div align="left">
							<label> <input name="receivername" type="text" size="40" />
								<span class="STYLE1">*</span>（内容不能为空）
							</label>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="29"><div align="right">标题：</div></td>
					<td>
						<div align="left">
							<label> <input name="header" type="text" size="40" /> <span
								class="STYLE1">*</span>（内容不能为空）
							</label>
						</div>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td><div align="right">内容：</div></td>
					<td>
						<div align="left">
							<label> <textarea name="content" cols="50" rows="10"></textarea>
							</label>
						</div>
					</td>
				</tr>

			<tr bgcolor="#FFFFFF">
				<td colspan="2"><label> <input type="submit"
						name="button" value="发送" /> <input type="submit" name="button"
						value="存草稿" /> <input type="reset" name="Submit3" value="重写"
						onclick="window.location.reload(true);" />
				</label></td>
			</tr>
			</table>
			<p></p>
		</div>
	</form>
	<label></label>
</body>
</html>
