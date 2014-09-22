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
package pe.gob.ocma.exception;

/**
 * Clase que registra las excepciones controladas en el proyecto OCMA.
 * @author César Altamirano Menor
 * 17/06/2013 10:14:41
 */
public class OcmaException extends RuntimeException {

	private static final long serialVersionUID = -3333864101153597603L;

	/**
	 * @param message El mensaje de error.
	 * @param cause La causa del error.
	 */
	public OcmaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message El mensaje de error.
	 */
	public OcmaException(String message) {
		super(message);
	}

	
}
