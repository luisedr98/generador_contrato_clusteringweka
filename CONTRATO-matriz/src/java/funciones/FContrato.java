/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.*;
import entidades.Contrato;
import entidades.Docente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msgoon6
 */
public class FContrato {

    public static int insertar(Contrato contrato) throws Exception {
        int resp = 0;
        try {
            ArrayList<Parametro> lstP = new ArrayList<>();
            String sql = "INSERT INTO contrato(docente, fecha_contrato, sueldo) VALUES (?, ?, ?);";
            lstP.add(new Parametro(1, contrato.getDocente().getCodigo()));
            java.sql.Date sqldate = new java.sql.Date(contrato.getFecha_contrato().getTime());
            lstP.add(new Parametro(2, sqldate));
            lstP.add(new Parametro(3, contrato.getSueldo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            resp = 1;
        } catch (SQLException exConec) {
            resp = 0;
        }
        return resp;
    }

    public static ArrayList<Contrato> obtener() throws Exception {
        ArrayList<Contrato> resp = new ArrayList<>();
        try {
            String sql = "Select * from contrato;";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            if (rs != null) {
                resp = FContrato.llenar(rs);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return resp;
    }

    private static ArrayList<Contrato> llenar(ConjuntoResultado rs) throws Exception {
        ArrayList<Contrato> lstper = new ArrayList<>();
        try {
            while (rs.next()) {
                Contrato tmp = new Contrato(rs.getInt(0), new Docente(1), rs.getDate(2), rs.getInt(3));
                lstper.add(tmp);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return lstper;
    }
}
