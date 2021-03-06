package pe.gob.ocma.entities.web_ocma;

// Generated 19/09/2014 11:18:41 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GrupoModuloId generated by hbm2java
 */
@Embeddable
public class GrupoModuloId implements java.io.Serializable {

	private String codGrupo;
	private int codModulo;
	private int codPrivilegio;

	public GrupoModuloId() {
	}

	public GrupoModuloId(String codGrupo, int codModulo, int codPrivilegio) {
		this.codGrupo = codGrupo;
		this.codModulo = codModulo;
		this.codPrivilegio = codPrivilegio;
	}

	@Column(name = "COD_GRUPO", nullable = false, length = 10)
	public String getCodGrupo() {
		return this.codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	@Column(name = "COD_MODULO", nullable = false)
	public int getCodModulo() {
		return this.codModulo;
	}

	public void setCodModulo(int codModulo) {
		this.codModulo = codModulo;
	}

	@Column(name = "COD_PRIVILEGIO", nullable = false)
	public int getCodPrivilegio() {
		return this.codPrivilegio;
	}

	public void setCodPrivilegio(int codPrivilegio) {
		this.codPrivilegio = codPrivilegio;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GrupoModuloId))
			return false;
		GrupoModuloId castOther = (GrupoModuloId) other;

		return ((this.getCodGrupo() == castOther.getCodGrupo()) || (this
				.getCodGrupo() != null && castOther.getCodGrupo() != null && this
				.getCodGrupo().equals(castOther.getCodGrupo())))
				&& (this.getCodModulo() == castOther.getCodModulo())
				&& (this.getCodPrivilegio() == castOther.getCodPrivilegio());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodGrupo() == null ? 0 : this.getCodGrupo().hashCode());
		result = 37 * result + this.getCodModulo();
		result = 37 * result + this.getCodPrivilegio();
		return result;
	}

}
