
package DAO;

import TO.TOTendero;
import bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOTendero{
    private final ConexionBD con = new ConexionBD();
    private final String nombreTabla = "Tendero";
    private final String nombreVista = "vistausuariotendero";
    private final String[] columnas = {"usuario","contrasena","idUsuario","nombreTienda"};
            
    public DAOTendero() {
    }
    
    public ArrayList<TOTendero> consultarTendero() {
        ArrayList<TOTendero> tendero = new ArrayList<>();
        TOTendero toTendero;
        try {
            ResultSet rs = con.consultar(nombreVista);
            while (rs.next()) {
                toTendero = new TOTendero();
                toTendero.setNombresUsuarios(rs.getString("nombresUsuarios"));
                toTendero.setApellidosUsuarios(rs.getString("apellidosUsuarios"));
                toTendero.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                toTendero.setIdentificacion(rs.getString("identificacion"));
                toTendero.setDireccionUsuarios(rs.getString("direccionUsuarios"));
                toTendero.setTelefonoUsuarios(rs.getString("telefonoUsuarios"));
                toTendero.setCorreoUsuarios(rs.getString("correoUsuarios"));
                toTendero.setIdUsuarios(rs.getInt("idUsuarios"));
//                toTendero.setIdTendero(rs.getInt("IdTendero"));
                toTendero.setUsuario(rs.getString("usuario"));
//                toTendero.setContrasena(rs.getString("Contrasena"));
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
        String[] valores = {toTenderos.getUsuario(),toTenderos.getContrasena(),String.valueOf(toTenderos.getIdUsuarios()),toTenderos.getNombreTienda()};
        try {
            return con.insertar(nombreTabla, columnas, valores);
          
        }catch(Exception ex){
            System.out.println("Error en DAOTendero.insertarTendero:" + ex.getMessage());
            return 0;
        }

    }
    
    public boolean actualizarTendero(TOTendero toTenderos) {
        String[] valores = {toTenderos.getUsuario(),toTenderos.getContrasena(),String.valueOf(toTenderos.getIdUsuarios()),toTenderos.getNombreTienda()};
        try {
            return con.actualizar(nombreTabla, columnas, valores, toTenderos.getIdTendero());

        } catch (Exception ex) {
            System.out.println("Error en DAOTendero.insertarTendero:" + ex.getMessage());
            return false;
        }

    }
    
      public boolean eliminarTendero(int idTendero) {
        try {
            return con.eliminar(nombreTabla,idTendero);

        } catch (Exception ex) {
            System.out.println("Error en DAOTendero.eliminarTendero:" + ex.getMessage());
            return false;
        }

    }
      
     public TOTendero verificarTendero(String usuario, String contrasena) {
        String condiciones = " usuario = '" + usuario + "' AND contrasena = '" + contrasena + "'";
        TOTendero toTendero= new TOTendero();
        try {
            ResultSet rs = con.consultarWhere(nombreTabla, condiciones);
            while (rs.next()) {
                toTendero.setNombresUsuarios(rs.getString("nombresUsuarios"));
                toTendero.setApellidosUsuarios(rs.getString("apellidosUsuarios"));
                toTendero.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                toTendero.setIdentificacion(rs.getString("identificacion"));
                toTendero.setDireccionUsuarios(rs.getString("direccionUsuarios"));
                toTendero.setTelefonoUsuarios(rs.getString("telefonoUsuarios"));
                toTendero.setCorreoUsuarios(rs.getString("correoUsuarios"));
 //               toTendero.setIdUsuarios(rs.getInt("idUsuarios"));
                toTendero.setIdTendero(rs.getInt("IdTendero"));
                toTendero.setUsuario(rs.getString("usuario"));
                toTendero.setContrasena(rs.getString("Contrasena"));
                toTendero.setNombreTienda(rs.getString("nombreTienda"));
            }
            return toTendero;
        } catch (SQLException ex) {
            System.out.println("Error en DAOTendero.verificarTendero:" + ex.getMessage());
            return null;
        }
     }
}