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

import pe.gob.ocma.entities.organosjurisd.Ojtespeciali;
import pe.gob.ocma.organosjur.dao.EspecialidadDao;
import pe.gob.ocma.organosjur.service.EspecialidadService;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 08/11/2013 09:24:40
 */

@Transactional(readOnly=true)
@Service("especialidadService")
public class EspecialidadServiceImpl implements EspecialidadService {

	@Autowired
	private EspecialidadDao especialidadDao;
	
	@Override
	public List<Ojtespeciali> listarEspecialidades() {
		return especialidadDao.searAll();
	}

}
