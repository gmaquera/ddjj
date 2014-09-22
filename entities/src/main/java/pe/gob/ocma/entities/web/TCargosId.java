package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TCargosId generated by hbm2java
 */
@Embeddable
public class TCargosId implements java.io.Serializable {

	private int codCargo;
	private String desCargo;

	public TCargosId() {
	}

	public TCargosId(int codCargo) {
		this.codCargo = codCargo;
	}

	public TCargosId(int codCargo, String desCargo) {
		this.codCargo = codCargo;
		this.desCargo = desCargo;
	}

	@Column(name = "cod_cargo", nullable = false)
	public int getCodCargo() {
		return this.codCargo;
	}

	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}

	@Column(name = "des_cargo")
	public String getDesCargo() {
		return this.desCargo;
	}

	public void setDesCargo(String desCargo) {
		this.desCargo = desCargo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TCargosId))
			return false;
		TCargosId castOther = (TCargosId) other;

		return (this.getCodCargo() == castOther.getCodCargo())
				&& ((this.getDesCargo() == castOther.getDesCargo()) || (this
						.getDesCargo() != null
						&& castOther.getDesCargo() != null && this
						.getDesCargo().equals(castOther.getDesCargo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodCargo();
		result = 37 * result
				+ (getDesCargo() == null ? 0 : this.getDesCargo().hashCode());
		return result;
	}

}
