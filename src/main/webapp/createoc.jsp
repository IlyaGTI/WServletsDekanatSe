<%-- 
    Document   : createoc
    Created on : 28 мая 2021 г., 21:55:45
    Author     : break
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить успеваемость</title>
        <style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Успеваемость</h3>
<form method="post">
<label>Фамилия</label><br>
<select name="SurName">
    <c:forEach var = "std" items = "${student}">
        <option>${std.lastname}</option>
    </c:forEach>
</select><br><br>
<label>Група</label><br>
<select name="NameGr">
    <c:forEach var = "gr" items = "${group}">
        <option>${gr.name}</option>
    </c:forEach>
</select><br><br>
<label>Предмет</label><br>
<select name="discips">
    <c:forEach var = "dis" items = "${discip}">
        <option>${dis.name}</option>
    </c:forEach>
</select><br><br>
<label>Оценка</label><br>
<input name="ocenka"/><br><br>
<br><br>

<input type="submit" value="Сохранить"  />
</form>
    </body>
</html>
