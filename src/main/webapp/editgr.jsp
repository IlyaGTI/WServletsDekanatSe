<%-- 
    Document   : editgr
    Created on : 27 мая 2021 г., 16:25:37
    Author     : break
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Измения данных о группе</title>
<style><%@include file="/WEB-INF/creatstyle.css"%></style>
</head>
<body>
    <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
<h3>Измения данных группы</h3>
<form method="post">
<input type="hidden" value="${gru.id}" name="idgrupastd" />
<label>Название групы</label><br>
<input name="namegrp" value="${gru.name}" /><br><br>
<label>Курс</label><br>
<input name="kurs" value="${gru.kurs}"/><br><br>
<label>Семестр</label><br>
<input name="semestr" value="${gru.semestr}"/><br><br>
<input type="submit" value="Принять изменения" />
</form>
</body>
</html>
