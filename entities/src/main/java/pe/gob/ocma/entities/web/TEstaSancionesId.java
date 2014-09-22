package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TEstaSancionesId generated by hbm2java
 */
@Embeddable
public class TEstaSancionesId implements java.io.Serializable {

	private int codSancion;
	private Integer codConcepto;
	private Integer totalMagistrados;
	private Integer totalAux;
	private String desMes;
	private String desAnio;

	public TEstaSancionesId() {
	}

	public TEstaSancionesId(int codSancion) {
		this.codSancion = codSancion;
	}

	public TEstaSancionesId(int codSancion, Integer codConcepto,
			Integer totalMagistrados, Integer totalAux, String desMes,
			String desAnio) {
		this.codSancion = codSancion;
		this.codConcepto = codConcepto;
		this.totalMagistrados = totalMagistrados;
		this.totalAux = totalAux;
		this.desMes = desMes;
		this.desAnio = desAnio;
	}

	@Column(name = "cod_sancion", nullable = false)
	public int getCodSancion() {
		return this.codSancion;
	}

	public void setCodSancion(int codSancion) {
		this.codSancion = codSancion;
	}

	@Column(name = "cod_concepto")
	public Integer getCodConcepto() {
		return this.codConcepto;
	}

	public void setCodConcepto(Integer codConcepto) {
		this.codConcepto = codConcepto;
	}

	@Column(name = "total_magistrados")
	public Integer getTotalMagistrados() {
		return this.totalMagistrados;
	}

	public void setTotalMagistrados(Integer totalMagistrados) {
		this.totalMagistrados = totalMagistrados;
	}

	@Column(name = "total_aux")
	public Integer getTotalAux() {
		return this.totalAux;
	}

	public void setTotalAux(Integer totalAux) {
		this.totalAux = totalAux;
	}

	@Column(name = "des_mes", length = 50)
	public String getDesMes() {
		return this.desMes;
	}

	public void setDesMes(String desMes) {
		this.desMes = desMes;
	}

	@Column(name = "des_anio", length = 50)
	public String getDesAnio() {
		return this.desAnio;
	}

	public void setDesAnio(String desAnio) {
		this.desAnio = desAnio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TEstaSancionesId))
			return false;
		TEstaSancionesId castOther = (TEstaSancionesId) other;

		return (this.getCodSancion() == castOther.getCodSancion())
				&& ((this.getCodConcepto() == castOther.getCodConcepto()) || (this
						.getCodConcepto() != null
						&& castOther.getCodConcepto() != null && this
						.getCodConcepto().equals(castOther.getCodConcepto())))
				&& ((this.getTotalMagistrados() == castOther
						.getTotalMagistrados()) || (this.getTotalMagistrados() != null
						&& castOther.getTotalMagistrados() != null && this
						.getTotalMagistrados().equals(
								castOther.getTotalMagistrados())))
				&& ((this.getTotalAux() == castOther.getTotalAux()) || (this
						.getTotalAux() != null
						&& castOther.getTotalAux() != null && this
						.getTotalAux().equals(castOther.getTotalAux())))
				&& ((this.getDesMes() == castOther.getDesMes()) || (this
						.getDesMes() != null && castOther.getDesMes() != null && this
						.getDesMes().equals(castOther.getDesMes())))
				&& ((this.getDesAnio() == castOther.getDesAnio()) || (this
						.getDesAnio() != null && castOther.getDesAnio() != null && this
						.getDesAnio().equals(castOther.getDesAnio())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodSancion();
		result = 37
				* result
				+ (getCodConcepto() == null ? 0 : this.getCodConcepto()
						.hashCode());
		result = 37
				* result
				+ (getTotalMagistrados() == null ? 0 : this
						.getTotalMagistrados().hashCode());
		result = 37 * result
				+ (getTotalAux() == null ? 0 : this.getTotalAux().hashCode());
		result = 37 * result
				+ (getDesMes() == null ? 0 : this.getDesMes().hashCode());
		result = 37 * result
				+ (getDesAnio() == null ? 0 : this.getDesAnio().hashCode());
		return result;
	}

}
