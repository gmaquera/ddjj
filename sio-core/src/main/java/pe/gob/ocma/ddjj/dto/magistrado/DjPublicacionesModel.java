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
 * 19/09/2014 08:36:06
 */
public class DjPublicacionesModel implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private int cod_personal;
	private int cod_inv_pub;
	private int cod_intinv_pub;
	private String des_inv_pub;
	private String des_titulo;
	private String des_detalle;
	private String fec_publicacion;
	
	
	public int getCod_personal() {
		return cod_personal;
	}
	public void setCod_personal(int cod_personal) {
		this.cod_personal = cod_personal;
	}
	public int getCod_inv_pub() {
		return cod_inv_pub;
	}
	public void setCod_inv_pub(int cod_inv_pub) {
		this.cod_inv_pub = cod_inv_pub;
	}
	public int getCod_intinv_pub() {
		return cod_intinv_pub;
	}
	public void setCod_intinv_pub(int cod_intinv_pub) {
		this.cod_intinv_pub = cod_intinv_pub;
	}
	public String getDes_inv_pub() {
		return des_inv_pub;
	}
	public void setDes_inv_pub(String des_inv_pub) {
		this.des_inv_pub = des_inv_pub;
	}
	public String getDes_titulo() {
		return des_titulo;
	}
	public void setDes_titulo(String des_titulo) {
		this.des_titulo = des_titulo;
	}
	public String getDes_detalle() {
		return des_detalle;
	}
	public void setDes_detalle(String des_detalle) {
		this.des_detalle = des_detalle;
	}
	public String getFec_publicacion() {
		return fec_publicacion;
	}
	public void setFec_publicacion(String fec_publicacion) {
		this.fec_publicacion = fec_publicacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
