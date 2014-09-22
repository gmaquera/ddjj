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
package pe.gob.ocma.ubigeo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.ubigeojud.Ujtprojud;
import pe.gob.ocma.ubigeo.dao.ProvinciaJudDao;
import pe.gob.ocma.ubigeo.service.ProvinciaJudService;

/**
 * DECRIBIR TODO
 * @author 
 * 07/11/2013 12:22:49
 */

@Transactional(readOnly=true)
@Service("provinciaJudService")
public class ProvinciaJudServiceImpl implements ProvinciaJudService {

	@Autowired
	private ProvinciaJudDao provinciaJudDao;
	
	@Override
	public List<Ujtprojud> listarProvinciaJud() {
		return provinciaJudDao.searAll();
	}

	@Override
	public List<Ujtprojud> buscarGruposDisJudicial(short codDisJud) {
		return provinciaJudDao.buscarProvinciasJud(codDisJud);
	}
}
