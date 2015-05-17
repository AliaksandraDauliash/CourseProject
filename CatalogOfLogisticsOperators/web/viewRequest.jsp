<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="requests" scope="request"
             class="dovlyash.bsuir.data.entity.Request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="css/form.css">
        <title>Заявки</title>
    </head>
    <body> 
        <c:if test="${empty requestList}">
            <p><b>У Вас нет заявок</b></p>
        </c:if>
        <c:if test="${not empty requestList}">
            <p><b>Ваши заявки:</b></p>
            <c:forEach items="${requestList}" var="request"
                       varStatus="counter">
                <form action="ApplicationServlet" method="post"><p>
                        <input type="hidden" value="${logoperatorId}" name="idLogoperator"/>
                        <input type="hidden" value="${request.id}" name="idRequest"/>
                        <b>ФИО(или компания):</b> ${request.goods.client.name}<br>
                        <b>Телефон:</b> ${request.goods.client.phone}<br>
                        <b>Email:</b> ${request.goods.client.email}<br>
                        <b>Информация о грузе:</b><br>
                        <b>Наименование:</b> ${request.goods.name}<br>
                        <b>Вес:</b> ${request.goods.weight} т.<br>
                        <b>Объем:</b> ${request.goods.volume} м3<br></p>
                    <button class='but' type='submit' value='deleteRequest' name='command'>Удалить</button>
                </form>
            </c:forEach>
        </c:if>
        <button class="but" type="button" onclick="location.href = 'index.jsp'">На главную</button>
    </body>
</html>
