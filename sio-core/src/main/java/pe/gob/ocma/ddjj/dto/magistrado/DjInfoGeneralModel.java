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
package pe.gob.ocma.ddjj.dto.magistrado;

import java.io.Serializable;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 10/09/2014 15:18:30
 */
public class DjInfoGeneralModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String des_ap_paterno;
	private String des_ap_materno;
	private String des_nombre;
	private String num_dni;
	private String des_foto;
	private String des_ciudad;
	private String des_distritojudicial;
	private String cargo;
	private String funcion;
	private String area;
	private String direccion_area;
	private String telefono_area;
	private String condicionlab;
	private String regimenlab;
	private String estadolab;
	private String fec_ingreso;
	private String num_escalafon;
	private String num_fotocheck;
	private String num_bnacion;
	private String num_ruc;
	private String cod_contab;
	private String num_essalud;
	private String des_regpension;
	private String des_afp;
	private String des_estadocivil;
	private String num_afp;
	private String des_observacion;
	private String fec_nacimiento;
	private String des_direccion;
	private String num_telefono;
	private String num_movil;
	private String des_email;
	private String des_email_laboral;
	private String departamento;
	private String provincia;
	private String distrito;
	private String fec_modificacion;
	private int fla_sexo;
	private String usuario;
	
	
	
	
	
	public DjInfoGeneralModel() {
		super();
	}
	
	public String getDes_ap_paterno() {
		return des_ap_paterno;
	}
	public void setDes_ap_paterno(String des_ap_paterno) {
		this.des_ap_paterno = des_ap_paterno;
	}
	public String getDes_ap_materno() {
		return des_ap_materno;
	}
	public void setDes_ap_materno(String des_ap_materno) {
		this.des_ap_materno = des_ap_materno;
	}
	public String getDes_nombre() {
		return des_nombre;
	}
	public void setDes_nombre(String des_nombre) {
		this.des_nombre = des_nombre;
	}
	public String getNum_dni() {
		return num_dni;
	}
	public void setNum_dni(String num_dni) {
		this.num_dni = num_dni;
	}
	public String getDes_foto() {
		return des_foto;
	}
	public void setDes_foto(String des_foto) {
		this.des_foto = des_foto;
	}
	public String getDes_ciudad() {
		return des_ciudad;
	}
	public void setDes_ciudad(String des_ciudad) {
		this.des_ciudad = des_ciudad;
	}
	public String getDes_distritojudicial() {
		return des_distritojudicial;
	}
	public void setDes_distritojudicial(String des_distritojudicial) {
		this.des_distritojudicial = des_distritojudicial;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFuncion() {
		return funcion;
	}
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDireccion_area() {
		return direccion_area;
	}
	public void setDireccion_area(String direccion_area) {
		this.direccion_area = direccion_area;
	}
	public String getTelefono_area() {
		return telefono_area;
	}
	public void setTelefono_area(String telefono_area) {
		this.telefono_area = telefono_area;
	}
	public String getCondicionlab() {
		return condicionlab;
	}
	public void setCondicionlab(String condicionlab) {
		this.condicionlab = condicionlab;
	}
	public String getRegimenlab() {
		return regimenlab;
	}
	public void setRegimenlab(String regimenlab) {
		this.regimenlab = regimenlab;
	}
	public String getEstadolab() {
		return estadolab;
	}
	public void setEstadolab(String estadolab) {
		this.estadolab = estadolab;
	}

	public String getFec_ingreso() {
		return fec_ingreso;
	}

	public void setFec_ingreso(String fec_ingreso) {
		this.fec_ingreso = fec_ingreso;
	}

	public String getNum_escalafon() {
		return num_escalafon;
	}
	public void setNum_escalafon(String num_escalafon) {
		this.num_escalafon = num_escalafon;
	}
	public String getNum_fotocheck() {
		return num_fotocheck;
	}
	public void setNum_fotocheck(String num_fotocheck) {
		this.num_fotocheck = num_fotocheck;
	}
	public String getNum_bnacion() {
		return num_bnacion;
	}
	public void setNum_bnacion(String num_bnacion) {
		this.num_bnacion = num_bnacion;
	}
	public String getNum_ruc() {
		return num_ruc;
	}
	public void setNum_ruc(String num_ruc) {
		this.num_ruc = num_ruc;
	}
	public String getCod_contab() {
		return cod_contab;
	}
	public void setCod_contab(String cod_contab) {
		this.cod_contab = cod_contab;
	}
	public String getNum_essalud() {
		return num_essalud;
	}
	public void setNum_essalud(String num_essalud) {
		this.num_essalud = num_essalud;
	}
	public String getDes_regpension() {
		return des_regpension;
	}
	public void setDes_regpension(String des_regpension) {
		this.des_regpension = des_regpension;
	}
	public String getDes_afp() {
		return des_afp;
	}
	public void setDes_afp(String des_afp) {
		this.des_afp = des_afp;
	}
	public String getDes_estadocivil() {
		return des_estadocivil;
	}
	public void setDes_estadocivil(String des_estadocivil) {
		this.des_estadocivil = des_estadocivil;
	}
	public String getNum_afp() {
		return num_afp;
	}
	public void setNum_afp(String num_afp) {
		this.num_afp = num_afp;
	}
	public String getDes_observacion() {
		return des_observacion;
	}
	public void setDes_observacion(String des_observacion) {
		this.des_observacion = des_observacion;
	}
	public String getFec_nacimiento() {
		return fec_nacimiento;
	}
	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}
	public String getDes_direccion() {
		return des_direccion;
	}
	public void setDes_direccion(String des_direccion) {
		this.des_direccion = des_direccion;
	}
	public String getNum_telefono() {
		return num_telefono;
	}
	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}
	public String getNum_movil() {
		return num_movil;
	}
	public void setNum_movil(String num_movil) {
		this.num_movil = num_movil;
	}
	public String getDes_email() {
		return des_email;
	}
	public void setDes_email(String des_email) {
		this.des_email = des_email;
	}
	public String getDes_email_laboral() {
		return des_email_laboral;
	}
	public void setDes_email_laboral(String des_email_laboral) {
		this.des_email_laboral = des_email_laboral;
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



	public String getFec_modificacion() {
		return fec_modificacion;
	}

	public void setFec_modificacion(String fec_modificacion) {
		this.fec_modificacion = fec_modificacion;
	}

	public int getFla_sexo() {
		return fla_sexo;
	}
	public void setFla_sexo(int fla_sexo) {
		this.fla_sexo = fla_sexo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
