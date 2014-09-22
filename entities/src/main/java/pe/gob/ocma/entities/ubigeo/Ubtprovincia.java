package pe.gob.ocma.entities.ubigeo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.gob.ocma.entities.organosjurisd.Ojtdependen;

@Entity
@Table(name = "UBTPROVINCIA", schema = "UBIGEO")
public class Ubtprovincia implements java.io.Serializable {
	
	private char codUbiProv;	
	private String descripcion;
	private char codDepartam;
	private Set<Ojtdependen> ojtdependencias = new HashSet<Ojtdependen>(0);
	
	public Ubtprovincia() {	
	}
		
	@Id
	@Column(name = "codUbiProv", nullable = false, length = 4)
	public char getCodUbiProv() {
		return codUbiProv;
	}
	
	public void setCodUbiProv(char codUbiProv) {
		this.codUbiProv = codUbiProv;
	}
	
	@Column(name = "descripcion", length = 100)
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
	@Column(name = "codDepartam", length = 2)
	public char getCodDepartam() {
		return codDepartam;
	}
	
	public void setCodDepartam(char codDepartam) {
		this.codDepartam = codDepartam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ubtprovincia")
	public Set<Ojtdependen> getOjtdependencias() {
		return ojtdependencias;
	}
	
	public void setOjtdependencias(Set<Ojtdependen> ojtdependencias) {
		this.ojtdependencias = ojtdependencias;
	}	
	
	

}
