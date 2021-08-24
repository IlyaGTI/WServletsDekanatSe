<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : indegr
    Created on : 27 мая 2021 г., 15:12:15
    Author     : break
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Группы</title>
    </head>
    <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
         <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Список групп</h2>
        <p><a href ='<c:url value="/CreateGr" />' class="knopka" >Добавить групу</a></p>
        <p><a href ='<c:url value="/indexGlav.jsp" />' class="knopka5" >Вернутся в главное меню</a></p>
        
        <table border="4">
<tr><th>id</th><th>Название группы</th><th>Курс</th><th>Семестр</th></tr>
<c:forEach var="gru" items="${group}">
    <tr><td>${gru.id}</td>
        <td><a href='<c:url value="/ZapServ2?idgrupastd=${gru.id}"  />'>${gru.name}</td>
    <td>${gru.kurs}</td>
    <td>${gru.semestr}</td>
    <td>
        <a href='<c:url value="/editGr?idgrupastd=${gru.id}"  />'>Исправить</a> |
    <form method="post" action='<c:url value="/deleteGr" />'  style="display:inline;">
        <input type="hidden" name="idgrupastd" value="${gru.id}">
        <input type="submit" value="Удалить" >
    </form>
        </td>
    </tr>
    </c:forEach>
</table> 
    </body>
</html>
