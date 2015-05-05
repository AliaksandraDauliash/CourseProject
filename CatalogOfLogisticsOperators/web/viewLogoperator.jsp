<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="logoperator" scope="request"
             class="dovlyash.bsuir.data.entity.Logoperator" />
<jsp:useBean id="logoperatorService" scope="request"
             class="dovlyash.bsuir.data.entity.LogoperatorService" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="get" enctype="multipart/form-data" name="myform">
            <p><b>Поиск компании: </b></b><input type="text" name="logName">
            <select name="serviceSelect" size=1>
            <option value="all">all</option>
            <option value="Avtomobilnaya">Avtomobilnaya</option>
            <option value="Zheleznodorozhnaya">Zheleznodorozhnaya</option>
            <option value="Avia">Avia</option>
            <option value="Morskaya">Morskaya</option>
            <option value="Avtoservice">Avtoservice</option>
            <option value="Strahovanie">Strahovanie</option>
            <option value="Logisticheskii konsulting">Logisticheskii konsulting</option>
            <option value="Optovaya torgovlya">Optovaya torgovlya</option>
            <option value="Tamozhennye sklady">Tamozhennye sklady</option>
            <option value="Ekspedirovanie">Ekspedirovanie</option>
            </select><p><br>
                <button class="but" type="submit" value="findLogoperator" name="command">Найти</button> 
                <button class="but" type="button" onclick="location.href = 'index.jsp'">На главную</button>
        <table border="1">
            <tr><td>Название</td><td>Адрес</td><td>Телефон</td><td>Email</td><td>Контактное лицо</td><td>Описание</td><td>Оказываемые услуги</td></tr>
        <c:forEach items="${logoperatorList}" var="logoperator"
	varStatus="counter">
			<tr>
                <td><p>${logoperator.name}</p></td>
                <td><p>${logoperator.adress}</p></td>
                <td><p>${logoperator.phone}</p></td>
                <td><p>${logoperator.email}</p></td>
                <td><p>${logoperator.contactName}</p></td>
                <td><p>${logoperator.description}</p></td><td><p>
                 <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
	varStatus="counter">
                     <c:if test="${logoperator.id==logoperatorService.logoperator.id}">  
                         ${logoperatorService.service.name}.
                      </c:if>
                 </c:forEach>
			</p></td></tr>
        </c:forEach>
	</table></form>
    </body>
</html>
