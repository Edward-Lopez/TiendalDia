
package TO;


public class TOUsuarios {
    private int idUsuarios;
    private String nombresUsuarios;
    private String apellidosUsuarios;
    private String tipoIdentificacion;
    private String identificacion;
    private String direccionUsuarios;
    private String telefonoUsuarios;
    private String correoUsuarios;

    public TOUsuarios() {
    }

    public TOUsuarios(int idUsuarios, String nombresUsuarios, String apellidosUsuarios, String tipoIdentificacion, String identificacion, String direccionUsuarios, String telefonoUsuarios, String correoUsuarios) {
        this.idUsuarios = idUsuarios;
        this.nombresUsuarios = nombresUsuarios;
        this.apellidosUsuarios = apellidosUsuarios;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.direccionUsuarios = direccionUsuarios;
        this.telefonoUsuarios = telefonoUsuarios;
        this.correoUsuarios = correoUsuarios;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombresUsuarios() {
        return nombresUsuarios;
    }

    public void setNombresUsuarios(String nombresUsuarios) {
        this.nombresUsuarios = nombresUsuarios;
    }

    public String getApellidosUsuarios() {
        return apellidosUsuarios;
    }

    public void setApellidosUsuarios(String apellidosUsuarios) {
        this.apellidosUsuarios = apellidosUsuarios;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccionUsuarios() {
        return direccionUsuarios;
    }

    public void setDireccionUsuarios(String direccionUsuarios) {
        this.direccionUsuarios = direccionUsuarios;
    }

    public String getTelefonoUsuarios() {
        return telefonoUsuarios;
    }

    public void setTelefonoUsuarios(String telefonoUsuarios) {
        this.telefonoUsuarios = telefonoUsuarios;
    }

    public String getCorreoUsuarios() {
        return correoUsuarios;
    }

    public void setCorreoUsuarios(String correoUsuarios) {
        this.correoUsuarios = correoUsuarios;
    }
    
    
}
