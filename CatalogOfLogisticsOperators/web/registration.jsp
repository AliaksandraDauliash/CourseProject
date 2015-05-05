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
        <form action="ApplicationServlet" method="get" enctype="multipart/form-data">
            <table>
            <p><b>Заполните форму:</b><br>
            <b>ФИО(или компания): <input type ="text" name="clName"><br>
            <b>Телефон: </b></b><input type="text" name="clPhone"><br>
            <b>eMail: </b><input type=text name="clMail"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="gmail.ru">gmail.ru</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <b>Логин: </b><input type="text" name="clLogin"><br>
            <b>Пароль: </b><input type="password" name="clPassword"><br>
            <b>Повторите пароль: </b><input type="password" name="clPasswordRepeat"></p><br>
            <button class="but" type="submit" value="addClient" name="command">Сохранить</button>
            <button type="reset">Сброс</button>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">Отмена</button>
        </form>
    </body>
</html>
