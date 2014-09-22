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
package pe.gob.ocma.persona.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.persona.dao.PersonaDao;
import pe.gob.ocma.persona.service.PersonaService;

/**
 * Clase para manejar la lógica de negocio de personas.
 * @author Gino Maquera Coyla
 * 21/11/2013 14:52:52
 */


@Transactional(readOnly=true)
@Service("personaService")
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao personaDao;	

	@Override
	public Petpersona buscarPersona(Long codPersona) {
		return personaDao.searchUnique(Petpersona.class, "codPersona", codPersona);
	}

	@Override
	public List<Petpersona> buscarPersonaNombre(String nombre) {
		return personaDao.buscarPersonaNombre(nombre);
	}

	@Override
	public WrappedData<Petpersona> buscarPersonas(
			Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first,
			int pageSize) {
		return personaDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}
	
}
