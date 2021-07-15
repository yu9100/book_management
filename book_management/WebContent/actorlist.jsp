<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,beans.Actor"
    %>
	<%
	List <Actor> list = (List <Actor>)request.getAttribute("LIST");
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
		<th>出演者名</th>
	</tr>
	<% for(Actor actor : list){ %>
		<tr>
			<td><%= actor.getId() %></td>
			<td><%= actor.getName() %></td>
		</tr>
	<%} %>
<%} %>
</table>
<a href="index.html">トップへ戻る</a>
</body>
</html>