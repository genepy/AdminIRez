<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/css/style.css"/>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp" />
        <br>
        <table>
            <tr>
                <td>Ip</td>
                <td>Description</td>
            </tr> 
            <c:forEach items="${ messages }" var="message" varStatus="boucle">
                <tr>
<!--                    <td>
                        <%--<c:out value="${message.ip}" />--%>
                    </td>
                    <td>
                        <%--<c:out value="${message.description}" />--%>
                    </td>-->
                    <td>${ message }</td>
                </tr> 
            </c:forEach>
        </table>
    </body>
</html>