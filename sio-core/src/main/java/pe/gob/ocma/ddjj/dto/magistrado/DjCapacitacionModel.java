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
 * 22/09/2014 08:24:49
 */
public class DjCapacitacionModel implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	private int cod_personal;
	private int cod_academica;
	private int cod_intacademica;
	private int c_actividad;
	private String des_cv_actividad;
	private String des_especialidad;
	private String des_centro_estudios;
	private int num_horas;
	private int c_participacion;
	private String des_cv_participacion;
	private String fec_inicio;
	private String fec_fin;
	
	
	
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
	public int getC_actividad() {
		return c_actividad;
	}
	public void setC_actividad(int c_actividad) {
		this.c_actividad = c_actividad;
	}
	public String getDes_cv_actividad() {
		return des_cv_actividad;
	}
	public void setDes_cv_actividad(String des_cv_actividad) {
		this.des_cv_actividad = des_cv_actividad;
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
	public int getNum_horas() {
		return num_horas;
	}
	public void setNum_horas(int num_horas) {
		this.num_horas = num_horas;
	}
	public int getC_participacion() {
		return c_participacion;
	}
	public void setC_participacion(int c_participacion) {
		this.c_participacion = c_participacion;
	}
	public String getDes_cv_participacion() {
		return des_cv_participacion;
	}
	public void setDes_cv_participacion(String des_cv_participacion) {
		this.des_cv_participacion = des_cv_participacion;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

}
