package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TPrensaDetalleFotoId generated by hbm2java
 */
@Embeddable
public class TPrensaDetalleFotoId implements java.io.Serializable {

	private Integer idDetalle;
	private Integer codNoticia;
	private String nomFoto;
	private String des;
	private Integer flaActivo;

	public TPrensaDetalleFotoId() {
	}

	public TPrensaDetalleFotoId(Integer idDetalle, Integer codNoticia,
			String nomFoto, String des, Integer flaActivo) {
		this.idDetalle = idDetalle;
		this.codNoticia = codNoticia;
		this.nomFoto = nomFoto;
		this.des = des;
		this.flaActivo = flaActivo;
	}

	@Column(name = "ID_DETALLE")
	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	@Column(name = "COD_NOTICIA")
	public Integer getCodNoticia() {
		return this.codNoticia;
	}

	public void setCodNoticia(Integer codNoticia) {
		this.codNoticia = codNoticia;
	}

	@Column(name = "NOM_FOTO")
	public String getNomFoto() {
		return this.nomFoto;
	}

	public void setNomFoto(String nomFoto) {
		this.nomFoto = nomFoto;
	}

	@Column(name = "DES")
	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Column(name = "FLA_ACTIVO")
	public Integer getFlaActivo() {
		return this.flaActivo;
	}

	public void setFlaActivo(Integer flaActivo) {
		this.flaActivo = flaActivo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TPrensaDetalleFotoId))
			return false;
		TPrensaDetalleFotoId castOther = (TPrensaDetalleFotoId) other;

		return ((this.getIdDetalle() == castOther.getIdDetalle()) || (this
				.getIdDetalle() != null && castOther.getIdDetalle() != null && this
				.getIdDetalle().equals(castOther.getIdDetalle())))
				&& ((this.getCodNoticia() == castOther.getCodNoticia()) || (this
						.getCodNoticia() != null
						&& castOther.getCodNoticia() != null && this
						.getCodNoticia().equals(castOther.getCodNoticia())))
				&& ((this.getNomFoto() == castOther.getNomFoto()) || (this
						.getNomFoto() != null && castOther.getNomFoto() != null && this
						.getNomFoto().equals(castOther.getNomFoto())))
				&& ((this.getDes() == castOther.getDes()) || (this.getDes() != null
						&& castOther.getDes() != null && this.getDes().equals(
						castOther.getDes())))
				&& ((this.getFlaActivo() == castOther.getFlaActivo()) || (this
						.getFlaActivo() != null
						&& castOther.getFlaActivo() != null && this
						.getFlaActivo().equals(castOther.getFlaActivo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdDetalle() == null ? 0 : this.getIdDetalle().hashCode());
		result = 37
				* result
				+ (getCodNoticia() == null ? 0 : this.getCodNoticia()
						.hashCode());
		result = 37 * result
				+ (getNomFoto() == null ? 0 : this.getNomFoto().hashCode());
		result = 37 * result
				+ (getDes() == null ? 0 : this.getDes().hashCode());
		result = 37 * result
				+ (getFlaActivo() == null ? 0 : this.getFlaActivo().hashCode());
		return result;
	}

}
