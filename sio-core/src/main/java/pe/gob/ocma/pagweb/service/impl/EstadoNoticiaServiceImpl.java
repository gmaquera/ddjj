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
package pe.gob.ocma.pagweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.web.EstadoNoticia;
import pe.gob.ocma.pagweb.dao.EstadoNoticiaDao;
import pe.gob.ocma.pagweb.service.EstadoNoticiaService;

/**
 * FIXME DESCRIBIR
 * @author César Altamirano Menor
 * 28/11/2013 09:11:32
 */
@Transactional(readOnly = true)
@Service("estadoNoticiaService")
public class EstadoNoticiaServiceImpl implements EstadoNoticiaService {
	
	@Autowired
	private EstadoNoticiaDao estNotDao;

	@Override
	public List<EstadoNoticia> listEst() {
		return estNotDao.searAll();
	}

}