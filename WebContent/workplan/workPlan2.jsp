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
	<form action="UpdateWorkplan" method="post">
		<div align="center">
			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="38">
						<div align="center">
							�����ƻ�<font size="3"> </font> <font size="3"> </font>
						</div>
						<div align="center"></div>
					</td>
				</tr>
			</table>
			<div></div>
			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%"><table width="100%" border="0"
							cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
							<tr>
								<td bgcolor="#FFFFFF"><table width="100%" border="0"
										cellpadding="0" cellspacing="1" bgcolor="#999999">
										<tr>
											<td height="6" bgcolor="#D3E3F5"><img
												src="<%=request.getContextPath()%>/image/a666nniu020.jpg"
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
										<td><div align="right">���ţ�</div></td>
                    <td height="23"><input name="actid" type="text" value="${act.actid}" readonly="readonly"   ></td>
											 <tr bgcolor="#FFFFFF">
										<td><div align="right">����ƣ�</div></td>
                    <td height="23"><input name="actname" type="text" value="${act.actname}" ></td>
                  </tr>
				   <tr bgcolor="#FFFFFF">
                    <td><div align="right">���ʼʱ�䣺</div></td>
                    <td height="23"><input name="acttime" type="text" value="${act.acttime}" size="15"></td>
                  </tr>
				   <tr bgcolor="#FFFFFF">
                    <td><div align="right">�����ʱ�䣺</div></td>
                    <td height="23"><input name="endtime" type="text" value="${act.endtime}" size="15"></td>
                  </tr>
				   <tr bgcolor="#FFFFFF">
                    <td><div align="right">��ˣ�</div></td>
                    <td height="23"><input name="empname" type="text" value="${act.empname}" size="15" disabled> </td>
                  </tr> 
				    <tr bgcolor="#FFFFFF">
                    <td><div align="right">�����:</div></td>
                    <td height="185"><textarea name="actbody" cols="40" rows="10" wrap="VIRTUAL" >${act.actbody}</textarea></td>
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
				<input  type="submit"
					 value="�ύ">
				&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="Submit2"
					value="����"> &nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
					name="Submit3" value="����" onClick="javascript:history.go(-1);">
			</p>
		</div>
	</form>
</body>
</html>