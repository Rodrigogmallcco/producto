package entidad;
// Generated 26/01/2018 12:02:55 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private String id;
     private String pass;
     private int rolIdRol;

    public Usuario() {
    }

	
    public Usuario(int idUsuario, int rolIdRol) {
        this.idUsuario = idUsuario;
        this.rolIdRol = rolIdRol;
    }
    public Usuario(int idUsuario, String id, String pass, int rolIdRol) {
       this.idUsuario = idUsuario;
       this.id = id;
       this.pass = pass;
       this.rolIdRol = rolIdRol;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getRolIdRol() {
        return this.rolIdRol;
    }
    
    public void setRolIdRol(int rolIdRol) {
        this.rolIdRol = rolIdRol;
    }




}

