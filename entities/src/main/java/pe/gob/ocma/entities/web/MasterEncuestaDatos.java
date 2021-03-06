package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MasterEncuestaDatos generated by hbm2java
 */
@Entity
@Table(name = "master_encuesta_datos", schema = "WEB")
public class MasterEncuestaDatos implements java.io.Serializable {

	private MasterEncuestaDatosId id;

	public MasterEncuestaDatos() {
	}

	public MasterEncuestaDatos(MasterEncuestaDatosId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id")),
			@AttributeOverride(name = "doc", column = @Column(name = "doc", length = 20)),
			@AttributeOverride(name = "nom", column = @Column(name = "nom", length = 50)),
			@AttributeOverride(name = "categ", column = @Column(name = "categ")),
			@AttributeOverride(name = "fecha", column = @Column(name = "fecha", length = 26)),
			@AttributeOverride(name = "distJud", column = @Column(name = "dist_jud")),
			@AttributeOverride(name = "orgJuris", column = @Column(name = "org_juris", length = 50)),
			@AttributeOverride(name = "espec", column = @Column(name = "espec")),
			@AttributeOverride(name = "obs", column = @Column(name = "obs")),
			@AttributeOverride(name = "flaRegistro", column = @Column(name = "fla_registro")) })
	public MasterEncuestaDatosId getId() {
		return this.id;
	}

	public void setId(MasterEncuestaDatosId id) {
		this.id = id;
	}

}
