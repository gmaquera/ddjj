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
package pe.gob.ocma.sociedadcivil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.entities.oc_ocma.Socprioridad;
import pe.gob.ocma.sociedadcivil.dao.PrioridadSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.PrioridadSocMasterService;



/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 17/02/2014 17:45:04
 */

@Transactional(readOnly=true)
@Service("prioridadSocMasterService")
public class PrioridadSocMasterServiceImpl  implements PrioridadSocMasterService  {
	
	@Autowired
	private PrioridadSocMasterDao prioridadSocMasterDao;

	@Override
	public List<Socprioridad> listarPrioridadesSoc() {
		return prioridadSocMasterDao.searchOrder(new SortCriteria("cod_prioridad"));
	}

}
