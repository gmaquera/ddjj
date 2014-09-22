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
@Table(name = "DESPACHOS", schema = "OC_OCMA")
public class Despachos implements java.io.Serializable {
	
	private int cod_despac;
	private String des_despac;
	private int fla_estado;
	private Set<ExpePers> persDespacho = new HashSet<ExpePers>(0);
	
	public Despachos() {
		super();
	}

	@Id
	@Column(name = "cod_despac", nullable = false)
	public int getCod_despac() {
		return cod_despac;
	}

	public void setCod_despac(int cod_despac) {
		this.cod_despac = cod_despac;
	}

	@Column(name = "des_despac", length = 25)
	public String getDes_despac() {
		return des_despac;
	}

	public void setDes_despac(String des_despac) {
		this.des_despac = des_despac;
	}

	@Column(name = "fla_estado")
	public int getFla_estado() {
		return fla_estado;
	}

	public void setFla_estado(int fla_estado) {
		this.fla_estado = fla_estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persDespacho")
	public Set<ExpePers> getPersDespacho() {
		return persDespacho;
	}

	public void setPersDespacho(Set<ExpePers> persDespacho) {
		this.persDespacho = persDespacho;
	}
	
	
	
	

}
