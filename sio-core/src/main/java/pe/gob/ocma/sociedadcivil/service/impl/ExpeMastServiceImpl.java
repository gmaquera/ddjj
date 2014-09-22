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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.oc_ocma.ExpeMast;
import pe.gob.ocma.entities.oc_ocma.ExpeMastId;
import pe.gob.ocma.sociedadcivil.dao.ExpeMastDao;
import pe.gob.ocma.sociedadcivil.service.ExpeMastService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 25/02/2014 08:52:02
 */

@Transactional(readOnly=true)
@Service("expeMastScService")
public class ExpeMastServiceImpl implements ExpeMastService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ExpeMastDao expeMastScDao;

	@Override
	public ExpeMast buscarExpeMast(ExpeMastId numExpedi) {
		return expeMastScDao.buscarExpeMast(numExpedi);
	}

	@Override
	public void BuscarExpediente(ExpeMast expemast) {
		FilterCriteria filtro = new FilterCriteria(); 
		filtro.add("Id.codDistritoOrigen","*");	
		filtro.add("Id.codIntexp","*");
		//return expeMastScDao.searchFilter(filtro);
	}

	@Override
	public WrappedData<ExpeMast> listaExpeComprendidos(
			Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		return expeMastScDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}

	@Override
	public List<ExpeMast> BuscarExpeSoc(int intexp, int distriOrig) {
		FilterCriteria filExp = new FilterCriteria(); 
		filExp.add("id.codIntexp",intexp);
		filExp.add("id.codDistritoOrigen",distriOrig);
		return expeMastScDao.searchFilter(filExp);
		
	}
	
		

}
