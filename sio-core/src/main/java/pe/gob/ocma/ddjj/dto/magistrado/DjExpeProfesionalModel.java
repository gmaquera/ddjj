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
 * 19/09/2014 08:30:13
 */
public class DjExpeProfesionalModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int cod_personal;
	private int cod_experiencia;
	private int cod_intexperiencia;
	private String des_institucion;
	private String des_lugar;
	private String des_curso;
	private int c_cargo;
	private String des_cargo;
	private int c_condicionlaboral;
	private String des_condicionlaboral;
	private int c_distrito;
	private String des_distritojudicial;
	private String f_inicio;
	private String f_fin;
	private int cdocente;
	private String des_condicion_docente;
	private int cod_categoria_docente;
	private String des_categoria_docente;
	
	
	
	
	public int getCod_personal() {
		return cod_personal;
	}
	public void setCod_personal(int cod_personal) {
		this.cod_personal = cod_personal;
	}
	public int getCod_experiencia() {
		return cod_experiencia;
	}
	public void setCod_experiencia(int cod_experiencia) {
		this.cod_experiencia = cod_experiencia;
	}
	public int getCod_intexperiencia() {
		return cod_intexperiencia;
	}
	public void setCod_intexperiencia(int cod_intexperiencia) {
		this.cod_intexperiencia = cod_intexperiencia;
	}
	public String getDes_institucion() {
		return des_institucion;
	}
	public void setDes_institucion(String des_institucion) {
		this.des_institucion = des_institucion;
	}
	public String getDes_lugar() {
		return des_lugar;
	}
	public void setDes_lugar(String des_lugar) {
		this.des_lugar = des_lugar;
	}
	public String getDes_curso() {
		return des_curso;
	}
	public void setDes_curso(String des_curso) {
		this.des_curso = des_curso;
	}
	public int getC_cargo() {
		return c_cargo;
	}
	public void setC_cargo(int c_cargo) {
		this.c_cargo = c_cargo;
	}
	public String getDes_cargo() {
		return des_cargo;
	}
	public void setDes_cargo(String des_cargo) {
		this.des_cargo = des_cargo;
	}
	public int getC_condicionlaboral() {
		return c_condicionlaboral;
	}
	public void setC_condicionlaboral(int c_condicionlaboral) {
		this.c_condicionlaboral = c_condicionlaboral;
	}
	public String getDes_condicionlaboral() {
		return des_condicionlaboral;
	}
	public void setDes_condicionlaboral(String des_condicionlaboral) {
		this.des_condicionlaboral = des_condicionlaboral;
	}
	public int getC_distrito() {
		return c_distrito;
	}
	public void setC_distrito(int c_distrito) {
		this.c_distrito = c_distrito;
	}
	public String getDes_distritojudicial() {
		return des_distritojudicial;
	}
	public void setDes_distritojudicial(String des_distritojudicial) {
		this.des_distritojudicial = des_distritojudicial;
	}
	public String getF_inicio() {
		return f_inicio;
	}
	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}
	public String getF_fin() {
		return f_fin;
	}
	public void setF_fin(String f_fin) {
		this.f_fin = f_fin;
	}
	public int getCdocente() {
		return cdocente;
	}
	public void setCdocente(int cdocente) {
		this.cdocente = cdocente;
	}
	public String getDes_condicion_docente() {
		return des_condicion_docente;
	}
	public void setDes_condicion_docente(String des_condicion_docente) {
		this.des_condicion_docente = des_condicion_docente;
	}
	public int getCod_categoria_docente() {
		return cod_categoria_docente;
	}
	public void setCod_categoria_docente(int cod_categoria_docente) {
		this.cod_categoria_docente = cod_categoria_docente;
	}
	public String getDes_categoria_docente() {
		return des_categoria_docente;
	}
	public void setDes_categoria_docente(String des_categoria_docente) {
		this.des_categoria_docente = des_categoria_docente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
}
