<%-- 
    Document   : edit
    Created on : 21 мая 2021 г., 18:24:20
    Author     : break
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Измения данных студента</title>
<style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Измения данных студента</h3>
<form method="post">
<input type="hidden" value="${student.id}" name="idStudents" />
<label>Фамилия</label><br>
<input name="LastName" value="${student.lastname}" /><br><br>
<label>Имя</label><br>
<input name="Name" value="${student.name}"/><br><br>
<label>Отчество</label><br>
<input name="SurName" value="${student.surname}"/><br><br>
<label>Пол</label><br>
<input name="Pol" value="${student.pol}"/><br><br>
<label>Дата рождения</label><br>
<input name="BirthDate" value="${student.birthdate}"/><br><br>
<label>Адрес прописки</label><br>
<input name="Addres" value="${student.addres}"/><br><br>
<label>Группа</label><br>
<select name="Grupa" value="${student.grupa}">
<c:forEach var = "gr" items = "${group}">
        <option>${gr.name}</option>
    </c:forEach>
</select>
<br><br>
<input type="submit" value="Принять изменения" />
</form>
</body>
</html>