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
package pe.gob.ocma.generico.service;

import pe.gob.ocma.entities.generico.Getcorreldoc;

/**
 * Interface para el manejo de correlativos de las documentos desde la base de datos.
 * @author Gino Maquera Coyla
 * 11/11/2013 11:08:48
 */
public interface CorrelDocService {
	
	public abstract int searchNextCorrelQuejas(short codTip,int anio);
	
	public abstract void guardar(Getcorreldoc correlDoc);
}
