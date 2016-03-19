<%-- 
    Document   : index
    Created on : 21 janv. 2015, 21:55:44
    Author     : zakaria.ouhrochan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>page admin</h1>
        <a href="logout">deconnexion</a>

        Utilisateur: <sec:authentication property="principal.username"/>
        
        <ul>
            <sec:authorize ifAllGranted="ROLE_USER">
                <li> utilisateur simple </li>
                </sec:authorize>
                <sec:authorize ifAllGranted="ROLE_ADMIN">
                <li> administrateur </li>
                </sec:authorize>
        </ul>
    </body>
</html>

