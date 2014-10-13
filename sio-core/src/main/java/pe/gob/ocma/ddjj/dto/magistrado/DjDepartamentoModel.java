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
 * @author Gino Maquera Coyla
 * 25/9/2014 11:38:03
 */
public class DjDepartamentoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod_departamento;
	private String des_nombre;
	
	
	public String getCod_departamento() {
		return cod_departamento;
	}
	public void setCod_departamento(String cod_departamento) {
		this.cod_departamento = cod_departamento;
	}
	public String getDes_nombre() {
		return des_nombre;
	}
	public void setDes_nombre(String des_nombre) {
		this.des_nombre = des_nombre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
