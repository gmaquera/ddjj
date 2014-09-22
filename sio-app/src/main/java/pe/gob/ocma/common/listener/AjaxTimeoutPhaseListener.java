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
package pe.gob.ocma.common.listener;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.faces.context.ResponseWriter;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.gob.ocma.common.util.ConstanteWeb;

/**
 * Clase escuchadora que permite identificar el momento que caduca la sesión y
 * hace la redirección al nuevo login.
 * @author César Altamirano Menor
 * 16/07/2013 10:14:02
 */
public class AjaxTimeoutPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 2639152532235352192L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void afterPhase(PhaseEvent ev){
	}
	
	@Override
	public void beforePhase(PhaseEvent ev){
		FacesContext fc = Faces.getContext();
		RequestContext rc = RequestContext.getCurrentInstance();
		HttpServletResponse response = Faces.getResponse();
		HttpServletRequest request = Faces.getRequest();
				
		if (Faces.getExternalContext().getUserPrincipal() == null) {
			if (Faces.getExternalContext().isResponseCommitted()) {
				// redirect is not possible
				return;
			}
			try{
				if(((rc != null &&  rc.isAjaxRequest()) || (fc != null && fc.getPartialViewContext().isPartialRequest())) 
						&& fc.getResponseWriter() == null && fc.getRenderKit() == null) {
					
					response.setCharacterEncoding(request.getCharacterEncoding());
					RenderKitFactory factory = (RenderKitFactory) FactoryFinder.getFactory(FactoryFinder.RENDER_KIT_FACTORY);
					RenderKit renderKit = factory.getRenderKit(fc,fc.getApplication().getViewHandler().calculateRenderKitId(fc));
					ResponseWriter responseWriter = renderKit.createResponseWriter(response.getWriter(), null, request.getCharacterEncoding());
					responseWriter = new PartialResponseWriter(responseWriter);
					fc.setResponseWriter(responseWriter);
					
					StringBuilder outcome = new StringBuilder();
					outcome.append(Faces.getRequestContextPath());
					outcome.append(ConstanteWeb.TIMEOUT_URL);
					Faces.redirect(outcome.toString(), "");
				}
			} catch (IOException ex) {
				StringBuilder error = new StringBuilder("Redirect to the specified page '");
				error.append(ConstanteWeb.TIMEOUT_URL);
				error.append("' failed");
				logger.error(error.toString(), ex);
				throw new FacesException(ex);
			}
		} else {
			return ; //This is not a timeout case . Do nothing !
		}
	}
	
	public PhaseId getPhaseId(){
		return PhaseId.RESTORE_VIEW;
	}
}
