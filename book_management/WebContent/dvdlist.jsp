<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,beans.Dvd,beans.Actor,beans.Genre"
	%>
	<%
	List <Dvd> dvdlist = (List <Dvd>)request.getAttribute("DVDLIST");
	List <Actor> actorlist = (List <Actor>)request.getAttribute("ACTORLIST");
	List <Genre> genrelist = (List <Genre>)request.getAttribute("GENRELIST");
	List <Actor> dvdactorlist = (List <Actor>)request.getAttribute("DVDACTORLIST");
	List <Genre> dvdgenrelist = (List <Genre>)request.getAttribute("DVDGENRELIST");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(dvdlist.isEmpty()){ %>
	<p>登録されていません</p>
	<%}else{ %>
		<form action="./DvdServlet" method="get">
		DVD検索<br>タイトル検索<input type="text" name="text">
		<button type="submit" name="type" value="title">検索</button><br>
		<input type="hidden" name="value" value="search">
		</form>
		<form action="./DvdServlet" method="get">
		ジャンル検索
		<select name="text">
		<% for(Genre genre : genrelist){ %>
			<option value="<%= genre.getId() %>"><%= genre.getName() %></option>
		<%}%>
		</select>
		<button type="submit" name="type" value="genre">検索</button><br>
		<input type="hidden" name="value" value="search">
		</form>
		<form action="./DvdServlet" method="get">
		出演者検索
		<select name="text">
		<% for(Actor actor : actorlist){ %>
			<option value="<%= actor.getId() %>"><%= actor.getName() %></option>
		<%}%>
		</select>
		<button type="submit" name="type" value="actor">検索</button><br>
		<input type="hidden" name="value" value="search">
		</form>

		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>genre</th>
				<th>actor</th>
			</tr>
			<%for(Dvd dvd : dvdlist){ %>
				<tr>
					<td><%= dvd.getId() %></td>
					<td><%= dvd.getName() %></td>
					<td>
					<%for(Genre dvdgenre : dvdgenrelist){ %>
						<%if(dvd.getId() == dvdgenre.getId()){ %>
						<%= dvdgenre.getName() %><br>
						<%} %>
					<%} %>
					</td>
					<td>
					<%for(Actor dvdactor : dvdactorlist){ %>
						<%if(dvd.getId() == dvdactor.getId()){ %>
						<%= dvdactor.getName() %><br>
						<%} %>
					<%} %>
					</td>
				</tr>
			<%} %>
	<%} %>
		</table>
<a href="index.html">トップへ戻る</a>
</body>
</html>