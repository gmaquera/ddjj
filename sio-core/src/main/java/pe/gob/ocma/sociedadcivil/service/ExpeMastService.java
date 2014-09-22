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

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import pe.gob.ocma.common.dao.util.SortCriteria;
import pe.gob.ocma.common.wrapper.WrappedData;
import pe.gob.ocma.entities.oc_ocma.ExpeMast;
import pe.gob.ocma.entities.oc_ocma.ExpeMastId;
import pe.gob.ocma.entities.oc_ocma.ExpeQuej;


/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 25/02/2014 08:50:33
 */
public interface ExpeMastService {
	
	public abstract ExpeMast buscarExpeMast(ExpeMastId numExpedi);
	public abstract void BuscarExpediente(ExpeMast expemast);
	public abstract List<ExpeMast> BuscarExpeSoc(int intexp, int distriOrig);
	
	public abstract WrappedData<ExpeMast> listaExpeComprendidos(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
			


}
