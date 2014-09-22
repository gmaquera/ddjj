/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión de los requerimientos del
 * personal de la OCMA. Constiene las funcionalidades desde
 * que el solicitante realiza una solicitud de un requerimiento 
 * hasta que es atendido por el personal encargado.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.entities.auditoria;

import java.io.Serializable;
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

import pe.gob.ocma.entities.generico.Gettabla;
import pe.gob.ocma.entities.seguridad.Setusuario;

/**
 * POJO para el manejo de logs de las operaciónes realizadas por el usuario
 * @author César Altamirano Menor
 * 26/09/2013 11:37:27
 */
@Entity
@Table(name = "AURTRAZA", schema = "AUDITORIA")
public class Aurtraza implements Serializable {

	private static final long serialVersionUID = 1L;

	private long codTraza;
	private String codUsuario;
	private Setusuario setusuario;
	private String usuario;
	private String operacion;
	private short codTabla;
	private Gettabla gettabla;
	private String nomPk;
	private String valorPk;
	private String campos;
	private String datos;
	private Date fecha;
	private String terminal;

	public Aurtraza() {
		super();
	}

	@Id
	@Column(name = "codTraza", nullable = false)
	public long getCodTraza() {
		return codTraza;
	}

	public void setCodTraza(long codTraza) {
		this.codTraza = codTraza;
	}

	@Column(name = "codUsuario", nullable = false, length = 20)
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codUsuario", nullable = false, insertable = false, updatable = false)
	public Setusuario getSetusuario() {
		return setusuario;
	}

	public void setSetusuario(Setusuario setusuario) {
		this.setusuario = setusuario;
	}

	@Column(name = "usuario", nullable = false, length = 100)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "operacion", nullable = false, length = 20)
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	@Column(name = "codTabla", nullable = false)
	public short getCodTabla() {
		return codTabla;
	}

	public void setCodTabla(short codTabla) {
		this.codTabla = codTabla;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codTabla", nullable = false, insertable = false, updatable = false)
	public Gettabla getGettabla() {
		return gettabla;
	}

	public void setGettabla(Gettabla gettabla) {
		this.gettabla = gettabla;
	}

	@Column(name = "nomPk", nullable = false, length = 20)
	public String getNomPk() {
		return nomPk;
	}

	public void setNomPk(String nomPk) {
		this.nomPk = nomPk;
	}

	@Column(name = "valorPk", nullable = false, length = 100)
	public String getValorPk() {
		return valorPk;
	}

	public void setValorPk(String valorPk) {
		this.valorPk = valorPk;
	}

	@Column(name = "campos", nullable = true)
	public String getCampos() {
		return campos;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}

	@Column(name = "datos", nullable = true)
	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 26)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "terminal", nullable = false, length = 20)
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}	
}
