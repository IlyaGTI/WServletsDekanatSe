<%-- 
    Document   : editoc
    Created on : 1 июн. 2021 г., 19:32:41
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
<h3>Измениt данных</h3>
<form method="post">
<input type="hidden" value="${oc.id}" name="idocenki" />
<label>Фамилия</label><br>
<input name="SurName" value="${oc.surname}" /><br><br>
<label>Група</label><br>
<input name="NameGr" value="${oc.namegr}"/><br><br>
<label>Предмет</label><br>
<input name="discips" value="${oc.namedis}"/><br><br>
<label>Оценка</label><br>
<input name="ocenka" value="${oc.mark}"/><br><br>
<input type="submit" value="Принять изменения" />
</form>
</body>
</html>
