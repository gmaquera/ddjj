package pe.gob.ocma.entities.oc_ocma;
// Generated 16/05/2014 08:49:48 AM by Hibernate Tools 3.4.0.CR1

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
 * DjLista generated by hbm2java
 */
@Entity
@Table(name = "DJ_LISTA", schema = "OC_OCMA")
public class DjLista implements java.io.Serializable {

	private int codLista;
	private String desNumeroOficio;
	private String desRemitente;
	private String desNombre;
	private Date fecEnvioLista;
	private int codTipoLista;
	private Date fecCreacion;
	private Date fecModificacion;
	private int desEjercicio;
	private Integer flaEstadoLista;
	private Set<DjListaxdj> djListaxdjs = new HashSet<DjListaxdj>(0);

	public DjLista() {
	}

	public DjLista(int codLista, String desNumeroOficio, String desRemitente,
			String desNombre, Date fecEnvioLista, int codTipoLista,
			Date fecCreacion, int desEjercicio) {
		this.codLista = codLista;
		this.desNumeroOficio = desNumeroOficio;
		this.desRemitente = desRemitente;
		this.desNombre = desNombre;
		this.fecEnvioLista = fecEnvioLista;
		this.codTipoLista = codTipoLista;
		this.fecCreacion = fecCreacion;
		this.desEjercicio = desEjercicio;
	}

	public DjLista(int codLista, String desNumeroOficio, String desRemitente,
			String desNombre, Date fecEnvioLista, int codTipoLista,
			Date fecCreacion, Date fecModificacion, int desEjercicio,
			Integer flaEstadoLista, Set<DjListaxdj> djListaxdjs) {
		this.codLista = codLista;
		this.desNumeroOficio = desNumeroOficio;
		this.desRemitente = desRemitente;
		this.desNombre = desNombre;
		this.fecEnvioLista = fecEnvioLista;
		this.codTipoLista = codTipoLista;
		this.fecCreacion = fecCreacion;
		this.fecModificacion = fecModificacion;
		this.desEjercicio = desEjercicio;
		this.flaEstadoLista = flaEstadoLista;
		this.djListaxdjs = djListaxdjs;
	}

	@Id
	@Column(name = "COD_LISTA", nullable = false)
	public int getCodLista() {
		return this.codLista;
	}

	public void setCodLista(int codLista) {
		this.codLista = codLista;
	}

	@Column(name = "DES_NUMERO_OFICIO", nullable = false, length = 50)
	public String getDesNumeroOficio() {
		return this.desNumeroOficio;
	}

	public void setDesNumeroOficio(String desNumeroOficio) {
		this.desNumeroOficio = desNumeroOficio;
	}

	@Column(name = "DES_REMITENTE", nullable = false, length = 150)
	public String getDesRemitente() {
		return this.desRemitente;
	}

	public void setDesRemitente(String desRemitente) {
		this.desRemitente = desRemitente;
	}

	@Column(name = "DES_NOMBRE", nullable = false, length = 150)
	public String getDesNombre() {
		return this.desNombre;
	}

	public void setDesNombre(String desNombre) {
		this.desNombre = desNombre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_ENVIO_LISTA", nullable = false, length = 10)
	public Date getFecEnvioLista() {
		return this.fecEnvioLista;
	}

	public void setFecEnvioLista(Date fecEnvioLista) {
		this.fecEnvioLista = fecEnvioLista;
	}

	@Column(name = "COD_TIPO_LISTA", nullable = false)
	public int getCodTipoLista() {
		return this.codTipoLista;
	}

	public void setCodTipoLista(int codTipoLista) {
		this.codTipoLista = codTipoLista;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_CREACION", nullable = false, length = 10)
	public Date getFecCreacion() {
		return this.fecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FEC_MODIFICACION", length = 10)
	public Date getFecModificacion() {
		return this.fecModificacion;
	}

	public void setFecModificacion(Date fecModificacion) {
		this.fecModificacion = fecModificacion;
	}

	@Column(name = "DES_EJERCICIO", nullable = false)
	public int getDesEjercicio() {
		return this.desEjercicio;
	}

	public void setDesEjercicio(int desEjercicio) {
		this.desEjercicio = desEjercicio;
	}

	@Column(name = "FLA_ESTADO_LISTA")
	public Integer getFlaEstadoLista() {
		return this.flaEstadoLista;
	}

	public void setFlaEstadoLista(Integer flaEstadoLista) {
		this.flaEstadoLista = flaEstadoLista;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "djLista")
	public Set<DjListaxdj> getDjListaxdjs() {
		return this.djListaxdjs;
	}

	public void setDjListaxdjs(Set<DjListaxdj> djListaxdjs) {
		this.djListaxdjs = djListaxdjs;
	}

}
