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
 * 15/09/2014 16:25:56
 */
public class DjInfoLaboralModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String detalle_area;
	private String des_funcio;
	private String fec_inicio_cargo;
	private String des_direccion;
	private String num_telefono;
	private int edad;
	
	
	
	public String getDetalle_area() {
		return detalle_area;
	}
	public void setDetalle_area(String detalle_area) {
		this.detalle_area = detalle_area;
	}
	public String getDes_funcio() {
		return des_funcio;
	}
	public void setDes_funcio(String des_funcio) {
		this.des_funcio = des_funcio;
	}
	public String getDes_direccion() {
		return des_direccion;
	}
	public void setDes_direccion(String des_direccion) {
		this.des_direccion = des_direccion;
	}
	public String getNum_telefono() {
		return num_telefono;
	}
	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFec_inicio_cargo() {
		return fec_inicio_cargo;
	}
	public void setFec_inicio_cargo(String fec_inicio_cargo) {
		this.fec_inicio_cargo = fec_inicio_cargo;
	}
	
	
	

}
