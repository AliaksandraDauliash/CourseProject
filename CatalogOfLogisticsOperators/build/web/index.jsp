<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="css/index.css">
        <title>Главная страница</title>
    </head>
    <body>  
        <header>
            <form id="menu_nav" action="ApplicationServlet" method="post">
            <input type="hidden" value="${clientId}" name="idClient"/>
            <input type="hidden" value="${logoperatorId}" name="idLogoperator"/>
            <ul class="navigation">
                    <c:if test="${not empty clientId && clientId != 0}">
                        <li><a href="javascript:submitForm('viewClientProfile')">Профиль</a></li>
                        <li><a href="javascript:submitForm('viewLogoperator')">Каталог</a> </li>      
                    </c:if> 
                    <c:if test="${(clientId == 0 && logoperatorId==0) || (empty clientId && empty logoperatorId) || (empty clientId && logoperatorId == 0)}"> 
                        <li><a href = 'addLogoperator.jsp'>Добавить логоператора</a></li>
                        <li><a href = 'registration.jsp'>Регистрация</a></li>
                        <li><a href="javascript:submitForm('viewLogoperator')">Каталог</a></li>
                    </c:if>
                    <c:if test="${not empty logoperatorId && logoperatorId != 0}">
                        <li><a href="javascript:submitForm('viewRequest')">Просмотреть заявки</a></li>
                        <li><a href="javascript:submitForm('viewLogoperatorProfile')">Профиль</a></li>
                    </c:if>
                    <c:if test="${(not empty clientId && clientId != 0) || (not empty logoperatorId && logoperatorId != 0)}">
                        <li><a href="javascript:submitForm('logoutClient')">Выйти</a></li>
                    </c:if>
            </ul>
            </form>
        </header>
        <nav>
            <form class="menu_nav" action="ApplicationServlet" method="post">
                <c:if test="${(clientId == 0 && logoperatorId==0) || (empty clientId && empty logoperatorId) || (empty clientId && logoperatorId == 0)}"> 
                    <p>
                        <b>Логин: </b><br><input type=text name='clientLogin'><br>
                        <b>Пароль: </b><br><input type="password" name='clientPassword'><br>
                    </p>
                    <button class='but' type='submit' value='loginClient' name='command'>Войти</button>
                </c:if>
            </form>
        </nav>
        <section>
            <img class="section_image" src="picktures/index.png" >
        </section>
        <aside>
        </aside>      
        <footer>
            <p class="footer_text">
                <b>Логистика - это когда каждый отдел заинтересован не в результате работы своего отдела, а в результате работы компании.<br> 
                    Вот это и есть один из экономических эффектов логистики.  
                </b>
            </p>
        </footer>
    </body>
    <script src="js/index.js"></script>
</html>
