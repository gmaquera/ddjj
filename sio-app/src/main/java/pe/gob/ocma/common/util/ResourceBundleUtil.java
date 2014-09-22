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
package pe.gob.ocma.common.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

/**
 * Clase para manejar los mensajes dependiendo del idioma.
 * @author César Altamirano Menor
 * 14/05/2013 17:17:28
 */
public final class ResourceBundleUtil {

	public static final String MESSAGE_PATH = "messages";
	private static HashMap<String, Object> messageBundles = new HashMap<String, Object>();

	private ResourceBundleUtil(){
	}
	
	/**
	 * Obtiene un mensaje, según la llave que se le brinda, desde un archivo de mensajes
	 * 
	 * @param key La llave para buscar el mensaje
	 * @return Cadena correspondiente a la llave dada. Si la llave no se encuentra el mensaje devuelto es la misma llave.
	 */
	public static String getMessage(String key) {
		if (key == null) {
			return null;
		}
		try {
			Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
			if (locale == null) {
				locale = Locale.ENGLISH;
			}
			ResourceBundle messages = (ResourceBundle) messageBundles.get(locale.toString());
			if (messages == null) {
				messages = ResourceBundle.getBundle(MESSAGE_PATH, locale);
				messageBundles.put(locale.toString(), messages);
			}
			return messages.getString(key);
		} catch (Exception e) {
			return key;
		}
	}
}
