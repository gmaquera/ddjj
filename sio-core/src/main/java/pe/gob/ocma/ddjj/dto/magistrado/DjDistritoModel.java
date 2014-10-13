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
 * 25/9/2014 11:38:56
 */
public class DjDistritoModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod_distrito;
	private String des_nombre;
	
	
	public String getCod_distrito() {
		return cod_distrito;
	}
	public void setCod_distrito(String cod_distrito) {
		this.cod_distrito = cod_distrito;
	}
	public String getDes_nombre() {
		return des_nombre;
	}
	public void setDes_nombre(String des_nombre) {
		this.des_nombre = des_nombre;
	}

	
	
	
}
