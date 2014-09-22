package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DjTipoAcreencia generated by hbm2java
 */
@Entity
@Table(name = "DJ_TIPO_ACREENCIA", schema = "OC_OCMA")
public class DjTipoAcreencia implements java.io.Serializable {

	private int codTipoAcreencia;
	private String desTipoAcreencia;
	private Integer flaTipoAcreencia;

	public DjTipoAcreencia() {
	}

	public DjTipoAcreencia(int codTipoAcreencia, String desTipoAcreencia) {
		this.codTipoAcreencia = codTipoAcreencia;
		this.desTipoAcreencia = desTipoAcreencia;
	}

	public DjTipoAcreencia(int codTipoAcreencia, String desTipoAcreencia,
			Integer flaTipoAcreencia) {
		this.codTipoAcreencia = codTipoAcreencia;
		this.desTipoAcreencia = desTipoAcreencia;
		this.flaTipoAcreencia = flaTipoAcreencia;
	}

	@Id
	@Column(name = "COD_TIPO_ACREENCIA", nullable = false)
	public int getCodTipoAcreencia() {
		return this.codTipoAcreencia;
	}

	public void setCodTipoAcreencia(int codTipoAcreencia) {
		this.codTipoAcreencia = codTipoAcreencia;
	}

	@Column(name = "DES_TIPO_ACREENCIA", nullable = false, length = 250)
	public String getDesTipoAcreencia() {
		return this.desTipoAcreencia;
	}

	public void setDesTipoAcreencia(String desTipoAcreencia) {
		this.desTipoAcreencia = desTipoAcreencia;
	}

	@Column(name = "FLA_TIPO_ACREENCIA")
	public Integer getFlaTipoAcreencia() {
		return this.flaTipoAcreencia;
	}

	public void setFlaTipoAcreencia(Integer flaTipoAcreencia) {
		this.flaTipoAcreencia = flaTipoAcreencia;
	}

}
