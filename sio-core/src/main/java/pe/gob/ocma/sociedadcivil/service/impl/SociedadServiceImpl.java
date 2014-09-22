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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.entities.oc_ocma.Socmast;
import pe.gob.ocma.sociedadcivil.dao.SociedadDao;
import pe.gob.ocma.sociedadcivil.service.SociedadService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 24/02/2014 10:39:25
 */
@Transactional(readOnly=true)
@Repository("sociedadService")
public class SociedadServiceImpl implements SociedadService{

	@Autowired
	private SociedadDao sociedadDao;
	
	@Override
	public void GrabarExpeSoc(Socmast socmast) {
	socmast.setNum_sc((int)sociedadDao.searchNextCorrelMaeMerge("Scmast"));
	sociedadDao.save(socmast);
	}

	@Override
	public void EditarExpeSoc(Socmast socmast) {
	sociedadDao.update(socmast);
	}

	@Override
	public void EliminarExpeSoc(Socmast socmast) {
	sociedadDao.delete(socmast);
	}

	@Override
	public List<Socmast> buscarExpeExistente(Integer COD_DISTRITO_ORIGEN,
			Integer COD_INTEXP) {
		FilterCriteria filtro = new FilterCriteria(); 
		filtro.add("cod_distrito_origen",COD_DISTRITO_ORIGEN);	
		filtro.add("cod_intexp",COD_INTEXP);
		return sociedadDao.searchFilter(filtro);	
		 
	}

}
