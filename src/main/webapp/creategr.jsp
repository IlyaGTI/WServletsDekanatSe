<%-- 
    Document   : creategr
    Created on : 27 мая 2021 г., 16:02:47
    Author     : break
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить групу</title>
        <style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Новая группа</h3>
<form method="post">
<label>Название группы</label><br>
<input name="namegrp"/><br><br>
<label>Курс</label><br>
<input name="kurs"/><br><br>
<label>Семестр</label><br>
<input name="semestr"/><br><br>
<input type="submit" value="Сохранить"  />
</form>
    </body>
</html>