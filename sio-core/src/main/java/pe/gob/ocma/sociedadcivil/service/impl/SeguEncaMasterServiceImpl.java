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
import pe.gob.ocma.entities.oc_ocma.SeguEnca;
import pe.gob.ocma.sociedadcivil.dao.SeguEncaMasterDao;
import pe.gob.ocma.sociedadcivil.service.SeguEncaMasterService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 21/02/2014 12:37:35
 */
@Transactional(readOnly=true)
@Service("seguEncaMasterService")
public class SeguEncaMasterServiceImpl  implements SeguEncaMasterService  {
	@Autowired
	private SeguEncaMasterDao seguEncaMasterDao;

	@Override
	public List<SeguEnca> listarSeguEnca() {
		return seguEncaMasterDao.searchOrder(new SortCriteria("codEncarg"));
	}

}
