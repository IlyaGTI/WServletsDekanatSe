<%-- 
    Document   : Razn2
    Created on : 1 июн. 2021 г., 17:27:27
    Author     : break
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <table border="4">
<tr><th>Група</th><th>Фамилия</th><th>Оценка</th><th>Предемет</th></tr>
<c:forEach var="raz" items="${za}">
    <tr>
        <td>${raz.namegr}</td>
    <td>${raz.surname}</td>
    <td>${raz.ocenka}</td>
     <td>${raz.dis}</td>
    
    
    </td>
    </tr>
    </c:forEach>
</table>
        <h1>Hello World!</h1>
    </body>
</html>
