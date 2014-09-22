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
package pe.gob.ocma.generico.dao.impl;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.generico.Gettipdoc;
import pe.gob.ocma.generico.dao.TipoDocDao;

/**
 * Clase para el manejo de los tipos de documentos desde la base de datos.
 * @author Gino Maquera Coyla
 * 28/11/2013 09:52:36
 */

@Repository("tipoDocDao")
public class TipoDocDaoImpl extends BaseHibernateDaoImpl<Gettipdoc, Short> implements TipoDocDao {

	private static final long serialVersionUID = 1L;

}
