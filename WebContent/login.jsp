<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript">

if ("${loginResult}" == "fail"){
	alert("账号或密码错误!");
}
//alert("${loginResult}");

function _login() { //v3.0
	if(document.form.userid.value == ""){
		alert("账号不能为空");
		return false;
	}else if(document.form.pass.value == ""){
		alert("密码不能为空");
		return false;
	/*
	}else{
		if(document.form1.role[0].checked){
		    document.form1.action="staff.htm";
			document.form1.submit();
			//window.location = "staff.htm";
			return true;
		}else if(document.form1.role[1].checked){
			//window.location = "leader.htm";
			document.form1.action="leader.htm";
			document.form1.submit();
			return true;
		}else{
			//window.location = "admin.htm";
			document.form1.action="admin.htm";
			document.form1.submit();
			return true;
		}
		*/
	}
	
}

</script>
<style type="text/css">
<!--
.style2 {color: #000000; font-size: 18px;}
.style6 {font-size: 14px}
-->
</style>
</head>

<body>
<table width="1000" height="607" border="0"  bgcolor="#ADADAD">
  <tr>
    <td valign="top" height="377" ><embed  src="flash/main_movie1.swf" width="100%" height="115%"></embed></td>
  </tr>
  <tr>
    <td height="78">
    <div align="center" class="style1">
      <form name = "form" action="LoginServlet" method="post" onSubmit="return _login();">
      
      	<input name="role" type="radio" value="职员" checked>职员
	  	<input name="role" type="radio" value="领导">领导
      	<input name="role" type="radio" value="管理员">管理员<br>
      	账号<input type="text" name="userid" height="18" value="${sessionScope.userid }"><br>
      	密码<input type="password" name="pass" height="18"><br>
      	<input name="Submit" type="submit" value="登录">
      </form>
	</div>
	</td>
  </tr>
</table>
</body>
</html>
