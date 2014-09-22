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
package pe.gob.ocma.seguridad.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.seguridad.Setgrupo;
import pe.gob.ocma.seguridad.dao.GrupoDao;

/**
 * Clase que permite manejar los grupos o roles de un usuario desde la base de datos.
 * @author César Altamirano Menor
 * 05/06/2013 13:24:38
 */
@Repository("grupoDao")
public class GrupoDaoImpl extends BaseHibernateDaoImpl<Setgrupo, Integer> implements GrupoDao, Serializable {

	private static final long serialVersionUID = 3356234287391776712L;

}
