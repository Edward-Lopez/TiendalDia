
package DAO;

import TO.TOTendero;
import bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOTendero{
    private final ConexionBD con = new ConexionBD();
    private final String nombreTabla = "Tendero";
    private final String[] columnas = {"vistatendero"};
            
    public DAOTendero() {
    }
    
    public ArrayList<TOTendero> consultarTendero() {
        ArrayList<TOTendero> tendero = new ArrayList<>();
        TOTendero toTendero;
        try {
            ResultSet rs = con.consultar(nombreTabla);
            while (rs.next()) {
                toTendero = new TOTendero();
                toTendero.setNombresUsuarios(rs.getString("NombreUsuarios"));
                toTendero.setApellidosUsuarios(rs.getString("ApellidosUsuarios"));
                toTendero.setTipoIdentificacion(rs.getString("TipoIdentificacion"));
                toTendero.setIdentificacion(rs.getString("Identificacion"));
                toTendero.setDireccionUsuarios(rs.getString("DireccionUsuarios"));
                toTendero.setTelefonoUsuarios(rs.getString("TelefonoUsuarios"));
                toTendero.setCorreoUsuarios(rs.getString("CorreoUsuarios"));
                toTendero.setIdUsuarios(rs.getInt("IdUsuarios"));
                toTendero.setIdTendero(rs.getInt("idTendero"));
                toTendero.setUsuario(rs.getString("usuario"));
                toTendero.setContrasena(rs.getString("contrasena"));
                toTendero.setNombreTienda(rs.getString("nombreTienda"));

                tendero.add(toTendero);
            }
            return tendero;
        } catch (SQLException ex) {
            System.out.println("Error en DAOTendero.consultarTendero:" + ex.getMessage());
            return null;
        }

    }
    
    public int insertarTendero(TOTendero toTenderos) {
        String[] valores = {toTenderos.getNombresUsuarios(),toTenderos.getApellidosUsuarios(),toTenderos.getTipoIdentificacion(),toTenderos.getIdentificacion(),toTenderos.getDireccionUsuarios(),toTenderos.getTelefonoUsuarios(),toTenderos.getCorreoUsuarios()};
        try {
            return con.insertar(nombreTabla, columnas, valores);
          
        }catch(Exception ex){
            System.out.println("Error en DAOTendero.insertarTendero:" + ex.getMessage());
            return 0;
        }

    }
    
    public boolean actualizarTendero(TOTendero toTenderos) {
        String[] valores = {toTenderos.getNombresUsuarios(), toTenderos.getApellidosUsuarios(), toTenderos.getTipoIdentificacion(), toTenderos.getIdentificacion(), toTenderos.getDireccionUsuarios(), toTenderos.getTelefonoUsuarios(), toTenderos.getCorreoUsuarios()};
        try {
            return con.actualizar(nombreTabla, columnas, valores, toTenderos.getIdUsuarios());

        } catch (Exception ex) {
            System.out.println("Error en DAOTendero.insertarTendero:" + ex.getMessage());
            return false;
        }

    }
    
      public boolean eliminarTendero(int idUsuarios) {
        try {
            return con.eliminar(nombreTabla,idUsuarios);

        } catch (Exception ex) {
            System.out.println("Error en DAOTendero.eliminarTendero:" + ex.getMessage());
            return false;
        }

    }
}
