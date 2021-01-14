<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>
</head>
<body bgcolor = "#323859">
<div>
</div>
<a href="<%= request.getContextPath()%>/Main"><img src="<%= request.getContextPath()%>/img/Phongle-2.png" height="90px"  alt="image"/></a>
<br>
<br>
<br>
<br>
<br>

<div align='center'>
<form action='${requestUri}' method='get'>
<input type='text' name='keyword' placeholder = 'keyword' style="width:160px;height:30px;border:0px none;border-radius:8px;border-top-right-radius:0px;border-bottom-right-radius:0px;font-size:15px"/><input type='submit' value='submit' style="width:60px;height:32px;border:0px none;background-color:#F0D9AD;font-size:15px;border-radius:8px;border-top-left-radius:0px;border-bottom-left-radius:0px;font-position:center" />
</form>
</div>

</body>
</html>