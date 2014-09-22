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
package pe.gob.ocma.seguridad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.seguridad.Settema;
import pe.gob.ocma.seguridad.dao.TemaDao;
import pe.gob.ocma.seguridad.service.TemaService;

/**
 * Clase de servicio para manejar los temas de interfaz IU.
 * @author César Altamirano Menor
 * 18/06/2013 16:12:59
 */
@Transactional(readOnly=true)
@Service("temaService")
public class TemaServiceImpl implements TemaService{

	@Autowired
	private TemaDao temaDao;
	
	@Override
	public List<Settema> listarTemas() {
		return temaDao.searAll();
	}
}
