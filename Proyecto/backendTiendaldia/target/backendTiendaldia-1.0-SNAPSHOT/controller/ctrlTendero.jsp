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
    out.print(new Gson().toJson(tendero));
}else if("insertar".equals(opcion)){
    
}else if("actualizar".equals(opcion)){
    
}else if("eliminar".equals(opcion)){
    
}else{
    out.print("opción no válida");
}
%>