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
package pe.gob.ocma.generico.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.generico.Gettabmae;
import pe.gob.ocma.generico.dao.MaestraMaestrasDao;

/**
 * Clase para el manejo maestras de 2 o 3 registros dentro de una tabla maestra genérica.
 * @author César Altamirano Menor
 * 09/09/2013 12:21:35
 */
@Repository("maestraMaestrasDao")
public class MaestraMaestrasDaoImpl extends BaseHibernateDaoImpl<Gettabmae, Short> implements MaestraMaestrasDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Gettabmae buscar(String nomTabla, String codColumna) {
		StringBuilder hql = new StringBuilder();
		hql.append("from Gettabmae ma ");
		hql.append("where ma.nomTabla = :nomTabla ");
		hql.append("and ma.codColumna = :codColumna");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabla);
		query.setString("codColumna", codColumna);
		return (Gettabmae) query.uniqueResult();
	}

}
