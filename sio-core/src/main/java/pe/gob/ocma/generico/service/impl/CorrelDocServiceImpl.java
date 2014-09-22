/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión de los requerimientos del
 * personal de la OCMA. Constiene las funcionalidades desde
 * que el solicitante realiza una solicitud de un requerimiento 
 * hasta que es atendido por el personal encargado.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.generico.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.generico.Getcorreldoc;
import pe.gob.ocma.generico.dao.CorrelDocDao;
import pe.gob.ocma.generico.service.CorrelDocService;

/**
 * DECRIBIR TODO

 * 11/11/2013 11:09:06
 */
@Transactional(readOnly=true)
@Service("correlDocService")
public class CorrelDocServiceImpl implements CorrelDocService{
	
	@Autowired
	private CorrelDocDao correlDocDao;

	@Override
	public int searchNextCorrelQuejas(short codTip, int anio) {
		return correlDocDao.searchNextCorrelQuejas(codTip, anio);
	}

	@Override
	public void guardar(Getcorreldoc correlDoc) {
		correlDocDao.save(correlDoc);
	}

}
