package pe.gob.ocma.entities.oc_ocma;

// Generated 22/11/2013 04:30:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ExpeEsta generated by hbm2java
 */
@Entity
@Table(name = "EXPE_ESTA", schema = "OC_OCMA")
public class ExpeEsta implements java.io.Serializable {

	private int codEstado;
	private String desEstaex;
	private Character abrEstado;
	private Integer flaEsta;
	private Set<ExpePers> expePerses = new HashSet<ExpePers>(0);
	private Set<SeguReso> seguResos = new HashSet<SeguReso>(0);
	private Set<SeguMovi> moviEstado = new HashSet<SeguMovi>(0);

	public ExpeEsta() {
	}

	public ExpeEsta(int codEstado) {
		this.codEstado = codEstado;
	}

	public ExpeEsta(int codEstado, String desEstaex, Character abrEstado,
			Integer flaEsta, Set<ExpePers> expePerses, Set<SeguReso> seguResos) {
		this.codEstado = codEstado;
		this.desEstaex = desEstaex;
		this.abrEstado = abrEstado;
		this.flaEsta = flaEsta;
		this.expePerses = expePerses;
		this.seguResos = seguResos;
	}

	@Id
	@Column(name = "COD_ESTADO", nullable = false)
	public int getCodEstado() {
		return this.codEstado;
	}

	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}

	@Column(name = "DES_ESTAEX", length = 20)
	public String getDesEstaex() {
		return this.desEstaex;
	}

	public void setDesEstaex(String desEstaex) {
		this.desEstaex = desEstaex;
	}

	@Column(name = "ABR_ESTADO", length = 1)
	public Character getAbrEstado() {
		return this.abrEstado;
	}

	public void setAbrEstado(Character abrEstado) {
		this.abrEstado = abrEstado;
	}

	@Column(name = "FLA_ESTA")
	public Integer getFlaEsta() {
		return this.flaEsta;
	}

	public void setFlaEsta(Integer flaEsta) {
		this.flaEsta = flaEsta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expeEsta")
	public Set<ExpePers> getExpePerses() {
		return this.expePerses;
	}

	public void setExpePerses(Set<ExpePers> expePerses) {
		this.expePerses = expePerses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expeEsta")
	public Set<SeguReso> getSeguResos() {
		return this.seguResos;
	}

	public void setSeguResos(Set<SeguReso> seguResos) {
		this.seguResos = seguResos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "moviEstado")
	public Set<SeguMovi> getMoviEstado() {
		return moviEstado;
	}

	public void setMoviEstado(Set<SeguMovi> moviEstado) {
		this.moviEstado = moviEstado;
	}

	
}
