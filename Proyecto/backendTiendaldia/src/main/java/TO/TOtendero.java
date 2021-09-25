package TO;

public class TOTendero extends TOUsuarios{
    private int idTendero;
    private String usuario;
    private String contrasena;
    private String idUsuario;
    private String nombreTienda;
    private int idUsuarios;
    
    public TOTendero(){
        
    }

    public int getIdTendero() {
        return idTendero;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdTendero(int idTendero) {
        this.idTendero = idTendero;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
