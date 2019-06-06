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
        <%%>
        <ul class="navibar">
            <li class="navibar_opcion">
                <a href="index.jsp">
                    Inicio
                </a>
            </li>
            <%if(session.getAttribute("nombre") == null){%>
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
            <%}else{%>
            <li class="navibar_opcion2">
                <form action="Controlador" method="post">
                    <input type="submit" value="Cerrar Sesión" class="submit_boton2">
                <input type="hidden" name="accion" value="cerrar">
                </form>
            </li>
            <li class="navibar_opcion2">
                <a>
                Bienvenido, <%=session.getAttribute("nombre")%>
                </a>
            </li>
            <%}%>
        </ul>
        <h1>
            LDOO Segunda oportunidad
        </h1>
        <%if(session.getAttribute("nombre") == null){%>
        <h2>
            Página principal<br>
            El contenido de este sitio se mostrará una vez que hayas iniciado sesión.
        </h2>
        <div class="cuadro">
            <ul>
            <li>
            <a href="login.jsp" class="opcion">
                Inicia sesión
            </a>
            </li>
            </ul>
            ¿No tienes una cuenta?
            <ul>
                <li>
                    <a href="invitado.jsp" class="opcion">
                        Inicia sesión como invitado
                    </a>
                </li>
                <li>
                    <a href="registro.jsp" class="opcion">
                        Registrate e inicia sesión como usuario
                    </a>
                </li>
                <li>
                    <a href="registro_admin.jsp" class="opcion">
                        Registrate e inicia sesión como administrador
                    </a>
                </li>
            </ul>
        </div>
        <%}else{%>
        <h2>
            Página principal<br>
            Hola <%=session.getAttribute("nombre")%>, como <%=session.getAttribute("tipo")%> eres bienvenido al contenido de esta página.
        </h2>
        <div class="cuadro">
            <img src="Sin título.png" alt="Cookies"/>
            <%
                Cookie[] allCookies = request.getCookies();
                if(allCookies==null){
            %>
            <%=allCookies[0].getValue()%>
            <%}%>
        </div>
        <%}%>
    </body>
</html>
