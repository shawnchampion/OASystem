<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
</head>

<body>
<div align="center">
  <p>留言信息</p>
<table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="100%" ><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
            <tr> 
              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
                  <tr> 
                    <td height="6"   bgcolor="#D3E3F5" ><img src="../image/a666nniu020.jpg" width="1" height="1"></td>
                  </tr>
                </table>
   <table  width="780"style="border-collapse:collapse"  border="1">
    <tr  bgcolor="EEF2FD" >
      <td width="163">发件人</td>
      <td width="185"><form id="form1" name="form1" method="post" action="">
        <label>
          <input name="textfield" type="text" value="${msg.sendername }" readonly/>
          </label>
      </form>      </td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td>收件人</td>
      <td><form id="form2" name="form2" method="post" action="">
        <label>
          <input name="textfield2" type="text" value="${msg.receivername }" readonly/>
          </label>
      </form>      </td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="80">内容</td>
      <td><form id="form3" name="form3" method="post" action="">
        <label>
          <textarea name="textarea" cols="20" rows="10" readonly>${msg.content }</textarea>
          </label>
      </form>      </td>
    </tr>
  </table>
  <form id="form4" name="form4" method="post" action="">
    <label>
     <input type="button" onclick="history.go(-1)" value="返回">
    </label>
  </form>
  <p>&nbsp;  </p>
</div>
</body>

</html>
