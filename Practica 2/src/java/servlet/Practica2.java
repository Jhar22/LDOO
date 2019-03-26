/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jorge
 */
public class Practica2 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Practica2</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesP2.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>");
            out.println("<li>");
            out.println("<b>");
            out.println("Formulario con Servlet - Práctica 2");
            out.println("</b>");
            out.println("</li>");
            out.println("</ul>");
            out.println("<h1>Servlet de Practica 2 en " + request.getContextPath() + "</h1>");
            out.println("<h2>");
            out.println("Datos recolectados");
            out.println("</h2>");
            String nombre = request.getParameter("names") + " " + request.getParameter("lastnames");
            String correo = request.getParameter("email");
            String cumpleanios = request.getParameter("cumple");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            out.println("<ul>");
            out.println("<li>");
            out.println("Nombre completo: ");
            out.println(nombre);
            out.println("</li>");
            out.println("<li>");
            out.println("Nombre de usuario: ");
            out.println(user);
            out.println("</li>");
            out.println("<li>");
            out.println("Correo electrónico: ");
            out.println(correo);
            out.println("</li>");
            out.println("<li>");
            out.println("Contraseña: ");
            out.println(pass);
            out.println("</li>");
            out.println("<li>");
            out.println("Fecha de nacimiento: ");
            out.println(cumpleanios);
            out.println("</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
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
