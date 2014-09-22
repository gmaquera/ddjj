/**
 * Copyright © 2013 OCMA.
 *
 * Este es el sistema para la gestión integrada de los procesos de
 * la OCMA.
 *
 * Este sistema es de propiedad de la Oficina de Control de la 
 * Magistratura - OCMA, No puede ser distribuido ni modificado
 * sin autorización.
 *
 * Desarrollado en Mayo del 2013, por la Unidad de Sistemas de la OCMA.
 * Ing. Orlando Peña Mora - Responsable de la Unidad de Sistemas
 *
 */
package pe.gob.ocma.sociedadcivil.service;

import java.util.List;

import pe.gob.ocma.entities.oc_ocma.Socprocede;

/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 27/02/2014 10:59:38
 */
public interface ProcedeSocMasterService {
	public abstract List<Socprocede> listarProcede();
}
