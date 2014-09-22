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
@Table(name = "FUNCIONES", schema = "OC_OCMA")
public class Funciones implements java.io.Serializable {
	
	private int cod_funcio;
	private String des_funcio;
	private String des_abrevi;
	private int fla_estado;
	private Set<ExpePers> persFunciones = new HashSet<ExpePers>(0);
	
	public Funciones() {
		super();
	}

	@Id
	@Column(name = "cod_funcio", nullable = false)
	public int getCod_funcio() {
		return cod_funcio;
	}

	public void setCod_funcio(int cod_funcio) {
		this.cod_funcio = cod_funcio;
	}

	@Column(name = "des_funcio", length = 35)
	public String getDes_funcio() {
		return des_funcio;
	}

	public void setDes_funcio(String des_funcio) {
		this.des_funcio = des_funcio;
	}

	@Column(name = "des_abrevi", length = 5)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persFunciones")
	public Set<ExpePers> getPersFunciones() {
		return persFunciones;
	}

	public void setPersFunciones(Set<ExpePers> persFunciones) {
		this.persFunciones = persFunciones;
	}		
	
}
