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
import pe.gob.ocma.entities.oc_ocma.Socmovimiento;


/**
 * FIXME DESCRIBIR
 * @author Freddy Rodas Ulloa
 * 18/02/2014 15:22:11
 */
public interface SocMovimientoService {
	
	public abstract List<Socmovimiento> listarMovimiento(Integer num_sc);
	public abstract List<Socmovimiento> listarMovimientoUlt();
	public abstract List<Socmovimiento> listarAll();
	public abstract void GrabarMovimiento(Socmovimiento socmovimiento);
	public abstract void EditarMovimiento(Socmovimiento socmovimiento);
	public abstract void EliminarMovimiento(Socmovimiento socmovimiento);
	
	
	public abstract WrappedData<Socmovimiento> listarMovSociedad(Map<String, String> colFilters, 
			Map<String, Serializable> extFilters, SortCriteria sort, int first, int pageSize);
	
}
