<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
<script>
	//alert("${sessionScope.login}");
	if ("${sessionScope.login}" != "true"){
		alert("请先登录");
		window.location.href="login_index.jsp";
	}
</script>
-->
<title>OA协同办公系统</title>
</head>

<frameset rows="84,*,29" cols="*" frameborder="yes"  border="6" framespacing="6"  style="background-color:#666666" bordercolor="#33CCFF"  >
  <frame src="top_index.htm" name="topFrame" scrolling="NO" noresize frameborder="yes" bordercolor="#3399CC"  >
  <frameset rows="*" cols="199,*" framespacing="0" frameborder="NO" border="0" >
    <frame src="left_staff.htm" name="leftFrame" scrolling="NO" noresize  >
    <frame src="canlender.html" name="mainFrame">

  </frameset>
  <frame src="bottom.htm" name="footFrame" scrolling="no" noresize>
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
