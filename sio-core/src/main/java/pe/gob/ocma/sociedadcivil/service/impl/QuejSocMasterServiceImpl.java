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
import pe.gob.ocma.entities.oc_ocma.ExpeQuej;
import pe.gob.ocma.sociedadcivil.dao.QuejSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.QuejSocMasterService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 27/02/2014 12:38:31
 */
@Transactional(readOnly=true)
@Service("quejSocMasterService")
public class QuejSocMasterServiceImpl implements QuejSocMasterService{
	
	@Autowired
	private QuejSocMasterDao quejSocMasterDao;
	
	@Override
	public List<ExpeQuej> listarQuejoso() {
		return null;
	}

	@Override
	public List<ExpeQuej> listarQuejosExpe(int intexp, int distriOrig) {
		FilterCriteria filtro = new FilterCriteria(); 
		SortCriteria sortQuej = new SortCriteria("expeDque.desApelli", true);
		filtro.add("id.codIntexp",intexp);	
		filtro.add("id.codDistritoOrigen",distriOrig);	
		return quejSocMasterDao.searchFilterAndOrder(filtro, sortQuej);					
	}
}
