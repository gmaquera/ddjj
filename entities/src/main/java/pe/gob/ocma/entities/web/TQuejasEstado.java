package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TQuejasEstado generated by hbm2java
 */
@Entity
@Table(name = "T_QUEJAS_ESTADO", schema = "WEB")
public class TQuejasEstado implements java.io.Serializable {

	private int codEstado;
	private String desEstado;
	private Set<TQuejasMaster> TQuejasMasters = new HashSet<TQuejasMaster>(0);

	public TQuejasEstado() {
	}

	public TQuejasEstado(int codEstado, String desEstado) {
		this.codEstado = codEstado;
		this.desEstado = desEstado;
	}

	public TQuejasEstado(int codEstado, String desEstado,
			Set<TQuejasMaster> TQuejasMasters) {
		this.codEstado = codEstado;
		this.desEstado = desEstado;
		this.TQuejasMasters = TQuejasMasters;
	}

	@Id
	@Column(name = "cod_estado", nullable = false)
	public int getCodEstado() {
		return this.codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	@Column(name = "des_estado", nullable = false, length = 50)
	public String getDesEstado() {
		return this.desEstado;
	}

	public void setDesEstado(String desEstado) {
		this.desEstado = desEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TQuejasEstado")
	public Set<TQuejasMaster> getTQuejasMasters() {
		return this.TQuejasMasters;
	}

	public void setTQuejasMasters(Set<TQuejasMaster> TQuejasMasters) {
		this.TQuejasMasters = TQuejasMasters;
	}

}
