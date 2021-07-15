<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,beans.Genre"
	%>
	<%
	List <Genre> list = (List <Genre>)request.getAttribute("LIST");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(list.isEmpty()){%>
	<p>登録されていません</p>
<% }else{ %>
<table>
	<tr>
		<th>ID</th>
		<th>ジャンル名</th>
	</tr>
	<% for(Genre genre : list){ %>
		<tr>
			<td><%= genre.getId() %></td>
			<td><%= genre.getName() %></td>
		</tr>
	<%} %>
<%} %>
</table>
<a href="index.html">トップへ戻る</a>
</body>
</html>