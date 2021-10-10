package controllers;

import DAO.DAOTendero;
import TO.TOTendero;
import TO.TOUsuarios;
import java.util.ArrayList;

public class ctrlTendero {
    
    DAOTendero tenderoDAO;

    public ctrlTendero() {
        this.tenderoDAO = new DAOTendero();
    }

    public ArrayList<TOTendero> consultarTendero() {
        return tenderoDAO.consultarTendero();
    }

    public TOTendero verificarTendero(TOTendero tendero) {
        return tenderoDAO.verificarTendero(tendero.getUsuario(), tendero.getContrasena());
    }
    
    public int insertarTendero(TOTendero toTendero, TOUsuarios toUsuarios) {
        ctrlUsuarios usuariosCtrl = new ctrlUsuarios();
        toTendero.setIdUsuariosTendero(usuariosCtrl.insertarUsuarios(toUsuarios));
        return tenderoDAO.insertarTendero(toTendero);
    }

    public boolean actualizarTendero(TOTendero toTendero, TOUsuarios toUsuarios) {
        ctrlUsuarios usuariosCtrl = new ctrlUsuarios();
        toUsuarios.setIdUsuarios(toTendero.getIdUsuarios());
        usuariosCtrl.actualizarUsuarios(toUsuarios);
        return tenderoDAO.actualizarTendero(toTendero);
    }

    public boolean eliminarTendero(int idTendero) {
        return tenderoDAO.eliminarTendero(idTendero);
    }
}
