package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TJefes generated by hbm2java
 */
@Entity
@Table(name = "T_JEFES", schema = "WEB")
public class TJefes implements java.io.Serializable {

	private int idJefe;
	private String nomJefe;
	private String desPeriodo;
	private String imgJefe;
	private String flaActivo;
	private String curriJefe;

	public TJefes() {
	}

	public TJefes(int idJefe) {
		this.idJefe = idJefe;
	}

	public TJefes(int idJefe, String nomJefe, String desPeriodo,
			String imgJefe, String flaActivo, String curriJefe) {
		this.idJefe = idJefe;
		this.nomJefe = nomJefe;
		this.desPeriodo = desPeriodo;
		this.imgJefe = imgJefe;
		this.flaActivo = flaActivo;
		this.curriJefe = curriJefe;
	}

	@Id
	@Column(name = "id_jefe", nullable = false)
	public int getIdJefe() {
		return this.idJefe;
	}

	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}

	@Column(name = "nom_jefe", length = 150)
	public String getNomJefe() {
		return this.nomJefe;
	}

	public void setNomJefe(String nomJefe) {
		this.nomJefe = nomJefe;
	}

	@Column(name = "des_periodo", length = 200)
	public String getDesPeriodo() {
		return this.desPeriodo;
	}

	public void setDesPeriodo(String desPeriodo) {
		this.desPeriodo = desPeriodo;
	}

	@Column(name = "img_jefe", length = 100)
	public String getImgJefe() {
		return this.imgJefe;
	}

	public void setImgJefe(String imgJefe) {
		this.imgJefe = imgJefe;
	}

	@Column(name = "fla_activo", length = 10)
	public String getFlaActivo() {
		return this.flaActivo;
	}

	public void setFlaActivo(String flaActivo) {
		this.flaActivo = flaActivo;
	}

	@Column(name = "curri_jefe", length = 2000)
	public String getCurriJefe() {
		return this.curriJefe;
	}

	public void setCurriJefe(String curriJefe) {
		this.curriJefe = curriJefe;
	}

}
