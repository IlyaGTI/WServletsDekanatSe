<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
<%-- 
    Document   : indexuse
    Created on : 4 июн. 2021 г., 22:13:41
    Author     : break
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пользователи</title>
    </head>
    <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
         <h2>Список пользователей</h2>
         <p><a href ='<c:url value="/CreateUse" />' class="knopka" >Добавить пользователя</a></p>
        <p><a href ='<c:url value="/IndexAdmin.jsp" />' class="knopka5" >Вернутся в главное меню</a></p>
         <table border="4">
<tr><th>id</th><th>Логин</th><th>Пароль</th></tr>
<c:forEach var="us" items="${user}">
    <tr><td>${us.id}</td>
        <td>
          ${us.username}
        </td>
    <td>${us.password}</td>
    <td> 
        <a href='<c:url value="/editUse?idusers=${us.id}"  />'>Исправить</a> |
    <form method="post" action='<c:url value="/deleteUse" />'  style="display:inline;">
        <input type="hidden" name="idusers" value="${us.id}">
        <input type="submit" value="Удалить" >
    </form>
        </td>
    </tr>
    </c:forEach>
</table>  
    </body>
</html>
