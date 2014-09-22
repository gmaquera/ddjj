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
package pe.gob.ocma.organosjur.dao.impl;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.organosjurisd.Ojtsubespe;
import pe.gob.ocma.organosjur.dao.DepenDao;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 28/02/2014 10:42:40
 */

@Repository("depenDao")
public class DepenDaoImpl extends BaseHibernateDaoImpl<Ojtsubespe, Short> implements DepenDao  {

	private static final long serialVersionUID = 1L;

}
