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
package pe.gob.ocma.temporal;

import java.io.File;

/**
 * Clase para guardar variables temporales.
 * @author César Altamirano Menor
 * 09/05/2013 13:04:25
 */
public final class ConstanteTemporal {

	// 172.22.0.50/contenido/resolucion
	public final static String RUTA_RESOLUCIONES = (new StringBuilder()).append("E:").append(File.separator).append("resoluciones").toString();
}
