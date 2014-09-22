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
package pe.gob.ocma.common.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.util.ConstanteWeb;
import pe.gob.ocma.entities.persona.Petpernatu;


import pe.gob.ocma.entities.web_ocma.Usuario;
import pe.gob.ocma.intranet.service.UsuarioService;
import pe.gob.ocma.seguridad.util.Encriptador;

/**
 * Clase para manejar las variables de sesión de un usuario.
 * @author César Altamirano Menor
 * 04/06/2013 11:45:50
 */
@ManagedBean
@SessionScoped
public class SesionMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 4445322220834400352L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
		
	private String codUsuario;
	private String apeNomUsuario;
	private String tipoUsuario;
	private String terminal;
	private String temaUsuario;	
	
	@ManagedProperty(value="#{usuarioWebService}")
	private UsuarioService usuarioService;	
	
	public SesionMBean(){
	}
	
	public void iniciarParametrosUsuario(){
		if(codUsuario == null || codUsuario.isEmpty()) {
			super.addFatalMessage(super.getMessage("errorObtenUsuarioLogeado"));
			return;
		}
		try{
			Usuario usuario = usuarioService.buscarUsuario(codUsuario);
			if(usuario == null){
				super.addFatalMessage(super.getMessage("errorObtenUsuarioLogeado"));
				return;
			} else {				
				this.apeNomUsuario = usuario.getDesUsuario();				
				
			}
		} catch(Exception ex){
			super.addErrorMessage(getMessage("errorCargandoParamUsuario"));
			logger.error("Ha fallado la carga de parámetros del usuario", ex);
		}
	}
	
	
	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getApeNomUsuario() {
		return apeNomUsuario;
	}

	public void setApeNomUsuario(String apeNomUsuario) {
		this.apeNomUsuario = apeNomUsuario;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTemaUsuario() {
		if(temaUsuario == null){
			temaUsuario = ConstanteWeb.TEMA_INTERFAZ;
		}
		return temaUsuario;
	}
	public void setTemaUsuario(String temaUsuario) {
		this.temaUsuario = temaUsuario;
	}	

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	
}
