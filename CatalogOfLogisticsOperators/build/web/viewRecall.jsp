<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="logoperator" scope="request"
             class="dovlyash.bsuir.data.entity.Logoperator" />
<jsp:useBean id="recall" scope="request"
             class="dovlyash.bsuir.data.entity.Recall" />
<jsp:useBean id="client" scope="request"
             class="dovlyash.bsuir.data.entity.Client" />
<jsp:useBean id="mark" scope="request"
             class="dovlyash.bsuir.data.entity.Mark" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="css/form.css">
        <title>Отзывы</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post" name="recalls">
            <input type="hidden" value="${clientId}" name="idClient"/>
            <input type="hidden" value="${logoperatorId}" name="idLogoperator"/>
            <c:if test="${empty recallList}">
                <p>
                    У данного логоператора пока нет отзывов.
                </p>
            </c:if>
            <c:if test="${not empty recallList}">
                <c:forEach items="${recallList}" var="recall"
                           varStatus="counter">
                    <p><b>${recall.client.login}:</b>
                        <c:forEach items="${markList}" var="mark"
                                   varStatus="counter">
                            <c:if test="${recall.client.id == mark.client.id}"> 
                                Оценка: ${mark.value}.
                            </c:if>
                        </c:forEach>
                        ${recall.text}</p>
                    </c:forEach>
                </c:if>
            Оцените работу логоператора: <select name="markSelect" size=1>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            <button class="but" type="submit" value="addMark" name="command">Оценить</button><br>
            <b>Оставьте Ваш отзыв: </b><br>
            <textarea name="recallText" rows="10" cols="60"></textarea><br>
            <p><button class="but" type="submit" value="addRecall" name="command">Добавить</button></p>
        </form>
        <form action="ApplicationServlet" method="post" name="back">
            <p><button class="but" type="submit" value="viewLogoperator" name="command">Назад</button></p>
        </form>
    </body>
</html>
