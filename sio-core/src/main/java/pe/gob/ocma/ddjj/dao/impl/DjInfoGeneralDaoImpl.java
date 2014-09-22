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
import pe.gob.ocma.ddjj.dao.DjInfoGeneralDao;
import pe.gob.ocma.ddjj.dto.magistrado.DjExpedientesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoGeneralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjInfoLaboralModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjSancionesModel;
import pe.gob.ocma.ddjj.dto.magistrado.DjTrayMagistradoModel;
import pe.gob.ocma.entities.oc_ocma.DjMaster;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 10/09/2014 15:20:13
 */

@Repository("djInfoGeneralDao")
public class DjInfoGeneralDaoImpl  extends BaseHibernateDaoImpl<DjMaster,Integer> implements DjInfoGeneralDao, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoGeneralModel> lisInfoGeneral(String cod_personal) {
			
			Query query = this.getSession().createSQLQuery(
				"exec WEB_OCMA.sp_web_info_laboral :cod_personal")				
				.setParameter("cod_personal",cod_personal );
			//query.setString("des_ejercicio", des_ejercicio);			 
			List<DjInfoGeneralModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoGeneralModel.class)).list();
			return datalist;
			
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjInfoLaboralModel> lisInfoLaboral(String cod_personal) {

	
			StringBuilder sql = new StringBuilder("select  detalle_area,des_funcio,dateformat(fec_inicio_cargo,'DD-MM-YYYY') as fec_inicio_cargo,des_direccion,num_telefono,edad ");
			sql.append("from web_ocma.view_personal where cod_personal = :cod_personal "); 
	 	    Query query = this.getSession().createSQLQuery(sql.toString());
			query.setString("cod_personal", cod_personal);
			List<DjInfoLaboralModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjInfoLaboralModel.class)).list();
			return datalist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjTrayMagistradoModel> lisTrayectoriaMagis(String cod_personal) {

		StringBuilder sql = new StringBuilder("select num_resolucion,fecha_grilla,des_cargo,des_condicionlaboral,des_distritojudicial from web_ocma.view_personal_historico "); 
		sql.append("where cod_personal = :cod_personal ");
		sql.append("order by fecha_asignacion desc ");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("cod_personal", cod_personal);
		List<DjTrayMagistradoModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjTrayMagistradoModel.class)).list();
		return datalist;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DjExpedientesModel> lisExpedienteMagis(int cod_personal,int cod_inicio, int cod_fin) {
		
		Query query = this.getSession().createSQLQuery(
				"exec web_ocma.sp_web_expedientes :cod_personal, :cod_inicio, :cod_fin")				
				.setParameter("cod_personal",cod_personal )
				.setParameter("cod_inicio",cod_inicio )	
				.setParameter("cod_fin",cod_fin );
			//	query.setString("des_ejercicio", des_ejercicio);			 
			List<DjExpedientesModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjExpedientesModel.class)).list();
			return datalist;
		
	}

	@Override
	public List<DjSancionesModel> lisSancionesMagis(int distrito_origen,int cod_personal, int cod_inicio, int cod_fin) {
		
		Query query = this.getSession().createSQLQuery(
				"EXEC web_ocma.sp_web_sanciones :distrito_origen, :cod_personal , :cod_inicio, :cod_fin")
				.setParameter("distrito_origen",distrito_origen )
				.setParameter("cod_personal",cod_personal )
				.setParameter("cod_inicio",cod_inicio )	
				.setParameter("cod_fin",cod_fin );
			//	query.setString("des_ejercicio", des_ejercicio);			 
			@SuppressWarnings("unchecked")
			List<DjSancionesModel> datalist = query.setResultTransformer(Transformers.aliasToBean(DjSancionesModel.class)).list();
			return datalist;
			
	}

}
