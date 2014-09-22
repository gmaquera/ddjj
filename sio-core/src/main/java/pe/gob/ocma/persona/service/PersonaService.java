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
package pe.gob.ocma.persona.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.persona.Petpersona;

/**
 * Interface para manejar la lógica de negocio de Persona.
 * @author Gino Maquera Coyla
 * 21/11/2013 14:51:14
 */
public interface PersonaService {
	
	public abstract Petpersona buscarPersona(Long codPersona);
	
	public abstract List<Petpersona> buscarPersonaNombre(String nombre);
	
	public abstract WrappedData<Petpersona> buscarPersonas(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);

}
