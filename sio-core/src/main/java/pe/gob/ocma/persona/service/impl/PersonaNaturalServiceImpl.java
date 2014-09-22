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
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.persona.dao.PersonaNaturalDao;
import pe.gob.ocma.persona.service.PersonaNaturalService;

/**
 * Clase para manejar la lógica de negocio de personas naturales.
 * 
 * @author César Altamirano Menor 05/09/2013 16:51:37
 */
@Transactional(readOnly = true)
@Service("personaNaturalService")
public class PersonaNaturalServiceImpl implements PersonaNaturalService {

	@Autowired
	private PersonaNaturalDao perNatDao;

	@Override
	public Petpernatu buscarPersonaNatural(long codPerNatu) {
		return perNatDao.get(codPerNatu);
	}

	@Override
	public List<Petpernatu> buscarPersonaNatural(String apellido, String nombre) {
		return perNatDao.buscarPersonaNatural(apellido, nombre);
	}

	@Override
	public Petpernatu buscarCodigoPersona(long codPersona) {
		return perNatDao.buscarCodigoPersona(codPersona);
	}

	@Override
	public WrappedData<Petpernatu> buscarPersonas(Map<String, String> colFilters,
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize) {
		return perNatDao.searchFilterAndOrderPaginator(colFilters, extFilters, sort, first, pageSize);
	}

}
