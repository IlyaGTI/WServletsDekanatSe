<%-- 
    Document   : edituse
    Created on : 4 июн. 2021 г., 22:20:10
    Author     : break
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<h3>Измения данных</h3>
<form method="post">
<input type="hidden" value="${us.id}" name="idusers" />
<label>Логин</label><br>
<input name="userName" value="${us.username}" /><br><br>
<label>Пароль</label><br>
<input name="password" value="${us.password}"/><br><br>
<input type="submit" value="Принять изменения" />
</form>
</body>
</html>
