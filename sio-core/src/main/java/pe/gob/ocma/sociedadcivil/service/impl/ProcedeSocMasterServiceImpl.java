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
import pe.gob.ocma.entities.oc_ocma.Socprocede;
import pe.gob.ocma.sociedadcivil.dao.ProcedeSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.ProcedeSocMasterService;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 27/02/2014 11:00:53
 */
@Transactional(readOnly=true)
@Service("procedeSocMasterService")
public class ProcedeSocMasterServiceImpl implements ProcedeSocMasterService{
	@Autowired
	private ProcedeSocMasterDao procedeSocMasterDao;
	
	@Override
	public List<Socprocede> listarProcede() {
		return procedeSocMasterDao.searchOrder(new SortCriteria("cod_tiproc"));
	}
	

}
