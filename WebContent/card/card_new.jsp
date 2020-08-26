<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/style.css"  rel="stylesheet" type="text/css">
<title>无标题文档</title>
<!-- TemplateParam name="OptionalRegion1" type="boolean" value="true" -->
</head>

<body>
<form id="form" action="Card_Insert" method="post">
<table width="780">
<tr>
<td align="center">
新建名片</td>
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
                  <tr bgcolor="#FFFFFF"> 
                    <td width="46%"><div align="right">姓名</div></td>
                    <td width="54%"><div align="left">
                      <input type="text" name="name" value="${card.name }">
                    </div></td>
				  </tr>
                  <tr bgcolor="#FFFFFF"> 
                    <td><div align="right">公司</div></td>
                    <td width="54%"><div align="left">
                      <input type="text" name="company" value="${card.company }">
                    </div></td>
				  </tr>
                  <tr bgcolor="#FFFFFF">
                    <td align="right">职务</td>
                    <td width="54%"><div align="left">
                      <input type="text" name="position" value="${card.position }">
                    </div></td>
				  </tr>
                  <tr bgcolor="#FFFFFF"> 
                    <td><div align="right">分组</div></td>
                    <td>
                      <div align="left">
                        <select name="ccname">
                        <c:forEach var="cc" items="${ccs }"><option value="${cc.name }">${cc.name }</option></c:forEach>
                        </select>
                      </div></td>
				  </tr>
                  <tr bgcolor="#FFFFFF"> 
                    <td><div align="right">办公电话</div></td>
                    <td><div align="left">
                      <input type="text" name="phone" value="${card.phone }">
                    </div></td>
				  </tr>
                  <tr bgcolor="#FFFFFF">
                    <td><div align="right">移动电话</div></td>
                    <td><div align="left">
                      <input type="text" name="telephone" value="${card.telephone }">
                    </div></td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
                    <td><div align="right">电子邮件</div></td>
                    <td><div align="left">
                    <input type="text" name="email" value="${card.email }"></div></td>
                  </tr>
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
<table width="780">
<tr>
<td align="center">
<input type="submit" value="提交">
<input type="reset" value="重置" onClick="window.location.replace('Card_New')">
</td>
</tr>
</table>
</form>
</body>
</html>
