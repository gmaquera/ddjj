package pe.gob.ocma.entities.web_ocma;

// Generated 04/11/2014 04:33:59 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TablaCvTitulo generated by hbm2java
 */
@Entity
@Table(name = "TABLA_CV_TITULO", schema = "WEB_OCMA")
public class TablaCvTitulo implements java.io.Serializable {

	private int codCvTitulo;
	private String desCvTitulo;
	private char flaEstado;

	public TablaCvTitulo() {
	}

	public TablaCvTitulo(int codCvTitulo, String desCvTitulo, char flaEstado) {
		this.codCvTitulo = codCvTitulo;
		this.desCvTitulo = desCvTitulo;
		this.flaEstado = flaEstado;
	}

	@Id
	@Column(name = "COD_CV_TITULO", nullable = false)
	public int getCodCvTitulo() {
		return this.codCvTitulo;
	}

	public void setCodCvTitulo(int codCvTitulo) {
		this.codCvTitulo = codCvTitulo;
	}

	@Column(name = "DES_CV_TITULO", nullable = false, length = 30)
	public String getDesCvTitulo() {
		return this.desCvTitulo;
	}

	public void setDesCvTitulo(String desCvTitulo) {
		this.desCvTitulo = desCvTitulo;
	}

	@Column(name = "FLA_ESTADO", nullable = false, length = 1)
	public char getFlaEstado() {
		return this.flaEstado;
	}

	public void setFlaEstado(char flaEstado) {
		this.flaEstado = flaEstado;
	}

}