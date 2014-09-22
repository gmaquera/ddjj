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
package pe.gob.ocma.auditoria.service;

import java.util.Date;
import java.util.List;

import pe.gob.ocma.auditoria.dto.AuditoriaFechasModel;
import pe.gob.ocma.auditoria.dto.AuditoriaFechasTablaModel;
import pe.gob.ocma.common.wrapper.WrappedData;

/**
 * Interfaces para menejar la lógica de negocio de las opciones de auditoría.
 * @author César Altamirano Menor
 * 10/10/2013 16:03:11
 */
public interface AuditoriaService {

	/**
	 * Devuelve una lista con los datos de auditoría entre un rango de fechas.
	 * @param fechaInicio La fecha inicial.
	 * @param fechaFin La fecha final.
	 * @param first El registro inicial.
	 * @param pageSize La cantidad de registros por página.
	 * @return El graper con una lista y la cantidad de registros.
	 */
	public abstract WrappedData<AuditoriaFechasModel> buscarAuditoria(Date fechaInicio, Date fechaFin, int first, int pageSize);
	
	/**
	 * Devuelve una lista con nombres de algunos campos de la cabecera a mostrar en la tabla de auditoría.
	 * @param codTabla La clave primaria de la tabla.
	 * @return La lista de campos.
	 */
	public abstract List<String> buscarCamposCabecera(short codTabla);
	
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
