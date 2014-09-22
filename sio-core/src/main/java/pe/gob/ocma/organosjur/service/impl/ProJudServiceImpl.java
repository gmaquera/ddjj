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
package pe.gob.ocma.organosjur.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.entities.ubigeojud.Ujtprojud;
import pe.gob.ocma.organosjur.dao.ProJudDao;
import pe.gob.ocma.organosjur.service.ProJudService;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 28/02/2014 10:39:46
 */

@Transactional(readOnly=true)
@Service("proJudService")
public class ProJudServiceImpl implements ProJudService {

	@Autowired
	private ProJudDao proJudDao;
	
	@Override
	public List<Ujtprojud> listarProvincias() {
		return proJudDao.searAll();
	}

	@Override
	public List<Ujtprojud> listarProvDist(short codDisJud) {				
		return proJudDao.searchFilter(new FilterCriteria("codDisJud", codDisJud));
	}

}
