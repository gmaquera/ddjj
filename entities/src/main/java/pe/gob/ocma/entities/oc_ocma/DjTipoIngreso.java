package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DjTipoIngreso generated by hbm2java
 */
@Entity
@Table(name = "DJ_TIPO_INGRESO", schema = "OC_OCMA")
public class DjTipoIngreso implements java.io.Serializable {

	private int codTipoIngreso;
	private String desTipoIngreso;
	private int flaTipoIngreso;
	private Integer flaIngreso;

	public DjTipoIngreso() {
	}

	public DjTipoIngreso(int codTipoIngreso, String desTipoIngreso,
			int flaTipoIngreso) {
		this.codTipoIngreso = codTipoIngreso;
		this.desTipoIngreso = desTipoIngreso;
		this.flaTipoIngreso = flaTipoIngreso;
	}

	public DjTipoIngreso(int codTipoIngreso, String desTipoIngreso,
			int flaTipoIngreso, Integer flaIngreso) {
		this.codTipoIngreso = codTipoIngreso;
		this.desTipoIngreso = desTipoIngreso;
		this.flaTipoIngreso = flaTipoIngreso;
		this.flaIngreso = flaIngreso;
	}

	@Id
	@Column(name = "COD_TIPO_INGRESO", nullable = false)
	public int getCodTipoIngreso() {
		return this.codTipoIngreso;
	}

	public void setCodTipoIngreso(int codTipoIngreso) {
		this.codTipoIngreso = codTipoIngreso;
	}

	@Column(name = "DES_TIPO_INGRESO", nullable = false, length = 250)
	public String getDesTipoIngreso() {
		return this.desTipoIngreso;
	}

	public void setDesTipoIngreso(String desTipoIngreso) {
		this.desTipoIngreso = desTipoIngreso;
	}

	@Column(name = "FLA_TIPO_INGRESO", nullable = false)
	public int getFlaTipoIngreso() {
		return this.flaTipoIngreso;
	}

	public void setFlaTipoIngreso(int flaTipoIngreso) {
		this.flaTipoIngreso = flaTipoIngreso;
	}

	@Column(name = "FLA_INGRESO")
	public Integer getFlaIngreso() {
		return this.flaIngreso;
	}

	public void setFlaIngreso(Integer flaIngreso) {
		this.flaIngreso = flaIngreso;
	}

}
