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
package pe.gob.ocma.seguridad.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.persona.Petpernatu;
import pe.gob.ocma.entities.persona.Petpersona;
import pe.gob.ocma.entities.seguridad.Setusuario;

/**
 * Interfaces para la gestión de usuarios.
 * @author César Altamirano Menor
 * 15/05/2013 08:34:15
 */
public interface UsuarioService {

	/**
	 * Devuelve un usuario según su nombre de usuario.
	 * @param nomUsuario El nombre de usuario (Clave Primaria).
	 * @return El usuario buscado.
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
	 * Devuelve una lista de usuarios según criterios de filtros y paginación.
	 * @param colFilters Filtros de columnas, acepta null.
	 * @param extFilters Filtros externos para busquedas, acepta null.
	 * @param sort El o los criterios de ordenación.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros.
	 * @return
	 */
	public abstract WrappedData<Setusuario> buscarUsuariosDisJudicial(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
	
	/**
	 * Devuelve un usuario segun se codigo de personal.
	 * @param codPersonal La clave primaria de web personal.
	 * @return El usuario correspondiente.
	 */
	public abstract Setusuario buscarUsuarioPorCodPersonal(int codPersonal);
	
	/**
	 * Guarda un usuario en la base de datos.
	 * @param usuario El usuario a guardar.
	 * @param perNatural Los datos del usuario como persona natural.
	 * @param persona La persona (datos generales).
	 * @param generoPersona El género de la persona.
	 * @param grupos Los grupos o roles asignados a un usuario. Puede tener cero o más.
	 * @param actualizarPersona Indicador para saber si se debe actualizar el tipo de documento de la persona.
	 * @return El usuario guardado.
	 */
	public abstract Setusuario guardarUsuario(Setusuario usuario, Petpernatu perNatural, Petpersona persona, 
			String generoPersona, List<String> grupos, boolean actualizarPersona);
	
	/**
	 * Actualiza algunos cambios en la tabla usuario.
	 * @param usuario El objeto persistente con los datos del usuario a cambiar.
	 * @param grupos La lista con los códigos de grupos o roles del usuario.
	 */
	public abstract void actualizarDatosUsuario(Setusuario usuario, List<String> grupos);
	
	/**
	 * 
	 * @param codUsuario La clave primaria del usuario.
	 * @param contraseActual La contraseña actual.
	 * @param contraseNueva La nueva contraseña.
	 */
	public abstract void cambiarContrasenia(String codUsuario, String contraseActual, String contraseNueva);
	
	public abstract Setusuario buscarUsuarioCod(String codUsuario);
}
