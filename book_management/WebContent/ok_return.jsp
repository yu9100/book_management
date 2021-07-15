<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Dvd"%>
    <%
    List<Dvd> dvdlist = (List<Dvd>)request.getAttribute("DVDLIST");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>返却完了<br>
レンタルしている残りのDVD一覧</p><br>
<%if(dvdlist.isEmpty()){ %>
	<p>なし</p>
<%}else{ %>
	<%for(Dvd dvd : dvdlist){ %>
		<%if(dvd.getFlg() == 1){ %>
			<p><%= dvd.getName() %></p><br>
		<%} %>
	<%} %>
<%} %><br>
<a href="index.html">トップへ戻る</a>
</body>
</html>