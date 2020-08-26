<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
	<%@page import="java.util.Calendar"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function topage(){	
	var a=document.getElementById("mypage").value;
	//alert('第'+a+'页');
	document.myform.cur.value=a;
	document.myform.submit();
}

</script>
</head>


<body leftmargin="0" topmargin="0">
<form action="SelectWorkAll2" method="post">
<div align="center"> 
  
    <table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td height="38">  <div align="center"> 待办工作列表<font size="3">
                  </font> <font size="3"> </font></div>
          <div align="center"></div></td>
      </tr>
    </table>
    <table width="780" border="0" cellspacing="0" cellpadding="0">
      <tr> 
        <td width="100%" ><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="B1BCEC">
            <tr> 
              <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
                  <tr> 
                    <td height="6"   bgcolor="#D3E3F5" ><img src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/a666nniu020.jpg" width="1" height="1"></td>
                  </tr>
                </table>
                <table width="100%" border="0" cellpadding="2" cellspacing="1" bgcolor="#CCCCCC">
                  <tr bgcolor="EEF2FD"> 
                    <td width="30%" height="23"><div align="center">工作安排</div></td>
                    <td width="25%"><div align="center">工作日期</div></td>
                    <td width="23%"> <div align="center">工作时间</div></td>
                    <td width="22%"><div align="center">安排人</div></td>
                  </tr>
                 <c:forEach items="${workplans}" var="workplan">
                  <tr bgcolor="#FFFFFF"> 
             	
                    <td><div align="left"><a href="<%=request.getContextPath()%>/SelectWorkplanBywname?workno=${workplan.workno}">${workplan.wname}</a></div></td>
                    <td><div align="center">${workplan.workday}</div></td>
                    <td><div align="center">${workplan.starttime}-${workplan.stoptime}</div></td>
                    <td><div align="center">${workplan.arrid}</div></td>                  
                  </tr>
                  </c:forEach>                  
                </table></td>
            </tr>
          </table></td>
        <td width="4" valign="top"  background="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg6.jpg"><img src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg7.jpg" width="4" height="6"></td>
      </tr>
      <tr> 
        <td background="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg5.jpg"><img src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg3.jpg" width="6" height="4"></td>
        <td><img src="file:///E|/&#26032;&#24314;&#25991;&#20214;&#22841;%20(2)/image/danghangbg4.jpg" width="4" height="4"></td>
      </tr>
    </table>
    
    
		<tr>
			<td align="center">第${cur}页 共${total}页 <a
							href="<%=request.getContextPath()%>/SelectWorkplan?cur=1&&point=0">首页</a>
							<c:if test="${cur!=1}">
								<a
									href="<%=request.getContextPath()%>/SelectWorkplan?cur=${cur-1}&point=0">上一页</a>
							</c:if> <c:if test="${cur==1}">
	 	  上一页
	     </c:if> <c:if test="${cur!=total}">
								<a
									href="<%=request.getContextPath()%>/SelectWorkplan?cur=${cur+1}&point=0"
									 >下一页</a>
							</c:if> <c:if test="${cur==total}">
	     下一页
	     </c:if> <a
							href="<%=request.getContextPath()%>/SelectWorkplan?cur=${total}&point=0" >尾页</a>
							转至 <select onchange="topage()" id="mypage">
						
								<c:forEach begin="1" end="${total}" var="cu">	
								<option value="${cu}" <c:if test="${cu==cur}">selected</c:if> >${cu}</option>
								</c:forEach>
						</select>

						</td>
					</tr> 
   页 　<a href="workplan/workPlan.jsp">继续添加工作安排</a>　</div>
   </form>
   	<form action="<%=request.getContextPath()%>/SelectWorkplan?point=0" name="myform">
	<input type="hidden" name="cur">
	</form>

</body>
</html>
