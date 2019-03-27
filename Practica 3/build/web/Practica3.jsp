<%-- 
    Document   : Practica3
    Created on : 10/03/2019, 03:00:04 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/Styles3.css" rel="stylesheet" type="text/css"/>
        <title>Practica 3</title>
    </head>
    <body>
        <ul>
            <li>
                <b>
                    Formulario con JSP - Práctica 3
                </b>
            </li>
	</ul>
        <h2>Datos recolectados</h2>
        <% 
            String nombre = request.getParameter("names") + " " + request.getParameter("lastnames");
            String correo = request.getParameter("email");
            String cumpleanios = request.getParameter("cumple");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
        %>
        <ul>
            <li>
                Nombre completo: <% out.print(nombre); %>
            </li>
            <li>
                Nombre de usuario: <% out.print(user); %>
            </li>
            <li>
                Correo electrónico: <% out.print(correo); %>
            </li>
            <li>
                Contraseña: <% out.print(pass); %>
            </li>
            <li>
                Fecha de nacimiento: <% out.print(cumpleanios); %>
            </li>
        </ul>
    </body>
</html>
