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
package pe.gob.ocma.auditoria.dao;

import java.util.Date;

import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasTablaModel;
import pe.gob.ocma.auditoria.dto.AuditoriaModel;
import pe.gob.ocma.common.dao.util.Auditoria;
import pe.gob.ocma.common.wrapper.WrappedData;

/**
 * Interface para menejar el acceso a datos a la tabla de auditoría
 * @author César Altamirano Menor
 * 26/09/2013 15:13:12
 */
public interface AuditoriaDao {
	
	/**
	 * Guarda a que tabla y por quien se consulto, además guarda el query de consulta.
	 * @param nomTabAuditada El nombre de la tabla auditada.
	 * @param parametros Los parametros de la consulta, acepta null.
	 * @param queryConsulta El query de la consulta en HQL.
	 */
	public abstract void guardarConsulta(String nomTabAuditada, String parametros, String queryConsulta);
	
	/**
	 * Guarda los datos de creación en cualquier tabla.
	 * @param nomTabAuditada El nombre de la tabla auditada.
	 * @param au El objeto que tiene los campos y los valores guardados.
	 * @param nomPk El nombre de la columna que es clave primaria de la tabla auditada.
	 * @param valorPk El valor correspondiente a la columna que es clave primaria de la tabla auditada.
	 */
	public abstract void guardarCreacion(String nomTabAuditada, Auditoria au, String nomPk, String valorPk);
	
	/**
	 * Guarda la modificación de un registro en cualquier tabla.
	 * @param nomTabAuditada El nombre de la tabla auditada.
	 * @param au El objeto que tiene los campos y los valores actualizados.
	 * @param nomPk El nombre de la columna que es clave primaria de la tabla auditada.
	 * @param valorPk El valor correspondiente a la columna que es clave primaria de la tabla auditada.
	 */
	public abstract void guardarActualizacion(String nomTabAuditada, Auditoria au, String nomPk, String valorPk);
	
	/**
	 * Guarda la eliminación de un registro en cualquier tabla.
	 * @param nomTabAuditada El nombre de la tabla auditada.
	 * @param nomPk El nombre de la columna que es clave primaria de la tabla auditada.
	 * @param valorPk El valor correspondiente a la columna que es clave primaria de la tabla auditada.
	 */
	public abstract void guardarEliminacion(String nomTabAuditada, String nomPk, String valorPk);
	
	/**
	 * Devuelve una lista con los datos de auditoría entre un rango de fechas.
	 * @param fechaInicio La fecha inicial.
	 * @param fechaFin La fecha final.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros por página.
	 * @return El wrapper con una lista y la cantidad de registros.
	 */
	public abstract WrappedData<AuditoriaFechasModel> buscarAuditoria(Date fechaInicio, Date fechaFin, int first, int pageSize);
	
	/**
	 * Devuelve un registro que sirve para obtener los campos de cabecera de la tabla auditada.
	 * @param codTabla La clave primaria de la tabla.
	 * @return Un objeto con los datos buscados.
	 */
	public abstract AuditoriaModel buscarCamposCabecera(short codTabla);
	
	/**
	 * Devuelve una lista con datos auditados a una tabla específica en un rango de fechas.
	 * @param codTabla La clave primaria de la tabla auditada.
	 * @param fechaInicio La fecha de inicio del rango.
	 * @param fechaFin La fecha final del rango.
	 * @param numColumnas El número total de columnas a mostrar.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros en una página.
	 * @return El wrapper con la lista buscada.
	 */
	public abstract WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(short codTabla, Date fechaInicio, Date fechaFin, 
			int numColumnas, int first, int pageSize);
	
	/**
	 * Devuelve una lista con los datos de auditoría entre un rango de fechas.
	 * @param codUsuario La clave primaria del usuario.
	 * @param fechaInicio La fecha inicial.
	 * @param fechaFin La fecha final.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros por página.
	 * @return El wrapper con una lista y la cantidad de registros.
	 */
	public abstract WrappedData<AuditoriaFechasModel> buscarAuditoria(String codUsuario, Date fechaInicio, Date fechaFin, int first, int pageSize);
	
	/**
	 * Devuelve una lista con datos auditados a una tabla específica en un rango de fechas.
	 * @param codUsuario La clave primaria del usuario.
	 * @param codTabla La clave primaria de la tabla auditada.
	 * @param fechaInicio La fecha de inicio del rango.
	 * @param fechaFin La fecha final del rango.
	 * @param numColumnas El número total de columnas a mostrar.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros en una página.
	 * @return El wrapper con la lista buscada.
	 */
	public abstract WrappedData<AuditoriaFechasTablaModel> buscarAuditoria(String codUsuario, short codTabla, Date fechaInicio, Date fechaFin, 
			int numColumnas, int first, int pageSize);
}
