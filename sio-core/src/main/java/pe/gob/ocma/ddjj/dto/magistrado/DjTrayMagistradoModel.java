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
 * 16/09/2014 11:54:14
 */
public class DjTrayMagistradoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String num_resolucion;
	private String fecha_grilla;
	private String des_cargo;
	private String des_condicionlaboral;
	private String des_distritojudicial;
	
	
	
	public String getNum_resolucion() {
		return num_resolucion;
	}
	public void setNum_resolucion(String num_resolucion) {
		this.num_resolucion = num_resolucion;
	}
	public String getFecha_grilla() {
		return fecha_grilla;
	}
	public void setFecha_grilla(String fecha_grilla) {
		this.fecha_grilla = fecha_grilla;
	}
	public String getDes_cargo() {
		return des_cargo;
	}
	public void setDes_cargo(String des_cargo) {
		this.des_cargo = des_cargo;
	}
	public String getDes_condicionlaboral() {
		return des_condicionlaboral;
	}
	public void setDes_condicionlaboral(String des_condicionlaboral) {
		this.des_condicionlaboral = des_condicionlaboral;
	}
	public String getDes_distritojudicial() {
		return des_distritojudicial;
	}
	public void setDes_distritojudicial(String des_distritojudicial) {
		this.des_distritojudicial = des_distritojudicial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
