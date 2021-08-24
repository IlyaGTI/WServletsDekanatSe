
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : indeoc
    Created on : 28 мая 2021 г., 21:49:04
    Author     : break
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Успеваемость</title>
    </head>
     <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Успеваемость студентов</h2>
        <p><a href ='<c:url value="/CreateOc" />' class="knopka" >Добавить</a></p>
        <p><a href ='<c:url value="/indexGlav.jsp" />' class="knopka5" >Вернутся в главное меню</a></p>
        
        <table border="5">
<tr><th>Фамилия</th><th>Група</th><th>Предмет</th><th>Оценка</th></tr>
<c:forEach var="oc" items="${ocenki}">
    <tr><td>${oc.surname}</td>
        <td>${oc.namegr}</td>
    <td><a href='<c:url value="/RazServ?discip = ${oc.namedis}"  />'> ${oc.namedis}</td>
    <td>${oc.mark}</td>
    <td>  <a href='<c:url value="/EditOcServ?idocenki=${oc.id}"  />'>Исправить</a> |
    <form method="post" action='<c:url value="/deleteOc" />'  style="display:inline;">
        <input type="hidden" name="idocenki" value="${oc.id}">
        <input type="submit" value="Удалить" >
    </form></td>
    </tr>
    </c:forEach>
</table> 
        
    </body>
</html>
