 <%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<%--
    Document   : inde
    Created on : 16 мая 2021 г., 19:03:58
    Author     : break
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Студенты</title>
    </head>
    
    <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Список студентов</h2>
        
       
        
       <p><a href ='<c:url value="/indexGlav.jsp" />' class="knopka6" >Вернутся в главное меню</a></p>
        <p><a href ='<c:url value="/Create" />' class="knopka" >Добавить студента</a></p>
  <table border="8">
<tr><th>id</th><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Пол</th><th>Дата Рождения</th><th>Адрес прописки</th><th>Группа</th></tr>
<c:forEach var="std" items="${student}">
    <tr><td>${std.id}</td>
        <td>${std.lastname}</td>
    <td>${std.name}</td>
    <td>${std.surname}</td>
    <td>${std.pol}</td>
    <td>${std.birthdate}</td>
    <td>${std.addres}</td>
    <td>${std.grupa}</td>
    
    <td>
        <a href='<c:url value="/edit?idStudents=${std.id}"  />'>Исправить</a> |
    <form method="post" action='<c:url value="/delete" />'  style="display:inline;">
        <input type="hidden" name="idStudents" value="${std.id}">
        <input type="submit" value="Удалить" >
    </form>
    </td>
    </tr>
    </c:forEach>
    
    
</table>
 
            
            
            
        </form>
    </body>
</html>
