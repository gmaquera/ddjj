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
 * 19/09/2014 08:40:43
 */
public class DjMeritoModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int cod_personal;
	private int cod_academica;
	private int cod_intacademica;
	private String des_centro_estudios;
	private int c_merito;
	private String des_cv_merito;
	private String des_merito;
	private String des_fecha;
	
	
	
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
	public String getDes_centro_estudios() {
		return des_centro_estudios;
	}
	public void setDes_centro_estudios(String des_centro_estudios) {
		this.des_centro_estudios = des_centro_estudios;
	}
	public int getC_merito() {
		return c_merito;
	}
	public void setC_merito(int c_merito) {
		this.c_merito = c_merito;
	}
	public String getDes_cv_merito() {
		return des_cv_merito;
	}
	public void setDes_cv_merito(String des_cv_merito) {
		this.des_cv_merito = des_cv_merito;
	}
	public String getDes_merito() {
		return des_merito;
	}
	public void setDes_merito(String des_merito) {
		this.des_merito = des_merito;
	}
	public String getDes_fecha() {
		return des_fecha;
	}
	public void setDes_fecha(String des_fecha) {
		this.des_fecha = des_fecha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
