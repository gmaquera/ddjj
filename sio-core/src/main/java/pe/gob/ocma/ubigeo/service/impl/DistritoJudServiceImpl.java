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

import pe.gob.ocma.entities.ubigeojud.Ujtdisjud;
import pe.gob.ocma.ubigeo.dao.DistritoJudDao;
import pe.gob.ocma.ubigeo.service.DistritoJudService;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 07/11/2013 11:24:07
 */

@Transactional(readOnly=true)
@Service("distritoJudService")
public class DistritoJudServiceImpl implements DistritoJudService{

	@Autowired
	private DistritoJudDao distritoJudDao;
	
	@Override
	public List<Ujtdisjud> listarDistritoJud() {
		return distritoJudDao.searAll();
	}	

}
