<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="client" scope="request"
             class="dovlyash.bsuir.data.entity.Client" />
<link  rel="stylesheet" type="text/css" href="css/form.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post">
            <c:forEach items="${clientList}" var="client"
	varStatus="counter">
            <input type="hidden" value="${client.id}" name="idClient"/>
            <p><b>Ваш профиль:</b><br></p><p>
            <b>ФИО(или компания): </b><br><input type ="text" name="clName" value="${client.name}" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9]{1,45}$"><br>
            <b>Телефон (в формате 000-00-00): </b><br><input type="text" name="clPhone" value="${client.phone}" required="required" pattern="\d{3}[\-]\d{2}[\-]\d{2}"><br>
            <b>eMail: </b><br><input type=text name="clMail" value="${client.email.split("@")[0]}" required="required" pattern="^[a-zA-Z0-9_]{1,35}$"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="@gmail.ru">@gmail.ru</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <b>Логин: </b><br><input type="text" name="clLogin" value="${client.login}" required="required" pattern="^[a-zA-Z][a-zA-Z0-9-_]{1,15}$"><br>
            <b>Пароль: </b><br><input type="password" name="clPassword" required="required" pattern="[a-zA-Z0-9]{6,15}$"><br></p>
        </c:forEach>
            <button class="but" type="submit" value="updateClient" name="command">Сохранить</button>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">На главную</button>
        </form>
    </body>
</html>
