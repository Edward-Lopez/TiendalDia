package TO;

public class TOTendero extends TOUsuarios { 

    private int idTendero;
    private String usuario;
    private String contrasena;
    private int idUsuario;
    private String nombreTienda;
    private int idUsuarios;
 /*   private String nombresUsuarios;      
    private String apellidosUsuarios;
    private String tipoIdentificacion;
    private String identificacion;
    private String direccionUsuarios;
    private String telefonoUsuarios;
    private String correoUsuarios;        Parece que estos atributos no van acá porque TOTendero ya los hereda       */  

    public TOTendero() {

    }

 /*   public TOTendero(String nombreTienda, String nombresUsuarios, String apellidosUsuarios, String tipoIdentificacion, String identificacion, String direccionUsuarios, String telefonoUsuarios, String correoUsuarios) {
        this.nombreTienda = nombreTienda;
        this.nombresUsuarios = nombresUsuarios;
        this.apellidosUsuarios = apellidosUsuarios;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.direccionUsuarios = direccionUsuarios;            
        this.telefonoUsuarios = telefonoUsuarios;
        this.correoUsuarios = correoUsuarios;
    }                                         El bloque anterior del código puede borrarse(ya que tenemos el constructor vacío) o bien solo mantener la línea 23 y en la 24 usar el comando super, declarando dentro de él los atributos que viene de la clase padre
*/
      
    public int getIdTendero() {
        return idTendero;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getIdUsuario() {
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

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
}
