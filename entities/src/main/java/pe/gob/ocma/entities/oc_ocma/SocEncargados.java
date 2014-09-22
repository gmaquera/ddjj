package pe.gob.ocma.entities.oc_ocma;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import pe.gob.ocma.entities.seguridad.Setusuario;

@Entity
@Table(name = "SCENCARGADOS", schema = "OC_OCMA")
public class SocEncargados {
	private Integer codEncargado;
	private String codUsuario;
	private Setusuario setusuario;
	private Set<Socmovimiento> socencargados = new HashSet<Socmovimiento>(0);
	
	public SocEncargados() {
		super();
	}

	@Id
	@Column(name = "codEncargado", nullable = false)
	public Integer getCodEncargado() {
		return codEncargado;
	}

	public void setCodEncargado(Integer codEncargado) {
		this.codEncargado = codEncargado;
	}

	@Column(name = "codUsuario", length = 20, nullable = false)
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socencargados")
	public Set<Socmovimiento> getSocencargados() {
		return socencargados;
	}

	public void setSocencargados(Set<Socmovimiento> socencargados) {
		this.socencargados = socencargados;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "codUsuario", referencedColumnName = "codUsuario", nullable = false, insertable = false, updatable = false),
			 })
	public Setusuario getSetusuario() {
		return setusuario;
	}

	public void setSetusuario(Setusuario setusuario) {
		this.setusuario = setusuario;
	}				
}
