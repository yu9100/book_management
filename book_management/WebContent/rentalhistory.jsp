<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Rental"%>
    <%
    List <Rental> rentallist = (List <Rental>)request.getAttribute("RENTALLIST");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(rentallist.isEmpty()){ %>
	<p>履歴が存在しません</p>
<%}else{ %>
	<table>
		<tr>
			<th>貸出番号</th>
			<th>貸出日</th>
			<th>貸出相手</th>
			<th>返却状態</th>
		</tr>
		<%for(Rental rental : rentallist){ %>
			<tr>
				<td><%= rental.getId() %></td>
				<td><%= rental.getDate() %></td>
				<td><%= rental.getFriend() %></td>
				<td><%= rental.getResult() %></td>
			</tr>
		<%} %>
	</table>
<%} %>
<a href="index.html">トップへ戻る</a>
</body>
</html>