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

import pe.gob.ocma.entities.ubigeojud.Ujtdisjud;
import pe.gob.ocma.organosjur.dao.DisJudDao;
import pe.gob.ocma.organosjur.service.DisJudService;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 28/02/2014 10:33:23
 */
@Transactional(readOnly=true)
@Service("disJudService")
public class DisJudServiceImpl implements DisJudService {

	@Autowired
	private DisJudDao disJudDao;
	
	@Override
	public List<Ujtdisjud> listarDistritos() {
		return disJudDao.searAll();
	}

}
