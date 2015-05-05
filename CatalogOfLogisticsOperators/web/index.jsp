<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="menu" action="ApplicationServlet" method="get" enctype="multipart/form-data">
        <button class="but" type="submit" value="viewLogoperator" name="command">Каталог</button>
        <button class="but" type="button" onclick="location.href = 'addLog.jsp'">Добавить логоператора</button>
        <button class="but" type="button" onclick="location.href = 'registration.jsp'">Регистрация</button>
        <button class="but" type="button" id="login">Войти</button>
        <p><b>Логин: </b><input type=text name='clientLogin'>
        <br><b>Пароль: </b><input type="password" name='clientPassword'><br>
        <button class='but' type='submit' value='loginClient' name='command'>Войти</button>
        <button class='but' type='button' onclick="location.href = 'index.jsp'">Отмена</button></p>
        </form>
    </body>
    <script type="text/javascript" src="js/login.js"></script>
</html>
