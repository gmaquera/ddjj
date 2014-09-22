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
package pe.gob.ocma.ubigeo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.entities.ubigeojud.Ujtdisjud;
import pe.gob.ocma.entities.ubigeojud.Ujtprojud;
import pe.gob.ocma.ubigeo.service.DistritoJudService;
import pe.gob.ocma.ubigeo.service.ProvinciaJudService;

/**
 * DECRIBIR TODO

 * 07/11/2013 11:28:04
 */


@ManagedBean
@ViewScoped
public class DistritoJudMBean extends BaseMBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private List<Ujtdisjud> lisDistritosJud = new ArrayList<Ujtdisjud>();
	private List<Ujtprojud> lisProvinciasJud = new ArrayList<Ujtprojud>();
	
	
	@ManagedProperty(value = "#{distritoJudService}")
	private DistritoJudService distritoJudService;
	
	@ManagedProperty(value = "#{provinciaJudService}")
	private ProvinciaJudService provinciaJudService;
	
	public DistritoJudMBean() {	
	}
	
	@PostConstruct
	private void inicializar() {
		this.lisDistritosJud = distritoJudService.listarDistritoJud();		
		this.lisProvinciasJud = provinciaJudService.listarProvinciaJud();		
	}	
	
	
	

	public List<Ujtdisjud> getLisDistritosJud() {
		return lisDistritosJud;
	}

	public void setLisDistritosJud(List<Ujtdisjud> lisDistritosJud) {
		this.lisDistritosJud = lisDistritosJud;
	}

	public DistritoJudService getDistritoJudService() {
		return distritoJudService;
	}

	public void setDistritoJudService(DistritoJudService distritoJudService) {
		this.distritoJudService = distritoJudService;
	}

	public ProvinciaJudService getProvinciaJudService() {
		return provinciaJudService;
	}

	public void setProvinciaJudService(ProvinciaJudService provinciaJudService) {
		this.provinciaJudService = provinciaJudService;
	}

	public List<Ujtprojud> getLisProvinciasJud() {
		return lisProvinciasJud;
	}

	public void setLisProvinciasJud(List<Ujtprojud> lisProvinciasJud) {
		this.lisProvinciasJud = lisProvinciasJud;
	}	
	

}
