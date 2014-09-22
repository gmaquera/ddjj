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
import pe.gob.ocma.entities.seguridad.Setaplica;
import pe.gob.ocma.seguridad.dao.AplicacionDao;

/**
 * Clase para el manejo de las aplicaciones del sistema.
 * @author César Altamirano Menor
 * 03/09/2013 12:29:25
 */
@Repository("aplicacionDao")
public class AplicacionDaoImpl extends BaseHibernateDaoImpl<Setaplica, Short> implements AplicacionDao, Serializable {

	private static final long serialVersionUID = 1L;

}