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
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase controladora que maneja las variables de aplicación del sistema.
 * @author César Altamirano Menor
 * 04/06/2013 11:46:05
 */
@ManagedBean
@ApplicationScoped
public class AplicacionMBean extends BaseMBean implements Serializable {

	private static final long serialVersionUID = 8756860834791082852L;
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	private String formatoFecha,formatoFecha2;
	private String formatoTiempo;
	private String formatoFechaTiempo;
	private Locale locale;

	public AplicacionMBean(){
		formatoFecha = "dd/MM/yyyy";
		formatoFecha2 = "yyyy/MM/dd";
		formatoTiempo = "HH:mm:ss";
		formatoFechaTiempo = "dd/MM/yyyy HH:mm:ss";
		locale = Locale.getDefault();
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public String getFormatoTiempo() {
		return formatoTiempo;
	}

	public String getFormatoFechaTiempo() {
		return formatoFechaTiempo;
	}

	public Locale getLocale() {
		return locale;
	}

	public String getFormatoFecha2() {
		return formatoFecha2;
	}

	public void setFormatoFecha2(String formatoFecha2) {
		this.formatoFecha2 = formatoFecha2;
	}
	
}