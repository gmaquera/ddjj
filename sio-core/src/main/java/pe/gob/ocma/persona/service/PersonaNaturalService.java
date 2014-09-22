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
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.entities.seguridad.Setusuario;

/**
 * Interface para manejar la lógica de negocio de personas naturales.
 * @author César Altamirano Menor
 * 05/09/2013 16:50:56
 */
public interface PersonaNaturalService {
	
	/**
	 * Devuelve una persona natural según su clave primaria.
	 * @param codPerNatu La clave primaria.
	 * @return La persona natural buscada.
	 */
	public abstract Petpernatu buscarPersonaNatural(long codPerNatu);

	/**
	 * Devuelva la o las personas con el apellido y nombre envíado.
	 * @param apellido El apellido de la persona.
	 * @param nombre El nombre de la persona.
	 * @return La lista buscada.
	 */
	public abstract List<Petpernatu> buscarPersonaNatural(String apellido, String nombre);
	
	
	public abstract Petpernatu buscarCodigoPersona(long codPersona);	
	
	
	public abstract WrappedData<Petpernatu> buscarPersonas(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
}
