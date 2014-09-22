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

import pe.gob.ocma.common.util.ConstanteCore;

/**
 * Clase POJO, Modelo para mostrar los datos.
 * @author César Altamirano Menor
 * 10/10/2013 15:19:56
 */
public class AuditoriaFechasModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private long codTraza;
	private String nomTabla;
	private String desOperacion;
	private String usuario;
	private String clavePrimaria;
	private String campos;
	private String datos;
	private Date fecha;
	private int cantColumnas;
	private String[] cabecera;
	private String[] detalle;
	
	public AuditoriaFechasModel() {
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
		if(!this.desOperacion.equals(ConstanteCore.ACCION_CONSULTA) && campos != null){
			this.cabecera = campos.split("\\|");
			this.cantColumnas = cabecera.length;
		}
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
		if(datos != null) {
			this.detalle = datos.split("\\|");
		}
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantColumnas() {
		return cantColumnas;
	}

	public String[] getCabecera() {
		return cabecera;
	}

	public String[] getDetalle() {
		return detalle;
	}
}
