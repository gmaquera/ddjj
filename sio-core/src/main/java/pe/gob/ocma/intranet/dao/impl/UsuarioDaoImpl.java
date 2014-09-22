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
package pe.gob.ocma.intranet.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.entities.web_ocma.Usuario;
import pe.gob.ocma.intranet.dao.UsuarioDao;
import pe.gob.ocma.intranet.dto.LoginModel;

/**
 * FIXME DESCRIBIR
 * @author Gino Maquera Coyla
 * 19/9/2014 11:49:30
 */

@Repository("usuarioWebDao")
public class UsuarioDaoImpl extends BaseHibernateDaoImpl<Usuario, String> implements UsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Usuario buscarUsuario(String codUsuario) {
		return super.searchUnique(Usuario.class, "codUsuario", codUsuario);
	}

	@Override
	public LoginModel obtenerUsuario(String codUsuario) {
		StringBuilder sql = new StringBuilder(" SELECT  web_personal.cod_personal, "); 
		sql.append(" nombre=des_ap_paterno || ' ' || des_ap_materno || ', ' || des_nombre, "); 
		sql.append(" usuario.cod_usuario, usuario.cod_distritojudicial, usuario.fla_cambio_contrasenia_inicio, usuario.des_contrasena_limpia "); 
		sql.append(" FROM web_ocma.web_personal, web_ocma.usuario, web_ocma.usuarioxgrupo, web_ocma.grupo_modulo ");
		sql.append(" WHERE usuario.cod_usuario = :codUsuario AND ");					   
		sql.append(" web_personal.cod_personal = usuario.cod_personal AND ");
		sql.append(" usuario.fla_estado=1 AND ");
		sql.append(" usuario.cod_usuario = usuarioxgrupo.cod_usuario AND ");
		sql.append(" usuarioxgrupo.cod_grupo = grupo_modulo.cod_grupo AND ");
		sql.append(" grupo_modulo.cod_modulo=1 ");
	    Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("codUsuario", codUsuario);
		LoginModel result = (LoginModel)query.setResultTransformer(Transformers.aliasToBean(LoginModel.class)).uniqueResult();		
		return result;
	}

}
