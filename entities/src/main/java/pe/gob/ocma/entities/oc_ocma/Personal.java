package pe.gob.ocma.entities.oc_ocma;

// Generated 22/11/2013 04:30:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Personal generated by hbm2java
 */
@Entity
@Table(name = "PERSONAL", schema = "OC_OCMA")
public class Personal implements java.io.Serializable {

	private int codIntper;
	private Integer codDistri;
	private Integer codCiudad;
	private String desNombre;
	private String desApelli;
	private Integer codDespac;
	private Integer codDepend;
	private Integer codFuncio;
	private Integer codCargo;
	private Date fecIngres;
	private String desUbicac;
	private String desObserv;
	private String codContab;
	private String numEscala;
	private Integer codEstper;
	private Integer flaActivo;
	private Integer codDocide;
	private String desNumide;
	private Date fecNacimi;
	private String codDepartamento;
	private String codProvincia;
	private String codDistrito;
	private String codCentroPoblado;
	private Integer flaSexo;
	private Integer codEstciv;
	private String codDepartamentoDir;
	private String codProvinciaDir;
	private String codDistritoDir;
	private String codCentroPobladoDir;
	private String desDirecc;
	private String desNumtel;
	private Date fecCreacion;
	private String desHistor;
	private Date fecModificacion;
	private String desTelaux;
	private String desEmail;
	private String desNacionalidad;
	private String desNssp;
	private Integer codGsang;
	private Integer codAfp;
	private String numBnac;
	private String desNmult;
	private String numRuc;
	private String numAfp;
	private String numLmil;
	private String numColeg;
	private String numFotocheck;
	private Integer codRegpen;
	private String numBrevete;
	private String numCarnetext;
	private String numPassport;
	private Set<ExpePers> expePerses = new HashSet<ExpePers>(0);

	
	public Personal() {
		
	}

	public Personal(int codIntper) {
		this.codIntper = codIntper;
	}

	public Personal(int codIntper, Integer codDistri, Integer codCiudad,
			String desNombre, String desApelli, Integer codDespac,
			Integer codDepend, Integer codFuncio, Integer codCargo,
			Date fecIngres, String desUbicac, String desObserv,
			String codContab, String numEscala, Integer codEstper,
			Integer flaActivo, Integer codDocide, String desNumide,
			Date fecNacimi, String codDepartamento, String codProvincia,
			String codDistrito, String codCentroPoblado, Integer flaSexo,
			Integer codEstciv, String codDepartamentoDir,
			String codProvinciaDir, String codDistritoDir,
			String codCentroPobladoDir, String desDirecc, String desNumtel,
			Date fecCreacion, String desHistor, Date fecModificacion,
			String desTelaux, String desEmail, String desNacionalidad,
			String desNssp, Integer codGsang, Integer codAfp, String numBnac,
			String desNmult, String numRuc, String numAfp, String numLmil,
			String numColeg, String numFotocheck, Integer codRegpen,
			String numBrevete, String numCarnetext, String numPassport,
			Set<ExpePers> expePerses) {
		this.codIntper = codIntper;
		this.codDistri = codDistri;
		this.codCiudad = codCiudad;
		this.desNombre = desNombre;
		this.desApelli = desApelli;
		this.codDespac = codDespac;
		this.codDepend = codDepend;
		this.codFuncio = codFuncio;
		this.codCargo = codCargo;
		this.fecIngres = fecIngres;
		this.desUbicac = desUbicac;
		this.desObserv = desObserv;
		this.codContab = codContab;
		this.numEscala = numEscala;
		this.codEstper = codEstper;
		this.flaActivo = flaActivo;
		this.codDocide = codDocide;
		this.desNumide = desNumide;
		this.fecNacimi = fecNacimi;
		this.codDepartamento = codDepartamento;
		this.codProvincia = codProvincia;
		this.codDistrito = codDistrito;
		this.codCentroPoblado = codCentroPoblado;
		this.flaSexo = flaSexo;
		this.codEstciv = codEstciv;
		this.codDepartamentoDir = codDepartamentoDir;
		this.codProvinciaDir = codProvinciaDir;
		this.codDistritoDir = codDistritoDir;
		this.codCentroPobladoDir = codCentroPobladoDir;
		this.desDirecc = desDirecc;
		this.desNumtel = desNumtel;
		this.fecCreacion = fecCreacion;
		this.desHistor = desHistor;
		this.fecModificacion = fecModificacion;
		this.desTelaux = desTelaux;
		this.desEmail = desEmail;
		this.desNacionalidad = desNacionalidad;
		this.desNssp = desNssp;
		this.codGsang = codGsang;
		this.codAfp = codAfp;
		this.numBnac = numBnac;
		this.desNmult = desNmult;
		this.numRuc = numRuc;
		this.numAfp = numAfp;
		this.numLmil = numLmil;
		this.numColeg = numColeg;
		this.numFotocheck = numFotocheck;
		this.codRegpen = codRegpen;
		this.numBrevete = numBrevete;
		this.numCarnetext = numCarnetext;
		this.numPassport = numPassport;
		this.expePerses = expePerses;
	}

