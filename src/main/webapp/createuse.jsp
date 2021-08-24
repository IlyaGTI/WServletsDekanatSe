<%-- 
    Document   : createuse
    Created on : 4 июн. 2021 г., 22:27:08
    Author     : break
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить пользователя</title>
        <style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
    </div>
<h3>Новый пользоваетль</h3>
<form method="post">
<label>Логин</label><br>
<input name="userName"/><br><br>
<label>Пароль</label><br>
<input name="password"/><br><br>
<input type="submit" value="Сохранить"  />
</form>
    </body>
</html>