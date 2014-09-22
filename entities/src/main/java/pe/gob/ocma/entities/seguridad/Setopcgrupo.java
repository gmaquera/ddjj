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
package pe.gob.ocma.entities.seguridad;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase de persistencia
 * @author César Altamirano Menor
 * 02/09/2013 12:56:34
 */
@Entity
@Table(name = "SETOPCGRUPO", schema = "SEGURIDAD")
public class Setopcgrupo implements Serializable {

	private static final long serialVersionUID = 1L;
	private SetopcgrupoId id;
	private Setopcion setopcion;
	private Setgrupo setgrupo;

	public Setopcgrupo() {
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codOpcion", column = @Column(name = "codOpcion", nullable = false)),
			@AttributeOverride(name = "codGrupo", column = @Column(name = "codGrupo", nullable = false)) })
	public SetopcgrupoId getId() {
		return this.id;
	}

	public void setId(SetopcgrupoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codOpcion", nullable = false, insertable = false, updatable = false)
	public Setopcion getSetopcion() {
		return this.setopcion;
	}

	public void setSetopcion(Setopcion setopcion) {
		this.setopcion = setopcion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codGrupo", nullable = false, insertable = false, updatable = false)
	public Setgrupo getSetgrupo() {
		return this.setgrupo;
	}

	public void setSetgrupo(Setgrupo setgrupo) {
		this.setgrupo = setgrupo;
	}
}
