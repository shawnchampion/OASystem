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
<script>
	function del(){
		var msg = "确认要删除吗?";
		if (true == confirm(msg)){
			return true;
		}else{
			return false;
		}
	}
	
	function toPage() {
		var a = document.getElementById("mypage").value;
		//alert(a);
		document.getElementById("ccur").value = a;
		document.form.submit();
	}
	function nextPage() {
		document.getElementById("ccur").value = "${cur + 1}";
		document.form.submit();
	}
	function firstPage() {
		document.getElementById("ccur").value = 1;
		document.form.submit();
	}
	function prePage() {
		document.getElementById("ccur").value = "${cur - 1}";
		document.form.submit();
	}
	function lastPage() {
		document.getElementById("ccur").value = "${total}";
		//alert(document.getElementById("ccur").value);
		document.form.submit();
	}
</script>
</head>

<body>
  	<form id="form" name="form" action="" method="post">
		<input id="ccur" name="ccur" hidden ></input>
<table border="0" style="border-collapse:collapse" width="780" background="back2.gif">
<tr>
<td>
<table width="780"style="border-collapse:collapse"  border="0">
  <tr>
    <td><center>
      名片夹分类
    </center>
    </td>
  </tr>
  <tr>
    <td height="29"><a href=card/card_category_new.jsp>新建分类</a></td>
  </tr>
  <tr>
    <td>
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
                    <td width="48%" height="23"><div align="center">分类名称</div></td>
                    <td colspan="2"><div align="center">操作 </div>					  </td>
					</tr>
				<c:forEach var="category" items="${categories}">
                  <tr bgcolor="#FFFFFF"> 
                    <td><center>${category.name}</center></td>
                    <td width="27%"><div align="center"><a href="Card_Category_Modify?ccid=${category.ccid }">修改</a></div></td>
					<td width="25%"><div align="center"><a href="Card_Category_Delete?ccid=${category.ccid }" onclick="return del();">删除</a></div></td>
                  </tr>
                </c:forEach>
                </table></td>
            </tr>
          </table></td>
        <td width="4" valign="top" background="../image/danghangbg6.jpg"><img src="../image/danghangbg7.jpg" width="4" height="6"></td>
      </tr>
      <tr> 
        <td height="4" background="../image/danghangbg5.jpg"><img src="../image/danghangbg3.jpg" width="6" height="4"></td>
        <td><img src="../image/danghangbg4.jpg" width="4" height="4"></td>
      </tr>
    </table>
	</td>
  <tr>
    <td align="center">第${cur }页 共${total }页 
			<a href="#" onclick="firstPage();">首页 </a>
			<a href="#" <c:if test="${cur!=1 }">onclick="prePage();"</c:if>>上一页</a>
			<a href="#" <c:if test="${cur!=total }">onclick="nextPage();"</c:if>>下一页</a>
			<a href="#" onclick="lastPage();">尾页</a>
			转至第 <label> <select onchange="toPage();" id="mypage">
					<c:forEach begin="1" end="${total }" var="cu">
					<option value="${cu }" <c:if test="${cu==cur }">selected</c:if>>${cu }</option>
					</c:forEach>
			</select>
			</label> 页
	</td>
  </tr>
</table>
</td>
</tr>
</table>

	</form>

</body>
</html>
