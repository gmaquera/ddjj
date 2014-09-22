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
import pe.gob.ocma.sociedadcivil.dao.SeguEncaSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.SeguEncaSocMasterService;


/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 03/03/2014 15:47:15
 */
@Transactional(readOnly=true)
@Service("seguEncaSocMasterService")
public class SeguEncaSocMasterServiceImpl implements SeguEncaSocMasterService{

	@Autowired
	private SeguEncaSocMasterDao seguEncaSocMasterDao;
	
	@Override
	public List<SeguEnca> listarEncaSocFirm() {
		return seguEncaSocMasterDao.searchOrder(new SortCriteria("codEncarg"));				
	}

}
