<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="get" enctype="multipart/form-data">
            <p><b>Введите информацию о компании:</b><br>
            <b>Название: <input type ="text" name="logName"><br>
            <b>Адрес: </b><input type ="text" name="logAdress"><br>
            <b>Телефон: </b></b><input type="text" name="logPhone"><br>
            <b>eMail: </b><input type=text name="logMail"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="gmail.ru">gmail.ru</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <b>Вид предоставляемых услуг:</b><br>
            <input type="checkbox" name="logService" value="Avtomobilnaya">Avtomobilnaya<br>
            <input type="checkbox" name="logService" value="Zheleznodorozhnaya">Zheleznodorozhnaya<br>
            <input type="checkbox" name="logService" value="Avia">Avia<br>
            <input type="checkbox" name="logService" value="Morskaya">Morskaya<br>
            <input type="checkbox" name="logService" value="Avtoservice">Avtoservice<br>
            <input type="checkbox" name="logService" value="Strahovanie">Strahovanie<br>
            <input type="checkbox" name="logService" value="Logisticheskii konsulting">Logisticheskii konsulting<br>
            <input type="checkbox" name="logService" value="Optovaya torgovlya">Optovaya torgovlya<br>
            <input type="checkbox" name="logService" value="Tamozhennye sklady">Tamozhennye sklady<br>
            <input type="checkbox" name="logService" value="Ekspedirovanie">Ekspedirovanie<br>
            <b>Контактное лицо: </b><input type ="text" name="logContactName"><br>
            <b>Описание: </b><textarea name="logDescription"></textarea><br>
            <b>Логин: </b><input type="text" name="logLogin"><br>
            <b>Пароль: </b><input type="password" name="logPassword"><br>
            <b>Повторите пароль: </b><input type="password" name="logPasswordRepeat"></p><br>
            <button class="but" type="submit" value="addLogoperator" name="command">Сохранить</button>
            <button type="reset">Сброс</button></p>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">Отмена</button>
        </form>
    </body>
</html>
