<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:requestEncoding value="UTF-8" />
<jsp:useBean id="logoperatorService" scope="request"
             class="dovlyash.bsuir.data.entity.LogoperatorService" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="css/form.css">
        <title>Оставить заявку</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post" name="make_request">
            <input type="hidden" value="${clientId}" name="idClient"/>
            <input type="hidden" value="${logoperatorId}" name="idLogoperator"/>
            <b>Дата заявки: </b><input type ="text" id="date" name="requestDate" required="required" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])-(0[1-9}|1[012])-[0-9]{4}"><br>
            <b>Наименование груза: </b><input type ="text" name="goodsName" required="required"><br>
            <b>Вес груза (т.): </b><input type ="text" name="goodsWeight" required="required" pattern="\d+\.\d+"><br>
            <b>Объем груза (м3): </b><input type="text" name="goodsVolume" required="required" pattern="\d+\.\d+"><br>
            <select name="serviceSelect" size=1>
                <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                           varStatus="counter">
                    <option value="${logoperatorService.service.name}">${logoperatorService.service.name}</option>  
                </c:forEach>
            </select>
            <p><button class="but" type="submit" value="makeRequest" name="command">Сохранить</button>
            </p>
        </form>
        <form action="ApplicationServlet" method="post">
            <p><button class="but" type="submit" value="viewLogoperator" name="command">Назад</button></p>
        </form>
    </body>
    <script>
        var elem = document.querySelector("#date");
        var d = new Date();
        var curr_date = d.getDate();
        if (curr_date < 10)
            curr_date = "0" + curr_date;
        var curr_month = d.getMonth();
        if (curr_month < 10)
            curr_month = "0" + curr_month;
        var curr_year = d.getFullYear();
        elem.value = curr_date + "-" + curr_month + "-" + curr_year;
    </script>
</html>
