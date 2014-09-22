package pe.gob.ocma.entities.web_ocma;

// Generated 19/09/2014 11:18:41 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IngresoAuditoria generated by hbm2java
 */
@Entity
@Table(name = "INGRESO_AUDITORIA", schema = "WEB_OCMA")
public class IngresoAuditoria implements java.io.Serializable {

	private IngresoAuditoriaId id;
	private Usuario usuario;
	private Date fecIngreso;
	private String numIp;
	private Integer codModulo;

	public IngresoAuditoria() {
	}

	public IngresoAuditoria(IngresoAuditoriaId id, Usuario usuario,
			Date fecIngreso) {
		this.id = id;
		this.usuario = usuario;
		this.fecIngreso = fecIngreso;
	}

	public IngresoAuditoria(IngresoAuditoriaId id, Usuario usuario,
			Date fecIngreso, String numIp, Integer codModulo) {
		this.id = id;
		this.usuario = usuario;
		this.fecIngreso = fecIngreso;
		this.numIp = numIp;
		this.codModulo = codModulo;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codUsuario", column = @Column(name = "COD_USUARIO", nullable = false, length = 20)),
			@AttributeOverride(name = "codAuditoria", column = @Column(name = "COD_AUDITORIA", nullable = false)) })
	public IngresoAuditoriaId getId() {
		return this.id;
	}

	public void setId(IngresoAuditoriaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_USUARIO", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_INGRESO", nullable = false, length = 26)
	public Date getFecIngreso() {
		return this.fecIngreso;
	}

	public void setFecIngreso(Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}

	@Column(name = "NUM_IP", length = 20)
	public String getNumIp() {
		return this.numIp;
	}

	public void setNumIp(String numIp) {
		this.numIp = numIp;
	}

	@Column(name = "COD_MODULO")
	public Integer getCodModulo() {
		return this.codModulo;
	}

	public void setCodModulo(Integer codModulo) {
		this.codModulo = codModulo;
	}

}
