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
import pe.gob.ocma.entities.oc_ocma.ExpeQuej;
import pe.gob.ocma.entities.oc_ocma.ExpeQuejId;
import pe.gob.ocma.sociedadcivil.dao.QuejSocMasterDao;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas
 * 19/03/2014 17:39:46
 */
@Repository("quejSocMasterDao")
public class QuejSocMasterDaoImpl extends BaseHibernateDaoImpl<ExpeQuej, ExpeQuejId> implements QuejSocMasterDao, Serializable{
	private static final long serialVersionUID = 1L;
}
