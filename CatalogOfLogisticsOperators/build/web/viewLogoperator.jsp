<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="logoperator" scope="request"
             class="dovlyash.bsuir.data.entity.Logoperator" />
<jsp:useBean id="logoperatorService" scope="request"
             class="dovlyash.bsuir.data.entity.LogoperatorService" />
<jsp:useBean id="client" scope="request"
             class="dovlyash.bsuir.data.entity.Client" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Каталог</title>
        <link rel="stylesheet" type="text/css" href="css/viewLogoperator.css">
    </head>
    <body>
        <form class="search_form" action="ApplicationServlet" method="post">
            <p><b>Поиск компании: </b><input type="text" name="logName">
                <select name="serviceSelect" size=1>
                    <option value="all">all</option>
                    <option value="Автомобильная">Автомобильная</option>
                    <option value="Железнодорожная">Железнодорожная</option>
                    <option value="Авиа">Авиа</option>
                    <option value="Морская">Морская</option>
                    <option value="Автосервис">Автосервис</option>
                    <option value="Страхование">Страхование</option>
                    <option value="Логистический консалтинг">Логистический консалтинг</option>
                    <option value="Оптовая торговля">Оптовая торговля</option>
                    <option value="Таможенные склады">Таможенные склады</option>
                    <option value="Экспедирование">Экспедирование</option>
                </select>
                <button class="but" type="submit" value="findLogoperator" name="command"><b>Найти</b></button> 
                <button class="but" type="button" onclick="location.href = 'index.jsp'"><b>На главную</b></button></p>
        </form>
        <table border="1">
            <tr><td>Название</td><td>Адрес</td><td>Телефон</td><td>Email</td><td>Контактное лицо</td><td>Описание</td><td>Оказываемые услуги</td></tr>
            <c:forEach items="${logoperatorList}" var="logoperator"
                       varStatus="counter">
                <tr>
                    <td><p><b>${logoperator.name}</b></p></td>
                    <td><p>${logoperator.adress}</p></td>
                    <td><p>${logoperator.phone}</p></td>
                    <td><p>${logoperator.email}</p></td>
                    <td><p>${logoperator.contactName}</p></td>
                    <td><p>${logoperator.description}</p></td><td><p>
                            <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                       varStatus="counter">
                                <c:if test="${logoperator.id==logoperatorService.logoperator.id}">  
                                    ${logoperatorService.service.name}<br>
                                </c:if>
                            </c:forEach>
                        </p></td>
                        <c:if test="${clientId!=0 && not empty clientId}"> 
                        <td><p><form action="ApplicationServlet" method="post">
                                <input type="hidden" value="${logoperator.id}" name="idLogoperator"/>
                                <input type="hidden" value="${clientId}" name="idClient"/>
                                <button class="but" type="submit" value="openRequestPage" name="command"><b>Оставить заявку</b></button>
                                <button class="but" type="submit" value="viewRecall" name="command"><b>Отзывы</b></button><br>
                            </form>
                            </p></td>
                        </c:if>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
