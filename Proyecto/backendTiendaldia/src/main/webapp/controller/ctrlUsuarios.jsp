<%@page import="java.util.ArrayList"%>
<%@page import="TO.TOUsuarios"%>
<%@page import="controllers.CtrlUsuarios"%>
<%@page import="com.google.gson.Gson"%>
<%CtrlUsuarios usuariosCtrl = new CtrlUsuarios();
String opcion = request.getParameter("opcion")
if("listar".equals(opcion)){
    ArrayList<TOUsuarios> usuarios = usuariosCtrl.consultarUsuarios();
    out.print(new Gson().toJson(usuarios));
}else{
    out.print("opción no válida");
}
%>