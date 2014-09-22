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
package pe.gob.ocma.seguridad.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.entities.seguridad.Settema;
import pe.gob.ocma.seguridad.service.TemaService;
import pe.gob.ocma.seguridad.service.UsuarioService;

/**
 * Clase para controlar las operaciones con respecto a los temas IU.
 * @author César Altamirano Menor
 * 18/06/2013 16:17:57
 */
@ManagedBean
@ViewScoped
public class TemaMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = -6029721311432630052L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<Settema> listaTemas = new ArrayList<Settema>();
	
	@ManagedProperty(value = "#{temaService}")
	private TemaService temaService;
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;
	
	public TemaMBean(){
	}
	
	@PostConstruct
	private void inicializar(){
		this.listaTemas = temaService.listarTemas();
	}
	
	public void cambiarTema(ActionEvent ev){
		String tema = Faces.getRequestParameter("paramTema");
		super.getSesionMBean().setTemaUsuario(tema);
	}
	
	public void guardarTema(ActionEvent ev){
		try{
			usuarioService.guardarTemaUsuario(super.getSesionMBean().getCodUsuario(), 
					super.getSesionMBean().getTemaUsuario(), super.getSesionMBean().getTerminal());
			super.addInfoMessage(super.getMessage("msgCambiosGuardadoExito"));
		} catch(Exception ex){
			String msg = super.getMessage("errorGuardarCambio");
			logger.error(msg, ex);
			super.addErrorMessage(msg);
		}
	}

	public List<Settema> getListaTemas() {
		return listaTemas;
	}

	public void setTemaService(TemaService temaService) {
		this.temaService = temaService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
