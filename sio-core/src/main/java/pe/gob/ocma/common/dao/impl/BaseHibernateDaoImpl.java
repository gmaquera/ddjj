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
 * Ing. Orlando Peña Mora - Jefe de Sistemas
 *
 */
package pe.gob.ocma.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.ScalarReturn;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.ocma.auditoria.dao.AuditoriaDao;
import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.common.dao.util.FilterCriteria;
import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.util.Tablas;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.generico.Getcorrelmae;

/**
 * Clase base de todas las clases que resuelven el acceso a datos de la
 * aplicación.
 * 
 * @author César Altamirano Menor 06/05/2013 11:26:53
 */
public abstract class BaseHibernateDaoImpl<T, Id extends Serializable>
		implements BaseHibernateDao<T, Id>, Serializable {

	private static final long serialVersionUID = 1840191310663868740L;

	@Autowired
	protected SessionFactory sessionFactory;
	private Session session;
	private Class<T> persistentClass;

	@Autowired
	private AuditoriaDao auDao;

	@SuppressWarnings("unchecked")
	public BaseHibernateDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Id id) {
		return (T) this.getSession().load(this.persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Id id) {
		return (T) this.getSession().get(this.persistentClass, id);
	}

	@Override
	public void save(T obj) {
		this.getSession().save(obj);
		this.getSession().flush();
	}

	@Override
	public void update(T obj) {
		this.getSession().update(obj);
		this.getSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T obj) {
		return (T) this.getSession().merge(obj);
	}

	@Override
	public void delete(T obj) {
		this.getSession().delete(obj);
		this.getSession().flush();
	}

	@Override
	public T refresh(T obj) {
		this.getSession().refresh(obj);
		return obj;
	}

	@Override
	public void saveOrUpdate(T obj) {
		this.getSession().saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searAll() {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		Query query = getSession().createQuery(hql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> search(Integer first, Integer max) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		Query query = getSession().createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchOrder(SortCriteria sort) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		hql.append(" p");
		if (sort != null) {
			hql.append(" ");
			hql.append(sort.getHQL());
		}
		Query query = this.getSession().createQuery(hql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchFilter(FilterCriteria filter) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		hql.append(" p");
		if (filter != null) {
			hql.append(" ");
			hql.append(filter.getHQL());
		}
		Query query = this.getSession().createQuery(hql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchFilterLimit(FilterCriteria filter, int maxResults) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		hql.append(" p");
		if (filter != null) {
			hql.append(" ");
			hql.append(filter.getHQL());
		}
		Query query = this.getSession().createQuery(hql.toString());
		query.setMaxResults(maxResults);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchFilterAndOrder(FilterCriteria filter, SortCriteria sort) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(persistentClass.getName());
		hql.append(" p");
		if (filter != null) {
			hql.append(" ");
			hql.append(filter.getHQL());
		}
		if (sort != null) {
			hql.append(" ");
			hql.append(sort.getHQL());
		}
		Query query = this.getSession().createQuery(hql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WrappedData<T> searchFilterAndOrderPaginator(
			Map<String, String> colFilters,
			Map<String, Serializable> maExtFilters, SortCriteria sort,
			final int first, final int pageSize) {
		StringBuilder hqlConditions = new StringBuilder(
				persistentClass.getName());
		hqlConditions.append(" p");
		String f = this.getHQLFilters(colFilters, maExtFilters);
		if (f != null)
			hqlConditions.append(f);

		StringBuilder hqlRowCount = new StringBuilder("select count(*) from ");
		hqlRowCount.append(hqlConditions.toString());
		Query queryRowCount = this.getSession().createQuery(
				hqlRowCount.toString());
		Long aux = (Long) queryRowCount.uniqueResult();
		long size = 0;
		if (aux != null)
			size = aux;

		StringBuilder hql = new StringBuilder("from ");
		hql.append(hqlConditions.toString());
		if (sort != null) {
			hql.append(" ");
			hql.append(sort.getHQL());
		}
		Query query = this.getSession().createQuery(hql.toString());
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		List<T> data = query.list();
		// AUDITORIA FIXME
		//auDao.guardarConsulta(Tablas.SETUSUARIO, null, query.getQueryString());
		return new WrappedData<T>(data, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchUnique(Class<T> clazz, String field, Serializable data) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(clazz.getSimpleName());
		hql.append(" ob where ob.");
		hql.append(field);
		if (data instanceof String) {
			hql.append("='");
			hql.append(data.toString());
			hql.append("'");
		} else if (data instanceof Integer) {
			hql.append("=");
			hql.append(((Integer) data).intValue());
		} else if (data instanceof Short) {
			hql.append("=");
			hql.append(((Short) data).shortValue());			
		} else if (data instanceof Long) {
			hql.append("=");
			hql.append(((Long) data).longValue());
		} else if (data instanceof Boolean) {
			hql.append("=");
			hql.append(((Boolean) data).booleanValue());
		} else {
			throw new IllegalArgumentException(
					"El tipo de dato no es soportado.");
		}
		Query query = this.getSession().createQuery(hql.toString());
		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T searchUnique(Class<T> clazz, String field, Serializable data,
			boolean habilitado) {
		StringBuilder hql = new StringBuilder("from ");
		hql.append(clazz.getSimpleName());
		hql.append(" ob where ob.");
		hql.append(field);

		if (data instanceof String) {
			hql.append("='");
			hql.append(data.toString());
			hql.append("'");
		} else if (data instanceof Integer) {
			hql.append("=");
			hql.append(((Integer) data).intValue());
		} else if (data instanceof Boolean) {
			hql.append("=");
			hql.append(((Boolean) data).booleanValue());
		} else {
			throw new IllegalArgumentException(
					"El tipo de dato no es soportado.");
		}
		hql.append(" and ob.habilitado=").append(habilitado);
		Query query = this.getSession().createQuery(hql.toString());
		return (T) query.uniqueResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List searchByNativeQuery(String nativeQuery, Map params,
			Class<?> obj, ResultTransformer rt, ScalarReturn scalar) {
		SQLQuery query = getSession().createSQLQuery(nativeQuery);
		if (scalar != null) {
			query.addScalar(scalar.getColumnAlias(), scalar.getType());
		}
		if (rt != null) {
			query.setResultTransformer(rt);
		}
		if (obj != null) {
			query.addEntity(obj);
		} else {
			query.addEntity(persistentClass);
		}

		Set<Map.Entry> rawParameters = params.entrySet();
		for (Map.Entry entry : rawParameters) {
			query.setParameter(entry.getKey().toString(), entry.getValue());
		}
		return query.list();
	}

	@Override
	public long searchNextCorrelMae(String nomTabla) {
		StringBuilder hql = new StringBuilder("from Getcorrelmae ");
		hql.append("where nomTabla = :nomTabla");
		Query query = this.getSession().createQuery(hql.toString());
		query.setParameter("nomTabla", nomTabla);
		Getcorrelmae cm = (Getcorrelmae) query.uniqueResult();
		if (cm == null) {
			if (nomTabla == Tablas.GETCORRELMAE) {
				cm = new Getcorrelmae();
				cm.setCodCorrel((short) 1);
				cm.setNomTabla(Tablas.GETCORRELMAE);
				cm.setCorrelativo(2);
				this.getSession().save(cm);
				return 2;
			} else {
				cm = new Getcorrelmae();
				cm.setCodCorrel((short) searchNextCorrelMae(Tablas.GETCORRELMAE));
				cm.setNomTabla(nomTabla);
				cm.setCorrelativo(1);
				this.getSession().save(cm);
				return 1;
			}
		} else {
			long correlativo = cm.getCorrelativo() + 1;
			cm.setCorrelativo(correlativo);
			this.getSession().update(cm);
			this.getSession().flush();
			return correlativo;
		}
	}

	@Override
	public long searchNextCorrelMaeMerge(String nomTabla) {
		StringBuilder hql = new StringBuilder("from Getcorrelmae ");
		hql.append("where nomTabla = :nomTabla");
		Query query = this.getSession().createQuery(hql.toString());
		query.setParameter("nomTabla", nomTabla);
		Getcorrelmae cm = (Getcorrelmae) query.uniqueResult();
		if (cm == null) {
			if (nomTabla == Tablas.GETCORRELMAE) {
				cm = new Getcorrelmae();
				cm.setCodCorrel((short) 1);
				cm.setNomTabla(Tablas.GETCORRELMAE);
				cm.setCorrelativo(2);
				this.getSession().save(cm);
				return 2;
			} else {
				cm = new Getcorrelmae();
				cm.setCodCorrel((short) searchNextCorrelMae(Tablas.GETCORRELMAE));
				cm.setNomTabla(nomTabla);
				cm.setCorrelativo(1);
				this.getSession().merge(cm);
				return 1;
			}

		} else {
			long correlativo = cm.getCorrelativo() + 1;
			cm.setCorrelativo(correlativo);
			this.getSession().merge(cm);
			this.getSession().flush();
			return correlativo;
		}
	}	

	public String getHQLFilters(Map<String, String> colFilters,
			Map<String, Serializable> extFilters) {
		StringBuilder hql = null;
		int filterCount = 0;
		if (colFilters != null && !colFilters.isEmpty()) {
			hql = new StringBuilder(" where");
			Iterator<Entry<String, String>> it = colFilters.entrySet()
					.iterator();
			while (it.hasNext()) {
				Entry<String, String> entry = it.next();
				if (entry != null && entry.getValue() != null
						&& !"".equals(entry.getValue())) {
					Field f;
					try {
						if (filterCount != 0)
							hql.append(" and");
						if (entry.getKey().contains(".")) {
							hql.append(" p.").append(entry.getKey());
							hql.append(" like '%").append(entry.getValue())
									.append("%' ");
						} else {
							f = persistentClass
									.getDeclaredField(entry.getKey());
							if (f.getType().isAssignableFrom(String.class)) {
								hql.append(" lower(p.").append(entry.getKey())
										.append(")");
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (f.getType()
									.isAssignableFrom(Short.class)
									|| f.getType()
											.isAssignableFrom(short.class)) {
								hql.append(" str(p.").append(entry.getKey())
										.append(")");
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (f.getType().isAssignableFrom(
									Integer.class)
									|| f.getType().isAssignableFrom(int.class)) {
								hql.append(" str(p.").append(entry.getKey())
										.append(")");
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (f.getType().isAssignableFrom(Long.class)
									|| f.getType().isAssignableFrom(long.class)) {
								hql.append(" str(p.").append(entry.getKey())
										.append(")");
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (f.getType().isAssignableFrom(Date.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (f.getType().isAssignableFrom(
									Character.class)
									|| f.getType().isAssignableFrom(char.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("='").append(entry.getValue())
										.append("' ");
							} else if (f.getType().isAssignableFrom(
									Boolean.class)
									|| f.getType().isAssignableFrom(
											boolean.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							}
						}
						filterCount++;
					} catch (NoSuchFieldException ex) {
					} catch (Exception ex) {
					}
				}
			}
		}
		if (extFilters != null && !extFilters.isEmpty()) {
			if (hql == null || hql.toString().isEmpty()) {
				hql = new StringBuilder(" where");
			}
			Iterator<Entry<String, Serializable>> it = extFilters.entrySet()
					.iterator();
			while (it.hasNext()) {
				Entry<String, Serializable> entry = it.next();
				if (entry != null && entry.getValue() != null
						&& !"".equals(entry.getValue())) {
					Field f;
					try {
						if (filterCount != 0)
							hql.append(" and");
						if (entry.getKey().contains(".")) {
							if (entry.getValue() instanceof String) {
								hql.append(" p.").append(entry.getKey());
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (entry.getValue() instanceof Short) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (entry.getValue() instanceof Integer) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (entry.getValue() instanceof Date) {
								Date fecha = (Date) entry.getValue();
								Calendar cal = Calendar.getInstance();
								cal.setTime(fecha);
								int year = cal.get(Calendar.YEAR);
								int month = cal.get(Calendar.MONTH) + 1;
								int day = cal.get(Calendar.DAY_OF_MONTH);
								hql.append(" year(p.").append(entry.getKey())
										.append(") = ").append(year);
								hql.append(" and month(p.")
										.append(entry.getKey()).append(") = ")
										.append(month);
								hql.append(" and day(p.")
										.append(entry.getKey()).append(") = ")
										.append(day);
							} else {
								throw new IllegalArgumentException(
										"Agregar tipo de dato en la restricción del where");
							}
						} else {
							f = persistentClass
									.getDeclaredField(entry.getKey());
							if (f.getType().isAssignableFrom(String.class)) {
								hql.append(" lower(p.").append(entry.getKey())
										.append(")");
								hql.append(" like '%").append(entry.getValue())
										.append("%' ");
							} else if (f.getType()
									.isAssignableFrom(Short.class)
									|| f.getType()
											.isAssignableFrom(short.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (f.getType().isAssignableFrom(
									Integer.class)
									|| f.getType().isAssignableFrom(int.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (f.getType().isAssignableFrom(Long.class)
									|| f.getType().isAssignableFrom(long.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							} else if (f.getType().isAssignableFrom(Date.class)) {
								Date fecha = (Date) entry.getValue();
								Calendar cal = Calendar.getInstance();
								cal.setTime(fecha);
								int year = cal.get(Calendar.YEAR);
								int month = cal.get(Calendar.MONTH) + 1;
								int day = cal.get(Calendar.DAY_OF_MONTH);
								hql.append(" year(p.").append(entry.getKey())
										.append(") = ").append(year);
								hql.append(" and month(p.")
										.append(entry.getKey()).append(") = ")
										.append(month);
								hql.append(" and day(p.")
										.append(entry.getKey()).append(") = ")
										.append(day);
							} else if (f.getType().isAssignableFrom(
									Character.class)
									|| f.getType().isAssignableFrom(char.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("='").append(entry.getValue())
										.append("' ");
							} else if (f.getType().isAssignableFrom(
									Boolean.class)
									|| f.getType().isAssignableFrom(
											boolean.class)) {
								hql.append(" p.").append(entry.getKey())
										.append("=").append(entry.getValue());
							}
						}
						filterCount++;
					} catch (NoSuchFieldException ex) {
					} catch (Exception ex) {
					}
				}
			}
		}
		if (hql == null)
			return null;
		return hql.toString();
	}

	protected Session getSession() {
		if (session == null || !session.isOpen()) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}
}
