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

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.persona.dao.PersonaNaturalDao;

/**
 * Clase para manejar los datos de personas naturales desde base de datos
 * @author César Altamirano Menor
 * 05/09/2013 16:49:27
 */
@Repository("personaNaturalDao")
public class PersonaNaturalDaoImpl extends BaseHibernateDaoImpl<Petpernatu, Long> implements PersonaNaturalDao, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Petpernatu> buscarPersonaNatural(String apellido, String nombre) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Petpernatu p ");
		hql.append("where p.apellido = :apellido ");
		hql.append("and p.nombre = :nombre");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("apellido", apellido);
		query.setString("nombre", nombre);
		return query.list();
	}

	@Override
	public Petpernatu buscarCodigoPersona(long codPersona) {
		return super.searchUnique(Petpernatu.class, "codPernatu", codPersona);
	}
}
