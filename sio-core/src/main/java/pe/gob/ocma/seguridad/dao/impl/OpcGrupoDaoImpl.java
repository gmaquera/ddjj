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
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.entities.seguridad.Setopcgrupo;
import pe.gob.ocma.entities.seguridad.SetopcgrupoId;
import pe.gob.ocma.seguridad.dao.OpcGrupoDao;
import pe.gob.ocma.seguridad.dto.MenuModel;

/**
 * Clase para manejar el acceso a los objetos del sistema desde la base de datos.
 * @author César Altamirano Menor
 * 05/06/2013 16:22:41
 */
@Repository("opcGrupoDao")
public class OpcGrupoDaoImpl extends BaseHibernateDaoImpl<Setopcgrupo, SetopcgrupoId> implements OpcGrupoDao, Serializable {

	private static final long serialVersionUID = 3498084024277985312L;

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuSoloPadres(char tipo) {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.tipo = :tipo and o.opcPadre = :opcPadre ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        query.setParameter("tipo", tipo);
        query.setInteger("opcPadre", 0);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuHijosPadres(char tipo) {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.tipo = :tipo and o.opcPadre != :opcPadre ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        query.setParameter("tipo", tipo);
        query.setInteger("opcPadre", 0);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuSoloPadres(String codUsuario, char tipo) {
		StringBuilder hql = new StringBuilder();
        hql.append("select distinct o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url, o.orden as orden ");
        hql.append("from Setopcgrupo og ");
        hql.append("inner join og.setopcion o ");
        hql.append("where og.setgrupo in ");
        hql.append("(select distinct ug.setgrupo from Setusugrupo ug where ug.setusuario.codUsuario = :codUsuario and ug.habilitado = :habilitado) ");
        hql.append("and o.tipo = :tipo and o.opcPadre = :opcPadre ");
        hql.append("order by orden");
        Query query = super.getSession().createQuery(hql.toString());
        query.setParameter("codUsuario", codUsuario);
        query.setBoolean("habilitado", ConstanteCore.HABILITADO_TRUE);
        query.setParameter("tipo", tipo);
        query.setInteger("opcPadre", 0);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuHijosPadres(String codUsuario, char tipo) {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcgrupo og ");
        hql.append("inner join og.setopcion o ");
        hql.append("where og.setgrupo in ");
        hql.append("(select distinct ug.setgrupo from Setusugrupo ug where ug.setusuario.codUsuario = :codUsuario and ug.habilitado = :habilitado) ");
        hql.append("and o.tipo = :tipo and o.opcPadre != :opcPadre ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        query.setParameter("codUsuario", codUsuario);
        query.setBoolean("habilitado", ConstanteCore.HABILITADO_TRUE);
        query.setParameter("tipo", tipo);
        query.setInteger("opcPadre", 0);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuSoloPadres(int codDisJudicial) {
		StringBuilder hql = new StringBuilder();
        hql.append("select distinct o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url, o.orden as ordenar ");
        hql.append("from Setopcgrupo og ");
        hql.append("inner join og.setopcion o ");
        hql.append("where og.setgrupo.codDisJudic = :codDisJudicial ");
        hql.append("and o.opcPadre is null ");
        hql.append("order by ordenar");
        Query query = super.getSession().createQuery(hql.toString());
        query.setInteger("codDisJudicial", codDisJudicial);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuHijosPadres(int codDisJudicial) {
		
		StringBuilder hql = new StringBuilder();
        hql.append("select distinct o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url, o.orden as ordenar ");
        hql.append("from Setopcgrupo og ");
        hql.append("inner join og.setopcion o ");
        hql.append("where og.setgrupo.codDisJudic = :codDisJudicial ");
        hql.append("and o.opcPadre is not null ");
        hql.append("order by ordenar");
        Query query = super.getSession().createQuery(hql.toString());
        query.setInteger("codDisJudicial", codDisJudicial);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuSoloPadres() {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.opcPadre is null ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuHijosPadres() {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.opcPadre is not null ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarMenuHijosPadre(Integer opcPadre) {
		StringBuilder hql = new StringBuilder();
		hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.opcPadre = :opcPadre ");
        hql.append("order by o.orden");
        Query query = super.getSession().createQuery(hql.toString());
        query.setParameter("opcPadre", opcPadre);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setopcgrupo> buscarOpcGrupo(int codGrupo) {
		StringBuilder hql = new StringBuilder("from Setopcgrupo og ");
		hql.append("where og.id.codGrupo = :codGrupo");
		Query query = this.getSession().createQuery(hql.toString());
		query.setParameter("codGrupo", codGrupo);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Setopcgrupo> buscarOpcionesPorEliminar(int codGrupo, Collection<Integer> codOpciones) {
		StringBuilder hql = new StringBuilder("from Setopcgrupo og ");
		hql.append("where og.id.codGrupo = :codGrupo ");
		hql.append("and og.id.codOpcion not in (:opciones)");
		Query query = super.getSession().createQuery(hql.toString());
		query.setInteger("codGrupo", codGrupo);
		query.setParameterList("opciones", codOpciones, new IntegerType());
		return query.list();
	}
}
