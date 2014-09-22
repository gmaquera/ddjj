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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpedientesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoGeneralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjSancionesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjTrayMagistradoModel;
import pe.gob.ocma.ddjj.service.DjInfoGeneralService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 10/09/2014 16:40:58
 */

@ManagedBean
@ViewScoped
public class DjInfoGeneralMBean extends BaseMBean implements Serializable{

	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;
	private List<DjInfoGeneralModel> lisInfoGeneral = new ArrayList<DjInfoGeneralModel>();
	private List<DjInfoLaboralModel> lisInfoLaboral = new ArrayList<DjInfoLaboralModel>();
	private List<DjTrayMagistradoModel> lisTrayectoriaMagis = new ArrayList<DjTrayMagistradoModel>();
	private List<DjExpedientesModel> lisExpedienteMagis = new ArrayList<DjExpedientesModel>();
	private List<DjSancionesModel> lisSancionesMagis = new ArrayList<DjSancionesModel>();
	
	//EXPEDIENTES 
	
	private Integer c_tot_queja; //
	private Integer c_tot_visita; //
	private Integer c_expediente_archivado; //
	private Integer c_tot_expediente; 
		
	private Integer c_tot_cautelar; //
	private Integer c_tot_rehabilitado; //
	private Integer c_tot_tramite; //
	
	private Integer c_tot_investigacion; //
	private Integer c_tot_expediente_rehabilitacion;
	private Integer c_tot_sancion; //

	//SANCIONES
	
	private Integer c_tot_apercibimiento; //
	private Integer c_tot_suspencion; //
	private Integer c_tot_multa; //
	private Integer c_tot_destituciones; //
	private Integer c_tot_sanciones; //
	
	
	private String ap_paterno;
	private String ap_materno;
	private String des_nombre;
	private String num_dni;
	private String des_direccion;
	private String num_tel;
	private String num_movil;
	private String des_email;
	private String des_emaillaboral;
	private String fec_nacimiento;
	private String des_foto;
	private String des_distritojudicial;
	private String des_ciudad;
	private String cargo;
	private String condicionlab;
	private String fec_ingreso;
	private int edad;
	private String msg;
	
	@ManagedProperty(value = "#{djInfoGeneralService}")
	private DjInfoGeneralService djInfoGeneralService;
	

	public DjInfoGeneralMBean() {

	}
	

	@PostConstruct
	private void inicializar() {
	
		lisInfoLaboral = djInfoGeneralService.lisInfoLaboral("69666");
		lisInfoGeneral =djInfoGeneralService.lisInfoGeneral("69666");
		lisTrayectoriaMagis = djInfoGeneralService.lisTrayectoriaMagis("69666");
		lisExpedienteMagis = djInfoGeneralService.lisExpedienteMagis(69666,1,5);
		lisSancionesMagis = djInfoGeneralService.lisSancionesMagis(0, 69666, 0, 5);
		
		ap_paterno =lisInfoGeneral.get(0).getDes_ap_paterno();
		ap_materno =lisInfoGeneral.get(0).getDes_ap_materno();
		des_nombre =lisInfoGeneral.get(0).getDes_nombre();
		num_dni  = lisInfoGeneral.get(0).getNum_dni();
		des_direccion = lisInfoGeneral.get(0).getDes_direccion();
		num_tel = lisInfoGeneral.get(0).getNum_telefono();
		num_movil = lisInfoGeneral.get(0).getNum_movil();
		des_email =  lisInfoGeneral.get(0).getDes_email();
		des_emaillaboral = lisInfoGeneral.get(0).getDes_email_laboral();
		fec_nacimiento = lisInfoGeneral.get(0).getFec_nacimiento();
		des_foto =  lisInfoGeneral.get(0).getDes_foto();
		des_distritojudicial =lisInfoGeneral.get(0).getDes_distritojudicial();
		des_ciudad = lisInfoGeneral.get(0).getDes_ciudad();
		cargo = lisInfoGeneral.get(0).getCargo();
		condicionlab =lisInfoGeneral.get(0).getCondicionlab();
		
		//fec_inicio_cargo =lisInfoLaboral.get(0).getFec_inicio_cargo();
		fec_ingreso =  lisInfoGeneral.get(0).getFec_ingreso();
		edad = lisInfoLaboral.get(0).getEdad();
		
		
		if(lisSancionesMagis.size() == 0){
			msg = "NO REGISTRA MEDIDAS DISCIPLINARIAS";
		}
		///EXPEDIENTES
	
		
		
	}

	
	
	
	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public List<DjExpedientesModel> getLisExpedienteMagis() {
		return lisExpedienteMagis;
	}


	public void setLisExpedienteMagis(List<DjExpedientesModel> lisExpedienteMagis) {
		this.lisExpedienteMagis = lisExpedienteMagis;
	}


	public List<DjTrayMagistradoModel> getLisTrayectoriaMagis() {
		return lisTrayectoriaMagis;
	}


