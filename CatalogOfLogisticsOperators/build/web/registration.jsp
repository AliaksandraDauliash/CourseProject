<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/form.css">
        <title>Регистрация</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post">
            <p><b>Заполните форму:</b></p>
            <p><b>ФИО(или компания): </b><br><input type ="text" name="clName" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9\ ]{1,45}$" value="${name}"><br>
                <b>Телефон (в формате 000-00-00): </b><br><input type="text" name="clPhone" required="required" pattern="\d{3}[\-]\d{2}[\-]\d{2}" value="${phone}"><br>
            <b>eMail: </b><br><input type="text" name="clMail" required="required" pattern="^[a-zA-Z0-9_]{1,35}$" value="${email}"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="@gmail.ru">@gmail.ru</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <c:if test="${flag=='true'}">
                <font color="red">Данный логин уже существует!</font><br>
            </c:if>
            <b>Логин: </b><br><input type="text" name="clLogin" required="required" pattern="^[a-zA-Z][a-zA-Z0-9-_]{1,15}$"><br>
            <b>Пароль (минимум 6 символов): </b><br><input type="password" name="clPassword" required="required" pattern="[a-zA-Z0-9]{6,15}$"></p><br>
            <p><button class="but" type="submit" value="addClient" name="command">Сохранить</button>
            <button type="reset">Сброс</button>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">Отмена</button></p>
        </form>
    </body>
</html>
