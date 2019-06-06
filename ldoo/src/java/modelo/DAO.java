/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DAO {
    private Connection conexion;
    private void abrirConexion() throws SQLException{
        String url, usuario, password;
        url = "jdbc:derby://localhost:1527/LDOO";
        usuario = "FCFM";
        password = "lsti01";
        conexion = DriverManager.getConnection(url,usuario,password);
    }
    private void cerrarConexion() throws SQLException{
        conexion.close();
    }
    public void registrar(Usuario usuario) throws SQLException{
        try{
            String nombre = usuario.getNombre();
            String correo = usuario.getCorreo();
            String fecha = usuario.getFecha();
            String pass = usuario.getPass();
            String tipo = usuario.getTipo();
            abrirConexion();
            String sql ="insert into usuarios values('"+nombre+"','"+correo+"','"+fecha+"','"+pass+"','"+tipo+"')";
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(sql);
            cerrarConexion();
        }catch(SQLException a){
           System.out.println("No se pudo registrar");
        }
    }
    
    public boolean ingresar(Usuario usuario) throws SQLException{
        boolean existe = false;
        try{
            String nombre = usuario.getNombre();
            String pass = usuario.getPass();
            abrirConexion();
            String sql ="select * from usuarios where nombre='"+nombre+"' AND pass='"+pass+"'";
            ResultSet rs;
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);
            existe = rs != null;
            cerrarConexion();
        }catch(SQLException b){
            System.out.println("No se pudo ingresar");
        }
        return existe;
    }
}
