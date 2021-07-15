<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Friend,beans.Dvd"%>
    <%
    List<Friend> friendlist = (List<Friend>)request.getAttribute("FRIENDLIST");
    List<Dvd> dvdlist = (List<Dvd>)request.getAttribute("DVDLIST");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(friendlist.isEmpty()){ %>
	<p>友人を登録してください</p>
<%}else if(dvdlist.isEmpty()){ %>
	<p>DVDを登録してないか、全てのDVDを貸出ています</p>
<%}else{ %>
	<form action="./RentalServlet" method="post">
	友人
	<select name="friend">
	<%for(Friend friend : friendlist){ %>
		<option value="<%= friend.getId() %>"><%= friend.getName() %>
	<%} %>
	</select><br>
	DVD
	<%for(Dvd dvd : dvdlist){ %>
		<input type="checkbox" name="dvd" value="<%= dvd.getId() %>"><%= dvd.getName() %>
	<%} %><br>
	<button type="submit">登録</button>
	</form>
<%} %>
<a href="index.html">トップへ戻る</a>
</body>
</html>