package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TIntegrante generated by hbm2java
 */
@Entity
@Table(name = "T_INTEGRANTE", schema = "WEB")
public class TIntegrante implements java.io.Serializable {

	private int idIntegrante;
	private TArea TArea;
	private String nomIntegrante;
	private String cargoIntegrante;
	private String curriIntegrante;
	private String flaEstado;
	private int flaJefe;
	private String colegiado;
	private Integer instancia;

	public TIntegrante() {
	}

	public TIntegrante(int idIntegrante, TArea TArea, String nomIntegrante,
			String cargoIntegrante, String flaEstado, int flaJefe) {
		this.idIntegrante = idIntegrante;
		this.TArea = TArea;
		this.nomIntegrante = nomIntegrante;
		this.cargoIntegrante = cargoIntegrante;
		this.flaEstado = flaEstado;
		this.flaJefe = flaJefe;
	}

	public TIntegrante(int idIntegrante, TArea TArea, String nomIntegrante,
			String cargoIntegrante, String curriIntegrante, String flaEstado,
			int flaJefe, String colegiado, Integer instancia) {
		this.idIntegrante = idIntegrante;
		this.TArea = TArea;
		this.nomIntegrante = nomIntegrante;
		this.cargoIntegrante = cargoIntegrante;
		this.curriIntegrante = curriIntegrante;
		this.flaEstado = flaEstado;
		this.flaJefe = flaJefe;
		this.colegiado = colegiado;
		this.instancia = instancia;
	}

	@Id
	@Column(name = "id_integrante", nullable = false)
	public int getIdIntegrante() {
		return this.idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area", nullable = false)
	public TArea getTArea() {
		return this.TArea;
	}

	public void setTArea(TArea TArea) {
		this.TArea = TArea;
	}

	@Column(name = "nom_integrante", nullable = false, length = 200)
	public String getNomIntegrante() {
		return this.nomIntegrante;
	}

	public void setNomIntegrante(String nomIntegrante) {
		this.nomIntegrante = nomIntegrante;
	}

	@Column(name = "cargo_integrante", nullable = false, length = 200)
	public String getCargoIntegrante() {
		return this.cargoIntegrante;
	}

	public void setCargoIntegrante(String cargoIntegrante) {
		this.cargoIntegrante = cargoIntegrante;
	}

	@Column(name = "curri_integrante", length = 4000)
	public String getCurriIntegrante() {
		return this.curriIntegrante;
	}

	public void setCurriIntegrante(String curriIntegrante) {
		this.curriIntegrante = curriIntegrante;
	}

	@Column(name = "fla_estado", nullable = false, length = 10)
	public String getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(String flaEstado) {
		this.flaEstado = flaEstado;
	}

	@Column(name = "fla_jefe", nullable = false)
	public int getFlaJefe() {
		return this.flaJefe;
	}

	public void setFlaJefe(int flaJefe) {
		this.flaJefe = flaJefe;
	}

	@Column(name = "colegiado", length = 2)
	public String getColegiado() {
		return this.colegiado;
	}

	public void setColegiado(String colegiado) {
		this.colegiado = colegiado;
	}

	@Column(name = "instancia")
	public Integer getInstancia() {
		return this.instancia;
	}

	public void setInstancia(Integer instancia) {
		this.instancia = instancia;
	}

}
