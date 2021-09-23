package TO;


public class TOProveedor extends TOUsuarios{
    private int idProveedor;
    private String nombreProveedor;
    private int idUsuario;

    public TOProveedor() {
        
    }     
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
