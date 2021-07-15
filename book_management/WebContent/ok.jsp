<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
	String message = (String)request.getAttribute("MESSAGE");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= message %>
<a href='index.html'>トップへ戻る</a>
</body>
</html>