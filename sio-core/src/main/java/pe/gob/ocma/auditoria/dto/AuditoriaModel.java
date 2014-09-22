/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión de los requerimientos del
 * personal de la OCMA. Constiene las funcionalidades desde
 * que el solicitante realiza una solicitud de un requerimiento 
 * hasta que es atendido por el personal encargado.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.auditoria.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase POJO, Modelo para mostrar los datos.
 * @author César Altamirano Menor
 * 14/10/2013 12:11:20
 */
public class AuditoriaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long codTraza;
	private String nomTabla;
	private String desOperacion;
	private String usuario;
	private String clavePrimaria;
	private String campos;
	private String datos;
	private Date fecha;

	public AuditoriaModel() {
		super();
	}

	public long getCodTraza() {
		return codTraza;
	}

	public void setCodTraza(long codTraza) {
		this.codTraza = codTraza;
	}

	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	public String getDesOperacion() {
		return desOperacion;
	}

	public void setDesOperacion(String desOperacion) {
		this.desOperacion = desOperacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClavePrimaria() {
		return clavePrimaria;
	}

	public void setClavePrimaria(String clavePrimaria) {
		this.clavePrimaria = clavePrimaria;
	}

	public String getCampos() {
		return campos;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
