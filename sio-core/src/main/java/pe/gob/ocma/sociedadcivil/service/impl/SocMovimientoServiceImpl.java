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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.oc_ocma.ExpeMast;
import pe.gob.ocma.entities.oc_ocma.Socmovimiento;
import pe.gob.ocma.sociedadcivil.dao.EncaSocMasterDao;
import pe.gob.ocma.sociedadcivil.dao.ProcedeSocMasterDao;
import pe.gob.ocma.sociedadcivil.dao.SeguEncaMasterDao;
import pe.gob.ocma.sociedadcivil.dao.SocMovimientoDao;
import pe.gob.ocma.sociedadcivil.dao.TipDocSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.SocMovimientoService;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 18/02/2014 15:31:23
 */

@Transactional(readOnly=true)
@Repository("socMovimientoService")
public class SocMovimientoServiceImpl implements SocMovimientoService{
	
	@Autowired
	private SocMovimientoDao socMovimientoDao;
	
	@Autowired
	private	SeguEncaMasterDao seguEncaDao;
	
	@Autowired
	private	TipDocSocMasterDao tipDocDao;
	
	@Autowired
	private ProcedeSocMasterDao ProcedeSocDao;
	
	@Autowired
	private EncaSocMasterDao EncaSocDao;

	@Override
	public List<Socmovimiento> listarMovimiento(Integer num_sc) {
		FilterCriteria filMovSoc = new FilterCriteria(); 
		SortCriteria sortMovSoc = new SortCriteria("fecha_in", false);
		filMovSoc.add("NUM_SC", num_sc);
		return socMovimientoDao.searchFilterAndOrder(filMovSoc, sortMovSoc);
	}

	@Override
	public List<Socmovimiento> listarMovimientoUlt() {
		FilterCriteria filtro = new FilterCriteria(); 
		SortCriteria sortSocMov = new SortCriteria("fecha_in", false);
		filtro.add("fla_ult_movi","*");	
		return socMovimientoDao.searchFilterAndOrder(filtro, sortSocMov);
	}

	@Transactional
	@Override
	public void GrabarMovimiento(Socmovimiento socmovimiento) {
		FilterCriteria ultMov = new FilterCriteria(); 
		ultMov.add("fla_ult_movi","*");
		ultMov.add("NUM_SC",socmovimiento.getNum_sc());
		if (!socMovimientoDao.searchFilter(ultMov).isEmpty()) {
			Socmovimiento socTemp = socMovimientoDao.searchFilter(ultMov).get(0);
			socTemp.setFla_ult_movi("-");
			socMovimientoDao.update(socTemp);			
		}
		socmovimiento.setFla_ult_movi("*");
		socmovimiento.setNum_info((int)socMovimientoDao.searchNextCorrelMaeMerge("Scmovimiento"));
		socmovimiento.setSocencarg(seguEncaDao.get(socmovimiento.getCod_encarg()));
		socmovimiento.setSoctipdoc(tipDocDao.get(socmovimiento.getCod_tipdoc()));
		socmovimiento.setSocprocede(ProcedeSocDao.get(socmovimiento.getCod_tiproc()));
		socmovimiento.setSocencargados(EncaSocDao.get(socmovimiento.getCodEncargado()));
		socMovimientoDao.save(socmovimiento);		
		
	}
 
	@Override
	public void EditarMovimiento(Socmovimiento socmovimiento) {
		socmovimiento.setSocencarg(seguEncaDao.get(socmovimiento.getCod_encarg()));
		socmovimiento.setSoctipdoc(tipDocDao.get(socmovimiento.getCod_tipdoc()));
		socmovimiento.setSocprocede(ProcedeSocDao.get(socmovimiento.getCod_tiproc()));
		socmovimiento.setSocencargados(EncaSocDao.get(socmovimiento.getCodEncargado()));
		socMovimientoDao.update(socmovimiento);
	}

	@Transactional
	@Override
	public void EliminarMovimiento(Socmovimiento socmovimiento) {		
				
			socMovimientoDao.delete(socmovimiento);
			if (socmovimiento.getFla_ult_movi().equals("*")) {				
				SortCriteria sortSocMov = new SortCriteria("fecha_in", false);
				FilterCriteria ultMov = new FilterCriteria(); 
				ultMov.add("NUM_SC",socmovimiento.getNum_sc());
				Socmovimiento movTemp = socMovimientoDao.searchFilterAndOrder(ultMov, sortSocMov).get(0);
				movTemp.setFla_ult_movi("*");
				socMovimientoDao.update(movTemp);				
			}	
			
				
	}

	@Override
	public List<Socmovimiento> listarAll() {
		return socMovimientoDao.searAll();
	}

	@Override
	public WrappedData<Socmovimiento> listarMovSociedad(
			Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		return socMovimientoDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}

	
	/**
	
	@Override
	public WrappedData<ExpeMast> listaExpeComprendidos(
			Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		return expeMastScDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}**/


}
