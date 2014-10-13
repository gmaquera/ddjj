/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.webocma.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 30/9/2014 8:39:54
 */
public class WebInfoPersonalModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String apellidos;
	private String des_nombre;
	private String fec_nacimiento;
	private String nacion;
	private String militar;
	private String brevete;
	private String pasaporte;
	private String carnet;
	private String direccion;
	private int fla_sexo;
	private String des_estadocivil;
	private int c_estadocivil;
	private String telefono;
	private String movil;
	private String mail;
	private String des_email_laboral;
	private String c_departamentonac;
	private String c_provincianac;
	private String c_distritonac;
	private String c_departamento;
	private String c_provincia;
	private String c_distrito;
	private String departamentonac;
	private String provincianac;
	private String distritonac;
	private String departamento;
	private String provincia;
	private String distrito;
	private String des_numiden;
	private String des_docidentidad;
	private String des_gsanguineo;
	private int c_sanguineo;
	
	
	public WebInfoPersonalModel() {
		super();
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDes_nombre() {
		return des_nombre;
	}
	public void setDes_nombre(String des_nombre) {
		this.des_nombre = des_nombre;
	}

	public String getFec_nacimiento() {
		return fec_nacimiento;
	}
	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}
	public String getNacion() {
		return nacion;
	}
	public void setNacion(String nacion) {
		this.nacion = nacion;
	}
	public String getMilitar() {
		return militar;
	}
	public void setMilitar(String militar) {
		this.militar = militar;
	}
	public String getBrevete() {
		return brevete;
	}
	public void setBrevete(String brevete) {
		this.brevete = brevete;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getFla_sexo() {
		return fla_sexo;
	}
	public void setFla_sexo(int fla_sexo) {
		this.fla_sexo = fla_sexo;
	}
	public String getDes_estadocivil() {
		return des_estadocivil;
	}
	public void setDes_estadocivil(String des_estadocivil) {
		this.des_estadocivil = des_estadocivil;
	}
	public int getC_estadocivil() {
		return c_estadocivil;
	}
	public void setC_estadocivil(int c_estadocivil) {
		this.c_estadocivil = c_estadocivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDes_email_laboral() {
		return des_email_laboral;
	}
	public void setDes_email_laboral(String des_email_laboral) {
		this.des_email_laboral = des_email_laboral;
	}
	public String getC_departamentonac() {
		return c_departamentonac;
	}
	public void setC_departamentonac(String c_departamentonac) {
		this.c_departamentonac = c_departamentonac;
	}
	public String getC_provincianac() {
		return c_provincianac;
	}
	public void setC_provincianac(String c_provincianac) {
		this.c_provincianac = c_provincianac;
	}
	public String getC_distritonac() {
		return c_distritonac;
	}
	public void setC_distritonac(String c_distritonac) {
		this.c_distritonac = c_distritonac;
	}
	public String getC_departamento() {
		return c_departamento;
	}
	public void setC_departamento(String c_departamento) {
		this.c_departamento = c_departamento;
	}
	public String getC_provincia() {
		return c_provincia;
	}
	public void setC_provincia(String c_provincia) {
		this.c_provincia = c_provincia;
	}
	public String getC_distrito() {
		return c_distrito;
	}
	public void setC_distrito(String c_distrito) {
		this.c_distrito = c_distrito;
	}
	public String getDepartamentonac() {
		return departamentonac;
	}
	public void setDepartamentonac(String departamentonac) {
		this.departamentonac = departamentonac;
	}
	public String getProvincianac() {
		return provincianac;
	}
	public void setProvincianac(String provincianac) {
		this.provincianac = provincianac;
	}
	public String getDistritonac() {
		return distritonac;
	}
	public void setDistritonac(String distritonac) {
		this.distritonac = distritonac;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getDes_numiden() {
		return des_numiden;
	}
	public void setDes_numiden(String des_numiden) {
		this.des_numiden = des_numiden;
	}
	public String getDes_docidentidad() {
		return des_docidentidad;
	}
	public void setDes_docidentidad(String des_docidentidad) {
		this.des_docidentidad = des_docidentidad;
	}
	public String getDes_gsanguineo() {
		return des_gsanguineo;
	}
	public void setDes_gsanguineo(String des_gsanguineo) {
		this.des_gsanguineo = des_gsanguineo;
	}
	public int getC_sanguineo() {
		return c_sanguineo;
	}
	public void setC_sanguineo(int c_sanguineo) {
		this.c_sanguineo = c_sanguineo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
