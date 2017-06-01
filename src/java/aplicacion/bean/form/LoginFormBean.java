/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.bean.form;

import aplicacion.modelo.datos.ColeccionUsuarios;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alumno
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    private String unUsuario;
    private String unaContraseña;

    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
        
    }
    public String validarUsuario(){
        ColeccionUsuarios Usuarios=new ColeccionUsuarios();
        Usuario usuario=new Usuario();
        String resultado=null;
        usuario=Usuarios.validarUsuario(getUnUsuario(), getUnaContraseña());
        if(usuario==null){
            FacesMessage facesMessage=
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Credenciales invalidas","Credenciales invalidas");
            FacesContext.getCurrentInstance()
                    .addMessage(null, facesMessage);
        }else{
            FacesMessage facesMessage=
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Usuario Valido","Usuario Valido");
            FacesContext.getCurrentInstance()
                    .addMessage(null, facesMessage);
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().put("UsuarioValidado", usuario);
            resultado="/menu";
            // resultado="/menu"; ! No cambia la dirección al redireccionar
            // resultado="/menu?faces-redirect=true";
        }
        return resultado;
    }
    
    public String getNombreUsuarioValido(){
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("UsuarioValidado");
        return usuario.getUsuario(); 
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance()
                .getExternalContext().invalidateSession();
        FacesMessage facesMessage= new FacesMessage
        (FacesMessage.SEVERITY_INFO,"Sesión Cerrada","Sesión Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="/login";
        // String resultado="/login?faces-redirect=true";
        return resultado;  
    }
    
    public boolean verificarSesion(){
        boolean sesionValida=false;
        if(FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap()
                .get("UsuarioValidado")!=null){
            sesionValida=true;
        }
        return sesionValida;
    }
    
    /**
     * @return the unUsuario
     */
    public String getUnUsuario() {
        return unUsuario;
    }

    /**
     * @param unUsuario the unUsuario to set
     */
    public void setUnUsuario(String unUsuario) {
        this.unUsuario = unUsuario;
    }

    /**
     * @return the unaContraseña
     */
    public String getUnaContraseña() {
        return unaContraseña;
    }

    /**
     * @param unaContraseña the unaContraseña to set
     */
    public void setUnaContraseña(String unaContraseña) {
        this.unaContraseña = unaContraseña;
    }
    
}
