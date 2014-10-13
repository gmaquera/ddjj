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
package pe.gob.ocma.webocma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.entities.web_ocma.Afp;
import pe.gob.ocma.entities.web_ocma.TablaRegimenPension;
import pe.gob.ocma.webocma.dao.WebAfpDao;
import pe.gob.ocma.webocma.dao.WebTablaRegimenPensionDao;
import pe.gob.ocma.webocma.dao.WebWebPersonalDao;
import pe.gob.ocma.webocma.service.WebInfoLaboralService;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 7/10/2014 8:30:19
 */
@Service("webInfoLaboralService")
public class WebInfoLaboralServiceImpl implements WebInfoLaboralService{

	
	@Autowired
	private WebAfpDao webAfpDao;
	
	@Autowired
	private WebTablaRegimenPensionDao webTablaRegimenPensionDao;
	
	
	@Override
	public List<Afp> listaTipoAFP() {
		return webAfpDao.searchOrder(new SortCriteria("codAfp"));
	}
	
	@Override
	public List<TablaRegimenPension> listaTipoRegimenPension() {
		return webTablaRegimenPensionDao.searchOrder(new SortCriteria("codRegpension"));
	} 
	
}
