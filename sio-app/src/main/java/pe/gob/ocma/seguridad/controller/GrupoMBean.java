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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.common.enums.Accion;
import pe.gob.ocma.entities.seguridad.Setaplica;
import pe.gob.ocma.entities.seguridad.Setgrupo;
import pe.gob.ocma.exception.SecuenciaMaeException;
import pe.gob.ocma.seguridad.service.AplicacionService;
import pe.gob.ocma.seguridad.service.GrupoService;

/**
 * Clase de control para menejar los grupos de usuarios.
 * @author César Altamirano Menor
 * 13/06/2013 15:55:44
 */
@ManagedBean
@ViewScoped
public class GrupoMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 5308266564079003222L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private Accion accion;
	private List<Setgrupo> lisGrupos = new ArrayList<Setgrupo>();
	private Setgrupo grupo;
	
	private List<Setaplica> lisAplicaciones = new ArrayList<Setaplica>();
	private short selectedAplicacion;
	
	@ManagedProperty(value = "#{grupoService}")
	private GrupoService grupoService;
	@ManagedProperty(value = "#{aplicacionService}")
	private AplicacionService aplicacionService;

	public GrupoMBean(){
	}
	
	@PostConstruct
	private void inicializar(){
		this.lisAplicaciones = aplicacionService.listarAplicaciones();
		this.lisGrupos = grupoService.listarGrupos();
	}
	
	public void nuevoGrupo(ActionEvent ev){
		grupo = new Setgrupo();
		grupo.setHabilitado(true);
		accion = Accion.NUEVO;
	}
	
	public void editarGrupo(){
		this.selectedAplicacion = grupo.getCodAplica();
		accion = Accion.EDITAR;
	}
	
	/**
	 * Guarda o actualiza un grupo de usuarios.
	 */
	public void guardar(){
		if(accion == Accion.NUEVO){
			try{
				grupo.setCodAplica(selectedAplicacion);
				grupo.setCodAutoriza(super.getSesionMBean().getCodUsuario());
				grupo = grupoService.guardarGrupo(grupo);
				addInfoMessage(super.getMessage("msgDatosGuardadosExito"));
				addCallbackParam("correcto", true);
			}catch(SecuenciaMaeException ex){
				addErrorMessage(ex.getMessage());
			}catch(Exception ex){
				String msg = super.getMessage("errorGuardandoDatos");
				logger.error(msg, ex);
				addErrorMessage(msg);
			}
		} else if (accion == Accion.EDITAR) {
			try{
				grupo.setCodAplica(selectedAplicacion);
				grupoService.actualizarGrupo(grupo);
				addInfoMessage(super.getMessage("msgCambiosGuardadosExito"));
				addCallbackParam("correcto", true);
			} catch (Exception ex){
				String msg = super.getMessage("errorGuardandoDatos");
				logger.error(msg, ex);
				addErrorMessage(msg);
			}
		} else {
			logger.error("Acción incorrecta, solo es aceptado nuevo y actualizar");
		}
		this.inicializar();
	}
	
	public void eliminar(ActionEvent ev) {
		try{
			grupoService.eliminarGrupo(grupo);
			lisGrupos.remove(grupo);
			addInfoMessage(super.getMessage("msgRegistroEliminadoExito"));
		} catch (Exception ex){
			addErrorMessage(super.getMessage("errorEliminar"));
		}
	}
	
	public void irAPermisos(ActionEvent ev) {
		UIComponent ui = ev.getComponent().getParent().getParent();
		try{
			UIData data = (UIData) ui;
			if(data != null){
				this.grupo = (Setgrupo) data.getRowData();
				Faces.getFlash().put("codGrupoUsuarios", grupo.getCodGrupo());
				StringBuilder outcome = new StringBuilder();
				outcome.append(Faces.getRequestContextPath());
				outcome.append("/sistema/seguridad/permisos.xhtml");
				Faces.redirect(outcome.toString(), "");
			}
		}catch(IOException ex){
			logger.error(ex.getMessage(), ex);
		}
	}

	public Accion getAccion() {
		return accion;
	}

	public List<Setgrupo> getLisGrupos() {
		return lisGrupos;
	}

	public Setgrupo getGrupo() {
		if(grupo == null){
			grupo = new Setgrupo();
		}
		return grupo;
	}

	public void setGrupo(Setgrupo grupo) {
		this.grupo = grupo;
	}

	public List<Setaplica> getLisAplicaciones() {
		return lisAplicaciones;
	}

	public short getSelectedAplicacion() {
		return selectedAplicacion;
	}

	public void setSelectedAplicacion(short selectedAplicacion) {
		this.selectedAplicacion = selectedAplicacion;
	}

	public void setGrupoService(GrupoService grupoService) {
		this.grupoService = grupoService;
	}

	public void setAplicacionService(AplicacionService aplicacionService) {
		this.aplicacionService = aplicacionService;
	}
}