	public void setLisTrayectoriaMagis(
			List<DjTrayMagistradoModel> lisTrayectoriaMagis) {
		this.lisTrayectoriaMagis = lisTrayectoriaMagis;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDes_distritojudicial() {
		return des_distritojudicial;
	}


	public void setDes_distritojudicial(String des_distritojudicial) {
		this.des_distritojudicial = des_distritojudicial;
	}


	public String getDes_ciudad() {
		return des_ciudad;
	}


	public void setDes_ciudad(String des_ciudad) {
		this.des_ciudad = des_ciudad;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getCondicionlab() {
		return condicionlab;
	}


	public void setCondicionlab(String condicionlab) {
		this.condicionlab = condicionlab;
	}


	public String getFec_ingreso() {
		return fec_ingreso;
	}


	public void setFec_ingreso(String fec_ingreso) {
		this.fec_ingreso = fec_ingreso;
	}


	public String getDes_foto() {
		return des_foto;
	}


	public void setDes_foto(String des_foto) {
		this.des_foto = des_foto;
	}


	public String getDes_email() {
		return des_email;
	}


	public void setDes_email(String des_email) {
		this.des_email = des_email;
	}


	public String getDes_emaillaboral() {
		return des_emaillaboral;
	}


	public void setDes_emaillaboral(String des_emaillaboral) {
		this.des_emaillaboral = des_emaillaboral;
	}


	public String getFec_nacimiento() {
		return fec_nacimiento;
	}


	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}


	public Logger getLogger() {
		return logger;
	}


	public void setLogger(Logger logger) {
		this.logger = logger;
	}


	public List<DjInfoGeneralModel> getLisInfoGeneral() {
		return lisInfoGeneral;
	}


	public void setLisInfoGeneral(List<DjInfoGeneralModel> lisInfoGeneral) {
		this.lisInfoGeneral = lisInfoGeneral;
	}


	public DjInfoGeneralService getDjInfoGeneralService() {
		return djInfoGeneralService;
	}


	public void setDjInfoGeneralService(DjInfoGeneralService djInfoGeneralService) {
		this.djInfoGeneralService = djInfoGeneralService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAp_paterno() {
		return ap_paterno;
	}


	public void setAp_paterno(String ap_paterno) {
		this.ap_paterno = ap_paterno;
	}


	public String getAp_materno() {
		return ap_materno;
	}


	public void setAp_materno(String ap_materno) {
		this.ap_materno = ap_materno;
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


	public String getDes_direccion() {
		return des_direccion;
	}


	public void setDes_direccion(String des_direccion) {
		this.des_direccion = des_direccion;
	}


	public String getNum_tel() {
		return num_tel;
	}


	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}


	public String getNum_movil() {
		return num_movil;
	}


	public void setNum_movil(String num_movil) {
		this.num_movil = num_movil;
	}


	public List<DjInfoLaboralModel> getLisInfoLaboral() {
		return lisInfoLaboral;
	}


	public void setLisInfoLaboral(List<DjInfoLaboralModel> lisInfoLaboral) {
		this.lisInfoLaboral = lisInfoLaboral;
	}

	public Integer getC_tot_queja() {
 
		//return c_tot_queja;
		int c_tot_queja_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_queja_ += Integer.parseInt(tot.getC_tot_queja().toString());
		}
		return c_tot_queja_;
		
	}


	public void setC_tot_queja(Integer c_tot_queja) {
		this.c_tot_queja = c_tot_queja;
	}


	public Integer getC_tot_visita() {
		//return c_tot_visita;
		int c_tot_visita_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_visita_ += Integer.parseInt(tot.getC_tot_visita().toString());
		}
		return c_tot_visita_;
	}


	public void setC_tot_visita(Integer c_tot_visita) {
		this.c_tot_visita = c_tot_visita;
	}