	@Id
	@Column(name = "COD_INTPER", nullable = false)
	public int getCodIntper() {
		return this.codIntper;
	}

	public void setCodIntper(int codIntper) {
		this.codIntper = codIntper;
	}

	@Column(name = "COD_DISTRI")
	public Integer getCodDistri() {
		return this.codDistri;
	}

	public void setCodDistri(Integer codDistri) {
		this.codDistri = codDistri;
	}

	@Column(name = "COD_CIUDAD")
	public Integer getCodCiudad() {
		return this.codCiudad;
	}

	public void setCodCiudad(Integer codCiudad) {
		this.codCiudad = codCiudad;
	}

	@Column(name = "DES_NOMBRE", length = 35)
	public String getDesNombre() {
		return this.desNombre;
	}

	public void setDesNombre(String desNombre) {
		this.desNombre = desNombre;
	}

	@Column(name = "DES_APELLI", length = 50)
	public String getDesApelli() {
		return this.desApelli;
	}

	public void setDesApelli(String desApelli) {
		this.desApelli = desApelli;
	}

	@Column(name = "COD_DESPAC")
	public Integer getCodDespac() {
		return this.codDespac;
	}

	public void setCodDespac(Integer codDespac) {
		this.codDespac = codDespac;
	}

	@Column(name = "COD_DEPEND")
	public Integer getCodDepend() {
		return this.codDepend;
	}

	public void setCodDepend(Integer codDepend) {
		this.codDepend = codDepend;
	}

	@Column(name = "COD_FUNCIO")
	public Integer getCodFuncio() {
		return this.codFuncio;
	}

	public void setCodFuncio(Integer codFuncio) {
		this.codFuncio = codFuncio;
	}

	@Column(name = "COD_CARGO")
	public Integer getCodCargo() {
		return this.codCargo;
	}

	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_INGRES", length = 10)
	public Date getFecIngres() {
		return this.fecIngres;
	}

	public void setFecIngres(Date fecIngres) {
		this.fecIngres = fecIngres;
	}

	@Column(name = "DES_UBICAC")
	public String getDesUbicac() {
		return this.desUbicac;
	}

	public void setDesUbicac(String desUbicac) {
		this.desUbicac = desUbicac;
	}

	@Column(name = "DES_OBSERV")
	public String getDesObserv() {
		return this.desObserv;
	}

	public void setDesObserv(String desObserv) {
		this.desObserv = desObserv;
	}

	@Column(name = "COD_CONTAB", length = 10)
	public String getCodContab() {
		return this.codContab;
	}

	public void setCodContab(String codContab) {
		this.codContab = codContab;
	}

	@Column(name = "NUM_ESCALA", length = 6)
	public String getNumEscala() {
		return this.numEscala;
	}

	public void setNumEscala(String numEscala) {
		this.numEscala = numEscala;
	}

