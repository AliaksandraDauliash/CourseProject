<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link  rel="stylesheet" type="text/css" href="css/form.css">
        <link  rel="stylesheet" type="text/css" href="css/addLogoperator.css">
        <title>Добавить компанию</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post" id="add_form" class="add">
            <p><b>Введите информацию о компании:</b><br></p><p>
                <b>Название: </b><br><input type ="text" name="logName" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9\ ]{1,25}$" value="${name}"><br>
            <b>Адрес: </b><br><input type ="text" name="logAdress" required="required" pattern="^[а-яА-ЯёЁ0-9-.\, ]{1,30}$" value="${adress}"><br>
            <b>Телефон(в формате 000-00-00): </b><br><input type="text" name="logPhone" required="required" pattern="\d{3}[\-]\d{2}[\-]\d{2}" value="${phone}"><br>
            <b>eMail: </b><br><input type=text name="logMail" required="required" pattern="^[a-zA-Z0-9_]{1,35}$" value="${email}"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="@gmail.com">@gmail.com</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <b>Вид предоставляемых услуг:</b><br>
            <input type="checkbox" name="logService" value="Автомобильная">Автомобильная<br>
            <input type="checkbox" name="logService" value="Железнодорожная">Железнодорожная<br>
            <input type="checkbox" name="logService" value="Авиа">Авиа<br>
            <input type="checkbox" name="logService" value="Морская">Морская<br>
            <input type="checkbox" name="logService" value="Автосервис">Автосервис<br>
            <input type="checkbox" name="logService" value="Страхование">Страхование<br>
            <input type="checkbox" name="logService" value="Логистический консалтинг">Логистический консалтинг<br>
            <input type="checkbox" name="logService" value="Оптовая торговля">Оптовая торговля<br>
            <input type="checkbox" name="logService" value="Таможенные склады">Таможенные склады<br>
            <input type="checkbox" name="logService" value="Экспедирование">Экспедирование<br>
            <b>Контактное лицо: </b><br><input type ="text" value="${contact}" name="logContactName" required="required" pattern="^[а-яА-ЯёЁ- ]{1,45}$"><br>
            <b>Описание: </b><br><textarea name="logDescription" rows="8" cols="40" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9_.,!? -]{1,200}$">${description}</textarea><br>
            <c:if test="${flag=='true'}">
                <font color="red">Данный логин уже существует!</font><br>
            </c:if>
            <b>Логин: </b><br><input type="text" name="logLogin" required="required" pattern="^[a-zA-Z][a-zA-Z0-9-_]{1,15}$"><br>
            <b>Пароль (минимум 6 символов): </b><br><input type="password" name="logPassword" required="required" pattern="[a-zA-Z0-9]{6,15}$"><br>
           </p>
            <button class="but" type="submit" value="addLogoperator" name="command">Сохранить</button>
            <button type="reset">Сброс</button>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">Отмена</button>
        </form>
        <div class="add">
            <img src="picktures/addLogoperator.jpg" width="720px" height="480px">
        </div>
    </body>
</html>
