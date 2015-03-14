<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un IP</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/include/css/style.css"/>" />
    </head>
    <body>
        <c:import url="/include/menu.jsp" />
        <br>
        <form method="post" action="<c:url value="/addip"/>">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez ajouter une IP via ce formulaire.</p>

                <label for="adresseip">Adresse ip <span class="requis">*</span></label>
                <input type="text" id="ip" name="ip" size="20" maxlength="60" />
                <br />

                <label for="description">Description <span class="requis">*</span></label>
                <textarea name="description" id="description"></textarea>                  
                <br />

                <input type="submit" value="Ajouter" class="sansLabel" />

            </fieldset>
        </form>
    </body>
</html>