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
package pe.gob.ocma.common.controller;

import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import pe.gob.ocma.common.util.ResourceBundleUtil;

/**
 * Clase base para los Managed Bean.
 * @author César Altamirano Menor
 * 14/05/2013 17:16:30
 */
public abstract class BaseMBean {
	
	public BaseMBean(){
	}
	
	/**
	 * Envía un parámetro al cliente.
	 * @param nombre El nombre identificador del parámetro. 
	 * @param valor El valor asociado al nombre del parámetro.
	 */
	public final static void addCallbackParam(String nombre, Object valor) {
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.addCallbackParam(nombre, valor);
	}

	/**
	 * Devuelve el mensaje asociado a una llave.
	 * 
	 * @param key Llave para buscar el mensaje en el archivos de mensajes de internacionalización
	 * @return El mensaje para la llave ingresada.
	 */
	public final static String getMessage(String key) {
		return ResourceBundleUtil.getMessage(key);
	}

	/**
	 * Agrega mensaje de información a la lista de mensajes JSF.
	 * 
	 * @param message El mensaje detallado.
	 */
	public final static void addInfoMessage(String message) {
		addMessage(FacesMessage.SEVERITY_INFO, message);
	}

	/**
	 * Agrega mensaje de advertencia a la lista de mensajes JSF.
	 * 
	 * @param message El mensaje detallado.
	 */
	public final static void addWarnMessage(String message) {
		addMessage(FacesMessage.SEVERITY_WARN, message);
	}

	/**
	 * Agrega mensaje de error a la lista de mensajes JSF.
	 * 
	 * @param message El mensaje detallado.
	 */
	public final static void addErrorMessage(String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, message);
	}

	/**
	 * Agrega mensaje de error grabe a la lista de mensajes JSF.
	 * 
	 * @param message El mensaje detallado.
	 */
	public final static void addFatalMessage(String message) {
		addMessage(FacesMessage.SEVERITY_FATAL, message);
	}

	/**
	 * Agrega un mensaje a la lista de mensajes de JSF, considerando el grado de severidad.
	 * 
	 * @param severity La sereridad del mensaje(Informacion, Advertencia, Error, Error grabe).
	 * @param title El título para el mensaje.
	 * @param message El mensaje detallado.
	 */
	private final static void addMessage(FacesMessage.Severity severity, String message) {
		FacesMessage facesMessage = new FacesMessage(severity, null, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	/**
	 * Devuelve un Managed Bean JSF, si no existe lo crea y si existe lo recupera con todos sus valores.
	 * 
	 * @param bean El nombre del Managed Bean que se desea buscar
	 * @return Un Objeto que puede ser transformado al Managed Bean buscado
	 */
	public final static Object getBean(String bean) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		ValueExpression ve = app.getExpressionFactory().createValueExpression(fc.getELContext(), String.format("#{%s}", bean), Object.class);
		return ve.getValue(fc.getELContext());
	}

	/**
	 * Devuelve el Managed Bean de sesión que contiene los datos y parametros de sesión del sistema.
	 * 
	 * @return El Managed Bean de session.
	 */
	public final static SesionMBean getSesionMBean() {
		return (SesionMBean) getBean("sesionMBean");
	}
	
	/**
	 * Devuelve el Managed Bean de Aplicación que contiene los datos y parametros de aplicación del sistema.
	 * 
	 * @return El Manaded Bean de Aplicación.
	 */
	public final static AplicacionMBean getAplicacionMBean(){
		return (AplicacionMBean) getBean("aplicacionMBean");
	}
}
