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
import pe.gob.ocma.entities.generico.Getcorreldoc;
import pe.gob.ocma.entities.generico.GetcorreldocId;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 11/11/2013 11:00:30
 */
public interface CorrelDocDao extends BaseHibernateDao<Getcorreldoc, GetcorreldocId> {
	public abstract int searchNextCorrelQuejas(short codTip,int anio);
}
