<%@page import="TO.TOUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TO.TOTendero"%>
<%@page import="controllers.ctrlTendero"%>
<%@page import="com.google.gson.Gson"%>
<%ctrlTendero tenderoCtrl = new ctrlTendero();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOTendero> tendero = tenderoCtrl.consultarTendero();
    out.print(new Gson().toJson(tendero));
}else if("login".equals(opcion)){
    String datos = request.getParameter("datos");
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoTO = tenderoCtrl.verificarTendero(tenderoTO);
    out.print(new Gson().toJson(tenderoTO));
}else if("insertar".equals(opcion)){
    String datos = request.getParameter("datos");
    TOUsuarios usuariosTO = new Gson().fromJson(datos, TOUsuarios.class);
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoCtrl.insertarTendero(tenderoTO, usuariosTO);
    out.print(new Gson().toJson(usuariosTO));
}else if("actualizar".equals(opcion)){
    String datos = request.getParameter("datos");
    TOUsuarios usuariosTO = new Gson().fromJson(datos, TOUsuarios.class);
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoCtrl.actualizarTendero(tenderoTO, usuariosTO);
    out.print(new Gson().toJson(usuariosTO));
}else if("eliminar".equals(opcion)){
    String datos = request.getParameter("datos");
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoCtrl.eliminarTendero(tenderoTO);
}else{
    out.print("opción no válida");
}
%>