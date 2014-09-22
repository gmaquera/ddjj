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
package pe.gob.ocma.seguridad.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.entities.seguridad.Setusugrupo;
import pe.gob.ocma.entities.seguridad.SetusugrupoId;
import pe.gob.ocma.seguridad.dao.UsuGrupoDao;

/**
 * Clase para manejar los grupos o roles de un usuario desde base de datos.
 * @author César Altamirano Menor
 * 24/06/2013 17:26:09
 */
@Repository("usuGrupoDao")
public class UsuGrupoDaoImpl extends BaseHibernateDaoImpl<Setusugrupo, SetusugrupoId> implements UsuGrupoDao, Serializable{
	
	private static final long serialVersionUID = -3509931497133731305L;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> buscarCodGruposUsuario(String codUsuario) {
		StringBuilder hql = new StringBuilder("select ug.id.codGrupo from Setusugrupo ug ");
		hql.append("where ug.id.codUsuario = :codUsuario ");
		hql.append("and ug.habilitado = :habilitado");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("codUsuario", codUsuario);
		query.setBoolean("habilitado", ConstanteCore.HABILITADO_TRUE);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Setusugrupo> buscarHabilitadosPorDeshabilitar(String codUsuario, List<String> seleccionados) {
		StringBuilder hql = new StringBuilder("from Setusugrupo ug ");
		hql.append("where ug.id.codUsuario = :codUsuario ");
		if(seleccionados!= null && seleccionados.size() > 0) {
			hql.append("and ug.id.codGrupo not in (:grupos) ");
		}
		hql.append("and ug.habilitado = :habilitado");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("codUsuario", codUsuario);
		if(seleccionados!= null && seleccionados.size() > 0) {
			query.setParameterList("grupos", seleccionados, new StringType());
		}
		query.setBoolean("habilitado", ConstanteCore.HABILITADO_TRUE);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setusugrupo> buscarUsuariosGrupo(int codGrupo) {
		StringBuilder hql = new StringBuilder("from Setusugrupo ug ");
		hql.append("where ug.id.codGrupo = :codGrupo ");
		hql.append("and ug.habilitado = :habilitado");
		Query query = super.getSession().createQuery(hql.toString());
		query.setInteger("codGrupo", codGrupo);
		query.setBoolean("habilitado", true);
		return query.list();
	}
}
