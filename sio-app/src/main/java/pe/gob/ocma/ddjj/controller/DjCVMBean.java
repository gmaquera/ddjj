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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionIdiomaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjDepartamentoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjDistritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjEstadoCivilModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpeProfesionalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaCompModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoFamiliarModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralCVModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoPersonalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjMeritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjProvinciaMocel;
import pe.gob.ocma.ddjj.dto.magistrado.DjPublicacionesModel;
import pe.gob.ocma.ddjj.service.DjCVService;
import pe.gob.ocma.ddjj.service.DjInfoGeneralService;
import pe.gob.ocma.entities.web.EstadoNoticia;
import pe.gob.ocma.entities.web_ocma.PersonalInfo;
import pe.gob.ocma.entities.web_ocma.TablaEstadoCivil;
import pe.gob.ocma.webocma.dto.WebInfoPersonalModel;
import pe.gob.ocma.webocma.service.WebCVService;

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
	private List<DjInfoFamiliarModel> lisInfoFamiliar = new ArrayList<DjInfoFamiliarModel>();
	
	///*** UPDATE INFO. PERSONAL CV ****////
	//private List<WebInfoPersonalModel> listaData = new ArrayList<WebInfoPersonalModel>();
	
	//// COMBO LISTA -  ESTADO CIVIL 
	private List<DjEstadoCivilModel> lisEstadoCivilCV = new ArrayList<DjEstadoCivilModel>();

	//// COMBO LISTA -  DEPARTAMENTO 
	private List<DjDepartamentoModel> lisDepartamentoCV = new ArrayList<DjDepartamentoModel>();
	//// COMBO LISTA -  PROVINCIA 
	private List<DjProvinciaMocel> lisProvinciaCV = new ArrayList<DjProvinciaMocel>();
	//// COMBO LISTA -  DISTRITO
	private List<DjDistritoModel> lisDistritoCV = new ArrayList<DjDistritoModel>();
	
	private String sexo;
	
	private int fla_sexo;
	//private String getfec_nacimiento;
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
	
	
	private int codEstadocivil;
	private String codDepartamento;
	private String codProvincia;
	private String codDistrito;
	
	private String codDepartamentonac;
	private String codProvincianac;
	private String codDistritonac;
	
	/// LISTA MESSES
	private List<Integer> listaDias= new ArrayList<Integer>();
	private SelectItem[] ListaMeses = new SelectItem[12];
	private List<Integer> listaAnios= new ArrayList<Integer>();
	private int anio,anioLimite;
	private String getMes,getDia,getAnio;
	private String new_Fec_Nacimiento = null ;
	
	
	
	
	@ManagedProperty(value = "#{djCVService}")
	private DjCVService djCVService;
	
	@ManagedProperty(value = "#{djInfoGeneralService}")
	private DjInfoGeneralService djInfoGeneralService;
	
	@ManagedProperty(value = "#{webCVService}")
	private WebCVService webCVService;
	
	public DjCVMBean() {
		
//		ListaMeses [0] = new SelectItem("0", super.getMessage("msgTodos"));
		ListaMeses [0] = new SelectItem(1, super.getMessage("msgEnero"));
		ListaMeses [1] = new SelectItem(2, super.getMessage("msgFebrero"));
		ListaMeses [2] = new SelectItem(3, super.getMessage("msgMarzo"));
		ListaMeses [3] = new SelectItem(4, super.getMessage("msgAbril"));
		ListaMeses [4] = new SelectItem(5, super.getMessage("msgMayo"));
		ListaMeses [5] = new SelectItem(6, super.getMessage("msgJunio"));
		ListaMeses [6] = new SelectItem(7, super.getMessage("msgJulio"));
		ListaMeses [7] = new SelectItem(8, super.getMessage("msgAgosto"));
		ListaMeses [8] = new SelectItem(9, super.getMessage("msgSetiembre"));
		ListaMeses [9] = new SelectItem(10, super.getMessage("msgOctubre"));
		ListaMeses [10] = new SelectItem(11, super.getMessage("msgNoviembre"));
		ListaMeses [11] = new SelectItem(12, super.getMessage("msgDiciembre"));

	}
	

	@PostConstruct
	private void inicializar() {
		
	  //codEstadocivil = 0;
	  //codDepartamento ="01";
	  //codProvincia = "01";
				
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
	  lisInfoFamiliar  = djCVService.lisInfoFamiliarCV(69666,0);
	  System.out.println("sexo:"+ lisInfoPersonalCV.get(0).getFla_sexo());
	  fla_sexo = lisInfoPersonalCV.get(0).getFla_sexo();
	  if(lisInfoPersonalCV.get(0).getFla_sexo() == 1){
		  sexo = "Masculino";
	  }else{
		  sexo = "Femenino";
	  }
	  pasaporte = lisInfoPersonalCV.get(0).getPasaporte();
	  /////Datos  de Nacimiento //////
	  codEstadocivil  = lisInfoPersonalCV.get(0).getC_estadocivil();
	  codProvincianac = lisInfoPersonalCV.get(0).getC_provincianac();
	  codDepartamentonac = lisInfoPersonalCV.get(0).getC_departamentonac();
	  codDistritonac = lisInfoPersonalCV.get(0).getC_distritonac();
	  ////////////////////////////////
	  
	  /////Datos  de Residencia //////
	  codProvincia = lisInfoPersonalCV.get(0).getC_provincia();
	  codDepartamento = lisInfoPersonalCV.get(0).getC_departamento();
	  codDistrito = lisInfoPersonalCV.get(0).getC_distrito();
	  ////////////////////////////////
	  
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
	  
	  ////	INF  LABORAL CV
	  
	  num_escalafon = lisInfoLaboralCV.get(0).getNum_escalafon();
	  fec_ingreso = lisInfoLaboralCV.get(0).getFec_ingreso();
	  num_bnacion = lisInfoLaboralCV.get(0).getNum_bnacion();
	  cod_contab = lisInfoLaboralCV.get(0).getCod_contab();
	  num_ruc = lisInfoLaboralCV.get(0).getNum_ruc();
	  des_regpension = lisInfoLaboralCV.get(0).getDes_regpension();
	  des_afp = lisInfoLaboralCV.get(0).getDes_afp();
	  num_essalud = lisInfoLaboralCV.get(0).getNum_essalud();
	  num_afp = lisInfoLaboralCV.get(0).getNum_afp();
	  
	  /// COMBO  ESTADO - CIVIL 
	  lisEstadoCivilCV = djCVService.lisEstadoCivilCV();
	  /// COMBO  DEPARTAMENTO
	  lisDepartamentoCV = djCVService.lisDepartamentoCV();
	  /// COMBO  PROVINCIA 
	  lisProvinciaCV = djCVService.lisProvinciaCV(codDepartamento);
	  /// COMBO  DISTRITO
	  lisDistritoCV = djCVService.lisDistritoCV(codProvincia, codDepartamento);
	  
	  
	  
	  ///// COMBOS  FECHA  DE NACIMIENTO
	  
	  //  LISTA  DIAS  
	  for (int i = 1; i < 32 ; i++) {
		  listaDias.add(i);
		  
		  //System.out.println(dropList.get(i));
	  }
	  
	  Calendar calendar = Calendar.getInstance();
	  
	  anio = calendar.get(calendar.YEAR);
	  //LISTA ANIOS 
	  anioLimite = anio - 25;
	  for (int j = 1927; j < anioLimite ; j++) {
		  
		  listaAnios.add(j);	
		  
	  }	
	  
	  
	  // DIA 
	  getDia =listaDias.get(Integer.parseInt(fec_nacimiento.toString().substring(0, 2).toString())-1).toString();
	  System.out.println("Dia :" + getDia);
	  
	  // MES
	  getMes = fec_nacimiento.toString().substring(3, 5);
	  
	  getMes = listaDias.get(Integer.parseInt(fec_nacimiento.toString().substring(3, 5).toString())-1).toString();
	  
	  // AÑIO
	  getAnio = fec_nacimiento.toString().substring(6, 10);
	  
	  new_Fec_Nacimiento = getAnio + "-" + getMes + "-" + getDia;
	  System.out.println("Fec  nacimiento  inicializar : " + new_Fec_Nacimiento.toString());
			
	}	
		
	
	public void updateInfoPersonalCV(ActionEvent ev){
		
		//WebInfoPersonalModel listaDataInfPer = new WebInfoPersonalModel();
		WebInfoPersonalModel personal = new WebInfoPersonalModel();
		
		new_Fec_Nacimiento = getAnio + "-" + getMes + "-" + getDia;
		System.out.println("UPDATE ----- " + new_Fec_Nacimiento.toString());
		try {
//			System.out.println("UPDATE : " + new_Fec_Nacimiento);
			//listaDataInfPer.set(69666);
//			personal.setc(69666);
			personal.setFla_sexo(fla_sexo);
			personal.setC_estadocivil(codEstadocivil);
			personal.setPasaporte(pasaporte);
//			TablaEstadoCivil tablaEstadoCivil = new TablaEstadoCivil();
//			tablaEstadoCivil.setCodEstadocivil(codEstadocivil);
			
	
//			***** DATOS  DEL NACIMIENTO *****///

//			Date getfec_nacimiento = new Date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//			getfec_nacimiento = dateFormat.parse(new_Fec_Nacimiento);
//			System.out.println("UPDATE : " +  getfec_nacimiento.toString());
			
			//personal.setFec_nacimiento(new_Fec_Nacimiento);
			personal.setFec_nacimiento(new_Fec_Nacimiento);
			personal.setC_departamentonac(codDepartamentonac);
			personal.setC_provincianac(codProvincianac);
			personal.setC_distritonac(codDistritonac);
	
		
			//***** DATOS  DE  RESIDENCIA  *****///
			personal.setDireccion(direccion);
			personal.setC_departamento(codDepartamento);
			personal.setC_provincia(codProvincia);
			personal.setC_distrito(codDistrito);
		
	
			//***** MEDIOS  DEL CONTACTO  *****///
			
			personal.setTelefono(telefono);
			personal.setMovil(movil);
			personal.setMail(mail);
			personal.setDes_email_laboral(des_email_laboral);
			
			webCVService.EditarInfPersonalCV(personal,69666);
			addInfoMessage(super.getMessage("msgCambiosGuardadosExito"));
			addCallbackParam("correcto", true);
			//lisInfoPersonalCV = djCVService.lisInfoPersonalCV("69666");
			
		} catch (Exception ex) {
			String msg = super.getMessage("errorGuardandoDatos");
			logger.error(msg, ex);
			addErrorMessage(msg);
		}
		//lisInfoPersonalCV = djCVService.lisInfoPersonalCV("69666");
	}
	

	public void seleccionarDepartamento(){
		lisProvinciaCV = djCVService.lisProvinciaCV(codDepartamento);
		
	}

	public void seleccionarDProvincia(){
		lisDistritoCV = djCVService.lisDistritoCV(codProvincia, codDepartamento);
		
	}
	

	public void seleccionarDepartamentonac(){
		lisProvinciaCV = djCVService.lisProvinciaCV(codDepartamentonac);
		
	}

	public void seleccionarDProvincianac(){
		lisDistritoCV = djCVService.lisDistritoCV(codProvincianac, codDepartamentonac);
		
	}
	
	/////////////////////


	public String getNew_Fec_Nacimiento() {
		return new_Fec_Nacimiento;
	}

	public String getSexo() {
		return sexo;
	}


	public int getFla_sexo() {
		return fla_sexo;
	}


	public void setFla_sexo(int fla_sexo) {
		this.fla_sexo = fla_sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setNew_Fec_Nacimiento(String new_Fec_Nacimiento) {
		this.new_Fec_Nacimiento = new_Fec_Nacimiento;
	}


	public WebCVService getWebCVService() {
		return webCVService;
	}


	public void setWebCVService(WebCVService webCVService) {
		this.webCVService = webCVService;
	}


		public SelectItem[] getListaMeses() {
		return ListaMeses;
	}

	
	public String getGetDia() {
		return getDia;
	}


	public void setGetDia(String getDia) {
		this.getDia = getDia;
	}


	public String getGetAnio() {
		return getAnio;
	}


	public void setGetAnio(String getAnio) {
		this.getAnio = getAnio;
	}


	public String getGetMes() {
		return getMes;
	}


	public void setGetMes(String getMes) {
		this.getMes = getMes;
	}


	public int getAnio() {
		return anio;
	}


	public void setAnio(int anio) {
		this.anio = anio;
	}


	public int getAnioLimite() {
		return anioLimite;
	}


	public void setAnioLimite(int anioLimite) {
		this.anioLimite = anioLimite;
	}


	public List<Integer> getListaDias() {
		return listaDias;
	}


	public void setListaDias(List<Integer> listaDias) {
		this.listaDias = listaDias;
	}


	public List<Integer> getListaAnios() {
		return listaAnios;
	}


	public void setListaAnios(List<Integer> listaAnios) {
		this.listaAnios = listaAnios;
	}


	public void setListaMeses(SelectItem[] listaMeses) {
		this.ListaMeses = listaMeses;
	}


	public String getCodDepartamentonac() {
		return codDepartamentonac;
	}


	public void setCodDepartamentonac(String codDepartamentonac) {
		this.codDepartamentonac = codDepartamentonac;
	}


	public String getCodProvincianac() {
		return codProvincianac;
	}


	public void setCodProvincianac(String codProvincianac) {
		this.codProvincianac = codProvincianac;
	}


	public String getCodDistritonac() {
		return codDistritonac;
	}


	public void setCodDistritonac(String codDistritonac) {
		this.codDistritonac = codDistritonac;
	}


	public String getCodDistrito() {
		return codDistrito;
	}


	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}


	public String getCodDepartamento() {
		return codDepartamento;
	}


	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}


	public String getCodProvincia() {
		return codProvincia;
	}


	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}


	public List<DjDepartamentoModel> getLisDepartamentoCV() {
		return lisDepartamentoCV;
	}


	public void setLisDepartamentoCV(List<DjDepartamentoModel> lisDepartamentoCV) {
		this.lisDepartamentoCV = lisDepartamentoCV;
	}


	public List<DjProvinciaMocel> getLisProvinciaCV() {
		return lisProvinciaCV;
	}


	public void setLisProvinciaCV(List<DjProvinciaMocel> lisProvinciaCV) {
		this.lisProvinciaCV = lisProvinciaCV;
	}


	public List<DjDistritoModel> getLisDistritoCV() {
		return lisDistritoCV;
	}


	public void setLisDistritoCV(List<DjDistritoModel> lisDistritoCV) {
		this.lisDistritoCV = lisDistritoCV;
	}


	public List<DjEstadoCivilModel> getLisEstadoCivilCV() {
		return lisEstadoCivilCV;
	}


	public void setLisEstadoCivilCV(List<DjEstadoCivilModel> lisEstadoCivilCV) {
		this.lisEstadoCivilCV = lisEstadoCivilCV;
	}


	public int getCodEstadocivil() {
		return codEstadocivil;
	}


	public void setCodEstadocivil(int codEstadocivil) {
		this.codEstadocivil = codEstadocivil;
	}


	public List<DjInfoFamiliarModel> getLisInfoFamiliar() {
		return lisInfoFamiliar;
	}


	public void setLisInfoFamiliar(List<DjInfoFamiliarModel> lisInfoFamiliar) {
		this.lisInfoFamiliar = lisInfoFamiliar;
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
