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
public interface UsuarioInterface {
    public void setNombre(String nombre);
    public String getNombre();
    public void setCorreo(String correo);
    public String getCorreo();
    public void setTipo(String tipo);
    public String getTipo();
}