	@Column(name = "COD_ESTPER")
	public Integer getCodEstper() {
		return this.codEstper;
	}

	public void setCodEstper(Integer codEstper) {
		this.codEstper = codEstper;
	}

	@Column(name = "FLA_ACTIVO")
	public Integer getFlaActivo() {
		return this.flaActivo;
	}

	public void setFlaActivo(Integer flaActivo) {
		this.flaActivo = flaActivo;
	}

	@Column(name = "COD_DOCIDE")
	public Integer getCodDocide() {
		return this.codDocide;
	}

	public void setCodDocide(Integer codDocide) {
		this.codDocide = codDocide;
	}

	@Column(name = "DES_NUMIDE", length = 20)
	public String getDesNumide() {
		return this.desNumide;
	}

	public void setDesNumide(String desNumide) {
		this.desNumide = desNumide;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_NACIMI", length = 10)
	public Date getFecNacimi() {
		return this.fecNacimi;
	}

	public void setFecNacimi(Date fecNacimi) {
		this.fecNacimi = fecNacimi;
	}

	@Column(name = "COD_DEPARTAMENTO", length = 2)
	public String getCodDepartamento() {
		return this.codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	@Column(name = "COD_PROVINCIA", length = 2)
	public String getCodProvincia() {
		return this.codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	@Column(name = "COD_DISTRITO", length = 2)
	public String getCodDistrito() {
		return this.codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

	@Column(name = "COD_CENTRO_POBLADO", length = 4)
	public String getCodCentroPoblado() {
		return this.codCentroPoblado;
	}

	public void setCodCentroPoblado(String codCentroPoblado) {
		this.codCentroPoblado = codCentroPoblado;
	}

	@Column(name = "FLA_SEXO")
	public Integer getFlaSexo() {
		return this.flaSexo;
	}

	public void setFlaSexo(Integer flaSexo) {
		this.flaSexo = flaSexo;
	}

	@Column(name = "COD_ESTCIV")
	public Integer getCodEstciv() {
		return this.codEstciv;
	}

	public void setCodEstciv(Integer codEstciv) {
		this.codEstciv = codEstciv;
	}

	@Column(name = "COD_DEPARTAMENTO_DIR", length = 2)
	public String getCodDepartamentoDir() {
		return this.codDepartamentoDir;
	}

	public void setCodDepartamentoDir(String codDepartamentoDir) {
		this.codDepartamentoDir = codDepartamentoDir;
	}

	@Column(name = "COD_PROVINCIA_DIR", length = 2)
	public String getCodProvinciaDir() {
		return this.codProvinciaDir;
	}

	public void setCodProvinciaDir(String codProvinciaDir) {
		this.codProvinciaDir = codProvinciaDir;
	}

	@Column(name = "COD_DISTRITO_DIR", length = 2)
	public String getCodDistritoDir() {
		return this.codDistritoDir;
	}

	public void setCodDistritoDir(String codDistritoDir) {
		this.codDistritoDir = codDistritoDir;
	}

	@Column(name = "COD_CENTRO_POBLADO_DIR", length = 4)
	public String getCodCentroPobladoDir() {
		return this.codCentroPobladoDir;
	}

	public void setCodCentroPobladoDir(String codCentroPobladoDir) {
		this.codCentroPobladoDir = codCentroPobladoDir;
	}

	@Column(name = "DES_DIRECC", length = 50)
	public String getDesDirecc() {
		return this.desDirecc;
	}

	public void setDesDirecc(String desDirecc) {
		this.desDirecc = desDirecc;
	}

	@Column(name = "DES_NUMTEL", length = 12)
	public String getDesNumtel() {
		return this.desNumtel;
	}

	public void setDesNumtel(String desNumtel) {
		this.desNumtel = desNumtel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_CREACION", length = 26)
	public Date getFecCreacion() {
		return this.fecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	@Column(name = "DES_HISTOR", length = 200)
	public String getDesHistor() {
		return this.desHistor;
	}

	public void setDesHistor(String desHistor) {
		this.desHistor = desHistor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_MODIFICACION", length = 26)
	public Date getFecModificacion() {
		return this.fecModificacion;
	}

	public void setFecModificacion(Date fecModificacion) {
		this.fecModificacion = fecModificacion;
	}

	@Column(name = "DES_TELAUX", length = 12)
	public String getDesTelaux() {
		return this.desTelaux;
	}

	public void setDesTelaux(String desTelaux) {
		this.desTelaux = desTelaux;
	}

	@Column(name = "DES_EMAIL", length = 100)
	public String getDesEmail() {
		return this.desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	@Column(name = "DES_NACIONALIDAD", length = 100)
	public String getDesNacionalidad() {
		return this.desNacionalidad;
	}

	public void setDesNacionalidad(String desNacionalidad) {
		this.desNacionalidad = desNacionalidad;
	}

	@Column(name = "DES_NSSP", length = 15)
	public String getDesNssp() {
		return this.desNssp;
	}

	public void setDesNssp(String desNssp) {
		this.desNssp = desNssp;
	}

	@Column(name = "COD_GSANG")
	public Integer getCodGsang() {
		return this.codGsang;
	}

	public void setCodGsang(Integer codGsang) {
		this.codGsang = codGsang;
	}

	@Column(name = "COD_AFP")
	public Integer getCodAfp() {
		return this.codAfp;
	}

	public void setCodAfp(Integer codAfp) {
		this.codAfp = codAfp;
	}

	@Column(name = "NUM_BNAC", length = 12)
	public String getNumBnac() {
		return this.numBnac;
	}

	public void setNumBnac(String numBnac) {
		this.numBnac = numBnac;
	}

	@Column(name = "DES_NMULT", length = 19)
	public String getDesNmult() {
		return this.desNmult;
	}

	public void setDesNmult(String desNmult) {
		this.desNmult = desNmult;
	}

	@Column(name = "NUM_RUC", length = 11)
	public String getNumRuc() {
		return this.numRuc;
	}

	public void setNumRuc(String numRuc) {
		this.numRuc = numRuc;
	}

	@Column(name = "NUM_AFP", length = 12)
	public String getNumAfp() {
		return this.numAfp;
	}

	public void setNumAfp(String numAfp) {
		this.numAfp = numAfp;
	}

	@Column(name = "NUM_LMIL", length = 10)
	public String getNumLmil() {
		return this.numLmil;
	}

	public void setNumLmil(String numLmil) {
		this.numLmil = numLmil;
	}

	@Column(name = "NUM_COLEG", length = 5)
	public String getNumColeg() {
		return this.numColeg;
	}

	public void setNumColeg(String numColeg) {
		this.numColeg = numColeg;
	}

	@Column(name = "NUM_FOTOCHECK", length = 5)
	public String getNumFotocheck() {
		return this.numFotocheck;
	}

	public void setNumFotocheck(String numFotocheck) {
		this.numFotocheck = numFotocheck;
	}

	@Column(name = "COD_REGPEN")
	public Integer getCodRegpen() {
		return this.codRegpen;
	}

	public void setCodRegpen(Integer codRegpen) {
		this.codRegpen = codRegpen;
	}

	@Column(name = "NUM_BREVETE", length = 30)
	public String getNumBrevete() {
		return this.numBrevete;
	}

	public void setNumBrevete(String numBrevete) {
		this.numBrevete = numBrevete;
	}

	@Column(name = "NUM_CARNETEXT", length = 30)
	public String getNumCarnetext() {
		return this.numCarnetext;
	}

	public void setNumCarnetext(String numCarnetext) {
		this.numCarnetext = numCarnetext;
	}

	@Column(name = "NUM_PASSPORT", length = 30)
	public String getNumPassport() {
		return this.numPassport;
	}

	public void setNumPassport(String numPassport) {
		this.numPassport = numPassport;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
	public Set<ExpePers> getExpePerses() {
		return this.expePerses;
	}

	public void setExpePerses(Set<ExpePers> expePerses) {
		this.expePerses = expePerses;
	}

}
