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
@Table(name = "SCPROCEDE", schema = "OC_OCMA")
public class Socprocede{
	private int cod_tiproc;
	private String det_tiproc;
	private Set<Socmovimiento> socprocede = new HashSet<Socmovimiento>(0);
	
	public Socprocede() {
		super();
	}
	
	@Id
	@Column(name = "cod_tiproc", nullable = false)
	public int getCod_tiproc() {
		return cod_tiproc;
	}
	public void setCod_tiproc(int cod_tiproc) {
		this.cod_tiproc = cod_tiproc;
	}
	
	@Column(name = "det_tiproc", length = 20)
	public String getDet_tiproc() {
		return det_tiproc;
	}

	public void setDet_tiproc(String det_tiproc) {
		this.det_tiproc = det_tiproc;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socprocede")
	public Set<Socmovimiento> getSocprocede() {
		return socprocede;
	}

	

	public void setSocprocede(Set<Socmovimiento> socprocede) {
		this.socprocede = socprocede;
	}
	
	
	
}
