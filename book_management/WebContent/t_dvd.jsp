<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,beans.Actor,beans.Genre"%>
    <%
    List<Actor> actorlist = (List<Actor>)request.getAttribute("ACTORLIST");
    List<Genre> genrelist = (List<Genre>)request.getAttribute("GENRELIST");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(actorlist.isEmpty()){ %>
	<p>出演者を登録してください</p>
<%}else if(genrelist.isEmpty()){ %>
	<p>ジャンルを登録してください</p>
<%}else{ %>
	<form action="./DvdServlet" method="post">
	DVD名<input type="text" name="name"><br>
	ジャンル
	<%for(Genre genre : genrelist){ %>
		<input type="checkbox" name="genre" value="<%= genre.getId() %>"><%= genre.getName() %>
	<%} %><br>
	出演者
	<%for(Actor actor : actorlist){ %>
		<input type="checkbox" name="actor" value="<%= actor.getId() %>"><%= actor.getName() %>
	<%} %><br>
	<button type="submit">登録</button>
	</form>
<%} %>
<a href="index.html">トップへ戻る</a>
</body>
</html>