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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;
import pe.gob.ocma.exception.OcmaException;
import pe.gob.ocma.seguridad.service.UsuarioService;

/**
 * Clase para controlar la interfaz de cambio de contraseña de cada usuario.
 * 
 * @author César Altamirano Menor 17/07/2013 11:03:13
 */
@ManagedBean
@ViewScoped
public class CambioContraseMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 708632467381213263L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());

	private String contraseActual;
	private String contraseNueva;
	
	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	public CambioContraseMBean() {
	}

	public void guardarCambio(ActionEvent ev) {
		try {
			usuarioService.cambiarContrasenia(super.getSesionMBean().getCodUsuario(), contraseActual, contraseNueva);
			addInfoMessage(super.getMessage("msgCambiosGuardadoExito"));
		} catch(OcmaException ex){
			addErrorMessage(ex.getMessage());
		}catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			addErrorMessage(ex.getMessage());
		}
	}

	public String getContraseActual() {
		return contraseActual;
	}

	public void setContraseActual(String contraseActual) {
		this.contraseActual = contraseActual;
	}

	public String getContraseNueva() {
		return contraseNueva;
	}

	public void setContraseNueva(String contraseNueva) {
		this.contraseNueva = contraseNueva;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
