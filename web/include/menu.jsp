<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="menu">
    <ul>
        <li><a href="<c:url value="/index.jsp"/>">Accueil</a></li>
        <li><a href="<c:url value="/pages/inscription.jsp"/>">Inscription</a></li>
        <li><a href="<c:url value="/pages/connexion.jsp"/>">Connexion</a></li>
        <li><a href="<c:url value="/deconnexion"/>">Deconnexion</a></li>
        <li><a href="<c:url value="/pages/addip.jsp"/>">Ajouter un IP</a></li>
        <li><a href="<c:url value="/listip"/>">Lister les IP</a></li>
    </ul>
<!--      <ul>
        <li><a href="<c:url value="/index.jsp"/>">Accueil</a></li>
        <li><a href="<c:url value="/adduser"/>">Inscription</a></li>
        <li><a href="<c:url value="/connexion"/>">Connexion</a></li>
        <li><a href="<c:url value="/deconnexion"/>">Deconnexion</a></li>
        <li><a href="<c:url value="/addip"/>">Ajouter un IP</a></li>
        <li><a href="<c:url value="/listip"/>">Lister les IP</a></li>
    </ul>-->
</div>