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
import pe.gob.ocma.entities.oc_ocma.Socmast;
import pe.gob.ocma.sociedadcivil.dao.SocMasterDao;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 13/02/2014 16:14:34
 */
@Repository("socMasterDao")
public class SocMasterDaoImpl  extends BaseHibernateDaoImpl<Socmast, Integer> implements SocMasterDao, Serializable{

	private static final long serialVersionUID = 1L;	

}
