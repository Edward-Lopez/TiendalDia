<%@page import="bd.ConexionBD"%>
<%@ page import="java.sql.*"%>
<%@page import="DAO.DAOTendero"%>
<%@page import="TO.TOTendero"%>
<%
ConexionBD connection = new ConexionBD();
String[] columnas = {"NombresUsuarios", "ApellidosUsuarios", "TipoIdentificacion", "Identificacion", "DireccionUsuarios", "TelefonoUsuarios", "CorreoUsuarios"};
    String[] valores = {"NombresUsuarios", "ApellidosUsuarios", "TipoIdentificacion", "Identificacion", "DireccionUsuarios", "TelefonoUsuarios", "CorreoUsuarios"};
    //String x = connection.insertar("Usuarios", columnas, valores);
    //
    //ResultSet rs = connection.consultar("vistausuariotendero");
    //out.print();
    /*while (rs.next()) {
        out.print(rs.getInt(1) + " ");
        out.print("|");
        out.print(rs.getString(2));
        out.print("|");
        out.print(rs.getString(3));
        out.print("|");
        out.print(rs.getString(4));
        out.print("<br>");
    }*/
    /*String x = connection.eliminar("tendero",5,"idTendero");
    out.print(x);*/
    TOTendero toTenderos = new TOTendero();
    toTenderos.setUsuario("adsada");
    toTenderos.setContrasena("saas");
    toTenderos.setIdUsuario(1);
    toTenderos.setNombreTienda("tienda");
    toTenderos.setIdTendero(6);
    
    String x = new DAOTendero().actualizarTendero(toTenderos);
    out.print(x);
%>
