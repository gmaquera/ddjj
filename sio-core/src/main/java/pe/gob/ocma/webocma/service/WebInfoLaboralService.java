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
package pe.gob.ocma.webocma.service;

import java.util.List;

import pe.gob.ocma.entities.web_ocma.Afp;
import pe.gob.ocma.entities.web_ocma.TablaRegimenPension;

/**
 * FIXME DESCRIBIR
 * @author Brian Berrocal Chavez
 * 7/10/2014 8:29:53
 */
public interface WebInfoLaboralService {


	public abstract List<Afp> listaTipoAFP();
	
	public abstract List<TablaRegimenPension> listaTipoRegimenPension();
}
