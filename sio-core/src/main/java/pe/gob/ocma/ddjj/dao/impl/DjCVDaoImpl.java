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
package pe.gob.ocma.ddjj.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.ddjj.dao.DjCVDao;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionIdiomaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjCapacitacionModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpeProfesionalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaCompModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoAcademicaModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralCVModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoPersonalModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjMeritoModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjPublicacionesModel;
import pe.gob.ocma.entities.oc_ocma.DjMaster;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 19/09/2014 08:50:01
 */

@Repository("djCVDao")
public class DjCVDaoImpl extends BaseHibernateDaoImpl<DjMaster,Integer> implements DjCVDao, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoPersonalModel> lisInfoPersonalCV(String cod_personal) {

		Query query = this.getSession().createSQLQuery(
			"exec WEB_OCMA.sp_web_personal_info_2  :cod_personal")				
			.setParameter("cod_personal",cod_personal );
			//query.setString("des_ejercicio", des_ejercicio);			 
			List<DjInfoPersonalModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoPersonalModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoLaboralCVModel> lisInfoLaboralCV(String cod_personal) {


		Query query = this.getSession().createSQLQuery(
				"exec WEB_OCMA.sp_web_info_laboral_2  :cod_personal")				
				.setParameter("cod_personal",cod_personal );
			//query.setString("des_ejercicio", des_ejercicio);			 
			List<DjInfoLaboralCVModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoLaboralCVModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoAcademicaModel> lisInfoAcademicaCV(String cod_personal,String cod_academia) {
		
		StringBuilder sql = new StringBuilder("select cod_personal, cod_academica, cod_intacademica, ");
		sql.append("personal_academica.cod_cv_titulo as c_titulo, ");
		sql.append("personal_academica.cod_sector, dj_tipo_sector.des_sector,"); 
		sql.append("personal_academica.cod_cv_nivel, tabla_cv_nivel.des_cv_nivel, "); 
		sql.append("des_cv_titulo, des_especialidad, des_centro_estudios, ");
		sql.append("num_colegiatura, des_lugar, des_ano_inicio, des_ano_fin, num_semestre "); 
		sql.append("FROM web_ocma.personal_academica  ");
		sql.append("LEFT OUTER JOIN web_ocma.tabla_cv_titulo "); 
		sql.append("ON personal_academica.cod_cv_titulo = tabla_cv_titulo.cod_cv_titulo "); 
		sql.append("LEFT OUTER JOIN oc_ocma.dj_tipo_sector ");
		sql.append("ON personal_academica.cod_sector = dj_tipo_sector.cod_sector "); 
		sql.append("LEFT OUTER JOIN web_ocma.tabla_cv_nivel "); 
		sql.append("ON personal_academica.cod_cv_nivel = tabla_cv_nivel.cod_cv_nivel "); 
		sql.append("where  ");
		sql.append("cod_personal = :cod_personal And cod_academica = :cod_academia ");
		sql.append("order by des_cv_titulo DESC, des_ano_inicio desc "); 
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		query.setString("cod_academia", cod_academia);
		List<DjInfoAcademicaModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoAcademicaModel.class)).list();
		return datalist;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoAcademicaCompModel> lisInfoAcademicaComCV(String cod_personal, String cod_academia) {

		StringBuilder sql = new StringBuilder("select cod_personal, cod_academica, cod_intacademica, "); 
		sql.append("personal_academica.cod_cv_estudiosup as c_estuiosup, des_cv_estudiosup, ");
		sql.append("des_especialidad, des_centro_estudios, des_lugar, DATEFORMAT( fec_inicio, 'dd/mm/yyyy' ) as fec_inicio, DATEFORMAT( fec_fin, 'dd/mm/yyyy' ) as fec_fin, num_horas "); 
		sql.append("FROM web_ocma.personal_academica, web_ocma.tabla_cv_estudiosup  ");
		sql.append("WHERE cod_personal= :cod_personal AND COD_ACADEMICA= :cod_academia AND ");
		sql.append("personal_academica.cod_cv_estudiosup = tabla_cv_estudiosup.cod_cv_estudiosup "); 
		sql.append("ORDER BY c_estuiosup ASC, personal_academica.fec_inicio DESC ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		query.setString("cod_academia", cod_academia);
		List<DjInfoAcademicaCompModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoAcademicaCompModel.class)).list();
		return datalist;
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjCapacitacionModel> lisInfoCapacitacionCV(String cod_personal, String cod_academia) {

		StringBuilder sql = new StringBuilder("select cod_personal, cod_academica, cod_intacademica, "); 
		sql.append("personal_academica.cod_cv_actividad as c_actividad, des_cv_actividad, des_especialidad, des_centro_estudios, num_horas, "); 
		sql.append("personal_academica.cod_cv_participacion as c_participacion, des_cv_participacion, DATEFORMAT( fec_inicio, 'dd/mm/yyyy' ) as fec_inicio, DATEFORMAT( fec_fin, 'dd/mm/yyyy' ) as fec_fin "); 
		sql.append("from web_ocma.personal_academica, web_ocma.tabla_cv_actividad, web_ocma.tabla_cv_participacion  ");
		sql.append("where cod_personal= :cod_personal and COD_ACADEMICA= :cod_academia and  ");
		sql.append("personal_academica.cod_cv_actividad = tabla_cv_actividad.cod_cv_actividad and "); 
		sql.append("personal_academica.cod_cv_participacion = tabla_cv_participacion.cod_cv_participacion "); 
		sql.append("order by c_actividad ASC, personal_academica.fec_inicio DESC ,des_cv_participacion ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		query.setString("cod_academia", cod_academia);
		List<DjCapacitacionModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjCapacitacionModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjCapacitacionIdiomaModel> lisInfoCapacitacionCompCV(String cod_personal, String cod_academia) {
		
		StringBuilder sql = new StringBuilder("select  cod_personal, cod_academica, cod_intacademica, "); 
		sql.append("des_especialidad, des_centro_estudios,  ");
		sql.append("personal_academica.cod_cv_nivel_idioma, tabla_cv_nivel_idioma.des_cv_nivel_idioma "); 
		sql.append("FROM web_ocma.personal_academica,  ");
		sql.append("web_ocma.tabla_cv_nivel_idioma  ");
		sql.append("WHERE Cod_personal=  :cod_personal and cod_academica= :cod_academia and "); 
		sql.append("personal_academica.cod_cv_nivel_idioma = tabla_cv_nivel_idioma.cod_cv_nivel_idioma "); 
		sql.append("ORDER BY des_especialidad asc"); 
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		query.setString("cod_academia", cod_academia);
		List<DjCapacitacionIdiomaModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjCapacitacionIdiomaModel.class)).list();
		return datalist;
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DjExpeProfesionalModel> lisInfoExpProfesionalCV(String cod_personal, String cod_academia) {

		Query query = this.getSession().createSQLQuery(
			"exec web_ocma.sp_web_cv_experiencia  :cpersonal , :cexperiencia ")				
			.setParameter("cpersonal",cod_personal )
			.setParameter("cexperiencia",cod_academia );
			//query.setString("des_ejercicio", des_ejercicio);			 
			List<DjExpeProfesionalModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjExpeProfesionalModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjPublicacionesModel> lisInfoPublicacionesCV(String cod_personal) {

		StringBuilder sql = new StringBuilder("select cod_personal, personal_inv_pub.cod_inv_pub, cod_intinv_pub, des_inv_pub, des_titulo, des_detalle, DATEFORMAT( fec_publicacion, 'dd/mm/yyyy' ) as fec_publicacion "); 
		sql.append("from web_ocma.personal_inv_pub, web_ocma.tabla_inv_pub  ");
		sql.append("where cod_personal= :cod_personal and personal_inv_pub.cod_inv_pub = tabla_inv_pub.cod_inv_pub ");
		sql.append("order by personal_inv_pub.cod_inv_pub");  
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		List<DjPublicacionesModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjPublicacionesModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjMeritoModel> lisInfoMeritoCV(String cod_personal,String cod_academia) {
		
		StringBuilder sql = new StringBuilder("select cod_personal, cod_academica, cod_intacademica, des_centro_estudios, "); 
		sql.append("personal_academica.cod_cv_merito as c_merito, des_cv_merito, des_merito, ");
		sql.append("DATEFORMAT( fec_inicio, 'dd/mm/yyyy') as des_fecha  ");
		sql.append("from  ");
		sql.append("web_ocma.personal_academica, web_ocma.tabla_cv_merito ");
		sql.append("where ");
		sql.append("cod_personal= :cod_personal and COD_ACADEMICA= :cod_academia and ");
		sql.append("personal_academica.cod_cv_merito = tabla_cv_merito.cod_cv_merito ");
		sql.append("order by fec_inicio desc, des_cv_merito asc");  
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		query.setString("cod_academia", cod_academia);
		List<DjMeritoModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjMeritoModel.class)).list();
		return datalist;
		
	}
	
}
