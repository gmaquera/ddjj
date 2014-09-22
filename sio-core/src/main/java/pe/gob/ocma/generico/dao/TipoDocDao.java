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
package pe.gob.ocma.generico.dao;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.generico.Gettipdoc;

/**
 * Interface para el manejo de tipos de documentos de la base de datos.
 * @author Gino Maquera Coyla
 * 28/11/2013 09:47:45
 */
public interface TipoDocDao extends BaseHibernateDao<Gettipdoc, Short>{

}
