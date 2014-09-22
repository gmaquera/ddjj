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
package pe.gob.ocma.seguridad.dao;

import pe.gob.ocma.entities.seguridad.Setusuario;
import pe.gob.ocma.common.dao.BaseHibernateDao;

/**
 * Interfaces para la gestión de usuarios del sistema.
 * @author César Altamirano Menor
 * 14/05/2013 15:21:32
 */
public interface UsuarioDao extends BaseHibernateDao<Setusuario, String>{
	
	/**
	 * Devuelve un usuario por su nombre de usuario.
	 * @param nomUsuario El nombre de usuario.
	 * @return El usuario.
	 */
	public abstract Setusuario buscarUsuario(String nomUsuario);
	
	/**
	 * Guarda el tema seleccionado por el usuario.
	 * @param codUsuario La clave primaria del usuario.
	 * @param codTema La clave primaria del Tema.
	 * @param terminal El terminal desde donde se hace la modificación.
	 * @return La cantidad de registros actualizados.
	 */
	public abstract int guardarTemaUsuario(String codUsuario, String codTema, String terminal);
	
	/**
	 * Devuelve una contraseña encriptada con el algoritmo MD5.
	 * @param contrase La contraseña.
	 * @return La contraseña encriptada.
	 */
	public abstract String obtenerContraseMD5(String contrase);
	
	/**
	 * Actualiza estado y super usuario y de forma opcional contraseña de un usuario.
	 * @param usuario El objeto con lo datos a actualizar.
	 */
	public abstract void actualizarDatosUsuario(Setusuario usuario);
	
	/**
	 * 
	 * @param codUsuario La clave primaria del usuario.
	 * @param contraseActual La contraseña actual.
	 * @param contraseNueva La nueva contraseña.
	 */
	public abstract void cambiarContrasenia(String codUsuario, String contraseActual, String contraseNueva);
}
