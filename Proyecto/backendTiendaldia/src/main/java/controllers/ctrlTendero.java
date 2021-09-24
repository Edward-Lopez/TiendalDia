/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.DAOTendero;
import TO.TOTendero;
import java.util.ArrayList;

/**
 *
 * @author RMUSR0002
 */
public class ctrlTendero {
    DAOTendero tenderoDAO;

    public ctrlTendero() {
        this.tenderoDAO = new DAOTendero();
    }

    public ArrayList<TOTendero> consultarTendero() {
        return tenderoDAO.consultarTendero();
    }

    public int insertarTendero(TOTendero toTendero) {
        return tenderoDAO.insertarTendero(toTendero);
    }

    public boolean actualizarTendero(TOTendero toTendero) {
        return tenderoDAO.actualizarTendero(toTendero);
    }

    public boolean eliminarTendero(int idTendero) {
        return tenderoDAO.eliminarTendero(idTendero);
    }
}
