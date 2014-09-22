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

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.seguridad.Setnivseguri;

/**
 * Interface para manejar los niveles de seguridad de un usuario desde base de datos.
 * @author César Altamirano Menor
 * 30/09/2013 10:55:58
 */
public interface NivelSeguridadDao extends BaseHibernateDao<Setnivseguri, Short> {

}
