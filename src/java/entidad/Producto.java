package entidad;
// Generated 26/01/2018 12:02:55 PM by Hibernate Tools 4.3.1



/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private int idProducto;
     private String nombre;
     private Integer stock;
     private String descripcion;
     private int usuarioIdUsuario;

    public Producto() {
    }

	
    public Producto(int idProducto, int usuarioIdUsuario) {
        this.idProducto = idProducto;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }
    public Producto(int idProducto, String nombre, Integer stock, String descripcion, int usuarioIdUsuario) {
       this.idProducto = idProducto;
       this.nombre = nombre;
       this.stock = stock;
       this.descripcion = descripcion;
       this.usuarioIdUsuario = usuarioIdUsuario;
    }
   
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getUsuarioIdUsuario() {
        return this.usuarioIdUsuario;
    }
    
    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }




}

