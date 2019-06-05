<%-- 
    Document   : Registro
    Created on : 5/04/2019, 06:05:03 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Práctica 5/6 - Session & Cookies</title>
    </head>
    <body>
        <link href="css/index-style.css" rel="stylesheet" type="text/css"/>
        <ul class='navibar'>
            <a href='/Practica_5' id="titulo"><b>Práctica 5/6 - Session & Cookies</b></a>
            <li class="navibar">
                <a href='Registro.jsp'><b>Registrate</b></a>
            </li>
            <li class="navibar">
                <a href='Login.jsp'><b>Ingresar</b></a>
            </li>
        </ul>
        <form action="controlador.do" method="POST">
            Nombre de usuario: <input type="text" name="user"><br>
            Contraseña: <input type="password" name="pass"><br>
            Fecha de nacimiento: <input type="date" name="birth"><br>
            <input type="submit" value="Registrarse">
        </form>
        <h6>Autor: Jorge Alejandro HERRERA RAMOS; ID: 1863060</h6>
    </html>
