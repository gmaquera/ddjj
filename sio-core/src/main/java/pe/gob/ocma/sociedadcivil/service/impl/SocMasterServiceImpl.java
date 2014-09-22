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
import pe.gob.ocma.entities.oc_ocma.Socmast;
import pe.gob.ocma.sociedadcivil.dao.SocMasterDao;
import pe.gob.ocma.sociedadcivil.service.SocMasterService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 14/02/2014 08:22:42
 */
@Transactional(readOnly=true)
@Service("socMasterService")
public class SocMasterServiceImpl implements SocMasterService {

	@Autowired
	private SocMasterDao socMasterDao;
	
	@Override
	public List<Socmast> listarExpeSociedad() {
		return socMasterDao.searAll();
	}

	@Override
	public void GrabarSocmast(Socmast socmast) {
		socMasterDao.save(socmast);
	}

	@Override
	public void EditarSocmast(Socmast socmast) {
		socMasterDao.update(socmast);
	}

	@Override
	public void EliminarSocmast(Socmast socmast) {
		socMasterDao.delete(socmast);
	}

	@Override
	public Socmast ObtenerSocmast(Integer numsoc) {
		return socMasterDao.searchUnique(Socmast.class, "num_sc", numsoc);
	}
	

}
