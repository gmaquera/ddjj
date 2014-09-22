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
package pe.gob.ocma.organosjur.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.organosjurisd.Ojtdependen;
import pe.gob.ocma.organosjur.dao.DependenciaDao;
import pe.gob.ocma.organosjur.service.DependenciaService;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 08/11/2013 10:34:04
 */

@Transactional(readOnly=true)
@Service("dependenciaService")
public class DependenciaServiceImpl implements DependenciaService {
	
	@Autowired
	private DependenciaDao dependenciaDao;

	@Override
	public List<Ojtdependen> listarDependencias() {
		return dependenciaDao.searAll();
	}

	@Override
	public List<Ojtdependen> buscarDependencia(Short codDisJud,
			Short codOrgJurisd, Short codEspeciali) {
		return dependenciaDao.buscarDependencia(codDisJud, codOrgJurisd, codEspeciali);
	}

}
