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
import pe.gob.ocma.entities.generico.Gettabla;
import pe.gob.ocma.generico.dao.TablaDao;

/**
 * Clase para menejar el acceso a datos a la tabla Tabla
 * @author César Altamirano Menor
 * 26/09/2013 13:15:28
 */
@Repository("tablaDao")
public class TablaDaoImpl extends BaseHibernateDaoImpl<Gettabla, Short> implements TablaDao, Serializable {

	private static final long serialVersionUID = 1L;
}
