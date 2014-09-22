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
package pe.gob.ocma.ddjj.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionIdiomaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpeProfesionalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaCompModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralCVModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoPersonalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjMeritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjPublicacionesModel;
import pe.gob.ocma.ddjj.service.DjCVService;
import pe.gob.ocma.ddjj.service.DjInfoGeneralService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 19/09/2014 08:56:54
 */

@ManagedBean
@ViewScoped
public class DjCVMBean extends BaseMBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<DjInfoPersonalModel> lisInfoPersonalCV = new ArrayList<DjInfoPersonalModel>();
	private List<DjInfoLaboralModel> lisInfoLaboral = new ArrayList<DjInfoLaboralModel>();
	private List<DjInfoLaboralCVModel> lisInfoLaboralCV = new ArrayList<DjInfoLaboralCVModel>();
	private List<DjInfoAcademicaModel> lisInfoAcademicaCV = new ArrayList<DjInfoAcademicaModel>();
	private List<DjInfoAcademicaCompModel> lisInfoAcademicaComCV = new ArrayList<DjInfoAcademicaCompModel>();
	private List<DjCapacitacionModel> lisInfoCapacitacionCV = new ArrayList<DjCapacitacionModel>();
	private List<DjCapacitacionIdiomaModel> lisInfoCapacitacionCompCV = new ArrayList<DjCapacitacionIdiomaModel>();
	private List<DjExpeProfesionalModel> lisInfoExpProfesionalCV = new ArrayList<DjExpeProfesionalModel>();
	private List<DjPublicacionesModel> lisInfoPublicacionesCV = new ArrayList<DjPublicacionesModel>();
	private List<DjMeritoModel> lisInfoMeritoCV = new ArrayList<DjMeritoModel>();
	
	private String sexo;
	private String des_estadocivil;
	private String pasaporte;
	private String fec_nacimiento;
	private String distritonac;
	private String provincianac;
	private String departamentonac;
	private int edad;
	private String distrito;
	private String provincia;
	private String departamento;
	private String direccion;
	
	private String telefono;
	private String movil;
	private String mail;
	private String des_email_laboral;

	
	/// INF.  LABORAL 
	private String num_escalafon;
	private String fec_ingreso;
	private String num_bnacion;
	private String cod_contab;
	private String num_ruc;
	private String des_regpension;
	private String des_afp;
	private String num_essalud;
	private String num_afp;
	
	
	
	@ManagedProperty(value = "#{djCVService}")
	private DjCVService djCVService;
	
	@ManagedProperty(value = "#{djInfoGeneralService}")
	private DjInfoGeneralService djInfoGeneralService;
	
	public DjCVMBean() {

	}
	

	@PostConstruct
	private void inicializar() {
		
		lisInfoPersonalCV = djCVService.lisInfoPersonalCV("69666");
		lisInfoLaboral = djInfoGeneralService.lisInfoLaboral("69666");
		lisInfoLaboralCV = djCVService.lisInfoLaboralCV("69666");
		lisInfoAcademicaCV = djCVService.lisInfoAcademicaCV("69666", "1"); 
		lisInfoAcademicaComCV = djCVService.lisInfoAcademicaComCV("69666", "2");
		lisInfoCapacitacionCV = djCVService.lisInfoCapacitacionCV("69666", "3");
		lisInfoCapacitacionCompCV = djCVService.lisInfoCapacitacionCompCV("69666", "4");
		lisInfoExpProfesionalCV = djCVService.lisInfoExpProfesionalCV("69666", "2");
		lisInfoPublicacionesCV = djCVService.lisInfoPublicacionesCV("69666");
		lisInfoMeritoCV  = djCVService.lisInfoMeritoCV("69666","1");
		
		if(lisInfoPersonalCV.get(0).getFla_sexo() == 1){
			sexo = "Masculino"; 
		}else{
			sexo = "Femenino";
		}
		des_estadocivil = lisInfoPersonalCV.get(0).getDes_estadocivil();
		fec_nacimiento = lisInfoPersonalCV.get(0).getFec_nacimiento();
		departamentonac = lisInfoPersonalCV.get(0).getDepartamentonac();
		provincianac = lisInfoPersonalCV.get(0).getProvincianac();
		distritonac = lisInfoPersonalCV.get(0).getDistritonac();
		edad = lisInfoLaboral.get(0).getEdad();
		
		departamento = lisInfoPersonalCV.get(0).getDepartamento();
		provincia = lisInfoPersonalCV.get(0).getProvincia();
		distrito = lisInfoPersonalCV.get(0).getDistrito();
		direccion = lisInfoPersonalCV.get(0).getDireccion();
		
		telefono = lisInfoPersonalCV.get(0).getTelefono();
		movil = lisInfoPersonalCV.get(0).getMovil();
		mail = lisInfoPersonalCV.get(0).getMail();
		des_email_laboral = lisInfoPersonalCV.get(0).getDes_email_laboral();
		
		////INF  LABORAL CV
		
		num_escalafon = lisInfoLaboralCV.get(0).getNum_escalafon();
		fec_ingreso = lisInfoLaboralCV.get(0).getFec_ingreso();
		num_bnacion = lisInfoLaboralCV.get(0).getNum_bnacion();
		cod_contab = lisInfoLaboralCV.get(0).getCod_contab();
		num_ruc = lisInfoLaboralCV.get(0).getNum_ruc();
		des_regpension = lisInfoLaboralCV.get(0).getDes_regpension();
		des_afp = lisInfoLaboralCV.get(0).getDes_afp();
		num_essalud = lisInfoLaboralCV.get(0).getNum_essalud();
		num_afp = lisInfoLaboralCV.get(0).getNum_afp();
		
	}



	public List<DjMeritoModel> getLisInfoMeritoCV() {
		return lisInfoMeritoCV;
	}


	public void setLisInfoMeritoCV(List<DjMeritoModel> lisInfoMeritoCV) {
		this.lisInfoMeritoCV = lisInfoMeritoCV;
	}


	public List<DjPublicacionesModel> getLisInfoPublicacionesCV() {
		return lisInfoPublicacionesCV;
	}


	public void setLisInfoPublicacionesCV(
			List<DjPublicacionesModel> lisInfoPublicacionesCV) {
		this.lisInfoPublicacionesCV = lisInfoPublicacionesCV;
	}


	public List<DjExpeProfesionalModel> getLisInfoExpProfesionalCV() {
		return lisInfoExpProfesionalCV;
	}


	public void setLisInfoExpProfesionalCV(
			List<DjExpeProfesionalModel> lisInfoExpProfesionalCV) {
		this.lisInfoExpProfesionalCV = lisInfoExpProfesionalCV;
	}


	public List<DjCapacitacionModel> getLisInfoCapacitacionCV() {
		return lisInfoCapacitacionCV;
	}


	public void setLisInfoCapacitacionCV(
			List<DjCapacitacionModel> lisInfoCapacitacionCV) {
		this.lisInfoCapacitacionCV = lisInfoCapacitacionCV;
	}


	public List<DjCapacitacionIdiomaModel> getLisInfoCapacitacionCompCV() {
		return lisInfoCapacitacionCompCV;
	}


	public void setLisInfoCapacitacionCompCV(
			List<DjCapacitacionIdiomaModel> lisInfoCapacitacionCompCV) {
		this.lisInfoCapacitacionCompCV = lisInfoCapacitacionCompCV;
	}


	public List<DjInfoAcademicaCompModel> getLisInfoAcademicaComCV() {
		return lisInfoAcademicaComCV;
	}


	public void setLisInfoAcademicaComCV(
			List<DjInfoAcademicaCompModel> lisInfoAcademicaComCV) {
		this.lisInfoAcademicaComCV = lisInfoAcademicaComCV;
	}


	public List<DjInfoAcademicaModel> getLisInfoAcademicaCV() {
		return lisInfoAcademicaCV;
	}


	public void setLisInfoAcademicaCV(List<DjInfoAcademicaModel> lisInfoAcademicaCV) {
		this.lisInfoAcademicaCV = lisInfoAcademicaCV;
	}


	public List<DjInfoLaboralCVModel> getLisInfoLaboralCV() {
		return lisInfoLaboralCV;
	}


	public void setLisInfoLaboralCV(List<DjInfoLaboralCVModel> lisInfoLaboralCV) {
		this.lisInfoLaboralCV = lisInfoLaboralCV;
	}


	public String getNum_escalafon() {
		return num_escalafon;
	}


	public void setNum_escalafon(String num_escalafon) {
		this.num_escalafon = num_escalafon;
	}


	public String getFec_ingreso() {
		return fec_ingreso;
	}


	public void setFec_ingreso(String fec_ingreso) {
		this.fec_ingreso = fec_ingreso;
	}


	public String getNum_bnacion() {
		return num_bnacion;
	}


	public void setNum_bnacion(String num_bnacion) {
		this.num_bnacion = num_bnacion;
	}


	public String getCod_contab() {
		return cod_contab;
	}


	public void setCod_contab(String cod_contab) {
		this.cod_contab = cod_contab;
	}


	public String getNum_ruc() {
		return num_ruc;
	}


	public void setNum_ruc(String num_ruc) {
		this.num_ruc = num_ruc;
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


	public String getNum_essalud() {
		return num_essalud;
	}


	public void setNum_essalud(String num_essalud) {
		this.num_essalud = num_essalud;
	}


	public String getNum_afp() {
		return num_afp;
	}


	public void setNum_afp(String num_afp) {
		this.num_afp = num_afp;
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


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<DjInfoPersonalModel> getLisInfoPersonalCV() {
		return lisInfoPersonalCV;
	}


	public void setLisInfoPersonalCV(List<DjInfoPersonalModel> lisInfoPersonalCV) {
		this.lisInfoPersonalCV = lisInfoPersonalCV;
	}


	public DjCVService getDjCVService() {
		return djCVService;
	}


	public void setDjCVService(DjCVService djCVService) {
		this.djCVService = djCVService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDes_estadocivil() {
		return des_estadocivil;
	}


	public void setDes_estadocivil(String des_estadocivil) {
		this.des_estadocivil = des_estadocivil;
	}


	public String getPasaporte() {
		return pasaporte;
	}


	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}


	public String getFec_nacimiento() {
		return fec_nacimiento;
	}


	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}


	public String getDistritonac() {
		return distritonac;
	}


	public void setDistritonac(String distritonac) {
		this.distritonac = distritonac;
	}


	public String getProvincianac() {
		return provincianac;
	}


	public void setProvincianac(String provincianac) {
		this.provincianac = provincianac;
	}


	public String getDepartamentonac() {
		return departamentonac;
	}


	public void setDepartamentonac(String departamentonac) {
		this.departamentonac = departamentonac;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public List<DjInfoLaboralModel> getLisInfoLaboral() {
		return lisInfoLaboral;
	}


	public void setLisInfoLaboral(List<DjInfoLaboralModel> lisInfoLaboral) {
		this.lisInfoLaboral = lisInfoLaboral;
	}


	public DjInfoGeneralService getDjInfoGeneralService() {
		return djInfoGeneralService;
	}


	public void setDjInfoGeneralService(DjInfoGeneralService djInfoGeneralService) {
		this.djInfoGeneralService = djInfoGeneralService;
	}
	
	
	
}
