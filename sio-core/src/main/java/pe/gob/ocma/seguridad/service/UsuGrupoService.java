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
package pe.gob.ocma.seguridad.service;

import java.util.List;

import pe.gob.ocma.entities.seguridad.Setusugrupo;

/**
 * Interface para manejar la lógica de negocio de los grupos de un usuario.
 * @author César Altamirano Menor
 * 26/06/2013 09:56:49
 */
public interface UsuGrupoService {

	/**
	 * Devuelve una lista con los códigos de los grupos o roles de un usuario. 
	 * @param codUsuario La clave primaria del usuario.
	 * @return La lista con los códigos.
	 */
	public abstract List<String> buscarCodGruposUsuario(String codUsuario);
	
	/**
	 * Devuelve la lista de usuarios de un grupo.
	 * @param codGrupo La clave primaria del grupo.
	 * @return La lista buscada.
	 */
	public abstract List<Setusugrupo> buscarUsuariosGrupo(int codGrupo);
	
	/**
	 * Guarda en base de datos un usuario en un grupo.
	 * @param usuGrupo El objeto usuario grupo.
	 */
	public abstract void guardarUsuGrupo(Setusugrupo usuGrupo);
	
	/**
	 * Desactiva un registro.
	 * @param usuGrupo El objeto o registro a desactivar.
	 */
	public abstract void desactivarUsuGrupo(Setusugrupo usuGrupo);
}
