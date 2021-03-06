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
package pe.gob.ocma.organosjur.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.organosjurisd.Ojtespeciali;
import pe.gob.ocma.organosjur.dao.EspecialidadDao;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 08/11/2013 09:20:48
 */
@Repository("especialidadDao")
public class EspecialidadDaoImpl extends BaseHibernateDaoImpl<Ojtespeciali, Short> implements EspecialidadDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}
