package pe.gob.ocma.entities.oc_ocma;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SEGU_MOVI", schema = "OC_OCMA")
public class SeguMovi implements java.io.Serializable {
	
	private SeguMoviId id;
	private ExpeMast expeMast;
	private ExpeEsta moviEstado;
	private Integer cod_estado;
	private String des_notas;
	private Date fec_movimi;
	private Integer num_fojas;
	private String fla_ultmov;
	private Integer num_fojas_documento;
	private String cod_usuario_creacion;
	private Date fec_creacion;
	private String cod_usuario_modificacion;
	private Date fec_modificacion;
	private Integer cod_encargado;
	
	public SeguMovi() {
		super();
	}
	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codDistritoOrigen", column = @Column(name = "COD_DISTRITO_ORIGEN", nullable = false)),
			@AttributeOverride(name = "codIntexp", column = @Column(name = "COD_INTEXP", nullable = false)),
			@AttributeOverride(name = "numSecuen", column = @Column(name = "NUM_SECUEN", nullable = false)) })
	public SeguMoviId getId() {
		return id;
	}

	public void setId(SeguMoviId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "COD_DISTRITO_ORIGEN", referencedColumnName = "COD_DISTRITO_ORIGEN", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "COD_INTEXP", referencedColumnName = "COD_INTEXP", nullable = false, insertable = false, updatable = false) })
	public ExpeMast getExpeMast() {
		return expeMast;
	}

	public void setExpeMast(ExpeMast expeMast) {
		this.expeMast = expeMast;
	}

	@Column(name = "cod_estado", nullable = false)
	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}

	@Column(name = "des_notas", length = 200)
	public String getDes_notas() {
		return des_notas;
	}

	public void setDes_notas(String des_notas) {
		this.des_notas = des_notas;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fec_movimi", length = 10)
	public Date getFec_movimi() {
		return fec_movimi;
	}

	public void setFec_movimi(Date fec_movimi) {
		this.fec_movimi = fec_movimi;
	}

	@Column(name = "num_fojas")
	public Integer getNum_fojas() {
		return num_fojas;
	}

	public void setNum_fojas(Integer num_fojas) {
		this.num_fojas = num_fojas;
	}

	@Column(name = "fla_ultmov", length = 1)
	public String getFla_ultmov() {
		return fla_ultmov;
	}

	public void setFla_ultmov(String fla_ultmov) {
		this.fla_ultmov = fla_ultmov;
	}

	@Column(name = "num_fojas_documento")
	public Integer getNum_fojas_documento() {
		return num_fojas_documento;
	}

	public void setNum_fojas_documento(Integer num_fojas_documento) {
		this.num_fojas_documento = num_fojas_documento;
	}

	@Column(name = "cod_usuario_creacion", length = 20)
	public String getCod_usuario_creacion() {
		return cod_usuario_creacion;
	}

	public void setCod_usuario_creacion(String cod_usuario_creacion) {
		this.cod_usuario_creacion = cod_usuario_creacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fec_creacion", length = 10)
	public Date getFec_creacion() {
		return fec_creacion;
	}

	public void setFec_creacion(Date fec_creacion) {
		this.fec_creacion = fec_creacion;
	}

	@Column(name = "cod_usuario_modificacion", length = 20)
	public String getCod_usuario_modificacion() {
		return cod_usuario_modificacion;
	}

	public void setCod_usuario_modificacion(String cod_usuario_modificacion) {
		this.cod_usuario_modificacion = cod_usuario_modificacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fec_modificacion", length = 10)
	public Date getFec_modificacion() {
		return fec_modificacion;
	}

	public void setFec_modificacion(Date fec_modificacion) {
		this.fec_modificacion = fec_modificacion;
	}

	@Column(name = "cod_encargado")
	public Integer getCod_encargado() {
		return cod_encargado;
	}

	public void setCod_encargado(Integer cod_encargado) {
		this.cod_encargado = cod_encargado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_estado", nullable = false, insertable = false, updatable = false)
	public ExpeEsta getMoviEstado() {
		return moviEstado;
	}

	public void setMoviEstado(ExpeEsta moviEstado) {
		this.moviEstado = moviEstado;
	}			
	
	
}
