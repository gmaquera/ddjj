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
 * 18/09/2014 13:29:37
 */
public class DjInfoAcademicaModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// MODEL INFO ACADEMICA

	private int cod_personal;
	private int cod_academica;
	private int cod_intacademica;
	private int c_titulo;
	private int cod_sector;
	private String des_sector;
	private int cod_cv_nivel;
	private String des_cv_nivel;
	private String des_cv_titulo;
	private String des_especialidad;
	private String des_centro_estudios;
	private String num_colegiatura;
	private String des_lugar;
	private String des_ano_inicio;
	private String des_ano_fin;
	private int num_semestre;
	
	
	
	
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
	public int getC_titulo() {
		return c_titulo;
	}
	public void setC_titulo(int c_titulo) {
		this.c_titulo = c_titulo;
	}
	public int getCod_sector() {
		return cod_sector;
	}
	public void setCod_sector(int cod_sector) {
		this.cod_sector = cod_sector;
	}
	public String getDes_sector() {
		return des_sector;
	}
	public void setDes_sector(String des_sector) {
		this.des_sector = des_sector;
	}
	public int getCod_cv_nivel() {
		return cod_cv_nivel;
	}
	public void setCod_cv_nivel(int cod_cv_nivel) {
		this.cod_cv_nivel = cod_cv_nivel;
	}
	public String getDes_cv_nivel() {
		return des_cv_nivel;
	}
	public void setDes_cv_nivel(String des_cv_nivel) {
		this.des_cv_nivel = des_cv_nivel;
	}
	public String getDes_cv_titulo() {
		return des_cv_titulo;
	}
	public void setDes_cv_titulo(String des_cv_titulo) {
		this.des_cv_titulo = des_cv_titulo;
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
	public String getNum_colegiatura() {
		return num_colegiatura;
	}
	public void setNum_colegiatura(String num_colegiatura) {
		this.num_colegiatura = num_colegiatura;
	}
	public String getDes_lugar() {
		return des_lugar;
	}
	public void setDes_lugar(String des_lugar) {
		this.des_lugar = des_lugar;
	}
	public String getDes_ano_inicio() {
		return des_ano_inicio;
	}
	public void setDes_ano_inicio(String des_ano_inicio) {
		this.des_ano_inicio = des_ano_inicio;
	}
	public String getDes_ano_fin() {
		return des_ano_fin;
	}
	public void setDes_ano_fin(String des_ano_fin) {
		this.des_ano_fin = des_ano_fin;
	}
	public int getNum_semestre() {
		return num_semestre;
	}
	public void setNum_semestre(int num_semestre) {
		this.num_semestre = num_semestre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
