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
 * 18/09/2014 15:06:25
 */
public class DjCapacitacionIdiomaModel implements Serializable{

	
	
	private static final long serialVersionUID = 1L;
	
	private int cod_personal;
	private int cod_academica;
	private int cod_intacademica; 
	private String des_especialidad;
	private String des_centro_estudios; 
	private int cod_cv_nivel_idioma;
	private String des_cv_nivel_idioma;
	
	
	
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
	public int getCod_cv_nivel_idioma() {
		return cod_cv_nivel_idioma;
	}
	public void setCod_cv_nivel_idioma(int cod_cv_nivel_idioma) {
		this.cod_cv_nivel_idioma = cod_cv_nivel_idioma;
	}
	public String getDes_cv_nivel_idioma() {
		return des_cv_nivel_idioma;
	}
	public void setDes_cv_nivel_idioma(String des_cv_nivel_idioma) {
		this.des_cv_nivel_idioma = des_cv_nivel_idioma;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
}
