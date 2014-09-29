package pe.gob.ocma.entities.web_ocma;

// Generated 29/09/2014 11:43:47 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TablaEstadoCivil generated by hbm2java
 */
@Entity
@Table(name = "TABLA_ESTADO_CIVIL", schema = "WEB_OCMA")
public class TablaEstadoCivil implements java.io.Serializable {

	private int codEstadocivil;
	private String desEstadocivil;
	private char flaEstado;
	private Set<PersonalInfo> personalInfos = new HashSet<PersonalInfo>(0);

	public TablaEstadoCivil() {
	}

	public TablaEstadoCivil(int codEstadocivil, String desEstadocivil,
			char flaEstado) {
		this.codEstadocivil = codEstadocivil;
		this.desEstadocivil = desEstadocivil;
		this.flaEstado = flaEstado;
	}

	public TablaEstadoCivil(int codEstadocivil, String desEstadocivil,
			char flaEstado, Set<PersonalInfo> personalInfos) {
		this.codEstadocivil = codEstadocivil;
		this.desEstadocivil = desEstadocivil;
		this.flaEstado = flaEstado;
		this.personalInfos = personalInfos;
	}

	@Id
	@Column(name = "COD_ESTADOCIVIL", nullable = false)
	public int getCodEstadocivil() {
		return this.codEstadocivil;
	}

	public void setCodEstadocivil(int codEstadocivil) {
		this.codEstadocivil = codEstadocivil;
	}

	@Column(name = "DES_ESTADOCIVIL", nullable = false, length = 40)
	public String getDesEstadocivil() {
		return this.desEstadocivil;
	}

	public void setDesEstadocivil(String desEstadocivil) {
		this.desEstadocivil = desEstadocivil;
	}

	@Column(name = "FLA_ESTADO", nullable = false, length = 1)
	public char getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(char flaEstado) {
		this.flaEstado = flaEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tablaEstadoCivil")
	public Set<PersonalInfo> getPersonalInfos() {
		return this.personalInfos;
	}

	public void setPersonalInfos(Set<PersonalInfo> personalInfos) {
		this.personalInfos = personalInfos;
	}

}
