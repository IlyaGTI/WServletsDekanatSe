<%-- 
    Document   : editds
    Created on : 27 мая 2021 г., 21:24:14
    Author     : break
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Измения данных о дисциплине</title>
<style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Измения данных дисцилины</h3>
<form method="post">
<input type="hidden" value="${dis.id}" name="iddiscip" />
<label>Фамилия</label><br>
<input name="SurName" value="${dis.surname}" /><br><br>
<label>Фамилия</label><br>
<input name="SurName" value="${dis.surname}" /><br><br>
<label>Фамилия</label><br>
<input name="SurName" value="${dis.surname}" /><br><br>
<label>Часы</label><br>
<input name="hour" value="${dis.hour}"/><br><br>
<input type="submit" value="Принять изменения" />
</form>
</body>
</html>