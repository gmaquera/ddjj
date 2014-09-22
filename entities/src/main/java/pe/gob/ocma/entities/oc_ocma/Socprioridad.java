package pe.gob.ocma.entities.oc_ocma;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SCPRIORIDAD", schema = "OC_OCMA")
public class Socprioridad {
	private int cod_prioridad;
	private String det_prioridad;
	private Set<Socmast> socmast = new HashSet<Socmast>(0);
	
	public Socprioridad() {
		super();
	}
	
	@Id
	@Column(name = "cod_prioridad", nullable = false)
	public int getCod_prioridad() {
		return cod_prioridad;
	}
	public void setCod_prioridad(int cod_prioridad) {
		this.cod_prioridad = cod_prioridad;
	}
	
	@Column(name = "det_prioridad", length = 30)
	public String getDet_prioridad() {
		return det_prioridad;
	}
	public void setDet_prioridad(String det_prioridad) {
		this.det_prioridad = det_prioridad;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socprioridad")
	public Set<Socmast> getSocmast() {
		return this.socmast;
	}

	public void setSocmast(Set<Socmast> socmast) {
		this.socmast = socmast;
	}	

}
