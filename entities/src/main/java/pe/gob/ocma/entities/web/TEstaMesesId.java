package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TEstaMesesId generated by hbm2java
 */
@Embeddable
public class TEstaMesesId implements java.io.Serializable {

	private int codMes;
	private String desMes;
	private String abrMes;

	public TEstaMesesId() {
	}

	public TEstaMesesId(int codMes) {
		this.codMes = codMes;
	}

	public TEstaMesesId(int codMes, String desMes, String abrMes) {
		this.codMes = codMes;
		this.desMes = desMes;
		this.abrMes = abrMes;
	}

	@Column(name = "cod_mes", nullable = false)
	public int getCodMes() {
		return this.codMes;
	}

	public void setCodMes(int codMes) {
		this.codMes = codMes;
	}

	@Column(name = "des_mes", length = 50)
	public String getDesMes() {
		return this.desMes;
	}

	public void setDesMes(String desMes) {
		this.desMes = desMes;
	}

	@Column(name = "abr_mes", length = 50)
	public String getAbrMes() {
		return this.abrMes;
	}

	public void setAbrMes(String abrMes) {
		this.abrMes = abrMes;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TEstaMesesId))
			return false;
		TEstaMesesId castOther = (TEstaMesesId) other;

		return (this.getCodMes() == castOther.getCodMes())
				&& ((this.getDesMes() == castOther.getDesMes()) || (this
						.getDesMes() != null && castOther.getDesMes() != null && this
						.getDesMes().equals(castOther.getDesMes())))
				&& ((this.getAbrMes() == castOther.getAbrMes()) || (this
						.getAbrMes() != null && castOther.getAbrMes() != null && this
						.getAbrMes().equals(castOther.getAbrMes())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodMes();
		result = 37 * result
				+ (getDesMes() == null ? 0 : this.getDesMes().hashCode());
		result = 37 * result
				+ (getAbrMes() == null ? 0 : this.getAbrMes().hashCode());
		return result;
	}

}
