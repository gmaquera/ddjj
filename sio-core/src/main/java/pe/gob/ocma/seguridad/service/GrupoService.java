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

import pe.gob.ocma.entities.seguridad.Setgrupo;

/**
 * Interfaz de negocio para manejar los grupos de usuarios.
 * @author César Altamirano Menor
 * 13/06/2013 15:50:43
 */
public interface GrupoService {
	
	/**
	 * Devuelve un grupo según su clave primaria.
	 * @param codGrupo La clave primaria del grupo.
	 * @return El grupo solicitado.
	 */
	public abstract Setgrupo buscarGrupo(int codGrupo); 
	
	/**
	 * Devuelve una lista con todos los grupos o roles de usuario.
	 * @return La lista con los grupos encontrados.
	 */
	public abstract List<Setgrupo> listarGrupos();

	/**
	 * Devuelve una lista con los grupos o roles de usuario según su estado.
	 * @param habilitado El estado del grupo.
	 * @return La lista con los grupos encontrados.
	 */
	public abstract List<Setgrupo> listarGrupos(boolean habilitado);
	
	/**
	 * Guarda un  grupo y devuelve el objeto guardado.
	 * @param grupo El nuevo grupo a guardar.
	 * @return El grupo guardado.
	 */
	public abstract Setgrupo guardarGrupo(Setgrupo grupo);
	
	/**
	 * Actualiza el grupo en la base de datos.
	 * @param grupo El grupo a actualizar.
	 */
	public abstract void actualizarGrupo(Setgrupo grupo);
	
	/**
	 * Elimina un grupo de la base de datos.
	 * @param grupo El grupo a eliminar.
	 */
	public abstract void eliminarGrupo(Setgrupo grupo);
}