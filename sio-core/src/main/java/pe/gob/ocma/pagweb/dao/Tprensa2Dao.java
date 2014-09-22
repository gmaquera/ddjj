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
package pe.gob.ocma.pagweb.dao;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.web.TPrensa2;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 28/11/2013 10:46:38
 */
public interface Tprensa2Dao extends BaseHibernateDao<TPrensa2,Integer> {

	public abstract void updateUrlres(int id, String desurl);
	public abstract void updateUrlfot(int id, String desurl);

}