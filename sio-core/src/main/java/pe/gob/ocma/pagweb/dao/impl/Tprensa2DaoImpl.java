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
package pe.gob.ocma.pagweb.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.web.TPrensa2;
import pe.gob.ocma.exception.OcmaException;
import pe.gob.ocma.pagweb.dao.Tprensa2Dao;

/**
 * FIXME DESCRIBIR
 * @author Adolfo Edgar Queque Cruz
 * 28/11/2013 10:42:45
 */

@Repository("tprensa2Dao")
public class Tprensa2DaoImpl extends BaseHibernateDaoImpl<TPrensa2, Integer> implements Tprensa2Dao, Serializable {

	private static final long serialVersionUID = 7960576856622377722L;

	@Override
	public void updateUrlres(int id, String desurl) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE WEB.T_PRENSA_2 SET URL_NOTICIA='" + desurl + "' WHERE ID_NOTICIA="+ id +"");
		
		Query query = super.getSession().createSQLQuery(sql.toString());
		int update = query.executeUpdate();
		if(update == 0){
			throw new OcmaException("Error al Actualizar URLNOTICIA :(");
		}
		
	}

	@Override
	public void updateUrlfot(int id, String desurl) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE WEB.T_PRENSA_2 SET URL_IMAGEN='" + desurl + "' WHERE ID_NOTICIA="+ id +"");
		
		Query query = super.getSession().createSQLQuery(sql.toString());
		int update = query.executeUpdate();
		if(update == 0){
			throw new OcmaException("Error al Actualizar URLFOTO :(");
		}
	}
}