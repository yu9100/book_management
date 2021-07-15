<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String number = (String)request.getAttribute("NUMBER");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	貸出番号は<%= number %>番です。<br>
	<a href="index.html">トップへ戻る</a>
</body>
</html>