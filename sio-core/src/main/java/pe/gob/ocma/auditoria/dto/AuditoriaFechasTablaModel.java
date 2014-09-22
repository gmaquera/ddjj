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
 * 14/10/2013 10:59:44
 */
public class AuditoriaFechasTablaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long codTraza;
	private String desOperacion;
	private String usuario;
	private String clavePrimaria;
	private Date fecha;
	private String[] datos;
	private int colspan;
	
	public AuditoriaFechasTablaModel() {
	}

	public long getCodTraza() {
		return codTraza;
	}

	public void setCodTraza(long codTraza) {
		this.codTraza = codTraza;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String[] getDatos() {
		return datos;
	}

	public void setDatos(String[] datos) {
		this.datos = datos;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}
}