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
import pe.gob.ocma.entities.persona.Pettipdoc;
import pe.gob.ocma.persona.dao.DocumentoIdentidadDao;

/**
 * Clase de acceso a datos para manejar los tipos de documentos de identificación.
 * @author César Altamirano Menor
 * 21/06/2013 16:42:55
 */
@Repository("documentoIdentidadDao")
public class DocumentoIdentidadDaoImpl extends BaseHibernateDaoImpl<Pettipdoc, Short> implements DocumentoIdentidadDao, Serializable{
	
	private static final long serialVersionUID = -3838054940910285352L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Pettipdoc> buscarTiposDoc(String nomTabla, String codColumna, boolean habilitado) {
		StringBuilder hql = new StringBuilder("from Pettipdoc td ");
		hql.append("where td.gettabmae.nomTabla = :nomTabla ");
		hql.append("and td.gettabmae.codColumna = :codColumna ");
		hql.append("and td.habilitado = :habilitado");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabla);
		query.setString("codColumna", codColumna);
		query.setBoolean("habilitado", habilitado);
		return query.list();
	}
}
