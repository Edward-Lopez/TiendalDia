<%@page import="TO.TOUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TO.TOTendero"%>
<%@page import="controllers.ctrlTendero"%>
<%@page import="com.google.gson.Gson"%>
<%ctrlTendero tenderoCtrl = new ctrlTendero();
    String opcion = request.getParameter("opcion");
if ("listar".equals(opcion)) {
        ArrayList<TOTendero> tendero = tenderoCtrl.consultarTendero();
//        out.print(new Gson().toJson(tendero));
        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(new Gson().toJson(tendero));
        response.getWriter().close();
}else if ("login".equals(opcion)) {
        String datos = request.getParameter("datos");
        TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
        tenderoTO = tenderoCtrl.verificarTendero(tenderoTO);
//        out.print(new Gson().toJson(tenderoTO));
        response.setContentType("text/plain; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(new Gson().toJson(tenderoTO));
        response.getWriter().close();
} else if ("insertar".equals(opcion)) {
    String datos = request.getParameter("datos");
    TOUsuarios usuariosTO = new Gson().fromJson(datos, TOUsuarios.class);
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoCtrl.insertarTendero(tenderoTO, usuariosTO);
//        out.print(new Gson().toJson(usuariosTO));
    response.setContentType("text/plain; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().println(new Gson().toJson(tenderoTO));
    response.getWriter().close();
}else if("actualizar".equals(opcion)){
    String datos = request.getParameter("datos");
    TOUsuarios usuariosTO = new Gson().fromJson(datos, TOUsuarios.class);
    TOTendero tenderoTO = new Gson().fromJson(datos, TOTendero.class);
    tenderoCtrl.actualizarTendero(tenderoTO, usuariosTO);
    //out.print(new Gson().toJson(usuariosTO));
    response.setContentType("text/plain; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().println(new Gson().toJson(usuariosTO));
    response.getWriter().close();
 }else if("eliminar".equals(opcion)){
    String idTendero = request.getParameter("idTendero");
    tenderoCtrl.eliminarTendero(Integer.parseInt(idTendero));
    //out.print(new Gson().toJson(usuariosTO));
    response.setContentType("text/plain; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().close();
    }else{
    out.print("opción no válida");
}
%>