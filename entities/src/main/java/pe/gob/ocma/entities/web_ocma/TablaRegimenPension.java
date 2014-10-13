package pe.gob.ocma.entities.web_ocma;

// Generated 29/09/2014 11:43:47 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TablaRegimenPension generated by hbm2java
 */
@Entity
@Table(name = "TABLA_REGIMEN_PENSION", schema = "WEB_OCMA")
public class TablaRegimenPension implements java.io.Serializable {

	private int codRegpension;
	private String desRegpension;
	private char flaEstado;

	public TablaRegimenPension() {
	}

	public TablaRegimenPension(int codRegpension, char flaEstado) {
		this.codRegpension = codRegpension;
		this.flaEstado = flaEstado;
	}

	public TablaRegimenPension(int codRegpension, String desRegpension,
			char flaEstado) {
		this.codRegpension = codRegpension;
		this.desRegpension = desRegpension;
		this.flaEstado = flaEstado;
	}

	@Id
	@Column(name = "COD_REGPENSION", nullable = false)
	public int getCodRegpension() {
		return this.codRegpension;
	}

	public void setCodRegpension(int codRegpension) {
		this.codRegpension = codRegpension;
	}

	@Column(name = "DES_REGPENSION", length = 100)
	public String getDesRegpension() {
		return this.desRegpension;
	}

	public void setDesRegpension(String desRegpension) {
		this.desRegpension = desRegpension;
	}

	@Column(name = "FLA_ESTADO", nullable = false, length = 1)
	public char getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(char flaEstado) {
		this.flaEstado = flaEstado;
	}

}