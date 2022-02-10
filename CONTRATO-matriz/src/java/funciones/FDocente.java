/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.*;
import entidades.Docente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msgoon6
 */
public class FDocente {

    public static int insertar(Docente docente) throws Exception {
        int resp = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "INSERT INTO docente(ci, nombres, apellidos, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?);";
            lstP.add(new Parametro(1, docente.getCi()));
            lstP.add(new Parametro(2, docente.getNombre()));
            lstP.add(new Parametro(3, docente.getApellidos()));
            lstP.add(new Parametro(4, docente.getDireccion()));
            lstP.add(new Parametro(5, docente.getTelefono()));
            java.sql.Date sqldate = new java.sql.Date(docente.getFecha_nacimiento().getTime());
            lstP.add(new Parametro(6, sqldate));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            resp = 1;
        } catch (SQLException exConec) {
            resp = 0;
        }
        return resp;
    }

    public static ArrayList<Docente> obtener() throws Exception {
        ArrayList<Docente> resp = new ArrayList<>();
        try {
            String sql = "Select * from docente;";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            if (rs != null) {
                resp = FDocente.llenar(rs);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return resp;
    }

    private static ArrayList<Docente> llenar(ConjuntoResultado rs) throws Exception {
        ArrayList<Docente> lstper = new ArrayList<>();
        try {
            while (rs.next()) {
                Docente tmp = new Docente(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
                lstper.add(tmp);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return lstper;
    }
}
