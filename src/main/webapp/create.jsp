<%-- 
    Document   : create
    Created on : 16 мая 2021 г., 17:47:43
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
        <title>Добавить студента</title>
        <style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Новый студент</h3>
<form method="post">
<label>Фамилия</label><br>
<input name="LastName"/><br><br>
<label>Имя</label><br>
<input name="Name"/><br><br>
<label>Отчество</label><br>
<input name="SurName"/><br><br>
<label>Пол</label><br>
<input name="Pol"/><br><br>
<label>Дата Рождения</label><br>
<input name="BirthDate"/><br><br>
<label>Адрес прописки</label><br>
<input name="Addres"/><br><br>
<label>Група</label><br>
<select name="Grupa">
    <c:forEach var = "gr" items = "${group}">
        <option>${gr.name}</option>
    </c:forEach>
</select>
<br><br>

<input type="submit" value="Сохранить"  />
</form>
    </body>
</html>
