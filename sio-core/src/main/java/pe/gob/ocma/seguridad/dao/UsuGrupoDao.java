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
package pe.gob.ocma.seguridad.dao;

import java.util.List;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.seguridad.Setusugrupo;
import pe.gob.ocma.entities.seguridad.SetusugrupoId;

/**
 * Intefaces para manejar los grupos de un usuario desde base de datos.
 * @author César Altamirano Menor
 * 24/06/2013 17:24:13
 */
public interface UsuGrupoDao extends BaseHibernateDao<Setusugrupo, SetusugrupoId> {
	
	/**
	 * Devuelve una lista con los códigos de los grupos o roles de un usuario. 
	 * @param codUsuario La clave primaria del usuario.
	 * @return La lista con los códigos.
	 */
	public abstract List<String> buscarCodGruposUsuario(String codUsuario);
	
	/**
	 * Devuelve una lista con los grupos de un usuario que estan habilitados y no han sido
	 * seleccionados, por lo que se deben deshabilitar.
	 * @param codUsuario La clave primaria del usuario.
	 * @param seleccionados Los grupos seleccionados.
	 * @return La lista de grupos por deshabilitar.
	 */
	public List<Setusugrupo> buscarHabilitadosPorDeshabilitar(String codUsuario, List<String> seleccionados);
	
	/**
	 * Devuelve la lista de usuarios de un grupo.
	 * @param codGrupo La clave primaria del grupo.
	 * @return La lista buscada.
	 */
	public abstract List<Setusugrupo> buscarUsuariosGrupo(int codGrupo);
}
