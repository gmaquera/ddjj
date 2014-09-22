package pe.gob.ocma.entities.oc_ocma;
import java.beans.Transient;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;


@Entity
@Table(name = "SCMOVIMIENTO", schema = "OC_OCMA")
public class Socmovimiento {
	private Integer num_info;
	private int num_sc;
	private Date fecha_in;
	private String nro_oficio;
	private SeguEnca socencarg;
	private int cod_encarg;
	private int cod_unidad;
	private Soctipdoc soctipdoc;
	private int cod_tipdoc;
	private String nro_tipdoc;
	private Date fecha_tipdoc;
	private String movi_det;
	private Socprocede socprocede;
	private int cod_tiproc;
	private SocEncargados socencargados;
	private Integer codEncargado;
	private String fla_ult_movi;
	private Socmast socmovimiento;	
	private Integer vencimiento;  

		
	public Socmovimiento() {
		fecha_tipdoc = new Date();	
		socencarg = new SeguEnca();
		soctipdoc = new Soctipdoc();
		socprocede = new Socprocede();
		socencargados = new SocEncargados();
	}
	
	@Id
	@Column(name = "num_info", nullable = false)
	public Integer getNum_info() {
		return num_info;
	}
	public void setNum_info(Integer num_info) {
		this.num_info = num_info;
	}
	
	@Column(name = "num_sc", nullable = false)
	public int getNum_sc() {
		return num_sc;
	}
	public void setNum_sc(int num_sc) {
		this.num_sc = num_sc;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_in", length = 10)
	public Date getFecha_in() {
		return fecha_in;
	}
	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}
	
	@Column(name = "nro_oficio", length = 20)
	public String getNro_oficio() {
		return nro_oficio;
	}
	public void setNro_oficio(String nro_oficio) {
		this.nro_oficio = nro_oficio;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_encarg", nullable = false, insertable = false, updatable = false)
	public SeguEnca getSocencarg() {
		return socencarg;
	}

	public void setSocencarg(SeguEnca socencarg) {
		this.socencarg = socencarg;
	}

	@Column(name = "cod_encarg", nullable = false)
	public int getCod_encarg() {
		return cod_encarg;
	}

	public void setCod_encarg(int cod_encarg) {
		this.cod_encarg = cod_encarg;
	}
	
	@Column(name = "cod_unidad")
	public int getCod_unidad() {
		return cod_unidad;
	}
	

	public void setCod_unidad(int cod_unidad) {
		this.cod_unidad = cod_unidad;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipdoc", nullable = false, insertable = false, updatable = false)
	public Soctipdoc getSoctipdoc() {
		return this.soctipdoc;
	}

	public void setSoctipdoc(Soctipdoc soctipdoc) {
		this.soctipdoc = soctipdoc;
	}	
	
	@Column(name = "cod_tipdoc", nullable = false)
	public int getCod_tipdoc() {
		return cod_tipdoc;
	}
	public void setCod_tipdoc(int cod_tipdoc) {
		this.cod_tipdoc = cod_tipdoc;
	}
	
	@Column(name = "nro_tipdoc", length = 5)
	public String getNro_tipdoc() {
		return nro_tipdoc;
	}
	public void setNro_tipdoc(String nro_tipdoc) {
		this.nro_tipdoc = nro_tipdoc;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_tipdoc", length = 10)
	public Date getFecha_tipdoc() {
		return fecha_tipdoc;
	}
	public void setFecha_tipdoc(Date fecha_tipdoc) {
		this.fecha_tipdoc = fecha_tipdoc;
	}
	
	@Column(name = "movi_det", length = 5)
	public String getMovi_det() {
		return movi_det;
	}
	public void setMovi_det(String movi_det) {
		this.movi_det = movi_det;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tiproc", nullable = false, insertable = false, updatable = false)
	public Socprocede getSocprocede() {
		return this.socprocede;
	}

	public void setSocprocede(Socprocede socprocede) {
		this.socprocede = socprocede;
	}	
	
	
	@Column(name = "cod_tiproc", nullable = false)
	public int getCod_tiproc() {
		return cod_tiproc;
	}
	public void setCod_tiproc(int cod_tiproc) {
		this.cod_tiproc = cod_tiproc;
	}
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codEncargado", nullable = false, insertable = false, updatable = false)
	public SocEncargados getSocencargados() {
		return socencargados;
	}

	public void setSocencargados(SocEncargados socencargados) {
		this.socencargados = socencargados;
	}

	@Column(name = "codEncargado")
	public Integer getCodEncargado() {
		return codEncargado;
	}

	public void setCodEncargado(Integer codEncargado) {
		this.codEncargado = codEncargado;
	}
	
	
	@Column(name = "fla_ult_movi", length = 1)
	public String getFla_ult_movi() {
		return fla_ult_movi;
	}
	
	public void setFla_ult_movi(String fla_ult_movi) {
		this.fla_ult_movi = fla_ult_movi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "num_sc", nullable = false, insertable = false, updatable = false)
	public Socmast getSocmovimiento() {
		return socmovimiento;
	}

	public void setSocmovimiento(Socmast socmovimiento) {
		this.socmovimiento = socmovimiento;
	}

	
	@Formula("getdate() - fecha_in")
	public Integer getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Integer vencimiento) {
		this.vencimiento = vencimiento;
	}	
	
}
