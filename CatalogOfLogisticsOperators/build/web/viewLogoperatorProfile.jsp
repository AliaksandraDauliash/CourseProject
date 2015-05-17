<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="logoperator" scope="request"
             class="dovlyash.bsuir.data.entity.Logoperator" />
<jsp:useBean id="service" scope="request"
             class="dovlyash.bsuir.data.entity.Service" />
<jsp:useBean id="logoperatorService" scope="request"
             class="dovlyash.bsuir.data.entity.LogoperatorService" />
<link  rel="stylesheet" type="text/css" href="css/form.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Профиль</title>
    </head>
    <body>
        <form action="ApplicationServlet" method="post">
            <c:forEach items="${logoperatorList}" var="logoperator"
	varStatus="counter">
            <input type="hidden" value="${logoperator.id}" name="idLogoperator"/>
            <p><b>Ваш профиль:</b></p>
            <p><b>Название: </b><br><input type ="text" name="logName" value="${logoperator.name}" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9]{1,25}$"><br>
            <b>Адрес: </b><br><input type ="text" name="logAdress" value="${logoperator.adress}" required="required" pattern="^[а-яА-ЯёЁ0-9-.\, ]{1,30}$"><br>
            <b>Телефон: </b><br><input type="text" name="logPhone" value="${logoperator.phone}" required="required" pattern="\d{3}[\-]\d{2}[\-]\d{2}""><br>
            <b>eMail: </b><br><input type=text name="logMail" value="${logoperator.email.split("@")[0]}" required="required" pattern="^[a-zA-Z0-9_]{1,35}$"><select name="mailSelect" size=1>
            <option value="@mail.ru">@mail.ru</option>
            <option value="@inbox.ru">@inbox.ru</option>
            <option value="@bk.ru">@bk.ru</option>
            <option value="@list.ru">@list.ru</option>
            <option value="@gmail.ru">@gmail.ru</option>
            <option value="@yandex.ru">@yandex.ru</option>
            <option value="@tut.by">@tut.by</option>
            </select><br>
            <b>Вид предоставляемых услуг:</b><br>
            <c:forEach items="${serviceList}" var="service"
	varStatus="counter">
                        <c:if test="${service.name.equals('Автомобильная')}"> 
                            <c:set var="count" value="0" />
                                 <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Автомобильная" checked="">Автомобильная<br>
                                     </c:if>
                                  </c:forEach>
                                     <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Автомобильная">Автомобильная<br>
                                    </c:if>
                         </c:if>
                         <c:if test="${service.name.equals('Железнодорожная')}">   
                             <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Железнодорожная" checked="">Железнодорожная<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Железнодорожная">Железнодорожная<br>
                                    </c:if>
                         </c:if>
                                        <c:if test="${service.name.equals('Авиа')}">  
                                            <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Авиа" checked="">Авиа<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Авиа">Авиа<br>
                                    </c:if>
                         </c:if>
                             <c:if test="${service.name.equals('Морская')}">  
                                 <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Морская" checked="">Морская<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Морская">Морская<br>
                                    </c:if>
                         </c:if>
                             <c:if test="${service.name.equals('Автосервис')}">   
                                 <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Автосервис" checked="">Автосервис<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Автосервис">Автосервис<br>
                                    </c:if>
                         </c:if>
                            <c:if test="${service.name.equals('Страхование')}">  
                                <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Страхование" checked="">Страхование<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Страхование">Страхование<br>
                                    </c:if>
                         </c:if>
                             <c:if test="${service.name.equals('Логистический консалтинг')}"> 
                                 <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Логистический консалтинг" checked="">Логистический консалтинг<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Логистический консалтинг">Логистический консалтинг<br>
                                    </c:if>
                         </c:if>
                             <c:if test="${service.name.equals('Оптовая торговля')}"> 
                                 <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Оптовая торговля" checked="">Оптовая торговля<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Оптовая торговля">Оптовая торговля<br>
                                    </c:if>
                         </c:if>
                             <c:if test="${service.name.equals('Таможенные склады')}">   
                                 <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Таможенные склады" checkedТаможенные складыЖелезнодорожная<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Таможенные склады">Таможенные склады<br>
                                    </c:if>
                         </c:if>
                            <c:if test="${service.name.equals('Экспедирование')}"> 
                                <c:set var="count" value="0" />
                             <c:forEach items="${logoperatorServiceList}" var="logoperatorService"
                                            varStatus="counter">
                                     <c:if test="${logoperatorService.service.name.equals(service.name)}">
                                         <c:set var="count" value="1" />
                                         <input type="checkbox" name="logService" value="Экспедирование" checked="">Экспедирование<br>
                                     </c:if>
                                  </c:forEach>
                                    <c:if test="${count=='0'}">
                                        <input type="checkbox" name="logService" value="Экспедирование">Экспедирование<br>
                                    </c:if>
                         </c:if>
                             </c:forEach>
            <b>Контактное лицо: </b><br><input type ="text" name="logContactName" value="${logoperator.contactName}" required="required" pattern="^[а-яА-ЯёЁ- ]{1,45}$"><br>
            <b>Описание: </b><br><textarea name="logDescription" rows="8" cols="40" required="required" pattern="^[а-яА-ЯёЁa-zA-Z0-9_.,!? -]{1,200}$">${logoperator.description} </textarea><br>
            <b>Логин: </b><br><input type="text" name="logLogin" value="${logoperator.login}" required="required" pattern="^[a-zA-Z][a-zA-Z0-9-_]{1,15}$"><br>
            <b>Пароль: </b><br><input type="password" name="logPassword" required="required" pattern="[a-zA-Z0-9]{6,15}$"><br>
            <b>Повторите пароль: </b><br><input type="password" name="logPasswordRepeat"></p><br>
            <p>
        </c:forEach>
            <button class="but" type="submit" value="updateLogoperator" name="command">Сохранить</button>
            <button class="but" type="button" onclick="location.href = 'index.jsp'">На главную</button>
        </form>
    </body>
</html>
