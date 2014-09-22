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
package pe.gob.ocma.pagweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.entities.web.TPrensaTipo;
import pe.gob.ocma.pagweb.dao.TPrensaTipoDao;
import pe.gob.ocma.pagweb.service.TPrensaTipoService;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 26/11/2013 10:36:08
 */

@Transactional(readOnly = true)
@Service("tPrensaTipoService")
public class TPrensaTipoServiceImpl implements TPrensaTipoService {

	@Autowired
	private TPrensaTipoDao tprensaTipoDao;

	@Override
	public List<TPrensaTipo> lisTipNot(int idCateg) {
		FilterCriteria filtros= new FilterCriteria();
		filtros.add("TPrensaCategoria", idCateg);
		filtros.add("flaTipo",1);
		return tprensaTipoDao.searchFilter(filtros);
	}
	
}