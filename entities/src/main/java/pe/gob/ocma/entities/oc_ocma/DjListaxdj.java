package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DjListaxdj generated by hbm2java
 */
@Entity
@Table(name = "DJ_LISTAXDJ", schema = "OC_OCMA")
public class DjListaxdj implements java.io.Serializable {

	private DjListaxdjId id;
	private DjLista djLista;
	private DjMaster djMaster;
	private String desObservacion;

	public DjListaxdj() {
	}

	public DjListaxdj(DjListaxdjId id, DjLista djLista, DjMaster djMaster) {
		this.id = id;
		this.djLista = djLista;
		this.djMaster = djMaster;
	}

	public DjListaxdj(DjListaxdjId id, DjLista djLista, DjMaster djMaster,
			String desObservacion) {
		this.id = id;
		this.djLista = djLista;
		this.djMaster = djMaster;
		this.desObservacion = desObservacion;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codDj", column = @Column(name = "COD_DJ", nullable = false)),
			@AttributeOverride(name = "codLista", column = @Column(name = "COD_LISTA", nullable = false)) })
	public DjListaxdjId getId() {
		return this.id;
	}

	public void setId(DjListaxdjId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_LISTA", nullable = false, insertable = false, updatable = false)
	public DjLista getDjLista() {
		return this.djLista;
	}

	public void setDjLista(DjLista djLista) {
		this.djLista = djLista;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_DJ", nullable = false, insertable = false, updatable = false)
	public DjMaster getDjMaster() {
		return this.djMaster;
	}

	public void setDjMaster(DjMaster djMaster) {
		this.djMaster = djMaster;
	}

	@Column(name = "DES_OBSERVACION")
	public String getDesObservacion() {
		return this.desObservacion;
	}

	public void setDesObservacion(String desObservacion) {
		this.desObservacion = desObservacion;
	}

}
