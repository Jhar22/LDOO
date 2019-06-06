/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO;
import modelo.Factory;
import modelo.Usuario;

/**
 *
 * @author Jorge
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        if(accion.equals("registro_usuario") || accion.equals("registro_admin")){
            
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String fecha = request.getParameter("fecha");
            String pass = request.getParameter("pass");
            
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setCorreo(correo);
            usuario.setFecha(fecha);
            usuario.setPass(pass);
            
            HttpSession sesion = request.getSession();
            sesion.setAttribute("nombre", nombre);
            
            if(accion.equals("registro_usuario")){
                
                sesion.setAttribute("tipo", "usuario");
                usuario.setTipo("usuario");
                Cookie cookie = new Cookie("nombre", nombre);
                
            }else{
                
                sesion.setAttribute("tipo", "administrador");
                usuario.setTipo("administrador");
                
            }
            
            DAO conexion = new DAO();
            conexion.registrar(usuario);
            response.sendRedirect("index.jsp");
        }else{
            if(accion.equals("login")){
                String nombre = request.getParameter("nombre");
                String pass = request.getParameter("pass");
                Usuario usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setPass(pass);
                DAO conexion = new DAO();
                boolean existe = conexion.ingresar(usuario);
                if(existe == true){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("nombre", nombre);
                }
                response.sendRedirect("index.jsp");
            }else{
                if(accion.equals("cerrar")){
                    HttpSession sesion = request.getSession();
                    sesion.invalidate();
                    response.sendRedirect("index.jsp");
                }else{
                    if(accion.equals("registro_invitado")){
                        String nombre = request.getParameter("nombre");
                        String correo = request.getParameter("correo");
                        String tipo = request.getParameter("tipo");
                        Factory factory = Factory.getFactory();
                        factory.crearInvitado(nombre, correo, tipo);
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("nombre", nombre);
                        sesion.setAttribute("tipo", "invitado");
                        response.sendRedirect("index.jsp");
                    }
                }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
