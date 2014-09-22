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
 * Clase que maneja las excepciones por limite de secuencia de tablas maestras o secuencias de documentos.
 * @author César Altamirano Menor
 * 17/06/2013 10:25:59
 */
public class SecuenciaMaeException extends OcmaException {

	private static final long serialVersionUID = 4176618667203291673L;

	/**
	 * @param message El mensaje del error.
	 */
	public SecuenciaMaeException(String message) {
		super(message);
	}
}
