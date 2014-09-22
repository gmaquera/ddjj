/**
 * Copyright © 2013 OCMA
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
package pe.gob.ocma.pagweb.service.impl;

import java.io.Serializable;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.web.TPrensa2;
import pe.gob.ocma.pagweb.dao.EstadoNoticiaDao;
import pe.gob.ocma.pagweb.dao.TPrensaTipoDao;
import pe.gob.ocma.pagweb.dao.Tprensa2Dao;
import pe.gob.ocma.pagweb.service.Tprensa2Service;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 28/11/2013 10:52:10
 */

@Transactional(readOnly = true)
@Service("tprensa2Service")

public class Tprensa2ServiceImpl implements Tprensa2Service {

	@Autowired
	private Tprensa2Dao tprensa2Dao;

	@Autowired
	private EstadoNoticiaDao estadoNoticiaDao;
	
	@Autowired
	private TPrensaTipoDao tPrensaTipoDao;
	/*@Override
	public List<TPrensa2> ListaTablaRes() {
		
		FilterCriteria filtro= new FilterCriteria();
		filtro.add("cateNoticia", 13);
		return tprensa2Dao.searchFilter(filtro); 
	}*/
	@Override
	public WrappedData<TPrensa2> buscarResoluciones(
			Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		extFilters.put("cateNoticia", 13);
		return tprensa2Dao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
		
	}
	
	@Transactional
	@Override
	public int guardarRes(TPrensa2 objsaveRes) {
		
		Long correlativo = tprensa2Dao.searchNextCorrelMaeMerge(Tablas.TPRENSA2);
		objsaveRes.setIdNoticia(correlativo.intValue());
		tprensa2Dao.save(objsaveRes);
		objsaveRes.setDesEstado(estadoNoticiaDao.load(objsaveRes.getEstadoNoticia())); // actualiza el objeto 
		objsaveRes.setDesTipNot(tPrensaTipoDao.load(objsaveRes.getTipoNoticia()));
		return objsaveRes.getIdNoticia();
	}
	@Transactional
	@Override
	public void actualizaRes(TPrensa2 objupdateRes) {
		tprensa2Dao.update(objupdateRes);
		objupdateRes.setDesEstado(estadoNoticiaDao.load(objupdateRes.getEstadoNoticia())); // actualiza el objeto
		objupdateRes.setDesTipNot(tPrensaTipoDao.load(objupdateRes.getTipoNoticia()));
	
	}
	
	@Transactional
	@Override
	public void updateUrlRes(int id, String desUrl) {
		tprensa2Dao.updateUrlres(id, desUrl);
	}

	@Override
	public WrappedData<TPrensa2> buscarNoticias(Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		extFilters.put("cateNoticia", 12);
		return tprensa2Dao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}
	
	@Transactional
	@Override
	public void updateUrlFot(int id, String desUrl) {
		tprensa2Dao.updateUrlfot(id, desUrl);
	}

}