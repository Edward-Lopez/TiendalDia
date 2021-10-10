<%@page import="java.util.ArrayList"%>
<%@page import="TO.TOUsuarios"%>
<%@page import="controllers.ctrlUsuarios"%>
<%@page import="com.google.gson.Gson"%>
<%ctrlUsuarios usuariosCtrl = new ctrlUsuarios();
String opcion = request.getParameter("opcion");
if("listar".equals(opcion)){
    ArrayList<TOUsuarios> usuarios = usuariosCtrl.consultarUsuarios();
    out.print(new Gson().toJson(usuarios));
}else{
    out.print("opción no válida");
}
%>