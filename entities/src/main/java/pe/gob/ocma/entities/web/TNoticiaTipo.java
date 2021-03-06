package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TNoticiaTipo generated by hbm2java
 */
@Entity
@Table(name = "T_NOTICIA_TIPO", schema = "WEB")
public class TNoticiaTipo implements java.io.Serializable {

	private TNoticiaTipoId id;

	public TNoticiaTipo() {
	}

	public TNoticiaTipo(TNoticiaTipoId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idcategoria", column = @Column(name = "idcategoria", nullable = false)),
			@AttributeOverride(name = "descategoria", column = @Column(name = "descategoria", length = 100)) })
	public TNoticiaTipoId getId() {
		return this.id;
	}

	public void setId(TNoticiaTipoId id) {
		this.id = id;
	}

}
