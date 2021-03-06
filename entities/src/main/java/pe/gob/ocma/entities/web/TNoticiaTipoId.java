package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TNoticiaTipoId generated by hbm2java
 */
@Embeddable
public class TNoticiaTipoId implements java.io.Serializable {

	private int idcategoria;
	private String descategoria;

	public TNoticiaTipoId() {
	}

	public TNoticiaTipoId(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public TNoticiaTipoId(int idcategoria, String descategoria) {
		this.idcategoria = idcategoria;
		this.descategoria = descategoria;
	}

	@Column(name = "idcategoria", nullable = false)
	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	@Column(name = "descategoria", length = 100)
	public String getDescategoria() {
		return this.descategoria;
	}

	public void setDescategoria(String descategoria) {
		this.descategoria = descategoria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TNoticiaTipoId))
			return false;
		TNoticiaTipoId castOther = (TNoticiaTipoId) other;

		return (this.getIdcategoria() == castOther.getIdcategoria())
				&& ((this.getDescategoria() == castOther.getDescategoria()) || (this
						.getDescategoria() != null
						&& castOther.getDescategoria() != null && this
						.getDescategoria().equals(castOther.getDescategoria())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdcategoria();
		result = 37
				* result
				+ (getDescategoria() == null ? 0 : this.getDescategoria()
						.hashCode());
		return result;
	}

}
