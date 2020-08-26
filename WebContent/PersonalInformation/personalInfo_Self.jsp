<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>

<script>
	//alert("${userid}");

	function edit() {
		//alert(" ");
		//取消只读属性
		var rs = document.querySelectorAll("input[readonly]");
		for (var i = 1; i < rs.length; i++) {
			rs[i].readOnly = false;
		}
		var introduction = document.querySelector("#introduction");
		introduction.readOnly = false;
		//修改按钮显示
		var submit = document.querySelector("#submit");
		submit.hidden = false;
		var cancel = document.querySelector("#cancel");
		cancel.hidden = false;
		var edit = document.querySelector("#edit");
		edit.hidden = true;
	}
	function cancel() {
		location.reload(true);
	}
	function formSubmit() {
		//alert("");
		var form = document.querySelector("#form");
		form.submit();
	}
</script>
</head>

<body>
	<div align="center">
		<form id="form" method="post"
			action="<%=request.getContextPath()%>/PersonalInfo_Edit">
			<table width="780" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="100%">
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="B1BCEC">
							<tr>
								<td bgcolor="#FFFFFF">
									<table width="100%" border="0" cellpadding="0" cellspacing="1"
										bgcolor="#999999">
										<tr>
											<td height="6" bgcolor="#D3E3F5"><img
												src="../image/a666nniu020.jpg" width="1" height="1"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<table width="780" style="border-collapse: collapse" border="1">
				<tr bgcolor="EEF2FD">
					<td colspan="4"><div align="center">个人信息查询--本人信息</div></td>
				</tr>
				<tr>
					<td width="92" align="left">员工号:</td>
					<td colspan="3" align="left"><span class="STYLE1"></span><span
						class="STYLE1"></span><span class="STYLE1"> <label>
								<input name="id" type="text" value="${emp.empid }" size="60"
								readonly />
						</label>
					</span></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td align="left">姓名：</td>
					<td width="232" align="left"><label> <input
							name="name" type="text" value="${emp.name }" readonly />
					</label></td>
					<td width="106" align="left">性别：</td>
					<td width="226" align="left"><label> <input name="sex"
							type="text" value="${emp.sex }" readonly />
					</label></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td align="left">所属部门：</td>
					<td align="left"><label> <input name="dept"
							type="text" value="${emp.dept }" readonly />
					</label></td>
					<td align="left">年龄：</td>
					<td align="left"><label> <input name="age" type="text"
							value="${emp.age }" readonly />
					</label></td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td align="left">电子邮件：</td>
					<td align="left"><label> <input name="email"
							type="text" value="${emp.email }" readonly />
					</label></td>
					<td align="left">职位：</td>
					<td align="left"><label> <input name="pos" type="text"
							value="${emp.pos }" readonly />
					</label></td>
				</tr>
				<tr>
					<td align="left">办公电话：</td>
					<td align="left"><label> <input name="phone"
							type="text" value="${emp.phone }" readonly />
					</label></td>
					<td align="left">移动电话：</td>
					<td align="left"><label> <input name="telephone"
							type="text" value="${emp.telephone }" readonly />
					</label></td>
				</tr>
				<tr>
					<td align="left">住址：</td>
					<td align="left"><label> <input name="address"
							type="text" value="${emp.address }" readonly />
					</label></td>
					<td align="left">系统角色：</td>
					<td align="left"><label> <input name="role"
							type="text" value="${sessionScope.role }" readonly />
					</label></td>
				</tr>
				<tr>
					<td align="left">兴趣爱好：</td>
					<td colspan="3" align="left"><span class="STYLE1"></span><span
						class="STYLE1"></span> <input name="hobby" type="text"
						value="${emp.hobby }" size="60" readonly /></td>
				</tr>
				<tr>
					<td align="left">个人介绍：</td>
					<td colspan="3" align="left"><span class="STYLE1"></span><span
						class="STYLE1"></span><span class="STYLE1"> <label></label>
							<textarea id="introduction" name="introduction" cols="60" rows="10" readonly>${emp.introduction } </textarea>
					</span></td>
				</tr>
			</table>

		</form>
		<button id="submit" hidden="true" onclick="formSubmit()">提交</button>
		<button id="cancel" hidden="true" onclick="cancel()">取消</button>
		<button id="edit" onclick="edit()">修改</button>
		<!-- <a href="personalInfo_Xiu.html">修改</a></div> -->
	</div>
	<script>
	if ("${userid}" != "${sessionScope.userid}"){
		//alert("访问他人个人界面，隐藏编辑按钮");
		var edit = document.querySelector("#edit");
		edit.hidden = true;
	}
	</script>
</body>
</html>
