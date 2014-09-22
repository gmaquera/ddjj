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

import pe.gob.ocma.entities.seguridad.Setaplica;
import pe.gob.ocma.seguridad.dao.AplicacionDao;
import pe.gob.ocma.seguridad.service.AplicacionService;

/**
 * Clase para manejar la lógica de negocio de las aplicaciones del sistema.
 * @author César Altamirano Menor
 * 03/09/2013 12:33:42
 */
@Transactional(readOnly=true)
@Service("aplicacionService")
public class AplicacionServiceImpl implements AplicacionService {

	@Autowired
	private AplicacionDao aplicaDao;
	
	@Override
	public List<Setaplica> listarAplicaciones() {
		return aplicaDao.searAll();
	}
}
