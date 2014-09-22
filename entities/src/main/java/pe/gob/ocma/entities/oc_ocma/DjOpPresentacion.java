package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DjOpPresentacion generated by hbm2java
 */
@Entity
@Table(name = "DJ_OP_PRESENTACION", schema = "OC_OCMA")
public class DjOpPresentacion implements java.io.Serializable {

	private int codPresentacion;
	private String desNombre;
	private Set<DjMaster> djMasters = new HashSet<DjMaster>(0);

	public DjOpPresentacion() {
	}

	public DjOpPresentacion(int codPresentacion) {
		this.codPresentacion = codPresentacion;
	}

	public DjOpPresentacion(int codPresentacion, String desNombre,
			Set<DjMaster> djMasters) {
		this.codPresentacion = codPresentacion;
		this.desNombre = desNombre;
		this.djMasters = djMasters;
	}

	@Id
	@Column(name = "COD_PRESENTACION", unique = true, nullable = false)
	public int getCodPresentacion() {
		return this.codPresentacion;
	}

	public void setCodPresentacion(int codPresentacion) {
		this.codPresentacion = codPresentacion;
	}

	@Column(name = "DES_NOMBRE", length = 200)
	public String getDesNombre() {
		return this.desNombre;
	}

	public void setDesNombre(String desNombre) {
		this.desNombre = desNombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "djOpPresentacion")
	public Set<DjMaster> getDjMasters() {
		return this.djMasters;
	}

	public void setDjMasters(Set<DjMaster> djMasters) {
		this.djMasters = djMasters;
	}

}
