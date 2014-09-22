/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.common.util;

/**
 * Clase que tiene las constantes para la capa de servicio.
 * @author César Altamirano Menor
 * 22/11/2013 13:13:19
 */
public final class ConstanteCore {

	public final static short COD_DIS_JUDICIAL_OCMA = 23;
	
	public final static String ENCODING_SISTEMA = "UTF-8";

	public final static char ESTADO_ACTIVO = '1';
	public final static char ESTADO_INACTIVO = '0';
	public final static boolean HABILITADO_TRUE= true;
	public final static boolean HABILITADO_FALSE = false;
	
	public final static String REMPLASA_NULL = "--";
	public final static String EMPTY = "";
	
	public final static String ACCION_LOGIN="Login";
	public final static String ACCION_CREACION="Creación";
	public final static String ACCION_ACTUALIZACION="Actualización";
	public final static String ACCION_ELIMINACION="Eliminación";
	public final static String ACCION_CONSULTA="Consulta";
}
