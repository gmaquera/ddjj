package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TPrensaDetalleFoto generated by hbm2java
 */
@Entity
@Table(name = "T_PRENSA_DETALLE_FOTO", schema = "WEB")
public class TPrensaDetalleFoto implements java.io.Serializable {

	private TPrensaDetalleFotoId id;

	public TPrensaDetalleFoto() {
	}

	public TPrensaDetalleFoto(TPrensaDetalleFotoId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idDetalle", column = @Column(name = "ID_DETALLE")),
			@AttributeOverride(name = "codNoticia", column = @Column(name = "COD_NOTICIA")),
			@AttributeOverride(name = "nomFoto", column = @Column(name = "NOM_FOTO")),
			@AttributeOverride(name = "des", column = @Column(name = "DES")),
			@AttributeOverride(name = "flaActivo", column = @Column(name = "FLA_ACTIVO")) })
	public TPrensaDetalleFotoId getId() {
		return this.id;
	}

	public void setId(TPrensaDetalleFotoId id) {
		this.id = id;
	}

}
