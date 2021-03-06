package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TEstaCategoriaId generated by hbm2java
 */
@Embeddable
public class TEstaCategoriaId implements java.io.Serializable {

	private int codCategoria;
	private String desCategoria;

	public TEstaCategoriaId() {
	}

	public TEstaCategoriaId(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public TEstaCategoriaId(int codCategoria, String desCategoria) {
		this.codCategoria = codCategoria;
		this.desCategoria = desCategoria;
	}

	@Column(name = "cod_categoria", nullable = false)
	public int getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	@Column(name = "des_categoria", length = 50)
	public String getDesCategoria() {
		return this.desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TEstaCategoriaId))
			return false;
		TEstaCategoriaId castOther = (TEstaCategoriaId) other;

		return (this.getCodCategoria() == castOther.getCodCategoria())
				&& ((this.getDesCategoria() == castOther.getDesCategoria()) || (this
						.getDesCategoria() != null
						&& castOther.getDesCategoria() != null && this
						.getDesCategoria().equals(castOther.getDesCategoria())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodCategoria();
		result = 37
				* result
				+ (getDesCategoria() == null ? 0 : this.getDesCategoria()
						.hashCode());
		return result;
	}

}
