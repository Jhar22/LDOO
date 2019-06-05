<%-- 
    Document   : perdedor
    Created on : 22/05/2019, 03:33:00 AM
    Author     : Jorge
--%>

<%@page import="Modelo.AciertaModelo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/csslab5.css" rel="stylesheet" type="text/css"/>
        <title>¡Casi!</title>
    </head>
    <body id="perdiendo">
        <h1>
            ¡Casi lo logras!
        </h1>
        <% 
            int maximo = 3;
            AciertaModelo modelo = (AciertaModelo) session.getAttribute("aleatorio");
            int intentos = (Integer) session.getAttribute("intentos");
            if(intentos == maximo){
                session.invalidate();
        %>
        <h2>
            Deberías volver a intentarlo, por ahora se te acabaron los intentos.<br> 
            El número correcto era <%=modelo.getRandom()%>.<br>
        <% }else{ %>
        <h2>
            Deberías volver a intentarlo, llevas <%=intentos%>/3 intentos.
        <%}%>
            Suerte para la próxima.
        </h2>
        <a href="index.html">
            Haz click aquí para volver a intentarlo.
        </a>
    </body>
</html>
