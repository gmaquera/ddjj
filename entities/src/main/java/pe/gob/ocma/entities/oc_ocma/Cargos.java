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
@Table(name = "CARGOS", schema = "OC_OCMA")
public class Cargos implements java.io.Serializable {
	
	private int cod_cargo;
	private String des_nomenc;
	private String des_cargo;
	private String des_abrevi;
	private int fla_estado;
	private Set<ExpePers> persCargo = new HashSet<ExpePers>(0);
	
	public Cargos() {
		super();
	}

	@Id
	@Column(name = "cod_cargo", nullable = false)
	public int getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(int cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	@Column(name = "des_nomenc", length = 8)
	public String getDes_nomenc() {
		return des_nomenc;
	}

	public void setDes_nomenc(String des_nomenc) {
		this.des_nomenc = des_nomenc;
	}

	@Column(name = "des_cargo", length = 35)
	public String getDes_cargo() {
		return des_cargo;
	}

	public void setDes_cargo(String des_cargo) {
		this.des_cargo = des_cargo;
	}

	@Column(name = "des_abrevi", length = 6)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persCargo")
	public Set<ExpePers> getPersCargo() {
		return persCargo;
	}

	public void setPersCargo(Set<ExpePers> persCargo) {
		this.persCargo = persCargo;
	}
	

}
