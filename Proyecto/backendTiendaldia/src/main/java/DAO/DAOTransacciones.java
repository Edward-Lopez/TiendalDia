package DAO;

import TO.TOTransacciones;
import bd.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOTransacciones {
    
    private final ConexionBD con = new ConexionBD();
    private final String nombreTabla = "Transacciones";
    private final String[] columnas = {"IDProducto","TotalTransaccion","CantidadTransaccion","ValorUnitarioCompra","ValorUnitarioVenta","FechaTransaccion","IVATransaccion","TipoTransacciones"};

    public DAOTransacciones() {
    }
    
    public ArrayList<TOTransacciones> consultarTransacciones() {
        ArrayList<TOTransacciones> transacciones = new ArrayList<>();
        TOTransacciones toTransaccion;
        try {
            ResultSet rs = con.consultar(nombreTabla);
            while (rs.next()) {
                toTransaccion = new TOTransacciones();
                toTransaccion.setIdProducto(rs.getInt("IDProducto"));
                toTransaccion.setTotalTransaccion(rs.getDouble("TotalTransaccion"));
                toTransaccion.setCantidadTransaccion(rs.getDouble("CantidadTransaccion"));
                toTransaccion.setValorUnitarioCompra(rs.getDouble("ValorUnitarioCompra"));
                toTransaccion.setValorUnitarioVenta(rs.getDouble("ValorUnitarioVenta"));
                toTransaccion.setFechaTransaccion(rs.getDate("FechaTransaccion"));
                toTransaccion.setIvaTransaccion(rs.getDouble("IVATransaccion"));
                toTransaccion.setTipoTransacciones(rs.getString("TipoTransacciones"));
                toTransaccion.setIdTransacciones(rs.getInt("IdTransacciones"));

                transacciones.add(toTransaccion);
            }
            return transacciones;
        } catch (SQLException ex) {
            System.out.println("Error en DAOTransacciones.consultarTransacciones:" + ex.getMessage());
            return null;
        }

    }
    
}
