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
@Table(name = "SCTIPDOC", schema = "OC_OCMA")
public class Soctipdoc {

	private int cod_tipdoc;
	private String det_tipdoc;
	private Set<Socmovimiento> soctipdoc = new HashSet<Socmovimiento>(0);
	
		
	public Soctipdoc() {
		super();
	}
	
	@Id
	@Column(name = "cod_tipdoc", nullable = false)
	public int getCod_tipdoc() {
		return cod_tipdoc;
	}
	public void setCod_tipdoc(int cod_tipdoc) {
		this.cod_tipdoc = cod_tipdoc;
	}
	
	@Column(name = "det_tipdoc", length = 20)
	public String getDet_tipdoc() {
		return det_tipdoc;
	}

	public void setDet_tipdoc(String det_tipdoc) {
		this.det_tipdoc = det_tipdoc;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "soctipdoc")
	public Set<Socmovimiento> getSoctipdoc() {
		return soctipdoc;
	}

	public void setSoctipdoc(Set<Socmovimiento> soctipdoc) {
		this.soctipdoc = soctipdoc;
	}

}


