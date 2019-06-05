<%-- 
    Document   : ganador
    Created on : 22/05/2019, 03:32:09 AM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/csslab5.css" rel="stylesheet" type="text/css"/>
        <title>¡Felicidades!</title>
    </head>
    <body id="ganando">
        <h1>
            ¿Qué crees?
        </h1>
        <h2>
            Adivinaste el número que se había generado, debes estar teniendo un gran día.<br>
            Tú existencia aporta a este mundo, gracias por existir "usuario".<br>
        </h2>
        <div>
            ¿Es la primera vez que ganas?
            Este es tu récord: <%Cookie[] allCookies = request.getCookies();
                                 for(Cookie cookie : allCookies){
                                     if(cookie.getName().equals("juegosGanados")){
                                         out.println(cookie.getValue());
                                         break;
                                     }
                                 }
                               %> juego(s) ganado(s).
        </div>
        <h3>
            ¿Qué cuál es tu premio?<br>
            Bueno, da click <a href="perro.jpg">aquí</a> para ver una fotografía interesante...<br>
            También puedes volver a jugar <a href="index.html">aquí</a>
        </h3>
    </body>
</html>
