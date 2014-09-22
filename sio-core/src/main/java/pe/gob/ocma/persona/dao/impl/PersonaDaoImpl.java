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
package pe.gob.ocma.persona.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.persona.dao.PersonaDao;

/**
 * Clase para manejar los datos de personas naturales y jurídicas desde base de datos.
 * @author César Altamirano Menor
 * 09/09/2013 12:04:24
 */
@Repository("personaDao")
public class PersonaDaoImpl extends BaseHibernateDaoImpl<Petpersona, Long> implements PersonaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Petpersona buscarPersonaDoc(String numDocumento) {
		return super.searchUnique(Petpersona.class, "numDocumento", numDocumento);
	}

	@Override
	public List<Petpersona> buscarPersonaNombre(String nombre) {
		return super.searchFilter(new FilterCriteria("nombre", nombre));
	}

}
