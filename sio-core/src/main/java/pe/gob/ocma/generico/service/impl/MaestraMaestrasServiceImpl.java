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

import pe.gob.ocma.entities.generico.Gettabmae;
import pe.gob.ocma.generico.dao.MaestraMaestrasDao;
import pe.gob.ocma.generico.service.MaestraMaestrasService;

/**
 * Clase para manejar la lógica de negocio de 2 o 3 registros dentro de una tabla maestra genérica.
 * @author César Altamirano Menor
 * 09/09/2013 15:47:52
 */
@Transactional(readOnly=true)
@Service("maestraMaestrasService")
public class MaestraMaestrasServiceImpl implements MaestraMaestrasService {

	@Autowired
	private MaestraMaestrasDao maeDao;
	
	@Override
	public Gettabmae buscar(short codTabMae) {
		return maeDao.get(codTabMae);
	}
	
	@Override
	public Gettabmae buscar(String nomTabla, String codColumna) {
		return maeDao.buscar(nomTabla, codColumna);
	}
}
