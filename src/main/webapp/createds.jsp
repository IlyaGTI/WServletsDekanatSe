<%-- 
    Document   : createds
    Created on : 27 мая 2021 г., 21:07:46
    Author     : break
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить предмет</title>
        <style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Новая дисциплину</h3>
<form method="post">
<label>Название дисциплины</label><br>
<input name="namediscip"/><br><br>
<label>Часы</label><br>
<input name="hour"/><br><br>
<input type="submit" value="Сохранить"  />
</form>
    </body>
</html>
