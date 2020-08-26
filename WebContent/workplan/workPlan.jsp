<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">



</head>

<body leftmargin="0" topmargin="0">


	<form action="/jdbcdemo/SaveAct" method="post">
		<div align="center">

			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="38">
						<div align="center">
							添加工作计划<font size="3"> </font> <font size="3"> </font>
						</div>
						<div align="center"></div>
					</td>
				</tr>
			</table>
			<div></div>
			<table class="" width="780" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="100%"><table width="100%" border="0"
							cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
							<tr>
								<td bgcolor="#FFFFFF"><table width="100%" border="0"
										cellpadding="0" cellspacing="1" bgcolor="#999999">
										<tr>
											<td height="6" bgcolor="#D3E3F5"><img
												src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/a666nniu020.jpg"
												width="1" height="1"></td>
										</tr>
									</table>
									<table width="100%" border="0" cellpadding="2" cellspacing="1"
										bgcolor="#CCCCCC">
										<tr bgcolor="EEF2FD">
											<td width="22%" bgcolor="EEF2FD"><div align="center"></div></td>
											<td height="23"><div align="center"></div>
												<div align="center"></div>
												<div align="center"></div>
												<div align="center"></div></td>
										</tr>
										<tr bgcolor="#FFFFFF">
											<td><div align="right">活动名称:</div></td>
											<td height="23"><input type="text" name="actname"></td>
										</tr>
										
										<tr bgcolor="#FFFFFF">
											<td><div align="right">活动开始时间:</div></td>
											<td height="23"><input type="text" name="acttime" 
												onFocus="calendar()"></td>
										</tr>
										<tr bgcolor="#FFFFFF">
											<td><div align="right">活动结束时间:</div></td>
											<td height="23"><input type="text" name="endtime" 
												onFocus="calendar()"></td>
										</tr>
										<tr bgcolor="#FFFFFF">

											<td><div align="right">活动人:</div></td>

											<td height="23"><input name="empname" type="text" 
												size="15"></td>

										</tr>
										<tr bgcolor="#FFFFFF">
											<td><div align="right">活动内容:</div></td>
											<td height="185"><textarea name="actbody" cols="40"
													rows="10"></textarea></td>
										</tr>
									</table></td>
							</tr>
						</table></td>
					<td width="4" valign="top"
						background="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg6.jpg"><img
						src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg7.jpg"
						width="4" height="6"></td>
				</tr>
				<tr>
					<td
						background="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg5.jpg"><img
						src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg3.jpg"
						width="6" height="4"></td>
					<td><img
						src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg4.jpg"
						width="4" height="4"></td>
				</tr>
			</table>
			<p>
				<input type="submit" value="提交"> &nbsp;&nbsp;&nbsp;&nbsp; <input
					type="reset" name="Submit2" value="重置">
			</p>
		</div>
	</form>
</body>
</html>
