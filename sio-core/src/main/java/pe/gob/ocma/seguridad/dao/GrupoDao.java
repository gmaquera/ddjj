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
import pe.gob.ocma.entities.seguridad.Setgrupo;

/**
 * Interfaces para la gestión de grupos o roles de usuario.
 * @author César Altamirano Menor
 * 05/06/2013 13:14:10
 */
public interface GrupoDao extends BaseHibernateDao<Setgrupo, Integer> {
}
