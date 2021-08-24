<%-- 
    Document   : IndexAdmin
    Created on : 4 июн. 2021 г., 23:35:17
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
        <title>Деканат</title>
    </head>
    <style><%@include file="/WEB-INF/GlavCss.css"%></style>
    <body>
        <div id = "headerse">
            <img src = "E:\Кыртинки\logo_new.png">
        </div>
        <h2>Главное меню</h2>
        <p><a href ='<c:url value="/Ind" />' class="knopka" >Таблица Студенты</a></p>
        <p><a href ='<c:url value="/IndGr" />' class="knopka2" >Таблица Группы</a></p>
        <p><a href ='<c:url value="/IndDs" />' class="knopka3" >Таблица Дисциплины</a></p>
        <p><a href ='<c:url value="/IndOc" />' class="knopka4" >Успеваемость</a></p>
        <p><a href ='<c:url value="/IndeUse" />' class="admin" >Управление пользователями</a></p>        
    </body>
</html>