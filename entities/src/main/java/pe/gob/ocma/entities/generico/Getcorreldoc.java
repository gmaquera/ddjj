package pe.gob.ocma.entities.generico;

// Generated 02/09/2013 10:25:33 AM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Getcorreldoc generated by hbm2java
 */
@Entity
@Table(name = "GETCORRELDOC", schema = "GENERICO")
public class Getcorreldoc implements java.io.Serializable {

	private GetcorreldocId id;
	private short numDocAncho;
	private boolean habilitado;

	public Getcorreldoc() {
	}

	public Getcorreldoc(GetcorreldocId id, boolean habilitado) {
		this.id = id;
		this.habilitado = habilitado;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codTipDoc", column = @Column(name = "codTipDoc", nullable = false)),
			@AttributeOverride(name = "anio", column = @Column(name = "anio", nullable = false)),
			@AttributeOverride(name = "numDoc", column = @Column(name = "numDoc", nullable = false)) })
	public GetcorreldocId getId() {
		return this.id;
	}

	public void setId(GetcorreldocId id) {
		this.id = id;
	}

	@Column(name = "numDocAncho", nullable = false)
	public short getNumDocAncho() {
		return numDocAncho;
	}

	public void setNumDocAncho(short numDocAncho) {
		this.numDocAncho = numDocAncho;
	}

	@Column(name = "habilitado", nullable = false)
	public boolean isHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
