package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DjListaxdjId generated by hbm2java
 */
@Embeddable
public class DjListaxdjId implements java.io.Serializable {

	private int codDj;
	private int codLista;

	public DjListaxdjId() {
	}

	public DjListaxdjId(int codDj, int codLista) {
		this.codDj = codDj;
		this.codLista = codLista;
	}

	@Column(name = "COD_DJ", nullable = false)
	public int getCodDj() {
		return this.codDj;
	}

	public void setCodDj(int codDj) {
		this.codDj = codDj;
	}

	@Column(name = "COD_LISTA", nullable = false)
	public int getCodLista() {
		return this.codLista;
	}

	public void setCodLista(int codLista) {
		this.codLista = codLista;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DjListaxdjId))
			return false;
		DjListaxdjId castOther = (DjListaxdjId) other;

		return (this.getCodDj() == castOther.getCodDj())
				&& (this.getCodLista() == castOther.getCodLista());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodDj();
		result = 37 * result + this.getCodLista();
		return result;
	}

}
