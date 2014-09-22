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
package pe.gob.ocma.organosjur.service;

import java.util.List;

import pe.gob.ocma.entities.organosjurisd.Ojtdependen;

/**
 * DECRIBIR TODO
 * @author Gino Maquera Coyla
 * 08/11/2013 10:33:01
 */
public interface DependenciaService {
	public abstract List<Ojtdependen> listarDependencias();
	public abstract List<Ojtdependen> buscarDependencia(Short codDisJud, Short codOrgJurisd, Short codEspeciali);

}
