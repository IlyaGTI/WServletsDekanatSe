<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : indeds
    Created on : 27 мая 2021 г., 20:53:14
    Author     : break
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Дисциплины</title>
    </head>
    <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Список дисциплин</h2>
        <p><a href ='<c:url value="/CreateDs" />' class="knopka" >Добавить предмет</a></p>
        <p><a href ='<c:url value="/indexGlav.jsp" />' class="knopka5" >Вернутся в главное меню</a></p>
        
        <table border="4">
<tr><th>id</th><th>Название дисциплины</th><th>Количество часов</th></tr>
<c:forEach var="dis" items="${discip}">
    <tr><td>${dis.id}</td>
        <td>
          <a href='<c:url value="/RazServ?iddiscip=${dis.id}"  />'>${dis.name}</a> 
        </td>
    <td>${dis.hour}</td>
    <td> 
        <a href='<c:url value="/EditDs?iddiscip=${dis.id}"  />'>Исправить</a> |
    <form method="post" action='<c:url value="/deleteDs" />'  style="display:inline;">
        <input type="hidden" name="iddiscip" value="${dis.id}">
        <input type="submit" value="Удалить" >
    </form>
        </td>
    </tr>
    </c:forEach>
</table> 
    </body>
</html>
