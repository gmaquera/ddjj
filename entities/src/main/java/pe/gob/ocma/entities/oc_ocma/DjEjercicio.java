package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DjEjercicio generated by hbm2java
 */
@Entity
@Table(name = "DJ_EJERCICIO", schema = "OC_OCMA")
public class DjEjercicio implements java.io.Serializable {

	private int codEjercicio;
	private int desEjercicio;
	private int flaEjercicio;

	public DjEjercicio() {
	}

	public DjEjercicio(int codEjercicio, int desEjercicio, int flaEjercicio) {
		this.codEjercicio = codEjercicio;
		this.desEjercicio = desEjercicio;
		this.flaEjercicio = flaEjercicio;
	}

	@Id
	@Column(name = "COD_EJERCICIO", nullable = false)
	public int getCodEjercicio() {
		return this.codEjercicio;
	}

	public void setCodEjercicio(int codEjercicio) {
		this.codEjercicio = codEjercicio;
	}

	@Column(name = "DES_EJERCICIO", nullable = false)
	public int getDesEjercicio() {
		return this.desEjercicio;
	}

	public void setDesEjercicio(int desEjercicio) {
		this.desEjercicio = desEjercicio;
	}

	@Column(name = "FLA_EJERCICIO", nullable = false)
	public int getFlaEjercicio() {
		return this.flaEjercicio;
	}

	public void setFlaEjercicio(int flaEjercicio) {
		this.flaEjercicio = flaEjercicio;
	}

}
