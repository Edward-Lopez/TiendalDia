
package controllers;

import DAO.DAOUsuarios;
import TO.TOUsuarios;
import java.util.ArrayList;

/**
 *
 * @author Personal
 */
public class CtrlUsuarios {
    DAOUsuarios usuariosDAO;

    public CtrlUsuarios() {
        this.usuariosDAO = new DAOUsuarios();
    }
    
    public ArrayList<TOUsuarios> consultarUsuarios(){
        return usuariosDAO.consultar(nombreTabla);
    }
}
