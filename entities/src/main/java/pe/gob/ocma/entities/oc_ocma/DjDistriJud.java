package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DjDistriJud generated by hbm2java
 */
@Entity
@Table(name = "DJ_DISTRI_JUD", schema = "OC_OCMA")
public class DjDistriJud implements java.io.Serializable {

	private int codDistri;
	private String desDistri;
	private Integer flaEstado;
	private String desDireccion;

	public DjDistriJud() {
	}

	public DjDistriJud(int codDistri) {
		this.codDistri = codDistri;
	}

	public DjDistriJud(int codDistri, String desDistri, Integer flaEstado,
			String desDireccion) {
		this.codDistri = codDistri;
		this.desDistri = desDistri;
		this.flaEstado = flaEstado;
		this.desDireccion = desDireccion;
	}

	@Id
	@Column(name = "COD_DISTRI", nullable = false)
	public int getCodDistri() {
		return this.codDistri;
	}

	public void setCodDistri(int codDistri) {
		this.codDistri = codDistri;
	}

	@Column(name = "DES_DISTRI", length = 25)
	public String getDesDistri() {
		return this.desDistri;
	}

	public void setDesDistri(String desDistri) {
		this.desDistri = desDistri;
	}

	@Column(name = "FLA_ESTADO")
	public Integer getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(Integer flaEstado) {
		this.flaEstado = flaEstado;
	}

	@Column(name = "DES_DIRECCION", length = 100)
	public String getDesDireccion() {
		return this.desDireccion;
	}

	public void setDesDireccion(String desDireccion) {
		this.desDireccion = desDireccion;
	}

}
