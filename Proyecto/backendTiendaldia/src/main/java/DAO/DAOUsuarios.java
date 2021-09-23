package DAO;

import TO.TOUsuarios;
import bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOUsuarios {
    
    private final ConexionBD con = new ConexionBD();
    private final String nombreTabla = "Usuarios";
    private final String[] columnas = {"NombreUsuarios","ApellidosUsuarios","TipoIdentificacion","Identificacion","DireccionUsuarios","TelefonoUsuarios","CorreoUsuarios"};
            
    public DAOUsuarios() {
    }
    
    public ArrayList<TOUsuarios> consultarUsuarios() {
        ArrayList<TOUsuarios> usuarios = new ArrayList<>();
        TOUsuarios toUsuario;
        try {
            ResultSet rs = con.consultar(nombreTabla);
            while (rs.next()) {
                toUsuario = new TOUsuarios();
                toUsuario.setNombresUsuarios(rs.getString("NombreUsuarios"));
                toUsuario.setApellidosUsuarios(rs.getString("ApellidosUsuarios"));
                toUsuario.setTipoIdentificacion(rs.getString("TipoIdentificacion"));
                toUsuario.setIdentificacion(rs.getString("Identificacion"));
                toUsuario.setDireccionUsuarios(rs.getString("DireccionUsuarios"));
                toUsuario.setTelefonoUsuarios(rs.getString("TelefonoUsuarios"));
                toUsuario.setCorreoUsuarios(rs.getString("CorreoUsuarios"));
                toUsuario.setIdUsuarios(rs.getInt("IdUsuarios"));

                usuarios.add(toUsuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error en DAOUsuarios.consultarUsuarios:" + ex.getMessage());
            return null;
        }

    }
    
    public int insertarUsuarios(TOUsuarios toUsuarios) {
        String[] valores = {toUsuarios.getNombresUsuarios(),toUsuarios.getApellidosUsuarios(),toUsuarios.getTipoIdentificacion(),toUsuarios.getIdentificacion(),toUsuarios.getDireccionUsuarios(),toUsuarios.getTelefonoUsuarios(),toUsuarios.getCorreoUsuarios()};
        try {
            return con.insertar(nombreTabla, columnas, valores);
          
        }catch(Exception ex){
            System.out.println("Error en DAOUsuarios.insertarUsuarios:" + ex.getMessage());
            return 0;
        }

    }
    
    public boolean actualizarUsuarios(TOUsuarios toUsuarios) {
        String[] valores = {toUsuarios.getNombresUsuarios(), toUsuarios.getApellidosUsuarios(), toUsuarios.getTipoIdentificacion(), toUsuarios.getIdentificacion(), toUsuarios.getDireccionUsuarios(), toUsuarios.getTelefonoUsuarios(), toUsuarios.getCorreoUsuarios()};
        try {
            return con.actualizar(nombreTabla, columnas, valores, toUsuarios.getIdUsuarios());

        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.insertarUsuarios:" + ex.getMessage());
            return false;
        }

    }
    
      public boolean eliminarUsuarios(int idUsuarios) {
        try {
            return con.eliminar(nombreTabla,idUsuarios);

        } catch (Exception ex) {
            System.out.println("Error en DAOUsuarios.eliminarUsuarios:" + ex.getMessage());
            return false;
        }

    }
        
    
}



