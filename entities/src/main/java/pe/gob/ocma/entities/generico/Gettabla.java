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
package pe.gob.ocma.entities.generico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO para las tablas de base de datos.
 * @author César Altamirano Menor
 * 26/09/2013 11:31:44
 */
@Entity
@Table(name = "GETTABLA", schema = "GENERICO")
public class Gettabla implements Serializable {

	private static final long serialVersionUID = 1L;

	private short codTabla;
	private String nomTabla;
	private String descripcion;

	public Gettabla() {
		super();
	}

	@Id
	@Column(name = "codTabla", nullable = false)
	public short getCodTabla() {
		return codTabla;
	}

	public void setCodTabla(short codTabla) {
		this.codTabla = codTabla;
	}

	@Column(name = "nomTabla", nullable = false, length = 20)
	public String getNomTabla() {
		return nomTabla;
	}

	public void setNomTabla(String nomTabla) {
		this.nomTabla = nomTabla;
	}

	@Column(name = "descripcion", nullable = true, length = 100)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
