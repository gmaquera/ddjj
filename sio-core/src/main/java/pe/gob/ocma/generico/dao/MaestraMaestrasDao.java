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
package pe.gob.ocma.generico.dao;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.generico.Gettabmae;

/**
 * Interface para el manejo maestras de 2 o 3 registros dentro de una tabla maestra genérica.
 * @author César Altamirano Menor
 * 09/09/2013 12:19:28
 */
public interface MaestraMaestrasDao extends BaseHibernateDao<Gettabmae, Short> {

	/**
	 * Devuelve el registro segun el nombre de tabla y el código de columna.
	 * @param nomTabla El nombre de tabla.
	 * @param codColumna El código de columna.
	 * @return El registro encontrado.
	 */
	public abstract Gettabmae buscar(String nomTabla, String codColumna);
}
