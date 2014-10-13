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
 * 25/9/2014 11:38:17
 */
public class DjEstadoCivilModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int cod_estadocivil;
	private String des_estadocivil;
	private Character fla_estado;
	
	
	
	public int getCod_estadocivil() {
		return cod_estadocivil;
	}
	public void setCod_estadocivil(int cod_estadocivil) {
		this.cod_estadocivil = cod_estadocivil;
	}
	public String getDes_estadocivil() {
		return des_estadocivil;
	}
	public void setDes_estadocivil(String des_estadocivil) {
		this.des_estadocivil = des_estadocivil;
	}
	public Character getFla_estado() {
		return fla_estado;
	}
	public void setFla_estado(Character fla_estado) {
		this.fla_estado = fla_estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
}
