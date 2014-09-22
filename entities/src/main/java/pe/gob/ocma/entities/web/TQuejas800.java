package pe.gob.ocma.entities.web;

// Generated 27/11/2013 01:05:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TQuejas800 generated by hbm2java
 */
@Entity
@Table(name = "T_QUEJAS_800", schema = "WEB")
public class TQuejas800 implements java.io.Serializable {

	private int idQueja;
	private Date fecha;
	private Date horaInicio;
	private Date horaFinal;
	private String telefono;
	private String nombres;
	private String apellidos;
	private String dni;
	private String detalle;

	public TQuejas800() {
	}

	public TQuejas800(int idQueja) {
		this.idQueja = idQueja;
	}

	public TQuejas800(int idQueja, Date fecha, Date horaInicio, Date horaFinal,
			String telefono, String nombres, String apellidos, String dni,
			String detalle) {
		this.idQueja = idQueja;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.telefono = telefono;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.detalle = detalle;
	}

	@Id
	@Column(name = "id_queja", nullable = false)
	public int getIdQueja() {
		return this.idQueja;
	}

	public void setIdQueja(int idQueja) {
		this.idQueja = idQueja;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", length = 26)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicio", length = 26)
	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_final", length = 26)
	public Date getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Column(name = "telefono", length = 20)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "nombres", length = 50)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Column(name = "apellidos", length = 50)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "dni", length = 50)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "detalle", length = 50)
	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
