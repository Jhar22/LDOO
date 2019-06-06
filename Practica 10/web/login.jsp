<%-- 
    Document   : index
    Created on : 4/06/2019, 08:52:35 PM
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segunda oportunidad LDOO</title>
        <link href="css.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <ul class="navibar">
            <li class="navibar_opcion">
                <a href="index.jsp">
                    Inicio
                </a>
            </li>
            <li class="navibar_opcion">
                <a href="registro.jsp">
                    Registrate
                </a>
            </li>
            <li class="navibar_opcion">
                <a href="registro_admin.jsp">
                    Forma parte del equipo
                </a>
            </li>
            <li class="navibar_opcion">
                <a href="invitado.jsp">
                    Echa un vistazo como invitado
                </a>
            </li>
            <li class="navibar_opcion">
                <a href="login.jsp">
                    Iniciar Sesion
                </a>
            </li>
        </ul>
        <h1>
            LDOO Segunda oportunidad
        </h1>
        <h2>
            Inicia sesión
        </h2>
        <form action="Controlador" method="post" class="formulario">
            
            <div class="formulario_div">
                Nombre de usuario:<br>
                <input type="text" name="nombre" class="formulario_input" size="16" placeholder="Juanito" required pattern="[A-Za-z0-9]{5,16}" title="El nombre de usuario debe tener por lo menos 5 caracteres(números y/o letras)" required="true">
            </div>
            
            
            <div class="formulario_div">
                Contraseña:<br>
                <input type="password"  size="30" name="pass" minlength="8" maxlength="30" class="formulario_input" required="true">
            </div>
            
            <input class="submit_boton" type="submit" value="Ingresar">
            <input type="hidden" name="accion"  value="login">
        </form>
    </body>
</html>
