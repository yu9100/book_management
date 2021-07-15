<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,beans.Dvd"%>
    <%
    List<Dvd> dvdlist = (List <Dvd>)request.getAttribute("DVDLIST");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(dvdlist.isEmpty()){ %>
	<p>その番号は存在していません</p>
<%}else{ %>
	<form action="./ReturnServlet" method="post">
	レンタルしているDVD一覧<br>
	<%for(Dvd dvd : dvdlist){ %>
		<%if(dvd.getFlg() == 1){ %>
			<input type="checkbox" name="dvd" value="<%= dvd.getDvdId() %>"><%= dvd.getName() %>
		<%} %>
	<%} %>
	<input type="hidden" name="id" value="<%= dvdlist.get(0).getId() %>">
	<button type="submit">返却</button>
	</form>
<%} %>
<a href="index.html">トップへ戻る</a>
</body>
</html>