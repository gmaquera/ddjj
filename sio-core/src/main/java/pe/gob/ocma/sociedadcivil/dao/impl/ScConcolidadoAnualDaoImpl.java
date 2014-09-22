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
package pe.gob.ocma.sociedadcivil.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.oc_ocma.Socmovimiento;
import pe.gob.ocma.sociedadcivil.dao.ScConcolidadoAnualDao;
import pe.gob.ocma.sociedadcivil.dto.ScConcolidadoAnualModel;
import pe.gob.ocma.sociedadcivil.dto.ScListaAnioModel;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas
 * 18/03/2014 09:32:49
 */
@Repository("scConcolidadoAnualDao")
public class ScConcolidadoAnualDaoImpl extends BaseHibernateDaoImpl<Socmovimiento, Integer> implements ScConcolidadoAnualDao,Serializable{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<ScConcolidadoAnualModel> listaConsolidadoAnual(int anio) {
		StringBuilder sql = new StringBuilder( "select case when Mes = 'January' then 'Enero' ");
		sql.append("when Mes = 'February' then 'Febrero' ");
		sql.append("when Mes = 'March' then 'Marzo' "); 
		sql.append("when Mes = 'April' then 'Abril' "); 
		sql.append("when Mes = 'May' then 'Mayo' ");
		sql.append("when Mes = 'June' then 'Junio' ");
		sql.append("when Mes = 'July' then 'Julio' ");
		sql.append("when Mes = 'August' then 'Agosto' ");
		sql.append("when Mes = 'September' then 'Setiembre' "); 
		sql.append("when Mes = 'October' then 'Octubre' ");
		sql.append("when Mes = 'November' then 'Noviembre' ");
		sql.append("when Mes = 'December' then 'Diciembre' ");
		sql.append("End as Mes, ");
		sql.append("case when Mes = 'Enero' then 1 "); 
		sql.append("when Mes = 'Febrero' then 2 ");
		sql.append("when Mes = 'Marzo' then 3 ");
		sql.append("when Mes = 'Abril' then 4 ");
		sql.append("when Mes = 'Mayo' then 5 ");
		sql.append("when Mes = 'Junio' then 6 ");
		sql.append("when Mes = 'Julio' then 7 ");
		sql.append("when Mes = 'Agosto' then 8 ");
		sql.append("when Mes = 'Setiembre' then 9 ");
		sql.append("when Mes = 'Octubre' then 10 ");
		sql.append("when Mes = 'Noviembre' then 11 ");
		sql.append("when Mes = 'Diciembre' then 12 ");
		sql.append("End as Numero, ");
				
		sql.append("sum(Observacion) Observacion, sum(Apersonamiento) Apersonamiento, sum(ApersObservacion) ApersObservacion, sum(ApersOdecma) ApersOdecma, sum(Apelacion) Apelacion, sum(Consentido) Consentido, sum(QuejaDerecho) QuejaDerecho, sum(DocumentoMeroTra) DocumentoMeroTra, sum(Nulidad) Nulidad, sum(ApersApelacion) ApersApelacion,sum(TotalMeses) TotalMeses "); 
		sql.append("from (select  monthname(sc.FECHA_IN) Mes, count(*) TotalMeses, ");
		sql.append("case when sc.cod_tiproc = 1 then count(sc.FECHA_IN) else 0 end Observacion, "); 
		sql.append("case when sc.cod_tiproc = 2 then count(sc.FECHA_IN) else 0 end Apersonamiento, "); 
		sql.append("case when sc.cod_tiproc = 3 then count(sc.FECHA_IN) else 0 end ApersObservacion, ");
		sql.append("case when sc.cod_tiproc = 4 then count(sc.FECHA_IN) else 0 end ApersOdecma, ");
		sql.append("case when sc.cod_tiproc = 5 then count(sc.FECHA_IN) else 0 end Apelacion, ");
		sql.append("case when sc.cod_tiproc = 6 then count(sc.FECHA_IN) else 0 end Consentido, ");
		sql.append("case when sc.cod_tiproc = 7 then count(sc.FECHA_IN) else 0 end QuejaDerecho, ");
		sql.append("case when sc.cod_tiproc = 8 then count(sc.FECHA_IN) else 0 end DocumentoMeroTra, "); 
		sql.append("case when sc.cod_tiproc = 9 then count(sc.FECHA_IN) else 0 end Nulidad, ");
		sql.append("case when sc.cod_tiproc = 10 then count(sc.FECHA_IN) else 0 end ApersApelacion ");
		sql.append("from oc_ocma.SCMOVIMIENTO as sc ");
		sql.append("where year(sc.FECHA_IN)= :fecha ");
		sql.append("group by monthname(sc.FECHA_IN), sc.cod_tiproc "); 
		sql.append(") seleccionar ");
		sql.append("group by Mes ");
		sql.append("order by Numero ");
		
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setInteger("fecha", anio);
		List<ScConcolidadoAnualModel> datalist = query.setResultTransformer(Transformers.aliasToBean(ScConcolidadoAnualModel.class)).list();
		return datalist;
	}

	@Override
	public List<ScListaAnioModel> listaAnio() {
		StringBuilder hqlConditions = new StringBuilder();
		hqlConditions.append("from Socmovimiento p ");
		hqlConditions.append("order by anio ");
		StringBuilder hql = new StringBuilder("select distinct year(p.fecha_in) as anio ");	
		hql.append(hqlConditions.toString());
		Query query = this.getSession().createQuery(hql.toString());
		List<ScListaAnioModel> anio = query.setResultTransformer(Transformers.aliasToBean(ScListaAnioModel.class)).list();
		return anio;
	}

	@Override
	public List<ScListaAnioModel> listaMes() {
		StringBuilder sql = new StringBuilder("select distinct DATEPART(mm, q.FECHA_IN) as meses, "); 
		sql.append("case when monthname(q.FECHA_IN) = 'January' then 'Enero' ");
		sql.append("when monthname(q.FECHA_IN) = 'February' then 'Febrero' ");
		sql.append("when monthname(q.FECHA_IN) = 'March' then 'Marzo' ");
		sql.append("when monthname(q.FECHA_IN) = 'April' then 'Abril' ");
		sql.append("when monthname(q.FECHA_IN) = 'May' then 'Mayo' ");
		sql.append("when monthname(q.FECHA_IN) = 'June' then 'Junio' ");
		sql.append("when monthname(q.FECHA_IN) = 'July' then 'Julio' ");
		sql.append("when monthname(q.FECHA_IN) = 'August' then 'Agosto' ");
		sql.append("when monthname(q.FECHA_IN) = 'September' then 'Setiembre' ");
		sql.append("when monthname(q.FECHA_IN) = 'October' then 'Octubre' ");
		sql.append("when monthname(q.FECHA_IN) = 'November' then 'Noviembre' ");
		sql.append("when monthname(q.FECHA_IN) = 'December' then 'Diciembre' ");
		sql.append("end as descripcion ");
		sql.append("from oc_ocma.SCMOVIMIENTO q order by meses ");
		 		
		Query query = this.getSession().createSQLQuery(sql.toString());
		List<ScListaAnioModel> meses = query.setResultTransformer(Transformers.aliasToBean(ScListaAnioModel.class)).list();
		return meses;

	}

}
