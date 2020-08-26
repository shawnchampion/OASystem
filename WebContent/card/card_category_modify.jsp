<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="../css/style.css"  rel="stylesheet" type="text/css">
<script>
	function reset(){
		var name = document.querySelector("#name");
		name.value = "";
	}
</script>

</head>

<body>
<table width="780">
<tr>
  <td align="center">修改名片分类</td>
</tr>
</table>
<table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="100%" ><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
            <tr> 
              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
                  <tr> 
                    <td height="6"   bgcolor="#D3E3F5" ><img src="../image/a666nniu020.jpg" width="1" height="1"></td>
                  </tr>
                </table>
                <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <form action="Card_Category_Update" method="post">
                  <input name="ccid" value="${cc.ccid }" hidden>
                  <tr bgcolor="#FFFFFF"> 
                    <td width="41%"><div align="right">原分类名：</div></td>
                    <td width="59%"><input type = "text" value = "${cc.name }" disabled></td>
                  </tr>
                  <tr bgcolor="#FFFFFF"> 
                    <td><div align="right">修改名：</div></td>
                    <td><input type="text" id="name" name="name"></td>
                  </tr>
                  <tr bgcolor="#FFFFFF"> 
                    <td colspan="2" align="center"><input type="submit" value="修改"><input type="button" value="重置" onclick="reset();"></td>
                  </tr>
                  </form>
                </table></td>
            </tr>
          </table></td>
        <td width="4" valign="top" background="../image/danghangbg6.jpg"><img src="../image/danghangbg7.jpg" width="4" height="6"></td>
      </tr>
      <tr> 
        <td background="../image/danghangbg5.jpg"><img src="../image/danghangbg3.jpg" width="6" height="4"></td>
        <td><img src="../image/danghangbg4.jpg" width="4" height="4"></td>
      </tr>
    </table>
</body>
</html>
