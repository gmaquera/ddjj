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
package pe.gob.ocma.auditoria.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasTablaModel;
import pe.gob.ocma.auditoria.dto.AuditoriaModel;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.common.util.ConstanteCore;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.entities.auditoria.Aurtraza;
import pe.gob.ocma.entities.generico.Getcorrelmae;
import pe.gob.ocma.entities.generico.Gettabla;
import pe.gob.ocma.entities.seguridad.Setusuario;

/**
 * Clase para menejar el acceso a datos a la tabla de auditoría
 * @author César Altamirano Menor
 * 26/09/2013 15:14:27
 */
@Repository("auditoriaDao")
public class AuditoriaDaoImpl implements AuditoriaDao, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
    protected SessionFactory sessionFactory;

	@Override
	public void guardarConsulta(String nomTabAuditada, String parametros, String queryConsulta) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebAuthenticationDetails wad = (WebAuthenticationDetails) auth.getDetails();
		
		Setusuario usu = (Setusuario) sessionFactory.getCurrentSession().load(Setusuario.class, auth.getName());
		StringBuilder usuario = new StringBuilder();
		usuario.append(usu.getPetpernatu().getApellido());
		usuario.append(" ");
		usuario.append(usu.getPetpernatu().getNombre());
		StringBuilder hql = new StringBuilder("from Gettabla tb ");
		hql.append("where tb.nomTabla = :nomTabla");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabAuditada);
		
		Gettabla tab = (Gettabla) query.uniqueResult();
		if(tab == null) {
			long correlTabla = searchNextCorrelMae(Tablas.GETTABLA);
			tab = new Gettabla();
			tab.setCodTabla((short) correlTabla);
			tab.setNomTabla(nomTabAuditada);
			sessionFactory.getCurrentSession().save(tab);
			sessionFactory.getCurrentSession().flush();
		}
		Aurtraza at = new Aurtraza();
		at.setCodTraza(searchNextCorrelMae(Tablas.AURTRAZA));
		at.setCodUsuario(auth.getName());
		at.setUsuario(usuario.toString());
		at.setOperacion(ConstanteCore.ACCION_CONSULTA);
		at.setCodTabla(tab.getCodTabla());
		at.setNomPk(ConstanteCore.EMPTY);
		at.setValorPk(ConstanteCore.EMPTY);
		at.setCampos(parametros);
		at.setDatos(queryConsulta);
		at.setFecha(Calendar.getInstance().getTime());
		at.setTerminal(wad.getRemoteAddress());
		sessionFactory.getCurrentSession().save(at);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void guardarCreacion(String nomTabAuditada, Auditoria au, String nomPk, String valorPk) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebAuthenticationDetails wad = (WebAuthenticationDetails) auth.getDetails();
		
		Setusuario usu = (Setusuario) sessionFactory.getCurrentSession().load(Setusuario.class, auth.getName());
		StringBuilder usuario = new StringBuilder();
		usuario.append(usu.getPetpernatu().getApellido());
		usuario.append(" ");
		usuario.append(usu.getPetpernatu().getNombre());
		StringBuilder hql = new StringBuilder("from Gettabla tb ");
		hql.append("where tb.nomTabla = :nomTabla");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabAuditada);
		Gettabla tab = (Gettabla) query.uniqueResult();
		if(tab == null) {
			long correlTabla = searchNextCorrelMae(Tablas.GETTABLA);
			tab = new Gettabla();
			tab.setCodTabla((short) correlTabla);
			tab.setNomTabla(nomTabAuditada);
			sessionFactory.getCurrentSession().save(tab);
			sessionFactory.getCurrentSession().flush();
		}
		Aurtraza at = new Aurtraza();
		at.setCodTraza(searchNextCorrelMae(Tablas.AURTRAZA));
		at.setCodUsuario(auth.getName());
		at.setUsuario(usuario.toString());
		at.setOperacion(ConstanteCore.ACCION_CREACION);
		at.setCodTabla(tab.getCodTabla());
		at.setNomPk(nomPk);
		at.setValorPk(valorPk);
		at.setCampos(au.obtenerCampos());
		at.setDatos(au.obtenerDatos());
		at.setFecha(Calendar.getInstance().getTime());
		at.setTerminal(wad.getRemoteAddress());
		sessionFactory.getCurrentSession().save(at);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void guardarActualizacion(String nomTabAuditada, Auditoria au, String nomPk, String valorPk) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebAuthenticationDetails wad = (WebAuthenticationDetails) auth.getDetails();
		
		Setusuario usu = (Setusuario) sessionFactory.getCurrentSession().load(Setusuario.class, auth.getName());
		StringBuilder usuario = new StringBuilder();
		usuario.append(usu.getPetpernatu().getApellido());
		usuario.append(" ");
		usuario.append(usu.getPetpernatu().getNombre());
		StringBuilder hql = new StringBuilder("from Gettabla tb ");
		hql.append("where tb.nomTabla = :nomTabla");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabAuditada);
		Gettabla tab = (Gettabla) query.uniqueResult();
		if(tab == null) {
			long correlTabla = searchNextCorrelMae(Tablas.GETTABLA);
			tab = new Gettabla();
			tab.setCodTabla((short) correlTabla);
			tab.setNomTabla(nomTabAuditada);
			sessionFactory.getCurrentSession().save(tab);
			sessionFactory.getCurrentSession().flush();
		}
		Aurtraza at = new Aurtraza();
    	at.setCodTraza(searchNextCorrelMae(Tablas.AURTRAZA));
    	at.setCodUsuario(auth.getName());
    	at.setUsuario(usuario.toString());
    	at.setOperacion(ConstanteCore.ACCION_ACTUALIZACION);
    	at.setCodTabla(tab.getCodTabla());
    	at.setNomPk(nomPk);
    	at.setValorPk(valorPk);
    	at.setCampos(au.obtenerCampos());
    	at.setDatos(au.obtenerDatos());
    	at.setFecha(Calendar.getInstance().getTime());
    	at.setTerminal(wad.getRemoteAddress());
    	sessionFactory.getCurrentSession().save(at);
    	sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void guardarEliminacion(String nomTabAuditada, String nomPk, String valorPk) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails wad = (WebAuthenticationDetails) auth.getDetails();
        
        Setusuario usu = (Setusuario) sessionFactory.getCurrentSession().load(Setusuario.class, auth.getName());
		StringBuilder usuario = new StringBuilder();
		usuario.append(usu.getPetpernatu().getApellido());
		usuario.append(" ");
		usuario.append(usu.getPetpernatu().getNombre());
		StringBuilder hql = new StringBuilder("from Gettabla tb ");
		hql.append("where tb.nomTabla = :nomTabla");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("nomTabla", nomTabAuditada);
		Gettabla tab = (Gettabla) query.uniqueResult();
		if(tab == null) {
			long correlTabla = searchNextCorrelMae(Tablas.GETTABLA);
			tab = new Gettabla();
			tab.setCodTabla((short) correlTabla);
			tab.setNomTabla(Tablas.GETCORRELMAE);
			sessionFactory.getCurrentSession().save(tab);
			sessionFactory.getCurrentSession().flush();
		}
		Aurtraza at = new Aurtraza();
		at.setCodTraza(searchNextCorrelMae(Tablas.AURTRAZA));
		at.setCodUsuario(auth.getName());
		at.setUsuario(usuario.toString());
		at.setOperacion(ConstanteCore.ACCION_ELIMINACION);
		at.setCodTabla(tab.getCodTabla());
		at.setNomPk(nomPk);
		at.setValorPk(valorPk);
		at.setCampos(null);
		at.setDatos(null);
		at.setFecha(Calendar.getInstance().getTime());
		at.setTerminal(wad.getRemoteAddress());
		sessionFactory.getCurrentSession().save(at);
		sessionFactory.getCurrentSession().flush();
	}
	
	public long searchNextCorrelMae(String nomTabla){
    	StringBuilder hql = new StringBuilder("from Getcorrelmae ");
    	hql.append("where nomTabla = :nomTabla");
    	Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
    	query.setParameter("nomTabla", nomTabla);
    	Getcorrelmae cm = (Getcorrelmae) query.uniqueResult();
		if(cm == null){
			if(nomTabla == Tablas.GETCORRELMAE){
				cm = new Getcorrelmae();
				cm.setCodCorrel((short)1);
				cm.setNomTabla(Tablas.GETCORRELMAE);
				cm.setCorrelativo(2);
				sessionFactory.getCurrentSession().save(cm);
				sessionFactory.getCurrentSession().flush();
				return 2;
			}else{
				cm = new Getcorrelmae();
				cm.setCodCorrel((short)searchNextCorrelMae(Tablas.GETCORRELMAE));
				cm.setNomTabla(nomTabla);
				cm.setCorrelativo(1);
				sessionFactory.getCurrentSession().save(cm);
				sessionFactory.getCurrentSession().flush();
				return 1;
			}
			
		} else {
    		long correlativo = cm.getCorrelativo() + 1;
    		cm.setCorrelativo(correlativo);
    		sessionFactory.getCurrentSession().update(cm);
    		sessionFactory.getCurrentSession().flush();
        	return correlativo;
    	}
    }

	@SuppressWarnings("unchecked")
	@Override
	public WrappedData<AuditoriaFechasModel> buscarAuditoria(Date fechaInicio, Date fechaFin, int first, int pageSize) {
		StringBuilder hqlRowCount = new StringBuilder("select count(*) ");
		hqlRowCount.append("from Aurtraza a ");
		hqlRowCount.append("inner join a.gettabla t ");
		hqlRowCount.append("where a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		Query queryRowCount = sessionFactory.getCurrentSession().createQuery(hqlRowCount.toString());
		queryRowCount.setTimestamp("fecIni", fechaInicio);
		queryRowCount.setTimestamp("fecFin", fechaFin);
		Long aux = (Long) queryRowCount.uniqueResult();
		long size = 0;
		if(aux != null) size = aux;
		
		StringBuilder hql = new StringBuilder();
		hql.append("select a.codTraza as codTraza, t.nomTabla as nomTabla, a.operacion as desOperacion, a.usuario as usuario, ");
		hql.append("a.valorPk as clavePrimaria, a.campos as campos, a.datos as datos, a.fecha as fecha ");
		hql.append("from Aurtraza a ");
		hql.append("inner join a.gettabla t ");
		hql.append("where a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		hql.append("order by a.fecha desc");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setTimestamp("fecIni", fechaInicio);
		query.setTimestamp("fecFin", fechaFin);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<AuditoriaFechasModel> data = query.setResultTransformer(Transformers.aliasToBean(AuditoriaFechasModel.class)).list();
		return new WrappedData<AuditoriaFechasModel>(data, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AuditoriaModel buscarCamposCabecera(short codTabla) {
		StringBuilder hql = new StringBuilder();
		hql.append("select a.campos as campos from Aurtraza a ");
		hql.append("where a.codTabla = :codTabla ");
		hql.append("and a.datos like '%|%'");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setShort("codTabla", codTabla);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<AuditoriaModel> lista = query.setResultTransformer(Transformers.aliasToBean(AuditoriaModel.class)).list();
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(short codTabla, Date fechaInicio, Date fechaFin, 
			int numColumnas, int first, int pageSize) {
		StringBuilder hqlRowCount = new StringBuilder("select count(*) ");
		hqlRowCount.append("from Aurtraza a ");
		hqlRowCount.append("inner join a.gettabla t ");
		hqlRowCount.append("where a.codTabla = :codTabla ");
		hqlRowCount.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		Query queryRowCount = sessionFactory.getCurrentSession().createQuery(hqlRowCount.toString());
		queryRowCount.setShort("codTabla", codTabla);
		queryRowCount.setTimestamp("fecIni", fechaInicio);
		queryRowCount.setTimestamp("fecFin", fechaFin);
		Long aux = (Long) queryRowCount.uniqueResult();
		long size = 0;
		if(aux != null) size = aux;
		
		List<AuditoriaFechasTablaModel> data = new ArrayList<AuditoriaFechasTablaModel>();
		StringBuilder hql = new StringBuilder();
		hql.append("select a.codTraza as codTraza, t.nomTabla as nomTabla, a.operacion as desOperacion, a.usuario as usuario, ");
		hql.append("a.valorPk as clavePrimaria, a.campos as campos, a.datos as datos, a.fecha as fecha ");
		hql.append("from Aurtraza a ");
		hql.append("inner join a.gettabla t ");
		hql.append("where a.codTabla = :codTabla ");
		hql.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		hql.append("order by a.fecha desc");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setShort("codTabla", codTabla);
		query.setTimestamp("fecIni", fechaInicio);
		query.setTimestamp("fecFin", fechaFin);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<Object[]> lista = query.list();
		for(Object[] o : lista) {
			long codTraza = Long.parseLong(o[0].toString());
			//String nomTabla = o[1].toString();
			String operacion = o[2].toString();
			String usuario = o[3].toString();
			String valorPk = o[4] == null ? "" : o[4].toString();
			//String campos = o[5].toString();
			String datos = o[6] == null ? "" : o[6].toString();
			Date fecha = (Date) o[7];
			
			AuditoriaFechasTablaModel a = new AuditoriaFechasTablaModel();
			a.setCodTraza(codTraza);
			a.setFecha(fecha);
			a.setUsuario(usuario);
			a.setDesOperacion(operacion);
			a.setClavePrimaria(valorPk);
			
			String[] rows = null;
			if(datos != null) {
				 rows = datos.split("\\|");
				 a.setDatos(rows);
				 if(rows.length == 1) {
					 a.setColspan(numColumnas - 4);
				 } else {
					 a.setColspan(0);
				 }
			} else {
				a.setColspan(numColumnas - 4);
			}
			data.add(a);
		}
		return new WrappedData<AuditoriaFechasTablaModel>(data, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public WrappedData<AuditoriaFechasModel> buscarAuditoria(String codUsuario, Date fechaInicio, Date fechaFin, int first, int pageSize) {
		StringBuilder hqlRowCount = new StringBuilder("select count(*) ");
		hqlRowCount.append("from Aurtraza a ");
		hqlRowCount.append("inner join a.gettabla t ");
		hqlRowCount.append("where a.codUsuario = :codUsuario ");
		hqlRowCount.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		Query queryRowCount = sessionFactory.getCurrentSession().createQuery(hqlRowCount.toString());
		queryRowCount.setString("codUsuario", codUsuario);
		queryRowCount.setTimestamp("fecIni", fechaInicio);
		queryRowCount.setTimestamp("fecFin", fechaFin);
		Long aux = (Long) queryRowCount.uniqueResult();
		long size = 0;
		if(aux != null) size = aux;
		
		StringBuilder hql = new StringBuilder();
		hql.append("select a.codTraza as codTraza, t.nomTabla as nomTabla, a.operacion as desOperacion, a.usuario as usuario, ");
		hql.append("a.valorPk as clavePrimaria, a.campos as campos, a.datos as datos, a.fecha as fecha ");
		hql.append("from Aurtraza a ");
		hql.append("inner join a.gettabla t ");
		hql.append("where a.codUsuario = :codUsuario ");
		hql.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		hql.append("order by a.fecha desc");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("codUsuario", codUsuario);
		query.setTimestamp("fecIni", fechaInicio);
		query.setTimestamp("fecFin", fechaFin);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<AuditoriaFechasModel> data = query.setResultTransformer(Transformers.aliasToBean(AuditoriaFechasModel.class)).list();
		return new WrappedData<AuditoriaFechasModel>(data, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(
			String codUsuario, short codTabla, Date fechaInicio, Date fechaFin,
			int numColumnas, int first, int pageSize) {
		StringBuilder hqlRowCount = new StringBuilder("select count(*) ");
		hqlRowCount.append("from Aurtraza a ");
		hqlRowCount.append("inner join a.gettabla t ");
		hqlRowCount.append("where a.codUsuario = :codUsuario ");
		hqlRowCount.append("and a.codTabla = :codTabla ");
		hqlRowCount.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		Query queryRowCount = sessionFactory.getCurrentSession().createQuery(hqlRowCount.toString());
		queryRowCount.setString("codUsuario", codUsuario);
		queryRowCount.setShort("codTabla", codTabla);
		queryRowCount.setTimestamp("fecIni", fechaInicio);
		queryRowCount.setTimestamp("fecFin", fechaFin);
		Long aux = (Long) queryRowCount.uniqueResult();
		long size = 0;
		if(aux != null) size = aux;
		
		List<AuditoriaFechasTablaModel> data = new ArrayList<AuditoriaFechasTablaModel>();
		StringBuilder hql = new StringBuilder();
		hql.append("select a.codTraza as codTraza, t.nomTabla as nomTabla, a.operacion as desOperacion, a.usuario as usuario, ");
		hql.append("a.valorPk as clavePrimaria, a.campos as campos, a.datos as datos, a.fecha as fecha ");
		hql.append("from Aurtraza a ");
		hql.append("inner join a.gettabla t ");
		hql.append("where a.codUsuario = :codUsuario ");
		hql.append("and a.codTabla = :codTabla ");
		hql.append("and a.fecha  >= :fecIni and a.fecha <= :fecFin ");
		hql.append("order by a.fecha desc");
		Query query = sessionFactory.getCurrentSession().createQuery(hql.toString());
		query.setString("codUsuario", codUsuario);
		query.setShort("codTabla", codTabla);
		query.setTimestamp("fecIni", fechaInicio);
		query.setTimestamp("fecFin", fechaFin);
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<Object[]> lista = query.list();
		for(Object[] o : lista) {
			long codTraza = Long.parseLong(o[0].toString());
			//String nomTabla = o[1].toString();
			String operacion = o[2].toString();
			String usuario = o[3].toString();
			String valorPk = o[4] == null ? "" : o[4].toString();
			//String campos = o[5].toString();
			String datos = o[6] == null ? "" : o[6].toString();
			Date fecha = (Date) o[7];
			
			AuditoriaFechasTablaModel a = new AuditoriaFechasTablaModel();
			a.setCodTraza(codTraza);
			a.setFecha(fecha);
			a.setUsuario(usuario);
			a.setDesOperacion(operacion);
			a.setClavePrimaria(valorPk);
			
			String[] rows = null;
			if(datos != null) {
				 rows = datos.split("\\|");
				 a.setDatos(rows);
				 if(rows.length == 1) {
					 a.setColspan(numColumnas - 4);
				 } else {
					 a.setColspan(0);
				 }
			} else {
				a.setColspan(numColumnas - 4);
			}
			data.add(a);
		}
		return new WrappedData<AuditoriaFechasTablaModel>(data, size);
	}
}
