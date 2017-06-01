/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.datos;

import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class ColeccionUsuarios implements Serializable{
    private Usuario usuario;
    private ArrayList<Usuario> usuarios;

    public ColeccionUsuarios() {
        usuarios=new ArrayList();
        usuarios.add(new Usuario("admin","admin"));
        usuarios.add(new Usuario("alumno","alumno"));
        usuarios.add(new Usuario("matias","matias"));
    }
    public Usuario validarUsuario(String unUsuario, String unaContraseña){
        
        setUsuario(new Usuario());
        setUsuario(null);
        for(Usuario u:getUsuarios()){
            if(u.getUsuario().equals(unUsuario) 
                    && u.getContraseña().equals(unaContraseña)){
                setUsuario(u);
                break;
            }
        }
        return getUsuario();
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
