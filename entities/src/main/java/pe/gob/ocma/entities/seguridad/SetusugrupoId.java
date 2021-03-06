package pe.gob.ocma.entities.seguridad;

// Generated 02/09/2013 12:50:05 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SetusugrupoId generated by hbm2java
 */
@Embeddable
public class SetusugrupoId implements java.io.Serializable {

	private int codGrupo;
	private String codUsuario;

	public SetusugrupoId() {
	}

	public SetusugrupoId(int codGrupo, String codUsuario) {
		this.codGrupo = codGrupo;
		this.codUsuario = codUsuario;
	}

	@Column(name = "codGrupo", nullable = false)
	public int getCodGrupo() {
		return this.codGrupo;
	}

	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}

	@Column(name = "codUsuario", nullable = false)
	public String getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SetusugrupoId))
			return false;
		SetusugrupoId castOther = (SetusugrupoId) other;

		return (this.getCodGrupo() == castOther.getCodGrupo())
				&& (this.getCodUsuario() == castOther.getCodUsuario());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodGrupo();
		result = 37 * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
		return result;
	}
}
