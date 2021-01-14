<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>
<body bgcolor = "#323859">
<a href="<%= request.getContextPath()%>/Main"><img src="<%= request.getContextPath()%>/img/Phongle-2.png" height="90px"  alt="image"/></a>
<div style='background-color: #F5E0E0;border-radius:6px;padding:0px 10px;margin:-8px 0px'>

<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
	<a href='<%= orderList[i][1] %>' style='color: #0424D9'><%= orderList[i][0] %></a><h style="font-size:5px ;color: #8094A6"><%= orderList[i][1] %></h><br><br>
<%
}
%>
</div>
</body>
</html>