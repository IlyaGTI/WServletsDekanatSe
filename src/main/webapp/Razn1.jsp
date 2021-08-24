<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<%-- 
    Document   : Razn1
    Created on : 30 мая 2021 г., 18:36:38
    Author     : break
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Предмет</title>
    </head>
    <style><%@include file="/WEB-INF/indexstyle.css"%></style>
    <body>
        
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Дисциплина</h2>
        
        <p><a href ='<c:url value="/IndDs" />' class="knopka" >Вернутся к выбору предмета</a></p>
        
        <table border="4">
<tr><th>Предмет</th><th>Фамилия</th><th>Оценка</th><th>Група</th></tr>
<c:forEach var="raz" items="${za}">
    <tr>
        <td>${raz.dis}</td>
    <td>${raz.surname}</td>
    <td>${raz.ocenka}</td>
    <td>${raz.namegr}</td>
    
    
    </td>
    </tr>
    </c:forEach>
</table>
    </body>
</html>
