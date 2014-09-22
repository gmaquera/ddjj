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
import pe.gob.ocma.entities.oc_ocma.Soctipdoc;
import pe.gob.ocma.sociedadcivil.dao.TipDocSocMasterDao;
import pe.gob.ocma.sociedadcivil.service.TipDocSocMasterService;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 27/02/2014 10:15:28
 */
@Transactional(readOnly=true)
@Service("tipDocSocMasterService")
public class TipDocSocMasterServiceImpl implements TipDocSocMasterService{

	@Autowired
	private TipDocSocMasterDao tipDocSocMasterDao;

	@Override
	public List<Soctipdoc> listarTipDocSoc() {
		return tipDocSocMasterDao.searchOrder(new SortCriteria("cod_tipdoc"));
		
	}

}
