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
package pe.gob.ocma.sociedadcivil.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.oc_ocma.SeguMovi;
import pe.gob.ocma.entities.oc_ocma.SeguMoviId;
import pe.gob.ocma.sociedadcivil.dao.SeguMoviMasterDao;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 28/02/2014 10:22:59
 */
@Repository("seguMoviMasterDao")
public class SeguMoviMasterDaoImpl extends BaseHibernateDaoImpl<SeguMovi, SeguMoviId> implements SeguMoviMasterDao, Serializable{
	private static final long serialVersionUID = 1L;
}
