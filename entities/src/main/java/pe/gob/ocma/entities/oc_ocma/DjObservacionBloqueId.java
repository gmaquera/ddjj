package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DjObservacionBloqueId generated by hbm2java
 */
@Embeddable
public class DjObservacionBloqueId implements java.io.Serializable {

	private int codObservacion;
	private int codBloque;
	private int codDj;

	public DjObservacionBloqueId() {
	}

	public DjObservacionBloqueId(int codObservacion, int codBloque, int codDj) {
		this.codObservacion = codObservacion;
		this.codBloque = codBloque;
		this.codDj = codDj;
	}

	@Column(name = "COD_OBSERVACION", nullable = false)
	public int getCodObservacion() {
		return this.codObservacion;
	}

	public void setCodObservacion(int codObservacion) {
		this.codObservacion = codObservacion;
	}

	@Column(name = "COD_BLOQUE", nullable = false)
	public int getCodBloque() {
		return this.codBloque;
	}

	public void setCodBloque(int codBloque) {
		this.codBloque = codBloque;
	}

	@Column(name = "COD_DJ", nullable = false)
	public int getCodDj() {
		return this.codDj;
	}

	public void setCodDj(int codDj) {
		this.codDj = codDj;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DjObservacionBloqueId))
			return false;
		DjObservacionBloqueId castOther = (DjObservacionBloqueId) other;

		return (this.getCodObservacion() == castOther.getCodObservacion())
				&& (this.getCodBloque() == castOther.getCodBloque())
				&& (this.getCodDj() == castOther.getCodDj());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodObservacion();
		result = 37 * result + this.getCodBloque();
		result = 37 * result + this.getCodDj();
		return result;
	}

}
