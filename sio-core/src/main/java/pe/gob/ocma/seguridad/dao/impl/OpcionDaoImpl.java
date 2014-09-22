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
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.seguridad.Setopcion;
import pe.gob.ocma.seguridad.dao.OpcionDao;
import pe.gob.ocma.seguridad.dto.MenuModel;

/**
 * Clase para manejar las opciones del menú desde base de datos.
 * @author César Altamirano Menor
 * 04/09/2013 11:30:04
 */
@Repository("opcionDao")
public class OpcionDaoImpl extends BaseHibernateDaoImpl<Setopcion, Integer> implements OpcionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public MenuModel buscarPadreAplicacion(short codAplica) {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url ");
        hql.append("from Setopcion o ");
        hql.append("where o.opcPadre = :opcPadre ");
        hql.append("and o.setaplica.codAplica = :codAplica");
        Query query = super.getSession().createQuery(hql.toString());
        query.setInteger("opcPadre", 0);
        query.setInteger("codAplica", codAplica);
        return (MenuModel) query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuModel> buscarOpcionesAplicacion(short codAplica) {
		StringBuilder hql = new StringBuilder();
        hql.append("select o.codOpcion as menuId, o.opcPadre as padreId, ");
        hql.append("o.descripcion as nombre, o.url as url, o.tipo as tipo ");
        hql.append("from Setopcion o ");
        hql.append("where o.opcPadre != :opcPadre ");
        hql.append("and o.setaplica.codAplica = :codAplica");
        Query query = super.getSession().createQuery(hql.toString());
        query.setInteger("opcPadre", 0);
        query.setInteger("codAplica", codAplica);
        return query.setResultTransformer(Transformers.aliasToBean(MenuModel.class)).list();
	}
}
