<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Práctica 4</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <ul>
            <li>
                <b>
                    Sitio con MVC Spring - Práctica 4
                </b>
            </li>
	</ul>
        <form action="Practica4.jsp" method="POST">
            Nombres:
            <input type="text" value="Jorge Alejandro" name="names" size="40" maxlength="35" autofocus>
            Apellidos:
            <input type="text" value="Herrera Ramos" name="lastnames" size="40" maxlength="35">
            Nombre de usuario:
            <input type="text" value="Username" name="user" maxlength="15">
            Correo electrónico:
            <input type="email" value="example@example.com" name="email" size="40" maxlength="55">
            Contraseña:
            <input type="password" value="pass" name="pass" size="35" maxlength="60">
            Fecha de nacimiento:
            <input type="date" name="cumple" value="2000-11-27">
            <input type="submit" value="Enviar registro">
            <input type="reset" value="Reiniciar registro">
        </form>
    </body>
</html>
