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
package pe.gob.ocma.intranet.dto;

import java.io.Serializable;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 19/9/2014 11:32:21
 */
public class LoginModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer cod_personal;
	private String nombre;
	private String cod_usuario;
	private Integer cod_distritojudicial;
	private Character fla_cambio_contrasenia_inicio;
	private String des_contrasena_limpia;
	
	public LoginModel() {	
	}

	public Integer getCod_personal() {
		return cod_personal;
	}

	public void setCod_personal(Integer cod_personal) {
		this.cod_personal = cod_personal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public Integer getCod_distritojudicial() {
		return cod_distritojudicial;
	}

	public void setCod_distritojudicial(Integer cod_distritojudicial) {
		this.cod_distritojudicial = cod_distritojudicial;
	}
	

	public Character getFla_cambio_contrasenia_inicio() {
		return fla_cambio_contrasenia_inicio;
	}

	public void setFla_cambio_contrasenia_inicio(
			Character fla_cambio_contrasenia_inicio) {
		this.fla_cambio_contrasenia_inicio = fla_cambio_contrasenia_inicio;
	}

	public String getDes_contrasena_limpia() {
		return des_contrasena_limpia;
	}

	public void setDes_contrasena_limpia(String des_contrasena_limpia) {
		this.des_contrasena_limpia = des_contrasena_limpia;
	}
	
	


}
