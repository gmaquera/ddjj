/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.ddjj.dto.magistrado;

import java.io.Serializable;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 18/09/2014 14:45:30
 */
public class DjInfoAcademicaCompModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cod_personal;
	private int cod_academica;
	private int cod_intacademica;
	private int c_estuiosup;
	private String des_cv_estudiosup;
	private String des_especialidad;
	private String des_centro_estudios;
	private String des_lugar;
	private String fec_inicio;
	private String fec_fin;
	private int num_horas;
	
	
	public int getCod_personal() {
		return cod_personal;
	}
	public void setCod_personal(int cod_personal) {
		this.cod_personal = cod_personal;
	}
	public int getCod_academica() {
		return cod_academica;
	}
	public void setCod_academica(int cod_academica) {
		this.cod_academica = cod_academica;
	}
	public int getCod_intacademica() {
		return cod_intacademica;
	}
	public void setCod_intacademica(int cod_intacademica) {
		this.cod_intacademica = cod_intacademica;
	}
	public int getC_estuiosup() {
		return c_estuiosup;
	}
	public void setC_estuiosup(int c_estuiosup) {
		this.c_estuiosup = c_estuiosup;
	}
	public String getDes_cv_estudiosup() {
		return des_cv_estudiosup;
	}
	public void setDes_cv_estudiosup(String des_cv_estudiosup) {
		this.des_cv_estudiosup = des_cv_estudiosup;
	}
	public String getDes_especialidad() {
		return des_especialidad;
	}
	public void setDes_especialidad(String des_especialidad) {
		this.des_especialidad = des_especialidad;
	}
	public String getDes_centro_estudios() {
		return des_centro_estudios;
	}
	public void setDes_centro_estudios(String des_centro_estudios) {
		this.des_centro_estudios = des_centro_estudios;
	}
	public String getDes_lugar() {
		return des_lugar;
	}
	public void setDes_lugar(String des_lugar) {
		this.des_lugar = des_lugar;
	}
	public String getFec_inicio() {
		return fec_inicio;
	}
	public void setFec_inicio(String fec_inicio) {
		this.fec_inicio = fec_inicio;
	}
	public String getFec_fin() {
		return fec_fin;
	}
	public void setFec_fin(String fec_fin) {
		this.fec_fin = fec_fin;
	}
	public int getNum_horas() {
		return num_horas;
	}
	public void setNum_horas(int num_horas) {
		this.num_horas = num_horas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
