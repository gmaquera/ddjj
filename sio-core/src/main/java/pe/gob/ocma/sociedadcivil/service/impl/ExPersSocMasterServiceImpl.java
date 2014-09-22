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

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.entities.oc_ocma.ExpePers;
import pe.gob.ocma.sociedadcivil.dao.ExPersSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.ExPersSocMasterService;


/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 27/02/2014 17:25:52
 */
@Transactional(readOnly=true)
@Service("exPersSocMasterService")
public class ExPersSocMasterServiceImpl implements ExPersSocMasterService{

	@Autowired
	private ExPersSocMasterDao exPersSocMasterDao;
	
	@Override
	public List<ExpePers> listarExPersSc(int intexp, int distriOrig) {
		FilterCriteria filtro = new FilterCriteria(); 
		SortCriteria sortPer = new SortCriteria("personal.desApelli", true);
		filtro.add("id.codIntexp",intexp);	
		filtro.add("id.codDistritoOrigen",distriOrig);	
		return exPersSocMasterDao.searchFilterAndOrder(filtro, sortPer);			
	}
}
