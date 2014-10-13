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

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoGeneralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.service.DjInfoGeneralService;
import pe.gob.ocma.entities.web_ocma.Afp;
import pe.gob.ocma.entities.web_ocma.TablaRegimenPension;
import pe.gob.ocma.webocma.service.WebInfoLaboralService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 7/10/2014 12:09:44
 */

@ManagedBean
@ViewScoped
public class DjInfoLaboralMBean extends BaseMBean implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<SelectItem>  listipoAFP = new ArrayList<SelectItem>();
	private List<SelectItem>  listipoRegimenPension = new ArrayList<SelectItem>();
	private List<DjInfoLaboralModel> lisInfoLaboral = new ArrayList<DjInfoLaboralModel>();
	private List<DjInfoGeneralModel> lisInfoGeneral = new ArrayList<DjInfoGeneralModel>();
	
	private Integer codAfp;
	private Integer codRegpension;
	private String fec_ingreso;
	private Date fec_ingres_new;
	
	
	@ManagedProperty(value = "#{webInfoLaboralService}")
	private WebInfoLaboralService webInfoLaboralService;
	
	@ManagedProperty(value = "#{djInfoGeneralService}")
	private DjInfoGeneralService djInfoGeneralService;
	
	
	public DjInfoLaboralMBean() {
	}
	

	@PostConstruct
	private void inicializar() {
		
		lisInfoLaboral = djInfoGeneralService.lisInfoLaboral("69666");
		lisInfoGeneral =djInfoGeneralService.lisInfoGeneral("69666");
		fec_ingreso =  lisInfoGeneral.get(0).getFec_ingreso();
		System.out.println(fec_ingreso);
		

		fec_ingres_new = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			fec_ingres_new = dateFormat.parse(fec_ingreso);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		//  COMBO PARA  AFP
		for(Afp a : webInfoLaboralService.listaTipoAFP()){
			listipoAFP.add(new SelectItem(a.getCodAfp(),a.getDesAfp()));
			
		}
		System.out.println(listipoAFP.size());
		//COMBO PARA REGIMEN DE PENSION
		for(TablaRegimenPension r : webInfoLaboralService.listaTipoRegimenPension()){
			listipoRegimenPension.add(new SelectItem(r.getCodRegpension(),r.getDesRegpension()));
		}
		
		
	}

	

	public Date getFec_ingres_new() {
		return fec_ingres_new;
	}


	public void setFec_ingres_new(Date fec_ingres_new) {
		this.fec_ingres_new = fec_ingres_new;
	}


	public List<DjInfoGeneralModel> getLisInfoGeneral() {
		return lisInfoGeneral;
	}


	public void setLisInfoGeneral(List<DjInfoGeneralModel> lisInfoGeneral) {
		this.lisInfoGeneral = lisInfoGeneral;
	}


	public List<DjInfoLaboralModel> getLisInfoLaboral() {
		return lisInfoLaboral;
	}


	public void setLisInfoLaboral(List<DjInfoLaboralModel> lisInfoLaboral) {
		this.lisInfoLaboral = lisInfoLaboral;
	}

	public String getFec_ingreso() {
		return fec_ingreso;
	}


	public void setFec_ingreso(String fec_ingreso) {
		this.fec_ingreso = fec_ingreso;
	}


	public DjInfoGeneralService getDjInfoGeneralService() {
		return djInfoGeneralService;
	}


	public void setDjInfoGeneralService(DjInfoGeneralService djInfoGeneralService) {
		this.djInfoGeneralService = djInfoGeneralService;
	}


	public List<SelectItem> getListipoAFP() {
		return listipoAFP;
	}


	public void setListipoAFP(List<SelectItem> listipoAFP) {
		this.listipoAFP = listipoAFP;
	}


	public List<SelectItem> getListipoRegimenPension() {
		return listipoRegimenPension;
	}


	public void setListipoRegimenPension(List<SelectItem> listipoRegimenPension) {
		this.listipoRegimenPension = listipoRegimenPension;
	}


	public WebInfoLaboralService getWebInfoLaboralService() {
		return webInfoLaboralService;
	}


	public void setWebInfoLaboralService(WebInfoLaboralService webInfoLaboralService) {
		this.webInfoLaboralService = webInfoLaboralService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getCodAfp() {
		return codAfp;
	}


	public void setCodAfp(Integer codAfp) {
		this.codAfp = codAfp;
	}


	public Integer getCodRegpension() {
		return codRegpension;
	}


	public void setCodRegpension(Integer codRegpension) {
		this.codRegpension = codRegpension;
	}
	
	
	
	

}
