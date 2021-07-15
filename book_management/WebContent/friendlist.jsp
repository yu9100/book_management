<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,beans.Friend"
	%>
	<%
	List <Friend> list = (List <Friend>)request.getAttribute("LIST");
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
		<th>友人名</th>
		<th>メールアドレス</th>
	</tr>
	<% for(Friend friend : list){ %>
		<tr>
			<td><%= friend.getId() %></td>
			<td><%= friend.getName() %></td>
			<td><%= friend.getMail() %></td>
		</tr>
	<%} %>
<%} %>
</table>
<a href="index.html">トップへ戻る</a>
</body>
</html>