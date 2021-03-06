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
 * TCatenalce generated by hbm2java
 */
@Entity
@Table(name = "T_CATENALCE", schema = "WEB")
public class TCatenalce implements java.io.Serializable {

	private int idCategory;
	private String desCategory;
	private Character flaEstado;
	private Set<TEnlaces> TEnlaceses = new HashSet<TEnlaces>(0);

	public TCatenalce() {
	}

	public TCatenalce(int idCategory) {
		this.idCategory = idCategory;
	}

	public TCatenalce(int idCategory, String desCategory, Character flaEstado,
			Set<TEnlaces> TEnlaceses) {
		this.idCategory = idCategory;
		this.desCategory = desCategory;
		this.flaEstado = flaEstado;
		this.TEnlaceses = TEnlaceses;
	}

	@Id
	@Column(name = "id_category", nullable = false)
	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "des_category", length = 250)
	public String getDesCategory() {
		return this.desCategory;
	}

	public void setDesCategory(String desCategory) {
		this.desCategory = desCategory;
	}

	@Column(name = "fla_estado", length = 1)
	public Character getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(Character flaEstado) {
		this.flaEstado = flaEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCatenalce")
	public Set<TEnlaces> getTEnlaceses() {
		return this.TEnlaceses;
	}

	public void setTEnlaceses(Set<TEnlaces> TEnlaceses) {
		this.TEnlaceses = TEnlaceses;
	}

}
