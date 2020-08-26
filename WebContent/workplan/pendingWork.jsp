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
	
	document.myform.cur.value=a;
	document.myform.submit();
}

</script>
</head>

<body leftmargin="0" topmargin="0">

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
                  <td width="10%"><div align="center">工作编号</div></td>
                    <td width="18%" height="23"><div align="center">工作安排</div></td>
                    <td width="15%"><div align="center">工作日期</div></td>
                    <td width="17%"> <div align="center">工作时间</div></td>
                    <td width="17%"><div align="center">安排人</div></td>
                    <td width="14%"><div align="center">操作</div></td>
                    <td width="14%"><div align="center">完成状况</div></td>
                  </tr>
                 
                <c:forEach items="${acts}" var="act">
                <c:if test="${act.finish!=1}">
             	 <tr bgcolor="#FFFFFF">
                    <td><div align="center">${act.actid}</div></td>
                    <td><div align="left"><a href="<%=request.getContextPath()%>/SelectActById?actid=${act.actid}" target="_self">${act.actname}</a></div></td>
                    <td><div align="center">${act.acttime}</div></td>
                    <td> <div align="center">8:30-9:30</div></td>
                    <td><div align="center">${act.empname}</div></td>                                      
                    <td> <div align="center"><input type="button" value="删除" onClick="window.location.href='<%=request.getContextPath()%>/DeleteAct?actid=${act.actid}';"></div></td>
                    <td><div align="center"><input type="button" value="完成" onClick="window.location.href='<%=request.getContextPath()%>/UpdateWorkstase?actid=${act.actid}';"></div></td>
                    
                  </tr>
                  </c:if>
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
   <td align="center">第${cur}页 共${total}页 
							<a href="<%=request.getContextPath()%>/SelectWorkplan?cur=1">首页</a>
							<c:if test="${cur!=1}">
								<a
									href="<%=request.getContextPath()%>/SelectWorkplan?cur=${cur-1}">上一页</a>
							</c:if> <c:if test="${cur==1}">
	 	  上一页
	     </c:if> <c:if test="${cur!=total}">
								
								<a	href="<%=request.getContextPath()%>/SelectWorkplan?cur=${cur+1}">
									 下一页</a>
							</c:if> <c:if test="${cur==total}">
	     下一页
	     </c:if> <a
							href="<%=request.getContextPath()%>/SelectWorkplan?cur=${total}" >尾页</a>
							转至 <select onchange="topage()" id="mypage">
						
								<c:forEach begin="1" end="${total}" var="cu">	
								<option value="${cu}" <c:if test="${cu==cur}">selected</c:if> >${cu}</option>
								</c:forEach>
						</select>

						</td>
   页 　<a href="workplan/workPlan.jsp" target="_self">添加工作安排</a></div>
   
     	<form action="<%=request.getContextPath()%>/SelectWorkplan" name="myform">
	<input type="hidden" name="cur">
	</form>
</body>
</html>