	public Integer getC_expediente_archivado() {
		//return c_expediente_archivado_;
		int c_expediente_archivado_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			
			if(tot.getCod_estado_() == 2){
				
				c_expediente_archivado_ = c_expediente_archivado_ + 1;
			}
		}
		c_expediente_archivado = c_expediente_archivado_;
		return c_expediente_archivado_;

	}


	public void setC_expediente_archivado(Integer c_expediente_archivado) {
		this.c_expediente_archivado = c_expediente_archivado;
	}


	public Integer getC_tot_expediente() {
		
		int c_tot_expediente_ = 0;
		c_tot_expediente_ = getC_tot_queja() + getC_tot_cautelar() + getC_tot_investigacion() + getC_tot_visita() + getC_tot_rehabilitado();
		return c_tot_expediente_;
		
	}


	public void setC_tot_expediente(Integer c_tot_expediente) {
		this.c_tot_expediente = c_tot_expediente;
	}


	public Integer getC_tot_cautelar() {
		//return c_tot_cautelar;
		int c_tot_cautelar_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_cautelar_ += Integer.parseInt(tot.getC_tot_cautelar().toString());
		}
		return c_tot_cautelar_;
	}


	public void setC_tot_cautelar(Integer c_tot_cautelar) {
		this.c_tot_cautelar = c_tot_cautelar;
	}


	public Integer getC_tot_rehabilitado() {
		//return c_tot_rehabilitado;
		int c_tot_rehabilitado_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_rehabilitado_ += Integer.parseInt(tot.getC_tot_rehabilitado().toString());
		}
		return c_tot_rehabilitado_;
	}


	public void setC_tot_rehabilitado(Integer c_tot_rehabilitado) {
		this.c_tot_rehabilitado = c_tot_rehabilitado;
	}


	public Integer getC_tot_tramite() {
		//return c_tot_tramite_;
		int c_tot_tramite_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			
			if(tot.getCod_estado_() == 1){
				
				c_tot_tramite_ = c_tot_tramite_ + 1;
				
			}
			
		}
		c_tot_tramite = c_tot_tramite_;
		return c_tot_tramite_;
	}


	public void setC_tot_tramite(Integer c_tot_tramite) {
		this.c_tot_tramite = c_tot_tramite;
	}


	public Integer getC_tot_investigacion() {
		//return c_tot_investigacion_;
		int c_tot_investigacion_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_investigacion_ += Integer.parseInt(tot.getC_tot_investigacion().toString());
		}
		return c_tot_investigacion_;
	}


	public void setC_tot_investigacion(Integer c_tot_investigacion) {
		this.c_tot_investigacion = c_tot_investigacion;
	}


	public Integer getC_tot_expediente_rehabilitacion() {
		//return c_tot_expediente_rehabilitacion_;
		int c_tot_expediente_rehabilitacion_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			
			if(tot.getCod_estado_() == 3){
				
				c_tot_expediente_rehabilitacion_ += c_tot_expediente_rehabilitacion_ + 1;
			}
		}
		c_tot_expediente_rehabilitacion = c_tot_expediente_rehabilitacion_;
		return c_tot_expediente_rehabilitacion;
	}


	public void setC_tot_expediente_rehabilitacion(
			Integer c_tot_expediente_rehabilitacion) {
		this.c_tot_expediente_rehabilitacion = c_tot_expediente_rehabilitacion;
	}


	public Integer getC_tot_sancion() {
		//return c_tot_sancion;
		
		int c_tot_sancion_ = 0;
		for (DjExpedientesModel tot : lisExpedienteMagis) {
			c_tot_sancion_ += Integer.parseInt(tot.getC_tot_sancion().toString());
		}
		return c_tot_sancion_;
	}


	public void setC_tot_sancion(Integer c_tot_sancion) {
		this.c_tot_sancion = c_tot_sancion;
	}


	public List<DjSancionesModel> getLisSancionesMagis() {
		return lisSancionesMagis;
	}


	public void setLisSancionesMagis(List<DjSancionesModel> lisSancionesMagis) {
		this.lisSancionesMagis = lisSancionesMagis;
	}


	public Integer getC_tot_apercibimiento() {
		//return c_tot_apercibimiento;
		
		int c_tot_apercibimiento_ = 0;
		for (DjSancionesModel tot : lisSancionesMagis) {
			
		    c_tot_apercibimiento_ += tot.getApercibimiento() + 1;
			
		}
		
		return c_tot_apercibimiento_;
		
	}


	public void setC_tot_apercibimiento(Integer c_tot_apercibimiento) {
		this.c_tot_apercibimiento = c_tot_apercibimiento;
	}


	public Integer getC_tot_suspencion() {
		//return c_tot_suspencion_;
		
		int c_tot_suspencion_ = 0;
		for (DjSancionesModel tot : lisSancionesMagis) {
			
			c_tot_suspencion_ += tot.getSuspension() + 1;
			
		}
		
		return c_tot_suspencion_;
	}


	public void setC_tot_suspencion(Integer c_tot_suspencion) {
		this.c_tot_suspencion = c_tot_suspencion;
	}


	public Integer getC_tot_multa() {
		//return c_tot_multa_;
		
		int c_tot_multa_ = 0;
		for (DjSancionesModel tot : lisSancionesMagis) {
			
			c_tot_multa_ += tot.getMulta() + 1;
			
		}
		
		return c_tot_multa_;
	}


	public void setC_tot_multa(Integer c_tot_multa) {
		this.c_tot_multa = c_tot_multa;
	}


	public Integer getC_tot_destituciones() {
		//return c_tot_destituciones_;
		
		int c_tot_destituciones_ = 0;
		for (DjSancionesModel tot : lisSancionesMagis) {
			
			c_tot_destituciones_ += tot.getDestitucion() + 1;
			
		}
		
		return c_tot_destituciones_;
	}


	public void setC_tot_destituciones(Integer c_tot_destituciones) {
		this.c_tot_destituciones = c_tot_destituciones;
	}


	public Integer getC_tot_sanciones() {
		//return c_tot_sanciones_;
		
		int c_tot_sanciones_ = 0;
		for (DjSancionesModel tot : lisSancionesMagis) {
			
			c_tot_sanciones_ += tot.getApercibimiento() + tot.getMulta() + tot.getSuspension() + tot.getDestitucion();
			
		}
		
		return c_tot_sanciones_;
	}


	public void setC_tot_sanciones(Integer c_tot_sanciones) {
		this.c_tot_sanciones = c_tot_sanciones;
	}

	
	

}
