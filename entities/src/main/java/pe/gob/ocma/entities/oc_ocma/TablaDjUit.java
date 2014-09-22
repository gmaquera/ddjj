package pe.gob.ocma.entities.oc_ocma;

// Generated 07/07/2014 02:35:49 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TablaDjUit generated by hbm2java
 */
@Entity
@Table(name = "TABLA_DJ_UIT", schema = "OC_OCMA")
public class TablaDjUit implements java.io.Serializable {

	private int codUit;
	private BigDecimal valorUit;
	private int desEjercicio;

	public TablaDjUit() {
	}

	public TablaDjUit(int codUit, BigDecimal valorUit, int desEjercicio) {
		this.codUit = codUit;
		this.valorUit = valorUit;
		this.desEjercicio = desEjercicio;
	}

	@Id
	@Column(name = "COD_UIT", nullable = false)
	public int getCodUit() {
		return this.codUit;
	}

	public void setCodUit(int codUit) {
		this.codUit = codUit;
	}

	@Column(name = "VALOR_UIT", nullable = false, precision = 10)
	public BigDecimal getValorUit() {
		return this.valorUit;
	}

	public void setValorUit(BigDecimal valorUit) {
		this.valorUit = valorUit;
	}

	@Column(name = "DES_EJERCICIO", nullable = false)
	public int getDesEjercicio() {
		return this.desEjercicio;
	}

	public void setDesEjercicio(int desEjercicio) {
		this.desEjercicio = desEjercicio;
	}

}
