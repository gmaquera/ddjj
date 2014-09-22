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
package pe.gob.ocma.generico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.common.enums.Accion;
import pe.gob.ocma.entities.generico.Getcorrelmae;
import pe.gob.ocma.exception.SecuenciaMaeException;
import pe.gob.ocma.generico.service.CorrelMaeService;

/**
 * Clase de control para manejar los correlativos de las tablas maestras.
 * @author César Altamirano Menor
 * 14/06/2013 16:29:17
 */
@ManagedBean
@ViewScoped
public class CorrelMaeMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = -8536015938390227309L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Accion accion;
	private List<Getcorrelmae> listaCorrelMae = new ArrayList<Getcorrelmae>();
	private Getcorrelmae correlMae;
	private Getcorrelmae correlMaeAux;
	
	@ManagedProperty(value = "#{correlMaeService}")
	private CorrelMaeService correlMaeService;
	
	public CorrelMaeMBean(){
	}
	
	@PostConstruct
	private void inicializar(){
		listaCorrelMae = correlMaeService.listarCorrelativosMaestras();
	}
	
	public void nuevo(ActionEvent ev){
		this.correlMae = new Getcorrelmae();
		accion = Accion.NUEVO;
	}
	
	public void editar(ActionEvent ev){
		accion = Accion.EDITAR;
		correlMaeAux = correlMae;
	}
	
	public void guardar(ActionEvent ev){
		if(accion == Accion.NUEVO){
			try{
				correlMae = correlMaeService.guardarCorrelativoMaestra(correlMae);
				this.inicializar();
				//listaCorrelMae.add(correlMae);
				addInfoMessage(super.getMessage("msgDatosGuardadosExito"));
			}catch(SecuenciaMaeException ex){
				addErrorMessage(ex.getMessage());
			}catch(Exception ex){
				String msg = super.getMessage("errorGuardandoDatos");
				logger.error(msg, ex);
				addErrorMessage(msg);
			}
		} else {
			try{
				correlMaeService.actualizarCorrelativoMeastra(correlMae);
				addInfoMessage(super.getMessage("msgDatosGuardadosExito"));
			}catch(Exception ex){
				correlMae = correlMaeAux;
				addErrorMessage(super.getMessage("errorGuardandoDatos"));
				logger.error("Error actualizando correlativo de maestras", ex);
			}
		}
	}
	
	public void eliminar(ActionEvent ev){
		try{
			correlMaeService.eliminarCorrelativoMaestra(correlMae);
			listaCorrelMae.remove(correlMae);
			addInfoMessage(super.getMessage("msgRegistroEliminadoExito"));
		} catch (Exception ex){
			addErrorMessage(super.getMessage("errorEliminar"));
		}
	}

	public Accion getAccion() {
		return accion;
	}
	
	public List<Getcorrelmae> getListaCorrelMae() {
		return listaCorrelMae;
	}

	public Getcorrelmae getCorrelMae() {
		if(correlMae == null){
			correlMae = new Getcorrelmae();
		}
		return correlMae;
	}

	public void setCorrelMae(Getcorrelmae correlMae) {
		this.correlMae = correlMae;
	}

	public void setCorrelMaeService(CorrelMaeService correlMaeService) {
		this.correlMaeService = correlMaeService;
	}
}