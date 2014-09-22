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
 * Ing. Orlando Peña Mora - Jefe de Sistemas
 *
 */
package pe.gob.ocma.common.listener;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.web.WebAttributes;

import pe.gob.ocma.common.util.ResourceBundleUtil;
import pe.gob.ocma.seguridad.controller.CaptchaMBean;

/**
 * Clase escuchadora que permite identificar si el usuario ha hecho log in e
 * informar con un mensaje al usuario.
 * @author César Altamirano Menor
 * 15/05/2013 08:59:58
 */
public class LoginErrorPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 2915772174512112272L;

	@Override
	public void afterPhase(PhaseEvent phase) {
	}

	@Override
	public void beforePhase(PhaseEvent phase) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Exception datosIncorrectos = (Exception) ctx.getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
		FacesMessage facesMessage;
		
		Application app = ctx.getApplication();
		ValueExpression ve = app.getExpressionFactory().createValueExpression(ctx.getELContext(), String.format("#{%s}", "captchaMBean"), Object.class);
		CaptchaMBean cBean = (CaptchaMBean) ve.getValue(ctx.getELContext());
		cBean.setContador((short)(cBean.getContador()+1));
		cBean.setTypeException(datosIncorrectos);
		
		if(!cBean.isPaginaLogin()) {
			return;
		}
		
		Exception typeException = cBean.getTypeException();
		if(typeException != null) {
			if(typeException.getMessage().equals("CAPTCHA_INVALID")) {
				ctx.getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
				facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, ResourceBundleUtil.getMessage("errorCaracteresCaptcha"));
				ctx.addMessage(null, facesMessage);
				return;
			}
			if (typeException instanceof BadCredentialsException || typeException instanceof AuthenticationServiceException) {
				ctx.getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
				facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, ResourceBundleUtil.getMessage("errorCredencialesUsuario"));
				ctx.addMessage(null, facesMessage);
			} else if (typeException instanceof DisabledException) {
				ctx.getExternalContext().getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
				facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, ResourceBundleUtil.getMessage("errorUsuarioNoHabilitado"));
				ctx.addMessage(null, facesMessage);
			}
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}
}
