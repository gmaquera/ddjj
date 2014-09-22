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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.entities.generico.Gettabla;
import pe.gob.ocma.generico.dao.TablaDao;
import pe.gob.ocma.generico.service.TablaService;

/**
 * Clase para el manejo de lógica de negocio de las tablas existentes en base de datos.
 * @author César Altamirano Menor
 * 11/10/2013 13:31:17
 */
@Transactional(readOnly=true)
@Service("tablaService")
public class TablaServiceImpl implements TablaService {

	@Autowired
	private TablaDao tablaDao;
	
	@Override
	public List<Gettabla> listarTablas() {
		return tablaDao.searAll();
	}
}
