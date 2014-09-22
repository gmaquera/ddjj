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
@Table(name = "DEPENDEN", schema = "OC_OCMA")
public class Dependen {
	
	private int cod_depend;
	private String des_depend;
	private String des_abrevi;
	private int fla_estado;
	private Set<ExpePers> persDependecia = new HashSet<ExpePers>(0);
	
	public Dependen() {
		super();
	}

	
	@Id
	@Column(name = "cod_depend", nullable = false)
	public int getCod_depend() {
		return cod_depend;
	}

	public void setCod_depend(int cod_depend) {
		this.cod_depend = cod_depend;
	}

	@Column(name = "des_depend", length = 35)
	public String getDes_depend() {
		return des_depend;
	}

	public void setDes_depend(String des_depend) {
		this.des_depend = des_depend;
	}

	@Column(name = "des_abrevi", length = 15)
	public String getDes_abrevi() {
		return des_abrevi;
	}

	public void setDes_abrevi(String des_abrevi) {
		this.des_abrevi = des_abrevi;
	}

	@Column(name = "fla_estado")
	public int getFla_estado() {
		return fla_estado;
	}

	public void setFla_estado(int fla_estado) {
		this.fla_estado = fla_estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persDependecia")
	public Set<ExpePers> getPersDependecia() {
		return persDependecia;
	}

	public void setPersDependecia(Set<ExpePers> persDependecia) {
		this.persDependecia = persDependecia;
	}
	
	
	

}
