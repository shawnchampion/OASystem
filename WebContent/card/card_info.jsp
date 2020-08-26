<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OA协同办公系统</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="../js/calendarHMH.js" type="text/javascript"></script>
<style type="text/css">
<!--
.STYLE1 {
	color: #000000;
	font-weight: bold;
}

.STYLE3 {
	color: #000000
}
-->
</style>
<script>
	function buttonEdit(){
		//alert("修改");
		var rs = document.querySelectorAll("input[readonly]");
		for (var i = 0; i < rs.length; i++) {
			rs[i].readOnly = false;
		}
		var movebt = document.querySelector("#move");
		movebt.hidden = true;
		var editbt = document.querySelector("#edit");
		editbt.hidden = true;
		var txtlb = document.querySelector("#txtlb");
		txtlb.hidden = true;
		var selectCate = document.querySelector("#selectCate");
		selectCate.hidden = true;
		var submit = document.querySelector("#confirm");
		submit.hidden = false;
		var cancelbt = document.querySelector("#cancel");
		cancelbt.hidden = false;
	}
</script>
</head>
<h1 align="center">详细信息</h1>
<div align="center">
	<form id="form" name="form" action="Card_Update" method="post">
	<input name="cid" value="${card.cid }" hidden>
		<table width="780" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100%"><table width="100%" border="0" cellpadding="0"
						cellspacing="1" bgcolor="B1BCEC">
						<tr>
							<td bgcolor="#FFFFFF"><table width="100%" border="0"
									cellpadding="0" cellspacing="1" bgcolor="#999999">
									<tr>
										<td height="6" bgcolor="#D3E3F5"><img
											src="../image/a666nniu020.jpg" width="1" height="1"></td>
									</tr>
								</table>
								<table width="780" style="border-collapse: collapse" border="1">
									<tr bgcolor="EEF2FD">
									</tr>

									<tr>
										<td>
											<table width="780" style="border-collapse: collapse"
												border="1">
												<tr bgcolor="EEF2FD">
													<th scope="row">姓名：</th>
													<td align="left"><input type="text" name="name" value="${card.name }" readonly></td>
												</tr>
												<tr>
													<th scope="row">公司：</th>
													<td align="left"><input type="text" name="company" value="${card.company }" readonly></td>
												</tr>
												<tr>
													<th scope="row">职位：</th>
													<td align="left"><input type="text" name="position" value="${card.position }" readonly></td>
												</tr>
												<tr>
													<th scope="row">办公室电话：</th>
													<td align="left"><input type="text" name="phone" value="${card.phone }" readonly></td>
												</tr>
												<tr>
													<th scope="row">手机：</th>
													<td align="left"><input type="text" name="telephone" value="${card.telephone }" readonly></td>
												</tr>
												<tr>
													<th scope="row">电子邮件：</th>
													<td align="left"><input type="text" name="email" value="${card.email }" readonly></td>
												</tr>
											</table>
										</td>
									</tr>

									<tr>
										<td align="center" colspan="2"><label><span
												id="txtlb" class="STYLE1">名片移动至：</span><span class="STYLE3"></span></label>
										<select id="selectCate" name="ccname">
												<c:forEach var="category" items="${categories }">
												<option value="${category.name }" <c:if test="${category.name==card.ccname }">selected</c:if>>${category.name }</option>
												
												</c:forEach>
										</select> <input type="submit" id="move" name="button" value="移动" >
											<input type="button" id="edit" value="修改" onClick="buttonEdit();">
											<input type="submit" id="confirm" name="button" value="提交" hidden>
											<input type="button" id="cancel" value="取消" onClick="window.location.reload();" hidden>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>

</div>

</body>
</html>