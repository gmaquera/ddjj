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
package pe.gob.ocma.pagweb.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.web.TPrensaTipo;
import pe.gob.ocma.pagweb.dao.TPrensaTipoDao;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 26/11/2013 10:58:20
 */


@Repository("tPrensaTipoDao")
public class TPrensaTipoDaoImpl extends BaseHibernateDaoImpl<TPrensaTipo, Integer> implements TPrensaTipoDao,Serializable {

	private static final long serialVersionUID =1L;
}