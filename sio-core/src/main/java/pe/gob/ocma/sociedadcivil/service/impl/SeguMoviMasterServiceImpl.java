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
import pe.gob.ocma.entities.oc_ocma.SeguMovi;
import pe.gob.ocma.sociedadcivil.dao.SeguMoviMasterDao;
import pe.gob.ocma.sociedadcivil.service.SeguMoviMasterService;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 28/02/2014 10:27:18
 */
@Transactional(readOnly=true)
@Service("seguMoviMasterService")
public class SeguMoviMasterServiceImpl implements SeguMoviMasterService{

	@Autowired
	private SeguMoviMasterDao seguMoviMasterDao;
	
	@Override
	public List<SeguMovi> listarExpMovi(int intexp, int distriOrig) {
		FilterCriteria filtro = new FilterCriteria();
		SortCriteria sortmovi = new SortCriteria("fec_movimi", false);
		filtro.add("id.codIntexp",intexp);	
		filtro.add("id.codDistritoOrigen",distriOrig);
		return seguMoviMasterDao.searchFilterAndOrder(filtro, sortmovi);
				
	}

}
