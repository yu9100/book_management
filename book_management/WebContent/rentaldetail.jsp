<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Rental,beans.Dvd"%>
    <%
    List<Rental> rentallist = (List<Rental>)request.getAttribute("RENTALLIST");
    List<Dvd> dvdlist = (List<Dvd>)request.getAttribute("DVDLIST");
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
	<p>貸出番号<%= rentallist.get(0).getId() %></p>
	<p>貸出日時<%= rentallist.get(0).getDate() %></p>
	<p>貸出相手<%= rentallist.get(0).getFriend() %></p>
	<%for(Dvd dvd : dvdlist){ %>
		<p><%= dvd.getName() %>
			<%if(dvd.getFlg() == 0){ %>
				返却済
			<%}else{ %>
				貸出中
			<%} %></p>
	<%} %>
<%} %>
<a href="index.html">トップへ戻る</a>
</body>
</html>