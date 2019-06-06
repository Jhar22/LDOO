/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jorge
 */
public class Factory {
    private static Factory factory;
    public static Factory getFactory(){
        if(factory==null){
            factory = new Factory();
        }
        return factory;
    }
    private Factory(){
    }
    public Usuario crearUsuario(String nombre, String correo, String fecha, String pass, String tipo){
        Usuario usuario = new Usuario();
        usuario.setCorreo(correo);
        usuario.setNombre(nombre);
        usuario.setFecha(fecha);
        usuario.setPass(pass);
        usuario.setTipo(tipo);
        return usuario;
    }
    public UsuarioAdministrador crearAdministrador(String nombre, String correo, String fecha, String pass, String tipo){
        UsuarioAdministrador admin = new UsuarioAdministrador();
        admin.setCorreo(correo);
        admin.setNombre(nombre);
        admin.setFecha(fecha);
        admin.setPass(pass);
        admin.setTipo(tipo);
        return admin;
    }
    public Invitado crearInvitado(String nombre, String correo, String tipo){
    Invitado invitado = new Invitado();
    invitado.setNombre(nombre);
    invitado.setCorreo(correo);
    invitado.setTipo(tipo);
    return invitado;
    }
}
