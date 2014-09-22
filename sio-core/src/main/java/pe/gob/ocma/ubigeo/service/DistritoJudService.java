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
package pe.gob.ocma.ubigeo.service;

import java.util.List;

import pe.gob.ocma.entities.ubigeojud.Ujtdisjud;

/**
 * Interface para manejar la lógica de negocio de los distritos judiciales.
 * @author Gino Maquera Coyla
 * 07/11/2013 11:22:24
 */
public interface DistritoJudService {
	/**
	 * Devuelve todos los distritos judiciales del sistema.
	 * @return La lista de distritos.
	 */
	public abstract List<Ujtdisjud> listarDistritoJud();
}
