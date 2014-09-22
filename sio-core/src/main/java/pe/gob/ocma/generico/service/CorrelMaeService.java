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
package pe.gob.ocma.generico.service;

import java.util.List;

import pe.gob.ocma.entities.generico.Getcorrelmae;

/**
 * Interface para el manejo de correlativos de las tablas maestras desde la base de datos.
 * @author César Altamirano Menor
 * 14/06/2013 16:17:44
 */
public interface CorrelMaeService {

	/**
	 * Devuelve una lista con todos los correltativos de las tablas maestras.
	 * @return La lista de correlativos.
	 */
	public List<Getcorrelmae> listarCorrelativosMaestras();
	
	/**
	 * Guarda un nuevo correlativo para menejar las secuencia de las claves primarias de una tabla maestra.
	 * @param correlativoMae El objeto a guardar.
	 * @return El objeto guardado.
	 */
	public Getcorrelmae guardarCorrelativoMaestra(Getcorrelmae correlativoMae);
	
	/**
	 * Actualiza el objeto correlativo maestra.
	 * @param correltaivoMae El objeto a actualizar.
	 */
	public void actualizarCorrelativoMeastra(Getcorrelmae correltaivoMae);
	
	/**
	 * Elimina un objeto correspondiente a un registro de la tabla de correlativos de maestras.
	 * @param correlativoMae El objeto a eliminar.
	 */
	public void eliminarCorrelativoMaestra(Getcorrelmae correlativoMae);
}
