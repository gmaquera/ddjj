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
package pe.gob.ocma.generico.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.generico.Getcorrelmae;
import pe.gob.ocma.generico.dao.CorrelMaeDao;

/**
 * Clase para el manejo de correlativos de las tablas maestras desde la base de datos.
 * @author César Altamirano Menor
 * 14/06/2013 16:22:49
 */
@Repository("correlMaeDao")
public class CorrelMaeDaoImpl extends BaseHibernateDaoImpl<Getcorrelmae, Short> implements CorrelMaeDao, Serializable {

	private static final long serialVersionUID = -3327314445614037191L;
}
