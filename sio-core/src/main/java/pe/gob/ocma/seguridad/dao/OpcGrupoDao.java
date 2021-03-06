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

import java.util.Collection;
import java.util.List;

import pe.gob.ocma.common.dao.BaseHibernateDao;
import pe.gob.ocma.entities.seguridad.Setopcgrupo;
import pe.gob.ocma.entities.seguridad.SetopcgrupoId;
import pe.gob.ocma.seguridad.dto.MenuModel;

/**
 * Interface para la gestión de acceso al menú y opciones del sistema según los grupos o roles del usuario.
 * @author César Altamirano Menor
 * 05/06/2013 16:11:15
 */
public interface OpcGrupoDao extends BaseHibernateDao<Setopcgrupo, SetopcgrupoId>{
	
	/**
	 * Devuelve una lista con los registros que son sólo padres
	 * para empezar la cdena de acceso en el menu de la aplicación.
	 * @param tipo El tipo de menú (Arbol, Horizontal, Boton).
	 * @return La lista con las opciones del menú.
	 */
	public abstract List<MenuModel> buscarMenuSoloPadres(char tipo);
	
	/**
	 * Devuelve una lista con los registros que son hijos y/o padres de la cadena de acceso.
	 * @param tipo El tipo de menú (Vertical, Horizontal, Boton).
	 * @return La lista con opciones de menú.
	 */
	public abstract List<MenuModel> buscarMenuHijosPadres(char tipo);
	
	/**
     * Devuelve una lista con los registros que son sólo padres
     * para empezar la cadena de acceso en el menu de la aplicación.
     * @param codUsuario El usuario que desea obtener su cadena de acceso.
     * @param tipo El tipo de menú (Arbol, Horizontal, Boton).
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuSoloPadres(String codUsuario, char tipo);

    /**
     * Devuelve una lista con los registros que son hijos y/o padres de la cadena de acceso.
     * @param codUsuario El usuario que desea obtener su cadena de acceso.
     * @param tipo El tipo de menú (Vertical, Horizontal, Boton).
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuHijosPadres(String codUsuario, char tipo);
	
	/**
     * Devuelve una lista con los registros que son sólo padres para el 
     * grupo principal de un distrio judicial.
     * para empezar la cadena de acceso en el menu de la aplicación.
     * @param codDisJudicial La clave primaria del distrito judicial.
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuSoloPadres(int codDisJudicial);
	
	/**
     * Devuelve una lista con los registros que son hijos y/o padres de la cadena de acceso para el
     * grupo principal de un distrito judicial.
     * @param codDisJudicial La clave primaria del distrito judicial.
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuHijosPadres(int codDisJudicial);
	
	/**
     * Devuelve una lista con los registros que son sólo padres.
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuSoloPadres();
	
	/**
     * Devuelve una lista con los registros que son hijos y/o padres de la cadena de acceso.
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuHijosPadres();
	
	/**
     * Devuelve una lista con los registros que son hijos en la cadena de
     * acceso, segun el padre.
     * @param opcPadre El identificador padre de los hijos a recuperar.
     * @return La lista con opciones de menú.
     */
	public abstract List<MenuModel> buscarMenuHijosPadre(Integer opcPadre);
	
	/**
	 * Busca las opciones que tiene un grupo o rol.
	 * @param codGrupo La clave primaria del grupo.
	 * @return Las lista de opciones.
	 */
	public abstract List<Setopcgrupo> buscarOpcGrupo(int codGrupo);
	
	/**
	 * Devuelve una lista con las opciones de un grupo que deben ser eliminadas.
	 * @param codGrupo La clave primaria del grupo o rol.
	 * @param codOpciones La lista con códigos de opciones que no deben ser eliminados.
	 * @return La lista de opciones.
	 */
	public abstract List<Setopcgrupo> buscarOpcionesPorEliminar(int codGrupo, Collection<Integer> codOpciones);
}
