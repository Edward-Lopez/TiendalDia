<%@page import="java.util.ArrayList"%>
<%@page import="TO.TOTendero"%>
<%@page import="controllers.ctrlTendero"%>
<%@page import="com.google.gson.Gson"%>
<%ctrlTendero tenderoCtrl = new ctrlTendero();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOTendero> tendero =tenderoCtrl.consultarTendero();
    out.print(new Gson().toJson(tendero));
}else{
    out.print("opción no válida");
}
%>