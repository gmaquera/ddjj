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
package pe.gob.ocma.seguridad.dao;

import java.util.List;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.seguridad.Setopcion;
import pe.gob.ocma.seguridad.dto.MenuModel;

/**
 * Interface para manejar las opciones del menú desde base de datos.
 * @author César Altamirano Menor
 * 04/09/2013 11:27:55
 */
public interface OpcionDao extends BaseHibernateDao<Setopcion, Integer> {

	/**
	 * Devuelve la opción padre correspondiente a una aplicación.
	 * @param codAplica El código de la aplicación.
	 * @return El Nodo u opción padre.
	 */
	public abstract MenuModel buscarPadreAplicacion(short codAplica);
	
	/**
	 * Devuelve la lista de opciones de una aplicación, sin considerar la opción padre de todo.
	 * @param codAplica El código de la aplicación.
	 * @return La lista de opciones.
	 */
	public abstract List<MenuModel> buscarOpcionesAplicacion(short codAplica);
}
