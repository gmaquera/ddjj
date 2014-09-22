package pe.gob.ocma.entities.oc_ocma;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeguMoviId implements java.io.Serializable {
	
	private Integer codDistritoOrigen;
	private Integer codIntexp;
	private Integer numSecuen;
	
	public SeguMoviId() {
		super();
	}
	
	public SeguMoviId(Integer codDistritoOrigen, Integer codIntexp, Integer numSecuen) {
		this.codDistritoOrigen = codDistritoOrigen;
		this.codIntexp = codIntexp;
		this.numSecuen = numSecuen;
	}

	@Column(name = "COD_DISTRITO_ORIGEN", nullable = false)
	public int getCodDistritoOrigen() {
		return codDistritoOrigen;
	}

	public void setCodDistritoOrigen(Integer codDistritoOrigen) {
		this.codDistritoOrigen = codDistritoOrigen;
	}

	@Column(name = "COD_INTEXP", nullable = false)
	public int getCodIntexp() {
		return codIntexp;
	}

	public void setCodIntexp(Integer codIntexp) {
		this.codIntexp = codIntexp;
	}

	@Column(name = "NUM_SECUEN", nullable = false)
	public int getNumSecuen() {
		return numSecuen;
	}

	public void setNumSecuen(Integer numSecuen) {
		this.numSecuen = numSecuen;
	}	
	
	
	

}
