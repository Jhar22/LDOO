/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AciertaModelo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorge Alejandro Herrera Ramos 1863060
 */
public class AciertaControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int numeroDelJugador = Integer.parseInt(request.getParameter("numeroDelJugador"));
        if(numeroDelJugador>5 || numeroDelJugador<1){
            response.sendRedirect("error.jsp");
        }else{
            HttpSession sesion = request.getSession();
            Integer intentosSesion = (Integer)sesion.getAttribute("intentos");
            // si es la primera vez, los intentos deben ser 0
            // si no, usa los intentos que lleva
            int intentos = (intentosSesion == null ? 0 : intentosSesion);
            // incrementar la cuenta de intentos y actualizarla en la sesión
            sesion.setAttribute("intentos", ++intentos);
            
            AciertaModelo comparador = new AciertaModelo();
            // si es la primera vez que lo intenta...
            if (intentos == 1) {
             // primera vez
             // generar un número aleatorio en el modelo
             // y colocar el modelo en la sesión del jugador
             comparador.generarAleatorio(); // genera un nuevo número aleatorio
             sesion.setAttribute("aleatorio", comparador);
            } else {
             // no es la primera vez, así que ya existe un número aleatorio
             comparador = (AciertaModelo) sesion.getAttribute("aleatorio");
            }
            if(comparador.comparar(numeroDelJugador) == true){
                Cookie[] allCookies = request.getCookies();
            Cookie cookie = null;
            boolean existeCookie = false;
            for (Cookie tmp : allCookies) {
                if (tmp.getName().equals("juegosGanados")) {
                    // existe la cookie
                    existeCookie = true; // a.
                    int ganados = Integer.parseInt(tmp.getValue()); // b.
                    ganados++; // c.
                    cookie = new Cookie("juegosGanados", ganados + ""); // d.
                    break;
                }
            } // for
            if (!existeCookie) {
                // es la primera vez que gana
                cookie = new Cookie("juegosGanados", "0");
            }
            response.addCookie(cookie);
                sesion.invalidate();
                response.sendRedirect("ganador.jsp");
            }else{
                int respuesta = comparador.getRandom();
                response.sendRedirect("perdedor.jsp?random="+respuesta);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

