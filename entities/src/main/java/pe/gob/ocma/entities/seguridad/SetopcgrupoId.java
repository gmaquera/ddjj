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

import javax.persistence.Column;

/**
 * clase de persistencia
 * @author César Altamirano Menor
 * 02/09/2013 13:00:14
 */
public class SetopcgrupoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codOpcion;
	private int codGrupo;

	public SetopcgrupoId() {
	}

	public SetopcgrupoId(int codOpcion, int codGrupo) {
		this.codOpcion = codOpcion;
		this.codGrupo = codGrupo;
	}

	@Column(name = "codOpcion", nullable = false)
	public int getCodOpcion() {
		return this.codOpcion;
	}

	public void setCodOpcion(int codOpcion) {
		this.codOpcion = codOpcion;
	}

	@Column(name = "codGrupo", nullable = false)
	public int getCodGrupo() {
		return this.codGrupo;
	}

	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SetopcgrupoId))
			return false;
		SetopcgrupoId castOther = (SetopcgrupoId) other;

		return (this.getCodOpcion() == castOther.getCodOpcion())
				&& (this.getCodGrupo() == castOther.getCodGrupo());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodOpcion();
		result = 37 * result + this.getCodGrupo();
		return result;
	}
}
