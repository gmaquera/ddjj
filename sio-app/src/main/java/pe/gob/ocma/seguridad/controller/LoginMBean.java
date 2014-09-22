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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import org.omnifaces.util.Faces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.controller.BaseMBean;

/**
 * Clase que permite manejar el logeo de usuarios.
 * 
 * @author César Altamirano Menor 04/06/2013 11:55:25
 */
@ManagedBean
@ViewScoped
public class LoginMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());


	public LoginMBean(){
	}
	
	private CaptchaMBean getCaptchaMBean() {
		return (CaptchaMBean) super.getBean("captchaMBean");
	}
	
	public String hacerLogin(){
		try {
			RequestDispatcher dispatcher = Faces.getRequest().getRequestDispatcher("/j_spring_security_check");
			dispatcher.forward(Faces.getRequest(), Faces.getResponse());
			if(Faces.getExternalContext().getUserPrincipal() != null){
				String nomUsuario = Faces.getExternalContext().getUserPrincipal().getName();
				super.getSesionMBean().setCodUsuario(nomUsuario);
				super.getSesionMBean().iniciarParametrosUsuario();
				this.getCaptchaMBean().setPaginaLogin(false);
			}
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			super.addErrorMessage(super.getMessage("errorLogin"));
		}
		return null;
	}
}
