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
package pe.gob.ocma.seguridad.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.exception.OcmaException;
import pe.gob.ocma.common.dao.impl.BaseHibernateDaoImpl;
import pe.gob.ocma.seguridad.dao.UsuarioDao;

/**
 * Clase que permite la gestion de Usuarios en la base de datos.
 * @author César Altamirano Menor
 * 14/05/2013 15:26:16
 */
@Repository("usuarioDao")
public class UsuarioDaoImpl extends BaseHibernateDaoImpl<Setusuario, String> implements UsuarioDao, Serializable{

	private static final long serialVersionUID = 2321467658216878199L;

	@Override
	public Setusuario buscarUsuario(String nomUsuario){
		return super.searchUnique(Setusuario.class, "codUsuario", nomUsuario);
	}
	
	@Override
	public int guardarTemaUsuario(String codUsuario, String codTema, String terminal) {
		StringBuilder hql = new StringBuilder("update Setusuario u set u.settema.codTema = :codTema ");
		hql.append("where u.codUsuario = :codUsuario ");
		Query query = super.getSession().createQuery(hql.toString());
		query.setParameter("codTema", codTema);
		query.setParameter("codUsuario", codUsuario);
		return query.executeUpdate();
	}

	@Override
	public String obtenerContraseMD5(String contrase) {
		StringBuilder sql = new StringBuilder("SELECT HASH('");
		sql.append(contrase);
		sql.append("', 'MD5')");
		Query query = super.getSession().createSQLQuery(sql.toString());
		return (String)query.uniqueResult();
	}

	@Override
	public void actualizarDatosUsuario(Setusuario usuario) {
		StringBuilder hql = new StringBuilder("update Setusuario set ");
		if(usuario.getContrasenia() != null && !usuario.getContrasenia().isEmpty()){
			hql.append("contrasenia = '");
			hql.append(this.obtenerContraseMD5(usuario.getContrasenia())).append("', ");
		}
		hql.append("tipo = :tipo, ");
		hql.append("habilitado = :habilitado ");
		hql.append("where codUsuario = :codUsuario ");
		Query query = super.getSession().createQuery(hql.toString());
		query.setString("tipo", usuario.getTipo());
		query.setBoolean("habilitado", usuario.isHabilitado());
		query.setString("codUsuario", usuario.getCodUsuario());
		query.executeUpdate();
	}

	@Override
	public void cambiarContrasenia(String codUsuario, String contraseActual, String contraseNueva) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE SEGURIDAD.SETUSUARIO SET contrasenia=HASH('");
		sql.append(contraseNueva);
		sql.append("', 'MD5') ");
		sql.append("WHERE codUsuario='");
		sql.append(codUsuario);
		sql.append("' AND contrasenia=HASH('");
		sql.append(contraseActual);
		sql.append("', 'MD5')");
		Query query = super.getSession().createSQLQuery(sql.toString());
		int update = query.executeUpdate();
		if(update == 0){
			throw new OcmaException("La contraseña actual es incorrecta.");
		}
	}
}