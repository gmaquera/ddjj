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
package pe.gob.ocma.sociedadcivil.dao;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.oc_ocma.ExpeMast;
import pe.gob.ocma.entities.oc_ocma.ExpeMastId;


/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 24/02/2014 16:28:12
 */
public interface ExpeMastDao extends BaseHibernateDao <ExpeMast, ExpeMastId>{
	
	public abstract ExpeMast buscarExpeMast(ExpeMastId numExpedi);

}
