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
package pe.gob.ocma.seguridad.service;

import java.util.List;

import pe.gob.ocma.entities.seguridad.Settema;

/**
 * Interface para manejar los temas IU desde la base de datos.
 * @author César Altamirano Menor
 * 18/06/2013 16:10:32
 */
public interface TemaService {

	/**
	 * Devuelve una lista de temas para que el usuario personalize su interfaz.
	 * @return La lista de temas.
	 */
	public List<Settema> listarTemas();
}
