package pe.gob.ocma.entities.oc_ocma;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SCMAST", schema = "OC_OCMA")
public class Socmast {
	
	private DistriJud socmastdistorigen;	
	private int cod_distrito_origen;
	private int cod_intexp;
	private String num_expedi;
	private String num_anios;
	private int num_sc;
	private Socprioridad socprioridad;
	private int cod_prioridad;
	private Date fecha_creacion;
	private DistriJud socmastdist;
	private int cod_distri;
	private ExpeTipo socmastexpetipo;
	private int cod_tipexp;
	private ExpeMast id;
	private String docAtuado;
	private Set<Socmovimiento> socmovimiento = new HashSet<Socmovimiento>(0);
	
	public Socmast() {
		fecha_creacion = new Date();	
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_distrito_origen", nullable = false, insertable = false, updatable = false)
	public DistriJud getSocmastdistorigen() {
		return this.socmastdistorigen;
	}

	public void setSocmastdistorigen(DistriJud socmastdistorigen) {
		this.socmastdistorigen = socmastdistorigen;
	}	
	
	@Column(name = "cod_distrito_origen", nullable = false)
	public int getCod_distrito_origen() {
		return cod_distrito_origen;
	}
	public void setCod_distrito_origen(int cod_distrito_origen) {
		this.cod_distrito_origen = cod_distrito_origen;
	}
	
	@Column(name = "cod_intexp", nullable = false)
	public int getCod_intexp() {
		return cod_intexp;
	}
	public void setCod_intexp(int cod_intexp) {
		this.cod_intexp = cod_intexp;
	}
	
	@Column(name = "num_expedi", length = 5)	
	public String getNum_expedi() {
		return num_expedi;
	}

	public void setNum_expedi(String num_expedi) {
		this.num_expedi = num_expedi;
	}
	
	
	@Column(name = "num_anios", length = 4)
	public String getNum_anios() {
		return num_anios;
	}

	public void setNum_anios(String num_anios) {
		this.num_anios = num_anios;
	}

	@Id
	@Column(name = "num_sc", nullable = false)
	public int getNum_sc() {
		return num_sc;
	}
	public void setNum_sc(int num_sc) {
		this.num_sc = num_sc;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_prioridad", nullable = false, insertable = false, updatable = false)
	public Socprioridad getSocprioridad() {
		return this.socprioridad;
	}

	public void setSocprioridad(Socprioridad socprioridad) {
		this.socprioridad = socprioridad;
	}	
	
	@Column(name = "cod_prioridad")
	public int getCod_prioridad() {
		return cod_prioridad;
	}
	public void setCod_prioridad(int cod_prioridad) {
		this.cod_prioridad = cod_prioridad;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion", length = 10)
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_distri", nullable = false, insertable = false, updatable = false)
	public DistriJud getSocmastdist() {
		return this.socmastdist;
	}

	public void setSocmastdist(DistriJud socmastdist) {
		this.socmastdist = socmastdist;
	}	
	
	@Column(name = "cod_distri", nullable = false)
	public int getCod_distri() {
		return cod_distri;
	}
	public void setCod_distri(int cod_distri) {
		this.cod_distri = cod_distri;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipexp", nullable = false, insertable = false, updatable = false)
	public ExpeTipo getSocmastexpetipo() {
		return socmastexpetipo;
	}

	public void setSocmastexpetipo(ExpeTipo socmastexpetipo) {
		this.socmastexpetipo = socmastexpetipo;
	}	
	
	@Column(name = "cod_tipexp", nullable = false)
	public int getCod_tipexp() {
		return cod_tipexp;
	}
	
	public void setCod_tipexp(int cod_tipexp) {
		this.cod_tipexp = cod_tipexp;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cod_distrito_origen", referencedColumnName = "cod_distrito_origen", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "cod_intexp", referencedColumnName = "cod_intexp", nullable = false, insertable = false, updatable = false) })
	public ExpeMast getId() {
		return id;
	}

	public void setId(ExpeMast id) {
		this.id = id;		
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socmovimiento")
	public Set<Socmovimiento> getSocmovimiento() {
		return socmovimiento;
	}

	public void setSocmovimiento(Set<Socmovimiento> socmovimiento) {
		this.socmovimiento = socmovimiento;
	}

	
	@Column(name = "docAtuado", length = 30)
	public String getDocAtuado() {
		return docAtuado;
	}

	public void setDocAtuado(String docAtuado) {
		this.docAtuado = docAtuado;
	}
	
	
	
/**
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "COD_DISTRITO_ORIGEN", referencedColumnName = "COD_DISTRITO_ORIGEN", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "COD_INTEXP", referencedColumnName = "COD_INTEXP", nullable = false, insertable = false, updatable = false) })
	public ExpeMast getExpemast() {
		return expemast;
	}

	public void setExpemast(ExpeMast expemast) {
		this.expemast = expemast;
	}
	
	**/
	
	
	
}
