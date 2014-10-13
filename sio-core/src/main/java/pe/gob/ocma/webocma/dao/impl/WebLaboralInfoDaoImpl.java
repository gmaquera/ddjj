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
package pe.gob.ocma.webocma.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.web_ocma.WebPersonal;
import pe.gob.ocma.webocma.dao.WebWebPersonalDao;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 7/10/2014 11:53:59
 */
@Repository("webWebPersonalDao")
public class WebLaboralInfoDaoImpl extends BaseHibernateDaoImpl<WebPersonal, Integer> implements WebWebPersonalDao,Serializable{

	private static final long serialVersionUID = 1L;


}
