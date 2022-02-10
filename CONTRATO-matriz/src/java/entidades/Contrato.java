/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author msgoon6
 */
public class Contrato {

    private Integer codigo;
    private Docente docente;
    private Date fecha_contrato;
    private Integer sueldo;

    public Contrato(Integer codigo, Docente docente, Date fecha_contrato, Integer sueldo) {
        this.codigo = codigo;
        this.docente = docente;
        this.fecha_contrato = fecha_contrato;
        this.sueldo = sueldo;
    }

    public Contrato(Integer codigo) {
        this.codigo = codigo;
    }

    public Contrato() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Date getFecha_contrato() {
        return fecha_contrato;
    }

    public void setFecha_contrato(Date fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
}
